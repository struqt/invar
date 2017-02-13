/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lang;

import invar.InvarContext;
import invar.model.*;
import invar.model.InvarType.TypeID;

import java.util.*;
import java.util.Map.Entry;

public class TokenParser {
    private final static String STR_EMPTY = "";
    private final static String SPLIT_GENERICS = "-";
    private final static String SPLIT_PACK_TYPE = "::";

    private final Map<String, InvarType> searchCache;
    private final Map<TokenNode, TypeEnum> enumNodes;
    private final Map<TokenNode, TypeStruct> structNodes;
    private final Map<TokenNode, TypeProtocol> protocNodes;

    public TokenParser() {
        enumNodes = new LinkedHashMap<TokenNode, TypeEnum>(256);
        structNodes = new LinkedHashMap<TokenNode, TypeStruct>(256);
        protocNodes = new LinkedHashMap<TokenNode, TypeProtocol>(256);
        searchCache = new HashMap<String, InvarType>(512);
    }

    public void init(TokenNode node, InvarContext ctx) throws Exception {
        //System.out.println("TokenParser.init()\n" + node.toStringXml());
        int len = node.numChildren();
        for (int i = 0; i < len; i++) {
            TokenNode n = node.getChild(i);
            String packName = "";
            if (n.getName().equals("package")) {
                packName = getAttrOptional(n, "name");
            }
            InvarPackage pack = ctx.findOrCreatePack(packName);
            initPack(pack, n, ctx);
        }
    }

    public void parse(InvarContext ctx) throws Exception {
        for (Entry<TokenNode, TypeEnum> e : enumNodes.entrySet()) {
            parseEnum(e.getKey(), e.getValue());
        }
        for (Entry<TokenNode, TypeStruct> e : structNodes.entrySet()) {
            parseStruct(e.getKey(), e.getValue(), ctx);
        }
        for (Entry<TokenNode, TypeProtocol> e : protocNodes.entrySet()) {
            parseProtoc(e.getKey(), e.getValue(), ctx);
        }
    }

    private void initPack(InvarPackage pack, TokenNode node, InvarContext ctx) throws Exception {
        int len = node.numChildren();
        for (int i = 0; i < len; i++) {
            TokenNode n = node.getChild(i);
            String alias = getAttrOptional(n, "alias");
            if (!alias.equals("") && ctx.aliasGet(alias) != null) {
                throw new Exception(error(n, "Repeated alias: " + alias));
            }
            if (n.getName().equals("enum")) {
                String name = getAttr(n, "name");
                String comment = getAttrOptional(n, "doc");
                TypeEnum t = new TypeEnum(name, pack, comment);
                addToPack(pack, t, n);
                if (alias.equals("")) {
                    alias = name;
                }
                t.setAlias(alias);
                ctx.aliasAdd(t);
                enumNodes.put(n, t);
            } else if (n.getName().equals("struct")) {
                String name = getAttr(n, "name");
                String comment = getAttrOptional(n, "doc");
                String table = getAttrOptional(n, "table");
                TypeStruct t = new TypeStruct(name, pack, comment);
                addToPack(pack, t, n);
                t.setAlias(alias);
                t.setTableName(table);
                structNodes.put(n, t);
                t.setShortField(getAttrOptional(n, "short"));
                t.setNoHotfix(Boolean.parseBoolean(getAttrOptional(n, "nohotfix")));
            } else if (n.getName().equals("protoc")) {
                Integer id = Integer.parseInt(getAttr(n, "id")) & 0xFFFF;
                String name = getAttr(n, "name");
                String comment = getAttrOptional(n, "doc");
                TypeProtocol t = new TypeProtocol(id, name, pack, comment);
                addToPack(pack, t, n);
                protocNodes.put(n, t);
            } else {
                warn(n, "Unexpected XML node. It has been ignorned: ");
            }
        }
    }

    private void parseEnum(TokenNode node, TypeEnum t) throws Exception {
        int len = node.numChildren();
        for (int i = 0; i < len; i++) {
            TokenNode n = node.getChild(i);
            String name = getAttr(n, "name");
            String value = getAttr(n, "value");
            String doc = getAttrOptional(n, "doc");
            try {
                Integer v = Integer.decode(value);
                t.addOption(name, v, doc);
            } catch (NumberFormatException e) {
                throw new Exception(error(n, "Not an inteager: " + value));
            }
        }
    }

    private void parseProtoc(TokenNode node, TypeProtocol t, InvarContext ctx) throws Exception {
        TokenNode nClient = null;
        TokenNode nServer = null;
        List<String> nodes = new ArrayList<String>(2);
        String pName = node.getName();
        int len = node.numChildren();
        for (int i = 0; i < len; i++) {
            TokenNode n = node.getChild(i);
            if (n.getName().equals("client")) {
                if (nClient == null) {
                    nClient = n;
                    nodes.add("client");
                } else {
                    throw new Exception(error(node, "Repeated client in protocol '" + pName + "'"));
                }
            } else if (n.getName().equals("server")) {
                if (nServer == null) {
                    nServer = n;
                    nodes.add("server");
                } else {
                    throw new Exception(error(node, "Repeated server in protocol '" + pName + "'"));
                }
            } else {
                throw new Exception(error(node, "Invalid element in protocol '" + pName + "'"));
            }

        }
        t.reset(nodes);
        if (nClient != null) {
            parseStruct(nClient, t.getClient(), ctx);
        }
        if (nServer != null) {
            parseStruct(nServer, t.getServer(), ctx);
        }
    }

