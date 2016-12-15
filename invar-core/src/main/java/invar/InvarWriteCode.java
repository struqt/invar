/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar;

import invar.InvarSnippet.Key;
import invar.InvarSnippet.Token;
import invar.model.*;
import invar.model.InvarType.TypeID;

import java.io.File;
import java.lang.reflect.Method;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public final class InvarWriteCode extends InvarWrite {

    final private InvarSnippet snippet;
    final private HashMap<String, Method> mapInvoke;
    final private Pattern patternInvoke;
    final private NestedCoder nestedCoder;
    final private TreeSet<String> fileIncludes;

    public InvarWriteCode(InvarContext ctx, String dirRootPath, String snippetPath, String snippetDir) throws Exception {
        super(ctx, dirRootPath);
        this.snippet = new InvarSnippet(ctx, snippetDir, snippetPath, this);
        this.fileIncludes = new TreeSet<String>();
        this.nestedCoder = new NestedCoder();

        this.patternInvoke = Pattern.compile("\\[#\\S+.*\\(.*\\)\\]");
        this.mapInvoke = new HashMap<String, Method>(32);

        funcPublish("upperHeadChar", String.class);
        funcPublish("clampLen", Integer.class, Integer.class, String.class);
        funcPublish("snippetTryGet", String.class);
        funcPublish("addImport", TypeStruct.class, TreeSet.class, String.class);
        funcPublish("mathMax", Integer.class, Integer.class);

        funcPublish("operatorLess", TypeStruct.class);
        funcPublish("codeInits", TypeStruct.class, List.class);
        funcPublish("codeDeletes", List.class);
        funcPublish("codeCRC32", TypeStruct.class);
        funcPublish("codeBasicSize", TypeStruct.class);
        funcPublish("codeFields", TypeStruct.class, List.class);
        funcPublish("codeGetters", TypeStruct.class, List.class);
        funcPublish("codeSetters", TypeStruct.class, List.class);
        funcPublish("codeSetterBody", List.class, Integer.class, String.class);
        funcPublish("codeNested", String.class, Boolean.class, TypeStruct.class, List.class, TreeSet.class);
        funcPublish("codeDoc", List.class, Integer.class);
        funcPublish("codeLineDoc", List.class, Integer.class);
        funcPublish("codeMetaData", List.class, Integer.class);
    }

    static public Integer mathMax(Integer a, Integer b) {
        return Math.max(a, b);
    }

    static public String upperHeadChar(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
    }

    static public String clampLen(Integer min, Integer max, String s) {
        int len = Math.max(s.length(), min);
        len = Math.min(len, max);
        return fixedLen(len, s);
    }

    public String snippetGet(String key) {
        String s = snippet.tryGet(key, null);
        if (s == null) {
            logErr("Can't find snippet by key: " + key);
            return empty;
        }
        return s;
    }

    public String snippetTryGet(String key) {
        return snippet.tryGet(key, empty);
    }

    public String snippetTryGet(String key, String deft) {
        return snippet.tryGet(key, deft);
    }

    public void addImport(TypeStruct struct, TreeSet<String> imps, String s) {
        if (s == null || s.isEmpty()) {
            return;
        }
        InvarType t = super.findType(getContext(), s);
        if (t == null) {
            logErr("addImport() --- Can't find type named " + s);
            return;
        }
        impsCheckAdd(imps, t, struct);
    }

    public String codeNested(String prefix,
                             Boolean useFullName,
                             TypeStruct struct,
                             List<InvarField> fields,
                             TreeSet<String> imports) {
        return nestedCoder.code(prefix, useFullName, struct, fields);
    }

    public String operatorLess(TypeStruct type) {
        String s = snippetGet("less.method");
        if (s.equals(empty))
            return s;
        s = replace(s, Token.Body, snippetGet(type.getField("key") != null ? "less.body.key" : "less.body.deft"));
        s = replace(s, Token.Type, type.getName());
        return s;
    }

    public StringBuilder codeGetters(TypeStruct struct, List<InvarField> fields) {
        StringBuilder code = new StringBuilder();
        for (InvarField f : fields) {
            code.append(makeStructGetter(f, struct));
        }
        return code;
    }

    public StringBuilder codeSetters(TypeStruct struct, List<InvarField> fields) {
        StringBuilder code = new StringBuilder();
        for (InvarField f : fields) {
            code.append(makeStructSetter(f, struct));
        }
        return code;
    }

    public String codeSetterBody(List<InvarField> fields, Integer index, String arg) {
        InvarField f = fields.get(index);
        return makeFieldCopy(f, arg);
    }

    public StringBuilder codeFields(TypeStruct struct, List<InvarField> fields) {
        StringBuilder code = new StringBuilder();
        for (InvarField f : fields) {
            code.append(makeStructField(f));
        }
        return code;
    }

    public StringBuilder codeInits(TypeStruct struct, List<InvarField> fields) {
        StringBuilder code = new StringBuilder();
        Iterator<InvarField> i = fields.iterator();
        while (i.hasNext()) {
            InvarField f = i.next();
            code.append(makeConstructorField(f, i.hasNext()));
        }
        return code;
    }

    public StringBuilder codeDeletes(List<InvarField> fields) {
        StringBuilder code = new StringBuilder();
        for (InvarField f : fields) {
            if (!f.getUsePointer())
                continue;
            String s = snippetTryGet("struct.field.del");
            s = replace(s, Token.Name, f.getKey());
            s = replace(s, Token.NullPtr, snippetGet(Key.POINTER_NULL));
            code.append(s);
        }
        return code;
    }

    public String codeMetaData(List<InvarField> fields, Integer index) {
        InvarField f = fields.get(index);
        return makeStructMeta(f).toString();
    }

    public String codeDoc(List<InvarField> fields, Integer index) {
        InvarField f = fields.get(index);
        return makeDoc(f.getComment());
    }

    public String codeLineDoc(List<InvarField> fields, Integer index) {
        InvarField f = fields.get(index);
        return makeDocLine(f.getComment());
    }

    public String codeCRC32(TypeStruct type) {
        type.codecRule();
        return type.getCodecRuleCRC32String().toUpperCase();
    }

    public String codeBasicSize(TypeStruct type) {
        Long size = type.encodeSizeBasic();
        return size.toString();
    }

    @Override
    protected Boolean beforeWrite(InvarContext c) {
        snippet.buildSnippetMap(c);
        genericOverride = snippet.getGenericOverride();

        super.packNameReset(c, Boolean.parseBoolean(snippetTryGet("capitalize.pack.head")));
        String k = "method.indent.num";
        methodIndentNum = 1;
        if (!snippetTryGet(k).equals(empty)) {
            methodIndentNum = Integer.parseInt(snippetTryGet(k));
        }
        packNameNested = Boolean.parseBoolean(snippetTryGet("pack.name.nested"));
        packHeadPrefix = Boolean.parseBoolean(snippetTryGet("pack.head.prefix"));
        useFullName = Boolean.parseBoolean(snippetTryGet("use.full.type.name"));
        includeSelf = Boolean.parseBoolean(snippetTryGet("include.self"));
        impExcludeConflict = Boolean.parseBoolean(snippetTryGet("import.exclude.conflict"));
        impExcludeSamePack = Boolean.parseBoolean(snippetTryGet("import.exclude.same.pack"));
        impExcludePacks = Arrays.asList(snippetTryGet("import.exclude.packs").trim().split(","));
        dirPrefix = (snippetTryGet("code.dir.prefix"));
        lowerFileName = (Boolean.parseBoolean(snippetTryGet("file.name.lowercase")));
        fileNameNoSuffix = (Boolean.parseBoolean(snippetTryGet("file.name.no.suffix")));
        onePackOneFile = (Boolean.parseBoolean(snippetTryGet("one.pack.one.file")));
        flattenCodeDir = (Boolean.parseBoolean(snippetTryGet("code.dir.flatten")));
        flattenCodeSplit = snippetTryGet("code.flatten.split");
        traceAllTypes = (Boolean.parseBoolean(snippetTryGet("trace.all.types")));
        uniqueTypeName = (Boolean.parseBoolean(snippetTryGet("unique.type.name")));
        noGenericType = (Boolean.parseBoolean(snippetTryGet("no.generic.type")));
        InvarField.setPrefix(snippet.tryGet("struct.field.prefix", null));
        snippet.buildExportFiles();
        return true;
    }

    @Override
    String codeOneFile(String packName, String filePath, List<TypeEnum> enums, List<TypeStruct> structs) {
        fileIncludes.clear();
        TreeSet<String> imps = new TreeSet<String>();
        String body = codeOneFileBody(enums, structs, imps);
        if (body.equals(empty)) {
            return empty;
        }
        if (enums != null && enums.size() > 0) {
            String codePath = getContext().findBuildInType(TypeID.INT32).getRedirect().getCodePath();
            fileIncludes.add(codePath);
        }
        String code = codeOneFileWrap(packName, filePath, body, imps);
        code = code.replaceAll("\\n{3,}", "\n\n");
        return code;
    }

    @Override
    void resetCodePaths(Boolean merge, String suffix) {
        Iterator<String> iPack = context.getPackNames();
        while (iPack.hasNext()) {
            InvarPackage pack = context.getPack(iPack.next());
            if (context.isBuildInPack(pack))
                continue;
            String name = pack.getName();
            Iterator<String> iType = pack.getTypeNames();
            while (iType.hasNext()) {
                String typeName = iType.next();
                InvarType type = pack.getType(typeName);
                if (!onePackOneFile) {
                    name = typeName;
                    if (flattenCodeDir) {
                        name = type.fullName(flattenCodeSplit);
                    }
                }
                String split = snippetTryGet(Key.FILE_INCLUDE + ".split", "/");
                String path = flattenCodeDir ? name : type.fullName(split);
                path = (path + suffix);
                switch (type.getId()) {
                    case ENUM:
                    case STRUCT:
                        resetCodePath(type, path, name, merge);
                        break;
                    case PROTOCOL:
                        resetCodePath(type, path, name, merge);
                        TypeProtocol t = (TypeProtocol) type;
                        if (t.hasClient()) {
                            name = codeName(t.getClient());
                            path = codePath(t.getClient()) + suffix;
                            resetCodePath(t.getClient(), path, name, merge);
                        }
                        if (t.hasServer()) {
                            name = codeName(t.getServer());
                            path = codePath(t.getServer()) + suffix;
                            resetCodePath(t.getServer(), path, name, merge);
                        }
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private String codeName(TypeStruct t) {
        String name;
        if (!onePackOneFile) {
            name = t.getName();
            if (flattenCodeDir) {
                name = t.fullName(flattenCodeSplit);
            }
        } else {
            name = t.getPack().getName();
        }
        t.setCodeName(name);
        return name;
    }

    private String codePath(TypeStruct t) {
        String split = snippetTryGet(Key.FILE_INCLUDE + ".split", "/");
        return flattenCodeDir ? t.getCodeName() : t.fullName(split);
    }

    private void resetCodePath(InvarType type, String path, String name, Boolean merge) {
        type.setCodeName(name);
        if (!merge)
            type.setCodePath(path);
    }

    private String codeOneFileWrap(String packName, String filePath, String body, TreeSet<String> imps) {
        String[] names;
        names = packName.split(dotToken);
        String relatives = empty;
        int len = names.length;
        int i = 0;
        while (i < len) {
            relatives += "../";
            ++i;
        }
        StringBuilder includes = new StringBuilder();
        for (String inc : fileIncludes) {
            String s = snippetTryGet(Key.FILE_INCLUDE);
            if (s.equals(empty))
                continue;
            if (inc.equals(empty))
                continue;
            String m = packNameToModuleName(inc);
            if (lowerFileName) {
                inc = inc.toLowerCase();
            }
            if (!inc.startsWith("<")) {
                String wrap = snippetTryGet(Key.FILE_INCLUDE_WRAP, empty);
                if (!empty.equals(wrap)) {
                    inc = replace(wrap, Token.Value, inc);
                }
            }
            s = replace(s, Token.Name, inc);
            s = replace(s, Token.Module, m);
            s = replace(s, Token.NameUpper, relatives);
            includes.append(s);
        }

        List<String> packNames = new LinkedList<String>();
        if (packNameNested) {
            Collections.addAll(packNames, names);
        } else {
            packNames.add(packName);
        }

        String ifndef = filePath;
        ifndef = ifndef.toUpperCase();
        ifndef = replace(ifndef, "\"", empty);
        ifndef = replace(ifndef, "//", "_");
        ifndef = replace(ifndef, "/", "_");
        ifndef = replace(ifndef, dotToken, "_");
        String s = snippet.tryGet(Key.FILE,
            "//Error: No template named '" + Key.FILE + "' in " + snippet.getSnippetPath());
        s = replace(s, Token.Define, ifndef);
        s = replace(s, Token.Pack, codeOneFilePack(packNames, body));
        s = replace(s, Token.Import, makeImports(imps));
        s = replace(s, "[\r|\n]*" + Token.Concat, empty);
        s = replace(s, "[\\s]*" + Token.ConcatAll, empty);

        String head = snippetTryGet(Key.FILE_HEAD, empty);
        if (!s.contains("(#includes)")) {
            head += includes.toString();
        } /** for empty pack name */
        s = replace(s, Token.Head, head);
        s = replace(s, Token.Includes, includes.toString());
        return s;
    }

    String codeOneFileBody(List<TypeEnum> enums, List<TypeStruct> structs, TreeSet<String> imps) {
        StringBuilder codeEnums = new StringBuilder();
        StringBuilder codeStructs = new StringBuilder();
        if (enums != null && !snippetTryGet(Key.ENUM).equals(empty)) {
            for (TypeEnum type : enums) {
                String s = snippetGet(Key.ENUM);
                if (!s.contains("body"))
                    continue;
                String body = makeEnumBlock(type);
                s = replace(s, Token.Name, type.getName());
                s = replace(s, Token.Body, body);
                s = replace(s, Token.Doc, makeDoc(type.getComment()));
                codeEnums.append(s);
            }
        }
        for (TypeStruct type : structs) {
            impsCheckAdd(imps, type, type);
            String block = makeStructBlock(type, imps);
            codeStructs.append(block);
        }

        String blockEnums = codeEnums.toString();
        String blockStructs = codeStructs.toString();
        if (blockEnums.equals(empty) && blockStructs.equals(empty)) {
            return empty;
        }
        String s = snippet.tryGet(Key.FILE_BODY,
            "//Error: No template named '" + Key.FILE_BODY + "' in " + snippet.getSnippetPath());
        s = replace(s, Token.Import, makeImports(imps));
        s = replace(s, Token.Enums, blockEnums);
        s = replace(s, Token.Structs, blockStructs);
        return s;
    }

    String codeOneFilePack(List<String> packNames, String body) {
        int i = packNames.size() - 1;
        if (i < 0) {
            return body;
        }
        String name = packNames.get(i);
        packNames.remove(i);
        if (name.equals(empty)) {
            return body;
        }
        String split = snippet.tryGet(Key.FILE_PACK_SPLIT, null);
        if (split != null) {
            name = replace(name, dotToken, split);
        }
        String s = snippet.tryGet(Key.FILE_PACK,
            "//Error: No template named '" + Key.FILE_PACK + "' in " + snippet.getSnippetPath());
        s = replace(s, Token.Name, name);
        s = replace(s, Token.Body, body);
        return codeOneFilePack(packNames, s);
    }

    @Override
    protected void codeRuntime(String suffix) {
        String typeName = snippetTryGet(Key.RUNTIME_NAME);
        if (empty.equals(typeName)) {
            return;
        }
        String fileName = snippetTryGet(Key.RUNTIME_FILE, null);
        if (fileName == null) {
            fileName = typeName;
        }
        fileName = fileName + suffix;
        String fileDir = snippetGet(Key.RUNTIME_PACK);
        fileIncludes.clear();
        TreeSet<String> imps = new TreeSet<String>();
        String body = makeRuntimeBlock(imps);
        String s = snippet.tryGet(Key.FILE_BODY,
            "//Error: No template named '" + Key.FILE_BODY + "' in " + snippet.getSnippetPath());
        s = replace(s, Token.Import, makeImports(imps));
        s = replace(s, Token.Enums, empty);
        s = replace(s, Token.Structs, body);
        s = codeOneFileWrap(fileDir, fileDir + fileName, s, imps);
        addExportFile(fileDir, fileName, s);
    }

    @Override
    protected void codeManifest(Set<File> files) {
        /*
        int offset = dirRoot.getAbsolutePath().length() + 1;
        for (File f : files) {
            String path = f.getAbsolutePath().substring(offset);
            log(path);
        } //*/
    }

    protected String makeDocLine(String comment) {
        if (comment == null || comment.equals(empty))
            return empty;
        String s = snippetGet(Key.DOC_LINE);
        s = replace(s, Token.Doc, comment);
        return s;
    }

    protected String makeDoc(String comment) {
        if (comment == null)
            return empty;
        String s = snippetGet(Key.DOC);
        s = replace(s, Token.Doc, comment);
        return s;
    }

    protected String makeEnumBlock(TypeEnum type) {
        StringBuilder code = new StringBuilder();
        Iterator<String> i = type.getKeys().iterator();
        int lenDoc = 1;
        int lenKey = 1;
        int lenVal = 1;
        while (i.hasNext()) {
            String key = i.next();
            if (key.length() > lenKey)
                lenKey = key.length();
            if (type.getValue(key).toString().length() > lenVal)
                lenVal = type.getValue(key).toString().length();
            if (type.getComment(key).length() > lenDoc)
                lenDoc = type.getComment(key).length();
        }
        i = type.getKeys().iterator();
        while (i.hasNext()) {
            String key = i.next();
            String s = snippetGet(Key.ENUM_FIELD);
            s = replaceFirst(s, Token.Name, fixedLen(lenKey, key));
            s = replace(s, Token.Name, key);
            s = replace(s, Token.Type, type.getName());
            s = replace(s, Token.Value, fixedLenBackward(whiteSpace, lenVal, type.getValue(key).toString()));
            s = replace(s, Token.DocBlock, makeDoc(type.getComment(key)));
            s = replace(s, Token.Doc, makeDocLine(type.getComment(key)));
            code.append(s);
        }
        return code.toString();
    }

    private String makeStructBlock(TypeStruct type, TreeSet<String> imps) {
        List<InvarField> fs = type.listFields();

        if (type.getSuperType() != null)
            impsCheckAdd(imps, type.getSuperType(), type);
        int widthType = 1;
        int widthName = 1;
        int widthDeft = 1;
        for (InvarField f : fs) {
            if (f.isSpecial() && "protocCRC".equals(f.getRealKey())) {
                String deft = snippet.tryGet("struct.const.name.crc", null);
                if (deft != null) {
                    deft = replace(deft, Token.Type, type.getName());
                    f.setDefault(deft);
                }
            }
            makeTypeFormatted(getContext(), f, useFullName, packHeadPrefix);
            f.setDeftFormatted(makeStructFieldInit(f, false));

            if (f.getDeftFormatted().length() > widthDeft)
                widthDeft = f.getDeftFormatted().length();
            if (f.getTypeFormatted().length() > widthType)
                widthType = f.getTypeFormatted().length();
            if (f.getKey().length() > widthName)
                widthName = f.getKey().length();

            impsCheckAdd(imps, f.getType().getRedirect(), type);
            for (InvarType typeGene : f.getGenerics()) {
                impsCheckAdd(imps, typeGene.getRedirect(), type);
            }
        }
        for (InvarField f : fs) {
            f.setWidthType(widthType);
            f.setWidthKey(widthName);
            f.setWidthDefault(widthDeft);
        }
        String s = snippetGet(Key.STRUCT);
        s = replace(s, Token.Name, getUniqueTypeName(type));
        s = replace(s, Token.Doc, makeDoc(type.getComment()));
        HashMap<String, Object> args = new HashMap<String, Object>();
        args.put("struct", type);
        args.put("fields", fs);
        args.put("imports", imps);
        args.put("useFullName", useFullName);
        args.put("lenStruct", type.getName().length());
        args.put("lenFieldType", widthType);
        args.put("lenFieldName", widthName);
        if (InvarField.getPrefix() != null) {
            args.put("lenFieldNameR", widthName - InvarField.getPrefix().length());
        }
        //args.put("env", args);
        s = funcEvalAll(s, args);
        s = replace(s, Token.Debug, type.getCodecRule());
        if (type.getProtoc() != null) {
            Integer id;
            if (type.getProtoc().getClient() == type) {
                id = type.getProtoc().getClientId();
            } else if (type.getProtoc().getServer() == type) {
                id = type.getProtoc().getServerId();
            } else {
                id = 0;
            }
            s = replace(s, Token.ProtocId, id.toString());
        }
        if (type.getProtocType() != null) {
            String pt = snippetTryGet("struct.protoc." + type.getProtocType(), empty);
            s = replace(s, Token.ProtocType, pt);
        } else {
            s = replace(s, Token.ProtocType, empty);
        }
        s = replace(s, Token.ConstCRC, snippetTryGet("struct.const.name.crc", "CRC32"));
        return s;
    }

    private StringBuilder buildCodeLines(List<String> lines) {
        StringBuilder codes = new StringBuilder();
        for (String line : lines) {
            codes.append(br).append(line);
        }
        return codes;
    }

    private StringBuilder makeStructMeta(InvarField f) {
        StringBuilder code = new StringBuilder();
        String s = snippetGet(Key.STRUCT_META);
        s = replace(s, Token.Type, f.createAliasRule(getContext(), "."));
        s = replace(s, Token.Name, f.getShortName());
        s = replace(s, Token.Index, f.getIndex().toString());
        s = replace(s, Token.Mark, f.getUsePointer() ? "*" : "&");
        code.append(s);
        return code;
    }

    private String makeConstructorField(InvarField f, Boolean hasNext) {
        if (snippetTryGet(Key.CONSTRUCT_FIELD).equals(empty))
            return empty;
        String s = snippetGet(Key.CONSTRUCT_FIELD);
        s = replace(s, Token.Name, fixedLen(f.getWidthKey(), f.getKey()));
        s = replace(s, Token.Value, f.getDeftFormatted());
        if (hasNext) {
            s += snippetGet(Key.CONSTRUCT_FIELD_SPLIT);
        }
        return s;
    }

    private StringBuilder makeStructField(InvarField f) {
        StringBuilder code = new StringBuilder();
        String spec = f.getUsePointer() ? snippetTryGet(Key.POINTER_SPEC) : whiteSpace;
        String s = snippetGet(Key.STRUCT_FIELD);
        s = replace(s, Token.Type, f.getTypeFormatted());
        s = replace(s, Token.Mark, snippetTryGet("ptr.mark." + f.getType().getRealId().getName(), whiteSpace));
        s = replace(s, Token.Specifier, spec);
        s = replace(s, Token.Name, f.getKey());
        s = replace(s, Token.NameReal, f.getRealKey());
        s = replace(s, Token.Value, f.getDeftFormatted());
        s = replace(s, Token.Index, f.getIndex().toString());
        code.append(s);
        return code;
    }

    private StringBuilder makeStructSetter(InvarField f, TypeStruct struct) {
        StringBuilder code = new StringBuilder();
        if (f.getDisableSetter())
            return code;
        String sConst = snippetTryGet(Key.REFER_CONST) + whiteSpace;
        String s = snippetGet(Key.STRUCT_SETTER);
        s = replace(s, Token.TypeUpper, getUniqueTypeName(struct));
        s = replace(s, Token.Type, f.getTypeFormatted());
        s = replace(s, Token.Mark, snippetTryGet("ptr.mark." + f.getType().getRealId().getName(), whiteSpace));
        s = replace(s, Token.Specifier, makeStructFieldSpec(f, empty));
        s = replace(s, Token.Name, f.getKey());
        s = replace(s, Token.NameReal, f.getRealKey());
        s = replace(s, Token.Index, f.getIndex().toString());
        s = replace(s, Token.Const, (f.getUseReference() || f.getUsePointer()) ? sConst : empty);
        code.append(s);
        return code;
    }

    private StringBuilder makeStructGetter(InvarField f, TypeStruct struct) {
        Boolean bConst = !f.isMap() && !f.isVec() && (f.getUsePointer() || f.getUseReference());
        Boolean bConstBlock = !f.isMap() && !f.isVec();
        String sConst = snippetTryGet("refer.const") + whiteSpace;
        StringBuilder code = new StringBuilder();
        String s = snippetGet(Key.STRUCT_GETTER);
        s = replace(s, Token.TypeUpper, getUniqueTypeName(struct));
        s = replace(s, Token.Type, f.getTypeFormatted());
        s = replace(s, Token.Mark, snippetTryGet("ptr.mark." + f.getType().getRealId().getName(), whiteSpace));
        s = replace(s, Token.Specifier, makeStructFieldSpec(f, whiteSpace + whiteSpace));
        s = replace(s, Token.Name, f.getKey());
        s = replace(s, Token.NameReal, f.getRealKey());
        s = replace(s, Token.Index, f.getIndex().toString());
        s = replace(s, Token.Const, bConst ? sConst : empty);
        s = replace(s, Token.ConstBlock, bConstBlock ? whiteSpace + snippetTryGet("refer.const") : empty);
        code.append(s);
        return code;
    }

    private String makeStructFieldSpec(InvarField f, String deft) {
        if (f.getUsePointer())
            return whiteSpace + snippetTryGet(Key.POINTER_SPEC);
        else if (f.getUseReference())
            return whiteSpace + snippetTryGet(Key.REFER_SPEC);
        else
            return deft;
    }

    private String makeStructFieldInit(InvarField f, Boolean ignorePointer) {
        if (f.getUsePointer() && !ignorePointer) {
            return snippetGet(Key.POINTER_NULL);
        }
        InvarType type = f.getType();
        String s = snippet.tryGet("init." + type.getRealId().getName(), null);
        if (f.isSpecial()) {
            s = snippet.tryGet("init." + f.getKey(), null);
        }
        if (s == null) {
            s = snippetGet("init.any");
        }
        String deft = f.getDefault();
        if (deft == null || deft.equals(empty)) {
            deft = f.getType().getInitValue();
        }
        switch (f.getType().getRealId()) {
            case STRUCT:
            case VEC:
            case MAP:
                String t = f.getTypeFormatted();
                s = replace(s, Token.Type, Matcher.quoteReplacement(t));
                break;
            case ENUM:
                String pack = empty;
                String name;
                String option = empty;
                if (!deft.equals(empty)) {
                    String[] texts = deft.split(dotToken);
                    name = texts[0];
                    if (texts.length > 1)
                        option = texts[1];
                } else {
                    TypeEnum tEnum = (TypeEnum) type;
                    pack = tEnum.getPack().getName();
                    name = tEnum.getName();
                    option = tEnum.firstOptionKey();
                }
                s = replace(s, Token.Module, packNameToModuleName(pack));
                s = replace(s, Token.Pack, pack);
                s = replace(s, Token.Type, name);
                s = replace(s, Token.Name, option);
                break;
            default:
                break;
        }
        String splitPack = snippetTryGet(Key.IMPORT_SPLIT, empty);
        String splitType = snippetTryGet(Key.FILE_TYPE_SPLIT, null);
        String fullName = f.getType().getRedirect().fullName(splitPack, splitType);
        s = replace(s, Token.TypeFull, fullName + f.getGenericFormatted());
        s = replace(s, Token.Default, deft);
        return s;
    }

    private String makeRuntimeBlock(TreeSet<String> imps) {
        String s = snippetGet(Key.RUNTIME_BODY);
        String block = empty;
        block += makeRuntimeProtocHandleBlock(imps);
        if (!empty.equals(snippetTryGet(Key.RUNTIME_ALIAS))) {
            block += makeRuntimeAliasBlock(imps);
        }
        if (!empty.equals(snippetTryGet(Key.RUNTIME_PROTOC_IDS_FUNC))) {
            block += makeRuntimeIdsBlock(imps);
        }
        s = replace(s, Token.Body, block);
        s = replace(s, Token.Type, snippetTryGet(Key.RUNTIME_NAME));
        return s;
    }

    private String makeRuntimeIdsBlock(TreeSet<String> imps) {
        StringBuilder block = new StringBuilder(4096);
        Iterator<Integer> ids = TypeProtocol.allIds();
        while (ids.hasNext()) {
            Integer id = ids.next();
            TypeStruct tStruct;
            tStruct = TypeProtocol.findClient(id);
            if (tStruct == null) {
                tStruct = TypeProtocol.findServer(id);
            }
            if (tStruct == null) {
                continue;
            }
            impsCheckAdd(imps, tStruct, null, true);
            String split = snippetTryGet(Key.RUNTIME_TYPE_SPLIT);
            String full = tStruct.fullName(split);
            String type = tStruct.getConflict(context) ? full : tStruct.getName();
            log(id + " -----> " + type);
            String item = snippetGet(Key.RUNTIME_PROTOC_IDS_FUNC_ITEM);
            item = replace(item, Token.Key, id.toString());
            item = replace(item, Token.Type, type);
            block.append(item);
        }
        String name = snippetGet(Key.RUNTIME_PROTOC_IDS_FUNC_NAME);
        String s = snippetGet(Key.RUNTIME_PROTOC_IDS_FUNC);
        s = replace(s, Token.Name, name);
        s = replace(s, Token.Body, block.toString());
        return s;
    }

    private String makeRuntimeAliasBlock(TreeSet<String> imps) {
        StringBuilder meBasic = new StringBuilder();
        StringBuilder meEnums = new StringBuilder();
        StringBuilder meStruct = new StringBuilder();
        Iterator<String> i = getContext().aliasNames();
        while (i.hasNext()) {
            String alias = i.next();
            InvarType type = getContext().aliasGet(alias);
            impsCheckAdd(imps, type, null);

            String key;
            if (TypeID.VEC == type.getRealId())
                key = Key.RUNTIME_ALIAS_VEC;
            else if (TypeID.MAP == type.getRealId())
                key = Key.RUNTIME_ALIAS_MAP;
            else
                key = Key.RUNTIME_ALIAS_BASIC;

            String s = snippetGet(key);
            String split = snippetTryGet(Key.RUNTIME_TYPE_SPLIT);
            String full = type.fullName(split);
            s = replace(s, Token.Name, alias);
            s = replace(s, Token.Type, type.getConflict(context) ? full : type.getName());
            s = replace(s, Token.TypeFull, full);
            if (type instanceof TypeStruct)
                meStruct.append(s);
            else if (type instanceof TypeEnum)
                meEnums.append(s);
            else
                meBasic.append(s);
        }
        return makeRuntimeAliasFunc("aliasBasic", meBasic.toString())
            + makeRuntimeAliasFunc("aliasEnum", meEnums.toString())
            + makeRuntimeAliasFunc("aliasStruct", meStruct.toString());
    }

    private String makeRuntimeAliasFunc(String name, String block) {
        String s = snippetGet(Key.RUNTIME_ALIAS);
        s = replace(s, Token.Name, name);
        s = replace(s, Token.Body, block);
        return s;
    }

    private String makeRuntimeProtocHandleBlock(TreeSet<String> imps) {
        String name2c = snippetTryGet(Key.RUNTIME_PROTOC_HANDLE_2C);
        String name2s = snippetTryGet(Key.RUNTIME_PROTOC_HANDLE_2S);
        String result = empty;
        if (!empty.equals(name2s)) {
            result += makeRuntimeProtocHandleFunc(Key.RUNTIME_PROTOC_HANDLE_2S, imps, TypeProtocol.clientIds(), false, true);
        }
        if (!empty.equals(name2c)) {
            result += makeRuntimeProtocHandleFunc(Key.RUNTIME_PROTOC_HANDLE_2C, imps, TypeProtocol.serverIds(), true, false);
        }
        return result;
    }

    private String makeRuntimeProtocHandleFunc(
        String key, TreeSet<String> imps, Iterator<Integer> protocIds, Boolean isServer, Boolean isClient) {
        if (isClient && isServer) {
            return empty;
        }
        if (!isClient && !isServer) {
            return empty;
        }
        if (empty.equals(snippetGet(Key.RUNTIME_PROTOC_HANDLE_M))) {
            return empty;
        }
        String[] impArr = snippetTryGet(Key.RUNTIME_IMPORT, "").split(",");
        for (String s : impArr) {
            addImport(null, imps, s);
        }
        String name = snippetGet(key);
        String invoke = snippetTryGet(key + ".read");
        StringBuilder block = new StringBuilder();
        while (protocIds.hasNext()) {
            Integer id = protocIds.next();
            TypeStruct tStruct;
            if (isClient) {
                tStruct = TypeProtocol.findClient(id);
            } else {
                tStruct = TypeProtocol.findServer(id);
            }
            if (tStruct == null) {
                continue;
            }
            impsCheckAdd(imps, tStruct, null, true);
            boolean needReply = (tStruct == tStruct.getProtoc().getRequest());
            String keySnippet;
            String temp;
            if (needReply) {
                temp = "req";
                keySnippet = Key.RUNTIME_PROTOC_HANDLE_REQ;
            } else {
                temp = "rep";
                keySnippet = Key.RUNTIME_PROTOC_HANDLE_RESP;
                if (!(tStruct.getProtoc().hasClient() && tStruct.getProtoc().hasServer())) {
                    temp = "ntf";
                    keySnippet = Key.RUNTIME_PROTOC_HANDLE_NTF;
                }
            }
            String s = snippetGet(keySnippet);
            if (empty.equals(s)) {
                continue;
            }
            boolean useFullType = Boolean.parseBoolean(snippetTryGet(Key.RUNTIME_TYPE_FULL));
            s = replace(s, Token.Name, temp);
            if (tStruct.getProtoc().getRequest() != null) {
                TypeStruct t = tStruct.getProtoc().getRequest();
                s = replace(s, Token.Request, useFullType ? typeFullName(t) : t.getName());
            }
            if (tStruct.getProtoc().getResponse() != null) {
                TypeStruct t = tStruct.getProtoc().getResponse();
                s = replace(s, Token.Response, useFullType ? typeFullName(t) : t.getName());
            }
            String full = typeFullName(tStruct);
            s = replace(s, Token.Doc, tStruct.getProtoc().getComment());
            s = replace(s, Token.Key, id.toString());
            s = replace(s, Token.Type, useFullType ? full : tStruct.getName());
            s = replace(s, Token.TypeFull, full);
            block.append(s);
        }

        String s = snippetGet(Key.RUNTIME_PROTOC_HANDLE_M);
        s = replace(s, Token.Name, name);
        s = replace(s, Token.Body, block.toString());
        s = replace(s, Token.Invoke, invoke);
        return s;
    }

    private String typeFullName(TypeStruct tStruct) {
        String splitPack = snippetTryGet(Key.IMPORT_SPLIT, empty);
        String splitType = snippetTryGet(Key.FILE_TYPE_SPLIT, null);
        return tStruct.fullName(splitPack, splitType);
    }


    protected String makeImports(TreeSet<String> imps) {
        if (imps == null || imps.size() == 0) {
            return empty;
        } else {
            if (null == snippetTryGet(Key.IMPORT, null)) {
                return empty;
            }
            TreeSet<String> lines = new TreeSet<String>();
            for (String key : imps) {
                if (key.equals(empty))
                    continue;
                String[] names = key.split(ruleTypeSplit);
                if (names.length <= 0)
                    continue;
                String body = snippetGet(Key.IMPORT_BODY);
                if (names.length >= 1) {
                    String body2 = snippetTryGet(Key.IMPORT_BODY
                        + "." + names[names.length - 1].toLowerCase(), null);
                    if (null != body2) {
                        body = body2;
                    }
                }
                if (names.length < 1) {
                    continue;
                } else if (names.length == 1) {
                    body = replace(body, Token.Pack, empty);
                    body = replace(body, Token.Name, names[0]);
                } else {
                    String split = snippetGet(Key.IMPORT_SPLIT);
                    String pName = names[0];
                    pName = replace(pName, dotToken, split);
                    body = replace(body, Token.Pack, pName);
                    if (pName.equals(empty))
                        split = empty;
                    body = replace(body, Token.Name, split + names[1]);
                    body = replace(body, Token.Module, pName);
                }
                if (body.equals(empty))
                    continue;
                String s = snippetGet(Key.IMPORT);
                s = replace(s, Token.Body, body);
                lines.add(s);
            }
            StringBuilder code = new StringBuilder();
            for (String line : lines) {
                code.append(line);
            }
            return code.toString();
        }
    }

    private String packNameToModuleName(String pack) {
        if (pack == null || pack.length() <= 0) {
            return empty;
        }
        return pack.replace(".", empty);
    }

    private String makeTypeFormatted(InvarContext ctx, InvarField f, Boolean fullName, Boolean head) {
        String split = snippetTryGet(Key.IMPORT_SPLIT, null);
        String splitType = snippetTryGet(Key.FILE_TYPE_SPLIT, null);
        InvarType t = f.getType().getRedirect();
        String tName = t.getName();
        boolean conflict = t.getConflict(ctx);
        if (conflict) {
            if (uniqueTypeName && t.getConflict(ctx)) {
                tName = getUniqueTypeName(t);
            } else {
                tName = t.fullName(split, splitType);
            }
        } else {
            if (fullName) {
                tName = t.fullName(split, splitType);
                if (head) {
                    tName = split + tName;
                }
            }
        }
        return f.makeTypeFormatted(ctx, split, splitType, fullName, tName, noGenericType);
    }

    private String getUniqueTypeName(InvarType t) {
        if (!uniqueTypeName) {
            return t.getName();
        }
        return t.getConflict(context) ? t.getUniqueName() : t.getName();
    }

    void impsCheckAdd(TreeSet<String> imps, InvarType t, TypeStruct struct) {
        impsCheckAdd(imps, t, struct, false);
    }

    void impsCheckAdd(TreeSet<String> imps, InvarType t, TypeStruct struct, boolean forcedInclude) {
        String include = t.getCodePath();
        if (include != null && !include.equals(empty)) {
            String s = include;
            /*
            if (!s.startsWith("<")) {
                //if (t.getRealId() == TypeID.STRUCT || t.getRealId() == TypeID.DIALECT || t.getRealId() == TypeID.ENUM) {
                s = snippetTryGet(Key.FILE_INCLUDE_WRAP, include);
                s = replace(s, Token.Value, include);
            }//*/
            boolean isSelf = false;
            if (struct != null) {
                isSelf = onePackOneFile ? (t.getPack() == struct.getPack()) : (t == struct);
            }
            if (includeSelf) {
                if (isSelf)
                    fileIncludes.add(s);
            } else {
                if (!isSelf)
                    fileIncludes.add(s);
            }
            if (forcedInclude) {
                fileIncludes.add(s);
            }
        }
        if (t == struct) {
            return;
        }
        //TODO if (impExcludeConflict && t.getConflict(context)) {
        if (impExcludeConflict && getContext().findTypes(t.getName()).size() > 1) {
            return;
        }
        if (impExcludeSamePack && struct != null && t.getPack() == struct.getPack()) {
            return;
        }
        if (impExcludePacks != null && impExcludePacks.size() > 0 && impExcludePacks.contains(t.getPack().getName())) {
            return;
        }
        //String packName = t.getPack().getName();
        //String typeName = t.getName();
        //FIXME uniqueTypeName is not a good condition
        String packName = uniqueTypeName ? t.getCodeName() : t.getPack().getName();
        String typeName = uniqueTypeName && t.getConflict(context) ? t.getUniqueName() : t.getName();
        String rule = packName + ruleTypeSplit + typeName;
        imps.add(rule);
    }

    private List<String> indentLines(String snippet) {
        int numIndent = 1;
        String[] lines = snippet.split("\n|\r\n");
        String strIndent = empty;
        for (int i = 0; i < numIndent; i++) {
            strIndent += indent;
        }
        List<String> codes = new ArrayList<String>();
        for (String line : lines) {
            codes.add(strIndent + line);
        }
        return codes;
    }

    private void indentLines(List<String> lines, int numIndent) {
        String strIndent = empty;
        for (int i = 0; i < numIndent; i++) {
            strIndent += indent;
        }
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, strIndent + lines.get(i));
        }
    }

    static private String replace(String s, String Token, String replacement) {
        // RegExp Common Metacharacters: ^[.${*(\+)|?<> 
        return s.replaceAll(Token, Matcher.quoteReplacement(replacement));
    }

    static private String replaceFirst(String s, String Token, String replacement) {
        // RegExp Common Metacharacters: ^[.${*(\+)|?<> 
        return s.replaceFirst(Token, Matcher.quoteReplacement(replacement));
    }

    static private Boolean genericOverride = false; //For C++ template ">>" issue in GCC

    static private String createRule(InvarField f, InvarContext ctx, Boolean useFullName) {
        InvarType typeBasic = f.getType().getRedirect();
        if (f.getGenerics().size() == 0) {
            if (ctx.findTypes(typeBasic.getName()).size() > 1 || useFullName)
                return typeBasic.fullName(rulePackSplit, ruleTypeSplit);
            else
                return typeBasic.getName();
        }
        String s = getGenericOverride(typeBasic);
        for (InvarType t : f.getGenerics()) {
            t = t.getRedirect();
            String forShort;
            if (t.getConflict(ctx) || useFullName) {
                forShort = t.fullName(rulePackSplit, ruleTypeSplit);
            } else {
                forShort = t.getName();
            }
            /*
            if (t.getRealId() == TypeID.VEC || t.getRealId() == TypeID.MAP) {
                forShort = t.getName();
            } else {
                if (t.getConflict(ctx) || useFullName) {
                    forShort = t.fullName(rulePackSplit, ruleTypeSplit);
                } else {
                    forShort = t.getName();
                }
            } //*/
            s = s.replaceFirst("\\?", forShort + getGenericOverride(t));
        }
        String rule = useFullName ? typeBasic.fullName(rulePackSplit, ruleTypeSplit) : typeBasic.getName();
        rule = rule + s;
        return rule;
    }

    static String getGenericOverride(InvarType t) {
        String s = t.getRealId().getGeneric();
        if (genericOverride) {
            s = t.getGeneric();
        }
        return s;
    }

    public String makeCodeAssignment(String type, String name, String value, Boolean refer) {
        name = name.trim();
        value = value.trim();
        String s = snippetGet(Key.CODE_ASSIGNMENT);
        if (value.equals(name)) {
            value = empty;
        }
        if (value.equals(empty)) {
            refer = false;
            s = snippetGet(Key.CODE_DEFINITION);
        }
        if (refer)
            name = snippetTryGet(Key.REFER_SPEC) + name;
        s = replace(s, Token.Value, value);
        s = replace(s, Token.Type, !type.equals(empty) ? type + whiteSpace : empty);
        s = replace(s, Token.Name, name);
        return s;
    }

    private void funcPublish(String name, Class<?>... argTypes) throws NoSuchMethodException, SecurityException {
        Method m = InvarWriteCode.class.getMethod(name, argTypes);
        mapInvoke.put(name, m);
    }

    private String funcEvalAll(String s, HashMap<String, Object> env) {
        Matcher m = patternInvoke.matcher(s);
        StringBuffer sb = new StringBuffer();
        int mend = 0;
        while (m.find()) {
            String result = funcEval(s.substring(m.start(), m.end()), env);
            m.appendReplacement(sb, result);
            mend = m.end();
        }
        if (mend == 0)
            return s;
        String sNew = sb.toString() + s.substring(mend);
        //return sNew;
        return funcEvalAll(sNew, env);
    }

    private String funcEval(String expr, HashMap<String, Object> env) {
        expr = expr.trim();
        expr = expr.substring(2, expr.length() - 1);
        expr = funcEvalAll(expr, env);
        // expr = replace(expr, "\\[#", empty);
        // expr = replace(expr, "\\]", empty);
        String key = expr.substring(0, expr.indexOf("("));
        key = key.trim();
        if (mapInvoke.containsKey(key)) {
            String strParam = expr.substring(expr.indexOf("(") + 1, expr.lastIndexOf(")"));
            Method m = mapInvoke.get(key);
            Class<?>[] types = m.getParameterTypes();
            String[] strParams = strParam.split("\\s*;\\s*");
            if (types.length != strParams.length) {
                return makeDoc(expr + " param count mismatch.\n" + m.toString());
            }
            Object[] params = new Object[types.length];
            for (int i = 0; i < types.length; i++) {
                String arg = strParams[i].trim();
                if (env.containsKey(arg)) {
                    params[i] = env.get(arg);
                    continue;
                }
                Class<?> t = types[i];
                if (t.equals(String.class))
                    params[i] = arg;
                else if (t.equals(Byte.class))
                    params[i] = Byte.parseByte(arg);
                else if (t.equals(Short.class))
                    params[i] = Short.parseShort(arg);
                else if (t.equals(Integer.class))
                    params[i] = Integer.parseInt(arg);
                else if (t.equals(Long.class))
                    params[i] = Long.parseLong(arg);
                else if (t.equals(Float.class))
                    params[i] = Float.parseFloat(arg);
                else if (t.equals(Double.class))
                    params[i] = Double.parseDouble(arg);
                else if (t.equals(Boolean.class))
                    params[i] = Boolean.parseBoolean(arg);
                    //else if (t.isEnum())
                    //    params[i] = Enum.valueOf(t, arg);
                else
                    return makeDoc(expr + " type unsupported: " + t);
            }
            try {
                Object result = m.invoke(this, params);
                return result != null ? result.toString() : empty;
            } catch (Exception e) {
                System.out.println(m);
                e.printStackTrace();
            }
        }
        return makeDoc("No Func: " + expr);
    }

    private String makeFieldCopy(InvarField f, String arg) {
        String s = snippetTryGet(f.getUsePointer() ? "pointer.copy" : "refer.copy");
        String name = f.getKey();
        s = replace(s, Token.Type, f.getTypeFormatted());
        s = replace(s, Token.Name, name);
        s = replace(s, Token.Argument, arg);
        return s;
    }

    private class NestedCoder {
        final private TypeID sizeType = TypeID.UINT32;
        private Boolean useFullName = false;
        private Boolean isSql = false;
        private Boolean exceptAuto;
        private String prefix = empty;
        private String snippetMet = empty;
        private String snippetArg = empty;


        public String code(String prefix, Boolean useFullName, TypeStruct type, List<InvarField> fs) {
            this.prefix = prefix;
            this.useFullName = useFullName;
            this.snippetMet = snippetTryGet(prefix + "method", empty);
            this.snippetArg = snippetTryGet(prefix + "method.arg", empty);
            if (empty.equals(snippetMet)) {
                return empty;
            }
            this.isSql = prefix.startsWith("sql.");
            this.exceptAuto = Boolean.parseBoolean(snippetTryGet(prefix + "except.auto", empty));
            if (isSql && !type.isTable()) {
                return empty;
            }
            List<String> lines = new ArrayList<String>();
            int len = snippetMet.contains("(#body)") ? fs.size() : 0;
            boolean isSetter = prefix.startsWith("setter");
            for (int i = 0; i < len; i++) {
                InvarField f = fs.get(i);
                if (isSql && type.isTable() &&
                    (f.isMap() || f.isVec() ||
                        (exceptAuto && f.getAuto()))) {
                    continue;
                }
                if (isSetter && f.getDisableSetter()) {
                    continue;
                }
                lines.addAll(makeField(f, i == 0, i == len - 1));
            }

            return makeCodeMethod(lines, type, snippetMet);
        }

        private String makeCodeMethod(List<String> lines, TypeStruct type, String snippet) {
            String returnType = uniqueTypeName && type.getConflict(context) ? type.getUniqueName() : type.getName();
            String sNum = snippetTryGet(prefix + "indent.num", null);
            Integer iNum;
            if (sNum != null) {
                iNum = Math.max(0, Integer.parseInt(sNum));
            } else {
                iNum = methodIndentNum;
            }
            indentLines(lines, iNum);
            StringBuilder body = new StringBuilder();
            for (String line : lines) {
                if (line.trim().equals(empty)) {
                    continue;
                }
                body.append(br);
                body.append(line);
            }
            String s = snippet;
            s = replace(s, Token.Type, returnType);
            s = replace(s, Token.Body, body.toString());
            s = replace(s, Token.NullPtr, snippetTryGet(Key.POINTER_NULL));
            s = replace(s, Token.ByteNull, snippetTryGet("byte.non"));
            s = replace(s, Token.ByteNotNull, snippetTryGet("byte.yes"));
            s = replace(s, Token.Argument, snippetArg);
            s = replace(s, Token.NameTable, type.getTableName());
            s = replace(s, Token.Struct, getUniqueTypeName(type));
            return s;
        }

        private List<String> makeField(InvarField f, boolean isFirst, boolean isLast) {
            String rule = createRule(f, getContext(), useFullName);
            TypeID type = f.getType().getRealId();
            List<String> lines = new ArrayList<String>();
            NestedParam params = makeParams(null, rule, f.getKey(), f.getRealKey(), empty);
            params.isFirst = isFirst;
            params.isLast = isLast;
            makeGeneric(f, type, rule, params, lines);
            return lines;
        }

        private void makeGeneric(InvarField f, TypeID type, String rule, NestedParam p, List<String> lines) {
            p.field = f;
            p.type = type;
            String code;
            if (TypeID.VEC == type)
                code = makeUnitVec(p, rule);
            else if (TypeID.MAP == type)
                code = makeUnitMap(p, rule);
            else {
                if (p.isRoot())
                    code = makeUnitRoot(p, type);
                else
                    code = makeUnitNest(p, type);
            }
            String invoke = snippetTryGet(Key.REFER_INVOKE);
            if (p.isRoot() && p.field.getUsePointer()) {
                invoke = snippetTryGet(Key.POINTER_INVOKE);
            }
            //code = replace(code, Token.Argument, snippetArg);
            code = replace(code, Token.Invoke, invoke);
            if (p.isRoot()) {
                String spec = empty;
                String s;
                if (p.field.getUsePointer()) {
                    s = snippetTryGet(prefix + "ptr." + p.type.getName());
                    if (s.equals(empty))
                        s = snippetTryGet(prefix + "ptr.any");
                    spec = snippetTryGet(Key.POINTER_SPEC);
                } else {
                    s = snippetTryGet(prefix + "ref." + p.type.getName());
                    if (s.equals(empty))
                        s = snippetTryGet(prefix + "ref.any");
                }
                if (!s.equals(empty)) {
                    String s_head = snippetTryGet(prefix + "field.head." + p.type.getName());
                    if (empty.equals(s_head)) {
                        s_head = snippetTryGet(prefix + "field.head.any");
                    }
                    String tailKey = "field.tail." + p.type.getName();
                    if (p.field.getUsePointer()) {
                        tailKey += ".ptr";
                    }
                    String s_tail = snippetTryGet(prefix + tailKey);
                    if (empty.equals(s_tail)) {
                        s_tail = snippetTryGet(prefix + "field.tail.any");
                    }
                    String s_space = snippetTryGet(prefix + "field.space." + p.type.getName());
                    if (empty.equals(s_space)) {
                        s_space = snippetTryGet(prefix + "field.space.any");
                    }
                    if (!empty.equals(s_space) && !p.isFirst) {
                        s_head = s_head + s_space;
                    }
                    if (!empty.equals(s_head)) {
                        s = s_head + s;
                    }
                    //if (!empty.equals(s_space) && !p.isLast) {
                    //    s = s + s_space;
                    //}
                    if (p.field.isSpecial()) {
                        String s_special = snippetTryGet(prefix + "special." + p.field.getRealKey());
                        if (!empty.equals(s_special)) {
                            s = s + s_special;
                        }
                    }
                    if (!empty.equals(s_tail)) {
                        s = s + s_tail;
                    }
                    s = replace(s, Token.Body, code);
                    s = replace(s, Token.BodyIndent, makeBodyIndent(code));
                    s = replace(s, Token.Type, p.rule);
                    s = replace(s, Token.RuleLeft, ruleLeft(p.rule));
                    s = replace(s, Token.Name, p.name);
                    s = replace(s, Token.NameReal, p.nameReal);
                    s = replace(s, Token.Argument, snippetArg);
                    s = replace(s, Token.Split, snippetTryGet(Key.REFER_INVOKE));
                    s = replace(s, Token.Specifier, spec);
                    s = replace(s, Token.Default, makeStructFieldInit(p.field, true));
                    s = replace(s, Token.Index, p.field.getIndex().toString());
                    s = replace(s, Token.NameAlias, f.hasAlias() ? f.getAlias() : p.nameReal);
                    lines.addAll(indentLines(s));
                    return;
                }
            }
            lines.addAll(indentLines(code));
        }

        private String makeBodyIndent(String code) {
            List<String> bodyLines = indentLines(code);
            StringBuilder body = new StringBuilder();
            for (String line : bodyLines) {
                if (empty.equals(line.trim())) {
                    continue;
                }
                body.append(br).append(line);
            }
            return body.toString();
        }

        private String makeBasicExpr(TypeID t) {
            String s = snippetTryGet(prefix + t.getName());
            if (s.equals(empty)) {
                s = snippetGet(prefix + "any");
            }
            return s;
        }

        private String makeUnitRoot(NestedParam p, TypeID t) {
            if (p.field == null) {
                return empty;
            }
            if (!p.isRoot()) {
                return empty;
            }
            String body = makeBasicExpr(t);
            String spec = empty;
            if (p.field.getUsePointer()) {
                spec = snippetTryGet(Key.POINTER_SPEC);
            }
            body = replace(body, Token.Specifier, spec);
            body = replace(body, Token.Type, p.rule);
            body = replace(body, Token.Name, p.name);
            body = replace(body, Token.NameReal, p.nameReal);
            return body;
        }

        private String makeUnitNest(NestedParam p, TypeID t) {
            String s = snippetTryGet(prefix + "nest" + p.tag + "." + t.getName());
            if (s.equals(empty)) {
                s = snippetGet(prefix + "nest" + p.tag);
            }
            s = replace(s, Token.Body, makeBasicExpr(t));
            s = replace(s, Token.Split, "_");
            s = replace(s, Token.Specifier, empty);
            s = replace(s, Token.Type, p.rule);
            s = replace(s, Token.Name, p.name);
            s = replace(s, Token.NameReal, p.nameReal);
            if (p.parent != null) {
                String specUpper = empty;
                if (p.parent.isRoot() && p.field.getUsePointer()) {
                    specUpper = snippetTryGet(Key.POINTER_SPEC);
                }
                s = replace(s, Token.SpecUpper, specUpper);
                s = replace(s, Token.TypeUpper, p.parent.rule);
                s = replace(s, Token.NameUpper, p.parent.nameReal);
                s = replace(s, Token.NameUpper2, p.parent.name);
            }
            return s;
        }

        private String makeUnitVec(NestedParam p, String rule) {
            String s = snippetTryGet(prefix + TypeID.VEC.getName());
            if (!s.equals(empty)) {
                return s;
            }
            String ruleV = ruleRight(rule);
            String nameVal = "n" + p.depth;
            NestedParam pVal = makeParams(p, ruleV, nameVal, nameVal, ".n");
            String body = empty;
            body += makeUnitGeneric(ruleV, pVal);
            return makeUnitIter(TypeID.VEC.getName(), body, p, pVal, null);
        }

        private String makeUnitMap(NestedParam p, String rule) {
            String s = snippetTryGet(prefix + TypeID.MAP.getName());
            if (!s.equals(empty)) {
                return s;
            }
            String r = ruleRight(rule);
            String[] R = r.split(",");
            assert (R.length == 2);
            String ruleK = R[0];
            String ruleV = R[1];
            String nameKey = "k" + p.depth;
            String nameVal = "v" + p.depth;
            NestedParam pKey = makeParams(p, ruleK, nameKey, nameKey, ".k");
            NestedParam pVal = makeParams(p, ruleV, nameVal, nameVal, ".v");
            String body = empty;
            body += makeUnitGeneric(ruleK, pKey);
            body += makeUnitGeneric(ruleV, pVal);
            return makeUnitIter(TypeID.MAP.getName(), body, p, pVal, pKey);
        }

        private String makeUnitGeneric(String rule, NestedParam p) {
            String L = ruleLeft(rule);
            InvarType t = getTypeByShort(L);
            if (t == null) {
                logErr("No type named " + L);
                return empty;
            }
            TypeID type = t.getRealId();
            List<String> body = new ArrayList<String>();
            makeGeneric(p.field, type, rule, p, body);
            return buildCodeLines(body).toString();
        }

        private String makeUnitIter(String typeName, String body, NestedParam p, NestedParam pv, NestedParam pk) {
            String head = makeUnitIterHead(p);
            String sfor = null;
            Long sizeOf = -1L;
            if (/* list */ pk == null && pv != null) {
                if (pv.type.getSize() > 0) {
                    sizeOf = pv.type.getSize();
                }
            } else if (/* dict */ pk != null && pv != null) {
                if (pk.type.getSize() > 0 && pv.type.getSize() > 0) {
                    sizeOf = pk.type.getSize() + pv.type.getSize();
                }
            }
            if (sizeOf > 0) {
                sfor = snippetTryGet(prefix + typeName + ".for.simple", null);
            }
            if (sfor == null) {
                sfor = snippetGet(prefix + typeName + ".for");
            } else {
                sfor = replace(sfor, Token.SizeOf, sizeOf.toString());
            }
            String s = head + sfor;
            String iName = upperHeadChar(p.nameReal);
            String sizeType = getContext().findBuildInType(this.sizeType).getRedirect().getName();
            s = replace(s, Token.Body, body);
            s = replace(s, Token.BodyIndent, makeBodyIndent(body));
            s = replace(s, Token.SizeType, sizeType);
            s = replace(s, Token.Size, "len" + iName);
            s = replace(s, Token.Index, "i" + iName);
            s = replace(s, Token.Type, p.rule);
            s = replace(s, Token.RuleLeft, ruleLeft(p.rule));
            s = replace(s, Token.RuleRight, ruleRight(p.rule));
            s = replace(s, Token.Name, p.name);
            s = replace(s, Token.NameReal, p.nameReal);
            if (pv != null) {
                s = replace(s, Token.Value, pv.name);
            }
            if (pk != null) {
                s = replace(s, Token.Key, pk.name);
            }
            if (p.parent != null && p.parent.type != TypeID.VOID) {
                String specUpper = empty;
                if (p.parent.isRoot() && p.field.getUsePointer()) {
                    specUpper = snippetTryGet(Key.POINTER_SPEC);
                }
                s = replace(s, Token.SpecUpper, specUpper);
                s = replace(s, Token.TypeUpper, p.parent.rule);
                s = replace(s, Token.NameUpper, p.parent.nameReal);
                s = replace(s, Token.NameUpper2, p.parent.name);
                s = replace(s, Token.IndexUpper, "i" + upperHeadChar(p.parent.name));
            }
            return s;
        }

        private String makeUnitIterHead(NestedParam p) {
            String s = empty;
            if (p.parent != null && p.parent.type != TypeID.VOID) {
                s = snippetTryGet(prefix + p.parent.type.getName() + ".head" + p.tag);
                if (s.equals(empty))
                    s = snippetTryGet(prefix + p.parent.type.getName() + ".head");
            }
            return s;
        }

        private NestedParam makeParams(NestedParam parent, String rule, String name, String nameReal, String tag) {
            String splitType = snippetTryGet(Key.FILE_TYPE_SPLIT, null);
            String splitPack = snippetTryGet(Key.IMPORT_SPLIT, empty);
            String split = splitType == null ? splitPack : splitType;
            rule = rule.replace(".", splitPack);
            NestedParam p = new NestedParam();
            p.name = name;
            p.nameReal = nameReal;
            p.tag = tag;
            p.parent = parent;
            p.depth = (parent != null ? parent.depth : 0) + 1;
            p.rule = rule.replace(ruleTypeSplit, split).trim();
            if (parent != null) {
                p.field = parent.field;
            }
            return p;
        }
    } //class NestedCoder

    private final class NestedParam {

        private NestedParam parent = null;
        private boolean isFirst = false;
        private boolean isLast = false;
        private Integer depth = 0;
        private InvarField field = null;
        private TypeID type = TypeID.VOID;
        private String rule = empty;
        private String name = empty;
        private String nameReal = empty;
        private String tag = empty;

        public boolean isRoot() {
            return depth == 1;
        }
    }
}
