/*===-----------------------------*  C#  *---------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/

namespace Test.Abc {

using System.Collections.Generic;
using System.IO;
using System.Text;
using System;

/// 自定义类型.
public sealed class Custom
: Invar.BinaryDecode
, Invar.BinaryEncode
, Invar.JSONEncode
, Invar.XMLEncode
{
    public const uint CRC32 = 0x34A39940;

    private Gender            x        = Gender.NONE; // 枚举值.
    private TestBasic         test     = new TestBasic(); // 其他类型.
    private Test.Xyz.Conflict xyz      = new Test.Xyz.Conflict(); // 同名的类型.
    private Test.Abc.Conflict abc      = new Test.Abc.Conflict(); // 同名的类型.
    private List<Custom>      children = new List<Custom>(); // 自身类型容器.
    private Int32             noSetter = -1; // 屏蔽Setter.
    private String            useRef   = ""; // 使用引用.
    private String            usePtr   = null; // 使用指针.
    private Custom            prev     = null; // 自身类型.
    private Custom            next     = null; // 自身类型.
    private String            emptyDoc = "";

    /// 枚举值.
    [Invar.InvarRule("Test.Abc.Gender", "0")]
    public Gender GetX() { return this.x; }

    /// 其他类型.
    [Invar.InvarRule("Test.Abc.TestBasic", "1")]
    public TestBasic GetTest() { return this.test; }

    /// 同名的类型.
    [Invar.InvarRule("Test.Xyz.Conflict", "2")]
    public Test.Xyz.Conflict GetXyz() { return this.xyz; }

    /// 同名的类型.
    [Invar.InvarRule("Test.Abc.Conflict", "3")]
    public Test.Abc.Conflict GetAbc() { return this.abc; }

    /// 自身类型容器.
    [Invar.InvarRule("vec<Test.Abc.Custom>", "4")]
    public List<Custom> GetChildren() { return this.children; }

    /// 屏蔽Setter.
    [Invar.InvarRule("int32", "5")]
    public Int32 GetNoSetter() { return this.noSetter; }

    /// 使用引用.
    [Invar.InvarRule("string", "6")]
    public String GetUseRef() { return this.useRef; }

    /// 使用指针.
    [Invar.InvarRule("string", "7")]
    public String GetUsePtr() { return this.usePtr; }

    /// 自身类型.
    [Invar.InvarRule("Test.Abc.Custom", "8")]
    public Custom GetPrev() { return this.prev; }

    /// 自身类型.
    [Invar.InvarRule("Test.Abc.Custom", "9")]
    public Custom GetNext() { return this.next; }

    /// .
    [Invar.InvarRule("string", "10")]
    public String GetEmptyDoc() { return this.emptyDoc; }

    /// 枚举值.
    [Invar.InvarRule("Test.Abc.Gender", "0")]
    public Custom SetX(Gender value) { this.x = value; return this; }

    /// 其他类型.
    [Invar.InvarRule("Test.Abc.TestBasic", "1")]
    public Custom SetTest(TestBasic value) { this.test = value; return this; }

    /// 同名的类型.
    [Invar.InvarRule("Test.Xyz.Conflict", "2")]
    public Custom SetXyz(Test.Xyz.Conflict value) { this.xyz = value; return this; }

    /// 同名的类型.
    [Invar.InvarRule("Test.Abc.Conflict", "3")]
    public Custom SetAbc(Test.Abc.Conflict value) { this.abc = value; return this; }

    /// 使用引用.
    [Invar.InvarRule("string", "6")]
    public Custom SetUseRef(String value) { this.useRef = value; return this; }

    /// 使用指针.
    [Invar.InvarRule("string", "7")]
    public Custom SetUsePtr(String value) { this.usePtr = value; return this; }

    /// 自身类型.
    [Invar.InvarRule("Test.Abc.Custom", "8")]
    public Custom SetPrev(Custom value) { this.prev = value; return this; }

    /// 自身类型.
    [Invar.InvarRule("Test.Abc.Custom", "9")]
    public Custom SetNext(Custom value) { this.next = value; return this; }

    /// .
    [Invar.InvarRule("string", "10")]
    public Custom SetEmptyDoc(String value) { this.emptyDoc = value; return this; }

    public Custom Reuse()
    {
        this.x        = Gender.NONE;
        this.test.Reuse();
        this.xyz.Reuse();
        this.abc.Reuse();
        this.children.Clear();
        this.noSetter = -1;
        this.useRef   = "";
        if (this.usePtr != null) { this.usePtr = ""; }
        if (this.prev != null) { this.prev.Reuse(); }
        if (this.next != null) { this.next.Reuse(); }
        this.emptyDoc = "";
        return this;
    } //Custom::Reuse()

    public Custom Copy(Custom from_)
    {
        if (null == from_ || this == from_) {
            return this;
        }
        this.x = from_.x;
        this.test.Copy(from_.test);
        this.xyz.Copy(from_.xyz);
        this.abc.Copy(from_.abc);
        this.children.Clear();
        this.children.AddRange(from_.children);
        this.noSetter = from_.noSetter;
        this.useRef = from_.useRef;
        this.usePtr = from_.usePtr;
        if (null == from_.prev) {
            this.prev = null;
        } else {
            if (null == this.prev) { this.prev = new Custom(); }
            this.prev.Copy(from_.prev);
        }
        if (null == from_.next) {
            this.next = null;
        } else {
            if (null == this.next) { this.next = new Custom(); }
            this.next.Copy(from_.next);
        }
        this.emptyDoc = from_.emptyDoc;
        return this;
    } //Custom::Copy(...)

    public void Read(BinaryReader r)
    {
        this.x = (Gender)Enum.ToObject(typeof(Gender), r.ReadInt32());
        this.test.Read(r);
        this.xyz.Read(r);
        this.abc.Read(r);
        UInt32 lenChildren = r.ReadUInt32();
        for (UInt32 iChildren = 0; iChildren < lenChildren; iChildren++) {
            Custom n1 = new Custom();
            n1.Read(r);
            this.children.Add(n1);
        }
        this.noSetter = r.ReadInt32();
        this.useRef = Encoding.UTF8.GetString(r.ReadBytes(r.ReadInt32()));
        sbyte usePtrExists = r.ReadSByte();
        if ((sbyte)0x01 == usePtrExists) {
            this.usePtr = Encoding.UTF8.GetString(r.ReadBytes(r.ReadInt32()));
        }
        else if ((sbyte)0x00 == usePtrExists) { this.usePtr = null; }
        else { throw new IOException("Protoc read error: The value of 'usePtrExists' is invalid.", 496); }
        sbyte prevExists = r.ReadSByte();
        if ((sbyte)0x01 == prevExists) {
            if (this.prev == null) { this.prev = new Custom(); }
            this.prev.Read(r);
        }
        else if ((sbyte)0x00 == prevExists) { this.prev = null; }
        else { throw new IOException("Protoc read error: The value of 'prevExists' is invalid.", 497); }
        sbyte nextExists = r.ReadSByte();
        if ((sbyte)0x01 == nextExists) {
            if (this.next == null) { this.next = new Custom(); }
            this.next.Read(r);
        }
        else if ((sbyte)0x00 == nextExists) { this.next = null; }
        else { throw new IOException("Protoc read error: The value of 'nextExists' is invalid.", 497); }
        this.emptyDoc = Encoding.UTF8.GetString(r.ReadBytes(r.ReadInt32()));
    } //Custom::Read(...)

    public void Write(BinaryWriter w)
    {
        w.Write((Int32)this.x);
        this.test.Write(w);
        this.xyz.Write(w);
        this.abc.Write(w);
        w.Write(this.children.Count);
        foreach (Custom n1 in this.children) {
            n1.Write(w);
        }
        w.Write(this.noSetter);
        byte[] useRefBytes = Encoding.UTF8.GetBytes(this.useRef);
        w.Write(useRefBytes.Length);
        w.Write(useRefBytes);
        if (this.usePtr != null) {
            w.Write((sbyte)0x01);
            byte[] usePtrBytes = Encoding.UTF8.GetBytes(this.usePtr);
        w.Write(usePtrBytes.Length);
        w.Write(usePtrBytes);
        } else {
            w.Write((sbyte)0x00);
        }
        if (this.prev != null) {
            w.Write((sbyte)0x01);
            this.prev.Write(w);
        } else {
            w.Write((sbyte)0x00);
        }
        if (this.next != null) {
            w.Write((sbyte)0x01);
            this.next.Write(w);
        } else {
            w.Write((sbyte)0x00);
        }
        byte[] emptyDocBytes = Encoding.UTF8.GetBytes(this.emptyDoc);
        w.Write(emptyDocBytes.Length);
        w.Write(emptyDocBytes);
    } //Custom::Write(...)

    public override String ToString()
    {
        StringBuilder result = new StringBuilder();
        result.Append('{').Append(' ');
        result.Append(GetType().ToString());
        result.Append(',').Append(' ').Append("x").Append(':');
        result.Append(this.x.ToString());
        result.Append(',').Append(' ').Append("test").Append(':');
        result.Append("<TestBasic>");
        result.Append(',').Append(' ').Append("xyz").Append(':');
        result.Append("<Test.Xyz.Conflict>");
        result.Append(',').Append(' ').Append("abc").Append(':');
        result.Append("<Test.Abc.Conflict>");
        result.Append(',').Append(' ').Append("children").Append(':');
        result.Append("(" + this.children.Count + ")");
        result.Append(',').Append(' ').Append("noSetter").Append(':');
        result.Append(this.noSetter.ToString());
        result.Append(',').Append(' ').Append("useRef").Append(':');
        result.Append("\"" + this.useRef + "\"");
        result.Append(',').Append(' ').Append("usePtr").Append(':');
        if (this.usePtr != null) { result.Append("\"" + this.usePtr + "\""); }
        else { result.Append("null"); }
        result.Append(',').Append(' ').Append("prev").Append(':');
        if (this.prev != null) { result.Append("<Custom>"); }
        else { result.Append("null"); }
        result.Append(',').Append(' ').Append("next").Append(':');
        if (this.next != null) { result.Append("<Custom>"); }
        else { result.Append("null"); }
        result.Append(',').Append(' ').Append("emptyDoc").Append(':');
        result.Append("\"" + this.emptyDoc + "\"");
        result.Append(' ').Append('}');
        return result.ToString();
    } //Custom::ToString()

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
        s.Append('"').Append("x").Append('"').Append(':'); comma = ","; s.Append((int)this.x);;
        bool testExists = (null != this.test);
        if (!String.IsNullOrEmpty(comma) && testExists) { s.Append(comma); comma = null; }
        if (testExists) {
            s.Append('"').Append("test").Append('"').Append(':'); comma = ","; this.test.WriteJSON(s);
        }
        bool xyzExists = (null != this.xyz);
        if (!String.IsNullOrEmpty(comma) && xyzExists) { s.Append(comma); comma = null; }
        if (xyzExists) {
            s.Append('"').Append("xyz").Append('"').Append(':'); comma = ","; this.xyz.WriteJSON(s);
        }
        bool abcExists = (null != this.abc);
        if (!String.IsNullOrEmpty(comma) && abcExists) { s.Append(comma); comma = null; }
        if (abcExists) {
            s.Append('"').Append("abc").Append('"').Append(':'); comma = ","; this.abc.WriteJSON(s);
        }
        bool childrenExists = (null != this.children && this.children.Count > 0);
        if (!String.IsNullOrEmpty(comma) && childrenExists) { s.Append(comma); comma = null; }
        if (childrenExists) { s.Append('"').Append("children").Append('"').Append(':'); comma = ","; }
        int childrenSize = (null == this.children ? 0 : this.children.Count);
        if (childrenSize > 0) {
            s.Append('\n').Append('[');
            int childrenIdx = 0;
            foreach (Custom n1 in this.children) { /* vec.for: this.children */
                ++childrenIdx;
                n1.WriteJSON(s);
                if (childrenIdx != childrenSize) { s.Append(','); }
            }
            s.Append(']');
        }
        if (!String.IsNullOrEmpty(comma)) { s.Append(comma); comma = null; }
        s.Append('"').Append("noSetter").Append('"').Append(':'); comma = ","; s.Append(this.noSetter.ToString());
        bool useRefExists = !String.IsNullOrEmpty(this.useRef);
        if (!String.IsNullOrEmpty(comma) && useRefExists) { s.Append(comma); comma = null; }
        if (useRefExists) {
            s.Append('"').Append("useRef").Append('"').Append(':'); comma = ","; s.Append('"').Append(this.useRef.ToString()).Append('"');
        }
        bool usePtrExists = !String.IsNullOrEmpty(this.usePtr);
        if (!String.IsNullOrEmpty(comma) && usePtrExists) { s.Append(comma); comma = null; }
        if (usePtrExists) {
            s.Append('"').Append("usePtr").Append('"').Append(':'); comma = ","; s.Append('"').Append(this.usePtr.ToString()).Append('"');
        }
        bool prevExists = (null != this.prev);
        if (!String.IsNullOrEmpty(comma) && prevExists) { s.Append(comma); comma = null; }
        if (prevExists) {
            s.Append('"').Append("prev").Append('"').Append(':'); comma = ","; this.prev.WriteJSON(s);
        }
        bool nextExists = (null != this.next);
        if (!String.IsNullOrEmpty(comma) && nextExists) { s.Append(comma); comma = null; }
        if (nextExists) {
            s.Append('"').Append("next").Append('"').Append(':'); comma = ","; this.next.WriteJSON(s);
        }
        bool emptyDocExists = !String.IsNullOrEmpty(this.emptyDoc);
        if (!String.IsNullOrEmpty(comma) && emptyDocExists) { s.Append(comma); comma = null; }
        if (emptyDocExists) {
            s.Append('"').Append("emptyDoc").Append('"').Append(':'); comma = ","; s.Append('"').Append(this.emptyDoc.ToString()).Append('"');
        }
        s.Append('}').Append('\n');
    } //Custom::WriteJSON(...)

    public StringBuilder ToStringLua()
    {
        StringBuilder code = new StringBuilder();
        code.Append("-- Custom.CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" --").Append('\n');
        code.Append("local table=");
        this.WriteLua(code); code.Append(';');
        return code;
    }

    public void WriteLua(StringBuilder s)
    {
        s.Append('\n').Append('{');
        string comma = null;
        s.Append("x").Append('='); comma = ","; s.Append((int)this.x);;
        bool testExists = (null != this.test);
        if (!String.IsNullOrEmpty(comma) && testExists) { s.Append(comma); comma = null; }
        if (testExists) {
            s.Append("test").Append('='); comma = ","; this.test.WriteLua(s);
        }
        bool xyzExists = (null != this.xyz);
        if (!String.IsNullOrEmpty(comma) && xyzExists) { s.Append(comma); comma = null; }
        if (xyzExists) {
            s.Append("xyz").Append('='); comma = ","; this.xyz.WriteLua(s);
        }
        bool abcExists = (null != this.abc);
        if (!String.IsNullOrEmpty(comma) && abcExists) { s.Append(comma); comma = null; }
        if (abcExists) {
            s.Append("abc").Append('='); comma = ","; this.abc.WriteLua(s);
        }
        bool childrenExists = (null != this.children && this.children.Count > 0);
        if (!String.IsNullOrEmpty(comma) && childrenExists) { s.Append(comma); comma = null; }
        if (childrenExists) { s.Append("children").Append('='); comma = ","; }
        int childrenSize = (null == this.children ? 0 : this.children.Count);
        if (childrenSize > 0) {
            s.Append('\n').Append('{');
            int childrenIdx = 0;
            foreach (Custom n1 in this.children) { /* vec.for: this.children */
                ++childrenIdx;
                n1.WriteLua(s);
                if (childrenIdx != childrenSize) { s.Append(','); }
                s.Append('}');
            }
        }
        if (!String.IsNullOrEmpty(comma)) { s.Append(comma); comma = null; }
        s.Append("noSetter").Append('='); comma = ","; s.Append(this.noSetter.ToString());
        bool useRefExists = !String.IsNullOrEmpty(this.useRef);
        if (!String.IsNullOrEmpty(comma) && useRefExists) { s.Append(comma); comma = null; }
        if (useRefExists) {
            s.Append("useRef").Append('='); comma = ","; s.Append('"').Append(this.useRef.ToString()).Append('"');
        }
        bool usePtrExists = !String.IsNullOrEmpty(this.usePtr);
        if (!String.IsNullOrEmpty(comma) && usePtrExists) { s.Append(comma); comma = null; }
        if (usePtrExists) {
            s.Append("usePtr").Append('='); comma = ","; s.Append('"').Append(this.usePtr.ToString()).Append('"');
        }
        bool prevExists = (null != this.prev);
        if (!String.IsNullOrEmpty(comma) && prevExists) { s.Append(comma); comma = null; }
        if (prevExists) {
            s.Append("prev").Append('='); comma = ","; this.prev.WriteLua(s);
        }
        bool nextExists = (null != this.next);
        if (!String.IsNullOrEmpty(comma) && nextExists) { s.Append(comma); comma = null; }
        if (nextExists) {
            s.Append("next").Append('='); comma = ","; this.next.WriteLua(s);
        }
        bool emptyDocExists = !String.IsNullOrEmpty(this.emptyDoc);
        if (!String.IsNullOrEmpty(comma) && emptyDocExists) { s.Append(comma); comma = null; }
        if (emptyDocExists) {
            s.Append("emptyDoc").Append('='); comma = ","; s.Append('"').Append(this.emptyDoc.ToString()).Append('"');
        }
        s.Append('}').Append('\n');
    }

    public StringBuilder ToStringPHP()
    {
        StringBuilder code = new StringBuilder();
        code.Append("<?php ").Append("/* Custom.CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" */").Append('\n');
        code.Append('\n').Append("return ");
        this.WritePHP(code); code.Append(';').Append('\n');
        return code;
    }

    public void WritePHP(StringBuilder s)
    {
        s.Append("array").Append('(').Append('\n');
        string comma = null;
        s.Append('\'').Append("x").Append('\'').Append("=>"); comma = ","; s.Append((int)this.x);
        s.Append("/*Gender::").Append(this.x.ToString()).Append("*/");
        bool testExists = (null != this.test);
        if (!String.IsNullOrEmpty(comma) && testExists) { s.Append(comma).Append('\n'); comma = null; }
        if (testExists) {
            s.Append('\'').Append("test").Append('\'').Append("=>"); comma = ","; this.test.WritePHP(s);
        }
        bool xyzExists = (null != this.xyz);
        if (!String.IsNullOrEmpty(comma) && xyzExists) { s.Append(comma).Append('\n'); comma = null; }
        if (xyzExists) {
            s.Append('\'').Append("xyz").Append('\'').Append("=>"); comma = ","; this.xyz.WritePHP(s);
        }
        bool abcExists = (null != this.abc);
        if (!String.IsNullOrEmpty(comma) && abcExists) { s.Append(comma).Append('\n'); comma = null; }
        if (abcExists) {
            s.Append('\'').Append("abc").Append('\'').Append("=>"); comma = ","; this.abc.WritePHP(s);
        }
        bool childrenExists = (null != this.children && this.children.Count > 0);
        if (!String.IsNullOrEmpty(comma) && childrenExists) { s.Append(comma).Append('\n'); comma = null; }
        if (childrenExists) { s.Append('\'').Append("children").Append('\'').Append("=>"); comma = ","; }
        int childrenSize = (null == this.children ? 0 : this.children.Count);
        if (childrenSize > 0) {
            s.Append("array").Append('(').Append('\n');
            int childrenIdx = 0;
            foreach (Custom n1 in this.children) { /* vec.for: this.children */
                ++childrenIdx;
                n1.WritePHP(s);
                if (childrenIdx != childrenSize) { s.Append(',').Append('\n'); }
            }
            s.Append("/* vec size: ").Append(this.children.Count).Append(" */").Append(')');
        }
        if (!String.IsNullOrEmpty(comma)) { s.Append(comma).Append('\n'); comma = null; }
        s.Append('\'').Append("noSetter").Append('\'').Append("=>"); comma = ","; s.Append(this.noSetter.ToString());
        bool useRefExists = !String.IsNullOrEmpty(this.useRef);
        if (!String.IsNullOrEmpty(comma) && useRefExists) { s.Append(comma).Append('\n'); comma = null; }
        if (useRefExists) {
            s.Append('\'').Append("useRef").Append('\'').Append("=>"); comma = ","; s.Append('\'').Append(this.useRef.ToString()).Append('\'');
        }
        bool usePtrExists = !String.IsNullOrEmpty(this.usePtr);
        if (!String.IsNullOrEmpty(comma) && usePtrExists) { s.Append(comma).Append('\n'); comma = null; }
        if (usePtrExists) {
            s.Append('\'').Append("usePtr").Append('\'').Append("=>"); comma = ","; s.Append('\'').Append(this.usePtr.ToString()).Append('\'');
        }
        bool prevExists = (null != this.prev);
        if (!String.IsNullOrEmpty(comma) && prevExists) { s.Append(comma).Append('\n'); comma = null; }
        if (prevExists) {
            s.Append('\'').Append("prev").Append('\'').Append("=>"); comma = ","; this.prev.WritePHP(s);
        }
        bool nextExists = (null != this.next);
        if (!String.IsNullOrEmpty(comma) && nextExists) { s.Append(comma).Append('\n'); comma = null; }
        if (nextExists) {
            s.Append('\'').Append("next").Append('\'').Append("=>"); comma = ","; this.next.WritePHP(s);
        }
        bool emptyDocExists = !String.IsNullOrEmpty(this.emptyDoc);
        if (!String.IsNullOrEmpty(comma) && emptyDocExists) { s.Append(comma).Append('\n'); comma = null; }
        if (emptyDocExists) {
            s.Append('\'').Append("emptyDoc").Append('\'').Append("=>"); comma = ","; s.Append('\'').Append(this.emptyDoc.ToString()).Append('\'');
        }
        s.Append("/* ").Append(GetType().ToString()).Append(" */");
        s.Append(')');
    }

    public StringBuilder ToStringXML()
    {
        StringBuilder code = new StringBuilder();
        code.Append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        code.Append('\n').Append("<!-- ").Append("Custom").Append(".CRC32: 0x");
        code.Append(CRC32.ToString("X2")).Append(" -->");
        this.WriteXML(code, "Custom");
        return code;
    }

    public void WriteXML(StringBuilder s, String name)
    {
        StringBuilder attrs = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.Append(' ').Append("x").Append('=').Append('"').Append(this.x.ToString()).Append('"');
        this.test.WriteXML(nodes, "test");
        this.xyz.WriteXML(nodes, "xyz");
        this.abc.WriteXML(nodes, "abc");
        if (this.children.Count > 0) {
            nodes.Append('\n').Append('<').Append("children").Append('>');
            foreach (Custom n1 in this.children) {
                n1.WriteXML(nodes, "n1");
            }
            nodes.Append('<').Append('/').Append("children").Append('>');
        }
        attrs.Append(' ').Append("noSetter").Append('=').Append('"').Append(this.noSetter.ToString()).Append('"');
        attrs.Append(' ').Append("useRef").Append('=').Append('"').Append(this.useRef).Append('"');
        if (this.usePtr != null) {
            attrs.Append(' ').Append("usePtr").Append('=').Append('"').Append(this.usePtr).Append('"');
        }
        if (this.prev != null) {
            this.prev.WriteXML(nodes, "prev");
        }
        if (this.next != null) {
            this.next.WriteXML(nodes, "next");
        }
        attrs.Append(' ').Append("emptyDoc").Append('=').Append('"').Append(this.emptyDoc).Append('"');
        s.Append('\n').Append('<').Append(name).Append(attrs);
        if (nodes.Length == 0) {
            s.Append('/').Append('>');
        } else {
            s.Append('>').Append(nodes);
            s.Append('<').Append('/').Append(name).Append('>');
        }
    } //Custom::WriteXML(...)

} //class: Custom
/*
3@Test.Abc.Custom/int32/Test.Abc.TestBasic/Test.Xyz.Conflict/Test.Abc.Conflict/vec-Test.Abc.Custom/i
  nt32/string/string/Test.Abc.Custom/Test.Abc.Custom/string
+@Test.Abc.Conflict/int32/string/vec-int8/map-string-string
+@Test.Abc.TestBasic/int8/int16/int32/int64/uint8/uint16/uint32/uint64/float/double/bool/string/int3
  2/int32/map-string-string
+@Test.Xyz.Conflict/double/map-string-string
*/
} //namespace: Test.Abc