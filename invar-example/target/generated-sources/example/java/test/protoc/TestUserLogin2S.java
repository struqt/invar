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

/** 客户端请求,服务端响应 */
public final class TestUserLogin2S
implements
invar.lib.InvarCodec.ProtocRequest,
invar.lib.InvarCodec.BinaryDecode,
invar.lib.InvarCodec.BinaryEncode,
invar.lib.InvarCodec.XMLEncode,
invar.lib.InvarCodec.JSONEncode
{
    static public final long CRC32 = 0xB29912EFL;

    static public TestUserLogin2S Create()
    {
        return new TestUserLogin2S();
    }

    private Integer/*U16*/               protocId ;/* [AutoAdd] ProtocolID */
    private Long/*U32*/                  protocCRC;/* [AutoAdd] Protocol CRC32 */
    private Protoc2S                     protoc2S ;/* [AutoAdd] 客户端请求的公共数据 */
    private Long                         userId   ;
    private String                       platform ;
    private LinkedHashMap<String,String> hotfix   ;/* [AutoAdd] Hotfix */

    public TestUserLogin2S()
    {
        protocId  = 65527;
        protocCRC = CRC32;
        protoc2S  = null;
        userId    = -1L;
        platform  = "";
        hotfix    = null;
    }

    public TestUserLogin2S reuse()
    {
        protocId = 65527;
        protocCRC = CRC32;
        if (protoc2S != null) {
            protoc2S.reuse();
        }
        userId = -1L;
        platform = "";
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /** [AutoAdd] ProtocolID */
    @invar.lib.InvarRule(T="uint16", S="f0")
    public Integer/*U16*/ getProtocId() { return protocId; }
    /** [AutoAdd] Protocol CRC32 */
    @invar.lib.InvarRule(T="uint32", S="f1")
    public Long/*U32*/ getProtocCRC() { return protocCRC; }
    /** [AutoAdd] 客户端请求的公共数据 */
    @invar.lib.InvarRule(T="test.protoc.Protoc2S", S="f2")
    public Protoc2S getProtoc2S() { return protoc2S; }
    /**  */
    @invar.lib.InvarRule(T="int64", S="f3")
    public Long getUserId() { return userId; }
    /**  */
    @invar.lib.InvarRule(T="string", S="f4")
    public String getPlatform() { return platform; }
    /** [AutoAdd] Hotfix */
    @invar.lib.InvarRule(T="map<string,string>", S="f5")
    public LinkedHashMap<java.lang.String,java.lang.String> getHotfix() { return hotfix; }

    /** [AutoAdd] 客户端请求的公共数据 */
    @invar.lib.InvarRule(T="test.protoc.Protoc2S", S="f2")
    public void setProtoc2S(Protoc2S value) { this.protoc2S = value; }
    /**  */
    @invar.lib.InvarRule(T="int64", S="f3")
    public void setUserId(Long value) { this.userId = value; }
    /**  */
    @invar.lib.InvarRule(T="string", S="f4")
    public void setPlatform(String value) { this.platform = value; }
    /** [AutoAdd] Hotfix */
    @invar.lib.InvarRule(T="map<string,string>", S="f5")
    public void setHotfix(LinkedHashMap<java.lang.String,java.lang.String> value) { this.hotfix = value; }

    /** Shallow copy */
    public TestUserLogin2S copy(TestUserLogin2S from_)
    {
        if (this == from_ || from_ == null) {
            return this;
        }
        protocId = from_.protocId;
        protocCRC = from_.protocCRC;
        if (from_.protoc2S != null) {
            protoc2S.copy(from_.protoc2S);
        } else {
            protoc2S = null;
        }
        userId = from_.userId;
        platform = from_.platform;
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
        userId = from_.readLong();
        platform = from_.readUTF();
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
        dest_.writeShort(protocId);
        dest_.writeInt(protocCRC.intValue());
        if (protoc2S != null) {
            dest_.writeByte((byte)0x01);
            protoc2S.write(dest_);
        } else {
            dest_.writeByte((byte)0x00);
        }
        dest_.writeLong(userId);
        dest_.writeUTF(platform);
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
        s.append(',').append("userId").append(':');
        s.append(userId.toString());
        s.append(',').append("platform").append(':');
        s.append('"').append(platform).append('"');
        s.append(", hotfix:");
        if (hotfix != null) {
            s.append('[').append(hotfix.size()).append(']');
        } else {
            s.append("null");
        }
        s.append('}');
        return s.toString();
    } //TestUserLogin2S::toString ()

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
        if ('\0' != comma) { s_.append(comma); comma = '\0'; }
        s_.append('"').append("userId").append('"').append(':');
        s_.append(userId.toString()); comma = ',';
        boolean platformExists = platform != null && platform.length() > 0;
        if ('\0' != comma && platformExists) { s_.append(comma); comma = '\0'; }
        if (platformExists) {
            s_.append('"').append("platform").append('"').append(':'); comma = ','; s_.append('"').append(platform.toString()).append('"');
        }
        boolean hotfixExists = (null != hotfix);
        if ('\0' != comma && hotfixExists) { s_.append(comma); comma = '\0'; }
        if (hotfixExists) {
            s_.append('"').append("hotfix").append('"').append(':'); comma = ',';
            if (null != hotfix) {
                s_.append('{');
                int hotfixSize = hotfix.size();
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
    } /* TestUserLogin2S::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "TestUserLogin2S");
        return code.toString();
    }

    public void writeXML(StringBuilder result_, String name_)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.append(' ').append("protocId").append('=').append('"');
        attrs.append(protocId.toString()).append('"');
        attrs.append(' ').append("protocCRC").append('=').append('"');
        attrs.append(protocCRC.toString()).append('"');
        if (protoc2S != null) {
            protoc2S.writeXML(nodes, "protoc2S");
        }
        attrs.append(' ').append("userId").append('=').append('"');
        attrs.append(userId.toString()).append('"');
        attrs.append(' ').append("platform").append('=').append('"');
        attrs.append(platform).append('"');
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
    } /* TestUserLogin2S::writeXML(...) */

}

