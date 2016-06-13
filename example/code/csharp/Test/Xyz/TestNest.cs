/*===-----------------------------*  C#  *---------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/

namespace Test.Xyz {

using System.Collections.Generic;
using System.IO;
using System.Text;
using System;
using Test.Abc;

/// 测试泛型相互嵌套.
public sealed class TestNest
: Invar.BinaryDecode
, Invar.BinaryEncode
, Invar.JSONEncode
, Invar.XMLEncode
{
    public const uint CRC32 = 0xEE83F94A;

    private List<Dictionary<String,Custom>>       listDict = new List<Dictionary<String,Custom>>();
    private Dictionary<List<String>,List<Custom>> dictList = new Dictionary<List<String>,List<Custom>>();
    private List<List<List<List<List<Custom>>>>>  list5d   = new List<List<List<List<List<Custom>>>>>(); // 五维列表.
    private Dictionary<String,String>             hotfix   = null; // [AutoAdd] Hotfix.

    /// .
    [Invar.InvarRule("vec<map<string,Test.Abc.Custom>>", "0")]
    public List<Dictionary<String,Custom>> GetListDict() { return this.listDict; }

    /// .
    [Invar.InvarRule("map<vec<string>,vec<Test.Abc.Custom>>", "1")]
    public Dictionary<List<String>,List<Custom>> GetDictList() { return this.dictList; }

    /// 五维列表.
    [Invar.InvarRule("vec<vec<vec<vec<vec<Test.Abc.Custom>>>>>", "2")]
    public List<List<List<List<List<Custom>>>>> GetList5d() { return this.list5d; }

    /// [AutoAdd] Hotfix.
    [Invar.InvarRule("map<string,string>", "3")]
    public Dictionary<String,String> GetHotfix() { return this.hotfix; }

    /// [AutoAdd] Hotfix.
    [Invar.InvarRule("map<string,string>", "3")]
    public TestNest SetHotfix(Dictionary<String,String> value) { this.hotfix = value; return this; }

    public TestNest Reuse()
    {
        this.listDict.Clear();
        this.dictList.Clear();
        this.list5d.Clear();
        if (this.hotfix != null) { this.hotfix.Clear(); }
        return this;
    } //TestNest::Reuse()

    public TestNest Copy(TestNest from_)
    {
        if (null == from_ || this == from_) {
            return this;
        }
        this.listDict.Clear();
        this.listDict.AddRange(from_.listDict);
        this.dictList.Clear();
        foreach (var dictListIter in from_.dictList) {
            this.dictList.Add(dictListIter.Key, dictListIter.Value);
        }
        this.list5d.Clear();
        this.list5d.AddRange(from_.list5d);
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
    } //TestNest::Copy(...)

    public void Read(BinaryReader r)
    {
        UInt32 lenListDict = r.ReadUInt32();
        for (UInt32 iListDict = 0; iListDict < lenListDict; iListDict++) {
            Dictionary<String,Custom> n1 = new Dictionary<String,Custom>(); //read.vec.head
            UInt32 lenN1 = r.ReadUInt32();
            for (UInt32 iN1 = 0; iN1 < lenN1; iN1++) {
                String k2 = Encoding.UTF8.GetString(r.ReadBytes(r.ReadInt32()));
                Custom v2 = new Custom();
                v2.Read(r);
                if (!n1.ContainsKey(k2)) {
                    n1.Add(k2, v2);
                } else {
                    n1[k2] = v2;
                }
            }
            this.listDict.Add(n1);
        }
        UInt32 lenDictList = r.ReadUInt32();
        for (UInt32 iDictList = 0; iDictList < lenDictList; iDictList++) {
            List<String> k1 = new List<String>(); //read.map.head
            UInt32 lenK1 = r.ReadUInt32();
            for (UInt32 iK1 = 0; iK1 < lenK1; iK1++) {
                String n2 = Encoding.UTF8.GetString(r.ReadBytes(r.ReadInt32()));
                k1.Add(n2);
            }
            List<Custom> v1 = new List<Custom>(); //read.map.head
            UInt32 lenV1 = r.ReadUInt32();
            for (UInt32 iV1 = 0; iV1 < lenV1; iV1++) {
                Custom n2 = new Custom();
                n2.Read(r);
                v1.Add(n2);
            }
            if (!this.dictList.ContainsKey(k1)) {
                this.dictList.Add(k1, v1);
            } else {
                this.dictList[k1] = v1;
            }
        }
        UInt32 lenList5d = r.ReadUInt32();
        for (UInt32 iList5d = 0; iList5d < lenList5d; iList5d++) {
            List<List<List<List<Custom>>>> n1 = new List<List<List<List<Custom>>>>(); //read.vec.head
            UInt32 lenN1 = r.ReadUInt32();
            for (UInt32 iN1 = 0; iN1 < lenN1; iN1++) {
                List<List<List<Custom>>> n2 = new List<List<List<Custom>>>(); //read.vec.head
                UInt32 lenN2 = r.ReadUInt32();
                for (UInt32 iN2 = 0; iN2 < lenN2; iN2++) {
                    List<List<Custom>> n3 = new List<List<Custom>>(); //read.vec.head
                    UInt32 lenN3 = r.ReadUInt32();
                    for (UInt32 iN3 = 0; iN3 < lenN3; iN3++) {
                        List<Custom> n4 = new List<Custom>(); //read.vec.head
                        UInt32 lenN4 = r.ReadUInt32();
                        for (UInt32 iN4 = 0; iN4 < lenN4; iN4++) {
                            Custom n5 = new Custom();
                            n5.Read(r);
                            n4.Add(n5);
                        }
                        n3.Add(n4);
                    }
                    n2.Add(n3);
                }
                n1.Add(n2);
            }
            this.list5d.Add(n1);
        }
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
    } //TestNest::Read(...)

    public void Write(BinaryWriter w)
    {
        w.Write(this.listDict.Count);
        foreach (Dictionary<String,Custom> n1 in this.listDict) {
            w.Write(n1.Count);
            foreach (KeyValuePair<String,Custom> n1Iter in n1) {
                String k2 = n1Iter.Key;
                byte[] k2Bytes = Encoding.UTF8.GetBytes(k2);
                w.Write(k2Bytes.Length);
                w.Write(k2Bytes);
                Custom v2 = n1Iter.Value;
                v2.Write(w);
            }
        }
        w.Write(this.dictList.Count);
        foreach (KeyValuePair<List<String>,List<Custom>> dictListIter in this.dictList) {
            List<String> k1 = dictListIter.Key;
            w.Write(k1.Count);
            foreach (String n2 in k1) {
                byte[] n2Bytes = Encoding.UTF8.GetBytes(n2);
                w.Write(n2Bytes.Length);
                w.Write(n2Bytes);
            }
            List<Custom> v1 = dictListIter.Value;
            w.Write(v1.Count);
            foreach (Custom n2 in v1) {
                n2.Write(w);
            }
        }
        w.Write(this.list5d.Count);
        foreach (List<List<List<List<Custom>>>> n1 in this.list5d) {
            w.Write(n1.Count);
            foreach (List<List<List<Custom>>> n2 in n1) {
                w.Write(n2.Count);
                foreach (List<List<Custom>> n3 in n2) {
                    w.Write(n3.Count);
                    foreach (List<Custom> n4 in n3) {
                        w.Write(n4.Count);
                        foreach (Custom n5 in n4) {
                            n5.Write(w);
                        }
                    }
                }
            }
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
    } //TestNest::Write(...)

    public override String ToString()
    {
        StringBuilder result = new StringBuilder();
        result.Append('{').Append(' ');
        result.Append(GetType().ToString());
        result.Append(',').Append(' ').Append("listDict").Append(':');
        result.Append("(" + this.listDict.Count + ")");
        result.Append(',').Append(' ').Append("dictList").Append(':');
        result.Append("[" + this.dictList.Count + "]");
        result.Append(',').Append(' ').Append("list5d").Append(':');
        result.Append("(" + this.list5d.Count + ")");
        result.Append(',').Append(' ').Append("hotfix").Append(':');
        if (this.hotfix != null) { result.Append("[" + this.hotfix.Count + "]"); }
        else { result.Append("null"); }
        result.Append(' ').Append('}');
        return result.ToString();
    } //TestNest::ToString()

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
        bool listDictExists = (null != this.listDict && this.listDict.Count > 0);
        if (listDictExists) { s.Append('"').Append("listDict").Append('"').Append(':'); comma = ","; }
        int listDictSize = (null == this.listDict ? 0 : this.listDict.Count);
        if (listDictSize > 0) {
            s.Append('\n').Append('[');
            int listDictIdx = 0;
            foreach (Dictionary<String,Custom> n1 in this.listDict) { /* vec.for: this.listDict */
                ++listDictIdx;
                int n1Size = (null == n1 ? 0 : n1.Count);
                if (n1Size > 0) {
                    s.Append('\n').Append('{');
                    int n1Idx = 0;
                    foreach (KeyValuePair<String,Custom> n1Iter in n1) { /* map.for: n1 */
                        ++n1Idx;
                        String k2 = n1Iter.Key; /* nest.k */
                        s.Append('"'); s.Append('"').Append(k2.ToString()).Append('"'); s.Append('"').Append(':');
                        Custom v2 = n1Iter.Value; /* nest.v */
                        v2.WriteJSON(s);
                        if (n1Idx != n1Size) { s.Append(','); }
                    }
                    s.Append('}');
                }
                if (listDictIdx != listDictSize) { s.Append(','); }
            }
            s.Append(']');
        }
        bool dictListExists = (null != this.dictList && this.dictList.Count > 0);
        if (!String.IsNullOrEmpty(comma) && dictListExists) { s.Append(comma); comma = null; }
        if (dictListExists) { s.Append('"').Append("dictList").Append('"').Append(':'); comma = ","; }
        int dictListSize = (null == this.dictList ? 0 : this.dictList.Count);
        if (dictListSize > 0) {
            s.Append('\n').Append('{');
            int dictListIdx = 0;
            foreach (KeyValuePair<List<String>,List<Custom>> dictListIter in this.dictList) { /* map.for: this.dictList */
                ++dictListIdx;
                List<String> k1 = dictListIter.Key;
                int k1Size = (null == k1 ? 0 : k1.Count);
                if (k1Size > 0) {
                    s.Append('\n').Append('[');
                    int k1Idx = 0;
                    foreach (String n2 in k1) { /* vec.for: k1 */
                        ++k1Idx;
                        s.Append('"').Append(n2.ToString()).Append('"');
                        if (k1Idx != k1Size) { s.Append(','); }
                    }
                    s.Append(']');
                }
                List<Custom> v1 = dictListIter.Value;
                int v1Size = (null == v1 ? 0 : v1.Count);
                if (v1Size > 0) {
                    s.Append('\n').Append('[');
                    int v1Idx = 0;
                    foreach (Custom n2 in v1) { /* vec.for: v1 */
                        ++v1Idx;
                        n2.WriteJSON(s);
                        if (v1Idx != v1Size) { s.Append(','); }
                    }
                    s.Append(']');
                }
                if (dictListIdx != dictListSize) { s.Append(','); }
            }
            s.Append('}');
        }
        bool list5dExists = (null != this.list5d && this.list5d.Count > 0);
        if (!String.IsNullOrEmpty(comma) && list5dExists) { s.Append(comma); comma = null; }
        if (list5dExists) { s.Append('"').Append("list5d").Append('"').Append(':'); comma = ","; }
        int list5dSize = (null == this.list5d ? 0 : this.list5d.Count);
        if (list5dSize > 0) {
            s.Append('\n').Append('[');
            int list5dIdx = 0;
            foreach (List<List<List<List<Custom>>>> n1 in this.list5d) { /* vec.for: this.list5d */
                ++list5dIdx;
                int n1Size = (null == n1 ? 0 : n1.Count);
                if (n1Size > 0) {
                    s.Append('\n').Append('[');
                    int n1Idx = 0;
                    foreach (List<List<List<Custom>>> n2 in n1) { /* vec.for: n1 */
                        ++n1Idx;
                        int n2Size = (null == n2 ? 0 : n2.Count);
                        if (n2Size > 0) {
                            s.Append('\n').Append('[');
                            int n2Idx = 0;
                            foreach (List<List<Custom>> n3 in n2) { /* vec.for: n2 */
                                ++n2Idx;
                                int n3Size = (null == n3 ? 0 : n3.Count);
                                if (n3Size > 0) {
                                    s.Append('\n').Append('[');
                                    int n3Idx = 0;
                                    foreach (List<Custom> n4 in n3) { /* vec.for: n3 */
                                        ++n3Idx;
                                        int n4Size = (null == n4 ? 0 : n4.Count);
                                        if (n4Size > 0) {
                                            s.Append('\n').Append('[');
                                            int n4Idx = 0;
                                            foreach (Custom n5 in n4) { /* vec.for: n4 */
                                                ++n4Idx;
                                                n5.WriteJSON(s);
                                                if (n4Idx != n4Size) { s.Append(','); }
                                            }
                                            s.Append(']');
                                        }
                                        if (n3Idx != n3Size) { s.Append(','); }
                                    }
                                    s.Append(']');
                                }
                                if (n2Idx != n2Size) { s.Append(','); }
                            }
                            s.Append(']');
                        }
                        if (n1Idx != n1Size) { s.Append(','); }
                    }
                    s.Append(']');
                }
                if (list5dIdx != list5dSize) { s.Append(','); }
            }
            s.Append(']');
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
    } //TestNest::WriteJSON(...)

    public StringBuilder ToStringLua()
    {
        StringBuilder code = new StringBuilder();
        code.Append("-- TestNest.CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" --").Append('\n');
        code.Append("local table=");
        this.WriteLua(code); code.Append(';');
        return code;
    }

    public void WriteLua(StringBuilder s)
    {
        s.Append('\n').Append('{');
        string comma = null;
        bool listDictExists = (null != this.listDict && this.listDict.Count > 0);
        if (listDictExists) { s.Append("listDict").Append('='); comma = ","; }
        int listDictSize = (null == this.listDict ? 0 : this.listDict.Count);
        if (listDictSize > 0) {
            s.Append('\n').Append('{');
            int listDictIdx = 0;
            foreach (Dictionary<String,Custom> n1 in this.listDict) { /* vec.for: this.listDict */
                ++listDictIdx;
                int n1Size = (null == n1 ? 0 : n1.Count);
                if (n1Size > 0) {
                    s.Append('\n').Append('{');
                    int n1Idx = 0;
                    foreach (KeyValuePair<String,Custom> n1Iter in n1) { /* map.for: n1 */
                        ++n1Idx;
                        String k2 = n1Iter.Key; /* nest.k */
                        s.Append('"').Append(k2.ToString()).Append('"'); s.Append('=');
                        Custom v2 = n1Iter.Value; /* nest.v */
                        v2.WriteLua(s);
                        if (n1Idx != n1Size) { s.Append(','); }
                        s.Append('}');
                    }
                }
                if (listDictIdx != listDictSize) { s.Append(','); }
                s.Append('}');
            }
        }
        bool dictListExists = (null != this.dictList && this.dictList.Count > 0);
        if (!String.IsNullOrEmpty(comma) && dictListExists) { s.Append(comma); comma = null; }
        if (dictListExists) { s.Append("dictList").Append('='); comma = ","; }
        int dictListSize = (null == this.dictList ? 0 : this.dictList.Count);
        if (dictListSize > 0) {
            s.Append('\n').Append('{');
            int dictListIdx = 0;
            foreach (KeyValuePair<List<String>,List<Custom>> dictListIter in this.dictList) { /* map.for: this.dictList */
                ++dictListIdx;
                List<String> k1 = dictListIter.Key;
                int k1Size = (null == k1 ? 0 : k1.Count);
                if (k1Size > 0) {
                    s.Append('\n').Append('{');
                    int k1Idx = 0;
                    foreach (String n2 in k1) { /* vec.for: k1 */
                        ++k1Idx;
                        s.Append('"').Append(n2.ToString()).Append('"');
                        if (k1Idx != k1Size) { s.Append(','); }
                        s.Append('}');
                    }
                }
                List<Custom> v1 = dictListIter.Value;
                int v1Size = (null == v1 ? 0 : v1.Count);
                if (v1Size > 0) {
                    s.Append('\n').Append('{');
                    int v1Idx = 0;
                    foreach (Custom n2 in v1) { /* vec.for: v1 */
                        ++v1Idx;
                        n2.WriteLua(s);
                        if (v1Idx != v1Size) { s.Append(','); }
                        s.Append('}');
                    }
                }
                if (dictListIdx != dictListSize) { s.Append(','); }
                s.Append('}');
            }
        }
        bool list5dExists = (null != this.list5d && this.list5d.Count > 0);
        if (!String.IsNullOrEmpty(comma) && list5dExists) { s.Append(comma); comma = null; }
        if (list5dExists) { s.Append("list5d").Append('='); comma = ","; }
        int list5dSize = (null == this.list5d ? 0 : this.list5d.Count);
        if (list5dSize > 0) {
            s.Append('\n').Append('{');
            int list5dIdx = 0;
            foreach (List<List<List<List<Custom>>>> n1 in this.list5d) { /* vec.for: this.list5d */
                ++list5dIdx;
                int n1Size = (null == n1 ? 0 : n1.Count);
                if (n1Size > 0) {
                    s.Append('\n').Append('{');
                    int n1Idx = 0;
                    foreach (List<List<List<Custom>>> n2 in n1) { /* vec.for: n1 */
                        ++n1Idx;
                        int n2Size = (null == n2 ? 0 : n2.Count);
                        if (n2Size > 0) {
                            s.Append('\n').Append('{');
                            int n2Idx = 0;
                            foreach (List<List<Custom>> n3 in n2) { /* vec.for: n2 */
                                ++n2Idx;
                                int n3Size = (null == n3 ? 0 : n3.Count);
                                if (n3Size > 0) {
                                    s.Append('\n').Append('{');
                                    int n3Idx = 0;
                                    foreach (List<Custom> n4 in n3) { /* vec.for: n3 */
                                        ++n3Idx;
                                        int n4Size = (null == n4 ? 0 : n4.Count);
                                        if (n4Size > 0) {
                                            s.Append('\n').Append('{');
                                            int n4Idx = 0;
                                            foreach (Custom n5 in n4) { /* vec.for: n4 */
                                                ++n4Idx;
                                                n5.WriteLua(s);
                                                if (n4Idx != n4Size) { s.Append(','); }
                                                s.Append('}');
                                            }
                                        }
                                        if (n3Idx != n3Size) { s.Append(','); }
                                        s.Append('}');
                                    }
                                }
                                if (n2Idx != n2Size) { s.Append(','); }
                                s.Append('}');
                            }
                        }
                        if (n1Idx != n1Size) { s.Append(','); }
                        s.Append('}');
                    }
                }
                if (list5dIdx != list5dSize) { s.Append(','); }
                s.Append('}');
            }
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
        code.Append("<?php ").Append("/* TestNest.CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" */").Append('\n');
        code.Append('\n').Append("return ");
        this.WritePHP(code); code.Append(';').Append('\n');
        return code;
    }

    public void WritePHP(StringBuilder s)
    {
        s.Append("array").Append('(').Append('\n');
        string comma = null;
        bool listDictExists = (null != this.listDict && this.listDict.Count > 0);
        if (listDictExists) { s.Append('\'').Append("listDict").Append('\'').Append("=>"); comma = ","; }
        int listDictSize = (null == this.listDict ? 0 : this.listDict.Count);
        if (listDictSize > 0) {
            s.Append("array").Append('(').Append('\n');
            int listDictIdx = 0;
            foreach (Dictionary<String,Custom> n1 in this.listDict) { /* vec.for: this.listDict */
                ++listDictIdx;
                int n1Size = (null == n1 ? 0 : n1.Count);
                if (n1Size > 0) {
                    s.Append("array").Append('(').Append('\n');
                    int n1Idx = 0;
                    foreach (KeyValuePair<String,Custom> n1Iter in n1) { /* map.for: n1 */
                        ++n1Idx;
                        String k2 = n1Iter.Key; /* nest.k */
                        s.Append('\'').Append(k2.ToString()).Append('\''); s.Append("=>");
                        Custom v2 = n1Iter.Value; /* nest.v */
                        v2.WritePHP(s);
                        if (n1Idx != n1Size) { s.Append(','); s.Append('\n'); }
                    }
                    s.Append("/* map size: ").Append(n1.Count).Append(" */").Append(')');
                }
                if (listDictIdx != listDictSize) { s.Append(',').Append('\n'); }
            }
            s.Append("/* vec size: ").Append(this.listDict.Count).Append(" */").Append(')');
        }
        bool dictListExists = (null != this.dictList && this.dictList.Count > 0);
        if (!String.IsNullOrEmpty(comma) && dictListExists) { s.Append(comma).Append('\n'); comma = null; }
        if (dictListExists) { s.Append('\'').Append("dictList").Append('\'').Append("=>"); comma = ","; }
        int dictListSize = (null == this.dictList ? 0 : this.dictList.Count);
        if (dictListSize > 0) {
            s.Append("array").Append('(').Append('\n');
            int dictListIdx = 0;
            foreach (KeyValuePair<List<String>,List<Custom>> dictListIter in this.dictList) { /* map.for: this.dictList */
                ++dictListIdx;
                List<String> k1 = dictListIter.Key; /* map.head.k */
                int k1Size = (null == k1 ? 0 : k1.Count);
                if (k1Size > 0) {
                    s.Append("array").Append('(').Append('\n');
                    int k1Idx = 0;
                    foreach (String n2 in k1) { /* vec.for: k1 */
                        ++k1Idx;
                        s.Append('\'').Append(n2.ToString()).Append('\'');
                        if (k1Idx != k1Size) { s.Append(',').Append('\n'); }
                    }
                    s.Append("/* vec size: ").Append(k1.Count).Append(" */").Append(')');
                }
                List<Custom> v1 = dictListIter.Value; /* map.head.k */
                int v1Size = (null == v1 ? 0 : v1.Count);
                if (v1Size > 0) {
                    s.Append("array").Append('(').Append('\n');
                    int v1Idx = 0;
                    foreach (Custom n2 in v1) { /* vec.for: v1 */
                        ++v1Idx;
                        n2.WritePHP(s);
                        if (v1Idx != v1Size) { s.Append(',').Append('\n'); }
                    }
                    s.Append("/* vec size: ").Append(v1.Count).Append(" */").Append(')');
                }
                if (dictListIdx != dictListSize) { s.Append(','); s.Append('\n'); }
            }
            s.Append("/* map size: ").Append(this.dictList.Count).Append(" */").Append(')');
        }
        bool list5dExists = (null != this.list5d && this.list5d.Count > 0);
        if (!String.IsNullOrEmpty(comma) && list5dExists) { s.Append(comma).Append('\n'); comma = null; }
        if (list5dExists) { s.Append('\'').Append("list5d").Append('\'').Append("=>"); comma = ","; }
        int list5dSize = (null == this.list5d ? 0 : this.list5d.Count);
        if (list5dSize > 0) {
            s.Append("array").Append('(').Append('\n');
            int list5dIdx = 0;
            foreach (List<List<List<List<Custom>>>> n1 in this.list5d) { /* vec.for: this.list5d */
                ++list5dIdx;
                int n1Size = (null == n1 ? 0 : n1.Count);
                if (n1Size > 0) {
                    s.Append("array").Append('(').Append('\n');
                    int n1Idx = 0;
                    foreach (List<List<List<Custom>>> n2 in n1) { /* vec.for: n1 */
                        ++n1Idx;
                        int n2Size = (null == n2 ? 0 : n2.Count);
                        if (n2Size > 0) {
                            s.Append("array").Append('(').Append('\n');
                            int n2Idx = 0;
                            foreach (List<List<Custom>> n3 in n2) { /* vec.for: n2 */
                                ++n2Idx;
                                int n3Size = (null == n3 ? 0 : n3.Count);
                                if (n3Size > 0) {
                                    s.Append("array").Append('(').Append('\n');
                                    int n3Idx = 0;
                                    foreach (List<Custom> n4 in n3) { /* vec.for: n3 */
                                        ++n3Idx;
                                        int n4Size = (null == n4 ? 0 : n4.Count);
                                        if (n4Size > 0) {
                                            s.Append("array").Append('(').Append('\n');
                                            int n4Idx = 0;
                                            foreach (Custom n5 in n4) { /* vec.for: n4 */
                                                ++n4Idx;
                                                n5.WritePHP(s);
                                                if (n4Idx != n4Size) { s.Append(',').Append('\n'); }
                                            }
                                            s.Append("/* vec size: ").Append(n4.Count).Append(" */").Append(')');
                                        }
                                        if (n3Idx != n3Size) { s.Append(',').Append('\n'); }
                                    }
                                    s.Append("/* vec size: ").Append(n3.Count).Append(" */").Append(')');
                                }
                                if (n2Idx != n2Size) { s.Append(',').Append('\n'); }
                            }
                            s.Append("/* vec size: ").Append(n2.Count).Append(" */").Append(')');
                        }
                        if (n1Idx != n1Size) { s.Append(',').Append('\n'); }
                    }
                    s.Append("/* vec size: ").Append(n1.Count).Append(" */").Append(')');
                }
                if (list5dIdx != list5dSize) { s.Append(',').Append('\n'); }
            }
            s.Append("/* vec size: ").Append(this.list5d.Count).Append(" */").Append(')');
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
        code.Append('\n').Append("<!-- ").Append("TestNest").Append(".CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" -->");
        this.WriteXML(code, "TestNest");
        return code;
    }

    public void WriteXML(StringBuilder s, String name)
    {
        StringBuilder attrs = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        if (this.listDict.Count > 0) {
            nodes.Append('\n').Append('<').Append("listDict").Append('>');
            foreach (Dictionary<String,Custom> n1 in this.listDict) {
                nodes.Append('\n').Append('<').Append("n1").Append('>');
                foreach (KeyValuePair<String,Custom> n1Iter in n1) {
                    nodes.Append('\n');
                    String k2 = n1Iter.Key;
                    nodes.Append('<').Append("k2").Append(' ').Append("value").Append('=').Append('"');
                    nodes.Append(k2);
                    nodes.Append('"').Append('/').Append('>');
                    Custom v2 = n1Iter.Value;
                    v2.WriteXML(nodes, "v2");
                }
                nodes.Append('<').Append('/').Append("n1").Append('>');
            }
            nodes.Append('<').Append('/').Append("listDict").Append('>');
        }
        if (this.dictList.Count > 0) {
            nodes.Append('\n').Append('<').Append("dictList").Append('>');
            foreach (KeyValuePair<List<String>,List<Custom>> dictListIter in this.dictList) {
                nodes.Append('\n');
                List<String> k1 = dictListIter.Key;
                nodes.Append('\n').Append('<').Append("k1").Append('>');
                foreach (String n2 in k1) {
                    nodes.Append('<').Append("n2").Append(' ').Append("value").Append('=').Append('"');
                    nodes.Append(n2);
                    nodes.Append('"').Append('/').Append('>');
                }
                nodes.Append('<').Append('/').Append("k1").Append('>');
                List<Custom> v1 = dictListIter.Value;
                nodes.Append('\n').Append('<').Append("v1").Append('>');
                foreach (Custom n2 in v1) {
                    n2.WriteXML(nodes, "n2");
                }
                nodes.Append('<').Append('/').Append("v1").Append('>');
            }
            nodes.Append('<').Append('/').Append("dictList").Append('>');
        }
        if (this.list5d.Count > 0) {
            nodes.Append('\n').Append('<').Append("list5d").Append('>');
            foreach (List<List<List<List<Custom>>>> n1 in this.list5d) {
                nodes.Append('\n').Append('<').Append("n1").Append('>');
                foreach (List<List<List<Custom>>> n2 in n1) {
                    nodes.Append('\n').Append('<').Append("n2").Append('>');
                    foreach (List<List<Custom>> n3 in n2) {
                        nodes.Append('\n').Append('<').Append("n3").Append('>');
                        foreach (List<Custom> n4 in n3) {
                            nodes.Append('\n').Append('<').Append("n4").Append('>');
                            foreach (Custom n5 in n4) {
                                n5.WriteXML(nodes, "n5");
                            }
                            nodes.Append('<').Append('/').Append("n4").Append('>');
                        }
                        nodes.Append('<').Append('/').Append("n3").Append('>');
                    }
                    nodes.Append('<').Append('/').Append("n2").Append('>');
                }
                nodes.Append('<').Append('/').Append("n1").Append('>');
            }
            nodes.Append('<').Append('/').Append("list5d").Append('>');
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
    } //TestNest::WriteXML(...)

} //class: TestNest
/*
1@Test.Xyz.TestNest/vec-map-string-Test.Abc.Custom/map-vec-string-vec-Test.Abc.Custom/vec-vec-vec-ve
  c-vec-Test.Abc.Custom/map-string-string
+@Test.Abc.Custom/int32/Test.Abc.TestBasic/Test.Xyz.Conflict/Test.Abc.Conflict/vec-Test.Abc.Custom/i
  nt32/string/string/Test.Abc.Custom/Test.Abc.Custom/string
*/
} //namespace: Test.Xyz