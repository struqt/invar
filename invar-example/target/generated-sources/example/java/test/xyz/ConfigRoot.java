/*===----------------------------*  Java 6  *------------------------------===//
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
import test.abc.Info;

/**  */
public final class ConfigRoot
implements
invar.InvarCodec.BinaryDecode,
invar.InvarCodec.BinaryEncode,
invar.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0x6D03BB9BL;

    static public ConfigRoot Create()
    {
        return new ConfigRoot();
    }

    private String                       revision;
    private TestList                     list    ;
    private TestDict                     dict    ;
    private TestNest                     nest    ;
    private Info                         info    ;
    private InfoX                        infox   ;
    private LinkedHashMap<String,String> hotfix  ;/* [AutoAdd] Hotfix */

    public ConfigRoot()
    {
        revision = "1.0.0";
        list     = TestList.Create();
        dict     = TestDict.Create();
        nest     = TestNest.Create();
        info     = Info.Create();
        infox    = InfoX.Create();
        hotfix   = null;
    }

    public ConfigRoot reuse()
    {
        revision = "1.0.0";
        list.reuse();
        dict.reuse();
        nest.reuse();
        info.reuse();
        infox.reuse();
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /**  */
    @invar.InvarRule(T="string", S="f0")
    public String getRevision() { return revision; }

    /**  */
    @invar.InvarRule(T="test.xyz.TestList", S="f1")
    public TestList getList() { return list; }

    /**  */
    @invar.InvarRule(T="test.xyz.TestDict", S="f2")
    public TestDict getDict() { return dict; }

    /**  */
    @invar.InvarRule(T="test.xyz.TestNest", S="f3")
    public TestNest getNest() { return nest; }

    /**  */
    @invar.InvarRule(T="test.abc.Info", S="f4")
    public Info getInfo() { return info; }

    /**  */
    @invar.InvarRule(T="test.xyz.InfoX", S="f5")
    public InfoX getInfox() { return infox; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f6")
    public LinkedHashMap<String,String> getHotfix() { return hotfix; }

    /**  */
    @invar.InvarRule(T="string", S="f0")
    public ConfigRoot setRevision(String value) { this.revision = value; return this; }
    /**  */
    @invar.InvarRule(T="test.xyz.TestList", S="f1")
    public ConfigRoot setList(TestList value) { this.list = value; return this; }
    /**  */
    @invar.InvarRule(T="test.xyz.TestDict", S="f2")
    public ConfigRoot setDict(TestDict value) { this.dict = value; return this; }
    /**  */
    @invar.InvarRule(T="test.xyz.TestNest", S="f3")
    public ConfigRoot setNest(TestNest value) { this.nest = value; return this; }
    /**  */
    @invar.InvarRule(T="test.abc.Info", S="f4")
    public ConfigRoot setInfo(Info value) { this.info = value; return this; }
    /**  */
    @invar.InvarRule(T="test.xyz.InfoX", S="f5")
    public ConfigRoot setInfox(InfoX value) { this.infox = value; return this; }
    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f6")
    public ConfigRoot setHotfix(LinkedHashMap<java.lang.String,java.lang.String> value) { this.hotfix = value; return this; }

    /** Shallow copy */
    public ConfigRoot copy(ConfigRoot from)
    {
        if (this == from || from == null) {
            return this;
        }
        revision = from.revision;
        list = from.list;
        dict = from.dict;
        nest = from.nest;
        info = from.info;
        infox = from.infox;
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
        revision = from.readUTF();
        list.read(from);
        dict.read(from);
        nest.read(from);
        info.read(from);
        infox.read(from);
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
        dest.writeUTF(revision);
        list.write(dest);
        dict.write(dest);
        nest.write(dest);
        info.write(dest);
        infox.write(dest);
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
        s.append(',').append("revision").append(':');
        s.append('"').append(revision).append('"');
        s.append(',').append("list").append(':');
        s.append('<').append("TestList").append('>');
        s.append(',').append("dict").append(':');
        s.append('<').append("TestDict").append('>');
        s.append(',').append("nest").append(':');
        s.append('<').append("TestNest").append('>');
        s.append(',').append("info").append(':');
        s.append('<').append("Info").append('>');
        s.append(',').append("infox").append(':');
        s.append('<').append("InfoX").append('>');
        s.append(", hotfix:");
        if (hotfix != null) {
            s.append('[').append(hotfix.size()).append(']');
        } else {
            s.append("null");
        }
        s.append('}');
        return s.toString();
    } //ConfigRoot::toString ()

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
        boolean revisionExists = revision != null && revision.length() > 0;
        if (revisionExists) {
            s.append('"').append("revision").append('"').append(':'); comma = ','; s.append('"').append(revision.toString()).append('"');
        }
        boolean listExists = (null != list);
        if ('\0' != comma && listExists) { s.append(comma); comma = '\0'; }
        if (listExists) {
            s.append('"').append("list").append('"').append(':'); comma = ','; list.writeJSON(s);
        }
        boolean dictExists = (null != dict);
        if ('\0' != comma && dictExists) { s.append(comma); comma = '\0'; }
        if (dictExists) {
            s.append('"').append("dict").append('"').append(':'); comma = ','; dict.writeJSON(s);
        }
        boolean nestExists = (null != nest);
        if ('\0' != comma && nestExists) { s.append(comma); comma = '\0'; }
        if (nestExists) {
            s.append('"').append("nest").append('"').append(':'); comma = ','; nest.writeJSON(s);
        }
        boolean infoExists = (null != info);
        if ('\0' != comma && infoExists) { s.append(comma); comma = '\0'; }
        if (infoExists) {
            s.append('"').append("info").append('"').append(':'); comma = ','; info.writeJSON(s);
        }
        boolean infoxExists = (null != infox);
        if ('\0' != comma && infoxExists) { s.append(comma); comma = '\0'; }
        if (infoxExists) {
            s.append('"').append("infox").append('"').append(':'); comma = ','; infox.writeJSON(s);
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
    } /* ConfigRoot::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "ConfigRoot");
        return code.toString();
    }

    public void writeXML(StringBuilder result, String name)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.append(' ').append("revision").append('=').append('"');
        attrs.append(revision).append('"');
        list.writeXML(nodes, "list");
        dict.writeXML(nodes, "dict");
        nest.writeXML(nodes, "nest");
        info.writeXML(nodes, "info");
        infox.writeXML(nodes, "infox");
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
    } /* ConfigRoot::writeXML(...) */

}

