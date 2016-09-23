/*===-----------------------------*  C#  *---------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/

namespace Invar {

using System.Collections.Generic;
using System;
using Test.Abc;
using Test.Db;
using Test.Protoc;
using Test.Xyz;

public sealed class InvarRuntime {

static public InvarReadData MakeXmlReader()
{
    if (InvarReadData.AliasBasics == null) {
        InvarReadData.AliasBasics = aliasBasic ();
        InvarReadData.AliasEnums = aliasEnum ();
        InvarReadData.AliasStructs = aliasStruct ();
    }
    return new InvarReadData ();
}

static public void HandleProtocAsServer (System.IO.BinaryReader r)
{
    long p = r.BaseStream.Position;
    UInt16 id = r.ReadUInt16();
    r.BaseStream.Position = p;
    switch (id) {
    case 65527: /* 客户端请求,服务端响应 */
    { var req = new TestUserLogin2S(); req.Read(r); RecvRequest<TestUserLogin2S,TestUserLoginR2C>.Raise(req, new TestUserLoginR2C()); return; }
    case 65531: /* 客户端通知服务端 */
    { var ntf = new TestUserLocationN2S(); ntf.Read(r); RecvNotify<TestUserLocationN2S>.Raise(ntf); return; }
    case 65533: /* 服务端请求,客户端响应 */
    { var rep = new TestHeartBeatR2S(); rep.Read(r); RecvResponse<TestHeartBeatR2S>.Raise(rep); return; }
    default: throw new Exception("Unsupported protocol id: " + id);
    }
} // HandleProtocAsServer(...)

static public void HandleProtocAsClient (System.IO.BinaryReader r)
{
    long p = r.BaseStream.Position;
    UInt16 id = r.ReadUInt16();
    r.BaseStream.Position = p;
    switch (id) {
    case 65528: /* 客户端请求,服务端响应 */
    { var rep = new TestUserLoginR2C(); rep.Read(r); RecvResponse<TestUserLoginR2C>.Raise(rep); return; }
    case 65530: /* 服务器通知客户端 */
    { var ntf = new TestServerTimeN2C(); ntf.Read(r); RecvNotify<TestServerTimeN2C>.Raise(ntf); return; }
    case 65534: /* 服务端请求,客户端响应 */
    { var req = new TestHeartBeat2C(); req.Read(r); RecvRequest<TestHeartBeat2C,TestHeartBeatR2S>.Raise(req, new TestHeartBeatR2S()); return; }
    default: throw new Exception("Unsupported protocol id: " + id);
    }
} // HandleProtocAsClient(...)

static private Dictionary<String,Type> aliasBasic()
{
    Dictionary<String,Type> map = new Dictionary<String,Type>();
    map.Add("bool", typeof(System.Boolean));
    map.Add("double", typeof(System.Double));
    map.Add("float", typeof(System.Single));
    map.Add("int16", typeof(System.Int16));
    map.Add("int32", typeof(System.Int32));
    map.Add("int64", typeof(System.Int64));
    map.Add("int8", typeof(System.SByte));
    map.Add("map", typeof(Dictionary<,>));
    map.Add("string", typeof(System.String));
    map.Add("uint16", typeof(System.UInt16));
    map.Add("uint32", typeof(System.UInt32));
    map.Add("uint64", typeof(System.UInt64));
    map.Add("uint8", typeof(System.Byte));
    map.Add("vec", typeof(List<>));
    return map;
}

static private Dictionary<String,Type> aliasEnum()
{
    Dictionary<String,Type> map = new Dictionary<String,Type>();
    map.Add("Gender", typeof(Test.Abc.Gender));
    return map;
}

static private Dictionary<String,Type> aliasStruct()
{
    Dictionary<String,Type> map = new Dictionary<String,Type>();
    map.Add("Custom", typeof(Test.Abc.Custom));
    map.Add("Info", typeof(Test.Abc.Info));
    map.Add("InfoX", typeof(Test.Xyz.InfoX));
    map.Add("MemberEntry", typeof(Test.Db.MemberEntry));
    map.Add("TestAbcConflict", typeof(Test.Abc.Conflict));
    map.Add("TestBasic", typeof(Test.Abc.TestBasic));
    map.Add("TestDict", typeof(Test.Xyz.TestDict));
    map.Add("TestHeartBeat2C", typeof(Test.Protoc.TestHeartBeat2C));
    map.Add("TestHeartBeatR2S", typeof(Test.Protoc.TestHeartBeatR2S));
    map.Add("TestList", typeof(Test.Xyz.TestList));
    map.Add("TestNest", typeof(Test.Xyz.TestNest));
    map.Add("TestPointer", typeof(Test.Xyz.TestPointer));
    map.Add("TestRefer", typeof(Test.Xyz.TestRefer));
    map.Add("TestServerTimeN2C", typeof(Test.Protoc.TestServerTimeN2C));
    map.Add("TestUserLocationN2S", typeof(Test.Protoc.TestUserLocationN2S));
    map.Add("TestUserLogin2S", typeof(Test.Protoc.TestUserLogin2S));
    map.Add("TestUserLoginR2C", typeof(Test.Protoc.TestUserLoginR2C));
    map.Add("TestXyzConflict", typeof(Test.Xyz.Conflict));
    map.Add("protoc2C", typeof(Test.Protoc.Protoc2C));
    map.Add("protoc2S", typeof(Test.Protoc.Protoc2S));
    map.Add("root", typeof(Test.Xyz.ConfigRoot));
    return map;
}

static public UInt16 PeekProtocId(System.IO.BinaryReader r)
{
    long p = r.BaseStream.Position;
    UInt16 id = r.ReadUInt16();
    r.BaseStream.Position = p;
    return id;
}

} //class: InvarRuntime
} //namespace: Invar