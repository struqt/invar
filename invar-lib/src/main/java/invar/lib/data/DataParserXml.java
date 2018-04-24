/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib.data;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.io.StringReader;
import java.util.Stack;

/**
 * Created by wangkang on 12/7/16
 */
public class DataParserXml implements DataParser {

    private final XMLInputFactory factory;

    public DataParserXml() {
        final XMLInputFactory fac = XMLInputFactory.newFactory();
        fac.setProperty(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.TRUE);
        fac.setProperty(XMLInputFactory.IS_COALESCING, Boolean.FALSE);
        fac.setProperty(XMLInputFactory.SUPPORT_DTD, Boolean.FALSE);
        fac.setProperty(XMLInputFactory.IS_VALIDATING, Boolean.FALSE);
        fac.setProperty(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.FALSE);
        fac.setProperty(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.FALSE);
        this.factory = fac;
    }

    public DataParserXml(XMLInputFactory factory) {
        this.factory = factory;
    }

    @Override
    public DataNode parse(String content) throws Exception {
        DataNode root = DataNode.createObject();
        if (content == null || content.length() <= 0) {
            return root;
        }
        final Stack<DataNode<Object>> stack = new Stack<DataNode<Object>>();
        final XMLStreamReader reader = this.factory
            .createXMLStreamReader(new StringReader(content));
        return StAX(root, reader, stack);
    }

    @Override
    public DataNode parse(InputStream input) throws Exception {
        DataNode root = DataNode.createObject();
        if (input == null || input.available() <= 0) {
            return root;
        }
        final Stack<DataNode<Object>> stack = new Stack<DataNode<Object>>();
        final XMLStreamReader reader = this.factory
            .createXMLStreamReader(input, DataNode.UTF8.name());
        return StAX(root, reader, stack);
    }

    static private DataNode StAX(DataNode root, XMLStreamReader reader, Stack<DataNode<Object>> stack)
        throws XMLStreamException {
        try {
            while (reader.hasNext()) {
                int event = reader.getEventType();
                switch (event) {
                    case XMLStreamConstants.START_ELEMENT:
                        StAXStartElement(reader, stack);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        StAXEndElement(reader, stack, root);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        StAXCharacters(reader, stack);
                        break;
                    case XMLStreamConstants.START_DOCUMENT:
                        if (reader.getVersion() != null &&
                            !reader.getVersion().equals("1.0")) {
                            throw new XMLStreamException("XML version should be 1.0\n" + event + "\n");
                        }
                        break;
                    default:
                        break;
                }
                reader.next();
            }
        } finally {
            reader.close();
        }
        return root.numChildren() > 0 ? root.getChild(0) : root;
    }

    private static void StAXCharacters(XMLStreamReader r, Stack<DataNode<Object>> stack)
        throws XMLStreamException {
        int length = r.getTextLength();
        char[] chars = new char[length];
        r.getTextCharacters(0, chars, 0, length);
        String value = String.valueOf(chars);
        DataNode<Object> n = stack.peek();
        if (stack.empty() || n == null) {
            throw new XMLStreamException("No DataNode to store value :" + value);
        }
        if (value.trim().length() <= 0 && n.getValue() != null) {
            return;
        }
        n.setValue(value);
    }

    private static void StAXStartElement(XMLStreamReader r, Stack<DataNode<Object>> stack) {
        int len = r.getAttributeCount();
        String name = r.getLocalName();
        if (len <= 0) {
            DataNode<Object> n = DataNode.createAny();
            n.setFieldName(name);
            stack.push(n);
        } else {
            DataNode<Object> n = DataNode.createAny();
            n.setFieldName(name);
            stack.push(n);
            for (int i = 0; i < len; i++) {
                String k = r.getAttributeName(i).getLocalPart();
                String v = r.getAttributeValue(i);
                DataNode<Object> n1 = DataNode.createAny();
                n1.setFieldName(k);
                n1.setValue(v);
                n.addChild(n1);
            }
        }
    }

    private static void StAXEndElement(XMLStreamReader r, Stack<DataNode<Object>> stack, DataNode root)
        throws XMLStreamException {
        String name = r.getLocalName();
        DataNode n = stack.peek();
        if (stack.empty() || n == null) {
            throw new XMLStreamException("No start, but end: " + name);
        }
        if (name.equals(n.getFieldName())) {
            n = stack.pop();
            DataNode p = stack.empty() ? root : stack.peek();
            p.addChild(n);
        } else {
            throw new XMLStreamException("Redundant end element: " + name);
        }
    }


}
