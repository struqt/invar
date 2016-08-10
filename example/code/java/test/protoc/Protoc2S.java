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

/** 客户端请求的公共数据 */
public final class Protoc2S
implements
invar.InvarCodec.BinaryDecode,
invar.InvarCodec.BinaryEncode,
invar.InvarCodec.XMLEncode
{
    static public Protoc2S Create() { return new Protoc2S(); }

    static public final long CRC32 = 0xC0869FC2;

    private java.lang.String             sessionId;/* 会话Id */
    private LinkedHashMap<String,String> hotfix   ;/* [AutoAdd] Hotfix */

    public Protoc2S()
    {
        sessionId = "";
        hotfix    = null;
    }

    public Protoc2S reuse()
    {
        sessionId = "";
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /** 会话Id */
    @invar.InvarRule(T="string", S="f0")
    public java.lang.String getSessionId() { return sessionId; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f1")
    public LinkedHashMap<String,String> getHotfix() { return hotfix; }

    /** 会话Id */
    @invar.InvarRule(T="string", S="f0")
    public Protoc2S setSessionId(java.lang.String value) { this.sessionId = value; return this; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f1")
    public Protoc2S setHotfix(LinkedHashMap<String,String> value) { this.hotfix = value; return this; }

    public Protoc2S copy (Protoc2S from)
    {
        if (this == from || from == null) {
            return this;
        }
        sessionId = from.sessionId;
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
        sessionId = from.readUTF();
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
        dest.writeUTF(sessionId);
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
        attrs.append(" sessionId=\"");
        attrs.append(sessionId); attrs.append("\"");
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
    } //Protoc2S::toStringXML (String name)

    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        result.append(getClass().getName());
        result.append(", sessionId:");
        result.append("\"" + sessionId + "\"");
        result.append(", hotfix:");
        if (hotfix != null) {
            result.append("[" + hotfix.size() + "]");
        } else {
            result.append("null");
        }
        result.append(" }");
        return result.toString();
    } //Protoc2S::toString ()

}

