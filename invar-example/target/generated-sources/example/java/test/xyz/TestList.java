/*===----------------------------*  Java 6  *------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.xyz;

import invar.lib.CodecError;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.LinkedList;
import test.abc.Custom;
import test.abc.Gender;

/** 测试基本的列表类型 */
public final class TestList
implements
invar.lib.InvarCodec.BinaryDecode,
invar.lib.InvarCodec.BinaryEncode,
invar.lib.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0x5FD1194AL;

    static public TestList Create()
    {
        return new TestList();
    }

    private LinkedList<Byte>       listI08    ;/* 有符号的8位整数 */
    private LinkedList<Short>      listI16    ;/* 有符号的16位整数 */
    private LinkedList<Integer>    listI32    ;/* 有符号的32位整数 */
    private LinkedList<Long>       listI64    ;/* 有符号的64位整数 */
    private LinkedList<Integer>    listU08    ;/* 无符号的8位整数 */
    private LinkedList<Integer>    listU16    ;/* 无符号的16位整数 */
    private LinkedList<Long>       listU32    ;/* 无符号的32位整数 */
    private LinkedList<BigInteger> listU64    ;/* 无符号的64位整数 */
    private LinkedList<Float>      listSingle ;/* 单精度浮点小数 */
    private LinkedList<Double>     listDouble ;/* 双精度浮点小数 */
    private LinkedList<Boolean>    listBoolean;/* 布尔值 */
    private LinkedList<String>     listString ;/* 字符串 */
    private LinkedList<Gender>     listEnum   ;/* 枚举值 */
    private LinkedList<Custom>     listStruct ;/* 自定义结构 */

    public TestList()
    {
        listI08     = new LinkedList<Byte>();
        listI16     = new LinkedList<Short>();
        listI32     = new LinkedList<Integer>();
        listI64     = new LinkedList<Long>();
        listU08     = new LinkedList<Integer>();
        listU16     = new LinkedList<Integer>();
        listU32     = new LinkedList<Long>();
        listU64     = new LinkedList<BigInteger>();
        listSingle  = new LinkedList<Float>();
        listDouble  = new LinkedList<Double>();
        listBoolean = new LinkedList<Boolean>();
        listString  = new LinkedList<String>();
        listEnum    = new LinkedList<Gender>();
        listStruct  = new LinkedList<Custom>();
    }

    public TestList reuse()
    {
        listI08.clear();
        listI16.clear();
        listI32.clear();
        listI64.clear();
        listU08.clear();
        listU16.clear();
        listU32.clear();
        listU64.clear();
        listSingle.clear();
        listDouble.clear();
        listBoolean.clear();
        listString.clear();
        listEnum.clear();
        listStruct.clear();
        return this;
    }

    /** 有符号的8位整数 */
    @invar.lib.InvarRule(T="vec<int8>", S="f0")
    public LinkedList<java.lang.Byte> getListI08() { return listI08; }
    /** 有符号的16位整数 */
    @invar.lib.InvarRule(T="vec<int16>", S="f1")
    public LinkedList<Short> getListI16() { return listI16; }
    /** 有符号的32位整数 */
    @invar.lib.InvarRule(T="vec<int32>", S="f2")
    public LinkedList<Integer> getListI32() { return listI32; }
    /** 有符号的64位整数 */
    @invar.lib.InvarRule(T="vec<int64>", S="f3")
    public LinkedList<Long> getListI64() { return listI64; }
    /** 无符号的8位整数 */
    @invar.lib.InvarRule(T="vec<uint8>", S="f4")
    public LinkedList<java.lang.Integer> getListU08() { return listU08; }
    /** 无符号的16位整数 */
    @invar.lib.InvarRule(T="vec<uint16>", S="f5")
    public LinkedList<java.lang.Integer> getListU16() { return listU16; }
    /** 无符号的32位整数 */
    @invar.lib.InvarRule(T="vec<uint32>", S="f6")
    public LinkedList<java.lang.Long> getListU32() { return listU32; }
    /** 无符号的64位整数 */
    @invar.lib.InvarRule(T="vec<uint64>", S="f7")
    public LinkedList<BigInteger> getListU64() { return listU64; }
    /** 单精度浮点小数 */
    @invar.lib.InvarRule(T="vec<float>", S="f8")
    public LinkedList<Float> getListSingle() { return listSingle; }
    /** 双精度浮点小数 */
    @invar.lib.InvarRule(T="vec<double>", S="f9")
    public LinkedList<java.lang.Double> getListDouble() { return listDouble; }
    /** 布尔值 */
    @invar.lib.InvarRule(T="vec<bool>", S="f10")
    public LinkedList<java.lang.Boolean> getListBoolean() { return listBoolean; }
    /** 字符串 */
    @invar.lib.InvarRule(T="vec<string>", S="f11")
    public LinkedList<java.lang.String> getListString() { return listString; }
    /** 枚举值 */
    @invar.lib.InvarRule(T="vec<test.abc.Gender>", S="f12")
    public LinkedList<Gender> getListEnum() { return listEnum; }
    /** 自定义结构 */
    @invar.lib.InvarRule(T="vec<test.abc.Custom>", S="f13")
    public LinkedList<Custom> getListStruct() { return listStruct; }

    /** Shallow copy */
    public TestList copy(TestList from)
    {
        if (this == from || from == null) {
            return this;
        }
        listI08.clear();
        listI08.addAll(from.listI08);
        listI16.clear();
        listI16.addAll(from.listI16);
        listI32.clear();
        listI32.addAll(from.listI32);
        listI64.clear();
        listI64.addAll(from.listI64);
        listU08.clear();
        listU08.addAll(from.listU08);
        listU16.clear();
        listU16.addAll(from.listU16);
        listU32.clear();
        listU32.addAll(from.listU32);
        listU64.clear();
        listU64.addAll(from.listU64);
        listSingle.clear();
        listSingle.addAll(from.listSingle);
        listDouble.clear();
        listDouble.addAll(from.listDouble);
        listBoolean.clear();
        listBoolean.addAll(from.listBoolean);
        listString.clear();
        listString.addAll(from.listString);
        listEnum.clear();
        listEnum.addAll(from.listEnum);
        listStruct.clear();
        listStruct.addAll(from.listStruct);
        return this;
    } /* copyFrom(...) */

    public void read(InputStream from) throws IOException, CodecError
    {
        this.read((DataInput)new DataInputStream(from));
    }

    public void read(DataInput from) throws IOException, CodecError
    {
        listI08.clear();
        Long lenListI08 = from.readInt() & 0xFFFFFFFFL;
        for (Long iListI08 = 0L; iListI08 < lenListI08; ++iListI08) {
            java.lang.Byte n1 = from.readByte();
            listI08.add(n1);
        }
        listI16.clear();
        Long lenListI16 = from.readInt() & 0xFFFFFFFFL;
        for (Long iListI16 = 0L; iListI16 < lenListI16; ++iListI16) {
            Short n1 = from.readShort();
            listI16.add(n1);
        }
        listI32.clear();
        Long lenListI32 = from.readInt() & 0xFFFFFFFFL;
        for (Long iListI32 = 0L; iListI32 < lenListI32; ++iListI32) {
            Integer n1 = from.readUnsignedShort();
            listI32.add(n1);
        }
        listI64.clear();
        Long lenListI64 = from.readInt() & 0xFFFFFFFFL;
        for (Long iListI64 = 0L; iListI64 < lenListI64; ++iListI64) {
            Long n1 = from.readInt() & 0xFFFFFFFFL;
            listI64.add(n1);
        }
        listU08.clear();
        Long lenListU08 = from.readInt() & 0xFFFFFFFFL;
        for (Long iListU08 = 0L; iListU08 < lenListU08; ++iListU08) {
            java.lang.Integer n1 = from.readUnsignedShort();
            listU08.add(n1);
        }
        listU16.clear();
        Long lenListU16 = from.readInt() & 0xFFFFFFFFL;
        for (Long iListU16 = 0L; iListU16 < lenListU16; ++iListU16) {
            java.lang.Integer n1 = from.readUnsignedShort();
            listU16.add(n1);
        }
        listU32.clear();
        Long lenListU32 = from.readInt() & 0xFFFFFFFFL;
        for (Long iListU32 = 0L; iListU32 < lenListU32; ++iListU32) {
            java.lang.Long n1 = from.readInt() & 0xFFFFFFFFL;
            listU32.add(n1);
        }
        listU64.clear();
        Long lenListU64 = from.readInt() & 0xFFFFFFFFL;
        for (Long iListU64 = 0L; iListU64 < lenListU64; ++iListU64) {
            byte[] n1Bytes = new byte[8]; from.readFully(n1Bytes, 0, 8);
            BigInteger n1 = new BigInteger(1, n1Bytes);
            listU64.add(n1);
        }
        listSingle.clear();
        Long lenListSingle = from.readInt() & 0xFFFFFFFFL;
        for (Long iListSingle = 0L; iListSingle < lenListSingle; ++iListSingle) {
            Float n1 = from.readFloat();
            listSingle.add(n1);
        }
        listDouble.clear();
        Long lenListDouble = from.readInt() & 0xFFFFFFFFL;
        for (Long iListDouble = 0L; iListDouble < lenListDouble; ++iListDouble) {
            java.lang.Double n1 = from.readDouble();
            listDouble.add(n1);
        }
        listBoolean.clear();
        Long lenListBoolean = from.readInt() & 0xFFFFFFFFL;
        for (Long iListBoolean = 0L; iListBoolean < lenListBoolean; ++iListBoolean) {
            java.lang.Boolean n1 = from.readBoolean();
            listBoolean.add(n1);
        }
        listString.clear();
        Long lenListString = from.readInt() & 0xFFFFFFFFL;
        for (Long iListString = 0L; iListString < lenListString; ++iListString) {
            java.lang.String n1 = from.readUTF();
            listString.add(n1);
        }
        listEnum.clear();
        Long lenListEnum = from.readInt() & 0xFFFFFFFFL;
        for (Long iListEnum = 0L; iListEnum < lenListEnum; ++iListEnum) {
            Gender n1 = Gender.valueOf(from.readInt());
            listEnum.add(n1);
        }
        listStruct.clear();
        Long lenListStruct = from.readInt() & 0xFFFFFFFFL;
        for (Long iListStruct = 0L; iListStruct < lenListStruct; ++iListStruct) {
            Custom n1 = Custom.Create();
            n1.read(from);
            listStruct.add(n1);
        }
    }

    public void write(OutputStream from) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(from));
    }

    public void write(DataOutput dest) throws IOException
    {
        dest.writeInt(listI08.size());
        for (java.lang.Byte n1 : listI08) {
            dest.writeByte(n1);
        }
        dest.writeInt(listI16.size());
        for (Short n1 : listI16) {
            dest.writeShort(n1);
        }
        dest.writeInt(listI32.size());
        for (Integer n1 : listI32) {
            dest.writeShort(n1);
        }
        dest.writeInt(listI64.size());
        for (Long n1 : listI64) {
            dest.writeInt(n1.intValue());
        }
        dest.writeInt(listU08.size());
        for (java.lang.Integer n1 : listU08) {
            dest.writeShort(n1);
        }
        dest.writeInt(listU16.size());
        for (java.lang.Integer n1 : listU16) {
            dest.writeShort(n1);
        }
        dest.writeInt(listU32.size());
        for (java.lang.Long n1 : listU32) {
            dest.writeInt(n1.intValue());
        }
        dest.writeInt(listU64.size());
        for (BigInteger n1 : listU64) {
            dest.writeLong(n1.longValue());
        }
        dest.writeInt(listSingle.size());
        for (Float n1 : listSingle) {
            dest.writeFloat(n1);
        }
        dest.writeInt(listDouble.size());
        for (java.lang.Double n1 : listDouble) {
            dest.writeDouble(n1);
        }
        dest.writeInt(listBoolean.size());
        for (java.lang.Boolean n1 : listBoolean) {
            dest.writeBoolean(n1);
        }
        dest.writeInt(listString.size());
        for (java.lang.String n1 : listString) {
            dest.writeUTF(n1);
        }
        dest.writeInt(listEnum.size());
        for (Gender n1 : listEnum) {
            dest.writeInt(n1.value());
        }
        dest.writeInt(listStruct.size());
        for (Custom n1 : listStruct) {
            n1.write(dest);
        }
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append('{');
        s.append(getClass().getName());
        s.append(',').append("listI08").append(':');
        s.append('(').append(listI08.size()).append(')');
        s.append(',').append("listI16").append(':');
        s.append('(').append(listI16.size()).append(')');
        s.append(',').append("listI32").append(':');
        s.append('(').append(listI32.size()).append(')');
        s.append(',').append("listI64").append(':');
        s.append('(').append(listI64.size()).append(')');
        s.append(',').append("listU08").append(':');
        s.append('(').append(listU08.size()).append(')');
        s.append(',').append("listU16").append(':');
        s.append('(').append(listU16.size()).append(')');
        s.append(',').append("listU32").append(':');
        s.append('(').append(listU32.size()).append(')');
        s.append(',').append("listU64").append(':');
        s.append('(').append(listU64.size()).append(')');
        s.append(',').append("listSingle").append(':');
        s.append('(').append(listSingle.size()).append(')');
        s.append(',').append("listDouble").append(':');
        s.append('(').append(listDouble.size()).append(')');
        s.append(',').append("listBoolean").append(':');
        s.append('(').append(listBoolean.size()).append(')');
        s.append(',').append("listString").append(':');
        s.append('(').append(listString.size()).append(')');
        s.append(',').append("listEnum").append(':');
        s.append('(').append(listEnum.size()).append(')');
        s.append(',').append("listStruct").append(':');
        s.append('(').append(listStruct.size()).append(')');
        s.append('}');
        return s.toString();
    } //TestList::toString ()

    public String toStringJSON()
    {
        StringBuilder code = new StringBuilder();
        this.writeJSON(code);
        return code.toString();
    }

    public void writeJSON(StringBuilder s)
    {
        s.append('{');
        char comma = '\0';
        boolean listI08Exists = (null != listI08 && listI08.size() > 0);
        if (listI08Exists) { s.append('"').append("listI08").append('"').append(':'); comma = ','; }
        int listI08Size = (null == listI08 ? 0 : listI08.size());
        if (listI08Size > 0) {
            s.append('[');
            int listI08Idx = 0;
            for (java.lang.Byte n1 : listI08) { /* vec.for: listI08 */
                ++listI08Idx;
                s.append(n1.toString());
                if (listI08Idx != listI08Size) { s.append(','); }
            }
            s.append(']');
        }
        boolean listI16Exists = (null != listI16 && listI16.size() > 0);
        if ('\0' != comma && listI16Exists) { s.append(comma); comma = '\0'; }
        if (listI16Exists) { s.append('"').append("listI16").append('"').append(':'); comma = ','; }
        int listI16Size = (null == listI16 ? 0 : listI16.size());
        if (listI16Size > 0) {
            s.append('[');
            int listI16Idx = 0;
            for (Short n1 : listI16) { /* vec.for: listI16 */
                ++listI16Idx;
                s.append(n1.toString());
                if (listI16Idx != listI16Size) { s.append(','); }
            }
            s.append(']');
        }
        boolean listI32Exists = (null != listI32 && listI32.size() > 0);
        if ('\0' != comma && listI32Exists) { s.append(comma); comma = '\0'; }
        if (listI32Exists) { s.append('"').append("listI32").append('"').append(':'); comma = ','; }
        int listI32Size = (null == listI32 ? 0 : listI32.size());
        if (listI32Size > 0) {
            s.append('[');
            int listI32Idx = 0;
            for (Integer n1 : listI32) { /* vec.for: listI32 */
                ++listI32Idx;
                s.append(n1.toString());
                if (listI32Idx != listI32Size) { s.append(','); }
            }
            s.append(']');
        }
        boolean listI64Exists = (null != listI64 && listI64.size() > 0);
        if ('\0' != comma && listI64Exists) { s.append(comma); comma = '\0'; }
        if (listI64Exists) { s.append('"').append("listI64").append('"').append(':'); comma = ','; }
        int listI64Size = (null == listI64 ? 0 : listI64.size());
        if (listI64Size > 0) {
            s.append('[');
            int listI64Idx = 0;
            for (Long n1 : listI64) { /* vec.for: listI64 */
                ++listI64Idx;
                s.append(n1.toString());
                if (listI64Idx != listI64Size) { s.append(','); }
            }
            s.append(']');
        }
        boolean listU08Exists = (null != listU08 && listU08.size() > 0);
        if ('\0' != comma && listU08Exists) { s.append(comma); comma = '\0'; }
        if (listU08Exists) { s.append('"').append("listU08").append('"').append(':'); comma = ','; }
        int listU08Size = (null == listU08 ? 0 : listU08.size());
        if (listU08Size > 0) {
            s.append('[');
            int listU08Idx = 0;
            for (java.lang.Integer n1 : listU08) { /* vec.for: listU08 */
                ++listU08Idx;
                s.append(n1.toString());
                if (listU08Idx != listU08Size) { s.append(','); }
            }
            s.append(']');
        }
        boolean listU16Exists = (null != listU16 && listU16.size() > 0);
        if ('\0' != comma && listU16Exists) { s.append(comma); comma = '\0'; }
        if (listU16Exists) { s.append('"').append("listU16").append('"').append(':'); comma = ','; }
        int listU16Size = (null == listU16 ? 0 : listU16.size());
        if (listU16Size > 0) {
            s.append('[');
            int listU16Idx = 0;
            for (java.lang.Integer n1 : listU16) { /* vec.for: listU16 */
                ++listU16Idx;
                s.append(n1.toString());
                if (listU16Idx != listU16Size) { s.append(','); }
            }
            s.append(']');
        }
        boolean listU32Exists = (null != listU32 && listU32.size() > 0);
        if ('\0' != comma && listU32Exists) { s.append(comma); comma = '\0'; }
        if (listU32Exists) { s.append('"').append("listU32").append('"').append(':'); comma = ','; }
        int listU32Size = (null == listU32 ? 0 : listU32.size());
        if (listU32Size > 0) {
            s.append('[');
            int listU32Idx = 0;
            for (java.lang.Long n1 : listU32) { /* vec.for: listU32 */
                ++listU32Idx;
                s.append(n1.toString());
                if (listU32Idx != listU32Size) { s.append(','); }
            }
            s.append(']');
        }
        boolean listU64Exists = (null != listU64 && listU64.size() > 0);
        if ('\0' != comma && listU64Exists) { s.append(comma); comma = '\0'; }
        if (listU64Exists) { s.append('"').append("listU64").append('"').append(':'); comma = ','; }
        int listU64Size = (null == listU64 ? 0 : listU64.size());
        if (listU64Size > 0) {
            s.append('[');
            int listU64Idx = 0;
            for (BigInteger n1 : listU64) { /* vec.for: listU64 */
                ++listU64Idx;
                s.append(n1.toString());
                if (listU64Idx != listU64Size) { s.append(','); }
            }
            s.append(']');
        }
        boolean listSingleExists = (null != listSingle && listSingle.size() > 0);
        if ('\0' != comma && listSingleExists) { s.append(comma); comma = '\0'; }
        if (listSingleExists) { s.append('"').append("listSingle").append('"').append(':'); comma = ','; }
        int listSingleSize = (null == listSingle ? 0 : listSingle.size());
        if (listSingleSize > 0) {
            s.append('[');
            int listSingleIdx = 0;
            for (Float n1 : listSingle) { /* vec.for: listSingle */
                ++listSingleIdx;
                s.append(n1.toString());
                if (listSingleIdx != listSingleSize) { s.append(','); }
            }
            s.append(']');
        }
        boolean listDoubleExists = (null != listDouble && listDouble.size() > 0);
        if ('\0' != comma && listDoubleExists) { s.append(comma); comma = '\0'; }
        if (listDoubleExists) { s.append('"').append("listDouble").append('"').append(':'); comma = ','; }
        int listDoubleSize = (null == listDouble ? 0 : listDouble.size());
        if (listDoubleSize > 0) {
            s.append('[');
            int listDoubleIdx = 0;
            for (java.lang.Double n1 : listDouble) { /* vec.for: listDouble */
                ++listDoubleIdx;
                s.append(n1.toString());
                if (listDoubleIdx != listDoubleSize) { s.append(','); }
            }
            s.append(']');
        }
        boolean listBooleanExists = (null != listBoolean && listBoolean.size() > 0);
        if ('\0' != comma && listBooleanExists) { s.append(comma); comma = '\0'; }
        if (listBooleanExists) { s.append('"').append("listBoolean").append('"').append(':'); comma = ','; }
        int listBooleanSize = (null == listBoolean ? 0 : listBoolean.size());
        if (listBooleanSize > 0) {
            s.append('[');
            int listBooleanIdx = 0;
            for (java.lang.Boolean n1 : listBoolean) { /* vec.for: listBoolean */
                ++listBooleanIdx;
                s.append(n1.toString().toLowerCase());
                if (listBooleanIdx != listBooleanSize) { s.append(','); }
            }
            s.append(']');
        }
        boolean listStringExists = (null != listString && listString.size() > 0);
        if ('\0' != comma && listStringExists) { s.append(comma); comma = '\0'; }
        if (listStringExists) { s.append('"').append("listString").append('"').append(':'); comma = ','; }
        int listStringSize = (null == listString ? 0 : listString.size());
        if (listStringSize > 0) {
            s.append('[');
            int listStringIdx = 0;
            for (java.lang.String n1 : listString) { /* vec.for: listString */
                ++listStringIdx;
                s.append('"').append(n1.toString()).append('"');
                if (listStringIdx != listStringSize) { s.append(','); }
            }
            s.append(']');
        }
        boolean listEnumExists = (null != listEnum && listEnum.size() > 0);
        if ('\0' != comma && listEnumExists) { s.append(comma); comma = '\0'; }
        if (listEnumExists) { s.append('"').append("listEnum").append('"').append(':'); comma = ','; }
        int listEnumSize = (null == listEnum ? 0 : listEnum.size());
        if (listEnumSize > 0) {
            s.append('[');
            int listEnumIdx = 0;
            for (Gender n1 : listEnum) { /* vec.for: listEnum */
                ++listEnumIdx;
                s.append(n1.value());
                if (listEnumIdx != listEnumSize) { s.append(','); }
            }
            s.append(']');
        }
        boolean listStructExists = (null != listStruct && listStruct.size() > 0);
        if ('\0' != comma && listStructExists) { s.append(comma); comma = '\0'; }
        if (listStructExists) { s.append('"').append("listStruct").append('"').append(':'); comma = ','; }
        int listStructSize = (null == listStruct ? 0 : listStruct.size());
        if (listStructSize > 0) {
            s.append('[');
            int listStructIdx = 0;
            for (Custom n1 : listStruct) { /* vec.for: listStruct */
                ++listStructIdx;
                n1.writeJSON(s);
                if (listStructIdx != listStructSize) { s.append(','); }
            }
            s.append(']');
        }
        s.append('}');
    } /* TestList::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "TestList");
        return code.toString();
    }

    public void writeXML(StringBuilder result, String name)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        if (listI08.size() > 0) {
            nodes.append('<').append("listI08").append('>');
            for (java.lang.Byte n1 : listI08) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listI08").append('>');
        }
        if (listI16.size() > 0) {
            nodes.append('<').append("listI16").append('>');
            for (Short n1 : listI16) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listI16").append('>');
        }
        if (listI32.size() > 0) {
            nodes.append('<').append("listI32").append('>');
            for (Integer n1 : listI32) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listI32").append('>');
        }
        if (listI64.size() > 0) {
            nodes.append('<').append("listI64").append('>');
            for (Long n1 : listI64) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listI64").append('>');
        }
        if (listU08.size() > 0) {
            nodes.append('<').append("listU08").append('>');
            for (java.lang.Integer n1 : listU08) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listU08").append('>');
        }
        if (listU16.size() > 0) {
            nodes.append('<').append("listU16").append('>');
            for (java.lang.Integer n1 : listU16) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listU16").append('>');
        }
        if (listU32.size() > 0) {
            nodes.append('<').append("listU32").append('>');
            for (java.lang.Long n1 : listU32) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listU32").append('>');
        }
        if (listU64.size() > 0) {
            nodes.append('<').append("listU64").append('>');
            for (BigInteger n1 : listU64) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listU64").append('>');
        }
        if (listSingle.size() > 0) {
            nodes.append('<').append("listSingle").append('>');
            for (Float n1 : listSingle) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listSingle").append('>');
        }
        if (listDouble.size() > 0) {
            nodes.append('<').append("listDouble").append('>');
            for (java.lang.Double n1 : listDouble) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listDouble").append('>');
        }
        if (listBoolean.size() > 0) {
            nodes.append('<').append("listBoolean").append('>');
            for (java.lang.Boolean n1 : listBoolean) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listBoolean").append('>');
        }
        if (listString.size() > 0) {
            nodes.append('<').append("listString").append('>');
            for (java.lang.String n1 : listString) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listString").append('>');
        }
        if (listEnum.size() > 0) {
            nodes.append('<').append("listEnum").append('>');
            for (Gender n1 : listEnum) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listEnum").append('>');
        }
        if (listStruct.size() > 0) {
            nodes.append('<').append("listStruct").append('>');
            for (Custom n1 : listStruct) {
                n1.writeXML(nodes, "n1");
            }
            nodes.append('<').append('/').append("listStruct").append('>');
        }
        result.append('<').append(name).append(attrs);
        if (nodes.length() == 0) {
            result.append('/').append('>');
        } else {
            result.append('>').append(nodes);
            result.append('<').append('/').append(name).append('>');
        }
    } /* TestList::writeXML(...) */

}

