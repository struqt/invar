/*===-----------------------------*  C#  *---------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/

namespace Test.Protoc {

using System.Collections.Generic;
using System.IO;
using System.Text;
using System;

/// 服务端请求,客户端响应.
public sealed class TestHeartBeatR2S
: Invar.BinaryDecode
, Invar.BinaryEncode
, Invar.JSONEncode
, Invar.XMLEncode
, Invar.ProtocResponse
{
    public const uint CRC32 = 0xA13D5F14;

    private UInt16                    protocError = 0; // [AutoAdd] Protocol error code.
    private UInt16                    protocId    = 65533; // [AutoAdd] ProtocolID.
    private UInt32                    protocCRC   = CRC32; // [AutoAdd] Protocol CRC32.
    private Protoc2S                  protoc2S    = null; // [AutoAdd] 客户端请求的公共数据.
    private Dictionary<String,String> hotfix      = null; // [AutoAdd] Hotfix.

    /// [AutoAdd] Protocol error code.
    [Invar.InvarRule("uint16", "")]
    public UInt16 GetProtocError() { return this.protocError; }

    /// [AutoAdd] ProtocolID.
    [Invar.InvarRule("uint16", "")]
    public UInt16 GetProtocId() { return this.protocId; }

    /// [AutoAdd] Protocol CRC32.
    [Invar.InvarRule("uint32", "")]
    public UInt32 GetProtocCRC() { return this.protocCRC; }

    /// [AutoAdd] 客户端请求的公共数据.
    [Invar.InvarRule("Test.Protoc.Protoc2S", "")]
    public Protoc2S GetProtoc2S() { return this.protoc2S; }

    /// [AutoAdd] Hotfix.
    [Invar.InvarRule("map<string,string>", "")]
    public Dictionary<String,String> GetHotfix() { return this.hotfix; }

    /// [AutoAdd] Protocol error code.
    [Invar.InvarRule("uint16", "")]
    public TestHeartBeatR2S SetProtocError(UInt16 value) { this.protocError = value; return this; }

    /// [AutoAdd] 客户端请求的公共数据.
    [Invar.InvarRule("Test.Protoc.Protoc2S", "")]
    public TestHeartBeatR2S SetProtoc2S(Protoc2S value) { this.protoc2S = value; return this; }

    /// [AutoAdd] Hotfix.
    [Invar.InvarRule("map<string,string>", "")]
    public TestHeartBeatR2S SetHotfix(Dictionary<String,String> value) { this.hotfix = value; return this; }

    public TestHeartBeatR2S Reuse()
    {
        this.protocError = 0;
        this.protocId    = 65533;
        this.protocCRC   = CRC32;
        if (this.protoc2S != null) { this.protoc2S.Reuse(); }
        if (this.hotfix != null) { this.hotfix.Clear(); }
        return this;
    } //TestHeartBeatR2S::Reuse()

    public TestHeartBeatR2S Copy(TestHeartBeatR2S from_)
    {
        if (null == from_ || this == from_) {
            return this;
        }
        this.protocError = from_.protocError;
        this.protocId = from_.protocId;
        this.protocCRC = from_.protocCRC;
        if (null == from_.protoc2S) {
            this.protoc2S = null;
        } else {
            if (null == this.protoc2S) { this.protoc2S = new Protoc2S(); }
            this.protoc2S.Copy(from_.protoc2S);
        }
        if (null == from_.hotfix) {
            this.hotfix = null;
        } else {
            if (null == this.hotfix) { this.hotfix = new Dictionary<String,String>(); }
            else { this.hotfix.Clear(); }
            foreach (var hotfixIter in from_.hotfix) {
                this.hotfix.Add(hotfixIter.Key, hotfixIter.Value);
            }
        }
        return this;
    } //TestHeartBeatR2S::Copy(...)

    public void Read(BinaryReader r)
    {
        this.protocError = r.ReadUInt16();
        if (this.protocError != 0) {
            throw new IOException("Protoc read error: The code is " + this.protocError, this.protocError);
        }
        this.protocId = r.ReadUInt16();
        this.protocCRC = r.ReadUInt32();
        if (CRC32 != this.protocCRC) { throw new IOException("Protoc read error: CRC32 is mismatched.", 499); }
        sbyte protoc2SExists = r.ReadSByte();
        if ((sbyte)0x01 == protoc2SExists) {
            if (this.protoc2S == null) { this.protoc2S = new Protoc2S(); }
            this.protoc2S.Read(r);
        }
        else if ((sbyte)0x00 == protoc2SExists) { this.protoc2S = null; }
        else { throw new IOException("Protoc read error: The value of 'protoc2SExists' is invalid.", 497); }
        sbyte hotfixExists = r.ReadSByte();
        if ((sbyte)0x01 == hotfixExists) {
            if (this.hotfix == null) { this.hotfix = new Dictionary<String,String>(); }
            UInt32 lenHotfix = r.ReadUInt32();
            for (UInt32 iHotfix = 0; iHotfix < lenHotfix; iHotfix++) {
                String k1 = Encoding.UTF8.GetString(r.ReadBytes(r.ReadInt32()));
                String v1 = Encoding.UTF8.GetString(r.ReadBytes(r.ReadInt32()));
                if (!this.hotfix.ContainsKey(k1)) {
                    this.hotfix.Add(k1, v1);
                } else {
                    this.hotfix[k1] = v1;
                }
            }
        }
        else if ((sbyte)0x00 == hotfixExists) { this.hotfix = null; }
        else { throw new IOException("Protoc read error: The value of 'hotfixExists' is invalid.", 498); }
    } //TestHeartBeatR2S::Read(...)

    public void Write(BinaryWriter w)
    {
        w.Write(this.protocError);
        if (this.protocError != 0) { return; }
        w.Write(this.protocId);
        w.Write(this.protocCRC);
        if (this.protoc2S != null) {
            w.Write((sbyte)0x01);
            this.protoc2S.Write(w);
        } else {
            w.Write((sbyte)0x00);
        }
        if (this.hotfix != null) {
            w.Write((sbyte)0x01);
            w.Write(this.hotfix.Count);
            foreach (KeyValuePair<String,String> hotfixIter in this.hotfix) {
                String k1 = hotfixIter.Key;
                byte[] k1Bytes = Encoding.UTF8.GetBytes(k1);
                w.Write(k1Bytes.Length);
                w.Write(k1Bytes);
                String v1 = hotfixIter.Value;
                byte[] v1Bytes = Encoding.UTF8.GetBytes(v1);
                w.Write(v1Bytes.Length);
                w.Write(v1Bytes);
            }
        } else {
            w.Write((sbyte)0x00);
        }
    } //TestHeartBeatR2S::Write(...)

    public override String ToString()
    {
        StringBuilder result = new StringBuilder();
        result.Append('{').Append(' ');
        result.Append(GetType().ToString());
        result.Append(',').Append(' ').Append("protocError").Append(':');
        result.Append(this.protocError.ToString());
        result.Append(',').Append(' ').Append("protocId").Append(':');
        result.Append(this.protocId.ToString());
        result.Append(',').Append(' ').Append("protocCRC").Append(':');
        result.Append(this.protocCRC.ToString());
        result.Append(',').Append(' ').Append("protoc2S").Append(':');
        if (this.protoc2S != null) { result.Append("<Protoc2S>"); }
        else { result.Append("null"); }
        result.Append(',').Append(' ').Append("hotfix").Append(':');
        if (this.hotfix != null) { result.Append("[" + this.hotfix.Count + "]"); }
        else { result.Append("null"); }
        result.Append(' ').Append('}');
        return result.ToString();
    } //TestHeartBeatR2S::ToString()

    public StringBuilder ToStringJSON()
    {
        StringBuilder code = new StringBuilder();
        this.WriteJSON(code);
        return code;
    }

    public void WriteJSON(StringBuilder s)
    {
        s.Append('\n').Append('{');
        string comma = null;
        s.Append('"').Append("protocError").Append('"').Append(':'); comma = ","; s.Append(this.protocError.ToString());
        if (!String.IsNullOrEmpty(comma)) { s.Append(comma); comma = null; }
        s.Append('"').Append("protocId").Append('"').Append(':'); comma = ","; s.Append(this.protocId.ToString());
        if (!String.IsNullOrEmpty(comma)) { s.Append(comma); comma = null; }
        s.Append('"').Append("protocCRC").Append('"').Append(':'); comma = ","; s.Append(this.protocCRC.ToString());
        bool protoc2SExists = (null != this.protoc2S);
        if (!String.IsNullOrEmpty(comma) && protoc2SExists) { s.Append(comma); comma = null; }
        if (protoc2SExists) {
            s.Append('"').Append("protoc2S").Append('"').Append(':'); comma = ","; this.protoc2S.WriteJSON(s);
        }
        bool hotfixExists = (null != this.hotfix && this.hotfix.Count > 0);
        if (!String.IsNullOrEmpty(comma) && hotfixExists) { s.Append(comma); comma = null; }
        if (hotfixExists) {
            int hotfixSize = (null == this.hotfix ? 0 : this.hotfix.Count);
            if (hotfixSize > 0) {
                s.Append('\n').Append('{');
                int hotfixIdx = 0;
                foreach (KeyValuePair<String,String> hotfixIter in this.hotfix) { /* map.for: this.hotfix */
                    ++hotfixIdx;
                    String k1 = hotfixIter.Key; /* nest.k */
                    s.Append('"'); s.Append('"').Append(k1.ToString()).Append('"'); s.Append('"').Append(':');
                    String v1 = hotfixIter.Value; /* nest.v */
                    s.Append('"').Append(v1.ToString()).Append('"');
                    if (hotfixIdx != hotfixSize) { s.Append(','); }
                }
                s.Append('}');
            } comma = ",";
        }
        s.Append('}').Append('\n');
    } //TestHeartBeatR2S::WriteJSON(...)

    public StringBuilder ToStringLua()
    {
        StringBuilder code = new StringBuilder();
        code.Append("-- TestHeartBeatR2S.CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" --").Append('\n');
        code.Append("local table=");
        this.WriteLua(code); code.Append(';');
        return code;
    }

    public void WriteLua(StringBuilder s)
    {
        s.Append('\n').Append('{');
        string comma = null;
        s.Append("protocError").Append('='); comma = ","; s.Append(this.protocError.ToString());
        if (!String.IsNullOrEmpty(comma)) { s.Append(comma); comma = null; }
        s.Append("protocId").Append('='); comma = ","; s.Append(this.protocId.ToString());
        if (!String.IsNullOrEmpty(comma)) { s.Append(comma); comma = null; }
        s.Append("protocCRC").Append('='); comma = ","; s.Append(this.protocCRC.ToString());
        bool protoc2SExists = (null != this.protoc2S);
        if (!String.IsNullOrEmpty(comma) && protoc2SExists) { s.Append(comma); comma = null; }
        if (protoc2SExists) {
            s.Append("protoc2S").Append('='); comma = ","; this.protoc2S.WriteLua(s);
        }
        bool hotfixExists = (null != this.hotfix && this.hotfix.Count > 0);
        if (!String.IsNullOrEmpty(comma) && hotfixExists) { s.Append(comma); comma = null; }
        if (hotfixExists) {
            int hotfixSize = (null == this.hotfix ? 0 : this.hotfix.Count);
            if (hotfixSize > 0) {
                s.Append('\n').Append('{');
                int hotfixIdx = 0;
                foreach (KeyValuePair<String,String> hotfixIter in this.hotfix) { /* map.for: this.hotfix */
                    ++hotfixIdx;
                    String k1 = hotfixIter.Key; /* nest.k */
                    s.Append('"').Append(k1.ToString()).Append('"'); s.Append('=');
                    String v1 = hotfixIter.Value; /* nest.v */
                    s.Append('"').Append(v1.ToString()).Append('"');
                    if (hotfixIdx != hotfixSize) { s.Append(','); }
                    s.Append('}');
                }
            } comma = ",";
        }
        s.Append('}').Append('\n');
    }

    public StringBuilder ToStringPHP()
    {
        StringBuilder code = new StringBuilder();
        code.Append("<?php ").Append("/* TestHeartBeatR2S.CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" */").Append('\n');
        code.Append('\n').Append("return ");
        this.WritePHP(code); code.Append(';').Append('\n');
        return code;
    }

    public void WritePHP(StringBuilder s)
    {
        s.Append("array").Append('(').Append('\n');
        string comma = null;
        s.Append('\'').Append("protocError").Append('\'').Append("=>"); comma = ","; s.Append(this.protocError.ToString());
        if (!String.IsNullOrEmpty(comma)) { s.Append(comma).Append('\n'); comma = null; }
        s.Append('\'').Append("protocId").Append('\'').Append("=>"); comma = ","; s.Append(this.protocId.ToString());
        if (!String.IsNullOrEmpty(comma)) { s.Append(comma).Append('\n'); comma = null; }
        s.Append('\'').Append("protocCRC").Append('\'').Append("=>"); comma = ","; s.Append(this.protocCRC.ToString());
        bool protoc2SExists = (null != this.protoc2S);
        if (!String.IsNullOrEmpty(comma) && protoc2SExists) { s.Append(comma).Append('\n'); comma = null; }
        if (protoc2SExists) {
            s.Append('\'').Append("protoc2S").Append('\'').Append("=>"); comma = ","; this.protoc2S.WritePHP(s);
        }
        bool hotfixExists = (null != this.hotfix && this.hotfix.Count > 0);
        if (!String.IsNullOrEmpty(comma) && hotfixExists) { s.Append(comma).Append('\n'); comma = null; }
        if (hotfixExists) {
            int hotfixSize = (null == this.hotfix ? 0 : this.hotfix.Count);
            if (hotfixSize > 0) {
                s.Append("array").Append('(').Append('\n');
                int hotfixIdx = 0;
                foreach (KeyValuePair<String,String> hotfixIter in this.hotfix) { /* map.for: this.hotfix */
                    ++hotfixIdx;
                    String k1 = hotfixIter.Key; /* nest.k */
                    s.Append('\'').Append(k1.ToString()).Append('\''); s.Append("=>");
                    String v1 = hotfixIter.Value; /* nest.v */
                    s.Append('\'').Append(v1.ToString()).Append('\'');
                    if (hotfixIdx != hotfixSize) { s.Append(','); s.Append('\n'); }
                }
                s.Append("/* map size: ").Append(this.hotfix.Count).Append(" */").Append(')');
            } comma = ",";
        }
        s.Append("/* ").Append(GetType().ToString()).Append(" */");
        s.Append(')');
    }

    public StringBuilder ToStringXML()
    {
        StringBuilder code = new StringBuilder();
        code.Append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        code.Append('\n').Append("<!-- ").Append("TestHeartBeatR2S").Append(".CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" -->");
        this.WriteXML(code, "TestHeartBeatR2S");
        return code;
    }

    public void WriteXML(StringBuilder s, String name)
    {
        StringBuilder attrs = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.Append(' ').Append("protocError").Append('=').Append('"').Append(this.protocError.ToString()).Append('"');
        attrs.Append(' ').Append("protocId").Append('=').Append('"').Append(this.protocId.ToString()).Append('"');
        attrs.Append(' ').Append("protocCRC").Append('=').Append('"').Append(this.protocCRC.ToString()).Append('"');
        if (this.protoc2S != null) {
            this.protoc2S.WriteXML(nodes, "protoc2S");
        }
        if (this.hotfix != null && this.hotfix.Count > 0) {
            nodes.Append('\n').Append('<').Append("hotfix").Append('>');
            foreach (KeyValuePair<String,String> hotfixIter in this.hotfix) {
                nodes.Append('\n');
                String k1 = hotfixIter.Key;
                nodes.Append('<').Append("k1").Append(' ').Append("value").Append('=').Append('"');
                nodes.Append(k1);
                nodes.Append('"').Append('/').Append('>');
                String v1 = hotfixIter.Value;
                nodes.Append('<').Append("v1").Append(' ').Append("value").Append('=').Append('"');
                nodes.Append(v1);
                nodes.Append('"').Append('/').Append('>');
            }
            nodes.Append('<').Append('/').Append("hotfix").Append('>');
        }
        s.Append('\n').Append('<').Append(name).Append(attrs);
        if (nodes.Length == 0) {
            s.Append('/').Append('>');
        } else {
            s.Append('>').Append(nodes);
            s.Append('<').Append('/').Append(name).Append('>');
        }
    } //TestHeartBeatR2S::WriteXML(...)

} /* class: TestHeartBeatR2S */
/*
1@test.protoc.TestHeartBeatR2S/uint16/uint16/uint32/test.protoc.Protoc2S/map-string-string
+@test.protoc.Protoc2S/string/map-string-string
*/
} //namespace: Test.Protoc