package invar.model;

import invar.InvarContext;

import java.util.HashSet;
import java.util.regex.Matcher;

public class InvarType {
    public enum TypeID {
        INT08("int8"), INT16("int16"), INT32("int32"), INT64("int64"),
        UINT08("uint8"), UINT16("uint16"), UINT32("uint32"), UINT64("uint64"),
        FLOAT("float"), DOUBLE("double"), BOOL("bool"), ENUM("enum"),
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
        }

        TypeID(String name, String generic, Boolean refer, Boolean nullable) {
            this.name = name;
            this.generic = generic;
            this.useRefer = refer;
            this.nullable = nullable;
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

        final private String name;
        final private String generic;
        final private Boolean useRefer;
        final private Boolean nullable;
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
        if (uniqueName == null || "".equals(uniqueName)){
            this.uniqueName = pack.getName().replaceAll("\\.", "_") + "_" + name;
        }
        return uniqueName;
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
