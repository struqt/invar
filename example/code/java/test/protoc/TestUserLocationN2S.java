/*===----------------------------*  Java  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.protoc;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/** 客户端通知服务端 */
public final class TestUserLocationN2S
implements
invar.InvarCodec.ProtocNotify,
invar.InvarCodec.BinaryDecode,
invar.InvarCodec.BinaryEncode,
invar.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0xEC953457;

    static public TestUserLocationN2S Create() {
        return new TestUserLocationN2S();
    }

    private java.lang.Integer            protocId ;/* [AutoAdd] ProtocolID */
    private java.lang.Long               protocCRC;/* [AutoAdd] Protocol CRC32 */
    private Protoc2S                     protoc2S ;/* [AutoAdd] 客户端请求的公共数据 */
    private Float                        x        ;/* 坐标X */
    private Float                        y        ;/* 坐标Y */
    private LinkedHashMap<String,String> hotfix   ;/* [AutoAdd] Hotfix */

    public TestUserLocationN2S()
    {
        protocId  = 65531;
        protocCRC = CRC32;
        protoc2S  = null;
        x         = 0.0F;
        y         = 0.0F;
        hotfix    = null;
    }

    public TestUserLocationN2S reuse()
    {
        protocId = 65531;
        protocCRC = CRC32;
        if (protoc2S != null) {
            protoc2S.reuse();
        }
        x = 0.0F;
        y = 0.0F;
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /** [AutoAdd] ProtocolID */
    @invar.InvarRule(T="uint16", S="f0")
    public java.lang.Integer getProtocId() { return protocId; }

    /** [AutoAdd] Protocol CRC32 */
    @invar.InvarRule(T="uint32", S="f1")
    public java.lang.Long getProtocCRC() { return protocCRC; }

    /** [AutoAdd] 客户端请求的公共数据 */
    @invar.InvarRule(T="test.protoc.Protoc2S", S="f2")
    public Protoc2S getProtoc2S() { return protoc2S; }

    /** 坐标X */
    @invar.InvarRule(T="float", S="f3")
    public Float getX() { return x; }

    /** 坐标Y */
    @invar.InvarRule(T="float", S="f4")
    public Float getY() { return y; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f5")
    public LinkedHashMap<String,String> getHotfix() { return hotfix; }

    /** [AutoAdd] 客户端请求的公共数据 */
    @invar.InvarRule(T="test.protoc.Protoc2S", S="f2")
    public TestUserLocationN2S setProtoc2S(Protoc2S value) { this.protoc2S = value; return this; }

    /** 坐标X */
    @invar.InvarRule(T="float", S="f3")
    public TestUserLocationN2S setX(Float value) { this.x = value; return this; }

    /** 坐标Y */
    @invar.InvarRule(T="float", S="f4")
    public TestUserLocationN2S setY(Float value) { this.y = value; return this; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f5")
    public TestUserLocationN2S setHotfix(LinkedHashMap<String,String> value) { this.hotfix = value; return this; }

    public TestUserLocationN2S copy (TestUserLocationN2S from)
    {
        if (this == from || from == null) {
            return this;
        }
        protocId = from.protocId;
        protocCRC = from.protocCRC;
        if (from.protoc2S != null) {
            protoc2S.copy(from.protoc2S);
        } else {
            protoc2S = null;
        }
        x = from.x;
        y = from.y;
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
        protocId = from.readUnsignedShort();
        protocCRC = from.readInt() & 0xFFFFFFFFL;
        if (from.readByte() == (byte)0x01) {
            protoc2S.read(from);
        }
        x = from.readFloat();
        y = from.readFloat();
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
        dest.writeShort(protocId);
        dest.writeInt(protocCRC.intValue());
        if (protoc2S != null) {
            dest.writeByte((byte)0x01);
            protoc2S.write(dest);
        } else {
            dest.writeByte((byte)0x00);
        }
        dest.writeFloat(x);
        dest.writeFloat(y);
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
        attrs.append(" protocId=\"");
        attrs.append(protocId.toString()); attrs.append("\"");
        attrs.append(" protocCRC=\"");
        attrs.append(protocCRC.toString()); attrs.append("\"");
        if (protoc2S != null) {
            nodes.append(protoc2S.toStringXML("protoc2S"));
        }
        attrs.append(" x=\"");
        attrs.append(x.toString()); attrs.append("\"");
        attrs.append(" y=\"");
        attrs.append(y.toString()); attrs.append("\"");
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
    } //TestUserLocationN2S::toStringXML (String name)

    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        result.append(getClass().getName());
        result.append(", protocId:");
        result.append(protocId.toString());
        result.append(", protocCRC:");
        result.append(protocCRC.toString());
        result.append(", protoc2S:");
        if (protoc2S != null) {
            result.append("<Protoc2S>");
        } else {
            result.append("null");
        }
        result.append(", x:");
        result.append(x.toString());
        result.append(", y:");
        result.append(y.toString());
        result.append(", hotfix:");
        if (hotfix != null) {
            result.append("[" + hotfix.size() + "]");
        } else {
            result.append("null");
        }
        result.append(" }");
        return result.toString();
    } //TestUserLocationN2S::toString ()

}

