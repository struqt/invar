package invar.model;

import java.util.*;
import java.util.zip.CRC32;

public class TypeStruct extends InvarType {

    private InvarType superType;
    private HashMap<String, InvarField> fields;
    private String charset;
    private String alias;
    private String shortField;
    private Boolean noHotfix = false;

    private String codecRule = "";
    private long codecRuleCRC32 = 0L;
    private HashSet<TypeStruct> depends = new HashSet<TypeStruct>(16);

    public TypeStruct(String name, InvarPackage pack, String comment) {
        super(TypeID.STRUCT, name, pack, comment, false);
        fields = new LinkedHashMap<String, InvarField>();
        setCharset("UTF-8");
        setAlias("");
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

    public String codecRule() {
        if (null != codecRule && !"".equals(codecRule)) {
            //System.out.println(this.getName() + " ------------------> \n" + codecRule);
            return codecRule;
        }
        StringBuilder sb = new StringBuilder(256);
        sb.append(depends.size());
        codecRuleFields(this, sb);
        for (TypeStruct struct : depends) {
            if (struct == this) {
                continue;
            }
            sb.append('+');
            codecRuleFields(struct, sb);
        }
        this.codecRule = sb.toString();
        CRC32 crc = new CRC32();
        crc.update(this.codecRule.getBytes());
        this.codecRuleCRC32 = crc.getValue();
        return this.codecRule;
    }

    static void codecRuleFields(TypeStruct t, StringBuilder sb) {
        sb.append('@');
        sb.append(t.fullName("."));
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
    }
}
