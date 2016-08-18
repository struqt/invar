/*===----------------------------*  Java  *--------------------------------===//
//
//             THIS FILE IS GENERATED BY INVAR. DO NOT EDIT !!!
//
//===----------------------------------------------------------------------===*/
package test.xyz;

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
invar.InvarCodec.BinaryDecode,
invar.InvarCodec.BinaryEncode,
invar.InvarCodec.XMLEncode
{
    static public final long CRC32 = 0x6F0C2598;

    static public TestNest Create() {
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
    @invar.InvarRule(T="vec<map<string,test.abc.Custom>>", S="f0")
    public LinkedList<LinkedHashMap<String,Custom>> getListDict() { return listDict; }

    /**  */
    @invar.InvarRule(T="map<vec<string>,vec<test.abc.Custom>>", S="f1")
    public LinkedHashMap<LinkedList<String>,LinkedList<Custom>> getDictList() { return dictList; }

    /** 五维列表 */
    @invar.InvarRule(T="vec<vec<vec<vec<vec<test.abc.Custom>>>>>", S="f2")
    public LinkedList<LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>>> getList5d() { return list5d; }

    public TestNest copy (TestNest from)
    {
        if (this == from || from == null) {
            return this;
        }
        listDict.clear();
        listDict.addAll(from.listDict);
        dictList.clear();
        dictList.putAll(from.dictList);
        list5d.clear();
        list5d.addAll(from.list5d);
        return this;
    } //copyFrom(...)

    public void read(InputStream from) throws IOException
    {
        this.read((DataInput)new DataInputStream(from));
    }

    public void read(DataInput from) throws IOException
    {
        listDict.clear();
        Long lenListDict = from.readInt() & 0xFFFFFFFFL;
        for (Long iListDict = 0L; iListDict < lenListDict; ++iListDict) {
            LinkedHashMap<java.lang.String,Custom> n1 = new LinkedHashMap<java.lang.String,Custom>(); //read.vec.head
            Long lenN1 = from.readInt() & 0xFFFFFFFFL;
            for (Long iN1 = 0L; iN1 < lenN1; ++iN1) {
                java.lang.String k2 = from.readUTF();
                Custom v2 = Custom.Create();
                v2.read(from);
                n1.put(k2,v2);
            }
            listDict.add(n1);
        }
        dictList.clear();
        Long lenDictList = from.readInt() & 0xFFFFFFFFL;
        for (Long iDictList = 0L; iDictList < lenDictList; ++iDictList) {
            LinkedList<java.lang.String> k1 = new LinkedList<java.lang.String>(); //read.map.head
            Long lenK1 = from.readInt() & 0xFFFFFFFFL;
            for (Long iK1 = 0L; iK1 < lenK1; ++iK1) {
                java.lang.String n2 = from.readUTF();
                k1.add(n2);
            }
            LinkedList<Custom> v1 = new LinkedList<Custom>(); //read.map.head
            Long lenV1 = from.readInt() & 0xFFFFFFFFL;
            for (Long iV1 = 0L; iV1 < lenV1; ++iV1) {
                Custom n2 = Custom.Create();
                n2.read(from);
                v1.add(n2);
            }
            dictList.put(k1,v1);
        }
        list5d.clear();
        Long lenList5d = from.readInt() & 0xFFFFFFFFL;
        for (Long iList5d = 0L; iList5d < lenList5d; ++iList5d) {
            LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>> n1 = new LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>>(); //read.vec.head
            Long lenN1 = from.readInt() & 0xFFFFFFFFL;
            for (Long iN1 = 0L; iN1 < lenN1; ++iN1) {
                LinkedList<LinkedList<LinkedList<Custom>>> n2 = new LinkedList<LinkedList<LinkedList<Custom>>>(); //read.vec.head
                Long lenN2 = from.readInt() & 0xFFFFFFFFL;
                for (Long iN2 = 0L; iN2 < lenN2; ++iN2) {
                    LinkedList<LinkedList<Custom>> n3 = new LinkedList<LinkedList<Custom>>(); //read.vec.head
                    Long lenN3 = from.readInt() & 0xFFFFFFFFL;
                    for (Long iN3 = 0L; iN3 < lenN3; ++iN3) {
                        LinkedList<Custom> n4 = new LinkedList<Custom>(); //read.vec.head
                        Long lenN4 = from.readInt() & 0xFFFFFFFFL;
                        for (Long iN4 = 0L; iN4 < lenN4; ++iN4) {
                            Custom n5 = Custom.Create();
                            n5.read(from);
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

    public void write(OutputStream from) throws IOException
    {
        this.write((DataOutput)new DataOutputStream(from));
    }

    public void write(DataOutput dest) throws IOException
    {
        dest.writeInt(listDict.size());
        for (LinkedHashMap<java.lang.String,Custom> n1 : listDict) {
            dest.writeInt(n1.size());
            for (Map.Entry<java.lang.String,Custom> n1Iter : n1.entrySet()) {
                java.lang.String k2 = n1Iter.getKey();
                dest.writeUTF(k2);
                Custom v2 = n1Iter.getValue();
                v2.write(dest);
            }
        }
        dest.writeInt(dictList.size());
        for (Map.Entry<LinkedList<java.lang.String>,LinkedList<Custom>> dictListIter : dictList.entrySet()) {
            LinkedList<java.lang.String> k1 = dictListIter.getKey();
            dest.writeInt(k1.size());
            for (java.lang.String n2 : k1) {
                dest.writeUTF(n2);
            }
            LinkedList<Custom> v1 = dictListIter.getValue();
            dest.writeInt(v1.size());
            for (Custom n2 : v1) {
                n2.write(dest);
            }
        }
        dest.writeInt(list5d.size());
        for (LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>> n1 : list5d) {
            dest.writeInt(n1.size());
            for (LinkedList<LinkedList<LinkedList<Custom>>> n2 : n1) {
                dest.writeInt(n2.size());
                for (LinkedList<LinkedList<Custom>> n3 : n2) {
                    dest.writeInt(n3.size());
                    for (LinkedList<Custom> n4 : n3) {
                        dest.writeInt(n4.size());
                        for (Custom n5 : n4) {
                            n5.write(dest);
                        }
                    }
                }
            }
        }
    }

    public StringBuilder toStringXML (String name)
    {
        StringBuilder result = new StringBuilder();
        StringBuilder attrs  = new StringBuilder();
        StringBuilder nodes  = new StringBuilder();
        if (listDict.size() > 0) {
            nodes.append("<listDict>");
            for (LinkedHashMap<java.lang.String,Custom> n1 : listDict) {
                nodes.append("<n1>");
                for (Map.Entry<java.lang.String,Custom> n1Iter : n1.entrySet()) {
                    java.lang.String k2 = n1Iter.getKey();
                    nodes.append("<k2 value=\"");
                    nodes.append(k2);
                    nodes.append("\">");
                    Custom v2 = n1Iter.getValue();
                    nodes.append(v2.toStringXML("v2"));
                }
                nodes.append("</n1>");
            }
            nodes.append("</listDict>");
        }
        if (dictList.size() > 0) {
            nodes.append("<dictList>");
            for (Map.Entry<LinkedList<java.lang.String>,LinkedList<Custom>> dictListIter : dictList.entrySet()) {
                LinkedList<java.lang.String> k1 = dictListIter.getKey();
                nodes.append("<k1>");
                for (java.lang.String n2 : k1) {
                    nodes.append("<n2 value=\"");
                    nodes.append(n2);
                    nodes.append("\">");
                }
                nodes.append("</k1>");
                LinkedList<Custom> v1 = dictListIter.getValue();
                nodes.append("<v1>");
                for (Custom n2 : v1) {
                    nodes.append(n2.toStringXML("n2"));
                }
                nodes.append("</v1>");
            }
            nodes.append("</dictList>");
        }
        if (list5d.size() > 0) {
            nodes.append("<list5d>");
            for (LinkedList<LinkedList<LinkedList<LinkedList<Custom>>>> n1 : list5d) {
                nodes.append("<n1>");
                for (LinkedList<LinkedList<LinkedList<Custom>>> n2 : n1) {
                    nodes.append("<n2>");
                    for (LinkedList<LinkedList<Custom>> n3 : n2) {
                        nodes.append("<n3>");
                        for (LinkedList<Custom> n4 : n3) {
                            nodes.append("<n4>");
                            for (Custom n5 : n4) {
                                nodes.append(n5.toStringXML("n5"));
                            }
                            nodes.append("</n4>");
                        }
                        nodes.append("</n3>");
                    }
                    nodes.append("</n2>");
                }
                nodes.append("</n1>");
            }
            nodes.append("</list5d>");
        }
        result.append("<"); result.append(name); result.append(attrs);
        if (nodes.length() == 0) {
            result.append("/>");
        } else {
            result.append(">");
            result.append(nodes);
            result.append("</"); result.append(name); result.append(">");
        }
        return result;
    } //TestNest::toStringXML (String name)

    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        result.append("{ ");
        result.append(getClass().getName());
        result.append(", listDict:");
        result.append("(" + listDict.size() + ")");
        result.append(", dictList:");
        result.append("[" + dictList.size() + "]");
        result.append(", list5d:");
        result.append("(" + list5d.size() + ")");
        result.append(" }");
        return result.toString();
    } //TestNest::toString ()

}

