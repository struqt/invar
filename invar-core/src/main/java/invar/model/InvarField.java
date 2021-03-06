/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.model;

import invar.InvarContext;
import invar.model.InvarType.TypeID;

import java.util.LinkedList;
import java.util.List;

public class InvarField {

    private static String prefix = null;

    public static String getPrefix() {
        return prefix;
    }

    public static void setPrefix(String prefix) {
        InvarField.prefix = prefix;
    }

    private final InvarType type;
    private final LinkedList<InvarType> generics;
    private final String key;
    private final String comment;

    private final Boolean disableSetter;
    private final Boolean isSpecial;
    private final Integer index;

    private Boolean useReference = false;
    private Boolean usePointer = false;
    private Boolean auto = false;
    private String alias = "";
    private String shortName = "";
    private String defaultVal = "";
    private String typeFormatted = "";
    private String deftFormatted = "";
    private String genericFormatted = "";
    private int widthType = 1;
    private int widthKey = 1;
    private int widthDefault = 1;
    private String codecRule = "";

    public InvarField(Integer index, InvarType type, String key, String comment, Boolean disableSetter, Boolean special) {
        this.index = index;
        this.type = type;
        this.generics = new LinkedList<InvarType>();
        this.key = key.trim();
        this.comment = comment;

        this.isSpecial = special;
        this.disableSetter = disableSetter;
        this.setDefault("");
    }

    public InvarType getType() {
        return type;
    }

    public String getKey() {
        return prefix == null ? key : prefix + key;
    }

    public String getRealKey() {
        return key;
    }

    public List<InvarType> getGenerics() {
        return generics;
    }

    public String getTypeFormatted() {
        return typeFormatted;
    }

    public String getDeftFormatted() {
        return deftFormatted;
    }

    public String getGenericFormatted() {
        return genericFormatted;
    }

    public String makeTypeFormatted(
        InvarContext ctx, String split, String splitType, Boolean fullName, String tName, Boolean noGenerics) {

        typeFormatted = tName;
        if (!noGenerics) {
            genericFormatted = evalGenerics(ctx, type.getRedirect(), split, splitType, fullName);
            typeFormatted += genericFormatted;
        }
        typeFormatted = typeFormatted.trim();
        ///* FIXME a trick for java
        if (typeFormatted.startsWith("java.lang.")) {
            typeFormatted = typeFormatted.substring(10, typeFormatted.length());
        } //*/
        return typeFormatted;
    }

    String evalGenerics(
        InvarContext ctx, InvarType typeBasic, String split, String splitType, Boolean fullName) {

        if (getGenerics().size() == 0)
            return "";
        String s = typeBasic.getGeneric();
        for (InvarType t : getGenerics()) {
            t = t.getRedirect();
            String tName = t.getName();
            if (fullName || ctx.findTypes(t.getName(), true).size() > 1)
                tName = t.fullName(split, splitType);
            s = s.replaceFirst("\\?", tName + t.getGeneric());
        }
        return s;
    }

    public String createAliasRule(InvarContext ctx, String split) {
        InvarType typeBasic = type;
        String s = typeBasic.getGeneric();
        for (InvarType t : getGenerics()) {
            String name = t.fullName(split);
            s = s.replaceFirst("\\?", name + t.getGeneric());
        }
        s = typeBasic.fullName(split) + s;
        return s;
    }
    /*
    public String createFullNameRule(InvarContext ctx, String split) {
        InvarType typeBasic = type.getRedirect();
        if (getGenerics().size() == 0)
            return typeBasic.fullName(split);
        String s = typeBasic.getGeneric();
        for (InvarType t : getGenerics()) {
            t = t.getRedirect();
            s = s.replaceFirst("\\?", t.fullName(split) + t.getGeneric());
        }
        return typeBasic.fullName(split) + s;
    } //*/

    public void setDefault(String defaultValue) {
        this.defaultVal = defaultValue;
    }

    public String getDefault() {
        return defaultVal;
    }

    public String getComment() {
        return comment;
    }

    public int getWidthKey() {
        return Math.min(widthKey, 24);
    }

    public int getWidthType() {
        return Math.min(widthType, 48);
    }

    public int getWidthDefault() {
        return Math.min(widthDefault, 48);
    }

    public boolean hasAlias() {
        return alias != null && alias.length() > 0;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getAuto() {
        return auto;
    }

    public void setAuto(Boolean auto) {
        this.auto = auto;
    }

    public void setWidthType(int widthType) {
        this.widthType = widthType;
    }

    public void setWidthKey(int widthKey) {
        this.widthKey = widthKey;
    }

    public void setWidthDefault(int widthDefault) {
        this.widthDefault = widthDefault;
    }

    public String getShortName() {
        return shortName == null ? "" : shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setDeftFormatted(String deftFormatted) {
        this.deftFormatted = deftFormatted;
    }

    public Boolean getDisableSetter() {
        return disableSetter;
    }

    public Boolean getUseReference() {
        return useReference;
    }

    public void setUseReference(Boolean useReference) {
        this.useReference = useReference;
        if (this.useReference)
            this.usePointer = false;
    }

    public Boolean getUsePointer() {
        return usePointer;
    }

    public void setUsePointer(Boolean usePointer) {
        this.usePointer = usePointer;
        if (this.usePointer)
            this.useReference = false;
    }

    public Integer getIndex() {
        return index;
    }

    public Boolean isVec() {
        return type.getId() == TypeID.VEC;
    }

    public Boolean isMap() {
        return type.getId() == TypeID.MAP;
    }

    public Boolean isSpecial() {
        return isSpecial;
    }

    public String getRule() {
        if (null != codecRule && !"".equals(codecRule)) {
            return codecRule;
        }
        StringBuilder sb = new StringBuilder(64);
        makeCodecRule(type, sb);
        for (InvarType t : generics) {
            sb.append('-');
            makeCodecRule(t, sb);
        }
        codecRule = sb.toString();
        return codecRule;
    }

    static void makeCodecRule(InvarType t, StringBuilder sb) {
        if (t instanceof TypeStruct) {
            sb.append(t.codecRuleName());
        } else if (t instanceof TypeEnum) {
            sb.append(TypeID.INT32.getName());
        } else {
            sb.append(t.getId().getName());
        }
    }
}
