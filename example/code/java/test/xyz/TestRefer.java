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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import test.abc.Custom;
import test.abc.Gender;

/** 引用类型测试 */
public final class TestRefer
implements
invar.InvarCodec.BinaryDecode,
invar.InvarCodec.BinaryEncode,
invar.InvarCodec.XMLEncode
{
    static public TestRefer Create() { return new TestRefer(); }

    static public final long CRC32 = 0xBBD63AFD;

    private java.lang.Byte           numberi08   ;
    private Short                    numberi16   ;
    private Integer                  numberi32   ;
    private Long                     numberi64   ;
    private java.lang.Integer        numberu08   ;
    private java.lang.Integer        numberu16   ;
    private java.lang.Long           numberu32   ;
    private BigInteger               numberu64   ;
    private Float                    numberSingle;
    private java.lang.Double         numberDouble;
    private java.lang.Boolean        boolValue   ;
    private java.lang.String         stringValue ;
    private Gender                   enumValue   ;
    private Custom                   other       ;
    private TestRefer                self        ;
    private LinkedList<Byte>         listI08     ;
    private LinkedHashMap<Byte,Byte> dictI08     ;

    public TestRefer()
    {
        numberi08    = -1;
        numberi16    = -1;
        numberi32    = -1;
        numberi64    = -1L;
        numberu08    = 0;
        numberu16    = 0;
        numberu32    = 0L;
        numberu64    = new BigInteger("0", 10);
        numberSingle = 0.0F;
        numberDouble = 0.00;
        boolValue    = false;
        stringValue  = "";
        enumValue    = Gender.NONE;
        other        = new Custom();
        self         = null;
        listI08      = new LinkedList<Byte>();
        dictI08      = new LinkedHashMap<Byte,Byte>();
    }

    public TestRefer reuse()
    {
        numberi08 = -1;
        numberi16 = -1;
        numberi32 = -1;
        numberi64 = -1L;
        numberu08 = 0;
        numberu16 = 0;
        numberu32 = 0L;
        numberu64 = new BigInteger("0", 10);
        numberSingle = 0.0F;
        numberDouble = 0.00;
        boolValue = false;
        stringValue = "";
        enumValue = Gender.NONE;
        other.reuse();
        if (self != null) {
            self.reuse();
        }
        listI08.clear();
        dictI08.clear();
        return this;
    }

    /**  */
    @invar.InvarRule(T="int8", S="f0")
    public java.lang.Byte getNumberi08() { return numberi08; }

    /**  */
    @invar.InvarRule(T="int16", S="f1")
    public Short getNumberi16() { return numberi16; }

    /**  */
    @invar.InvarRule(T="int32", S="f2")
    public Integer getNumberi32() { return numberi32; }

    /**  */
    @invar.InvarRule(T="int64", S="f3")
    public Long getNumberi64() { return numberi64; }

    /**  */
    @invar.InvarRule(T="uint8", S="f4")
    public java.lang.Integer getNumberu08() { return numberu08; }

    /**  */
    @invar.InvarRule(T="uint16", S="f5")
    public java.lang.Integer getNumberu16() { return numberu16; }

    /**  */
    @invar.InvarRule(T="uint32", S="f6")
    public java.lang.Long getNumberu32() { return numberu32; }

    /**  */
    @invar.InvarRule(T="uint64", S="f7")
    public BigInteger getNumberu64() { return numberu64; }

    /**  */
    @invar.InvarRule(T="float", S="f8")
    public Float getNumberSingle() { return numberSingle; }

    /**  */
    @invar.InvarRule(T="double", S="f9")
    public java.lang.Double getNumberDouble() { return numberDouble; }

    /**  */
    @invar.InvarRule(T="bool", S="f10")
    public java.lang.Boolean getBoolValue() { return boolValue; }

    /**  */
    @invar.InvarRule(T="string", S="f11")
    public java.lang.String getStringValue() { return stringValue; }

    /**  */
    @invar.InvarRule(T="test.abc.Gender", S="f12")
    public Gender getEnumValue() { return enumValue; }

    /**  */
    @invar.InvarRule(T="test.abc.Custom", S="f13")
    public Custom getOther() { return other; }

    /**  */
    @invar.InvarRule(T="test.xyz.TestRefer", S="f14")
    public TestRefer getSelf() { return self; }

    /**  */
    @invar.InvarRule(T="vec<int8>", S="f15")
    public LinkedList<Byte> getListI08() { return listI08; }

    /**  */
    @invar.InvarRule(T="map<int8,int8>", S="f16")
    public LinkedHashMap<Byte,Byte> getDictI08() { return dictI08; }

    /**  */
    @invar.InvarRule(T="int8", S="f0")
    public TestRefer setNumberi08(java.lang.Byte value) { this.numberi08 = value; return this; }

    /**  */
    @invar.InvarRule(T="int16", S="f1")
    public TestRefer setNumberi16(Short value) { this.numberi16 = value; return this; }

    /**  */
    @invar.InvarRule(T="int32", S="f2")
    public TestRefer setNumberi32(Integer value) { this.numberi32 = value; return this; }

    /**  */
    @invar.InvarRule(T="int64", S="f3")
    public TestRefer setNumberi64(Long value) { this.numberi64 = value; return this; }

    /**  */
    @invar.InvarRule(T="uint8", S="f4")
    public TestRefer setNumberu08(java.lang.Integer value) { this.numberu08 = value; return this; }

    /**  */
    @invar.InvarRule(T="uint16", S="f5")
    public TestRefer setNumberu16(java.lang.Integer value) { this.numberu16 = value; return this; }

    /**  */
    @invar.InvarRule(T="uint32", S="f6")
    public TestRefer setNumberu32(java.lang.Long value) { this.numberu32 = value; return this; }

    /**  */
    @invar.InvarRule(T="uint64", S="f7")
    public TestRefer setNumberu64(BigInteger value) { this.numberu64 = value; return this; }

    /**  */
    @invar.InvarRule(T="float", S="f8")
    public TestRefer setNumberSingle(Float value) { this.numberSingle = value; return this; }

    /**  */
    @invar.InvarRule(T="double", S="f9")
    public TestRefer setNumberDouble(java.lang.Double value) { this.numberDouble = value; return this; }

    /**  */
    @invar.InvarRule(T="bool", S="f10")
    public TestRefer setBoolValue(java.lang.Boolean value) { this.boolValue = value; return this; }

    /**  */
    @invar.InvarRule(T="string", S="f11")
    public TestRefer setStringValue(java.lang.String value) { this.stringValue = value; return this; }

    /**  */
    @invar.InvarRule(T="test.abc.Gender", S="f12")
    public TestRefer setEnumValue(Gender value) { this.enumValue = value; return this; }

    /**  */
    @invar.InvarRule(T="test.abc.Custom", S="f13")
    public TestRefer setOther(Custom value) { this.other = value; return this; }

    /**  */
    @invar.InvarRule(T="test.xyz.TestRefer", S="f14")
    public TestRefer setSelf(TestRefer value) { this.self = value; return this; }

    public TestRefer copy (TestRefer from)
    {
        if (this == from || from == null) {
            return this;
        }
        numberi08 = from.numberi08;
        numberi16 = from.numberi16;
        numberi32 = from.numberi32;
        numberi64 = from.numberi64;
        numberu08 = from.numberu08;
        numberu16 = from.numberu16;
        numberu32 = from.numberu32;
        numberu64 = from.numberu64;
        numberSingle = from.numberSingle;
        numberDouble = from.numberDouble;
        boolValue = from.boolValue;
        stringValue = from.stringValue;
        enumValue = from.enumValue;
        other = from.other;
        if (from.self != null) {
            self.copy(from.self);
        } else {
            self = null;
        }
        listI08.clear();
        listI08.addAll(from.listI08);
        dictI08.clear();
        dictI08.putAll(from.dictI08);
        return this;
    } //copyFrom(...)

    public void read(InputStream from) throws IOException
    {
        this.read((DataInput)new DataInputStream(from));
    }

    public void read(DataInput from) throws IOException
    {
        numberi08 = from.readByte();
        numberi16 = from.readShort();
        numberi32 = from.readInt();
        numberi64 = from.readLong();
        numberu08 = from.readUnsignedByte();
        numberu16 = from.readUnsignedShort();
        numberu32 = from.readInt() & 0xFFFFFFFFL;
        byte[] numberu64Bytes = new byte[8]; from.readFully(numberu64Bytes, 0, 8);
        numberu64 = new BigInteger(numberu64Bytes);
        numberSingle = from.readFloat();
        numberDouble = from.readDouble();
        boolValue = from.readBoolean();
        stringValue = from.readUTF();
        enumValue = Gender.valueOf(from.readInt());
        other.read(from);
        if (from.readByte() == (byte)0x01) {
            self.read(from);
        }
        listI08.clear();
        Long lenListI08 = from.readInt() & 0xFFFFFFFFL;
        for (Long iListI08 = 0L; iListI08 < lenListI08; ++iListI08) {
            java.lang.Byte n1 = from.readByte();
            listI08.add(n1);
        }
        dictI08.clear();
        Long lenDictI08 = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictI08 = 0L; iDictI08 < lenDictI08; ++iDictI08) {
            java.lang.Byte k1 = from.readByte();
            java.lang.Byte v1 = from.readByte();
            dictI08.put(k1,v1);
        }
    }

    public void write(OutputStream from) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(from));
    }

    public void write(DataOutput dest) throws IOException
    {
        dest.writeByte(numberi08);
        dest.writeShort(numberi16);
        dest.writeInt(numberi32);
        dest.writeLong(numberi64);
        dest.writeByte(numberu08);
        dest.writeShort(numberu16);
        dest.writeInt(numberu32.intValue());
        dest.writeLong(numberu64.longValue());
        dest.writeFloat(numberSingle);
        dest.writeDouble(numberDouble);
        dest.writeBoolean(boolValue);
        dest.writeUTF(stringValue);
        dest.writeInt(enumValue.getValue());
        other.write(dest);
        if (self != null) {
            dest.writeByte((byte)0x01);
            self.write(dest);
        } else {
            dest.writeByte((byte)0x00);
        }
        dest.writeInt(listI08.size());
        for (java.lang.Byte n1 : listI08) {
            dest.writeByte(n1);
        }
        dest.writeInt(dictI08.size());
        for (Map.Entry<java.lang.Byte,java.lang.Byte> dictI08Iter : dictI08.entrySet()) {
            java.lang.Byte k1 = dictI08Iter.getKey();
            dest.writeByte(k1);
            java.lang.Byte v1 = dictI08Iter.getValue();
            dest.writeByte(v1);
        }
    }

    public StringBuilder toStringXML (String name)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes  = new StringBuilder();
        attrs.append(" numberi08=\"");
        attrs.append(numberi08.toString()); attrs.append("\"");
        attrs.append(" numberi16=\"");
        attrs.append(numberi16.toString()); attrs.append("\"");
        attrs.append(" numberi32=\"");
        attrs.append(numberi32.toString()); attrs.append("\"");
        attrs.append(" numberi64=\"");
        attrs.append(numberi64.toString()); attrs.append("\"");
        attrs.append(" numberu08=\"");
        attrs.append(numberu08.toString()); attrs.append("\"");
        attrs.append(" numberu16=\"");
        attrs.append(numberu16.toString()); attrs.append("\"");
        attrs.append(" numberu32=\"");
        attrs.append(numberu32.toString()); attrs.append("\"");
        attrs.append(" numberu64=\"");
        attrs.append(numberu64.toString()); attrs.append("\"");
        attrs.append(" numberSingle=\"");
        attrs.append(numberSingle.toString()); attrs.append("\"");
        attrs.append(" numberDouble=\"");
        attrs.append(numberDouble.toString()); attrs.append("\"");
        attrs.append(" boolValue=\"");
        attrs.append(boolValue.toString()); attrs.append("\"");
        attrs.append(" stringValue=\"");
        attrs.append(stringValue); attrs.append("\"");
        attrs.append(" enumValue=\"");
        attrs.append(enumValue.toString()); attrs.append("\"");
        nodes.append(other.toStringXML("other"));
        if (self != null) {
            nodes.append(self.toStringXML("self"));
        }
        if (listI08.size() > 0) {
            nodes.append("<listI08>");
            for (java.lang.Byte n1 : listI08) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</listI08>");
        }
        if (dictI08.size() > 0) {
            nodes.append("<dictI08>");
            for (Map.Entry<java.lang.Byte,java.lang.Byte> dictI08Iter : dictI08.entrySet()) {
                java.lang.Byte k1 = dictI08Iter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                java.lang.Byte v1 = dictI08Iter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictI08>");
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
    } //TestRefer::toStringXML (String name)

    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        result.append(getClass().getName());
        result.append(", numberi08:");
        result.append(numberi08.toString());
        result.append(", numberi16:");
        result.append(numberi16.toString());
        result.append(", numberi32:");
        result.append(numberi32.toString());
        result.append(", numberi64:");
        result.append(numberi64.toString());
        result.append(", numberu08:");
        result.append(numberu08.toString());
        result.append(", numberu16:");
        result.append(numberu16.toString());
        result.append(", numberu32:");
        result.append(numberu32.toString());
        result.append(", numberu64:");
        result.append(numberu64.toString());
        result.append(", numberSingle:");
        result.append(numberSingle.toString());
        result.append(", numberDouble:");
        result.append(numberDouble.toString());
        result.append(", boolValue:");
        result.append(boolValue.toString());
        result.append(", stringValue:");
        result.append("\"" + stringValue + "\"");
        result.append(", enumValue:");
        result.append(enumValue.toString());
        result.append(", other:");
        result.append("<Custom>");
        result.append(", self:");
        if (self != null) {
            result.append("<TestRefer>");
        } else {
            result.append("null");
        }
        result.append(", listI08:");
        result.append("(" + listI08.size() + ")");
        result.append(", dictI08:");
        result.append("[" + dictI08.size() + "]");
        result.append(" }");
        return result.toString();
    } //TestRefer::toString ()

}

