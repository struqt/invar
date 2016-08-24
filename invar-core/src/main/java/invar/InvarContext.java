/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar;

import invar.model.InvarPackage;
import invar.model.InvarType;
import invar.model.InvarType.TypeID;
import invar.model.TypeEnum;
import invar.model.TypeStruct;

import java.util.*;

final public class InvarContext {
    public static final String encoding = "UTF-8";

    private final InvarPackage packBuildIn;
    private final HashMap<String, InvarPackage> packAll;
    private final HashMap<String, InvarType> typeWithAlias;
    private String ruleDir;
    private TypeStruct structRoot;
    private TypeStruct structProtoc2S;
    private TypeStruct structProtoc2C;

    public InvarContext() throws Exception {
        typeWithAlias = new LinkedHashMap<String, InvarType>();
        packBuildIn = new InvarPackage("___", false);
        packAll = new HashMap<String, InvarPackage>();
        packAll.put(packBuildIn.getName(), packBuildIn);
    }

    public InvarPackage addBuildInTypes(TreeMap<TypeID, String> map) {
        InvarPackage pack = packBuildIn;
        Iterator<TypeID> i = map.keySet().iterator();
        while (i.hasNext()) {
            TypeID id = i.next();
            String name = map.get(id);
            InvarType type = new InvarType(id, name, pack, name + "[buildin]", true);
            pack.put(type);
            if (TypeID.VEC == id) {
                type.setGeneric("<?>");
            } else if (TypeID.MAP == id) {
                type.setGeneric("<?,?>");
            }
            //else {}
        }
        packAll.put(pack.getName(), pack);
        return pack;
    }

    public InvarContext typeRedefine(TypeID id,
                                     String namePack,
                                     String nameType,
                                     String generic,
                                     String initValue,
                                     String codePath) {
        if (TypeID.ENUM == id || TypeID.STRUCT == id || TypeID.PROTOCOL == id) {
            return this;
        }
        InvarType type = packBuildIn.getType(id);
        InvarType typeGhost = addDialectType(namePack, nameType, generic, id, false, initValue, codePath);

        type.setRedirect(typeGhost);
        type.setInitValue(initValue);
        type.setCodePath(codePath);
        typeWithAlias.put(type.getName(), typeGhost);
        return this;
    }

    public InvarType addDialectType(String namePack,
                                    String nameType,
                                    String generic,
                                    TypeID realId,
                                    Boolean isBuildin,
                                    String initValue,
                                    String codePath) {
        InvarPackage pack = packAll.get(namePack);
        if (pack == null) {
            pack = new InvarPackage(namePack, false);
            packAll.put(namePack, pack);
        }
        InvarType t = new InvarType(TypeID.DIALECT, nameType, pack, "", isBuildin);
        t.setGeneric(generic);
        t.setRealId(realId);
        t.setInitValue(initValue);
        t.setCodePath(codePath);
        pack.put(t);
        return t;
    }

    public void clearDialectTypes() {
        Iterator<String> i = packAll.keySet().iterator();
        while (i.hasNext()) {
            InvarPackage pack = packAll.get(i.next());
            pack.clearGhostTypes();
            if (pack.size() == 0)
                i.remove();
        }
    }

    public InvarPackage findOrCreatePack(String name) {
        InvarPackage info = packAll.get(name);
        if (info == null) {
            info = new InvarPackage(name, true);
            packAll.put(name, info);
        }
        return info;
    }

    public InvarPackage getPack(String name) {
        return packAll.get(name);
    }

    public Iterator<String> getPackNames() {
        return packAll.keySet().iterator();
    }

    public List<InvarType> findTypes(String typeName) {
        return findTypes(typeName, false);
    }

    public List<InvarType> findTypes(String typeName, boolean ignoreBuildin) {
        Iterator<String> i = packAll.keySet().iterator();
        InvarType type;
        List<InvarType> types = new ArrayList<InvarType>();
        while (i.hasNext()) {
            InvarPackage pack = packAll.get(i.next());
            if (ignoreBuildin && pack == packBuildIn)
                continue;
            type = pack.getType(typeName);
            if (type != null)
                types.add(type);
        }
        return types;
    }

    public InvarType findBuildInType(String typeName) {
        Iterator<String> i = packBuildIn.getTypeNames();
        while (i.hasNext()) {
            String name = i.next();
            InvarType type = packBuildIn.getType(name);
            if (name.equals(typeName)) {
                return type;
            }
            InvarType typeRedi = type.getRedirect();
            if (typeRedi != null && typeRedi.getName().equals(typeName)) {
                return typeRedi;
            }
        }
        return packBuildIn.getType(typeName.toLowerCase());
    }

    public InvarType findBuildInType(TypeID id) {
        return packBuildIn.getType(id);
    }

    public boolean isBuildInPack(InvarPackage pack) {
        return pack == packBuildIn;
    }

    public void aliasAdd(TypeEnum type) {
        typeWithAlias.put(type.getAlias(), type);
    }

    public void aliasAdd(TypeStruct type) {
        typeWithAlias.put(type.getAlias(), type);
        if (type.getAlias().equals("root")) {
            structRoot = type;
        }
        if (type.getAlias().equals("protoc2S")) {
            structProtoc2S = type;
        }
        if (type.getAlias().equals("protoc2C")) {
            structProtoc2C = type;
        }
    }

    public InvarType aliasGet(String alias) {
        return typeWithAlias.get(alias);
    }

    public Iterator<String> aliasNames() {
        return new TreeSet<String>(typeWithAlias.keySet()).iterator();
    }

    public TypeStruct getStructRoot() {
        return structRoot;
    }

    public TypeStruct getStructProtoc2S() {
        return structProtoc2S;
    }

    public TypeStruct getStructProtoc2C() {
        return structProtoc2C;
    }

    public void setRuleDir(String path) {
        ruleDir = path;
    }

    public String getRuleDir() {
        return ruleDir;
    }

}
