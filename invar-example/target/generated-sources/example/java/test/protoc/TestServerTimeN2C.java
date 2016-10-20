/*===----------------------------*  Java 6  *------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.protoc;

import invar.lib.CodecError;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

/** 服务器通知客户端 */
public final class TestServerTimeN2C
implements
invar.lib.InvarCodec.ProtocNotify,
invar.lib.InvarCodec.BinaryDecode,
invar.lib.InvarCodec.BinaryEncode,
invar.lib.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0x85E08773L;

    static public TestServerTimeN2C Create()
    {
        return new TestServerTimeN2C();
    }

    private Integer                      protocId ;/* [AutoAdd] ProtocolID */
    private Long                         protocCRC;/* [AutoAdd] Protocol CRC32 */
    private Protoc2C                     protoc2C ;/* [AutoAdd] 服务端响应的公共数据 */
    private Long                         time     ;/* 现在时间 */
    private LinkedHashMap<String,String> hotfix   ;/* [AutoAdd] Hotfix */

    public TestServerTimeN2C()
    {
        protocId  = 65530;
        protocCRC = CRC32;
        protoc2C  = null;
        time      = -1L;
        hotfix    = null;
    }

    public TestServerTimeN2C reuse()
    {
        protocId = 65530;
        protocCRC = CRC32;
        if (protoc2C != null) {
            protoc2C.reuse();
        }
        time = -1L;
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /** [AutoAdd] ProtocolID */
    @invar.lib.InvarRule(T="uint16", S="f0")
    public Integer getProtocId() { return protocId; }

    /** [AutoAdd] Protocol CRC32 */
    @invar.lib.InvarRule(T="uint32", S="f1")
    public Long getProtocCRC() { return protocCRC; }

    /** [AutoAdd] 服务端响应的公共数据 */
    @invar.lib.InvarRule(T="test.protoc.Protoc2C", S="f2")
    public Protoc2C getProtoc2C() { return protoc2C; }

    /** 现在时间 */
    @invar.lib.InvarRule(T="int64", S="f3")
    public Long getTime() { return time; }

    /** [AutoAdd] Hotfix */
    @invar.lib.InvarRule(T="map<string,string>", S="f4")
    public LinkedHashMap<String,String> getHotfix() { return hotfix; }

    /** [AutoAdd] 服务端响应的公共数据 */
    @invar.lib.InvarRule(T="test.protoc.Protoc2C", S="f2")
    public void setProtoc2C(Protoc2C value) { this.protoc2C = value; }
    /** 现在时间 */
    @invar.lib.InvarRule(T="int64", S="f3")
    public void setTime(Long value) { this.time = value; }
    /** [AutoAdd] Hotfix */
    @invar.lib.InvarRule(T="map<string,string>", S="f4")
    public void setHotfix(LinkedHashMap<java.lang.String,java.lang.String> value) { this.hotfix = value; }

    /** Shallow copy */
    public TestServerTimeN2C copy(TestServerTimeN2C from)
    {
        if (this == from || from == null) {
            return this;
        }
        protocId = from.protocId;
        protocCRC = from.protocCRC;
        if (from.protoc2C != null) {
            protoc2C.copy(from.protoc2C);
        } else {
            protoc2C = null;
        }
        time = from.time;
        if (null == from.hotfix) {
            hotfix = null;
        } else {
            if (null == hotfix) { hotfix = new LinkedHashMap<java.lang.String,java.lang.String>(); }
            else { hotfix.clear(); }
            hotfix.putAll(from.hotfix);
        }
        return this;
    } /* copyFrom(...) */

    public void read(InputStream from) throws IOException, CodecError
    {
        this.read((DataInput)new DataInputStream(from));
    }

    public void read(DataInput from) throws IOException, CodecError
    {
        protocId = from.readUnsignedShort();
        protocCRC = from.readInt() & 0xFFFFFFFFL;
        if (CRC32 != protocCRC) { throw new CodecError(CodecError.ERR_PROTOC_CRC_MISMATCH); }
        byte protoc2CExists = from.readByte();
        if ((byte)0x01 == protoc2CExists) {
            if (protoc2C == null) { protoc2C = Protoc2C.Create(); }
            protoc2C.read(from);
        }
        else if ((byte)0x00 == protoc2CExists) { protoc2C = null; }
        else { throw new CodecError(CodecError.ERR_DECODE_STRUCT_P); }
        time = from.readLong();
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
        else { throw new CodecError(CodecError.ERR_DECODE_VEC_MAP_P); }
    }

    public void write(OutputStream from) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(from));
    }

    public void write(DataOutput dest) throws IOException
    {
        dest.writeShort(protocId);
        dest.writeInt(protocCRC.intValue());
        if (protoc2C != null) {
            dest.writeByte((byte)0x01);
            protoc2C.write(dest);
        } else {
            dest.writeByte((byte)0x00);
        }
        dest.writeLong(time);
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
        s.append(',').append("protocId").append(':');
        s.append(protocId.toString());
        s.append(',').append("protocCRC").append(':');
        s.append(protocCRC.toString());
        s.append(", protoc2C:");
        if (protoc2C != null) {
            s.append('<').append("Protoc2C").append('>');
        } else {
            s.append("null");
        }
        s.append(',').append("time").append(':');
        s.append(time.toString());
        s.append(", hotfix:");
        if (hotfix != null) {
            s.append('[').append(hotfix.size()).append(']');
        } else {
            s.append("null");
        }
        s.append('}');
        return s.toString();
    } //TestServerTimeN2C::toString ()

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
        s.append('"').append("protocId").append('"').append(':');
        s.append(protocId.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("protocCRC").append('"').append(':');
        s.append(protocCRC.toString()); comma = ',';
        boolean protoc2CExists = (null != protoc2C);
        if ('\0' != comma && protoc2CExists) { s.append(comma); comma = '\0'; }
        if (protoc2CExists) {
            s.append('"').append("protoc2C").append('"').append(':'); comma = ','; protoc2C.writeJSON(s);
        }
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("time").append('"').append(':');
        s.append(time.toString()); comma = ',';
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
    } /* TestServerTimeN2C::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "TestServerTimeN2C");
        return code.toString();
    }

    public void writeXML(StringBuilder result, String name)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.append(' ').append("protocId").append('=').append('"');
        attrs.append(protocId.toString()).append('"');
        attrs.append(' ').append("protocCRC").append('=').append('"');
        attrs.append(protocCRC.toString()).append('"');
        if (protoc2C != null) {
            protoc2C.writeXML(nodes, "protoc2C");
        }
        attrs.append(' ').append("time").append('=').append('"');
        attrs.append(time.toString()).append('"');
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
    } /* TestServerTimeN2C::writeXML(...) */

}

