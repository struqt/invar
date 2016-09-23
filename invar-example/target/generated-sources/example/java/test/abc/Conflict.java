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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

/** 名字冲突的类型 */
public final class Conflict
implements
invar.lib.InvarCodec.BinaryDecode,
invar.lib.InvarCodec.BinaryEncode,
invar.lib.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0xCC7A29B9L;

    static public Conflict Create()
    {
        return new Conflict();
    }

    private Gender                       key   ;
    private String                       text  ;
    private LinkedList<Byte>             bytes ;
    private LinkedHashMap<String,String> hotfix;/* [AutoAdd] Hotfix */

    public Conflict()
    {
        key    = Gender.NONE;
        text   = "";
        bytes  = new LinkedList<Byte>();
        hotfix = null;
    }

    public Conflict reuse()
    {
        key = Gender.NONE;
        text = "";
        bytes.clear();
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /**  */
    @invar.lib.InvarRule(T="test.abc.Gender", S="f0")
    public Gender getKey() { return key; }

    /**  */
    @invar.lib.InvarRule(T="string", S="f1")
    public String getText() { return text; }

    /**  */
    @invar.lib.InvarRule(T="vec<int8>", S="f2")
    public LinkedList<Byte> getBytes() { return bytes; }

    /** [AutoAdd] Hotfix */
    @invar.lib.InvarRule(T="map<string,string>", S="f3")
    public LinkedHashMap<String,String> getHotfix() { return hotfix; }

    /**  */
    @invar.lib.InvarRule(T="test.abc.Gender", S="f0")
    public Conflict setKey(Gender value) { this.key = value; return this; }
    /**  */
    @invar.lib.InvarRule(T="string", S="f1")
    public Conflict setText(String value) { this.text = value; return this; }
    /** [AutoAdd] Hotfix */
    @invar.lib.InvarRule(T="map<string,string>", S="f3")
    public Conflict setHotfix(LinkedHashMap<java.lang.String,java.lang.String> value) { this.hotfix = value; return this; }

    /** Shallow copy */
    public Conflict copy(Conflict from)
    {
        if (this == from || from == null) {
            return this;
        }
        key = from.key;
        text = from.text;
        bytes.clear();
        bytes.addAll(from.bytes);
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
        key = Gender.valueOf(from.readInt());
        text = from.readUTF();
        bytes.clear();
        Long lenBytes = from.readInt() & 0xFFFFFFFFL;
        for (Long iBytes = 0L; iBytes < lenBytes; ++iBytes) {
            java.lang.Byte n1 = from.readByte();
            bytes.add(n1);
        }
        byte hotfixExists = from.readByte();
        if ((byte)0x01 == hotfixExists) {
            if (hotfix == null) { hotfix = new LinkedHashMap<java.lang.String,java.lang.String>(); }
            Long lenHotfix = from.readInt() & 0xFFFFFFFFL;
            for (Long iHotfix = 0L; iHotfix < lenHotfix; ++iHotfix) {
                java.lang.String k1 = from.readUTF();
                java.lang.String v1 = from.readUTF();
                hotfix.put(k1,v1);
            }
        }
        else if ((byte)0x00 == hotfixExists) { hotfix = null; }
        else { throw new IOException("Protoc read error: The value of 'hotfixExists' is invalid. 498"); }
    }

    public void write(OutputStream from) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(from));
    }

    public void write(DataOutput dest) throws IOException
    {
        dest.writeInt(key.value());
        dest.writeUTF(text);
        dest.writeInt(bytes.size());
        for (java.lang.Byte n1 : bytes) {
            dest.writeByte(n1);
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
        s.append(',').append("text").append(':');
        s.append('"').append(text).append('"');
        s.append(',').append("bytes").append(':');
        s.append('(').append(bytes.size()).append(')');
        s.append(", hotfix:");
        if (hotfix != null) {
            s.append('[').append(hotfix.size()).append(']');
        } else {
            s.append("null");
        }
        s.append('}');
        return s.toString();
    } //Conflict::toString ()

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
        s.append('"').append("key").append('"').append(':');
        s.append(key.ordinal()); comma = ',';
        boolean textExists = text != null && text.length() > 0;
        if ('\0' != comma && textExists) { s.append(comma); comma = '\0'; }
        if (textExists) {
            s.append('"').append("text").append('"').append(':'); comma = ','; s.append('"').append(text.toString()).append('"');
        }
        boolean bytesExists = (null != bytes && bytes.size() > 0);
        if ('\0' != comma && bytesExists) { s.append(comma); comma = '\0'; }
        if (bytesExists) { s.append('"').append("bytes").append('"').append(':'); comma = ','; }
        int bytesSize = (null == bytes ? 0 : bytes.size());
        if (bytesSize > 0) {
            s.append('[');
            int bytesIdx = 0;
            for (java.lang.Byte n1 : bytes) { /* vec.for: bytes */
                ++bytesIdx;
                s.append(n1.toString());
                if (bytesIdx != bytesSize) { s.append(','); }
            }
            s.append(']');
        }
        boolean hotfixExists = (null != hotfix && hotfix.size() > 0);
        if ('\0' != comma && hotfixExists) { s.append(comma); comma = '\0'; }
        if (hotfixExists) {
            int hotfixSize = (null == hotfix ? 0 : hotfix.size());
            if (hotfixSize > 0) {
                s.append('{');
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
        s.append('}');
    } /* Conflict::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "Conflict");
        return code.toString();
    }

    public void writeXML(StringBuilder result, String name)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.append(' ').append("key").append('=').append('"');
        attrs.append(key.toString()).append('"');
        attrs.append(' ').append("text").append('=').append('"');
        attrs.append(text).append('"');
        if (bytes.size() > 0) {
            nodes.append('<').append("bytes").append('>');
            for (java.lang.Byte n1 : bytes) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('>');
            }
            nodes.append('<').append('/').append("bytes").append('>');
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
    } /* Conflict::writeXML(...) */

}

