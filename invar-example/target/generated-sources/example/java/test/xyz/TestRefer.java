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
import java.math.BigInteger/*U64*/;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import test.abc.Custom;
import test.abc.Gender;

/** 引用类型测试 */
public final class TestRefer
implements
invar.lib.InvarCodec.BinaryDecode,
invar.lib.InvarCodec.BinaryEncode,
invar.lib.InvarCodec.XMLEncode,
invar.lib.InvarCodec.JSONEncode
{
    static public final long CRC32 = 0xBBD63AFDL;

    static public TestRefer Create()
    {
        return new TestRefer();
    }

    private Byte                     numberi08   ;
    private Short                    numberi16   ;
    private Integer                  numberi32   ;
    private Long                     numberi64   ;
    private Short/*U08*/             numberu08   ;
    private Integer/*U16*/           numberu16   ;
    private Long/*U32*/              numberu32   ;
    private BigInteger/*U64*/        numberu64   ;
    private Float                    numberSingle;
    private Double                   numberDouble;
    private Boolean                  boolValue   ;
    private String                   stringValue ;
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
        numberu64    = BigInteger.valueOf(0L);
        numberSingle = 0.0F;
        numberDouble = 0.00;
        boolValue    = false;
        stringValue  = "";
        enumValue    = Gender.NONE;
        other        = Custom.Create();
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
        numberu64 = BigInteger.valueOf(0L);
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
    @invar.lib.InvarRule(T="int8", S="f0")
    public Byte getNumberi08() { return numberi08; }
    /**  */
    @invar.lib.InvarRule(T="int16", S="f1")
    public Short getNumberi16() { return numberi16; }
    /**  */
    @invar.lib.InvarRule(T="int32", S="f2")
    public Integer getNumberi32() { return numberi32; }
    /**  */
    @invar.lib.InvarRule(T="int64", S="f3")
    public Long getNumberi64() { return numberi64; }
    /**  */
    @invar.lib.InvarRule(T="uint8", S="f4")
    public Short/*U08*/ getNumberu08() { return numberu08; }
    /**  */
    @invar.lib.InvarRule(T="uint16", S="f5")
    public Integer/*U16*/ getNumberu16() { return numberu16; }
    /**  */
    @invar.lib.InvarRule(T="uint32", S="f6")
    public Long/*U32*/ getNumberu32() { return numberu32; }
    /**  */
    @invar.lib.InvarRule(T="uint64", S="f7")
    public BigInteger/*U64*/ getNumberu64() { return numberu64; }
    /**  */
    @invar.lib.InvarRule(T="float", S="f8")
    public Float getNumberSingle() { return numberSingle; }
    /**  */
    @invar.lib.InvarRule(T="double", S="f9")
    public Double getNumberDouble() { return numberDouble; }
    /**  */
    @invar.lib.InvarRule(T="bool", S="f10")
    public Boolean getBoolValue() { return boolValue; }
    /**  */
    @invar.lib.InvarRule(T="string", S="f11")
    public String getStringValue() { return stringValue; }
    /**  */
    @invar.lib.InvarRule(T="test.abc.Gender", S="f12")
    public Gender getEnumValue() { return enumValue; }
    public Integer getEnumValueV() { return enumValue.value(); }
    /**  */
    @invar.lib.InvarRule(T="test.abc.Custom", S="f13")
    public Custom getOther() { return other; }
    /**  */
    @invar.lib.InvarRule(T="test.xyz.TestRefer", S="f14")
    public TestRefer getSelf() { return self; }
    /**  */
    @invar.lib.InvarRule(T="vec<int8>", S="f15")
    public LinkedList<java.lang.Byte> getListI08() { return listI08; }
    /**  */
    @invar.lib.InvarRule(T="map<int8,int8>", S="f16")
    public LinkedHashMap<java.lang.Byte,java.lang.Byte> getDictI08() { return dictI08; }

    /**  */
    @invar.lib.InvarRule(T="int8", S="f0")
    public void setNumberi08(Byte value)
    {
        setNumberi08(value.intValue());
    }
    public void setNumberi08(int value) throws NumberFormatException
    {
        if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
            throw new NumberFormatException("int8 value out of range: " + value);
        }
        this.numberi08 = Integer.valueOf(value).byteValue();
    }
    /**  */
    @invar.lib.InvarRule(T="int16", S="f1")
    public void setNumberi16(Short value)
    {
        setNumberi16(value.intValue());
    }
    public void setNumberi16(int value) throws NumberFormatException
    {
        if (value < Short.MIN_VALUE || value > Short.MAX_VALUE) {
            throw new NumberFormatException("int16 value out of range: " + value);
        }
        this.numberi16 = Integer.valueOf(value).shortValue();
    }
    /**  */
    @invar.lib.InvarRule(T="int32", S="f2")
    public void setNumberi32(Integer value) { this.numberi32 = value; }
    /**  */
    @invar.lib.InvarRule(T="int64", S="f3")
    public void setNumberi64(Long value) { this.numberi64 = value; }
    /**  */
    @invar.lib.InvarRule(T="uint8", S="f4")
    public void setNumberu08(Short/*U08*/ value)
    {
        setNumberu08(value.intValue());
    }
    public void setNumberu08(int value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFF) {
            throw new NumberFormatException("uint8 value out of range: " + value);
        }
        this.numberu08 = Integer.valueOf(value).shortValue();
    }
    /**  */
    @invar.lib.InvarRule(T="uint16", S="f5")
    public void setNumberu16(Integer/*U16*/ value)
    {
        setNumberu16(value.intValue());
    }
    public void setNumberu16(int value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFFFF) {
            throw new NumberFormatException("uint16 value out of range: " + value);
        }
        this.numberu16 = value;
    }
    /**  */
    @invar.lib.InvarRule(T="uint32", S="f6")
    public void setNumberu32(Long/*U32*/ value)
    {
        setNumberu32(value.longValue());
    }
    public void setNumberu32(long value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFFFFFFFFL) {
            throw new NumberFormatException("uint32 value out of range: " + value);
        }
        this.numberu32 = value;
    }
    /**  */
    @invar.lib.InvarRule(T="uint64", S="f7")
    public void setNumberu64(BigInteger/*U64*/ value) throws NumberFormatException
    {
        if (invar.lib.InvarCodec.overRangeUInt64(value)) {
            throw new NumberFormatException("uint64 value out of range: " + value);
        }
        this.numberu64 = value;
    }
    /**  */
    @invar.lib.InvarRule(T="float", S="f8")
    public void setNumberSingle(Float value) { this.numberSingle = value; }
    /**  */
    @invar.lib.InvarRule(T="double", S="f9")
    public void setNumberDouble(Double value) { this.numberDouble = value; }
    /**  */
    @invar.lib.InvarRule(T="bool", S="f10")
    public void setBoolValue(Boolean value) { this.boolValue = value; }
    /**  */
    @invar.lib.InvarRule(T="string", S="f11")
    public void setStringValue(String value) { this.stringValue = value; }
    /**  */
    @invar.lib.InvarRule(T="test.abc.Gender", S="f12")
    public void setEnumValue(Gender value) { this.enumValue = value; }
    public void setEnumValueV(Integer value) { this.enumValue = Gender.valueOf(value); }
    /**  */
    @invar.lib.InvarRule(T="test.abc.Custom", S="f13")
    public void setOther(Custom value) { this.other = value; }
    /**  */
    @invar.lib.InvarRule(T="test.xyz.TestRefer", S="f14")
    public void setSelf(TestRefer value) { this.self = value; }

    /** Shallow copy */
    public TestRefer copy(TestRefer from_)
    {
        if (this == from_ || from_ == null) {
            return this;
        }
        numberi08 = from_.numberi08;
        numberi16 = from_.numberi16;
        numberi32 = from_.numberi32;
        numberi64 = from_.numberi64;
        numberu08 = from_.numberu08;
        numberu16 = from_.numberu16;
        numberu32 = from_.numberu32;
        numberu64 = from_.numberu64;
        numberSingle = from_.numberSingle;
        numberDouble = from_.numberDouble;
        boolValue = from_.boolValue;
        stringValue = from_.stringValue;
        enumValue = from_.enumValue;
        other = from_.other;
        if (from_.self != null) {
            self.copy(from_.self);
        } else {
            self = null;
        }
        listI08.clear();
        listI08.addAll(from_.listI08);
        dictI08.clear();
        dictI08.putAll(from_.dictI08);
        return this;
    } /* copyFrom(...) */

    public void read(InputStream from_) throws IOException, CodecError
    {
        this.read((DataInput)new DataInputStream(from_));
    }

    public void read(DataInput from_) throws IOException, CodecError
    {
        numberi08 = from_.readByte();
        numberi16 = from_.readShort();
        numberi32 = from_.readInt();
        numberi64 = from_.readLong();
        numberu08 = Integer.valueOf(from_.readUnsignedByte()).shortValue();
        numberu16 = from_.readUnsignedShort();
        numberu32 = from_.readInt() & 0xFFFFFFFFL;
        byte[] numberu64Bytes = new byte[8]; from_.readFully(numberu64Bytes, 0, 8);
        numberu64 = new BigInteger/*U64*/(1, numberu64Bytes);
        numberSingle = from_.readFloat();
        numberDouble = from_.readDouble();
        boolValue = from_.readBoolean();
        stringValue = from_.readUTF();
        enumValue = Gender.valueOf(from_.readInt());
        other.read(from_);
        byte selfExists = from_.readByte();
        if ((byte)0x01 == selfExists) {
            if (self == null) { self = TestRefer.Create(); }
            self.read(from_);
        }
        else if ((byte)0x00 == selfExists) { self = null; }
        else { throw new CodecError(CodecError.ERR_DECODE_STRUCT_P); }
        listI08.clear();
        Long lenListI08 = from_.readInt() & 0xFFFFFFFFL;
        for (Long/*U32*/ iListI08 = 0L; iListI08 < lenListI08; ++iListI08) {
            java.lang.Byte n1 = from_.readByte();
            listI08.add(n1);
        }
        dictI08.clear();
        Long lenDictI08 = from_.readInt() & 0xFFFFFFFFL;
        for (Long/*U32*/ iDictI08 = 0L; iDictI08 < lenDictI08; ++iDictI08) {
            java.lang.Byte k1 = from_.readByte();
            java.lang.Byte v1 = from_.readByte();
            dictI08.put(k1,v1);
        }
    }

    public void write(OutputStream dest_) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(dest_));
    }

    public void write(DataOutput dest_) throws IOException
    {
        dest_.writeByte(numberi08);
        dest_.writeShort(numberi16);
        dest_.writeInt(numberi32);
        dest_.writeLong(numberi64);
        dest_.writeByte(numberu08);
        dest_.writeShort(numberu16);
        dest_.writeInt(numberu32.intValue());
        dest_.writeLong(numberu64.longValue());
        dest_.writeFloat(numberSingle);
        dest_.writeDouble(numberDouble);
        dest_.writeBoolean(boolValue);
        dest_.writeUTF(stringValue);
        dest_.writeInt(enumValue.value());
        other.write(dest_);
        if (self != null) {
            dest_.writeByte((byte)0x01);
            self.write(dest_);
        } else {
            dest_.writeByte((byte)0x00);
        }
        dest_.writeInt(listI08.size());
        for (java.lang.Byte n1 : listI08) {
            dest_.writeByte(n1);
        }
        dest_.writeInt(dictI08.size());
        for (Map.Entry<java.lang.Byte,java.lang.Byte> dictI08Iter : dictI08.entrySet()) {
            java.lang.Byte k1 = dictI08Iter.getKey();
            dest_.writeByte(k1);
            java.lang.Byte v1 = dictI08Iter.getValue();
            dest_.writeByte(v1);
        }
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append('{');
        s.append(getClass().getName());
        s.append(',').append("numberi08").append(':');
        s.append(numberi08.toString());
        s.append(',').append("numberi16").append(':');
        s.append(numberi16.toString());
        s.append(',').append("numberi32").append(':');
        s.append(numberi32.toString());
        s.append(',').append("numberi64").append(':');
        s.append(numberi64.toString());
        s.append(',').append("numberu08").append(':');
        s.append(numberu08.toString());
        s.append(',').append("numberu16").append(':');
        s.append(numberu16.toString());
        s.append(',').append("numberu32").append(':');
        s.append(numberu32.toString());
        s.append(',').append("numberu64").append(':');
        s.append(numberu64.toString());
        s.append(',').append("numberSingle").append(':');
        s.append(numberSingle.toString());
        s.append(',').append("numberDouble").append(':');
        s.append(numberDouble.toString());
        s.append(',').append("boolValue").append(':');
        s.append(boolValue.toString());
        s.append(',').append("stringValue").append(':');
        s.append('"').append(stringValue).append('"');
        s.append(',').append("enumValue").append(':');
        s.append(enumValue.toString());
        s.append(',').append("other").append(':');
        s.append('<').append("Custom").append('>');
        s.append(", self:");
        if (self != null) {
            s.append('<').append("TestRefer").append('>');
        } else {
            s.append("null");
        }
        s.append(',').append("listI08").append(':');
        s.append('(').append(listI08.size()).append(')');
        s.append(',').append("dictI08").append(':');
        s.append('[').append(dictI08.size()).append(']');
        s.append('}');
        return s.toString();
    } //TestRefer::toString ()

    public String toStringJSON()
    {
        StringBuilder code = new StringBuilder();
        this.writeJSON(code);
        return code.toString();
    }

    public void writeJSON(StringBuilder s_)
    {
        s_.append('{');
        char comma = '\0';
        s_.append('"').append("numberi08").append('"').append(':');
        s_.append(numberi08.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("numberi16").append('"').append(':');
        s_.append(numberi16.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("numberi32").append('"').append(':');
        s_.append(numberi32.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("numberi64").append('"').append(':');
        s_.append(numberi64.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("numberu08").append('"').append(':');
        s_.append(numberu08.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("numberu16").append('"').append(':');
        s_.append(numberu16.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("numberu32").append('"').append(':');
        s_.append(numberu32.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("numberu64").append('"').append(':');
        s_.append(numberu64.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("numberSingle").append('"').append(':');
        s_.append(numberSingle.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("numberDouble").append('"').append(':');
        s_.append(numberDouble.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("boolValue").append('"').append(':');
        s_.append(boolValue.toString().toLowerCase()); comma = ',';
        boolean stringValueExists = stringValue != null && stringValue.length() > 0;
        if ('\0' != comma && stringValueExists) { s_.append(comma); comma = '\0'; }
        if (stringValueExists) {
            s_.append('"').append("stringValue").append('"').append(':'); comma = ','; s_.append('"').append(stringValue.toString()).append('"');
        }
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("enumValue").append('"').append(':');
        s_.append(enumValue.value()); comma = ',';
        boolean otherExists = (null != other);
        if ('\0' != comma && otherExists) { s_.append(comma); comma = '\0'; }
        if (otherExists) {
            s_.append('"').append("other").append('"').append(':'); comma = ','; other.writeJSON(s_);
        }
        boolean selfExists = (null != self);
        if ('\0' != comma && selfExists) { s_.append(comma); comma = '\0'; }
        if (selfExists) {
            s_.append('"').append("self").append('"').append(':'); comma = ','; self.writeJSON(s_);
        }
        boolean listI08Exists = (null != listI08);
        if ('\0' != comma && listI08Exists) { s_.append(comma); comma = '\0'; }
        if (listI08Exists) { s_.append('"').append("listI08").append('"').append(':'); comma = ','; }
        if (null != listI08) {
            s_.append('[');
            int listI08Size = listI08.size();
            int listI08Idx = 0;
            for (java.lang.Byte n1 : listI08) { /* vec.for: listI08 */
                ++listI08Idx;
                s_.append(n1.toString());
                if (listI08Idx != listI08Size) { s_.append(','); }
            }
            s_.append(']');
        }
        boolean dictI08Exists = (null != dictI08);
        if ('\0' != comma && dictI08Exists) { s_.append(comma); comma = '\0'; }
        if (dictI08Exists) { s_.append('"').append("dictI08").append('"').append(':'); comma = ','; }
        if (null != dictI08) {
            s_.append('{');
            int dictI08Size = dictI08.size();
            int dictI08Idx = 0;
            for (Map.Entry<java.lang.Byte,java.lang.Byte> dictI08Iter : dictI08.entrySet()) { /* map.for: dictI08 */
                ++dictI08Idx;
                java.lang.Byte k1 = dictI08Iter.getKey(); /* nest.k */
                s_.append('"'); s_.append(k1.toString()); s_.append('"').append(':');
                java.lang.Byte v1 = dictI08Iter.getValue(); /* nest.v */
                s_.append(v1.toString());
                if (dictI08Idx != dictI08Size) { s_.append(','); }
            }
            s_.append('}');
        }
        s_.append('}');
    } /* TestRefer::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "TestRefer");
        return code.toString();
    }

    public void writeXML(StringBuilder result_, String name_)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.append(' ').append("numberi08").append('=').append('"');
        attrs.append(numberi08.toString()).append('"');
        attrs.append(' ').append("numberi16").append('=').append('"');
        attrs.append(numberi16.toString()).append('"');
        attrs.append(' ').append("numberi32").append('=').append('"');
        attrs.append(numberi32.toString()).append('"');
        attrs.append(' ').append("numberi64").append('=').append('"');
        attrs.append(numberi64.toString()).append('"');
        attrs.append(' ').append("numberu08").append('=').append('"');
        attrs.append(numberu08.toString()).append('"');
        attrs.append(' ').append("numberu16").append('=').append('"');
        attrs.append(numberu16.toString()).append('"');
        attrs.append(' ').append("numberu32").append('=').append('"');
        attrs.append(numberu32.toString()).append('"');
        attrs.append(' ').append("numberu64").append('=').append('"');
        attrs.append(numberu64.toString()).append('"');
        attrs.append(' ').append("numberSingle").append('=').append('"');
        attrs.append(numberSingle.toString()).append('"');
        attrs.append(' ').append("numberDouble").append('=').append('"');
        attrs.append(numberDouble.toString()).append('"');
        attrs.append(' ').append("boolValue").append('=').append('"');
        attrs.append(boolValue.toString()).append('"');
        attrs.append(' ').append("stringValue").append('=').append('"');
        attrs.append(stringValue).append('"');
        attrs.append(' ').append("enumValue").append('=').append('"');
        attrs.append(enumValue.value()).append('"');
        other.writeXML(nodes, "other");
        if (self != null) {
            self.writeXML(nodes, "self");
        }
        if (listI08.size() > 0) {
            nodes.append('<').append("listI08").append('>');
            for (java.lang.Byte n1 : listI08) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("listI08").append('>');
        }
        if (dictI08.size() > 0) {
            nodes.append('<').append("dictI08").append('>');
            for (Map.Entry<java.lang.Byte,java.lang.Byte> dictI08Iter : dictI08.entrySet()) {
                java.lang.Byte k1 = dictI08Iter.getKey();
                nodes.append('<').append("k1").append(' ').append("value").append('=').append('"');
                nodes.append(k1.toString()).append('"').append('/').append('>');
                java.lang.Byte v1 = dictI08Iter.getValue();
                nodes.append('<').append("v1").append(' ').append("value").append('=').append('"');
                nodes.append(v1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("dictI08").append('>');
        }
        result_.append('<').append(name_).append(attrs);
        if (nodes.length() == 0) {
            result_.append('/').append('>');
        } else {
            result_.append('>').append(nodes);
            result_.append('<').append('/').append(name_).append('>');
        }
    } /* TestRefer::writeXML(...) */

}

