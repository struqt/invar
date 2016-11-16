/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib.data;

import invar.lib.InvarEnum;
import invar.lib.InvarRule;

import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.HashMap;

/**
 * Created by wangkang on 11/14/16
 */
public abstract class DataMapper<T extends DataMapper<T>> {

    static public HashMap<String, Class<?>> aliasBasics = null;
    static public HashMap<String, Class<?>> aliasEnums = null;
    static public HashMap<String, Class<?>> aliasStructs = null;

    Class<?> loadGenericClass(String rule) throws Exception {
        String name = ruleLeft(rule);
        Class<?> Cls = getClassByAlias(name);
        if (Cls == null)
            Cls = Class.forName(name);
        if (Cls == null)
            onError("No Class matches this rule: " + rule);
        return Cls;
    }

    Object invokeGetter(String key, Object o, Object node) throws Exception {
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

    Object parseInteger(DataNode n, String rule, String debug) throws Exception {
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

    void checkInteger(Long v, Long min, Long max, String debug, DataNode x) throws Exception {
        if (v < min || v > max) {
            onError(debug + " = " + v + ". Number is out of range [" + min + ", " + max + "]", x);
        }
    }

    void onError(String hint) throws Exception {
        throw new Exception("\n" + hint + "\n" + path);
    }

    void onError(String hint, Object n) throws Exception {
        throw new Exception("\n" + hint + "\n" + n + "\n" + path);
    }

    String getRule(Class<?> ClsO, String key, DataNode n) throws Exception {
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

    void invokeSetter(Object value, String key, Object o, DataNode n, String debug) throws Exception {
        HashMap<String, Method> map = getSetters(o.getClass());
        Method method = map.get(key);
        if (method == null) {
            String nameSetter = PREFIX_SETTER + upperHeadChar(key);
            method = map.get(nameSetter);
            if (method == null) {
                onError("No setter named \"" + nameSetter + "()\" in " + o.getClass(), n);
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


    static final
    HashMap<Class<?>, HashMap<String, Method>> mapClassSetters = new HashMap<Class<?>, HashMap<String, Method>>();
    static final
    HashMap<Class<?>, HashMap<String, Method>> mapClassGetters = new HashMap<Class<?>, HashMap<String, Method>>();
    static final String GENERIC_SPLIT = ",";
    static final String GENERIC_LEFT = "<";
    static final String GENERIC_RIGHT = ">";
    static final String PREFIX_SETTER = "set";
    static final String PREFIX_GETTER = "get";
    static final String ATTR_MAP_KEY = "key";
    static final String ATTR_VALUE = "value";

    static HashMap<String, Method> getSetters(Class<?> ClsO) {
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

    static HashMap<String, Method> getGetters(Class<?> ClsO) {
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

    static String ruleLeft(String rule) {
        String name = rule;
        int index = rule.indexOf(GENERIC_LEFT);
        if (index >= 0) {
            name = rule.substring(0, index);
        }
        return name;
    }

    static String ruleRight(String rule) {
        int iBegin = rule.indexOf(GENERIC_LEFT) + 1;
        int iEnd = rule.lastIndexOf(GENERIC_RIGHT);
        if (iBegin > 0 && iEnd > iBegin) {
            return rule.substring(iBegin, iEnd);
        }
        return null;
    }

    static Class<?> getClassByAlias(String name) {
        Class<?> ClsN = aliasBasics.get(name);
        if (ClsN == null)
            ClsN = aliasEnums.get(name);
        if (ClsN == null)
            ClsN = aliasStructs.get(name);
        return ClsN;
    }

    static String upperHeadChar(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }

    static <T extends InvarEnum> Object EnumFromInt(int v, Class<T> clazz) {
        for (T t : clazz.getEnumConstants()) {
            if (t.value().equals(v)) {
                return t;
            }
        }
        return null;
    }

    static <T extends InvarEnum> T EnumFromString(String v, Class<T> clazz) {
        for (T t : clazz.getEnumConstants()) {
            if (t.name().equals(v)) {
                return t;
            }
        }
        return null;
    }

    static void log(Object txt) {
        System.out.println("| " + txt);
    }


    String path;
    Boolean verbose = false;

    public String getPath() {
        return path;
    }

    @SuppressWarnings("unchecked")
    public T setPath(String path) {
        this.path = path;
        return (T) this;
    }

    public Boolean getVerbose() {
        return verbose;
    }

    @SuppressWarnings("unchecked")
    public T setVerbose(Boolean verbose) {
        this.verbose = verbose;
        return (T) this;
    }

}