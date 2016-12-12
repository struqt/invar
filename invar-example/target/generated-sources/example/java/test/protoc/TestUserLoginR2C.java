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
import java.util.LinkedList;
import java.util.Map;

/** 客户端请求,服务端响应 */
public final class TestUserLoginR2C
implements
invar.lib.InvarCodec.ProtocResponse,
invar.lib.InvarCodec.BinaryDecode,
invar.lib.InvarCodec.BinaryEncode,
invar.lib.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0xAE3BF274L;

    static public TestUserLoginR2C Create()
    {
        return new TestUserLoginR2C();
    }

    private Integer/*U16*/               protocError;/* [AutoAdd] Protocol error code */
    private Integer/*U16*/               protocId   ;/* [AutoAdd] ProtocolID */
    private Long/*U32*/                  protocCRC  ;/* [AutoAdd] Protocol CRC32 */
    private Protoc2C                     protoc2C   ;/* [AutoAdd] 服务端响应的公共数据 */
    private String                       userId     ;
    private String                       userName   ;
    private LinkedList<Integer>          roles      ;
    private LinkedHashMap<String,String> hotfix     ;/* [AutoAdd] Hotfix */

    public TestUserLoginR2C()
    {
        protocError = 0;
        protocId    = 65528;
        protocCRC   = CRC32;
        protoc2C    = null;
        userId      = "";
        userName    = "";
        roles       = new LinkedList<Integer>();
        hotfix      = null;
    }

    public TestUserLoginR2C reuse()
    {
        protocError = 0;
        protocId = 65528;
        protocCRC = CRC32;
        if (protoc2C != null) {
            protoc2C.reuse();
        }
        userId = "";
        userName = "";
        roles.clear();
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
    /** [AutoAdd] 服务端响应的公共数据 */
    @invar.lib.InvarRule(T="test.protoc.Protoc2C", S="f3")
    public Protoc2C getProtoc2C() { return protoc2C; }
    /**  */
    @invar.lib.InvarRule(T="string", S="f4")
    public String getUserId() { return userId; }
    /**  */
    @invar.lib.InvarRule(T="string", S="f5")
    public String getUserName() { return userName; }
    /**  */
    @invar.lib.InvarRule(T="vec<int32>", S="f6")
    public LinkedList<Integer> getRoles() { return roles; }
    /** [AutoAdd] Hotfix */
    @invar.lib.InvarRule(T="map<string,string>", S="f7")
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
    /** [AutoAdd] 服务端响应的公共数据 */
    @invar.lib.InvarRule(T="test.protoc.Protoc2C", S="f3")
    public void setProtoc2C(Protoc2C value) { this.protoc2C = value; }
    /**  */
    @invar.lib.InvarRule(T="string", S="f4")
    public void setUserId(String value) { this.userId = value; }
    /**  */
    @invar.lib.InvarRule(T="string", S="f5")
    public void setUserName(String value) { this.userName = value; }
    /** [AutoAdd] Hotfix */
    @invar.lib.InvarRule(T="map<string,string>", S="f7")
    public void setHotfix(LinkedHashMap<java.lang.String,java.lang.String> value) { this.hotfix = value; }

    /** Shallow copy */
    public TestUserLoginR2C copy(TestUserLoginR2C from_)
    {
        if (this == from_ || from_ == null) {
            return this;
        }
        protocError = from_.protocError;
        protocId = from_.protocId;
        protocCRC = from_.protocCRC;
        if (from_.protoc2C != null) {
            protoc2C.copy(from_.protoc2C);
        } else {
            protoc2C = null;
        }
        userId = from_.userId;
        userName = from_.userName;
        roles.clear();
        roles.addAll(from_.roles);
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
        byte protoc2CExists = from_.readByte();
        if ((byte)0x01 == protoc2CExists) {
            if (protoc2C == null) { protoc2C = Protoc2C.Create(); }
            protoc2C.read(from_);
        }
        else if ((byte)0x00 == protoc2CExists) { protoc2C = null; }
        else { throw new CodecError(CodecError.ERR_DECODE_STRUCT_P); }
        userId = from_.readUTF();
        userName = from_.readUTF();
        roles.clear();
        Long lenRoles = from_.readInt() & 0xFFFFFFFFL;
        for (Long/*U32*/ iRoles = 0L; iRoles < lenRoles; ++iRoles) {
            Integer n1 = from_.readInt();
            roles.add(n1);
        }
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
        if (protoc2C != null) {
            dest_.writeByte((byte)0x01);
            protoc2C.write(dest_);
        } else {
            dest_.writeByte((byte)0x00);
        }
        dest_.writeUTF(userId);
        dest_.writeUTF(userName);
        dest_.writeInt(roles.size());
        for (Integer n1 : roles) {
            dest_.writeInt(n1);
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
        s.append(", protoc2C:");
        if (protoc2C != null) {
            s.append('<').append("Protoc2C").append('>');
        } else {
            s.append("null");
        }
        s.append(',').append("userId").append(':');
        s.append('"').append(userId).append('"');
        s.append(',').append("userName").append(':');
        s.append('"').append(userName).append('"');
        s.append(',').append("roles").append(':');
        s.append('(').append(roles.size()).append(')');
        s.append(", hotfix:");
        if (hotfix != null) {
            s.append('[').append(hotfix.size()).append(']');
        } else {
            s.append("null");
        }
        s.append('}');
        return s.toString();
    } //TestUserLoginR2C::toString ()

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
        boolean protoc2CExists = (null != protoc2C);
        if ('\0' != comma && protoc2CExists) { s_.append(comma); comma = '\0'; }
        if (protoc2CExists) {
            s_.append('"').append("protoc2C").append('"').append(':'); comma = ','; protoc2C.writeJSON(s_);
        }
        boolean userIdExists = userId != null && userId.length() > 0;
        if ('\0' != comma && userIdExists) { s_.append(comma); comma = '\0'; }
        if (userIdExists) {
            s_.append('"').append("userId").append('"').append(':'); comma = ','; s_.append('"').append(userId.toString()).append('"');
        }
        boolean userNameExists = userName != null && userName.length() > 0;
        if ('\0' != comma && userNameExists) { s_.append(comma); comma = '\0'; }
        if (userNameExists) {
            s_.append('"').append("userName").append('"').append(':'); comma = ','; s_.append('"').append(userName.toString()).append('"');
        }
        boolean rolesExists = (null != roles && roles.size() > 0);
        if ('\0' != comma && rolesExists) { s_.append(comma); comma = '\0'; }
        if (rolesExists) { s_.append('"').append("roles").append('"').append(':'); comma = ','; }
        int rolesSize = (null == roles ? 0 : roles.size());
        if (rolesSize > 0) {
            s_.append('[');
            int rolesIdx = 0;
            for (Integer n1 : roles) { /* vec.for: roles */
                ++rolesIdx;
                s_.append(n1.toString());
                if (rolesIdx != rolesSize) { s_.append(','); }
            }
            s_.append(']');
        }
        boolean hotfixExists = (null != hotfix && hotfix.size() > 0);
        if ('\0' != comma && hotfixExists) { s_.append(comma); comma = '\0'; }
        if (hotfixExists) {
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
            } comma = ',';
        }
        s_.append('}');
    } /* TestUserLoginR2C::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "TestUserLoginR2C");
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
        if (protoc2C != null) {
            protoc2C.writeXML(nodes, "protoc2C");
        }
        attrs.append(' ').append("userId").append('=').append('"');
        attrs.append(userId).append('"');
        attrs.append(' ').append("userName").append('=').append('"');
        attrs.append(userName).append('"');
        if (roles.size() > 0) {
            nodes.append('<').append("roles").append('>');
            for (Integer n1 : roles) {
                nodes.append('<').append("n1").append(' ').append("value").append('=').append('"');
                nodes.append(n1.toString()).append('"').append('/').append('>');
            }
            nodes.append('<').append('/').append("roles").append('>');
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
    } /* TestUserLoginR2C::writeXML(...) */

}

