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

/// 服务端响应的公共数据.
public sealed class Protoc2C
: Invar.BinaryDecode
, Invar.BinaryEncode
, Invar.JSONEncode
, Invar.XMLEncode
{
    public const uint CRC32 = 0xC716EAFC;

    private Dictionary<String,String> hotfix = null; // [AutoAdd] Hotfix.

    /// [AutoAdd] Hotfix.
    [Invar.InvarRule("map<string,string>", "0")]
    public Dictionary<String,String> GetHotfix() { return this.hotfix; }

    /// [AutoAdd] Hotfix.
    [Invar.InvarRule("map<string,string>", "0")]
    public Protoc2C SetHotfix(Dictionary<String,String> value) { this.hotfix = value; return this; }

    public Protoc2C Reuse()
    {
        if (this.hotfix != null) { this.hotfix.Clear(); }
        return this;
    } //Protoc2C::Reuse()

    public Protoc2C Copy(Protoc2C from_)
    {
        if (null == from_ || this == from_) {
            return this;
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
    } //Protoc2C::Copy(...)

    public void Read(BinaryReader r)
    {
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
    } //Protoc2C::Read(...)

    public void Write(BinaryWriter w)
    {
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
    } //Protoc2C::Write(...)

    public override String ToString()
    {
        StringBuilder result = new StringBuilder();
        result.Append('{').Append(' ');
        result.Append(GetType().ToString());
        result.Append(',').Append(' ').Append("hotfix").Append(':');
        if (this.hotfix != null) { result.Append("[" + this.hotfix.Count + "]"); }
        else { result.Append("null"); }
        result.Append(' ').Append('}');
        return result.ToString();
    } //Protoc2C::ToString()

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
        bool hotfixExists = (null != this.hotfix && this.hotfix.Count > 0);
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
    } //Protoc2C::WriteJSON(...)

    public StringBuilder ToStringLua()
    {
        StringBuilder code = new StringBuilder();
        code.Append("-- Protoc2C.CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" --").Append('\n');
        code.Append("local table=");
        this.WriteLua(code); code.Append(';');
        return code;
    }

    public void WriteLua(StringBuilder s)
    {
        s.Append('\n').Append('{');
        string comma = null;
        bool hotfixExists = (null != this.hotfix && this.hotfix.Count > 0);
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
        code.Append("<?php ").Append("/* Protoc2C.CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" */").Append('\n');
        code.Append('\n').Append("return ");
        this.WritePHP(code); code.Append(';').Append('\n');
        return code;
    }

    public void WritePHP(StringBuilder s)
    {
        s.Append("array").Append('(').Append('\n');
        string comma = null;
        bool hotfixExists = (null != this.hotfix && this.hotfix.Count > 0);
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
        code.Append('\n').Append("<!-- ").Append("Protoc2C").Append(".CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" -->");
        this.WriteXML(code, "Protoc2C");
        return code;
    }

    public void WriteXML(StringBuilder s, String name)
    {
        StringBuilder attrs = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
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
    } //Protoc2C::WriteXML(...)

} /* class: Protoc2C */
/*
0@test.protoc.Protoc2C/map-string-string
*/
} //namespace: Test.Protoc