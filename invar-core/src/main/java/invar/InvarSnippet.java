/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar;

import invar.model.InvarType;
import invar.model.InvarType.TypeID;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;

final public class InvarSnippet {

    private final static String empty = "";
    private final static String whiteSpace = " ";
    private final static String br = "\n";
    private final static String indent = whiteSpace + whiteSpace + whiteSpace + whiteSpace;

    final private Document snippetDoc;
    final private HashMap<String, String> snippetMap;
    final private String snippetDir;
    final private String snippetPath;
    final private InvarContext context;
    final private InvarWrite writer;

    //For C++ template "> >" issue in GCC
    private Boolean genericOverride = false;

    InvarSnippet(InvarContext ctx, String dir, String path, InvarWrite writer) throws Exception {
        this.context = ctx;
        this.writer = writer;
        this.snippetDir = dir;
        this.snippetPath = dir + path;
        this.snippetDoc = getSnippetDoc(this.snippetPath);
        this.snippetMap = new LinkedHashMap<String, String>();
    }

    void buildSnippetMap(InvarContext c) {
        if (!snippetDoc.hasChildNodes())
            return;
        Node root = snippetDoc.getFirstChild();
        c.setLanguage(getAttrOptional(root, "language"));
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            if (Node.ELEMENT_NODE != n.getNodeType())
                continue;
            String nameNode = n.getNodeName().toLowerCase();
            if (nameNode.equals("redefine")) {
                genericOverride = Boolean.parseBoolean(getAttrOptional(n, "genericOverride"));
                buildTypeRedefine(n.getChildNodes(), c);
            } else if (nameNode.equals("template")) {
                buildTemplates(n);
            } //else {}
        }
    }

    void buildExportFiles() {
        if (!snippetDoc.hasChildNodes())
            return;
        String fileHead = this.tryGet(Key.FILE_HEAD, empty);
        Node root = snippetDoc.getFirstChild();
        NodeList nodes = root.getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            if (Node.ELEMENT_NODE != n.getNodeType())
                continue;
            String nameNode = n.getNodeName().toLowerCase();
            if (nameNode.equals("export")) {
                buildExport(n, fileHead);
            }
        }
    }

    String tryGet(String key, String deft) {
        if (!snippetMap.containsKey(key)) {
            return deft;
        }
        return snippetMap.get(key);
    }

    String getSnippetPath() {
        return snippetPath;
    }

    Boolean getGenericOverride() {
        return genericOverride;
    }

    static private String getAttrOptional(Node node, String name) {
        Node n = node.getAttributes().getNamedItem(name);
        String v = empty;
        if (n != null) {
            v = n.getNodeValue();
        }
        return v;
    }

    private void buildTemplates(Node node) {
        String key = getAttrOptional(node, "key");
        key = key.replaceAll("\\s", empty);
        if (key.equals(empty))
            return;
        NodeList nodes = node.getChildNodes();
        int len = nodes.getLength();
        String cdada = empty;
        for (int i = 0; i < len; i++) {
            Node n = nodes.item(i);
            if (Node.CDATA_SECTION_NODE != n.getNodeType())
                continue;
            cdada = n.getTextContent();
        }
        String[] keys = key.split("\\|");
        for (String k : keys) {
            if (k.equals(empty))
                continue;
            snippetAdd(k, cdada);
        }
    }

    private void buildTypeRedefine(NodeList nodes, InvarContext c) {
        int len = nodes.getLength();
        for (int i = 0; i < len; i++) {
            Node n = nodes.item(i);
            if (Node.ELEMENT_NODE != n.getNodeType())
                continue;
            String typeName = n.getNodeName().toLowerCase();
            String type = getAttrOptional(n, "type");
            String pack = getAttrOptional(n, "pack");
            String generic = getAttrOptional(n, "generic");
            String initValue = getAttrOptional(n, "initValue");
            String include = getAttrOptional(n, "include");
            type = type.trim();
            pack = pack.trim();
            initValue = initValue.trim();
            InvarType buildInT = c.findBuildInType(typeName);
            if (buildInT == null) {
                context.addDialectType(pack, type, generic, TypeID.DIALECT, false, initValue, include);
                continue;
            }
            TypeID id = buildInT.getId();
            c.typeRedefine(id, pack, type, generic, initValue, include);
        }
    }

    private void buildExport(Node n, String fileHead) {
        String resPath = this.snippetDir + getAttrOptional(n, "resPath");
        String destDir = getAttrOptional(n, "destDir");
        String destName = getAttrOptional(n, "destName");
        InputStream stream = getSnippetStream(resPath);
        if (stream != null) {
            writer.exportFile(destDir, destName, fileHead, stream);
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void snippetAdd(String key, String s) {
        String[] lines = s.split("\n|\r\n");
        StringBuilder code = new StringBuilder();
        int len = lines.length;
        for (int i = 0; i < len; i++) {
            String line = lines[i];
            line = line.replaceAll("(^\\s*|\\s*$)", empty);
            line = line.replaceAll("(\\s*)(" + Token.Indent //
                + "|" + Token.Blank//
                //+ "|" + Token.Body//
                + ")(\\s*)", "$2");
            if (!line.equals(empty)) {
                line = line.replaceAll(Token.Br, br);
                line = line.replaceAll(Token.Indent, indent);
                line = line.replaceAll(Token.Blank, empty);
                line = line.replaceAll(Token.Space, whiteSpace);
                code.append(line);
                code.append(i != len - 1 ? br : empty);
            }
        }
        snippetMap.put(key, code.toString());
    }

    private Document getSnippetDoc(String path/*, InvarContext ctx*/) throws Exception {
        InputStream stream = getSnippetStream(path);
        if (stream == null) {
            System.out.println("error X---------> " + path);
            return null;
        }
        InputSource input = new InputSource(stream);
        Document doc = DocumentBuilderFactory.newInstance()
            .newDocumentBuilder()
            .parse(input);
        if (!doc.hasChildNodes())
            return null;
        System.out.println("read  <- " + path);
        return doc;
    }

    private InputStream getSnippetStream(String path) {
        File file = new File(path);
        if (file.exists()) {
            try {
                return new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            return getClass().getResourceAsStream("/snippet/" + path);
        }
        return null;
    }

    static public class Key {
        final static String REFER_SPEC = "refer.spec";
        final static String REFER_INVOKE = "refer.invoke";
        final static String REFER_CONST = "refer.const";
        final static String POINTER_NULL = "pointer.null";
        final static String POINTER_SPEC = "pointer.spec";
        final static String POINTER_INVOKE = "pointer.invoke";

        final static String FILE = "file";
        final static String FILE_HEAD = "file.head";
        final static String FILE_PACK = "file.pack";
        final static String FILE_PACK_SPLIT = "file.pack.split";
        final static String FILE_TYPE_SPLIT = "file.type.split";
        final static String FILE_BODY = "file.body";
        final static String FILE_INCLUDE = "file.include";
        final static String FILE_INCLUDE_WRAP = "file.include.wrap";

        final static String DOC = "doc";
        final static String DOC_LINE = "doc.line";
        final static String IMPORT = "import";
        final static String IMPORT_SPLIT = "import.split";
        final static String IMPORT_BODY = "import.body";

        final static String CODE_ASSIGNMENT = "code.assignment";
        final static String CODE_DEFINITION = "code.definition";

        final static String RUNTIME_IMPORT = "runtime.import";
        final static String RUNTIME_FILE = "runtime.file";
        final static String RUNTIME_PACK = "runtime.pack";
        final static String RUNTIME_NAME = "runtime.name";
        final static String RUNTIME_BODY = "runtime.body";
        final static String RUNTIME_ALIAS = "runtime.alias";
        final static String RUNTIME_ALIAS_BASIC = "runtime.alias.basic";
        final static String RUNTIME_ALIAS_VEC = "runtime.alias.list";
        final static String RUNTIME_ALIAS_MAP = "runtime.alias.map";
        final static String RUNTIME_TYPE_SPLIT = "runtime.type.split";
        final static String RUNTIME_TYPE_FULL = "runtime.type.full";
        final static String RUNTIME_PROTOC_HANDLE_2S = "runtime.protoc.handle.client";
        final static String RUNTIME_PROTOC_HANDLE_2C = "runtime.protoc.handle.server";
        final static String RUNTIME_PROTOC_HEAD_2S = "runtime.protoc.head.client";
        final static String RUNTIME_PROTOC_HEAD_2C = "runtime.protoc.head.server";
        final static String RUNTIME_PROTOC_HANDLE_M = "runtime.protoc.handle.method";
        final static String RUNTIME_PROTOC_HANDLE_NTF = "runtime.protoc.handle.notify";
        final static String RUNTIME_PROTOC_HANDLE_RESP = "runtime.protoc.handle.response";
        final static String RUNTIME_PROTOC_HANDLE_REQ = "runtime.protoc.handle.request";
        final static String RUNTIME_PROTOC_IDS_FUNC = "runtime.protoc.ids.func";
        final static String RUNTIME_PROTOC_IDS_FUNC_NAME = "runtime.protoc.ids.func.name";
        final static String RUNTIME_PROTOC_IDS_FUNC_ITEM = "runtime.protoc.ids.func.item";


        final static String ENUM = "enum";
        final static String ENUM_FIELD = "enum.field";
        final static String STRUCT = "struct";
        final static String STRUCT_META = "struct.meta";
        final static String STRUCT_FIELD = "struct.field";
        final static String STRUCT_GETTER = "struct.getter";
        final static String STRUCT_SETTER = "struct.setter";

        final static String CONSTRUCT_FIELD = "ctor.field";
        final static String CONSTRUCT_FIELD_SPLIT = "ctor.field.split";
    }

    static class Token {
        final static String Br = wrapToken("brk");
        final static String Concat = wrapToken("concat");
        final static String ConcatAll = wrapToken("concat-all");
        final static String Indent = wrapToken("tab");
        final static String Blank = wrapToken("blank");
        final static String Space = wrapToken("space");
        final static String NullPtr = wrapToken("null");
        final static String ByteNull = wrapToken("bytenon");
        final static String ByteNotNull = wrapToken("byteyes");
        final static String Doc = wrapToken("doc");
        final static String DocBlock = wrapToken("block-doc");
        final static String Debug = wrapToken("debug");

        final static String Define = wrapToken("define");
        final static String Head = wrapToken("head");
        final static String Pack = wrapToken("pack");
        final static String Import = wrapToken("import");
        final static String Includes = wrapToken("includes");
        final static String Enums = wrapToken("enums");
        final static String Structs = wrapToken("structs");
        final static String Const = wrapToken("const");
        final static String ConstBlock = wrapToken("constblock");

        final static String Argument = wrapToken("arg");
        final static String SizeType = wrapToken("sizetype");
        final static String Size = wrapToken("len");
        final static String SizeOf = wrapToken("sizeof");
        final static String Key = wrapToken("key");
        final static String Value = wrapToken("value");
        final static String Body = wrapToken("body");
        final static String BodyIndent = wrapToken("bodyindent");
        final static String Invoke = wrapToken("invoke");
        final static String Default = wrapToken("deft");
        final static String Split = wrapToken("split");
        final static String Index = wrapToken("index");
        final static String IndexUpper = wrapToken("indexupper");
        final static String Mark = wrapToken("mark");
        final static String Specifier = wrapToken("spec");
        final static String SpecUpper = wrapToken("specupper");
        final static String Module = wrapToken("module");
        final static String Name = wrapToken("name");
        final static String NameUpper = wrapToken("nameupper");
        final static String NameUpper2 = wrapToken("nameupper2");
        final static String Type = wrapToken("type");
        final static String TypeFull = wrapToken("typefull");
        final static String TypeUpper = wrapToken("typeupper");
        final static String RuleLeft = wrapToken("typel");
        final static String RuleRight = wrapToken("typer");
        final static String NameReal = wrapToken("namer");
        final static String NameTable = wrapToken("table");
        final static String NameAlias = wrapToken("alias");
        final static String Request = wrapToken("req");
        final static String Response = wrapToken("resp");
        final static String ProtocId = wrapToken("protoc-id");
        final static String ProtocType = wrapToken("protoc-type");
        final static String ConstCRC = wrapToken("const-crc");
        final static String Struct = wrapToken("struct");

        static String wrapToken(String name) {
            return "\\(#" + name + "\\)";
        }
    }
}
