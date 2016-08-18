/*===----------------------------*  Java  *--------------------------------===//
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
    static public final long CRC32 = 0x120FDCDB;

    static public Info Create() {
        return new Info();
    }

    private Integer                       key          ;
    private java.lang.Byte                number01     ;
    private Short                         number02     ;
    private Integer                       number03     ;
    private Long                          number04     ;/* Test field comments */
    private java.lang.Integer             number05     ;
    private java.lang.Integer             number06     ;
    private java.lang.Long                number07     ;
    private BigInteger                    number08     ;
    private Float                         number09     ;
    private java.lang.Double              number10     ;
    private java.lang.Boolean             isReal       ;
    private java.lang.String              s            ;/* a string */
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
        number08      = new BigInteger("0", 10);
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
        number08 = new BigInteger("0", 10);
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
    public java.lang.Byte getNumber01() { return number01; }

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
    public java.lang.Integer getNumber05() { return number05; }

    /**  */
    @invar.InvarRule(T="uint16", S="f6")
    public java.lang.Integer getNumber06() { return number06; }

    /**  */
    @invar.InvarRule(T="uint32", S="f7")
    public java.lang.Long getNumber07() { return number07; }

    /**  */
    @invar.InvarRule(T="uint64", S="f8")
    public BigInteger getNumber08() { return number08; }

    /**  */
    @invar.InvarRule(T="float", S="f9")
    public Float getNumber09() { return number09; }

    /**  */
    @invar.InvarRule(T="double", S="f10")
    public java.lang.Double getNumber10() { return number10; }

    /**  */
    @invar.InvarRule(T="bool", S="f11")
    public java.lang.Boolean getIsReal() { return isReal; }

    /** a string */
    @invar.InvarRule(T="string", S="f12")
    public java.lang.String getS() { return s; }

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
    public Info setNumber01(java.lang.Byte value) { this.number01 = value; return this; }

    /**  */
    @invar.InvarRule(T="int16", S="f2")
    public Info setNumber02(Short value) { this.number02 = value; return this; }

    /**  */
    @invar.InvarRule(T="int32", S="f3")
    public Info setNumber03(Integer value) { this.number03 = value; return this; }

    /** Test field comments */
    @invar.InvarRule(T="int64", S="f4")
    public Info setNumber04(Long value) { this.number04 = value; return this; }

    /**  */
    @invar.InvarRule(T="uint8", S="f5")
    public Info setNumber05(java.lang.Integer value) { this.number05 = value; return this; }

    /**  */
    @invar.InvarRule(T="uint16", S="f6")
    public Info setNumber06(java.lang.Integer value) { this.number06 = value; return this; }

    /**  */
    @invar.InvarRule(T="uint32", S="f7")
    public Info setNumber07(java.lang.Long value) { this.number07 = value; return this; }

    /**  */
    @invar.InvarRule(T="uint64", S="f8")
    public Info setNumber08(BigInteger value) { this.number08 = value; return this; }

    /**  */
    @invar.InvarRule(T="float", S="f9")
    public Info setNumber09(Float value) { this.number09 = value; return this; }

    /**  */
    @invar.InvarRule(T="double", S="f10")
    public Info setNumber10(java.lang.Double value) { this.number10 = value; return this; }

    /**  */
    @invar.InvarRule(T="bool", S="f11")
    public Info setIsReal(java.lang.Boolean value) { this.isReal = value; return this; }

    /** a string */
    @invar.InvarRule(T="string", S="f12")
    public Info setS(java.lang.String value) { this.s = value; return this; }

    /**  */
    @invar.InvarRule(T="test.abc.Gender", S="f14")
    public Info setGender(Gender value) { this.gender = value; return this; }

    /**  */
    @invar.InvarRule(T="test.abc.Info", S="f15")
    public Info setNext(Info value) { this.next = value; return this; }

    /**  */
    @invar.InvarRule(T="test.abc.Conflict", S="f16")
    public Info setConflict(test.abc.Conflict value) { this.conflict = value; return this; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f22")
    public Info setHotfix(LinkedHashMap<String,String> value) { this.hotfix = value; return this; }

    public Info copy (Info from)
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
        key = from.readInt();
        number01 = from.readByte();
        number02 = from.readShort();
        number03 = from.readInt();
        number04 = from.readLong();
        number05 = from.readUnsignedByte();
        number06 = from.readUnsignedShort();
        number07 = from.readInt() & 0xFFFFFFFFL;
        byte[] number08Bytes = new byte[8]; from.readFully(number08Bytes, 0, 8);
        number08 = new BigInteger(number08Bytes);
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

    public StringBuilder toStringXML (String name)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes  = new StringBuilder();
        attrs.append(" key=\"");
        attrs.append(key.toString()); attrs.append("\"");
        attrs.append(" number01=\"");
        attrs.append(number01.toString()); attrs.append("\"");
        attrs.append(" number02=\"");
        attrs.append(number02.toString()); attrs.append("\"");
        attrs.append(" number03=\"");
        attrs.append(number03.toString()); attrs.append("\"");
        attrs.append(" number04=\"");
        attrs.append(number04.toString()); attrs.append("\"");
        attrs.append(" number05=\"");
        attrs.append(number05.toString()); attrs.append("\"");
        attrs.append(" number06=\"");
        attrs.append(number06.toString()); attrs.append("\"");
        attrs.append(" number07=\"");
        attrs.append(number07.toString()); attrs.append("\"");
        attrs.append(" number08=\"");
        attrs.append(number08.toString()); attrs.append("\"");
        attrs.append(" number09=\"");
        attrs.append(number09.toString()); attrs.append("\"");
        attrs.append(" number10=\"");
        attrs.append(number10.toString()); attrs.append("\"");
        attrs.append(" isReal=\"");
        attrs.append(isReal.toString()); attrs.append("\"");
        attrs.append(" s=\"");
        attrs.append(s); attrs.append("\"");
        if (world.size() > 0) {
            nodes.append("<world>");
            for (java.lang.String n1 : world) {
                nodes.append("<n1 value=\"");
                nodes.append(n1);
                nodes.append("\">");
            }
            nodes.append("</world>");
        }
        attrs.append(" gender=\"");
        attrs.append(gender.toString()); attrs.append("\"");
        if (next != null) {
            nodes.append(next.toStringXML("next"));
        }
        nodes.append(conflict.toStringXML("conflict"));
        if (conflicts.size() > 0) {
            nodes.append("<conflicts>");
            for (test.xyz.Conflict n1 : conflicts) {
                nodes.append(n1.toStringXML("n1"));
            }
            nodes.append("</conflicts>");
        }
        if (numbers.size() > 0) {
            nodes.append("<numbers>");
            for (java.lang.Double n1 : numbers) {
                nodes.append("<n1 value=\"");
                nodes.append(n1.toString());
                nodes.append("\">");
            }
            nodes.append("</numbers>");
        }
        if (mapInfoG.size() > 0) {
            nodes.append("<mapInfoG>");
            for (Map.Entry<Info,Gender> mapInfoGIter : mapInfoG.entrySet()) {
                Info k1 = mapInfoGIter.getKey();
                nodes.append(k1.toStringXML("k1"));
                Gender v1 = mapInfoGIter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</mapInfoG>");
        }
        if (mapGenderInfo.size() > 0) {
            nodes.append("<mapGenderInfo>");
            for (Map.Entry<Gender,Info> mapGenderInfoIter : mapGenderInfo.entrySet()) {
                Gender k1 = mapGenderInfoIter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                Info v1 = mapGenderInfoIter.getValue();
                nodes.append(v1.toStringXML("v1"));
            }
            nodes.append("</mapGenderInfo>");
        }
        if (mapDouble.size() > 0) {
            nodes.append("<mapDouble>");
            for (Map.Entry<Integer,java.lang.Double> mapDoubleIter : mapDouble.entrySet()) {
                Integer k1 = mapDoubleIter.getKey();
                nodes.append("<k1 value=\"");
                nodes.append(k1.toString());
                nodes.append("\">");
                java.lang.Double v1 = mapDoubleIter.getValue();
                nodes.append("<v1 value=\"");
                nodes.append(v1.toString());
                nodes.append("\">");
            }
            nodes.append("</mapDouble>");
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
    } //Info::toStringXML (String name)

    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        result.append(getClass().getName());
        result.append(", key:");
        result.append(key.toString());
        result.append(", number01:");
        result.append(number01.toString());
        result.append(", number02:");
        result.append(number02.toString());
        result.append(", number03:");
        result.append(number03.toString());
        result.append(", number04:");
        result.append(number04.toString());
        result.append(", number05:");
        result.append(number05.toString());
        result.append(", number06:");
        result.append(number06.toString());
        result.append(", number07:");
        result.append(number07.toString());
        result.append(", number08:");
        result.append(number08.toString());
        result.append(", number09:");
        result.append(number09.toString());
        result.append(", number10:");
        result.append(number10.toString());
        result.append(", isReal:");
        result.append(isReal.toString());
        result.append(", s:");
        result.append("\"" + s + "\"");
        result.append(", world:");
        result.append("(" + world.size() + ")");
        result.append(", gender:");
        result.append(gender.toString());
        result.append(", next:");
        if (next != null) {
            result.append("<Info>");
        } else {
            result.append("null");
        }
        result.append(", conflict:");
        result.append("<test.abc.Conflict>");
        result.append(", conflicts:");
        result.append("(" + conflicts.size() + ")");
        result.append(", numbers:");
        result.append("(" + numbers.size() + ")");
        result.append(", mapInfoG:");
        result.append("[" + mapInfoG.size() + "]");
        result.append(", mapGenderInfo:");
        result.append("[" + mapGenderInfo.size() + "]");
        result.append(", mapDouble:");
        result.append("[" + mapDouble.size() + "]");
        result.append(", hotfix:");
        if (hotfix != null) {
            result.append("[" + hotfix.size() + "]");
        } else {
            result.append("null");
        }
        result.append(" }");
        return result.toString();
    } //Info::toString ()

}

