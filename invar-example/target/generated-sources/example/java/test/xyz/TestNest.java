/*===----------------------------*  Java 6  *------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.xyz;

import invar.lib.CodecError;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import test.abc.Custom;

/** 测试泛型相互嵌套 */
public final class TestNest
implements
invar.lib.InvarCodec.BinaryDecode,
invar.lib.InvarCodec.BinaryEncode,
invar.lib.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0x6F0C2598L;

    static public TestNest Create()
    {
        return new TestNest();
    }

    private LinkedList<LinkedHashMap<String,Custom>>                         listDict;
    private LinkedHashMap<LinkedList<String>,LinkedList<Custom>>             dictList;
    private LinkedList<LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>>> list5d  ;/* 五维列表 */

    public TestNest()
    {
        listDict = new LinkedList<LinkedHashMap<String,Custom>>();
        dictList = new LinkedHashMap<LinkedList<String>,LinkedList<Custom>>();
        list5d   = new LinkedList<LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>>>();
    }

    public TestNest reuse()
    {
        listDict.clear();
        dictList.clear();
        list5d.clear();
        return this;
    }

    /**  */
    @invar.lib.InvarRule(T="vec<map<string,test.abc.Custom>>", S="f0")
    public LinkedList<LinkedHashMap<java.lang.String,Custom>> getListDict() { return listDict; }
    /**  */
    @invar.lib.InvarRule(T="map<vec<string>,vec<test.abc.Custom>>", S="f1")
    public LinkedHashMap<LinkedList<java.lang.String>,LinkedList<Custom>> getDictList() { return dictList; }
    /** 五维列表 */
    @invar.lib.InvarRule(T="vec<vec<vec<vec<vec<test.abc.Custom>>>>>", S="f2")
    public LinkedList<LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>>> getList5d() { return list5d; }

    /** Shallow copy */
    public TestNest copy(TestNest from_)
    {
        if (this == from_ || from_ == null) {
            return this;
        }
        listDict.clear();
        listDict.addAll(from_.listDict);
        dictList.clear();
        dictList.putAll(from_.dictList);
        list5d.clear();
        list5d.addAll(from_.list5d);
        return this;
    } /* copyFrom(...) */

    public void read(InputStream from_) throws IOException, CodecError
    {
        this.read((DataInput)new DataInputStream(from_));
    }

    public void read(DataInput from_) throws IOException, CodecError
    {
        listDict.clear();
        Long lenListDict = from_.readInt() & 0xFFFFFFFFL;
        for (Long iListDict = 0L; iListDict < lenListDict; ++iListDict) {
            LinkedHashMap<java.lang.String,Custom> n1 = new LinkedHashMap<java.lang.String,Custom>(); //read.vec.head
            Long lenN1 = from_.readInt() & 0xFFFFFFFFL;
            for (Long iN1 = 0L; iN1 < lenN1; ++iN1) {
                java.lang.String k2 = from_.readUTF();
                Custom v2 = Custom.Create();
                v2.read(from_);
                n1.put(k2,v2);
            }
            listDict.add(n1);
        }
        dictList.clear();
        Long lenDictList = from_.readInt() & 0xFFFFFFFFL;
        for (Long iDictList = 0L; iDictList < lenDictList; ++iDictList) {
            LinkedList<java.lang.String> k1 = new LinkedList<java.lang.String>(); //read.map.head
            Long lenK1 = from_.readInt() & 0xFFFFFFFFL;
            for (Long iK1 = 0L; iK1 < lenK1; ++iK1) {
                java.lang.String n2 = from_.readUTF();
                k1.add(n2);
            }
            LinkedList<Custom> v1 = new LinkedList<Custom>(); //read.map.head
            Long lenV1 = from_.readInt() & 0xFFFFFFFFL;
            for (Long iV1 = 0L; iV1 < lenV1; ++iV1) {
                Custom n2 = Custom.Create();
                n2.read(from_);
                v1.add(n2);
            }
            dictList.put(k1,v1);
        }
        list5d.clear();
        Long lenList5d = from_.readInt() & 0xFFFFFFFFL;
        for (Long iList5d = 0L; iList5d < lenList5d; ++iList5d) {
            LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>> n1 = new LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>>(); //read.vec.head
            Long lenN1 = from_.readInt() & 0xFFFFFFFFL;
            for (Long iN1 = 0L; iN1 < lenN1; ++iN1) {
                LinkedList<LinkedList<LinkedList<Custom>>> n2 = new LinkedList<LinkedList<LinkedList<Custom>>>(); //read.vec.head
                Long lenN2 = from_.readInt() & 0xFFFFFFFFL;
                for (Long iN2 = 0L; iN2 < lenN2; ++iN2) {
                    LinkedList<LinkedList<Custom>> n3 = new LinkedList<LinkedList<Custom>>(); //read.vec.head
                    Long lenN3 = from_.readInt() & 0xFFFFFFFFL;
                    for (Long iN3 = 0L; iN3 < lenN3; ++iN3) {
                        LinkedList<Custom> n4 = new LinkedList<Custom>(); //read.vec.head
                        Long lenN4 = from_.readInt() & 0xFFFFFFFFL;
                        for (Long iN4 = 0L; iN4 < lenN4; ++iN4) {
                            Custom n5 = Custom.Create();
                            n5.read(from_);
                            n4.add(n5);
                        }
                        n3.add(n4);
                    }
                    n2.add(n3);
                }
                n1.add(n2);
            }
            list5d.add(n1);
        }
    }

    public void write(OutputStream dest_) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(dest_));
    }

    public void write(DataOutput dest_) throws IOException
    {
        dest_.writeInt(listDict.size());
        for (LinkedHashMap<java.lang.String,Custom> n1 : listDict) {
            dest_.writeInt(n1.size());
            for (Map.Entry<java.lang.String,Custom> n1Iter : n1.entrySet()) {
                java.lang.String k2 = n1Iter.getKey();
                dest_.writeUTF(k2);
                Custom v2 = n1Iter.getValue();
                v2.write(dest_);
            }
        }
        dest_.writeInt(dictList.size());
        for (Map.Entry<LinkedList<java.lang.String>,LinkedList<Custom>> dictListIter : dictList.entrySet()) {
            LinkedList<java.lang.String> k1 = dictListIter.getKey();
            dest_.writeInt(k1.size());
            for (java.lang.String n2 : k1) {
                dest_.writeUTF(n2);
            }
            LinkedList<Custom> v1 = dictListIter.getValue();
            dest_.writeInt(v1.size());
            for (Custom n2 : v1) {
                n2.write(dest_);
            }
        }
        dest_.writeInt(list5d.size());
        for (LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>> n1 : list5d) {
            dest_.writeInt(n1.size());
            for (LinkedList<LinkedList<LinkedList<Custom>>> n2 : n1) {
                dest_.writeInt(n2.size());
                for (LinkedList<LinkedList<Custom>> n3 : n2) {
                    dest_.writeInt(n3.size());
                    for (LinkedList<Custom> n4 : n3) {
                        dest_.writeInt(n4.size());
                        for (Custom n5 : n4) {
                            n5.write(dest_);
                        }
                    }
                }
            }
        }
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append('{');
        s.append(getClass().getName());
        s.append(',').append("listDict").append(':');
        s.append('(').append(listDict.size()).append(')');
        s.append(',').append("dictList").append(':');
        s.append('[').append(dictList.size()).append(']');
        s.append(',').append("list5d").append(':');
        s.append('(').append(list5d.size()).append(')');
        s.append('}');
        return s.toString();
    } //TestNest::toString ()

    public String toStringJSON()
    {
        StringBuilder code = new StringBuilder();
        this.writeJSON(code);
        return code.toString();
    }

    public void writeJSON(StringBuilder _)
    {
        _.append('{');
        char comma = '\0';
        boolean listDictExists = (null != listDict && listDict.size() > 0);
        if (listDictExists) { _.append('"').append("listDict").append('"').append(':'); comma = ','; }
        int listDictSize = (null == listDict ? 0 : listDict.size());
        if (listDictSize > 0) {
            _.append('[');
            int listDictIdx = 0;
            for (LinkedHashMap<java.lang.String,Custom> n1 : listDict) { /* vec.for: listDict */
                ++listDictIdx;
                int n1Size = (null == n1 ? 0 : n1.size());
                if (n1Size > 0) {
                    _.append('{');
                    int n1Idx = 0;
                    for (Map.Entry<java.lang.String,Custom> n1Iter : n1.entrySet()) { /* map.for: n1 */
                        ++n1Idx;
                        java.lang.String k2 = n1Iter.getKey(); /* nest.k */
                        _.append('"').append(k2.toString()).append('"'); _.append(':');
                        Custom v2 = n1Iter.getValue(); /* nest.v */
                        v2.writeJSON(_);
                        if (n1Idx != n1Size) { _.append(','); }
                    }
                    _.append('}');
                }
                if (listDictIdx != listDictSize) { _.append(','); }
            }
            _.append(']');
        }
        boolean dictListExists = (null != dictList && dictList.size() > 0);
        if ('\0' != comma && dictListExists) { _.append(comma); comma = '\0'; }
        if (dictListExists) { _.append('"').append("dictList").append('"').append(':'); comma = ','; }
        int dictListSize = (null == dictList ? 0 : dictList.size());
        if (dictListSize > 0) {
            _.append('{');
            int dictListIdx = 0;
            for (Map.Entry<LinkedList<java.lang.String>,LinkedList<Custom>> dictListIter : dictList.entrySet()) { /* map.for: dictList */
                ++dictListIdx;
                LinkedList<java.lang.String> k1 = dictListIter.getKey();
                int k1Size = (null == k1 ? 0 : k1.size());
                if (k1Size > 0) {
                    _.append('[');
                    int k1Idx = 0;
                    for (java.lang.String n2 : k1) { /* vec.for: k1 */
                        ++k1Idx;
                        _.append('"').append(n2.toString()).append('"');
                        if (k1Idx != k1Size) { _.append(','); }
                    }
                    _.append(']');
                }
                LinkedList<Custom> v1 = dictListIter.getValue();
                int v1Size = (null == v1 ? 0 : v1.size());
                if (v1Size > 0) {
                    _.append('[');
                    int v1Idx = 0;
                    for (Custom n2 : v1) { /* vec.for: v1 */
                        ++v1Idx;
                        n2.writeJSON(_);
                        if (v1Idx != v1Size) { _.append(','); }
                    }
                    _.append(']');
                }
                if (dictListIdx != dictListSize) { _.append(','); }
            }
            _.append('}');
        }
        boolean list5dExists = (null != list5d && list5d.size() > 0);
        if ('\0' != comma && list5dExists) { _.append(comma); comma = '\0'; }
        if (list5dExists) { _.append('"').append("list5d").append('"').append(':'); comma = ','; }
        int list5dSize = (null == list5d ? 0 : list5d.size());
        if (list5dSize > 0) {
            _.append('[');
            int list5dIdx = 0;
            for (LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>> n1 : list5d) { /* vec.for: list5d */
                ++list5dIdx;
                int n1Size = (null == n1 ? 0 : n1.size());
                if (n1Size > 0) {
                    _.append('[');
                    int n1Idx = 0;
                    for (LinkedList<LinkedList<LinkedList<Custom>>> n2 : n1) { /* vec.for: n1 */
                        ++n1Idx;
                        int n2Size = (null == n2 ? 0 : n2.size());
                        if (n2Size > 0) {
                            _.append('[');
                            int n2Idx = 0;
                            for (LinkedList<LinkedList<Custom>> n3 : n2) { /* vec.for: n2 */
                                ++n2Idx;
                                int n3Size = (null == n3 ? 0 : n3.size());
                                if (n3Size > 0) {
                                    _.append('[');
                                    int n3Idx = 0;
                                    for (LinkedList<Custom> n4 : n3) { /* vec.for: n3 */
                                        ++n3Idx;
                                        int n4Size = (null == n4 ? 0 : n4.size());
                                        if (n4Size > 0) {
                                            _.append('[');
                                            int n4Idx = 0;
                                            for (Custom n5 : n4) { /* vec.for: n4 */
                                                ++n4Idx;
                                                n5.writeJSON(_);
                                                if (n4Idx != n4Size) { _.append(','); }
                                            }
                                            _.append(']');
                                        }
                                        if (n3Idx != n3Size) { _.append(','); }
                                    }
                                    _.append(']');
                                }
                                if (n2Idx != n2Size) { _.append(','); }
                            }
                            _.append(']');
                        }
                        if (n1Idx != n1Size) { _.append(','); }
                    }
                    _.append(']');
                }
                if (list5dIdx != list5dSize) { _.append(','); }
            }
            _.append(']');
        }
        _.append('}');
    } /* TestNest::writeJSON(...) */

    public String toStringXML()
    {
        StringBuilder code = new StringBuilder();
        this.writeXML(code, "TestNest");
        return code.toString();
    }

    public void writeXML(StringBuilder result_, String name_)
    {
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes = new StringBuilder();
        if (listDict.size() > 0) {
            nodes.append('<').append("listDict").append('>');
            for (LinkedHashMap<java.lang.String,Custom> n1 : listDict) {
                nodes.append('<').append("n1").append('>');
                for (Map.Entry<java.lang.String,Custom> n1Iter : n1.entrySet()) {
                    java.lang.String k2 = n1Iter.getKey();
                    nodes.append('<').append("k2").append(' ').append("value").append('=').append('"');
                    nodes.append(k2).append('"').append('/').append('>');
                    Custom v2 = n1Iter.getValue();
                    v2.writeXML(nodes, "v2");
                }
                nodes.append('<').append('/').append("n1").append('>');
            }
            nodes.append('<').append('/').append("listDict").append('>');
        }
        if (dictList.size() > 0) {
            nodes.append('<').append("dictList").append('>');
            for (Map.Entry<LinkedList<java.lang.String>,LinkedList<Custom>> dictListIter : dictList.entrySet()) {
                LinkedList<java.lang.String> k1 = dictListIter.getKey();
                nodes.append('<').append("k1").append('>');
                for (java.lang.String n2 : k1) {
                    nodes.append('<').append("n2").append(' ').append("value").append('=').append('"');
                    nodes.append(n2).append('"').append('/').append('>');
                }
                nodes.append('<').append('/').append("k1").append('>');
                LinkedList<Custom> v1 = dictListIter.getValue();
                nodes.append('<').append("v1").append('>');
                for (Custom n2 : v1) {
                    n2.writeXML(nodes, "n2");
                }
                nodes.append('<').append('/').append("v1").append('>');
            }
            nodes.append('<').append('/').append("dictList").append('>');
        }
        if (list5d.size() > 0) {
            nodes.append('<').append("list5d").append('>');
            for (LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>> n1 : list5d) {
                nodes.append('<').append("n1").append('>');
                for (LinkedList<LinkedList<LinkedList<Custom>>> n2 : n1) {
                    nodes.append('<').append("n2").append('>');
                    for (LinkedList<LinkedList<Custom>> n3 : n2) {
                        nodes.append('<').append("n3").append('>');
                        for (LinkedList<Custom> n4 : n3) {
                            nodes.append('<').append("n4").append('>');
                            for (Custom n5 : n4) {
                                n5.writeXML(nodes, "n5");
                            }
                            nodes.append('<').append('/').append("n4").append('>');
                        }
                        nodes.append('<').append('/').append("n3").append('>');
                    }
                    nodes.append('<').append('/').append("n2").append('>');
                }
                nodes.append('<').append('/').append("n1").append('>');
            }
            nodes.append('<').append('/').append("list5d").append('>');
        }
        result_.append('<').append(name_).append(attrs);
        if (nodes.length() == 0) {
            result_.append('/').append('>');
        } else {
            result_.append('>').append(nodes);
            result_.append('<').append('/').append(name_).append('>');
        }
    } /* TestNest::writeXML(...) */

}

