/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib.data;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by wangkang on 11/15/2016
 */
public class DataMapper {

    static public DataMapper forJson() {
        return new DataMapper(new DataParserJson()).setVerbose(false);
    }

    static public DataMapper forXml() {
        return new DataMapper(new DataParserXml()).setVerbose(false);
    }

    static public void setMaxRecursiveFiles(int maxRecursiveFiles) {
        DataMapper.maxRecursiveFiles = Math.max(1, maxRecursiveFiles);
    }

    static public void mapFiles(Object root, String dir, final String suffix) throws Exception {
        File file = new File(dir);
        if (!file.exists()) {
            throw new IOException("Path doesn't exist:\n" + file.getAbsolutePath());
        }
        FilenameFilter filter = new FilenameFilter() {
            //@Override
            public boolean accept(File dir, String name) {
                File f = new File(dir, name);
                return f.isDirectory()
                    && !f.getName().startsWith(".")
                    && !f.getName().startsWith("_")
                    || name.endsWith(suffix);
            }
        };
        List<File> files = new ArrayList<File>();
        recursiveReadFile(files, file, filter);
        for (File f : files) {
            String path = f.getAbsolutePath();
            if (suffix.endsWith("xml")) {
                forXml().setPath(path).map(root, new FileInputStream(f));
                log("Read <- " + path);
            } else if (suffix.endsWith("json")) {
                forJson().setPath(path).map(root, new FileInputStream(f));
                log("Read <- " + path);
            }
        }
    }

    static private void recursiveReadFile(List<File> all, File file, FilenameFilter filter) {
        if (all.size() > maxRecursiveFiles) {
            return;
        }
        if (file.isFile()) {
            all.add(file);
        } else if (file.isDirectory()) {
            File[] files = file.listFiles(filter);
            assert files != null;
            for (File file1 : files) {
                recursiveReadFile(all, file1, filter);
            }
        }
    }


    private final DataParser parser;

    public DataMapper(DataParser parser) {
        this.parser = parser;
    }

    public <T> T map(T dest, String from) throws Exception {
        if (from == null || from.length() <= 0) {
            return dest;
        }
        byte[] bytes = from.getBytes(UTF8);
        InputStream i = new ByteArrayInputStream(bytes);
        return map(dest, i);
    }

    public <T> T map(T dest, InputStream from) throws Exception {
        if (null == from) {
            return dest;
        }
        if (null == dest) {
            return null;
        }
        DataNode node = parser.parse(from);
        assert node != null;
        parse(dest, node);
        return dest;
    }

    private void parse(Object o, DataNode n) throws Exception {
        parse(o, n, o.getClass().getName(), o.getClass().getSimpleName());
    }

    @SuppressWarnings("unchecked")
    private void parse(Object o, DataNode n, String rule, String debug) throws Exception {
        if (o == null) {
            onError(debug + " is null.", n);
        }
        Class<?> ClsO = loadGenericClass(rule);
        if (LinkedList.class == ClsO) {
            parseVec((LinkedList<Object>) o, n, rule, debug);
        } else if (LinkedHashMap.class == ClsO || HashMap.class == ClsO) {
            parseMap((HashMap<Object, Object>) o, n, rule, debug);
        } else {
            parseStruct(o, n, rule, debug);
        }
    }

    private void parseStruct(Object o, DataNode n, String rule, String debug) throws Exception {
        Class<?> ClsO = loadGenericClass(rule);
        if (!o.getClass().getName().equals(ClsO.getName())) {
            onError("Object does not matches this rule: " + rule, n);
        }
        int len = n.numChildren();
        for (int i = 0; i < len; i++) {
            DataNode x = n.getChild(i);
            String key = x.getFieldName();
            if (key == null || key.length() <= 0) {
                continue;
            }
            if (key.equals("schemaLocation")) {
                continue;
            }
            String ruleX = getRule(ClsO, key, n);
            if (ruleX == null) {
                continue;
            }
            Class<?> ClsX = loadGenericClass(ruleX);
            Object v;
            if (isSimple(ClsX)) {
                v = parseGenericChild(x, ClsX, ruleX, debug);
                invokeSetter(v, key, o, x, debug);
            } else {
                v = invokeGetter(key, o, x);
                if (v == null && ClsX != Vector.class) {
                    v = ClsX.newInstance();
                    invokeSetter(v, key, o, x, debug);
                }
                parse(v, x, ruleX, debug + '.' + key);
            }
        }
    }

    private void parseVec(LinkedList<Object> list, DataNode n, String rule, String debug) throws Exception {
        String R = ruleRight(rule);
        if (R == null)
            onError("Unexpected type: " + rule, n);
        Class<?> Cls = loadGenericClass(R);
        int len = n.numChildren();
        for (int i = 0; i < len; i++) {
            final String d = debug + "[" + list.size() + "]";
            DataNode vn = n.getChild(i);
            if (ATTR_MAP_KEY.equals(vn.getFieldName())) {
                continue;
            }
            Object v = parseGenericChild(vn, Cls, R, d);
            list.add(v);
            if (getVerbose()) {
                log(d + ": " + v);
            }
        }
    }

