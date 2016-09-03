/*===----------------------------*  Java 6  *------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.abc;

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

/** Test comments */
public final class Info
implements
invar.InvarCodec.BinaryDecode,
invar.InvarCodec.BinaryEncode,
invar.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0x120FDCDBL;

    static public Info Create()
    {
        return new Info();
    }

    private Integer                       key          ;
    private Byte                          number01     ;
    private Short                         number02     ;
    private Integer                       number03     ;
    private Long                          number04     ;/* Test field comments */
    private Integer                       number05     ;
    private Integer                       number06     ;
    private Long                          number07     ;
    private BigInteger                    number08     ;
    private Float                         number09     ;
    private Double                        number10     ;
    private Boolean                       isReal       ;
    private String                        s            ;/* a string */
    private LinkedList<String>            world        ;
    private Gender                        gender       ;
    private Info                          next         ;
    private test.abc.Conflict             conflict     ;
    private LinkedList<test.xyz.Conflict> conflicts    ;
    private LinkedList<Double>            numbers      ;
    private LinkedHashMap<Info,Gender>    mapInfoG     ;
    private LinkedHashMap<Gender,Info>    mapGenderInfo;
    private LinkedHashMap<Integer,Double> mapDouble    ;
    private LinkedHashMap<String,String>  hotfix       ;/* [AutoAdd] Hotfix */

    public Info()
    {
        key           = 123;
        number01      = -1;
        number02      = -1;
        number03      = -1;
        number04      = -1L;
        number05      = 0;
        number06      = 0;
        number07      = 0L;
        number08      = BigInteger.valueOf(0L);
        number09      = 0.0F;
        number10      = 0.00;
        isReal        = false;
        s             = "hello";
        world         = new LinkedList<String>();
        gender        = Gender.NONE;
        next          = null;
        conflict      = test.abc.Conflict.Create();
        conflicts     = new LinkedList<test.xyz.Conflict>();
        numbers       = new LinkedList<Double>();
        mapInfoG      = new LinkedHashMap<Info,Gender>();
        mapGenderInfo = new LinkedHashMap<Gender,Info>();
        mapDouble     = new LinkedHashMap<Integer,Double>();
        hotfix        = null;
    }

    public Info reuse()
    {
        key = 123;
        number01 = -1;
        number02 = -1;
        number03 = -1;
        number04 = -1L;
        number05 = 0;
        number06 = 0;
        number07 = 0L;
        number08 = BigInteger.valueOf(0L);
        number09 = 0.0F;
        number10 = 0.00;
        isReal = false;
        s = "hello";
        world.clear();
        gender = Gender.NONE;
        if (next != null) {
            next.reuse();
        }
        conflict.reuse();
        conflicts.clear();
        numbers.clear();
        mapInfoG.clear();
        mapGenderInfo.clear();
        mapDouble.clear();
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /**  */
    @invar.InvarRule(T="int32", S="f0")
    public Integer getKey() { return key; }

    /**  */
    @invar.InvarRule(T="int8", S="f1")
    public Byte getNumber01() { return number01; }

    /**  */
    @invar.InvarRule(T="int16", S="f2")
    public Short getNumber02() { return number02; }

    /**  */
    @invar.InvarRule(T="int32", S="f3")
    public Integer getNumber03() { return number03; }

    /** Test field comments */
    @invar.InvarRule(T="int64", S="f4")
    public Long getNumber04() { return number04; }

    /**  */
    @invar.InvarRule(T="uint8", S="f5")
    public Integer getNumber05() { return number05; }

    /**  */
    @invar.InvarRule(T="uint16", S="f6")
    public Integer getNumber06() { return number06; }

    /**  */
    @invar.InvarRule(T="uint32", S="f7")
    public Long getNumber07() { return number07; }

    /**  */
    @invar.InvarRule(T="uint64", S="f8")
    public BigInteger getNumber08() { return number08; }

    /**  */
    @invar.InvarRule(T="float", S="f9")
    public Float getNumber09() { return number09; }

    /**  */
    @invar.InvarRule(T="double", S="f10")
    public Double getNumber10() { return number10; }

    /**  */
    @invar.InvarRule(T="bool", S="f11")
    public Boolean getIsReal() { return isReal; }

    /** a string */
    @invar.InvarRule(T="string", S="f12")
    public String getS() { return s; }

    /**  */
    @invar.InvarRule(T="vec<string>", S="f13")
    public LinkedList<String> getWorld() { return world; }

    /**  */
    @invar.InvarRule(T="test.abc.Gender", S="f14")
    public Gender getGender() { return gender; }

    /**  */
    @invar.InvarRule(T="test.abc.Info", S="f15")
    public Info getNext() { return next; }

    /**  */
    @invar.InvarRule(T="test.abc.Conflict", S="f16")
    public test.abc.Conflict getConflict() { return conflict; }

    /**  */
    @invar.InvarRule(T="vec<test.xyz.Conflict>", S="f17")
    public LinkedList<test.xyz.Conflict> getConflicts() { return conflicts; }

    /**  */
    @invar.InvarRule(T="vec<double>", S="f18")
    public LinkedList<Double> getNumbers() { return numbers; }

    /**  */
    @invar.InvarRule(T="map<test.abc.Info,test.abc.Gender>", S="f19")
    public LinkedHashMap<Info,Gender> getMapInfoG() { return mapInfoG; }

    /**  */
    @invar.InvarRule(T="map<test.abc.Gender,test.abc.Info>", S="f20")
    public LinkedHashMap<Gender,Info> getMapGenderInfo() { return mapGenderInfo; }

    /**  */
    @invar.InvarRule(T="map<int32,double>", S="f21")
    public LinkedHashMap<Integer,Double> getMapDouble() { return mapDouble; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f22")
    public LinkedHashMap<String,String> getHotfix() { return hotfix; }

    /**  */
    @invar.InvarRule(T="int32", S="f0")
    public Info setKey(Integer value) { this.key = value; return this; }
    /**  */
    @invar.InvarRule(T="int8", S="f1")
    public Info setNumber01(Byte value) { this.number01 = value; return this; }
    public Info setNumber01(int value) throws NumberFormatException
    {
        if (value < Byte.MIN_VALUE || value > Byte.MAX_VALUE) {
            throw new NumberFormatException("int8 value out of range: " + value);
        }
        this.number01 = Integer.valueOf(value).byteValue();
        return this;
    }
    /**  */
    @invar.InvarRule(T="int16", S="f2")
    public Info setNumber02(Short value) { this.number02 = value; return this; }
    public Info setNumber02(int value) throws NumberFormatException
    {
        if (value < Short.MIN_VALUE || value > Short.MAX_VALUE) {
            throw new NumberFormatException("int16 value out of range: " + value);
        }
        this.number02 = Integer.valueOf(value).shortValue();
        return this;
    }
    /**  */
    @invar.InvarRule(T="int32", S="f3")
    public Info setNumber03(Integer value) { this.number03 = value; return this; }
    /** Test field comments */
    @invar.InvarRule(T="int64", S="f4")
    public Info setNumber04(Long value) { this.number04 = value; return this; }
    /**  */
    @invar.InvarRule(T="uint8", S="f5")
    public Info setNumber05(int value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFF) {
            throw new NumberFormatException("uint8 value out of range: " + value);
        }
        this.number05 = value;
        return this;
    }
    /**  */
    @invar.InvarRule(T="uint16", S="f6")
    public Info setNumber06(int value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFFFF) {
            throw new NumberFormatException("uint16 value out of range: " + value);
        }
        this.number06 = value;
        return this;
    }
    /**  */
    @invar.InvarRule(T="uint32", S="f7")
    public Info setNumber07(long value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFFFFFFFFL) {
            throw new NumberFormatException("uint32 value out of range: " + value);
        }
        this.number07 = value;
        return this;
    }
    /**  */
    @invar.InvarRule(T="uint64", S="f8")
    public Info setNumber08(BigInteger value) { this.number08 = value; return this; }
    /**  */
    @invar.InvarRule(T="float", S="f9")
    public Info setNumber09(Float value) { this.number09 = value; return this; }
    /**  */
    @invar.InvarRule(T="double", S="f10")
    public Info setNumber10(Double value) { this.number10 = value; return this; }
    /**  */
    @invar.InvarRule(T="bool", S="f11")
    public Info setIsReal(Boolean value) { this.isReal = value; return this; }
    /** a string */
    @invar.InvarRule(T="string", S="f12")
    public Info setS(String value) { this.s = value; return this; }
    /**  */
    @invar.InvarRule(T="vec<string>", S="f13")
    public Info setWorld(LinkedList<java.lang.String> value) { this.world = value; return this; }
    /**  */
    @invar.InvarRule(T="test.abc.Gender", S="f14")
    public Info setGender(Gender value) { this.gender = value; return this; }
    /**  */
    @invar.InvarRule(T="test.abc.Info", S="f15")
    public Info setNext(Info value) { this.next = value; return this; }
    /**  */
    @invar.InvarRule(T="test.abc.Conflict", S="f16")
    public Info setConflict(test.abc.Conflict value) { this.conflict = value; return this; }
    /**  */
    @invar.InvarRule(T="vec<test.xyz.Conflict>", S="f17")
    public Info setConflicts(LinkedList<test.xyz.Conflict> value) { this.conflicts = value; return this; }
    /**  */
    @invar.InvarRule(T="vec<double>", S="f18")
    public Info setNumbers(LinkedList<java.lang.Double> value) { this.numbers = value; return this; }
    /**  */
    @invar.InvarRule(T="map<test.abc.Info,test.abc.Gender>", S="f19")
    public Info setMapInfoG(LinkedHashMap<Info,Gender> value) { this.mapInfoG = value; return this; }
    /**  */
    @invar.InvarRule(T="map<test.abc.Gender,test.abc.Info>", S="f20")
    public Info setMapGenderInfo(LinkedHashMap<Gender,Info> value) { this.mapGenderInfo = value; return this; }
    /**  */
    @invar.InvarRule(T="map<int32,double>", S="f21")
    public Info setMapDouble(LinkedHashMap<Integer,java.lang.Double> value) { this.mapDouble = value; return this; }
    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f22")
    public Info setHotfix(LinkedHashMap<java.lang.String,java.lang.String> value) { this.hotfix = value; return this; }

    /** Shallow copy */
    public Info copy(Info from)
    {
        if (this == from || from == null) {
            return this;
        }
        key = from.key;
        number01 = from.number01;
        number02 = from.number02;
        number03 = from.number03;
        number04 = from.number04;
        number05 = from.number05;
        number06 = from.number06;
        number07 = from.number07;
        number08 = from.number08;
        number09 = from.number09;
        number10 = from.number10;
        isReal = from.isReal;
        s = from.s;
        world.clear();
        world.addAll(from.world);
        gender = from.gender;
        if (from.next != null) {
            next.copy(from.next);
        } else {
            next = null;
        }
        conflict = from.conflict;
        conflicts.clear();
        conflicts.addAll(from.conflicts);
        numbers.clear();
        numbers.addAll(from.numbers);
        mapInfoG.clear();
        mapInfoG.putAll(from.mapInfoG);
        mapGenderInfo.clear();
        mapGenderInfo.putAll(from.mapGenderInfo);
        mapDouble.clear();
        mapDouble.putAll(from.mapDouble);
        if (null == from.hotfix) {
            hotfix = null;
        } else {
            if (null == hotfix) { hotfix = new LinkedHashMap<java.lang.String,java.lang.String>(); }
            else { hotfix.clear(); }
            hotfix.putAll(from.hotfix);
        }
        return this;
    } /* copyFrom(...) */

    public void read(InputStream from) throws IOException
    {
        this.read((DataInput)new DataInputStream(from));
    }

    public void read(DataInput from) throws IOException
    {
        key = from.readInt();
        number01 = from.readByte();
        number02 = from.readShort();
        number03 = from.readInt();
        number04 = from.readLong();
        number05 = from.readUnsignedByte();
        number06 = from.readUnsignedShort();
        number07 = from.readInt() & 0xFFFFFFFFL;
        byte[] number08Bytes = new byte[8]; from.readFully(number08Bytes, 0, 8);
        number08 = new BigInteger(1, number08Bytes);
        number09 = from.readFloat();
        number10 = from.readDouble();
        isReal = from.readBoolean();
        s = from.readUTF();
        world.clear();
        Long lenWorld = from.readInt() & 0xFFFFFFFFL;
        for (Long iWorld = 0L; iWorld < lenWorld; ++iWorld) {
            java.lang.String n1 = from.readUTF();
            world.add(n1);
        }
        gender = Gender.valueOf(from.readInt());
        if (from.readByte() == (byte)0x01) {
            next.read(from);
        }
        conflict.read(from);
        conflicts.clear();
        Long lenConflicts = from.readInt() & 0xFFFFFFFFL;
        for (Long iConflicts = 0L; iConflicts < lenConflicts; ++iConflicts) {
            test.xyz.Conflict n1 = test.xyz.Conflict.Create();
            n1.read(from);
            conflicts.add(n1);
        }
        numbers.clear();
        Long lenNumbers = from.readInt() & 0xFFFFFFFFL;
        for (Long iNumbers = 0L; iNumbers < lenNumbers; ++iNumbers) {
            java.lang.Double n1 = from.readDouble();
            numbers.add(n1);
        }
        mapInfoG.clear();
        Long lenMapInfoG = from.readInt() & 0xFFFFFFFFL;
        for (Long iMapInfoG = 0L; iMapInfoG < lenMapInfoG; ++iMapInfoG) {
            Info k1 = Info.Create();
            k1.read(from);
            Gender v1 = Gender.valueOf(from.readInt());
            mapInfoG.put(k1,v1);
        }
        mapGenderInfo.clear();
        Long lenMapGenderInfo = from.readInt() & 0xFFFFFFFFL;
        for (Long iMapGenderInfo = 0L; iMapGenderInfo < lenMapGenderInfo; ++iMapGenderInfo) {
            Gender k1 = Gender.valueOf(from.readInt());
            Info v1 = Info.Create();
            v1.read(from);
            mapGenderInfo.put(k1,v1);
        }
        mapDouble.clear();
        Long lenMapDouble = from.readInt() & 0xFFFFFFFFL;
        for (Long iMapDouble = 0L; iMapDouble < lenMapDouble; ++iMapDouble) {
            Integer k1 = from.readUnsignedShort();
            java.lang.Double v1 = from.readDouble();
            mapDouble.put(k1,v1);
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
        dest.writeInt(key);
        dest.writeByte(number01);
        dest.writeShort(number02);
        dest.writeInt(number03);
        dest.writeLong(number04);
        dest.writeByte(number05);
        dest.writeShort(number06);
        dest.writeInt(number07.intValue());
        dest.writeLong(number08.longValue());
        dest.writeFloat(number09);
        dest.writeDouble(number10);
        dest.writeBoolean(isReal);
        dest.writeUTF(s);
        dest.writeInt(world.size());
        for (java.lang.String n1 : world) {
            dest.writeUTF(n1);
        }
        dest.writeInt(gender.getValue());
        if (next != null) {
            dest.writeByte((byte)0x01);
            next.write(dest);
        } else {
            dest.writeByte((byte)0x00);
        }
        conflict.write(dest);
        dest.writeInt(conflicts.size());
        for (test.xyz.Conflict n1 : conflicts) {
            n1.write(dest);
        }
        dest.writeInt(numbers.size());
        for (java.lang.Double n1 : numbers) {
            dest.writeDouble(n1);
        }
        dest.writeInt(mapInfoG.size());
        for (Map.Entry<Info,Gender> mapInfoGIter : mapInfoG.entrySet()) {
            Info k1 = mapInfoGIter.getKey();
            k1.write(dest);
            Gender v1 = mapInfoGIter.getValue();
            dest.writeInt(v1.getValue());
        }
        dest.writeInt(mapGenderInfo.size());
        for (Map.Entry<Gender,Info> mapGenderInfoIter : mapGenderInfo.entrySet()) {
            Gender k1 = mapGenderInfoIter.getKey();
            dest.writeInt(k1.getValue());
            Info v1 = mapGenderInfoIter.getValue();
            v1.write(dest);
        }
        dest.writeInt(mapDouble.size());
        for (Map.Entry<Integer,java.lang.Double> mapDoubleIter : mapDouble.entrySet()) {
            Integer k1 = mapDoubleIter.getKey();
            dest.writeShort(k1);
            java.lang.Double v1 = mapDoubleIter.getValue();
            dest.writeDouble(v1);
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

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append('{');
        s.append(getClass().getName());
        s.append(',').append("key").append(':');
        s.append(key.toString());
        s.append(',').append("number01").append(':');
        s.append(number01.toString());
        s.append(',').append("number02").append(':');
        s.append(number02.toString());
        s.append(',').append("number03").append(':');
        s.append(number03.toString());
        s.append(',').append("number04").append(':');
        s.append(number04.toString());
        s.append(',').append("number05").append(':');
        s.append(number05.toString());
        s.append(',').append("number06").append(':');
        s.append(number06.toString());
        s.append(',').append("number07").append(':');
        s.append(number07.toString());
        s.append(',').append("number08").append(':');
        s.append(number08.toString());
        s.append(',').append("number09").append(':');
        s.append(number09.toString());
        s.append(',').append("number10").append(':');
        s.append(number10.toString());
        s.append(',').append("isReal").append(':');
        s.append(isReal.toString());
        s.append(',').append("s").append(':');
        s.append('"').append(s).append('"');
        s.append(',').append("world").append(':');
        s.append('(').append(world.size()).append(')');
        s.append(',').append("gender").append(':');
        s.append(gender.toString());
        s.append(", next:");
        if (next != null) {
            s.append('<').append("Info").append('>');
        } else {
            s.append("null");
        }
        s.append(',').append("conflict").append(':');
        s.append('<').append("test.abc.Conflict").append('>');
        s.append(',').append("conflicts").append(':');
        s.append('(').append(conflicts.size()).append(')');
        s.append(',').append("numbers").append(':');
        s.append('(').append(numbers.size()).append(')');
        s.append(',').append("mapInfoG").append(':');
        s.append('[').append(mapInfoG.size()).append(']');
        s.append(',').append("mapGenderInfo").append(':');
        s.append('[').append(mapGenderInfo.size()).append(']');
        s.append(',').append("mapDouble").append(':');
        s.append('[').append(mapDouble.size()).append(']');
        s.append(", hotfix:");
        if (hotfix != null) {
            s.append('[').append(hotfix.size()).append(']');
        } else {
            s.append("null");
        }
        s.append('}');
        return s.toString();
    } //Info::toString ()

    public String toStringJSON()
    {
        StringBuilder code = new StringBuilder();
        this.writeJSON(code);
        return code.toString();
    }

    public void writeJSON(StringBuilder s)
    {
        s.append('\n').append('{');
        char comma = '\0';
        s.append('"').append("key").append('"').append(':');
        s.append(key.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("number01").append('"').append(':');
        s.append(number01.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("number02").append('"').append(':');
        s.append(number02.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("number03").append('"').append(':');
        s.append(number03.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("number04").append('"').append(':');
        s.append(number04.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("number05").append('"').append(':');
        s.append(number05.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("number06").append('"').append(':');
        s.append(number06.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("number07").append('"').append(':');
        s.append(number07.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("number08").append('"').append(':');
        s.append(number08.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("number09").append('"').append(':');
        s.append(number09.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("number10").append('"').append(':');
        s.append(number10.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("isReal").append('"').append(':');
        s.append(isReal.toString().toLowerCase()); comma = ',';
        boolean sExists = s != null && s.length() > 0;
        if ('\0' != comma && sExists) { s.append(comma); comma = '\0'; }
        if (sExists) {
            s.append('"').append("s").append('"').append(':'); comma = ','; s.append('"').append(s.toString()).append('"');
        }
        boolean worldExists = (null != world && world.size() > 0);
        if ('\0' != comma && worldExists) { s.append(comma); comma = '\0'; }
        if (worldExists) { s.append('"').append("world").append('"').append(':'); comma = ','; }
        int worldSize = (null == world ? 0 : world.size());
        if (worldSize > 0) {
            s.append('\n').append('[');
            int worldIdx = 0;
            for (java.lang.String n1 : world) { /* vec.for: world */
                ++worldIdx;
                s.append('"').append(n1.toString()).append('"');
                if (worldIdx != worldSize) { s.append(','); }
            }
            s.append(']');
        }
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("gender").append('"').append(':');
        s.append(gender.ordinal()); comma = ',';
        boolean nextExists = (null != next);
        if ('\0' != comma && nextExists) { s.append(comma); comma = '\0'; }
        if (nextExists) {
            s.append('"').append("next").append('"').append(':'); comma = ','; next.writeJSON(s);
        }
        boolean conflictExists = (null != conflict);
        if ('\0' != comma && conflictExists) { s.append(comma); comma = '\0'; }
        if (conflictExists) {
            s.append('"').append("conflict").append('"').append(':'); comma = ','; conflict.writeJSON(s);
        }
        boolean conflictsExists = (null != conflicts && conflicts.size() > 0);
        if ('\0' != comma && conflictsExists) { s.append(comma); comma = '\0'; }
        if (conflictsExists) { s.append('"').append("conflicts").append('"').append(':'); comma = ','; }
        int conflictsSize = (null == conflicts ? 0 : conflicts.size());
        if (conflictsSize > 0) {
            s.append('\n').append('[');
            int conflictsIdx = 0;
            for (test.xyz.Conflict n1 : conflicts) { /* vec.for: conflicts */
                ++conflictsIdx;
                n1.writeJSON(s);
                if (conflictsIdx != conflictsSize) { s.append(','); }
            }
            s.append(']');
        }
        boolean numbersExists = (null != numbers && numbers.size() > 0);
        if ('\0' != comma && numbersExists) { s.append(comma); comma = '\0'; }
        if (numbersExists) { s.append('"').append("numbers").append('"').append(':'); comma = ','; }
        int numbersSize = (null == numbers ? 0 : numbers.size());
        if (numbersSize > 0) {
            s.append('\n').append('[');
            int numbersIdx = 0;
            for (java.lang.Double n1 : numbers) { /* vec.for: numbers */
                ++numbersIdx;
                s.append(n1.toString());
                if (numbersIdx != numbersSize) { s.append(','); }
            }
            s.append(']');
        }
        boolean mapInfoGExists = (null != mapInfoG && mapInfoG.size() > 0);
        if ('\0' != comma && mapInfoGExists) { s.append(comma); comma = '\0'; }
        if (mapInfoGExists) { s.append('"').append("mapInfoG").append('"').append(':'); comma = ','; }
        int mapInfoGSize = (null == mapInfoG ? 0 : mapInfoG.size());
        if (mapInfoGSize > 0) {
            s.append('\n').append('{');
            int mapInfoGIdx = 0;
            for (Map.Entry<Info,Gender> mapInfoGIter : mapInfoG.entrySet()) { /* map.for: mapInfoG */
                ++mapInfoGIdx;
                Info k1 = mapInfoGIter.getKey(); /* nest.k */
                s.append('"'); k1.writeJSON(s); s.append('"').append(':');
                Gender v1 = mapInfoGIter.getValue(); /* nest.v */
                s.append(v1.ordinal());
                if (mapInfoGIdx != mapInfoGSize) { s.append(','); }
            }
            s.append('}');
        }
        boolean mapGenderInfoExists = (null != mapGenderInfo && mapGenderInfo.size() > 0);
        if ('\0' != comma && mapGenderInfoExists) { s.append(comma); comma = '\0'; }
        if (mapGenderInfoExists) { s.append('"').append("mapGenderInfo").append('"').append(':'); comma = ','; }
        int mapGenderInfoSize = (null == mapGenderInfo ? 0 : mapGenderInfo.size());
        if (mapGenderInfoSize > 0) {
            s.append('\n').append('{');
            int mapGenderInfoIdx = 0;
            for (Map.Entry<Gender,Info> mapGenderInfoIter : mapGenderInfo.entrySet()) { /* map.for: mapGenderInfo */
                ++mapGenderInfoIdx;
                Gender k1 = mapGenderInfoIter.getKey(); /* nest.k */
                s.append('"'); s.append(k1.ordinal()); s.append('"').append(':');
                Info v1 = mapGenderInfoIter.getValue(); /* nest.v */
                v1.writeJSON(s);
                if (mapGenderInfoIdx != mapGenderInfoSize) { s.append(','); }
            }
            s.append('}');
        }
        boolean mapDoubleExists = (null != mapDouble && mapDouble.size() > 0);
        if ('\0' != comma && mapDoubleExists) { s.append(comma); comma = '\0'; }
        if (mapDoubleExists) { s.append('"').append("mapDouble").append('"').append(':'); comma = ','; }
        int mapDoubleSize = (null == mapDouble ? 0 : mapDouble.size());
        if (mapDoubleSize > 0) {
            s.append('\n').append('{');
            int mapDoubleIdx = 0;
            for (Map.Entry<Integer,java.lang.Double> mapDoubleIter : mapDouble.entrySet()) { /* map.for: mapDouble */
                ++mapDoubleIdx;
                Integer k1 = mapDoubleIter.getKey(); /* nest.k */
                s.append('"'); s.append(k1.toString()); s.append('"').append(':');
                java.lang.Double v1 = mapDoubleIter.getValue(); /* nest.v */
                s.append(v1.toString());
                if (mapDoubleIdx != mapDoubleSize) { s.append(','); }
            }
            s.append('}');
        }
        boolean hotfixExists = (null != hotfix && hotfix.size() > 0);
        if ('\0' != comma && hotfixExists) { s.append(comma); comma = '\0'; }
        if (hotfixExists) {
            int hotfixSize = (null == hotfix ? 0 : hotfix.size());
            if (hotfixSize > 0) {
                s.append('\n').append('{');
                int hotfixIdx = 0;
                for (Map.Entry<java.lang.String,java.lang.String> hotfixIter : hotfix.entrySet()) { /* map.for: hotfix */
                    ++hotfixIdx;
                    java.lang.String k1 = hotfixIter.getKey(); /* nest.k */
                    s.append('"'); s.append('"').append(k1.toString()).append('"'); s.append('"').append(':');
                    java.lang.String v1 = hotfixIter.getValue(); /* nest.v */
                    s.append('"').append(v1.toString()).append('"');
                    if (hotfixIdx != hotfixSize) { s.append(','); }
                }
                s.append('}');
            } comma = ',';
        }
        s.append('}').append('\n');
    } /* Info::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "Info");
        return code.toString();
    }

    public void writeXML(StringBuilder result, String name)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.append(' ').append("key").append('=').append('"');
        attrs.append(key.toString()).append('"');
        attrs.append(' ').append("number01").append('=').append('"');
        attrs.append(number01.toString()).append('"');
        attrs.append(' ').append("number02").append('=').append('"');
        attrs.append(number02.toString()).append('"');
        attrs.append(' ').append("number03").append('=').append('"');
        attrs.append(number03.toString()).append('"');
        attrs.append(' ').append("number04").append('=').append('"');
        attrs.append(number04.toString()).append('"');
        attrs.append(' ').append("number05").append('=').append('"');
        attrs.append(number05.toString()).append('"');
        attrs.append(' ').append("number06").append('=').append('"');
        attrs.append(number06.toString()).append('"');
        attrs.append(' ').append("number07").append('=').append('"');
        attrs.append(number07.toString()).append('"');
        attrs.append(' ').append("number08").append('=').append('"');
        attrs.append(number08.toString()).append('"');
        attrs.append(' ').append("number09").append('=').append('"');
        attrs.append(number09.toString()).append('"');
        attrs.append(' ').append("number10").append('=').append('"');
        attrs.append(number10.toString()).append('"');
        attrs.append(' ').append("isReal").append('=').append('"');
        attrs.append(isReal.toString()).append('"');
        attrs.append(' ').append("s").append('=').append('"');
        attrs.append(s).append('"');
        if (world.size() > 0) {
            nodes.append('<').append("world").append('>');
            for (java.lang.String n1 : world) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1).append('"').append('>');
            }
            nodes.append('<').append('/').append("world").append('>');
        }
        attrs.append(' ').append("gender").append('=').append('"');
        attrs.append(gender.toString()).append('"');
        if (next != null) {
            next.writeXML(nodes, "next");
        }
        conflict.writeXML(nodes, "conflict");
        if (conflicts.size() > 0) {
            nodes.append('<').append("conflicts").append('>');
            for (test.xyz.Conflict n1 : conflicts) {
                n1.writeXML(nodes, "n1");
            }
            nodes.append('<').append('/').append("conflicts").append('>');
        }
        if (numbers.size() > 0) {
            nodes.append('<').append("numbers").append('>');
            for (java.lang.Double n1 : numbers) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('>');
            }
            nodes.append('<').append('/').append("numbers").append('>');
        }
        if (mapInfoG.size() > 0) {
            nodes.append('<').append("mapInfoG").append('>');
            for (Map.Entry<Info,Gender> mapInfoGIter : mapInfoG.entrySet()) {
                Info k1 = mapInfoGIter.getKey();
                k1.writeXML(nodes, "k1");
                Gender v1 = mapInfoGIter.getValue();
                nodes.append('<').append("v1").append(' ').append("value").append('=').append('"');
                nodes.append(v1.toString()).append('"').append('>');
            }
            nodes.append('<').append('/').append("mapInfoG").append('>');
        }
        if (mapGenderInfo.size() > 0) {
            nodes.append('<').append("mapGenderInfo").append('>');
            for (Map.Entry<Gender,Info> mapGenderInfoIter : mapGenderInfo.entrySet()) {
                Gender k1 = mapGenderInfoIter.getKey();
                nodes.append('<').append("k1").append(' ').append("value").append('=').append('"');
                nodes.append(k1.toString()).append('"').append('>');
                Info v1 = mapGenderInfoIter.getValue();
                v1.writeXML(nodes, "v1");
            }
            nodes.append('<').append('/').append("mapGenderInfo").append('>');
        }
        if (mapDouble.size() > 0) {
            nodes.append('<').append("mapDouble").append('>');
            for (Map.Entry<Integer,java.lang.Double> mapDoubleIter : mapDouble.entrySet()) {
                Integer k1 = mapDoubleIter.getKey();
                nodes.append('<').append("k1").append(' ').append("value").append('=').append('"');
                nodes.append(k1.toString()).append('"').append('>');
                java.lang.Double v1 = mapDoubleIter.getValue();
                nodes.append('<').append("v1").append(' ').append("value").append('=').append('"');
                nodes.append(v1.toString()).append('"').append('>');
            }
            nodes.append('<').append('/').append("mapDouble").append('>');
        }
        if (hotfix != null && hotfix.size() > 0) {
            nodes.append('<').append("hotfix").append('>');
            for (Map.Entry<java.lang.String,java.lang.String> hotfixIter : hotfix.entrySet()) {
                java.lang.String k1 = hotfixIter.getKey();
                nodes.append('<').append("k1").append(' ').append("value").append('=').append('"');
                nodes.append(k1).append('"').append('>');
                java.lang.String v1 = hotfixIter.getValue();
                nodes.append('<').append("v1").append(' ').append("value").append('=').append('"');
                nodes.append(v1).append('"').append('>');
            }
            nodes.append('<').append('/').append("hotfix").append('>');
        }
        result.append('<').append(name).append(attrs);
        if (nodes.length() == 0) {
            result.append('/').append('>');
        } else {
            result.append('>').append(nodes);
            result.append('<').append('/').append(name).append('>');
        }
    } /* Info::writeXML(...) */

}

