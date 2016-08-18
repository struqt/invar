/*===----------------------------*  Java  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.xyz;

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
invar.InvarCodec.BinaryDecode,
invar.InvarCodec.BinaryEncode,
invar.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0x5FD1194A;

    static public TestList Create() {
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
    @invar.InvarRule(T="vec<int8>", S="f0")
    public LinkedList<Byte> getListI08() { return listI08; }

    /** 有符号的16位整数 */
    @invar.InvarRule(T="vec<int16>", S="f1")
    public LinkedList<Short> getListI16() { return listI16; }

    /** 有符号的32位整数 */
    @invar.InvarRule(T="vec<int32>", S="f2")
    public LinkedList<Integer> getListI32() { return listI32; }

    /** 有符号的64位整数 */
    @invar.InvarRule(T="vec<int64>", S="f3")
    public LinkedList<Long> getListI64() { return listI64; }

    /** 无符号的8位整数 */
    @invar.InvarRule(T="vec<uint8>", S="f4")
    public LinkedList<Integer> getListU08() { return listU08; }

    /** 无符号的16位整数 */
    @invar.InvarRule(T="vec<uint16>", S="f5")
    public LinkedList<Integer> getListU16() { return listU16; }

    /** 无符号的32位整数 */
    @invar.InvarRule(T="vec<uint32>", S="f6")
    public LinkedList<Long> getListU32() { return listU32; }

    /** 无符号的64位整数 */
    @invar.InvarRule(T="vec<uint64>", S="f7")
    public LinkedList<BigInteger> getListU64() { return listU64; }

    /** 单精度浮点小数 */
    @invar.InvarRule(T="vec<float>", S="f8")
    public LinkedList<Float> getListSingle() { return listSingle; }

    /** 双精度浮点小数 */
    @invar.InvarRule(T="vec<double>", S="f9")
    public LinkedList<Double> getListDouble() { return listDouble; }

    /** 布尔值 */
    @invar.InvarRule(T="vec<bool>", S="f10")
    public LinkedList<Boolean> getListBoolean() { return listBoolean; }

    /** 字符串 */
    @invar.InvarRule(T="vec<string>", S="f11")
    public LinkedList<String> getListString() { return listString; }

    /** 枚举值 */
    @invar.InvarRule(T="vec<test.abc.Gender>", S="f12")
    public LinkedList<Gender> getListEnum() { return listEnum; }

    /** 自定义结构 */
    @invar.InvarRule(T="vec<test.abc.Custom>", S="f13")
    public LinkedList<Custom> getListStruct() { return listStruct; }

    public TestList copy (TestList from)
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
    } //copyFrom(...)

    public void read(InputStream from) throws IOException
    {
        this.read((DataInput)new DataInputStream(from));
    }

    public void read(DataInput from) throws IOException
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
            BigInteger n1 = new BigInteger(n1Bytes);
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
            dest.writeInt(n1.getValue());
        }
        dest.writeInt(listStruct.size());
        for (Custom n1 : listStruct) {
            n1.write(dest);
        }
    }

    public StringBuilder toStringXML (String name)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes  = new StringBuilder();
        if (listI08.size() > 0) {
            nodes.append("<listI08>");
            for (java.lang.Byte n1 : listI08) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listI08>");
        }
        if (listI16.size() > 0) {
            nodes.append("<listI16>");
            for (Short n1 : listI16) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listI16>");
        }
        if (listI32.size() > 0) {
            nodes.append("<listI32>");
            for (Integer n1 : listI32) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listI32>");
        }
        if (listI64.size() > 0) {
            nodes.append("<listI64>");
            for (Long n1 : listI64) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listI64>");
        }
        if (listU08.size() > 0) {
            nodes.append("<listU08>");
            for (java.lang.Integer n1 : listU08) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listU08>");
        }
        if (listU16.size() > 0) {
            nodes.append("<listU16>");
            for (java.lang.Integer n1 : listU16) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listU16>");
        }
        if (listU32.size() > 0) {
            nodes.append("<listU32>");
            for (java.lang.Long n1 : listU32) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listU32>");
        }
        if (listU64.size() > 0) {
            nodes.append("<listU64>");
            for (BigInteger n1 : listU64) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listU64>");
        }
        if (listSingle.size() > 0) {
            nodes.append("<listSingle>");
            for (Float n1 : listSingle) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listSingle>");
        }
        if (listDouble.size() > 0) {
            nodes.append("<listDouble>");
            for (java.lang.Double n1 : listDouble) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listDouble>");
        }
        if (listBoolean.size() > 0) {
            nodes.append("<listBoolean>");
            for (java.lang.Boolean n1 : listBoolean) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listBoolean>");
        }
        if (listString.size() > 0) {
            nodes.append("<listString>");
            for (java.lang.String n1 : listString) {
                nodes.append("<n1 value=\"");
                nodes.append(n1);
                nodes.append("\">");
            }
            nodes.append("</listString>");
        }
        if (listEnum.size() > 0) {
            nodes.append("<listEnum>");
            for (Gender n1 : listEnum) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listEnum>");
        }
        if (listStruct.size() > 0) {
            nodes.append("<listStruct>");
            for (Custom n1 : listStruct) {
                nodes.append(n1.toStringXML("n1"));
            }
            nodes.append("</listStruct>");
        }
        result.append("<"); result.append(name); result.append(attrs);
        if (nodes.length() == 0) {
            result.append("/>");
        } else {
            result.append(">");
            result.append(nodes);
            result.append("</"); result.append(name); result.append(">");
        }
        return result;
    } //TestList::toStringXML (String name)

    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        result.append(getClass().getName());
        result.append(", listI08:");
        result.append("(" + listI08.size() + ")");
        result.append(", listI16:");
        result.append("(" + listI16.size() + ")");
        result.append(", listI32:");
        result.append("(" + listI32.size() + ")");
        result.append(", listI64:");
        result.append("(" + listI64.size() + ")");
        result.append(", listU08:");
        result.append("(" + listU08.size() + ")");
        result.append(", listU16:");
        result.append("(" + listU16.size() + ")");
        result.append(", listU32:");
        result.append("(" + listU32.size() + ")");
        result.append(", listU64:");
        result.append("(" + listU64.size() + ")");
        result.append(", listSingle:");
        result.append("(" + listSingle.size() + ")");
        result.append(", listDouble:");
        result.append("(" + listDouble.size() + ")");
        result.append(", listBoolean:");
        result.append("(" + listBoolean.size() + ")");
        result.append(", listString:");
        result.append("(" + listString.size() + ")");
        result.append(", listEnum:");
        result.append("(" + listEnum.size() + ")");
        result.append(", listStruct:");
        result.append("(" + listStruct.size() + ")");
        result.append(" }");
        return result.toString();
    } //TestList::toString ()

}

