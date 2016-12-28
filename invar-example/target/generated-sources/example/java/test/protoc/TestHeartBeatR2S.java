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

/** 服务端请求,客户端响应 */
public final class TestHeartBeatR2S
implements
invar.lib.InvarCodec.ProtocResponse,
invar.lib.InvarCodec.BinaryDecode,
invar.lib.InvarCodec.BinaryEncode,
invar.lib.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0xA13D5F14L;

    static public TestHeartBeatR2S Create()
    {
        return new TestHeartBeatR2S();
    }

    private Integer/*U16*/               protocError;/* [AutoAdd] Protocol error code */
    private Integer/*U16*/               protocId   ;/* [AutoAdd] ProtocolID */
    private Long/*U32*/                  protocCRC  ;/* [AutoAdd] Protocol CRC32 */
    private Protoc2S                     protoc2S   ;/* [AutoAdd] 客户端请求的公共数据 */
    private LinkedHashMap<String,String> hotfix     ;/* [AutoAdd] Hotfix */

    public TestHeartBeatR2S()
    {
        protocError = 0;
        protocId    = 65533;
        protocCRC   = CRC32;
        protoc2S    = null;
        hotfix      = null;
    }

    public TestHeartBeatR2S reuse()
    {
        protocError = 0;
        protocId = 65533;
        protocCRC = CRC32;
        if (protoc2S != null) {
            protoc2S.reuse();
        }
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /** [AutoAdd] Protocol error code */
    @invar.lib.InvarRule(T="uint16", S="f0")
    public Integer/*U16*/ getProtocError() { return protocError; }
    /** [AutoAdd] ProtocolID */
    @invar.lib.InvarRule(T="uint16", S="f1")
    public Integer/*U16*/ getProtocId() { return protocId; }
    /** [AutoAdd] Protocol CRC32 */
    @invar.lib.InvarRule(T="uint32", S="f2")
    public Long/*U32*/ getProtocCRC() { return protocCRC; }
    /** [AutoAdd] 客户端请求的公共数据 */
    @invar.lib.InvarRule(T="test.protoc.Protoc2S", S="f3")
    public Protoc2S getProtoc2S() { return protoc2S; }
    /** [AutoAdd] Hotfix */
    @invar.lib.InvarRule(T="map<string,string>", S="f4")
    public LinkedHashMap<java.lang.String,java.lang.String> getHotfix() { return hotfix; }

    /** [AutoAdd] Protocol error code */
    @invar.lib.InvarRule(T="uint16", S="f0")
    public void setProtocError(int value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFFFF) {
            throw new NumberFormatException("uint16 value out of range: " + value);
        }
        this.protocError = value;
    }
    /** [AutoAdd] 客户端请求的公共数据 */
    @invar.lib.InvarRule(T="test.protoc.Protoc2S", S="f3")
    public void setProtoc2S(Protoc2S value) { this.protoc2S = value; }
    /** [AutoAdd] Hotfix */
    @invar.lib.InvarRule(T="map<string,string>", S="f4")
    public void setHotfix(LinkedHashMap<java.lang.String,java.lang.String> value) { this.hotfix = value; }

    /** Shallow copy */
    public TestHeartBeatR2S copy(TestHeartBeatR2S from_)
    {
        if (this == from_ || from_ == null) {
            return this;
        }
        protocError = from_.protocError;
        protocId = from_.protocId;
        protocCRC = from_.protocCRC;
        if (from_.protoc2S != null) {
            protoc2S.copy(from_.protoc2S);
        } else {
            protoc2S = null;
        }
        if (null == from_.hotfix) {
            hotfix = null;
        } else {
            if (null == hotfix) { hotfix = new LinkedHashMap<java.lang.String,java.lang.String>(); }
            else { hotfix.clear(); }
            hotfix.putAll(from_.hotfix);
        }
        return this;
    } /* copyFrom(...) */

    public void read(InputStream from_) throws IOException, CodecError
    {
        this.read((DataInput)new DataInputStream(from_));
    }

    public void read(DataInput from_) throws IOException, CodecError
    {
        protocError = from_.readUnsignedShort();
        if (protocError != 0) {
            throw new CodecError(protocError);
        }
        protocId = from_.readUnsignedShort();
        protocCRC = from_.readInt() & 0xFFFFFFFFL;
        if (CRC32 != protocCRC) { throw new CodecError(CodecError.ERR_PROTOC_CRC_MISMATCH); }
        byte protoc2SExists = from_.readByte();
        if ((byte)0x01 == protoc2SExists) {
            if (protoc2S == null) { protoc2S = Protoc2S.Create(); }
            protoc2S.read(from_);
        }
        else if ((byte)0x00 == protoc2SExists) { protoc2S = null; }
        else { throw new CodecError(CodecError.ERR_DECODE_STRUCT_P); }
        byte hotfixExists = from_.readByte();
        if ((byte)0x01 == hotfixExists) {
            if (hotfix == null) { hotfix = new LinkedHashMap<java.lang.String,java.lang.String>(); }
            Long lenHotfix = from_.readInt() & 0xFFFFFFFFL;
            for (Long/*U32*/ iHotfix = 0L; iHotfix < lenHotfix; ++iHotfix) {
                java.lang.String k1 = from_.readUTF();
                java.lang.String v1 = from_.readUTF();
                hotfix.put(k1,v1);
            }
        }
        else if ((byte)0x00 == hotfixExists) { hotfix = null; }
        else { throw new CodecError(CodecError.ERR_DECODE_VEC_MAP_P); }
    }

    public void write(OutputStream dest_) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(dest_));
    }

    public void write(DataOutput dest_) throws IOException
    {
        dest_.writeShort(protocError);
        dest_.writeShort(protocId);
        dest_.writeInt(protocCRC.intValue());
        if (protoc2S != null) {
            dest_.writeByte((byte)0x01);
            protoc2S.write(dest_);
        } else {
            dest_.writeByte((byte)0x00);
        }
        if (hotfix != null) {
            dest_.writeByte((byte)0x01);
            dest_.writeInt(hotfix.size());
            for (Map.Entry<java.lang.String,java.lang.String> hotfixIter : hotfix.entrySet()) {
                java.lang.String k1 = hotfixIter.getKey();
                dest_.writeUTF(k1);
                java.lang.String v1 = hotfixIter.getValue();
                dest_.writeUTF(v1);
            }
        } else {
            dest_.writeByte((byte)0x00);
        }
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append('{');
        s.append(getClass().getName());
        s.append(',').append("protocError").append(':');
        s.append(protocError.toString());
        s.append(',').append("protocId").append(':');
        s.append(protocId.toString());
        s.append(',').append("protocCRC").append(':');
        s.append(protocCRC.toString());
        s.append(", protoc2S:");
        if (protoc2S != null) {
            s.append('<').append("Protoc2S").append('>');
        } else {
            s.append("null");
        }
        s.append(", hotfix:");
        if (hotfix != null) {
            s.append('[').append(hotfix.size()).append(']');
        } else {
            s.append("null");
        }
        s.append('}');
        return s.toString();
    } //TestHeartBeatR2S::toString ()

    public String toStringJSON()
    {
        StringBuilder code = new StringBuilder();
        this.writeJSON(code);
        return code.toString();
    }

    public void writeJSON(StringBuilder s_)
    {
        s_.append('{');
        char comma = '\0';
        s_.append('"').append("protocError").append('"').append(':');
        s_.append(protocError.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("protocId").append('"').append(':');
        s_.append(protocId.toString()); comma = ',';
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("protocCRC").append('"').append(':');
        s_.append(protocCRC.toString()); comma = ',';
        boolean protoc2SExists = (null != protoc2S);
        if ('\0' != comma && protoc2SExists) { s_.append(comma); comma = '\0'; }
        if (protoc2SExists) {
            s_.append('"').append("protoc2S").append('"').append(':'); comma = ','; protoc2S.writeJSON(s_);
        }
        boolean hotfixExists = (null != hotfix && hotfix.size() > 0);
        if ('\0' != comma && hotfixExists) { s_.append(comma); comma = '\0'; }
        if (hotfixExists) {
            s_.append('"').append("hotfix").append('"').append(':'); comma = ',';
            int hotfixSize = (null == hotfix ? 0 : hotfix.size());
            if (hotfixSize > 0) {
                s_.append('{');
                int hotfixIdx = 0;
                for (Map.Entry<java.lang.String,java.lang.String> hotfixIter : hotfix.entrySet()) { /* map.for: hotfix */
                    ++hotfixIdx;
                    java.lang.String k1 = hotfixIter.getKey(); /* nest.k */
                    s_.append('"').append(k1.toString()).append('"'); s_.append(':');
                    java.lang.String v1 = hotfixIter.getValue(); /* nest.v */
                    s_.append('"').append(v1.toString()).append('"');
                    if (hotfixIdx != hotfixSize) { s_.append(','); }
                }
                s_.append('}');
            }
        }
        s_.append('}');
    } /* TestHeartBeatR2S::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "TestHeartBeatR2S");
        return code.toString();
    }

    public void writeXML(StringBuilder result_, String name_)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.append(' ').append("protocError").append('=').append('"');
        attrs.append(protocError.toString()).append('"');
        attrs.append(' ').append("protocId").append('=').append('"');
        attrs.append(protocId.toString()).append('"');
        attrs.append(' ').append("protocCRC").append('=').append('"');
        attrs.append(protocCRC.toString()).append('"');
        if (protoc2S != null) {
            protoc2S.writeXML(nodes, "protoc2S");
        }
        if (hotfix != null && hotfix.size() > 0) {
            nodes.append('<').append("hotfix").append('>');
            for (Map.Entry<java.lang.String,java.lang.String> hotfixIter : hotfix.entrySet()) {
                java.lang.String k1 = hotfixIter.getKey();
                nodes.append('<').append("k1").append(' ').append("value").append('=').append('"');
                nodes.append(k1).append('"').append('/').append('>');
                java.lang.String v1 = hotfixIter.getValue();
                nodes.append('<').append("v1").append(' ').append("value").append('=').append('"');
                nodes.append(v1).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("hotfix").append('>');
        }
        result_.append('<').append(name_).append(attrs);
        if (nodes.length() == 0) {
            result_.append('/').append('>');
        } else {
            result_.append('>').append(nodes);
            result_.append('<').append('/').append(name_).append('>');
        }
    } /* TestHeartBeatR2S::writeXML(...) */

}

