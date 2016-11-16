/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib.data;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangkang on 11/12/16
 */
public class DataNode<T> {

    public enum TypeId {
        INT64, BIGINT, DOUBLE, BOOL, STRING, NULL, OBJECT, ARRAY
    }

    static private <T> DataNode<T> create() {
        return new DataNode<T>();
    }

    static public DataNode<Object> createNull() {
        return DataNode.create().setTypeId(TypeId.NULL);
    }

    static public DataNode createArray() {
        return create().setTypeId(TypeId.ARRAY);
    }

    static public DataNode createObject() {
        return create().setTypeId(TypeId.OBJECT);
    }

    static public DataNode<String> createString() {
        return DataNode.<String>create().setTypeId(TypeId.STRING);
    }

    static public DataNode<Boolean> createBoolean() {
        return DataNode.<Boolean>create().setTypeId(TypeId.BOOL);
    }

    static public DataNode<Long> createLong() {
        return DataNode.<Long>create().setTypeId(TypeId.INT64);
    }

    static public DataNode<BigInteger> createBigInt() {
        return DataNode.<BigInteger>create().setTypeId(TypeId.BIGINT);
    }

    static public DataNode<Double> createDouble() {
        return DataNode.<Double>create().setTypeId(TypeId.DOUBLE);
    }

    private T value = null;
    private String fieldName;
    private TypeId typeId;
    private DataNode parent;
    private final List<DataNode> children;

    private DataNode() {
        children = new ArrayList<DataNode>(32);
    }

    public DataNode<T> setValue(T value) {
        this.value = value;
        return this;
    }

    public DataNode<T> setTypeId(TypeId typeId) {
        this.typeId = typeId;
        return this;
    }

    public String getFieldName() {
        return fieldName;
    }

    public DataNode<T> setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public DataNode<T> addChild(DataNode node) {
        if (node == null) {
            return this;
        }
        node.setParent(this);
        this.children.add(node);
        return this;
    }

    public int numChildren() {
        return this.children.size();
    }

    public DataNode getChild(int index) {
        return this.children.get(index);
    }

    public TypeId getTypeId() {
        return typeId;
    }

    public DataNode getParent() {
        return parent;
    }

    public T getValue() {
        return value;
    }

    private DataNode<T> setParent(DataNode parent) {
        if (parent == this) {
            return this;
        }
        this.parent = parent;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(256);
        dump(s);
        return s.toString();
    }

    public void dump(StringBuilder s) {
        if (s == null) {
            return;
        }
        if (getFieldName() != null) {
            //s.append('"');
            s.append(getFieldName());
            //s.append('"');
            s.append('<');
            s.append(getTypeId().name());
            s.append('>');
            s.append(':');
        }
        if (TypeId.OBJECT.equals(getTypeId())) {
            s.append('{');
            int len = children.size();
            for (int i = 0; i < len; i++) {
                DataNode n = children.get(i);
                n.dump(s);
                if (i < len - 1) {
                    s.append(',');
                }
            }
            s.append('}');
        } else if (TypeId.ARRAY.equals(getTypeId())) {
            s.append('[');
            int len = children.size();
            for (int i = 0; i < len; i++) {
                DataNode n = children.get(i);
                n.dump(s);
                if (i < len - 1) {
                    s.append(',');
                }
            }
            s.append(']');
        } else {
            s.append(value);
        }
    }

}