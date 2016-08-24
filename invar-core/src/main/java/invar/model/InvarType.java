/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.model;

import invar.InvarContext;

import java.util.HashSet;
import java.util.regex.Matcher;

public class InvarType {
    public enum TypeID {
        INT08("int8", 1), INT16("int16", 2), INT32("int32", 4), INT64("int64", 8),
        UINT08("uint8", 1), UINT16("uint16", 2), UINT32("uint32", 4), UINT64("uint64", 8),
        FLOAT("float", 4), DOUBLE("double", 8), BOOL("bool", 1), ENUM("enum", 4),
        STRING("string", "", true, true),
        VEC("vec", "<?>", true, true),
        MAP("map", "<?,?>", true, true),
        STRUCT("struct", "", true, true),
        //FUNC("func", "<?...>", true, false),
        DIALECT("~~~", "", true, false),
        PROTOCOL("protoc"), VOID("---");

        TypeID(String name) {
            this.name = name;
            this.generic = "";
            this.useRefer = false;
            this.nullable = false;
            this.size = 0L;
        }

        TypeID(String name, long size) {
            this.name = name;
            this.generic = "";
            this.useRefer = false;
            this.nullable = false;
            this.size = size;
        }

        TypeID(String name, String generic, Boolean refer, Boolean nullable) {
            this.name = name;
            this.generic = generic;
            this.useRefer = refer;
            this.nullable = nullable;
            this.size = 0L;
        }

        public String getName() {
            return name;
        }

        public String getGeneric() {
            return generic;
        }

        public Boolean getUseRefer() {
            return useRefer;
        }

        public Boolean getNullable() {
            return nullable;
        }

        public Long getSize() {
            return size;
        }

        final private String name;
        final private String generic;
        final private Boolean useRefer;
        final private Boolean nullable;
        final private Long size;
    }

    static private final HashSet<String> typeNames = new HashSet<String>(512);

    private final TypeID id;
    private final InvarPackage pack;
    private final String name;
    private final String comment;
    private final Boolean isBuildin;
    private TypeID realId;
    private InvarType redirect;
    private String generic;
    private Boolean isConflict;
    private String initValue;
    private String codePath;
    private String codeName;
    private String uniqueName;

    public InvarType(TypeID id, String name, InvarPackage pack, String comment, Boolean isBuildin) {
        this.id = id;
        this.name = name;
        this.comment = comment;
        this.pack = pack;
        this.generic = "";
        this.initValue = "";
        this.codePath = "";
        this.codeName = name;
        this.isBuildin = isBuildin;
        if (typeNames.contains(name)) {
            this.isConflict = true;
        } else {
            this.isConflict = false;
            typeNames.add(name);
        }
    }

    final public String fullName(String splitter) {
        String packName = pack.getName();
        packName = packName.replaceAll("\\.", Matcher.quoteReplacement(splitter));
        return !isBuildin() && !packName.equals("") ? packName + splitter + name : name;
    }

    final public String codecRuleName() {
        StringBuilder sb = new StringBuilder(64);
        if (getPack() != null && getPack().getName() != null && getPack().getName().length() > 0) {
            sb.append(getPack().getName().toLowerCase());
            sb.append('.');
        }
        sb.append(getName());
        return sb.toString();
    }

    final public TypeID getId() {
        return id;
    }

    final public InvarPackage getPack() {
        return pack;
    }

    final public String getName() {
        return name;
    }

    final public Boolean getConflict(InvarContext ctx) {
        if (isConflict) {
            return true;
        }
        if (ctx.findTypes(this.getName()).size() > 1) {
            isConflict = true;
            return true;
        }
        return false;
    }

    final public String getUniqueName() {
        if (uniqueName == null || "".equals(uniqueName)) {
            String[] packs = pack.getName().split("\\.");
            this.uniqueName = "";
            for (String pack : packs) {
                if (pack.length() < 1) {
                    continue;
                }
                this.uniqueName += upperHeadChar(pack);
            }
            this.uniqueName += name;
        }
        return uniqueName;
    }

    static String upperHeadChar(String s) {
        String ss = s.substring(0, 1).toUpperCase();
        if (s.length() > 1) {
            ss += s.substring(1, s.length());
        }
        return ss;
    }

    final public String getComment() {
        return comment;
    }

    final public String getGeneric() {
        return generic;
    }

    final public InvarType getRedirect() {
        return redirect == null ? this : redirect;
    }

    final public String getInitValue() {
        return initValue;
    }

    final public void setGeneric(String template) {
        this.generic = template;
    }

    public void setRedirect(InvarType redirect) {
        this.redirect = redirect;
    }

    public void setInitValue(String construct) {
        this.initValue = construct;
    }

    public TypeID getRealId() {
        return realId != null ? realId : id;
    }

    public void setRealId(TypeID realId) {
        this.realId = realId;
    }

    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public Boolean isBuildin() {
        return isBuildin;
    }

}
