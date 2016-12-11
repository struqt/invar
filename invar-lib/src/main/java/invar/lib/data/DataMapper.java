/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib.data;

import invar.lib.InvarEnum;
import invar.lib.InvarRule;

import java.io.*;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by wangkang on 11/14/16
 */
public class DataMapper {

    static public DataMapper forJson() {
        return new DataMapper(new DataParserJson()).setVerbose(false);
    }

    static public DataMapper forXml() {
        return new DataMapper(new DataParserXml()).setVerbose(false);
    }

    static public void mapFiles(Object root, String dir, final String suffix) throws Exception {
        File file = new File(dir);
        if (!file.exists())
            throw new IOException("Path doesn't exist:\n" + file.getAbsolutePath());
        if (aliasBasics == null)
            throw new Exception("InvarReadData.aliasBasics is null");
        if (aliasEnums == null)
            throw new Exception("InvarReadData.aliasEnums is null");
        if (aliasStructs == null)
            throw new Exception("InvarReadData.aliasStructs is null");
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
        if (all.size() > 1024) {
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

    static final public Charset UTF8 = Charset.forName("utf-8");
    static public HashMap<String, Class<?>> aliasBasics = null;
    static public HashMap<String, Class<?>> aliasEnums = null;
    static public HashMap<String, Class<?>> aliasStructs = null;

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
                DataNode vn = n.getChild(i);
                Object k = vn.getFieldName();
                if (vn.numChildren() > 0) {
                    int size = vn.numChildren();
                    for (int j = 0; j < size; j++) {
                        DataNode node = vn.getChild(j);
                        if (ATTR_MAP_KEY.equals(node.getFieldName())) {
                            k = parseGenericChildAny(node, ClsK, typeNames[0], debug + ".k");
                            break;
                        }
                    }
                }
                if (k == null) {
                    onError("No key for map: ", debug);
                }
                Object v = parseGenericChild(vn, ClsV, typeNames[1], debug + ".v");
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
    private Object parseGenericChildAny(DataNode cn, Class<?> Cls, String rule, String debug) throws Exception {
        final int radix = 10;
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
        if (!(o instanceof String)) {
            onError("Need string value for: " + debug);
            return null;
        }
        String s = (String) o;
        if (s.length() <= 0) {
            return s;
        }
        if (aliasEnums.containsValue(Cls)) {
            char head = s.charAt(0);
            if (head == '-' || Character.isDigit(s.charAt(0))) {
                Integer i = Integer.valueOf(s, radix);
                return EnumFromInt(i, (Class<? extends InvarEnum>) Cls);
            } else {
                return EnumFromString(s, (Class<? extends InvarEnum>) Cls);
            }
        } else {
            if ("int8".equals(rule)) {
                return Byte.valueOf(s, radix);
            } else if ("int16".equals(rule)) {
                return Short.valueOf(s, radix);
            } else if ("int32".equals(rule)) {
                return Integer.valueOf(s, radix);
            } else if ("int64".equals(rule)) {
                return Long.valueOf(s, radix);
            } else if ("uint8".equals(rule)) {
                return Integer.valueOf(s, radix);
            } else if ("uint16".equals(rule)) {
                return Integer.valueOf(s, radix);
            } else if ("uint32".equals(rule)) {
                return Long.valueOf(s, radix);
            } else if ("uint64".equals(rule)) {
                return new BigInteger(s, radix);
            } else if ("float".equals(rule)) {
                return Float.valueOf(s);
            } else if ("double".equals(rule)) {
                return Double.valueOf(s);
            } else if ("string".equals(rule)) {
                return s;
            } else if ("bool".equals(rule)) {
                return Boolean.valueOf(s.trim());
            } else {
                onError(debug);
                return null;
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
                if (aliasEnums.containsValue(Cls)) {
                    return EnumFromString((String) cn.getValue(),
                        (Class<? extends InvarEnum>) Cls);
                } else {
                    return cn.getValue();
                }
            case INT64:
                if (aliasEnums.containsValue(Cls)) {
                    return EnumFromInt(((Long) cn.getValue()).intValue(),
                        (Class<? extends InvarEnum>) Cls);
                } else {
                    Long s = (Long) cn.getValue();
                    return determineInteger(s, cn, rule, debug);
                }
            case DOUBLE:
                if ("float".equals(rule)) {
                    Double v = (Double) cn.getValue();
                    return v.floatValue();
                } else {
                    return cn.getValue();
                }
            case OBJECT:
            case ARRAY:
                Object co = Cls.newInstance();
                parse(co, cn, rule, debug);
                return co;
            default:
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

    private Class<?> loadGenericClass(String rule) throws Exception {
        String name = ruleLeft(rule);
        Class<?> Cls = getClassByAlias(name);
        if (Cls == null)
            Cls = Class.forName(name);
        if (Cls == null)
            onError("No Class matches this rule: " + rule);
        return Cls;
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

    private Object determineInteger(Long v, DataNode n, String rule, String debug) throws Exception {
        if ("int8".equals(rule)) {
            checkInteger(v, -0x80L, 0x7FL, debug, n);
            return v.byteValue();
        } else if ("int16".equals(rule)) {
            checkInteger(v, -0x8000L, 0x7FFFL, debug, n);
            return v.shortValue();
        } else if ("int32".equals(rule)) {
            checkInteger(v, -0x80000000L, 0x7FFFFFFFL, debug, n);
            return v.intValue();
        } else if ("int64".equals(rule)) {
            return v;
        } else if ("uint8".equals(rule)) {
            checkInteger(v, 0L, 0xFFL, debug, n);
            return v.shortValue();
        } else if ("uint16".equals(rule)) {
            checkInteger(v, 0L, 0xFFFFL, debug, n);
            return v.intValue();
        } else if ("uint32".equals(rule)) {
            checkInteger(v, 0L, 0xFFFFFFFFL, debug, n);
            return v;
        } else if ("uint64".equals(rule)) {
            return BigInteger.valueOf(v);
        } else {
            return v;
        }
    }

    private void checkInteger(Long v, Long min, Long max, String debug, DataNode x) throws Exception {
        if (v < min || v > max) {
            onError(debug + " = " + v + ". Number is out of range [" + min + ", " + max + "]", x);
        }
    }

    private void onError(String hint) throws Exception {
        if (path != null && path.length() > 0) {
            hint += "\n" + path;
        }
        throw new Exception("\n" + hint);
    }

    private void onError(String hint, Object n) throws Exception {
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
        InvarRule a = method.getAnnotation(InvarRule.class);
        if (a != null)
            rule = a.T();
        return rule;
    }

    private void invokeSetter(Object value, String key, Object o, DataNode n, String debug) throws Exception {
        HashMap<String, Method> map = getSetters(o.getClass());
        Method method = map.get(key);
        if (method == null) {
            String nameSetter = PREFIX_SETTER + upperHeadChar(key);
            method = map.get(nameSetter);
            if (method == null) {
                //onError("No setter named \"" + nameSetter + "()\" in " + o.getClass(), n);
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


    private static final HashMap<Class<?>, HashMap<String, Method>>
        mapClassSetters = new HashMap<Class<?>, HashMap<String, Method>>();
    private static final HashMap<Class<?>, HashMap<String, Method>>
        mapClassGetters = new HashMap<Class<?>, HashMap<String, Method>>();
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
                    InvarRule anno = method.getAnnotation(InvarRule.class);
                    if (anno != null) {
                        String shortName = anno.S();
                        methods.put(shortName, method);
                    }
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
                    InvarRule a = method.getAnnotation(InvarRule.class);
                    if (a != null) {
                        String shortName = a.S();
                        methods.put(shortName, method);
                    }
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

    private static Class<?> getClassByAlias(String name) {
        Class<?> ClsN = aliasBasics.get(name);
        if (ClsN == null)
            ClsN = aliasEnums.get(name);
        if (ClsN == null)
            ClsN = aliasStructs.get(name);
        return ClsN;
    }

    private static String upperHeadChar(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }

    private static <T extends InvarEnum> Object EnumFromInt(int v, Class<T> clazz) {
        for (T t : clazz.getEnumConstants()) {
            if (t.value().equals(v)) {
                return t;
            }
        }
        return null;
    }

    private static <T extends InvarEnum> T EnumFromString(String v, Class<T> clazz) {
        for (T t : clazz.getEnumConstants()) {
            if (t.name().equals(v.trim())) {
                return t;
            }
        }
        return null;
    }

    private static boolean isSimple(Class<?> Cls) {
        return aliasEnums.containsValue(Cls)
            || aliasBasics.containsValue(Cls)
            && LinkedList.class != Cls
            && HashMap.class != Cls
            && LinkedHashMap.class != Cls
            && !aliasStructs.containsValue(Cls)
            ;
    }

    private static void log(Object txt) {
        System.out.println("| " + txt);
    }

}