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
import java.util.LinkedHashMap;
import java.util.Map;

/**  */
public final class Conflict
implements
invar.InvarCodec.BinaryDecode,
invar.InvarCodec.BinaryEncode,
invar.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0x2126E985L;

    static public Conflict Create()
    {
        return new Conflict();
    }

    private Double                       pi    ;
    private LinkedHashMap<String,String> hotfix;/* [AutoAdd] Hotfix */

    public Conflict()
    {
        pi     = 3.1415926;
        hotfix = null;
    }

    public Conflict reuse()
    {
        pi = 3.1415926;
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /**  */
    @invar.InvarRule(T="double", S="f0")
    public Double getPi() { return pi; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f1")
    public LinkedHashMap<String,String> getHotfix() { return hotfix; }

    /**  */
    @invar.InvarRule(T="double", S="f0")
    public Conflict setPi(Double value) { this.pi = value; return this; }
    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f1")
    public Conflict setHotfix(LinkedHashMap<java.lang.String,java.lang.String> value) { this.hotfix = value; return this; }

    /** Shallow copy */
    public Conflict copy(Conflict from)
    {
        if (this == from || from == null) {
            return this;
        }
        pi = from.pi;
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
        pi = from.readDouble();
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
        dest.writeDouble(pi);
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
        s.append(',').append("pi").append(':');
        s.append(pi.toString());
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
        s.append('\n').append('{');
        char comma = '\0';
        s.append('"').append("pi").append('"').append(':');
        s.append(pi.toString()); comma = ',';
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
        attrs.append(' ').append("pi").append('=').append('"');
        attrs.append(pi.toString()).append('"');
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

