/*===----------------------------*  Java  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package invar;

import java.math.BigInteger;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import test.abc.Custom;
import test.abc.Gender;
import test.abc.Info;
import test.abc.TestBasic;
import test.db.MemberEntry;
import test.protoc.Protoc2C;
import test.protoc.Protoc2S;
import test.protoc.TestHeartBeat2C;
import test.protoc.TestHeartBeatR2S;
import test.protoc.TestServerTimeN2C;
import test.protoc.TestUserLocationN2S;
import test.protoc.TestUserLogin2S;
import test.protoc.TestUserLoginR2C;
import test.xyz.ConfigRoot;
import test.xyz.InfoX;
import test.xyz.TestDict;
import test.xyz.TestList;
import test.xyz.TestNest;
import test.xyz.TestPointer;
import test.xyz.TestRefer;


public final class InvarRuntime
{
    static public InvarReadData MakeXmlReader()
    {
        if (InvarReadData.aliasBasics == null)
        {
            InvarReadData.aliasBasics = aliasBasic();
            InvarReadData.aliasEnums = aliasEnum();
            InvarReadData.aliasStructs = aliasStruct();
        }
        return new InvarReadData();
    }
    static private LinkedHashMap<String,Class<?>> aliasBasic ()
    {
        LinkedHashMap<String,Class<?>> map = new LinkedHashMap<String,Class<?>>();
        map.put("bool", java.lang.Boolean.class);
        map.put("double", java.lang.Double.class);
        map.put("float", Float.class);
        map.put("int16", Short.class);
        map.put("int32", Integer.class);
        map.put("int64", Long.class);
        map.put("int8", java.lang.Byte.class);
        map.put("map", LinkedHashMap.class);
        map.put("string", java.lang.String.class);
        map.put("uint16", java.lang.Integer.class);
        map.put("uint32", java.lang.Long.class);
        map.put("uint64", BigInteger.class);
        map.put("uint8", java.lang.Integer.class);
        map.put("vec", LinkedList.class);
        return map;
    }
    static private LinkedHashMap<String,Class<?>> aliasEnum ()
    {
        LinkedHashMap<String,Class<?>> map = new LinkedHashMap<String,Class<?>>();
        map.put("Gender", Gender.class);
        return map;
    }
    static private LinkedHashMap<String,Class<?>> aliasStruct ()
    {
        LinkedHashMap<String,Class<?>> map = new LinkedHashMap<String,Class<?>>();
        map.put("Custom", Custom.class);
        map.put("Info", Info.class);
        map.put("InfoX", InfoX.class);
        map.put("MemberEntry", MemberEntry.class);
        map.put("TestAbcConflict", test.abc.Conflict.class);
        map.put("TestBasic", TestBasic.class);
        map.put("TestDict", TestDict.class);
        map.put("TestHeartBeat2C", TestHeartBeat2C.class);
        map.put("TestHeartBeatR2S", TestHeartBeatR2S.class);
        map.put("TestList", TestList.class);
        map.put("TestNest", TestNest.class);
        map.put("TestPointer", TestPointer.class);
        map.put("TestRefer", TestRefer.class);
        map.put("TestServerTimeN2C", TestServerTimeN2C.class);
        map.put("TestUserLocationN2S", TestUserLocationN2S.class);
        map.put("TestUserLogin2S", TestUserLogin2S.class);
        map.put("TestUserLoginR2C", TestUserLoginR2C.class);
        map.put("TestXyzConflict", test.xyz.Conflict.class);
        map.put("protoc2C", Protoc2C.class);
        map.put("protoc2S", Protoc2S.class);
        map.put("root", ConfigRoot.class);
        return map;
    }

}

