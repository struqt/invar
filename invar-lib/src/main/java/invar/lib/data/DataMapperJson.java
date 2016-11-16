/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib.data;

import invar.lib.InvarEnum;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by wangkang on 11/14/16
 */
public class DataMapperJson extends DataMapper<DataMapperJson> {

    static final public Charset UTF8 = Charset.forName("utf-8");
    static final DataParserJson decoder = new DataParserJson();

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
        DataNode node = decoder.parse(from);
        parse(dest, node);
        return dest;
    }

    void parse(Object o, DataNode n) throws Exception {
        parse(o, n, o.getClass().getName(), "o");
    }

    @SuppressWarnings("unchecked")
    void parse(Object o, DataNode n, String rule, String debug) throws Exception {
        if (o == null) {
            onError(debug + " is null.", n);
        }
        Class<?> ClsO = loadGenericClass(rule);
        if (LinkedList.class == ClsO) {
            parseVec((LinkedList<Object>) o, n, rule, debug);
        } else if (LinkedHashMap.class == ClsO) {
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

}
