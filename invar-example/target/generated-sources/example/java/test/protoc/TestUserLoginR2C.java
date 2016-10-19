/*===----------------------------*  Java 6  *------------------------------===//
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

    private Integer                      protocError;/* [AutoAdd] Protocol error code */
    private Integer                      protocId   ;/* [AutoAdd] ProtocolID */
    private Long                         protocCRC  ;/* [AutoAdd] Protocol CRC32 */
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
    public Integer getProtocError() { return protocError; }

    /** [AutoAdd] ProtocolID */
    @invar.lib.InvarRule(T="uint16", S="f1")
    public Integer getProtocId() { return protocId; }

    /** [AutoAdd] Protocol CRC32 */
    @invar.lib.InvarRule(T="uint32", S="f2")
    public Long getProtocCRC() { return protocCRC; }

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
    public LinkedHashMap<String,String> getHotfix() { return hotfix; }

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
    public TestUserLoginR2C copy(TestUserLoginR2C from)
    {
        if (this == from || from == null) {
            return this;
        }
        protocError = from.protocError;
        protocId = from.protocId;
        protocCRC = from.protocCRC;
        if (from.protoc2C != null) {
            protoc2C.copy(from.protoc2C);
        } else {
            protoc2C = null;
        }
        userId = from.userId;
        userName = from.userName;
        roles.clear();
        roles.addAll(from.roles);
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
        protocError = from.readUnsignedShort();
        if (protocError != 0) {
            throw new IOException("Protoc read error: The code is " + protocError);
        }
        protocId = from.readUnsignedShort();
        protocCRC = from.readInt() & 0xFFFFFFFFL;
        if (CRC32 != protocCRC) { throw new IOException("Protoc read error: CRC32 is mismatched. 499"); }
        byte protoc2CExists = from.readByte();
        if ((byte)0x01 == protoc2CExists) {
            if (protoc2C == null) { protoc2C = new Protoc2C(); }
            protoc2C.read(from);
        }
        else if ((byte)0x00 == protoc2CExists) { protoc2C = null; }
        else { throw new IOException("Protoc read error: The value of 'protoc2CExists' is invalid. 497"); }
        userId = from.readUTF();
        userName = from.readUTF();
        roles.clear();
        Long lenRoles = from.readInt() & 0xFFFFFFFFL;
        for (Long iRoles = 0L; iRoles < lenRoles; ++iRoles) {
            Integer n1 = from.readUnsignedShort();
            roles.add(n1);
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
        dest.writeShort(protocError);
        dest.writeShort(protocId);
        dest.writeInt(protocCRC.intValue());
        if (protoc2C != null) {
            dest.writeByte((byte)0x01);
            protoc2C.write(dest);
        } else {
            dest.writeByte((byte)0x00);
        }
        dest.writeUTF(userId);
        dest.writeUTF(userName);
        dest.writeInt(roles.size());
        for (Integer n1 : roles) {
            dest.writeShort(n1);
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

    public void writeJSON(StringBuilder s)
    {
        s.append('{');
        char comma = '\0';
        s.append('"').append("protocError").append('"').append(':');
        s.append(protocError.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
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
        boolean userIdExists = userId != null && userId.length() > 0;
        if ('\0' != comma && userIdExists) { s.append(comma); comma = '\0'; }
        if (userIdExists) {
            s.append('"').append("userId").append('"').append(':'); comma = ','; s.append('"').append(userId.toString()).append('"');
        }
        boolean userNameExists = userName != null && userName.length() > 0;
        if ('\0' != comma && userNameExists) { s.append(comma); comma = '\0'; }
        if (userNameExists) {
            s.append('"').append("userName").append('"').append(':'); comma = ','; s.append('"').append(userName.toString()).append('"');
        }
        boolean rolesExists = (null != roles && roles.size() > 0);
        if ('\0' != comma && rolesExists) { s.append(comma); comma = '\0'; }
        if (rolesExists) { s.append('"').append("roles").append('"').append(':'); comma = ','; }
        int rolesSize = (null == roles ? 0 : roles.size());
        if (rolesSize > 0) {
            s.append('[');
            int rolesIdx = 0;
            for (Integer n1 : roles) { /* vec.for: roles */
                ++rolesIdx;
                s.append(n1.toString());
                if (rolesIdx != rolesSize) { s.append(','); }
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
    } /* TestUserLoginR2C::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "TestUserLoginR2C");
        return code.toString();
    }

    public void writeXML(StringBuilder result, String name)
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
                nodes.append(n1.toString()).append('"').append('>');
            }
            nodes.append('<').append('/').append("roles").append('>');
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
    } /* TestUserLoginR2C::writeXML(...) */

}

