/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib.data;

import invar.lib.InvarEnum;
import invar.lib.InvarRule;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by wangkang on 11/14/16
 */
public class DataMapper {

    static public DataMapper forJson() {
        return new DataMapper(new DataParserJson());
    }

    static public DataMapper forXml() {
        return new DataMapper(new DataParserXml());
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
        parse(dest, node);
        return dest;
    }

    private void parse(Object o, DataNode n) throws Exception {
        parse(o, n, o.getClass().getName(), "o");
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
            String ruleX = getRule(ClsO, key, n);
            if (ruleX == null) {
                continue;
            }
            Class<?> ClsX = loadGenericClass(ruleX);
            Object v;
            switch (x.getTypeId()) {
                case OBJECT:
                case ARRAY:
                    v = invokeGetter(key, o, x);
                    if (v == null && ClsX != Vector.class) {
                        v = ClsX.newInstance();
                        invokeSetter(v, key, o, x, debug);
                    }
                    parse(v, x, ruleX, debug + '.' + key);
                    break;
                default:
                    v = parseGenericChild(x, ClsX, ruleX, debug);
                    invokeSetter(v, key, o, x, debug);
                    break;
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
            DataNode vn = n.getChild(i);
            Object v = parseGenericChild(vn, Cls, R, debug + "[" + list.size() + "]");
            list.add(v);
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
        Class<?> ClsV = loadGenericClass(typeNames[1]);
        int len = n.numChildren();
        for (int i = 0; i < len; i++) {
            DataNode vn = n.getChild(i);
            String k = vn.getFieldName();
            if (k == null || k.length() <= 0) {
                continue;
            }
            Object v = parseGenericChild(vn, ClsV, typeNames[1], debug + ".v");
            map.put(k, v);
        }
    }

    @SuppressWarnings("unchecked")
    private Object parseGenericChild(DataNode cn, Class<?> Cls, String rule, String debug) throws Exception {
        switch (cn.getTypeId()) {
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
                    return parseInteger(cn, rule, debug);
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

    public String getPath() {
        return path;
    }

    public DataMapper setPath(String path) {
        this.path = path;
        return this;
    }

    public Boolean getVerbose() {
        return verbose;
    }

    public DataMapper setVerbose(Boolean verbose) {
        this.verbose = verbose;
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

    private Object parseInteger(DataNode n, String rule, String debug) throws Exception {
        if (!n.getTypeId().equals(DataNode.TypeId.INT64)) {
            return 0;
        }
        Long s = (Long) n.getValue();
        if ("int8".equals(rule)) {
            checkInteger(s, -0x80L, 0x7FL, debug, n);
            return s.byteValue();
        } else if ("int16".equals(rule)) {
            checkInteger(s, -0x8000L, 0x7FFFL, debug, n);
            return s.shortValue();
        } else if ("int32".equals(rule)) {
            checkInteger(s, -0x80000000L, 0x7FFFFFFFL, debug, n);
            return s.intValue();
        } else if ("int64".equals(rule)) {
            return s;
        } else if ("uint8".equals(rule)) {
            checkInteger(s, 0L, 0xFFL, debug, n);
            return s.shortValue();
        } else if ("uint16".equals(rule)) {
            checkInteger(s, 0L, 0xFFFFL, debug, n);
            return s.intValue();
        } else if ("uint32".equals(rule)) {
            checkInteger(s, 0L, 0xFFFFFFFFL, debug, n);
            return s;
        } else if ("uint64".equals(rule)) {
            return BigInteger.valueOf(s);
        } else {
            return s;
        }
    }

    private void checkInteger(Long v, Long min, Long max, String debug, DataNode x) throws Exception {
        if (v < min || v > max) {
            onError(debug + " = " + v + ". Number is out of range [" + min + ", " + max + "]", x);
        }
    }

    private void onError(String hint) throws Exception {
        throw new Exception("\n" + hint + "\n" + path);
    }

    private void onError(String hint, Object n) throws Exception {
        throw new Exception("\n" + hint + "\n" + n + "\n" + path);
    }

    private String getRule(Class<?> ClsO, String key, DataNode n) throws Exception {
        HashMap<String, Method> map = getGetters(ClsO);
        Method method = map.get(key);
        if (method == null) {
            String nameGetter = PREFIX_GETTER + upperHeadChar(key);
            method = map.get(nameGetter);
            if (method == null && !ATTR_MAP_KEY.equals(key))
                onError("No getter named '" + nameGetter + "' in " + ClsO, n);
        }
        if (method == null)
            return null;
        String rule = method.getGenericReturnType().toString();
        InvarRule anno = method.getAnnotation(InvarRule.class);
        if (anno != null)
            rule = anno.T();
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
        if (verbose) {
            log(debug + "." + key + ": " + value);
        }
        try {
            method.invoke(o, value);
        } catch (Exception e) {
            System.err.println(debug + "." + key);
            System.err.println(n);
            //e.printStackTrace();
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
    //static final String ATTR_VALUE = "value";

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
                    InvarRule anno = method.getAnnotation(InvarRule.class);
                    if (anno != null) {
                        String shortName = anno.S();
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
            if (t.name().equals(v)) {
                return t;
            }
        }
        return null;
    }

    private static void log(Object txt) {
        System.out.println("| " + txt);
    }


}