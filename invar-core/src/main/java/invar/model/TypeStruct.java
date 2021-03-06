/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.model;

import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.CRC32;

public class TypeStruct extends InvarType {

    private InvarType superType;
    private HashMap<String, InvarField> fields;
    private String charset;
    private String alias;
    private String tableName;
    private String shortField;
    private Boolean noHotfix = false;

    private long encodeSizeBasic = Long.MIN_VALUE;
    private String codecRuleCRC32Str = null;
    private String codecRule = "";
    private long codecRuleCRC32 = 0L;
    private HashSet<TypeStruct> depends = new HashSet<TypeStruct>(16);

    private TypeProtocol protoc;
    private String protocType;

    public TypeStruct(String name, InvarPackage pack, String comment) {
        super(TypeID.STRUCT, name, pack, comment, false);
        fields = new LinkedHashMap<String, InvarField>();
        setCharset("UTF-8");
        setAlias("");
        setTableName("");
    }

    public int numFields() {
        return fields.size();
    }

    public List<InvarField> listFields() {
        List<InvarField> list = new ArrayList<InvarField>();
        for (String key : fields.keySet()) {
            list.add(fields.get(key));
        }
        return list;
    }

    public int maxLenKeys() {
        int len = 1;
        for (String key : fields.keySet()) {
            if (key.length() > len)
                len = key.length();
        }
        return len;
    }

    public TypeStruct addField(InvarField f) throws Exception {
        checkKey(f.getKey());
        if (shortField != null)
            f.setShortName(shortField + fields.size());
        fields.put(f.getKey(), f);

        if (f.getType() != this && f.getType() instanceof TypeStruct) {
            depends.add((TypeStruct) f.getType());
        }
        for (InvarType t : f.getGenerics()) {
            if (t != this && t instanceof TypeStruct) {
                depends.add((TypeStruct) t);
            }
        }
        return this;
    }

    public Set<String> getKeys() {
        return fields.keySet();
    }

    public InvarField getField(String key) {
        return fields.get(key);
    }

    public TypeID getFieldType(String key) {
        return fields.get(key).getType().getId();
    }

    private void checkKey(String key) throws Exception {
        if (fields.containsKey(key)) {
            throw new Exception("Repeated key '" + key + //
                "' in struct '" + getName() + "'.");
        }
    }

    public String getCharset() {
        return charset;
    }

    public TypeStruct setCharset(String charset) {
        this.charset = charset;
        return this;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean isTable() {
        return tableName != null && tableName.length() > 0;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public InvarType getSuperType() {
        return superType;
    }

    public void setSuperType(InvarType superType) {
        this.superType = superType;
    }

    public String getShortField() {
        return shortField;
    }

    public void setShortField(String shortField) {
        this.shortField = shortField;
    }

    public Boolean getNoHotfix() {
        return noHotfix;
    }

    public void setNoHotfix(Boolean noHotfix) {
        this.noHotfix = noHotfix;
    }

    public String getCodecRule() {
        return codecRule;
    }

    public long getCodecRuleCRC32() {
        return codecRuleCRC32;
    }

    public String getCodecRuleCRC32String() {
        if (codecRuleCRC32Str != null) {
            return codecRuleCRC32Str;
        }
        String s = Long.toHexString(getCodecRuleCRC32());
        if (s.length() < 8) {
            int len = 8 - s.length();
            for (int i = 0; i < len; i++) {
                s = "0" + s;
            }
        }
        return codecRuleCRC32Str = s;
    }

    public TypeProtocol getProtoc() {
        return protoc;
    }

    public void setProtoc(TypeProtocol protoc) {
        this.protoc = protoc;
    }

    public String getProtocType() {
        return protocType;
    }

    public void setProtocType(String protocType) {
        this.protocType = protocType;
    }

    public Long encodeSizeBasic() {
        if (encodeSizeBasic < 0) {
            encodeSizeBasic = calculateEncodeSizeBasic(this);
        }
        return encodeSizeBasic;
    }

    public String codecRule() {
        if (null != codecRule && !"".equals(codecRule)) {
            //System.out.println(this.getName() + " ------------------> \n" + codecRule);
            return codecRule;
        }
        StringBuilder sb = new StringBuilder(256);
        sb.append(depends.size());
        sb.append(codecRuleFields(this));
        TreeSet<String> deps = new TreeSet<String>();
        for (TypeStruct struct : depends) {
            if (struct == this) {
                continue;
            }
            deps.add(codecRuleFields(struct));
        }
        for (String dep : deps) {
            sb.append('+');
            sb.append(dep);
        }
        this.codecRule = sb.toString();
        CRC32 crc = new CRC32();
        byte[] bytes = this.codecRule.getBytes(Charset.forName("UTF-8"));
        crc.update(bytes);
        this.codecRuleCRC32 = crc.getValue();
        //System.out.println(getName());
        //System.out.println(Invar.bytesToHex(bytes, 32));
        return this.codecRule;
    }

    static String codecRuleFields(TypeStruct t) {
        final int max = 98;
        StringBuilder sb = new StringBuilder();
        sb.append('@');
        sb.append(t.codecRuleName());
        for (InvarField f : t.fields.values()) {
            String rule;
            if (f.getType().getId().equals(TypeID.ENUM)) {
                rule = TypeID.INT32.getName();
            } else {
                rule = f.getRule();
            }
            if ("".equals(rule) || null == rule) {
                rule = "?";
            }
            sb.append('/');
            sb.append(rule);
        }
        sb.append('\n');
        int offset = -1;
        int len = sb.length();
        StringBuilder code = new StringBuilder(len + 24);
        for (int i = 0; i < len; i++) {
            char c = sb.charAt(i);
            code.append(c);
            offset++;
            if (offset == max) {
                code.append('\n').append(' ').append(' ');
                offset = 0;
            }
        }
        return code.toString();
    }

    static Long calculateEncodeSizeBasic(TypeStruct t) {
        long len = 0L;
        for (InvarField f : t.fields.values()) {
            Long size = f.getType().getRealId().getSize();
            if (size > 0) {
                len += f.getType().getRealId().getSize();
            } else {
                if (f.getUsePointer()) {
                    len += 1;
                } else {
                    switch (f.getType().getRealId()) {
                        case STRING:
                        case VEC:
                        case MAP:
                            len += 4;
                            break;
                        default:
                            break;
                    }
                }
            }
        }
        return len;
    }
}
