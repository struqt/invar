/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar;

import invar.lang.xml.TokensFromXml;
import invar.model.InvarType.TypeID;

import java.util.Date;
import java.util.TreeMap;

final public class Invar {

    static final String ARG_HELP = "help";
    static final String ARG_SNIPPET_PATH = "snippet";
    static final String ARG_RULE_PATH = "rule";
    static final String ARG_XSD_PATH = "xsd";
    static final String ARG_JAVA_PATH = "java";
    static final String ARG_FLASH_PATH = "flash";
    static final String ARG_CSHARP_PATH = "csharp";
    static final String ARG_CPP_PATH = "cpp";
    static final String ARG_PHP_PATH = "php";
    static final String ARG_OBJC_PATH = "objc";
    static final String ARG_PYTHON_PATH = "python";

    static public void main(String[] args) {

        long startMS = System.currentTimeMillis();
        log("Invar start: " + new Date().toString() + " " + (Runtime.getRuntime().freeMemory() >> 20) + "MB");

        InvarMainArgs a = new InvarMainArgs();
        a.addDefault(ARG_RULE_PATH, "rule/");
        a.addDefault(ARG_SNIPPET_PATH, "res/");
        a.addDefault(ARG_XSD_PATH, "code/xsd/");
        a.addDefault(ARG_JAVA_PATH, "code/java/");
        a.addDefault(ARG_FLASH_PATH, "code/flash/");
        a.addDefault(ARG_CSHARP_PATH, "code/csharp/");
        a.addDefault(ARG_CPP_PATH, "code/cpp/");
        a.addDefault(ARG_PHP_PATH, "code/php/");
        a.addDefault(ARG_OBJC_PATH, "code/objc/");
        a.addDefault(ARG_PYTHON_PATH, "code/objc/");
        a.parseArguments(args);

        if (a.has(ARG_HELP)) {
            showHelp();
            return;
        }

        TreeMap<TypeID, String> basics = makeTypeIdMap();
        try {
            InvarContext ctx = new InvarContext();
            ctx.addBuildInTypes(basics);
            ctx.setRuleDir(a.get(ARG_RULE_PATH));
            log("");
            if (a.has(ARG_RULE_PATH)) {
                TokensFromXml.start(ctx);
            }
            if (a.has(ARG_XSD_PATH)) {
                log("");
                new InvarWriteXSD().write(ctx, basics, a.get(ARG_XSD_PATH));
            }
            if (a.has(ARG_CSHARP_PATH)) {
                log("");
                new InvarWriteCode(ctx, a.get(ARG_CSHARP_PATH), "csharp/snippet.xml", a.get(ARG_SNIPPET_PATH)).write(".cs");
            }
            if (a.has(ARG_JAVA_PATH)) {
                log("");
                new InvarWriteCode(ctx, a.get(ARG_JAVA_PATH), "java/snippet.xml", a.get(ARG_SNIPPET_PATH)).write(".java");
            }
            if (a.has(ARG_OBJC_PATH)) {
                log("");
                new InvarWriteCode(ctx, a.get(ARG_OBJC_PATH), "objc/snippet.h.xml", a.get(ARG_SNIPPET_PATH)).write(".h");
                new InvarWriteCode(ctx, a.get(ARG_OBJC_PATH), "objc/snippet.m.xml", a.get(ARG_SNIPPET_PATH)).write(".m", true);
            }
            if (a.has(ARG_PYTHON_PATH)) {
                log("");
                new InvarWriteCode(ctx, a.get(ARG_PYTHON_PATH), "python/snippet.xml", a.get(ARG_SNIPPET_PATH)).write(".py", true);
            }
            if (a.has(ARG_CPP_PATH)) {
                log("");
                new InvarWriteCode(ctx, a.get(ARG_CPP_PATH), "cpp/snippet.h.xml", a.get(ARG_SNIPPET_PATH)).write(".h");
                new InvarWriteCode(ctx, a.get(ARG_CPP_PATH), "cpp/snippet.cc.xml", a.get(ARG_SNIPPET_PATH)).write(".cpp", true);
            }
            if (a.has(ARG_PHP_PATH)) {
                log("");
                new InvarWriteCode(ctx, a.get(ARG_PHP_PATH), "php/snippet.xml", a.get(ARG_SNIPPET_PATH)).write(".php");
            }
            if (a.has(ARG_FLASH_PATH)) {
                log("");
                new InvarWriteCode(ctx, a.get(ARG_FLASH_PATH), "flash/snippet.xml", a.get(ARG_SNIPPET_PATH)).write(".as");
            }
            long total = Runtime.getRuntime().totalMemory();
            long free = Runtime.getRuntime().freeMemory();
            log("\nInvar end: " + (System.currentTimeMillis() - startMS) + "ms, " + ((total - free) >> 20) + "/" + (total >> 20) + "MB");
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    static public TreeMap<TypeID, String> makeTypeIdMap() {
        TreeMap<TypeID, String> map = new TreeMap<TypeID, String>();
        map.put(TypeID.INT08, TypeID.INT08.getName());
        map.put(TypeID.INT16, TypeID.INT16.getName());
        map.put(TypeID.INT32, TypeID.INT32.getName());
        map.put(TypeID.INT64, TypeID.INT64.getName());
        map.put(TypeID.UINT08, TypeID.UINT08.getName());
        map.put(TypeID.UINT16, TypeID.UINT16.getName());
        map.put(TypeID.UINT32, TypeID.UINT32.getName());
        map.put(TypeID.UINT64, TypeID.UINT64.getName());
        map.put(TypeID.FLOAT, TypeID.FLOAT.getName());
        map.put(TypeID.DOUBLE, TypeID.DOUBLE.getName());
        map.put(TypeID.BOOL, TypeID.BOOL.getName());
        map.put(TypeID.STRING, TypeID.STRING.getName());
        map.put(TypeID.MAP, TypeID.MAP.getName());
        map.put(TypeID.VEC, TypeID.VEC.getName());
        return map;
    }

    static void showHelp() {
        StringBuilder s = new StringBuilder(256);
        s.append("\n");
        s.append("Description: ");
        s.append("\n  ");
        s.append("Invariable data interchange format in your project.");
        s.append("\n\n");
        s.append("Argument List: ");
        s.append("\n  ");
        s.append(ARG_HELP);
        s.append("\n  ");
        s.append(ARG_RULE_PATH);
        s.append("\n  ");
        s.append(ARG_JAVA_PATH);
        s.append("\n  ");
        s.append(ARG_FLASH_PATH);
        log(s);
    }

    static void log(Object txt) {
        System.out.println(txt);
    }

}
