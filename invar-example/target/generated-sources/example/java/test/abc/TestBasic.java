/*===----------------------------*  Java 6  *------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.abc;

import invar.lib.CodecError;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;

/** 基础类型 */
public final class TestBasic
implements
invar.lib.InvarCodec.BinaryDecode,
invar.lib.InvarCodec.BinaryEncode,
invar.lib.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0xF60C9915L;

    static public TestBasic Create()
    {
        return new TestBasic();
    }

    private Byte       numberI08   ;/* 有符号的8位整数 */
    private Short      numberI16   ;/* 有符号的16位整数 */
    private Integer    numberI32   ;/* 有符号的32位整数 */
    private Long       numberI64   ;/* 有符号的64位整数 */
    private Integer    numberU08   ;/* 无符号的8位整数 */
    private Integer    numberU16   ;/* 无符号的16位整数 */
    private Long       numberU32   ;/* 无符号的32位整数 */
    private BigInteger numberU64   ;/* 无符号的64位整数 */
    private Float      numberSingle;/* 单精度浮点小数 */
    private Double     numberDouble;/* 双精度浮点小数 */
    private Boolean    boolValue   ;/* 布尔值 */
    private String     stringValue ;/* 字符串 */
    private Gender     enumValue   ;/* 枚举值 */
    private Gender     enumDeft    ;/* 枚举值制定默认值 */

    public TestBasic()
    {
        numberI08    = -128;
        numberI16    = -32768;
        numberI32    = -2147483648;
        numberI64    = -9223372036854774808L;
        numberU08    = 255;
        numberU16    = 65535;
        numberU32    = 4294967295L;
        numberU64    = BigInteger.valueOf(0L);
        numberSingle = 3.14159F;
        numberDouble = 3.1415926;
        boolValue    = false;
        stringValue  = "hello世界";
        enumValue    = Gender.NONE;
        enumDeft     = Gender.MALE;
    }

    public TestBasic reuse()
    {
        numberI08 = -128;
        numberI16 = -32768;
        numberI32 = -2147483648;
        numberI64 = -9223372036854774808L;
        numberU08 = 255;
        numberU16 = 65535;
        numberU32 = 4294967295L;
        numberU64 = BigInteger.valueOf(0L);
        numberSingle = 3.14159F;
        numberDouble = 3.1415926;
        boolValue = false;
        stringValue = "hello世界";
        enumValue = Gender.NONE;
        enumDeft = Gender.MALE;
        return this;
    }

    /** 有符号的8位整数 */
    @invar.lib.InvarRule(T="int8", S="f0")
    public Byte getNumberI08() { return numberI08; }
    /** 有符号的16位整数 */
    @invar.lib.InvarRule(T="int16", S="f1")
    public Short getNumberI16() { return numberI16; }
    /** 有符号的32位整数 */
    @invar.lib.InvarRule(T="int32", S="f2")
    public Integer getNumberI32() { return numberI32; }
    /** 有符号的64位整数 */
    @invar.lib.InvarRule(T="int64", S="f3")
    public Long getNumberI64() { return numberI64; }
    /** 无符号的8位整数 */
    @invar.lib.InvarRule(T="uint8", S="f4")
    public Integer getNumberU08() { return numberU08; }
    /** 无符号的16位整数 */
    @invar.lib.InvarRule(T="uint16", S="f5")
    public Integer getNumberU16() { return numberU16; }
    /** 无符号的32位整数 */
    @invar.lib.InvarRule(T="uint32", S="f6")
    public Long getNumberU32() { return numberU32; }
    /** 无符号的64位整数 */
    @invar.lib.InvarRule(T="uint64", S="f7")
    public BigInteger getNumberU64() { return numberU64; }
    /** 单精度浮点小数 */
    @invar.lib.InvarRule(T="float", S="f8")
    public Float getNumberSingle() { return numberSingle; }
    /** 双精度浮点小数 */
    @invar.lib.InvarRule(T="double", S="f9")
    public Double getNumberDouble() { return numberDouble; }
    /** 布尔值 */
    @invar.lib.InvarRule(T="bool", S="f10")
    public Boolean getBoolValue() { return boolValue; }
    /** 字符串 */
    @invar.lib.InvarRule(T="string", S="f11")
    public String getStringValue() { return stringValue; }
    /** 枚举值 */
    @invar.lib.InvarRule(T="test.abc.Gender", S="f12")
    public Gender getEnumValue() { return enumValue; }
    public Integer getEnumValueV() { return enumValue.value(); }
    /** 枚举值制定默认值 */
    @invar.lib.InvarRule(T="test.abc.Gender", S="f13")
    public Gender getEnumDeft() { return enumDeft; }
    public Integer getEnumDeftV() { return enumDeft.value(); }

    /** 有符号的8位整数 */
    @invar.lib.InvarRule(T="int8", S="f0")
    public void setNumberI08(Byte value) { this.numberI08 = value; }
    public void setNumberI08(int value) throws NumberFormatException
    {
        if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
            throw new NumberFormatException("int8 value out of range: " + value);
        }
        this.numberI08 = Integer.valueOf(value).byteValue();
    }
    /** 有符号的16位整数 */
    @invar.lib.InvarRule(T="int16", S="f1")
    public void setNumberI16(Short value) { this.numberI16 = value; }
    public void setNumberI16(int value) throws NumberFormatException
    {
        if (value < Short.MIN_VALUE || value > Short.MAX_VALUE) {
            throw new NumberFormatException("int16 value out of range: " + value);
        }
        this.numberI16 = Integer.valueOf(value).shortValue();
    }
    /** 有符号的32位整数 */
    @invar.lib.InvarRule(T="int32", S="f2")
    public void setNumberI32(Integer value) { this.numberI32 = value; }
    /** 有符号的64位整数 */
    @invar.lib.InvarRule(T="int64", S="f3")
    public void setNumberI64(Long value) { this.numberI64 = value; }
    /** 无符号的8位整数 */
    @invar.lib.InvarRule(T="uint8", S="f4")
    public void setNumberU08(int value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFF) {
            throw new NumberFormatException("uint8 value out of range: " + value);
        }
        this.numberU08 = value;
    }
    /** 无符号的16位整数 */
    @invar.lib.InvarRule(T="uint16", S="f5")
    public void setNumberU16(int value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFFFF) {
            throw new NumberFormatException("uint16 value out of range: " + value);
        }
        this.numberU16 = value;
    }
    /** 无符号的32位整数 */
    @invar.lib.InvarRule(T="uint32", S="f6")
    public void setNumberU32(long value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFFFFFFFFL) {
            throw new NumberFormatException("uint32 value out of range: " + value);
        }
        this.numberU32 = value;
    }
    /** 无符号的64位整数 */
    @invar.lib.InvarRule(T="uint64", S="f7")
    public void setNumberU64(BigInteger value) { this.numberU64 = value; }
    /** 单精度浮点小数 */
    @invar.lib.InvarRule(T="float", S="f8")
    public void setNumberSingle(Float value) { this.numberSingle = value; }
    /** 双精度浮点小数 */
    @invar.lib.InvarRule(T="double", S="f9")
    public void setNumberDouble(Double value) { this.numberDouble = value; }
    /** 布尔值 */
    @invar.lib.InvarRule(T="bool", S="f10")
    public void setBoolValue(Boolean value) { this.boolValue = value; }
    /** 字符串 */
    @invar.lib.InvarRule(T="string", S="f11")
    public void setStringValue(String value) { this.stringValue = value; }
    /** 枚举值 */
    @invar.lib.InvarRule(T="test.abc.Gender", S="f12")
    public void setEnumValue(Gender value) { this.enumValue = value; }
    public void setEnumValueV(int value) { this.enumValue = Gender.valueOf(value); }
    /** 枚举值制定默认值 */
    @invar.lib.InvarRule(T="test.abc.Gender", S="f13")
    public void setEnumDeft(Gender value) { this.enumDeft = value; }
    public void setEnumDeftV(int value) { this.enumDeft = Gender.valueOf(value); }

    /** Shallow copy */
    public TestBasic copy(TestBasic from)
    {
        if (this == from || from == null) {
            return this;
        }
        numberI08 = from.numberI08;
        numberI16 = from.numberI16;
        numberI32 = from.numberI32;
        numberI64 = from.numberI64;
        numberU08 = from.numberU08;
        numberU16 = from.numberU16;
        numberU32 = from.numberU32;
        numberU64 = from.numberU64;
        numberSingle = from.numberSingle;
        numberDouble = from.numberDouble;
        boolValue = from.boolValue;
        stringValue = from.stringValue;
        enumValue = from.enumValue;
        enumDeft = from.enumDeft;
        return this;
    } /* copyFrom(...) */

    public void read(InputStream from) throws IOException, CodecError
    {
        this.read((DataInput)new DataInputStream(from));
    }

    public void read(DataInput from) throws IOException, CodecError
    {
        numberI08 = from.readByte();
        numberI16 = from.readShort();
        numberI32 = from.readInt();
        numberI64 = from.readLong();
        numberU08 = from.readUnsignedByte();
        numberU16 = from.readUnsignedShort();
        numberU32 = from.readInt() & 0xFFFFFFFFL;
        byte[] numberU64Bytes = new byte[8]; from.readFully(numberU64Bytes, 0, 8);
        numberU64 = new BigInteger(1, numberU64Bytes);
        numberSingle = from.readFloat();
        numberDouble = from.readDouble();
        boolValue = from.readBoolean();
        stringValue = from.readUTF();
        enumValue = Gender.valueOf(from.readInt());
        enumDeft = Gender.valueOf(from.readInt());
    }

    public void write(OutputStream from) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(from));
    }

    public void write(DataOutput dest) throws IOException
    {
        dest.writeByte(numberI08);
        dest.writeShort(numberI16);
        dest.writeInt(numberI32);
        dest.writeLong(numberI64);
        dest.writeByte(numberU08);
        dest.writeShort(numberU16);
        dest.writeInt(numberU32.intValue());
        dest.writeLong(numberU64.longValue());
        dest.writeFloat(numberSingle);
        dest.writeDouble(numberDouble);
        dest.writeBoolean(boolValue);
        dest.writeUTF(stringValue);
        dest.writeInt(enumValue.value());
        dest.writeInt(enumDeft.value());
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append('{');
        s.append(getClass().getName());
        s.append(',').append("numberI08").append(':');
        s.append(numberI08.toString());
        s.append(',').append("numberI16").append(':');
        s.append(numberI16.toString());
        s.append(',').append("numberI32").append(':');
        s.append(numberI32.toString());
        s.append(',').append("numberI64").append(':');
        s.append(numberI64.toString());
        s.append(',').append("numberU08").append(':');
        s.append(numberU08.toString());
        s.append(',').append("numberU16").append(':');
        s.append(numberU16.toString());
        s.append(',').append("numberU32").append(':');
        s.append(numberU32.toString());
        s.append(',').append("numberU64").append(':');
        s.append(numberU64.toString());
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
        s.append(',').append("enumDeft").append(':');
        s.append(enumDeft.toString());
        s.append('}');
        return s.toString();
    } //TestBasic::toString ()

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
        s.append('"').append("numberI08").append('"').append(':');
        s.append(numberI08.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("numberI16").append('"').append(':');
        s.append(numberI16.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("numberI32").append('"').append(':');
        s.append(numberI32.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("numberI64").append('"').append(':');
        s.append(numberI64.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("numberU08").append('"').append(':');
        s.append(numberU08.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("numberU16").append('"').append(':');
        s.append(numberU16.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("numberU32").append('"').append(':');
        s.append(numberU32.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("numberU64").append('"').append(':');
        s.append(numberU64.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("numberSingle").append('"').append(':');
        s.append(numberSingle.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("numberDouble").append('"').append(':');
        s.append(numberDouble.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("boolValue").append('"').append(':');
        s.append(boolValue.toString().toLowerCase()); comma = ',';
        boolean stringValueExists = stringValue != null && stringValue.length() > 0;
        if ('\0' != comma && stringValueExists) { s.append(comma); comma = '\0'; }
        if (stringValueExists) {
            s.append('"').append("stringValue").append('"').append(':'); comma = ','; s.append('"').append(stringValue.toString()).append('"');
        }
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("enumValue").append('"').append(':');
        s.append(enumValue.value()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("enumDeft").append('"').append(':');
        s.append(enumDeft.value()); comma = ',';
        s.append('}');
    } /* TestBasic::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "TestBasic");
        return code.toString();
    }

    public void writeXML(StringBuilder result, String name)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.append(' ').append("numberI08").append('=').append('"');
        attrs.append(numberI08.toString()).append('"');
        attrs.append(' ').append("numberI16").append('=').append('"');
        attrs.append(numberI16.toString()).append('"');
        attrs.append(' ').append("numberI32").append('=').append('"');
        attrs.append(numberI32.toString()).append('"');
        attrs.append(' ').append("numberI64").append('=').append('"');
        attrs.append(numberI64.toString()).append('"');
        attrs.append(' ').append("numberU08").append('=').append('"');
        attrs.append(numberU08.toString()).append('"');
        attrs.append(' ').append("numberU16").append('=').append('"');
        attrs.append(numberU16.toString()).append('"');
        attrs.append(' ').append("numberU32").append('=').append('"');
        attrs.append(numberU32.toString()).append('"');
        attrs.append(' ').append("numberU64").append('=').append('"');
        attrs.append(numberU64.toString()).append('"');
        attrs.append(' ').append("numberSingle").append('=').append('"');
        attrs.append(numberSingle.toString()).append('"');
        attrs.append(' ').append("numberDouble").append('=').append('"');
        attrs.append(numberDouble.toString()).append('"');
        attrs.append(' ').append("boolValue").append('=').append('"');
        attrs.append(boolValue.toString()).append('"');
        attrs.append(' ').append("stringValue").append('=').append('"');
        attrs.append(stringValue).append('"');
        attrs.append(' ').append("enumValue").append('=').append('"');
        attrs.append(enumValue.toString()).append('"');
        attrs.append(' ').append("enumDeft").append('=').append('"');
        attrs.append(enumDeft.toString()).append('"');
        result.append('<').append(name).append(attrs);
        if (nodes.length() == 0) {
            result.append('/').append('>');
        } else {
            result.append('>').append(nodes);
            result.append('<').append('/').append(name).append('>');
        }
    } /* TestBasic::writeXML(...) */

}

