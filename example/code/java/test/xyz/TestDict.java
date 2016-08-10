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
import java.util.Map;
import test.abc.Custom;
import test.abc.Gender;

/** 测试基本的映射类型 */
public final class TestDict
implements
invar.InvarCodec.BinaryDecode,
invar.InvarCodec.BinaryEncode,
invar.InvarCodec.XMLEncode
{
    static public TestDict Create() { return new TestDict(); }

    static public final long CRC32 = 0x969046DE;

    private LinkedHashMap<Byte,Byte>             dictI08    ;/* 有符号的8位整数 */
    private LinkedHashMap<Short,Short>           dictI16    ;/* 有符号的16位整数 */
    private LinkedHashMap<Integer,Integer>       dictI32    ;/* 有符号的32位整数 */
    private LinkedHashMap<Long,Long>             dictI64    ;/* 有符号的64位整数 */
    private LinkedHashMap<Integer,Integer>       dictU08    ;/* 无符号的8位整数 */
    private LinkedHashMap<Integer,Integer>       dictU16    ;/* 无符号的16位整数 */
    private LinkedHashMap<Long,Long>             dictU32    ;/* 无符号的32位整数 */
    private LinkedHashMap<BigInteger,BigInteger> dictU64    ;/* 无符号的64位整数 */
    private LinkedHashMap<Float,Float>           dictSingle ;/* 单精度浮点小数 */
    private LinkedHashMap<Double,Double>         dictDouble ;/* 双精度浮点小数 */
    private LinkedHashMap<Boolean,Boolean>       dictBoolean;/* 布尔值 */
    private LinkedHashMap<String,String>         dictString ;/* 字符串 */
    private LinkedHashMap<Gender,Gender>         dictEnum   ;/* 枚举值 */
    private LinkedHashMap<Custom,Custom>         dictStruct ;/* 自定义结构 */
    private LinkedHashMap<String,String>         hotfix     ;/* [AutoAdd] Hotfix */

    public TestDict()
    {
        dictI08     = new LinkedHashMap<Byte,Byte>();
        dictI16     = new LinkedHashMap<Short,Short>();
        dictI32     = new LinkedHashMap<Integer,Integer>();
        dictI64     = new LinkedHashMap<Long,Long>();
        dictU08     = new LinkedHashMap<Integer,Integer>();
        dictU16     = new LinkedHashMap<Integer,Integer>();
        dictU32     = new LinkedHashMap<Long,Long>();
        dictU64     = new LinkedHashMap<BigInteger,BigInteger>();
        dictSingle  = new LinkedHashMap<Float,Float>();
        dictDouble  = new LinkedHashMap<Double,Double>();
        dictBoolean = new LinkedHashMap<Boolean,Boolean>();
        dictString  = new LinkedHashMap<String,String>();
        dictEnum    = new LinkedHashMap<Gender,Gender>();
        dictStruct  = new LinkedHashMap<Custom,Custom>();
        hotfix      = null;
    }

    public TestDict reuse()
    {
        dictI08.clear();
        dictI16.clear();
        dictI32.clear();
        dictI64.clear();
        dictU08.clear();
        dictU16.clear();
        dictU32.clear();
        dictU64.clear();
        dictSingle.clear();
        dictDouble.clear();
        dictBoolean.clear();
        dictString.clear();
        dictEnum.clear();
        dictStruct.clear();
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /** 有符号的8位整数 */
    @invar.InvarRule(T="map<int8,int8>", S="f0")
    public LinkedHashMap<Byte,Byte> getDictI08() { return dictI08; }

    /** 有符号的16位整数 */
    @invar.InvarRule(T="map<int16,int16>", S="f1")
    public LinkedHashMap<Short,Short> getDictI16() { return dictI16; }

    /** 有符号的32位整数 */
    @invar.InvarRule(T="map<int32,int32>", S="f2")
    public LinkedHashMap<Integer,Integer> getDictI32() { return dictI32; }

    /** 有符号的64位整数 */
    @invar.InvarRule(T="map<int64,int64>", S="f3")
    public LinkedHashMap<Long,Long> getDictI64() { return dictI64; }

    /** 无符号的8位整数 */
    @invar.InvarRule(T="map<uint8,uint8>", S="f4")
    public LinkedHashMap<Integer,Integer> getDictU08() { return dictU08; }

    /** 无符号的16位整数 */
    @invar.InvarRule(T="map<uint16,uint16>", S="f5")
    public LinkedHashMap<Integer,Integer> getDictU16() { return dictU16; }

    /** 无符号的32位整数 */
    @invar.InvarRule(T="map<uint32,uint32>", S="f6")
    public LinkedHashMap<Long,Long> getDictU32() { return dictU32; }

    /** 无符号的64位整数 */
    @invar.InvarRule(T="map<uint64,uint64>", S="f7")
    public LinkedHashMap<BigInteger,BigInteger> getDictU64() { return dictU64; }

    /** 单精度浮点小数 */
    @invar.InvarRule(T="map<float,float>", S="f8")
    public LinkedHashMap<Float,Float> getDictSingle() { return dictSingle; }

    /** 双精度浮点小数 */
    @invar.InvarRule(T="map<double,double>", S="f9")
    public LinkedHashMap<Double,Double> getDictDouble() { return dictDouble; }

    /** 布尔值 */
    @invar.InvarRule(T="map<bool,bool>", S="f10")
    public LinkedHashMap<Boolean,Boolean> getDictBoolean() { return dictBoolean; }

    /** 字符串 */
    @invar.InvarRule(T="map<string,string>", S="f11")
    public LinkedHashMap<String,String> getDictString() { return dictString; }

    /** 枚举值 */
    @invar.InvarRule(T="map<test.abc.Gender,test.abc.Gender>", S="f12")
    public LinkedHashMap<Gender,Gender> getDictEnum() { return dictEnum; }

    /** 自定义结构 */
    @invar.InvarRule(T="map<test.abc.Custom,test.abc.Custom>", S="f13")
    public LinkedHashMap<Custom,Custom> getDictStruct() { return dictStruct; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f14")
    public LinkedHashMap<String,String> getHotfix() { return hotfix; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f14")
    public TestDict setHotfix(LinkedHashMap<String,String> value) { this.hotfix = value; return this; }

    public TestDict copy (TestDict from)
    {
        if (this == from || from == null) {
            return this;
        }
        dictI08.clear();
        dictI08.putAll(from.dictI08);
        dictI16.clear();
        dictI16.putAll(from.dictI16);
        dictI32.clear();
        dictI32.putAll(from.dictI32);
        dictI64.clear();
        dictI64.putAll(from.dictI64);
        dictU08.clear();
        dictU08.putAll(from.dictU08);
        dictU16.clear();
        dictU16.putAll(from.dictU16);
        dictU32.clear();
        dictU32.putAll(from.dictU32);
        dictU64.clear();
        dictU64.putAll(from.dictU64);
        dictSingle.clear();
        dictSingle.putAll(from.dictSingle);
        dictDouble.clear();
        dictDouble.putAll(from.dictDouble);
        dictBoolean.clear();
        dictBoolean.putAll(from.dictBoolean);
        dictString.clear();
        dictString.putAll(from.dictString);
        dictEnum.clear();
        dictEnum.putAll(from.dictEnum);
        dictStruct.clear();
        dictStruct.putAll(from.dictStruct);
        if (from.hotfix != null) {
            hotfix.clear();
            hotfix.putAll(from.hotfix);
        } else {
            hotfix = null;
        }
        return this;
    } //copyFrom(...)

    public void read(InputStream from) throws IOException
    {
        this.read((DataInput)new DataInputStream(from));
    }

    public void read(DataInput from) throws IOException
    {
        dictI08.clear();
        Long lenDictI08 = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictI08 = 0L; iDictI08 < lenDictI08; ++iDictI08) {
            java.lang.Byte k1 = from.readByte();
            java.lang.Byte v1 = from.readByte();
            dictI08.put(k1,v1);
        }
        dictI16.clear();
        Long lenDictI16 = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictI16 = 0L; iDictI16 < lenDictI16; ++iDictI16) {
            Short k1 = from.readShort();
            Short v1 = from.readShort();
            dictI16.put(k1,v1);
        }
        dictI32.clear();
        Long lenDictI32 = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictI32 = 0L; iDictI32 < lenDictI32; ++iDictI32) {
            Integer k1 = from.readUnsignedShort();
            Integer v1 = from.readUnsignedShort();
            dictI32.put(k1,v1);
        }
        dictI64.clear();
        Long lenDictI64 = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictI64 = 0L; iDictI64 < lenDictI64; ++iDictI64) {
            Long k1 = from.readInt() & 0xFFFFFFFFL;
            Long v1 = from.readInt() & 0xFFFFFFFFL;
            dictI64.put(k1,v1);
        }
        dictU08.clear();
        Long lenDictU08 = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictU08 = 0L; iDictU08 < lenDictU08; ++iDictU08) {
            java.lang.Integer k1 = from.readUnsignedShort();
            java.lang.Integer v1 = from.readUnsignedShort();
            dictU08.put(k1,v1);
        }
        dictU16.clear();
        Long lenDictU16 = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictU16 = 0L; iDictU16 < lenDictU16; ++iDictU16) {
            java.lang.Integer k1 = from.readUnsignedShort();
            java.lang.Integer v1 = from.readUnsignedShort();
            dictU16.put(k1,v1);
        }
        dictU32.clear();
        Long lenDictU32 = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictU32 = 0L; iDictU32 < lenDictU32; ++iDictU32) {
            java.lang.Long k1 = from.readInt() & 0xFFFFFFFFL;
            java.lang.Long v1 = from.readInt() & 0xFFFFFFFFL;
            dictU32.put(k1,v1);
        }
        dictU64.clear();
        Long lenDictU64 = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictU64 = 0L; iDictU64 < lenDictU64; ++iDictU64) {
            byte[] k1Bytes = new byte[8]; from.readFully(k1Bytes, 0, 8);
            BigInteger k1 = new BigInteger(k1Bytes);
            byte[] v1Bytes = new byte[8]; from.readFully(v1Bytes, 0, 8);
            BigInteger v1 = new BigInteger(v1Bytes);
            dictU64.put(k1,v1);
        }
        dictSingle.clear();
        Long lenDictSingle = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictSingle = 0L; iDictSingle < lenDictSingle; ++iDictSingle) {
            Float k1 = from.readFloat();
            Float v1 = from.readFloat();
            dictSingle.put(k1,v1);
        }
        dictDouble.clear();
        Long lenDictDouble = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictDouble = 0L; iDictDouble < lenDictDouble; ++iDictDouble) {
            java.lang.Double k1 = from.readDouble();
            java.lang.Double v1 = from.readDouble();
            dictDouble.put(k1,v1);
        }
        dictBoolean.clear();
        Long lenDictBoolean = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictBoolean = 0L; iDictBoolean < lenDictBoolean; ++iDictBoolean) {
            java.lang.Boolean k1 = from.readBoolean();
            java.lang.Boolean v1 = from.readBoolean();
            dictBoolean.put(k1,v1);
        }
        dictString.clear();
        Long lenDictString = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictString = 0L; iDictString < lenDictString; ++iDictString) {
            java.lang.String k1 = from.readUTF();
            java.lang.String v1 = from.readUTF();
            dictString.put(k1,v1);
        }
        dictEnum.clear();
        Long lenDictEnum = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictEnum = 0L; iDictEnum < lenDictEnum; ++iDictEnum) {
            Gender k1 = Gender.valueOf(from.readInt());
            Gender v1 = Gender.valueOf(from.readInt());
            dictEnum.put(k1,v1);
        }
        dictStruct.clear();
        Long lenDictStruct = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictStruct = 0L; iDictStruct < lenDictStruct; ++iDictStruct) {
            Custom k1 = new Custom();
            k1.read(from);
            Custom v1 = new Custom();
            v1.read(from);
            dictStruct.put(k1,v1);
        }
        hotfix.clear();
        if (from.readByte() == (byte)0x01) {
            Long lenHotfix = from.readInt() & 0xFFFFFFFFL;
            for (Long iHotfix = 0L; iHotfix < lenHotfix; ++iHotfix) {
                java.lang.String k1 = from.readUTF();
                java.lang.String v1 = from.readUTF();
                hotfix.put(k1,v1);
            }
        }
    }

    public void write(OutputStream from) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(from));
    }

    public void write(DataOutput dest) throws IOException
    {
        dest.writeInt(dictI08.size());
        for (Map.Entry<java.lang.Byte,java.lang.Byte> dictI08Iter : dictI08.entrySet()) {
            java.lang.Byte k1 = dictI08Iter.getKey();
            dest.writeByte(k1);
            java.lang.Byte v1 = dictI08Iter.getValue();
            dest.writeByte(v1);
        }
        dest.writeInt(dictI16.size());
        for (Map.Entry<Short,Short> dictI16Iter : dictI16.entrySet()) {
            Short k1 = dictI16Iter.getKey();
            dest.writeShort(k1);
            Short v1 = dictI16Iter.getValue();
            dest.writeShort(v1);
        }
        dest.writeInt(dictI32.size());
        for (Map.Entry<Integer,Integer> dictI32Iter : dictI32.entrySet()) {
            Integer k1 = dictI32Iter.getKey();
            dest.writeShort(k1);
            Integer v1 = dictI32Iter.getValue();
            dest.writeShort(v1);
        }
        dest.writeInt(dictI64.size());
        for (Map.Entry<Long,Long> dictI64Iter : dictI64.entrySet()) {
            Long k1 = dictI64Iter.getKey();
            dest.writeInt(k1.intValue());
            Long v1 = dictI64Iter.getValue();
            dest.writeInt(v1.intValue());
        }
        dest.writeInt(dictU08.size());
        for (Map.Entry<java.lang.Integer,java.lang.Integer> dictU08Iter : dictU08.entrySet()) {
            java.lang.Integer k1 = dictU08Iter.getKey();
            dest.writeShort(k1);
            java.lang.Integer v1 = dictU08Iter.getValue();
            dest.writeShort(v1);
        }
        dest.writeInt(dictU16.size());
        for (Map.Entry<java.lang.Integer,java.lang.Integer> dictU16Iter : dictU16.entrySet()) {
            java.lang.Integer k1 = dictU16Iter.getKey();
            dest.writeShort(k1);
            java.lang.Integer v1 = dictU16Iter.getValue();
            dest.writeShort(v1);
        }
        dest.writeInt(dictU32.size());
        for (Map.Entry<java.lang.Long,java.lang.Long> dictU32Iter : dictU32.entrySet()) {
            java.lang.Long k1 = dictU32Iter.getKey();
            dest.writeInt(k1.intValue());
            java.lang.Long v1 = dictU32Iter.getValue();
            dest.writeInt(v1.intValue());
        }
        dest.writeInt(dictU64.size());
        for (Map.Entry<BigInteger,BigInteger> dictU64Iter : dictU64.entrySet()) {
            BigInteger k1 = dictU64Iter.getKey();
            dest.writeLong(k1.longValue());
            BigInteger v1 = dictU64Iter.getValue();
            dest.writeLong(v1.longValue());
        }
        dest.writeInt(dictSingle.size());
        for (Map.Entry<Float,Float> dictSingleIter : dictSingle.entrySet()) {
            Float k1 = dictSingleIter.getKey();
            dest.writeFloat(k1);
            Float v1 = dictSingleIter.getValue();
            dest.writeFloat(v1);
        }
        dest.writeInt(dictDouble.size());
        for (Map.Entry<java.lang.Double,java.lang.Double> dictDoubleIter : dictDouble.entrySet()) {
            java.lang.Double k1 = dictDoubleIter.getKey();
            dest.writeDouble(k1);
            java.lang.Double v1 = dictDoubleIter.getValue();
            dest.writeDouble(v1);
        }
        dest.writeInt(dictBoolean.size());
        for (Map.Entry<java.lang.Boolean,java.lang.Boolean> dictBooleanIter : dictBoolean.entrySet()) {
            java.lang.Boolean k1 = dictBooleanIter.getKey();
            dest.writeBoolean(k1);
            java.lang.Boolean v1 = dictBooleanIter.getValue();
            dest.writeBoolean(v1);
        }
        dest.writeInt(dictString.size());
        for (Map.Entry<java.lang.String,java.lang.String> dictStringIter : dictString.entrySet()) {
            java.lang.String k1 = dictStringIter.getKey();
            dest.writeUTF(k1);
            java.lang.String v1 = dictStringIter.getValue();
            dest.writeUTF(v1);
        }
        dest.writeInt(dictEnum.size());
        for (Map.Entry<Gender,Gender> dictEnumIter : dictEnum.entrySet()) {
            Gender k1 = dictEnumIter.getKey();
            dest.writeInt(k1.getValue());
            Gender v1 = dictEnumIter.getValue();
            dest.writeInt(v1.getValue());
        }
        dest.writeInt(dictStruct.size());
        for (Map.Entry<Custom,Custom> dictStructIter : dictStruct.entrySet()) {
            Custom k1 = dictStructIter.getKey();
            k1.write(dest);
            Custom v1 = dictStructIter.getValue();
            v1.write(dest);
        }
        if (hotfix != null) {
            dest.writeByte((byte)0x01);
            dest.writeInt(hotfix.size());
            for (Map.Entry<java.lang.String,java.lang.String> hotfixIter : hotfix.entrySet()) {
                java.lang.String k1 = hotfixIter.getKey();
                dest.writeUTF(k1);
                java.lang.String v1 = hotfixIter.getValue();
                dest.writeUTF(v1);
            }
        } else {
            dest.writeByte((byte)0x00);
        }
    }

    public StringBuilder toStringXML (String name)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes  = new StringBuilder();
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
        if (dictI16.size() > 0) {
            nodes.append("<dictI16>");
            for (Map.Entry<Short,Short> dictI16Iter : dictI16.entrySet()) {
                Short k1 = dictI16Iter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                Short v1 = dictI16Iter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictI16>");
        }
        if (dictI32.size() > 0) {
            nodes.append("<dictI32>");
            for (Map.Entry<Integer,Integer> dictI32Iter : dictI32.entrySet()) {
                Integer k1 = dictI32Iter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                Integer v1 = dictI32Iter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictI32>");
        }
        if (dictI64.size() > 0) {
            nodes.append("<dictI64>");
            for (Map.Entry<Long,Long> dictI64Iter : dictI64.entrySet()) {
                Long k1 = dictI64Iter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                Long v1 = dictI64Iter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictI64>");
        }
        if (dictU08.size() > 0) {
            nodes.append("<dictU08>");
            for (Map.Entry<java.lang.Integer,java.lang.Integer> dictU08Iter : dictU08.entrySet()) {
                java.lang.Integer k1 = dictU08Iter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                java.lang.Integer v1 = dictU08Iter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictU08>");
        }
        if (dictU16.size() > 0) {
            nodes.append("<dictU16>");
            for (Map.Entry<java.lang.Integer,java.lang.Integer> dictU16Iter : dictU16.entrySet()) {
                java.lang.Integer k1 = dictU16Iter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                java.lang.Integer v1 = dictU16Iter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictU16>");
        }
        if (dictU32.size() > 0) {
            nodes.append("<dictU32>");
            for (Map.Entry<java.lang.Long,java.lang.Long> dictU32Iter : dictU32.entrySet()) {
                java.lang.Long k1 = dictU32Iter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                java.lang.Long v1 = dictU32Iter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictU32>");
        }
        if (dictU64.size() > 0) {
            nodes.append("<dictU64>");
            for (Map.Entry<BigInteger,BigInteger> dictU64Iter : dictU64.entrySet()) {
                BigInteger k1 = dictU64Iter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                BigInteger v1 = dictU64Iter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictU64>");
        }
        if (dictSingle.size() > 0) {
            nodes.append("<dictSingle>");
            for (Map.Entry<Float,Float> dictSingleIter : dictSingle.entrySet()) {
                Float k1 = dictSingleIter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                Float v1 = dictSingleIter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictSingle>");
        }
        if (dictDouble.size() > 0) {
            nodes.append("<dictDouble>");
            for (Map.Entry<java.lang.Double,java.lang.Double> dictDoubleIter : dictDouble.entrySet()) {
                java.lang.Double k1 = dictDoubleIter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                java.lang.Double v1 = dictDoubleIter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictDouble>");
        }
        if (dictBoolean.size() > 0) {
            nodes.append("<dictBoolean>");
            for (Map.Entry<java.lang.Boolean,java.lang.Boolean> dictBooleanIter : dictBoolean.entrySet()) {
                java.lang.Boolean k1 = dictBooleanIter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                java.lang.Boolean v1 = dictBooleanIter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictBoolean>");
        }
        if (dictString.size() > 0) {
            nodes.append("<dictString>");
            for (Map.Entry<java.lang.String,java.lang.String> dictStringIter : dictString.entrySet()) {
                java.lang.String k1 = dictStringIter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1);
                nodes.append("\">");
                java.lang.String v1 = dictStringIter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1);
                nodes.append("\">");
            }
            nodes.append("</dictString>");
        }
        if (dictEnum.size() > 0) {
            nodes.append("<dictEnum>");
            for (Map.Entry<Gender,Gender> dictEnumIter : dictEnum.entrySet()) {
                Gender k1 = dictEnumIter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                Gender v1 = dictEnumIter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</dictEnum>");
        }
        if (dictStruct.size() > 0) {
            nodes.append("<dictStruct>");
            for (Map.Entry<Custom,Custom> dictStructIter : dictStruct.entrySet()) {
                Custom k1 = dictStructIter.getKey();
                nodes.append(k1.toStringXML("k1"));
                Custom v1 = dictStructIter.getValue();
                nodes.append(v1.toStringXML("v1"));
            }
            nodes.append("</dictStruct>");
        }
        if (hotfix != null && hotfix.size() > 0) {
            nodes.append("<hotfix>");
            for (Map.Entry<java.lang.String,java.lang.String> hotfixIter : hotfix.entrySet()) {
                java.lang.String k1 = hotfixIter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1);
                nodes.append("\">");
                java.lang.String v1 = hotfixIter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1);
                nodes.append("\">");
            }
            nodes.append("</hotfix>");
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
    } //TestDict::toStringXML (String name)

    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        result.append(getClass().getName());
        result.append(", dictI08:");
        result.append("[" + dictI08.size() + "]");
        result.append(", dictI16:");
        result.append("[" + dictI16.size() + "]");
        result.append(", dictI32:");
        result.append("[" + dictI32.size() + "]");
        result.append(", dictI64:");
        result.append("[" + dictI64.size() + "]");
        result.append(", dictU08:");
        result.append("[" + dictU08.size() + "]");
        result.append(", dictU16:");
        result.append("[" + dictU16.size() + "]");
        result.append(", dictU32:");
        result.append("[" + dictU32.size() + "]");
        result.append(", dictU64:");
        result.append("[" + dictU64.size() + "]");
        result.append(", dictSingle:");
        result.append("[" + dictSingle.size() + "]");
        result.append(", dictDouble:");
        result.append("[" + dictDouble.size() + "]");
        result.append(", dictBoolean:");
        result.append("[" + dictBoolean.size() + "]");
        result.append(", dictString:");
        result.append("[" + dictString.size() + "]");
        result.append(", dictEnum:");
        result.append("[" + dictEnum.size() + "]");
        result.append(", dictStruct:");
        result.append("[" + dictStruct.size() + "]");
        result.append(", hotfix:");
        if (hotfix != null) {
            result.append("[" + hotfix.size() + "]");
        } else {
            result.append("null");
        }
        result.append(" }");
        return result.toString();
    } //TestDict::toString ()

}