    private void parseStruct(TokenNode node, TypeStruct tStruct, InvarContext ctx) throws Exception {
        if (tStruct.getProtoc() != null) {
            TypeProtocol tProtoc = tStruct.getProtoc();
            if (tStruct == tProtoc.getResponse()) {
                AddProtocErrField(tStruct, ctx);
            }
            AddProtocIdField(tStruct, ctx);
            AddProtocCRC32Field(tStruct, ctx);
            TypeStruct t2s = ctx.getStructProtoc2S();
            if (t2s != null && t2s.getPack() == tStruct.getPack() && tStruct == tStruct.getProtoc().getClient()) {
                InvarField field = makeAutoAddField(tStruct, t2s, t2s.getAlias(), t2s.getComment(), false);
                field.setUsePointer(true);
                tStruct.addField(field);
            }
            TypeStruct t2c = ctx.getStructProtoc2C();
            if (t2c != null && t2c.getPack() == tStruct.getPack() && tStruct == tStruct.getProtoc().getServer()) {
                InvarField field = makeAutoAddField(tStruct, t2c, t2c.getAlias(), t2c.getComment(), false);
                field.setUsePointer(true);
                tStruct.addField(field);
            }
        }
        int len = node.numChildren();
        for (int i = 0; i < len; i++) {
            TokenNode n = node.getChild(i);
            String name = getAttr(n, "name");
            String type = getAttr(n, "type");
            String deft = getAttrOptional(n, "value");
            String doc = getAttrOptional(n, "doc");
            String alias = getAttrOptional(n, "alias");
            boolean auto = Boolean.parseBoolean(getAttrOptional(n, "auto"));
            LinkedList<InvarType> types = parseFieldType(type, n, ctx);
            if (types == null || types.size() <= 0) {
                throw new Exception(error(n, "Field type is invalid"));
            }

            InvarType typeMain = types.get(0);
            types.remove(0);
            TypeID tid = typeMain.getId();
            boolean isStructSelf = (typeMain == tStruct);
            boolean useRef = tid.getUseRefer();
            if (n.hasAttr("useref")) {
                useRef = Boolean.parseBoolean(getAttrOptional(n, "useref"));
            }
            boolean disableSetter = Boolean.parseBoolean(getAttrOptional(n, "nosetter"));
            switch (tid) {
                case VEC:
                case MAP:
                    disableSetter = true;
                    break;
                default:
                    break;
            }
            boolean usePtr = Boolean.parseBoolean(getAttrOptional(n, "useptr"));
            usePtr = isStructSelf || typeMain.getId().getNullable() && usePtr;
            if (usePtr) {
                disableSetter = false;
            }
            InvarField field = new InvarField(tStruct.numFields(), typeMain, name, doc, disableSetter, false);
            field.setDefault(deft);
            field.setAlias(alias);
            field.setAuto(auto);
            field.setUseReference(useRef);
            field.setUsePointer(usePtr);
            if (tid == TypeID.VEC) {
                if (types.size() < 1) {
                    types.addFirst(ctx.findBuildInType(TypeID.INT32));
                }
            } else if (tid == TypeID.MAP) {
                if (types.size() < 1) {
                    types.addFirst(ctx.findBuildInType(TypeID.INT32));
                }
                if (types.size() < 2) {
                    types.addFirst(ctx.findBuildInType(TypeID.INT32));
                }
            }
            field.getGenerics().addAll(types);
            tStruct.addField(field);
        }
        if (!tStruct.getNoHotfix()) {
            InvarType typeBasic = ctx.findBuildInType(TypeID.MAP);
            InvarField field = makeAutoAddField(tStruct, typeBasic, "hotfix", "Hotfix", false);
            field.getGenerics().add(ctx.findBuildInType(TypeID.STRING));
            field.getGenerics().add(ctx.findBuildInType(TypeID.STRING));
            field.setUsePointer(true);
            tStruct.addField(field);
        }
        if (tStruct.getAlias() == null || tStruct.getAlias().length() <= 0) {
            tStruct.setAlias(tStruct.getConflict(ctx) ? tStruct.getUniqueName() : tStruct.getName());
        }
        ctx.aliasAdd(tStruct);
    }

    private InvarField makeAutoAddField(
        TypeStruct struct, InvarType typeBasic, String name, String doc, Boolean noSetter) {
        return new InvarField(struct.numFields(), typeBasic, name, "[AutoAdd] " + doc, noSetter, true);
    }

