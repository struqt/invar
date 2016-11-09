/*===----------------------------*  Java 6  *------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.abc;

import invar.lib.CodecError;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

/** 自定义类型 */
public final class Custom
implements
invar.lib.InvarCodec.BinaryDecode,
invar.lib.InvarCodec.BinaryEncode,
invar.lib.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0x355EC042L;

    static public Custom Create()
    {
        return new Custom();
    }

    private Gender             x       ;/* 枚举值 */
    private TestBasic          test_   ;/* 其他类型 */
    private test.xyz.Conflict  xyz     ;/* 同名的类型 */
    private test.abc.Conflict  abc     ;/* 同名的类型 */
    private LinkedList<Custom> children;/* 自身类型容器 */
    private Integer            noSetter;/* 屏蔽Setter */
    private String             useRef  ;/* 使用引用 */
    private String             usePtr  ;/* 使用指针 */
    private Custom             prev    ;/* 自身类型 */
    private Custom             next    ;/* 自身类型 */
    private String             emptyDoc;

    public Custom()
    {
        x        = Gender.NONE;
        test_    = TestBasic.Create();
        xyz      = test.xyz.Conflict.Create();
        abc      = test.abc.Conflict.Create();
        children = new LinkedList<Custom>();
        noSetter = -1;
        useRef   = "";
        usePtr   = null;
        prev     = null;
        next     = null;
        emptyDoc = "";
    }

    public Custom reuse()
    {
        x = Gender.NONE;
        test_.reuse();
        xyz.reuse();
        abc.reuse();
        children.clear();
        noSetter = -1;
        useRef = "";
        if (usePtr != null) {
            usePtr = "";
        }
        if (prev != null) {
            prev.reuse();
        }
        if (next != null) {
            next.reuse();
        }
        emptyDoc = "";
        return this;
    }

    /** 枚举值 */
    @invar.lib.InvarRule(T="test.abc.Gender", S="f0")
    public Gender getX() { return x; }

    /** 其他类型 */
    @invar.lib.InvarRule(T="test.abc.TestBasic", S="f1")
    public TestBasic getTest_() { return test_; }

    /** 同名的类型 */
    @invar.lib.InvarRule(T="test.xyz.Conflict", S="f2")
    public test.xyz.Conflict getXyz() { return xyz; }

    /** 同名的类型 */
    @invar.lib.InvarRule(T="test.abc.Conflict", S="f3")
    public test.abc.Conflict getAbc() { return abc; }

    /** 自身类型容器 */
    @invar.lib.InvarRule(T="vec<test.abc.Custom>", S="f4")
    public LinkedList<Custom> getChildren() { return children; }

    /** 屏蔽Setter */
    @invar.lib.InvarRule(T="int32", S="f5")
    public Integer getNoSetter() { return noSetter; }

    /** 使用引用 */
    @invar.lib.InvarRule(T="string", S="f6")
    public String getUseRef() { return useRef; }

    /** 使用指针 */
    @invar.lib.InvarRule(T="string", S="f7")
    public String getUsePtr() { return usePtr; }

    /** 自身类型 */
    @invar.lib.InvarRule(T="test.abc.Custom", S="f8")
    public Custom getPrev() { return prev; }

    /** 自身类型 */
    @invar.lib.InvarRule(T="test.abc.Custom", S="f9")
    public Custom getNext() { return next; }

    /**  */
    @invar.lib.InvarRule(T="string", S="f10")
    public String getEmptyDoc() { return emptyDoc; }

    /** 枚举值 */
    @invar.lib.InvarRule(T="test.abc.Gender", S="f0")
    public void setX(Gender value) { this.x = value; }
    public void setXV(int value) { this.x = Gender.valueOf(value); }
    /** 其他类型 */
    @invar.lib.InvarRule(T="test.abc.TestBasic", S="f1")
    public void setTest_(TestBasic value) { this.test_ = value; }
    /** 同名的类型 */
    @invar.lib.InvarRule(T="test.xyz.Conflict", S="f2")
    public void setXyz(test.xyz.Conflict value) { this.xyz = value; }
    /** 同名的类型 */
    @invar.lib.InvarRule(T="test.abc.Conflict", S="f3")
    public void setAbc(test.abc.Conflict value) { this.abc = value; }
    /** 使用引用 */
    @invar.lib.InvarRule(T="string", S="f6")
    public void setUseRef(String value) { this.useRef = value; }
    /** 使用指针 */
    @invar.lib.InvarRule(T="string", S="f7")
    public void setUsePtr(String value) { this.usePtr = value; }
    /** 自身类型 */
    @invar.lib.InvarRule(T="test.abc.Custom", S="f8")
    public void setPrev(Custom value) { this.prev = value; }
    /** 自身类型 */
    @invar.lib.InvarRule(T="test.abc.Custom", S="f9")
    public void setNext(Custom value) { this.next = value; }
    /**  */
    @invar.lib.InvarRule(T="string", S="f10")
    public void setEmptyDoc(String value) { this.emptyDoc = value; }

    /** Shallow copy */
    public Custom copy(Custom from)
    {
        if (this == from || from == null) {
            return this;
        }
        x = from.x;
        test_ = from.test_;
        xyz = from.xyz;
        abc = from.abc;
        children.clear();
        children.addAll(from.children);
        noSetter = from.noSetter;
        useRef = from.useRef;
        usePtr = from.usePtr;
        if (from.prev != null) {
            prev.copy(from.prev);
        } else {
            prev = null;
        }
        if (from.next != null) {
            next.copy(from.next);
        } else {
            next = null;
        }
        emptyDoc = from.emptyDoc;
        return this;
    } /* copyFrom(...) */

    public void read(InputStream from) throws IOException, CodecError
    {
        this.read((DataInput)new DataInputStream(from));
    }

    public void read(DataInput from) throws IOException, CodecError
    {
        x = Gender.valueOf(from.readInt());
        test_.read(from);
        xyz.read(from);
        abc.read(from);
        children.clear();
        Long lenChildren = from.readInt() & 0xFFFFFFFFL;
        for (Long iChildren = 0L; iChildren < lenChildren; ++iChildren) {
            Custom n1 = Custom.Create();
            n1.read(from);
            children.add(n1);
        }
        noSetter = from.readInt();
        useRef = from.readUTF();
        byte usePtrExists = from.readByte();
        if ((byte)0x01 == usePtrExists) {
            usePtr = from.readUTF();
        }
        else if ((byte)0x00 == usePtrExists) { usePtr = null; }
        else { throw new CodecError(CodecError.ERR_DECODE_STRING_P); }
        byte prevExists = from.readByte();
        if ((byte)0x01 == prevExists) {
            if (prev == null) { prev = Custom.Create(); }
            prev.read(from);
        }
        else if ((byte)0x00 == prevExists) { prev = null; }
        else { throw new CodecError(CodecError.ERR_DECODE_STRUCT_P); }
        byte nextExists = from.readByte();
        if ((byte)0x01 == nextExists) {
            if (next == null) { next = Custom.Create(); }
            next.read(from);
        }
        else if ((byte)0x00 == nextExists) { next = null; }
        else { throw new CodecError(CodecError.ERR_DECODE_STRUCT_P); }
        emptyDoc = from.readUTF();
    }

    public void write(OutputStream from) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(from));
    }

    public void write(DataOutput dest) throws IOException
    {
        dest.writeInt(x.value());
        test_.write(dest);
        xyz.write(dest);
        abc.write(dest);
        dest.writeInt(children.size());
        for (Custom n1 : children) {
            n1.write(dest);
        }
        dest.writeInt(noSetter);
        dest.writeUTF(useRef);
        if (usePtr != null) {
            dest.writeByte((byte)0x01);
            dest.writeUTF(usePtr);
        } else {
            dest.writeByte((byte)0x00);
        }
        if (prev != null) {
            dest.writeByte((byte)0x01);
            prev.write(dest);
        } else {
            dest.writeByte((byte)0x00);
        }
        if (next != null) {
            dest.writeByte((byte)0x01);
            next.write(dest);
        } else {
            dest.writeByte((byte)0x00);
        }
        dest.writeUTF(emptyDoc);
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append('{');
        s.append(getClass().getName());
        s.append(',').append("x").append(':');
        s.append(x.toString());
        s.append(',').append("test_").append(':');
        s.append('<').append("TestBasic").append('>');
        s.append(',').append("xyz").append(':');
        s.append('<').append("test.xyz.Conflict").append('>');
        s.append(',').append("abc").append(':');
        s.append('<').append("test.abc.Conflict").append('>');
        s.append(',').append("children").append(':');
        s.append('(').append(children.size()).append(')');
        s.append(',').append("noSetter").append(':');
        s.append(noSetter.toString());
        s.append(',').append("useRef").append(':');
        s.append('"').append(useRef).append('"');
        s.append(", usePtr:");
        if (usePtr != null) {
            s.append('"').append(usePtr).append('"');
        } else {
            s.append("null");
        }
        s.append(", prev:");
        if (prev != null) {
            s.append('<').append("Custom").append('>');
        } else {
            s.append("null");
        }
        s.append(", next:");
        if (next != null) {
            s.append('<').append("Custom").append('>');
        } else {
            s.append("null");
        }
        s.append(',').append("emptyDoc").append(':');
        s.append('"').append(emptyDoc).append('"');
        s.append('}');
        return s.toString();
    } //Custom::toString ()

    public String toStringJSON()
    {
        StringBuilder code = new StringBuilder();
        this.writeJSON(code);
        return code.toString();
    }

    public void writeJSON(StringBuilder s)
    {
        s.append('{');
        char comma = '\0';
        s.append('"').append("x").append('"').append(':');
        s.append(x.value()); comma = ',';
        boolean test_Exists = (null != test_);
        if ('\0' != comma && test_Exists) { s.append(comma); comma = '\0'; }
        if (test_Exists) {
            s.append('"').append("test_").append('"').append(':'); comma = ','; test_.writeJSON(s);
        }
        boolean xyzExists = (null != xyz);
        if ('\0' != comma && xyzExists) { s.append(comma); comma = '\0'; }
        if (xyzExists) {
            s.append('"').append("xyz").append('"').append(':'); comma = ','; xyz.writeJSON(s);
        }
        boolean abcExists = (null != abc);
        if ('\0' != comma && abcExists) { s.append(comma); comma = '\0'; }
        if (abcExists) {
            s.append('"').append("abc").append('"').append(':'); comma = ','; abc.writeJSON(s);
        }
        boolean childrenExists = (null != children && children.size() > 0);
        if ('\0' != comma && childrenExists) { s.append(comma); comma = '\0'; }
        if (childrenExists) { s.append('"').append("children").append('"').append(':'); comma = ','; }
        int childrenSize = (null == children ? 0 : children.size());
        if (childrenSize > 0) {
            s.append('[');
            int childrenIdx = 0;
            for (Custom n1 : children) { /* vec.for: children */
                ++childrenIdx;
                n1.writeJSON(s);
                if (childrenIdx != childrenSize) { s.append(','); }
            }
            s.append(']');
        }
        if ('\0' != comma) { s.append(comma); comma = '\0'; }
        s.append('"').append("noSetter").append('"').append(':');
        s.append(noSetter.toString()); comma = ',';
        boolean useRefExists = useRef != null && useRef.length() > 0;
        if ('\0' != comma && useRefExists) { s.append(comma); comma = '\0'; }
        if (useRefExists) {
            s.append('"').append("useRef").append('"').append(':'); comma = ','; s.append('"').append(useRef.toString()).append('"');
        }
        boolean usePtrExists = usePtr != null && usePtr.length() > 0;
        if ('\0' != comma && usePtrExists) { s.append(comma); comma = '\0'; }
        if (usePtrExists) {
            s.append('"').append("usePtr").append('"').append(':'); comma = ','; s.append('"').append(usePtr.toString()).append('"');
        }
        boolean prevExists = (null != prev);
        if ('\0' != comma && prevExists) { s.append(comma); comma = '\0'; }
        if (prevExists) {
            s.append('"').append("prev").append('"').append(':'); comma = ','; prev.writeJSON(s);
        }
        boolean nextExists = (null != next);
        if ('\0' != comma && nextExists) { s.append(comma); comma = '\0'; }
        if (nextExists) {
            s.append('"').append("next").append('"').append(':'); comma = ','; next.writeJSON(s);
        }
        boolean emptyDocExists = emptyDoc != null && emptyDoc.length() > 0;
        if ('\0' != comma && emptyDocExists) { s.append(comma); comma = '\0'; }
        if (emptyDocExists) {
            s.append('"').append("emptyDoc").append('"').append(':'); comma = ','; s.append('"').append(emptyDoc.toString()).append('"');
        }
        s.append('}');
    } /* Custom::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "Custom");
        return code.toString();
    }

    public void writeXML(StringBuilder result, String name)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        attrs.append(' ').append("x").append('=').append('"');
        attrs.append(x.toString()).append('"');
        test_.writeXML(nodes, "test_");
        xyz.writeXML(nodes, "xyz");
        abc.writeXML(nodes, "abc");
        if (children.size() > 0) {
            nodes.append('<').append("children").append('>');
            for (Custom n1 : children) {
                n1.writeXML(nodes, "n1");
            }
            nodes.append('<').append('/').append("children").append('>');
        }
        attrs.append(' ').append("noSetter").append('=').append('"');
        attrs.append(noSetter.toString()).append('"');
        attrs.append(' ').append("useRef").append('=').append('"');
        attrs.append(useRef).append('"');
        if (usePtr != null) {
            attrs.append(' ').append("usePtr").append('=').append('"');
            attrs.append(usePtr).append('"');
        }
        if (prev != null) {
            prev.writeXML(nodes, "prev");
        }
        if (next != null) {
            next.writeXML(nodes, "next");
        }
        attrs.append(' ').append("emptyDoc").append('=').append('"');
        attrs.append(emptyDoc).append('"');
        result.append('<').append(name).append(attrs);
        if (nodes.length() == 0) {
            result.append('/').append('>');
        } else {
            result.append('>').append(nodes);
            result.append('<').append('/').append(name).append('>');
        }
    } /* Custom::writeXML(...) */

}

