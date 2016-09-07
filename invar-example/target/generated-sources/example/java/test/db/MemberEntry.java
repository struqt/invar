/*===----------------------------*  Java 6  *------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.db;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** 名字冲突的类型 */
public final class MemberEntry
implements
invar.InvarCodec.BinaryDecode,
invar.InvarCodec.BinaryEncode,
invar.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0x240151L;

    static public MemberEntry Create()
    {
        return new MemberEntry();
    }

    private Long                         id        ;/* 主键，自增长 */
    private String                       phone     ;/* 手机号码 */
    private String                       nickName  ;/* 会员昵称 */
    private Long                         createTime;/* 创建时间 */
    private Long                         updateTime;/* 创建时间 */
    private LinkedHashMap<String,String> hotfix    ;/* [AutoAdd] Hotfix */

    public MemberEntry()
    {
        id         = 0L;
        phone      = "";
        nickName   = "";
        createTime = -1L;
        updateTime = -1L;
        hotfix     = null;
    }

    public MemberEntry reuse()
    {
        id = 0L;
        phone = "";
        nickName = "";
        createTime = -1L;
        updateTime = -1L;
        if (hotfix != null) {
            hotfix.clear();
        }
        return this;
    }

    /** 主键，自增长 */
    @invar.InvarRule(T="uint32", S="f0")
    public Long getId() { return id; }

    /** 手机号码 */
    @invar.InvarRule(T="string", S="f1")
    public String getPhone() { return phone; }

    /** 会员昵称 */
    @invar.InvarRule(T="string", S="f2")
    public String getNickName() { return nickName; }

    /** 创建时间 */
    @invar.InvarRule(T="int64", S="f3")
    public Long getCreateTime() { return createTime; }

    /** 创建时间 */
    @invar.InvarRule(T="int64", S="f4")
    public Long getUpdateTime() { return updateTime; }

    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f5")
    public LinkedHashMap<String,String> getHotfix() { return hotfix; }

    /** 主键，自增长 */
    @invar.InvarRule(T="uint32", S="f0")
    public MemberEntry setId(long value) throws NumberFormatException
    {
        if (value < 0 || value > 0xFFFFFFFFL) {
            throw new NumberFormatException("uint32 value out of range: " + value);
        }
        this.id = value;
        return this;
    }
    /** 手机号码 */
    @invar.InvarRule(T="string", S="f1")
    public MemberEntry setPhone(String value) { this.phone = value; return this; }
    /** 会员昵称 */
    @invar.InvarRule(T="string", S="f2")
    public MemberEntry setNickName(String value) { this.nickName = value; return this; }
    /** 创建时间 */
    @invar.InvarRule(T="int64", S="f3")
    public MemberEntry setCreateTime(Long value) { this.createTime = value; return this; }
    /** 创建时间 */
    @invar.InvarRule(T="int64", S="f4")
    public MemberEntry setUpdateTime(Long value) { this.updateTime = value; return this; }
    /** [AutoAdd] Hotfix */
    @invar.InvarRule(T="map<string,string>", S="f5")
    public MemberEntry setHotfix(LinkedHashMap<java.lang.String,java.lang.String> value) { this.hotfix = value; return this; }

    /** Shallow copy */
    public MemberEntry copy(MemberEntry from)
    {
        if (this == from || from == null) {
            return this;
        }
        id = from.id;
        phone = from.phone;
        nickName = from.nickName;
        createTime = from.createTime;
        updateTime = from.updateTime;
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
        id = from.readInt() & 0xFFFFFFFFL;
        phone = from.readUTF();
        nickName = from.readUTF();
        createTime = from.readLong();
        updateTime = from.readLong();
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
        dest.writeInt(id.intValue());
        dest.writeUTF(phone);
        dest.writeUTF(nickName);
        dest.writeLong(createTime);
        dest.writeLong(updateTime);
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
        s.append(',').append("id").append(':');
        s.append(id.toString());
        s.append(',').append("phone").append(':');
        s.append('"').append(phone).append('"');
        s.append(',').append("nickName").append(':');
        s.append('"').append(nickName).append('"');
        s.append(',').append("createTime").append(':');
        s.append(createTime.toString());
        s.append(',').append("updateTime").append(':');
        s.append(updateTime.toString());
        s.append(", hotfix:");
        if (hotfix != null) {
            s.append('[').append(hotfix.size()).append(']');
        } else {
            s.append("null");
        }
        s.append('}');
        return s.toString();
    } //MemberEntry::toString ()

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
        s.append('"').append("id").append('"').append(':');
        s.append(id.toString()); comma = ',';
        boolean phoneExists = phone != null && phone.length() > 0;
        if ('\0' != comma && phoneExists) { s.append(comma); comma = '\0'; }
        if (phoneExists) {
            s.append('"').append("phone").append('"').append(':'); comma = ','; s.append('"').append(phone.toString()).append('"');
        }
        boolean nickNameExists = nickName != null && nickName.length() > 0;
        if ('\0' != comma && nickNameExists) { s.append(comma); comma = '\0'; }
        if (nickNameExists) {
            s.append('"').append("nickName").append('"').append(':'); comma = ','; s.append('"').append(nickName.toString()).append('"');
        }
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("createTime").append('"').append(':');
        s.append(createTime.toString()); comma = ',';
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("updateTime").append('"').append(':');
        s.append(updateTime.toString()); comma = ',';
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
    } /* MemberEntry::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "MemberEntry");
        return code.toString();
    }

    public void writeXML(StringBuilder result, String name)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.append(' ').append("id").append('=').append('"');
        attrs.append(id.toString()).append('"');
        attrs.append(' ').append("phone").append('=').append('"');
        attrs.append(phone).append('"');
        attrs.append(' ').append("nickName").append('=').append('"');
        attrs.append(nickName).append('"');
        attrs.append(' ').append("createTime").append('=').append('"');
        attrs.append(createTime.toString()).append('"');
        attrs.append(' ').append("updateTime").append('=').append('"');
        attrs.append(updateTime.toString()).append('"');
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
    } /* MemberEntry::writeXML(...) */

    public Object[] SqlParamsAll()
    {
        return new Object[] {
            phone,
            nickName,
        };
    }

    static public final class SQL {

        static public final String TABLE = "tbl_member";

        static public invar.InvarSQL getBuilder() {
            if (builder == null) {
                builder = invar.InvarSQL.Create(
                    TABLE, getWritableFields(), getAliasMap());
            }
            return builder;
        }

        static private invar.InvarSQL builder = null;

        static private List<String> writableFields = null;

        static private List<String> getWritableFields() {
            if (writableFields != null) {
                return writableFields;
            }
            List<String> list = new ArrayList<String>();
            list.add("phone");
            list.add("nick_name");
            return writableFields = list;
        }

        static private Map<String, String> aliasMap = null;

        static private Map<String, String> getAliasMap() {
            if (aliasMap != null) {
                return aliasMap;
            }
            Map<String, String> map = new LinkedHashMap<String, String>();
            map.put("id", "id");
            map.put("phone", "phone");
            map.put("nick_name", "nickName");
            map.put("create_time", "createTime");
            map.put("update_time", "updateTime");
            return aliasMap = map;
        }

    }

}