    private void AddProtocCRC32Field(TypeStruct t, InvarContext ctx) throws Exception {
        InvarType typeBasic = ctx.findBuildInType(TypeID.UINT32);
        InvarField field = makeAutoAddField(t, typeBasic, "protocCRC", "Protocol CRC32", true);
        field.setDefault("CRC32");
        t.addField(field);
    }

    private void AddProtocIdField(TypeStruct t, InvarContext ctx) throws Exception {
        TypeProtocol protoc = t.getProtoc();
        Integer id = 0;
        if (t == protoc.getClient()) {
            id = protoc.getClientId();
        } else if (t == protoc.getServer()) {
            id = protoc.getServerId();
        }
        if (id == 0) {
            return;
        }
        InvarType typeBasic = ctx.findBuildInType(TypeID.UINT16);
        InvarField field = makeAutoAddField(t, typeBasic, "protocId", "ProtocolID", true);
        field.setDefault(id.toString());
        t.addField(field);
    }

    private void AddProtocErrField(TypeStruct t, InvarContext ctx) throws Exception {
        InvarType typeBasic = ctx.findBuildInType(TypeID.INT32);
        InvarField field = makeAutoAddField(t, typeBasic, "protocError", "Protocol error code", false);
        field.setDefault("0");
        t.addField(field);
    }

    private LinkedList<InvarType> parseFieldType(String name, TokenNode n, InvarContext ctx) throws Exception {
        LinkedList<InvarType> ts = new LinkedList<InvarType>();
        if (name.indexOf(SPLIT_GENERICS) > 0) {
            String[] ss = name.split(SPLIT_GENERICS);
            for (String s : ss) {
                ts.add(searchType(s, ctx, n));
            }
        } else if (name.indexOf(SPLIT_GENERICS) == 0) {
            error(n, "Wrong generic format");
        } else {
            ts.add(searchType(name, ctx, n));
        }
        return ts;
    }

    private InvarType searchType(String name, InvarContext ctx, TokenNode n) throws Exception {
        if (searchCache.containsKey(name)) {
            return searchCache.get(name);
        }
        //System.out.println("TokenParser.searchType() --- " + name);
        String[] names = name.split(SPLIT_PACK_TYPE);
        String typeName;
        InvarPackage typePack = null;
        InvarType type;
        if (names.length == 1) {
            typeName = names[0];
        } else if (names.length == 2) {
            typeName = names[1];
            typePack = ctx.getPack(names[0]);
            if (typePack == null) {
                throw new Exception(error(n, "Package does not exist: " + name));
            }
        } else {
            throw new Exception(error(n, "Invalid type name: " + name));
        }
        type = ctx.findBuildInType(typeName);
        if (type == null) {
            if (typePack != null) {
                type = typePack.getType(typeName);
                if (type == null) {
                    throw new Exception(error(n, "No type in the package: " + name));
                }
            } else {
                List<InvarType> types = ctx.findTypes(typeName);
                if (types.size() == 1) {
                    type = types.get(0);
                } else if (types.size() > 1) {
                    // has conflicts
                    StringBuilder s = new StringBuilder();
                    for (InvarType t : types) {
                        s.append('\n');
                        s.append(t.getPack().getName());
                        s.append(SPLIT_PACK_TYPE);
                        s.append(t.getName());
                    }
                    throw new Exception(error(n,
                        "Find " + types.size() + " types. You should select one:" + s.toString()));
                }
            }
        }
        if (type == null) {
            throw new Exception(error(n, "Undefined type: " + name));
        } else {
            searchCache.put(name, type);
        }
        if (type.getId() == TypeID.PROTOCOL) {
            throw new Exception(error(n, "Protocol type can not be here: " + type.getName()));
        }
        return type;
    }

    private void addToPack(InvarPackage pack, InvarType t, TokenNode n) throws Exception {
        if (pack.getType(t.getName()) != null) {
            throw new Exception(error(n, "Repeated type name: " + t.getName()));
        }
        pack.add(t);
    }

    private String getAttrOptional(TokenNode n, String key) {
        String s = n.getAttr(key);
        return s == null ? STR_EMPTY : s.trim();
    }

    private String getAttr(TokenNode node, String key) throws Exception {
        String v = getAttrOptional(node, key);
        if (v.equals(STR_EMPTY)) {
            throw new Exception(error(node, "Attribute '" + key + "' is required."));
        }
        return v;
    }

    private String error(TokenNode node, String hint) {
        boolean withChildren = node.numAttributes() < 1;
        return String.format("[ERROR] %s\n%s\n%s", hint, node.toStringXml(withChildren), node.getFilePath());
    }

    private void warn(TokenNode node, String hint) {
        boolean withChildren = node.numAttributes() < 1;
        StringBuilder s = new StringBuilder();
        s.append("[WARN] ");
        s.append(hint);
        s.append('\n');
        s.append(node.toStringXml(withChildren));
        s.append('\n');
        s.append(node.getFilePath());
        System.out.println(s);
    }
}