    private void parseMap(Map<Object, Object> map, DataNode n, String rule, String debug) throws Exception {
        String R = ruleRight(rule);
        if (R == null) {
            onError("Unexpected type: " + rule, n);
            return;
        }
        String[] typeNames = R.split(GENERIC_SPLIT);
        if (typeNames.length != 2) {
            onError("Unexpected type: " + rule, n);
        }
        Class<?> ClsK = loadGenericClass(typeNames[0]);
        Class<?> ClsV = loadGenericClass(typeNames[1]);
        final int len = n.numChildren();
        if (shortenMapEntry) {
            for (int i = 0; i < len; i++) {
                DataNode kn = null;
                DataNode vn = n.getChild(i);
                if (vn.numChildren() > 0) {
                    int size = vn.numChildren();
                    for (int j = 0; j < size; j++) {
                        DataNode node = vn.getChild(j);
                        if (ATTR_MAP_KEY.equals(node.getFieldName())) {
                            //k = parseGenericChildAny(node, ClsK, typeNames[0], debug + ".k");
                            kn = node;
                            break;
                        }
                    }
                }
                if (kn == null) {
                    kn = DataNode.createString().setValue(vn.getFieldName());
                }
                Object k = parseGenericChildAny(kn, ClsK, typeNames[0], debug + ".k");
                Object v = parseGenericChildAny(vn, ClsV, typeNames[1], debug + ".v");
                map.put(k, v);
                if (getVerbose()) {
                    log(debug + "." + k + ": " + v);
                }
            }
        } else {
            if ((0x01 & len) != 0) {
                onError("Invalid amount of children: " + len, n);
            }
            for (int i = 0; i < len; i += 2) {
                DataNode kn = n.getChild(i);
                DataNode vn = n.getChild(i + 1);
                Object k = parseGenericChildAny(kn, ClsK, typeNames[0], debug + ".k");
                Object v = parseGenericChildAny(vn, ClsV, typeNames[1], debug + ".v");
                map.put(k, v);
                if (getVerbose()) {
                    log(debug + "." + k + ": " + v);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    private Object parseGenericChild(DataNode cn, Class<?> Cls, String rule, String debug) throws Exception {
        DataNode.TypeId id = cn.getTypeId();
        if (DataNode.TypeId.ANY.equals(id)) {
            return parseGenericChildAny(cn, Cls, rule, debug);
        }
        switch (id) {
            case NULL:
                return null;
            case BOOL:
                return cn.getValue();
            case BIGINT:
                return cn.getValue();
            case STRING:
                return parseGenericChildAny(cn, Cls, rule, debug);
            case INT64:
                return parseGenericChildAny(cn, Cls, rule, debug);
            case DOUBLE:
                return parseGenericChildAny(cn, Cls, rule, debug);
            case OBJECT:
            case ARRAY:
                Object co = Cls.newInstance();
                parse(co, cn, rule, debug);
                return co;
            default:
                return null;
        }
    }

    private Object parseGenericChildAny(DataNode cn, Class<?> Cls, String rule, String debug) throws Exception {
        if (!isSimple(Cls)) {
            Object co = Cls.newInstance();
            parse(co, cn, rule, debug);
            return co;
        }
        Object o = cn.getValue(); /*<n>123</n>*/
        if (o == null) {
            if (cn.numChildren() == 1) {
                o = cn.getChild(0).getValue(); /*<n x="123"/>*/
            } else if (cn.numChildren() > 1) {
                int len = cn.numChildren(); /*<n key="abc" value="123"/>*/
                for (int i = 0; i < len; i++) {
                    DataNode node = cn.getChild(i);
                    String field = node.getFieldName();
                    if ("v".equals(field) || "val".equals(field) || ATTR_VALUE.equals(field)) {
                        o = node.getValue();
                    }
                }
            }
        }
        if (o == null) {
            onError("No value for: " + debug);
        }
        return parseSimpleAny(o, Cls, cn, debug);
    }


    @SuppressWarnings("unchecked")
    private Object parseSimpleAny(Object o, Class<?> Cls, DataNode cn, String debug) throws Exception {
        final int radix = 10;
        if (o instanceof String) {
            String s = (String) o;
            if (s.length() <= 0) {
                return s;
            }
            if (Cls == Byte.class) {
                return Byte.valueOf(s, radix);
            } else if (Cls == Short.class) {
                return Short.valueOf(s, radix);
            } else if (Cls == Integer.class) {
                return Integer.valueOf(s, radix);
            } else if (Cls == Long.class) {
                return Long.valueOf(s, radix);
            } else if (Cls == BigInteger.class) {
                return new BigInteger(s, radix);
            } else if (Cls == Float.class) {
                return Float.valueOf(s);
            } else if (Cls == Double.class) {
                return Double.valueOf(s);
            } else if (Cls == String.class) {
                return s;
            } else if (Cls == Boolean.class) {
                return Boolean.valueOf(s.trim());
            } else if (Cls.isEnum()) {
                char head = s.charAt(0);
                if (head == '-' || Character.isDigit(s.charAt(0))) {
                    Integer i = Integer.valueOf(s, radix);
                    return EnumFromInt(i, (Class<? extends Enum>) Cls);
                } else {
                    return EnumFromString(s, (Class<? extends Enum>) Cls);
                }
            } else {
                onError(debug);
                return null;
            }
        } else if (o instanceof Long) {
            Long v = (Long) o;
            if (Cls == Byte.class) {
                return v.byteValue();
            } else if (Cls == Short.class) {
                return v.shortValue();
            } else if (Cls == Integer.class) {
                return v.intValue();
            } else if (Cls == Long.class) {
                return v;
            } else if (Cls == BigInteger.class) {
                return BigInteger.valueOf(v);
            } else if (Cls == Float.class) {
                return Float.valueOf(v);
            } else if (Cls == Double.class) {
                return Double.valueOf(v);
            } else if (Cls == String.class) {
                return v.toString();
            } else if (Cls == Boolean.class) {
                return v != 0;
            } else if (Cls.isEnum()) {
                return EnumFromInt(v.intValue(), (Class<? extends Enum>) Cls);
            } else {
                onError(debug, cn);
                return null;
            }
        } else if (o instanceof Double) {
            Double v = (Double) o;
            if (Cls == Byte.class) {
                return v.byteValue();
            } else if (Cls == Short.class) {
                return v.shortValue();
            } else if (Cls == Integer.class) {
                return v.intValue();
            } else if (Cls == Long.class) {
                return v.longValue();
            } else if (Cls == BigInteger.class) {
                return BigInteger.valueOf(v.longValue());
            } else if (Cls == Float.class) {
                return v.floatValue();
            } else if (Cls == Double.class) {
                return v;
            } else if (Cls == String.class) {
                return v.toString();
            } else if (Cls == Boolean.class) {
                return v != 0;
            } else if (Cls.isEnum()) {
                return EnumFromInt(v.intValue(), (Class<? extends Enum>) Cls);
            } else {
                onError(debug, cn);
                return null;
            }
        } else {
            onError(debug);
            return null;
        }
    }


////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

    private String path;
    private Boolean verbose = false;
    private Boolean shortenMapEntry = true;

    public String getPath() {
        return path;
    }

    public DataMapper setPath(String path) {
        this.path = path;
        return this;
    }

    private Boolean getVerbose() {
        return verbose;
    }

    public DataMapper setVerbose(Boolean verbose) {
        this.verbose = verbose;
        return this;
    }

    public DataMapper setShortenMapEntry(Boolean shortenMapEntry) {
        this.shortenMapEntry = shortenMapEntry;
        return this;
    }

    private Class<?> loadGenericClass(String rule) throws ClassNotFoundException {
        String name = ruleLeft(rule);
        return Class.forName(name.trim());
    }

    private Object invokeGetter(String key, Object o, Object node) throws Exception {
        HashMap<String, Method> map = getGetters(o.getClass());
        Method method = map.get(key);
        if (method == null) {
            String nameGetter = PREFIX_GETTER + upperHeadChar(key);
            method = map.get(nameGetter);
            if (method == null) {
                onError("No getter named \"" + nameGetter + "\" in " + o.getClass(), node);
                return null;
            }
        }
        return method.invoke(o);
    }

    private void onError(String hint) throws Exception {
        if (path != null && path.length() > 0) {
            hint += "\n" + path;
        }
        throw new Exception("\n" + hint);
    }

    private void onError(String hint, Object n) {
        try {
            onError(hint, n, false);
        } catch (Exception ignored) {
        }
    }

    private void onError(String hint, Object n, boolean silent) throws Exception {
        if (silent) {
            return;
        }
        if (n != null) {
            hint += "\n" + n;
        }
        if (path != null && path.length() > 0) {
            hint += "\n" + path;
        }
        throw new Exception("\n" + hint);
    }

    private String getRule(Class<?> ClsO, String key, DataNode n) throws Exception {
        HashMap<String, Method> map = getGetters(ClsO);
        Method method = map.get(key);
        if (method == null) {
            String nameGetter = PREFIX_GETTER + upperHeadChar(key);
            method = map.get(nameGetter);
            if (method == null) {
                if (!ATTR_MAP_KEY.equals(key)) {
                    onError("No getter named '" + nameGetter + "' in " + ClsO, n);
                }
            }
        }
        if (method == null) {
            return null;
        }
        String rule = method.getGenericReturnType().toString();
        Type genericType = method.getGenericReturnType();
        if (genericType instanceof Class) {
            rule = (((Class) genericType).getName());
        } else if (genericType instanceof ParameterizedType) {
            rule = (((ParameterizedType) genericType)).toString();
        }
        return rule;
    }

    private void invokeSetter(Object value, String key, Object o, DataNode n, String debug) throws Exception {
        HashMap<String, Method> map = getSetters(o.getClass());
        Method method = map.get(key);
        if (method == null) {
            String nameSetter = PREFIX_SETTER + upperHeadChar(key);
            method = map.get(nameSetter);
            if (method == null) {
                return;
            }
        }
        if (getVerbose()) {
            log(debug + "." + key + ": " + value);
        }
        try {
            method.invoke(o, value);
        } catch (Exception e) {
            System.err.println(debug + "." + key);
            System.err.println(n);
            e.printStackTrace();
        }
    }


    private static int maxRecursiveFiles = 8096;
    private static final Charset UTF8 = Charset.forName("utf-8");
    private static final HashMap<Class<?>, HashMap<String, Method>>
        mapClassSetters = new HashMap<Class<?>, HashMap<String, Method>>();
    private static final HashMap<Class<?>, HashMap<String, Method>>
        mapClassGetters = new HashMap<Class<?>, HashMap<String, Method>>();
    private static final HashMap<Class<?>, Method>
        mapEnumGetters = new HashMap<Class<?>, Method>();

    private static final String GENERIC_SPLIT = ",";
    private static final String GENERIC_LEFT = "<";
    private static final String GENERIC_RIGHT = ">";
    private static final String PREFIX_SETTER = "set";
    private static final String PREFIX_GETTER = "get";
    private static final String ATTR_MAP_KEY = "key";
    private static final String ATTR_VALUE = "value";

    private static HashMap<String, Method> getSetters(Class<?> ClsO) {
        HashMap<String, Method> methods = mapClassSetters.get(ClsO);
        if (methods == null) {
            Method[] meths = ClsO.getMethods();
            methods = new HashMap<String, Method>();
            for (Method method : meths) {
                if (method.getName().startsWith(PREFIX_SETTER)) {
                    methods.put(method.getName(), method);
                }
            }
            mapClassSetters.put(ClsO, methods);
        }
        return methods;
    }

    private static HashMap<String, Method> getGetters(Class<?> ClsO) {
        HashMap<String, Method> methods = mapClassGetters.get(ClsO);
        if (methods == null) {
            Method[] meths = ClsO.getMethods();
            methods = new HashMap<String, Method>();
            for (Method method : meths) {
                if (method.getName().startsWith(PREFIX_GETTER)) {
                    methods.put(method.getName(), method);
                }
            }
            mapClassGetters.put(ClsO, methods);
        }
        return methods;
    }

    private static String ruleLeft(String rule) {
        String name = rule;
        int index = rule.indexOf(GENERIC_LEFT);
        if (index >= 0) {
            name = rule.substring(0, index);
        }
        return name;
    }

    private static String ruleRight(String rule) {
        int iBegin = rule.indexOf(GENERIC_LEFT) + 1;
        int iEnd = rule.lastIndexOf(GENERIC_RIGHT);
        if (iBegin > 0 && iEnd > iBegin) {
            return rule.substring(iBegin, iEnd);
        }
        return null;
    }

    private static String upperHeadChar(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }

    private static <T extends Enum> Object EnumFromInt(int v, Class<T> clazz) {
        Method m = mapEnumGetters.get(clazz);
        if (m == null) {
            try {
                m = clazz.getMethod("value");
                mapEnumGetters.put(clazz, m);
            } catch (Exception ignored) {
            }
        }
        for (T t : clazz.getEnumConstants()) {
            if (m != null) {
                Object i = null;
                try {
                    i = m.invoke(t);
                } catch (Exception ignored) {
                }
                if (i != null && i.equals(v)) {
                    return t;
                }
            } else {
                if (t.ordinal() == v) {
                    return t;
                }
            }
        }
        return null;
    }

    private static <T extends Enum> T EnumFromString(String v, Class<T> clazz) {
        for (T t : clazz.getEnumConstants()) {
            if (t.name().equals(v.trim())) {
                return t;
            }
        }
        return null;
    }

    private static boolean isSimple(Class<?> C) {
        return C.isEnum()
            || C == String.class
            || C == Boolean.class
            || C == Float.class
            || C == Double.class
            || C == Byte.class
            || C == Short.class
            || C == Integer.class
            || C == Long.class
            || C == BigInteger.class
            ;
    }

    private static void log(Object txt) {
        System.out.println("| " + txt);
    }

}