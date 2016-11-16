/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar.lib.data;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

/**
 * Parse a data stream to a DataNode tree.
 * Created by wangkang on 11/12/16
 */
public class DataParserJson {

    private final JsonFactory factory;

    public DataParserJson() {
        this.factory = new JsonFactory();
    }

    public DataNode parse(String content) throws IOException {
        DataNode root = DataNode.createObject();
        if (content == null || content.length() <= 0) {
            return root;
        }
        JsonParser parser = factory.createParser(content);
        initParser(parser);
        parse(parser, root);
        parser.close();
        return root.numChildren() > 0 ? root.getChild(0) : root;
    }

    public DataNode parse(InputStream input) throws IOException {
        DataNode root = DataNode.createObject();
        if (input == null || input.available() <= 0) {
            return root;
        }
        JsonParser parser = factory.createParser(input);
        initParser(parser);
        parse(parser, root);
        parser.close();
        return root.numChildren() > 0 ? root.getChild(0) : root;
    }

    void initParser(JsonParser parser) {
        parser.enable(JsonParser.Feature.AUTO_CLOSE_SOURCE);
        parser.enable(JsonParser.Feature.IGNORE_UNDEFINED);
    }

    void parse(JsonParser parser, DataNode root) throws IOException {
        String fieldName = null;
        DataNode parent = root;
        while (!parser.isClosed()) {
            JsonToken token = parser.nextToken();
            if (token == null) {
                continue;
            }
            switch (token) {
                case START_ARRAY:
                    parent.addChild(parent = DataNode.createArray().setFieldName(fieldName));
                    fieldName = null;
                    break;
                case END_ARRAY:
                    parent = parent.getParent();
                    fieldName = null;
                    break;
                case START_OBJECT:
                    parent.addChild(parent = DataNode.createObject().setFieldName(fieldName));
                    fieldName = null;
                    break;
                case END_OBJECT:
                    parent = parent.getParent();
                    fieldName = null;
                    break;
                case VALUE_TRUE:
                    parent.addChild(DataNode.createBoolean()
                        .setValue(true).setFieldName(fieldName));
                    fieldName = null;
                    break;
                case VALUE_FALSE:
                    parent.addChild(DataNode.createBoolean()
                        .setValue(false).setFieldName(fieldName));
                    fieldName = null;
                    break;
                case VALUE_NULL:
                    parent.addChild(DataNode.createNull()
                        .setValue(null).setFieldName(fieldName));
                    fieldName = null;
                    break;
                case VALUE_STRING:
                    parent.addChild(DataNode.createString().setFieldName(fieldName)
                        .setValue(parser.getValueAsString()));
                    fieldName = null;
                    break;
                case VALUE_NUMBER_INT:
                    try {
                        Long v = parser.getValueAsLong();
                        parent.addChild(DataNode.createLong()
                            .setFieldName(fieldName).setValue(v));
                    } catch (JsonParseException e) {
                        BigInteger v = parser.getBigIntegerValue();
                        parent.addChild(DataNode.createBigInt()
                            .setFieldName(fieldName).setValue(v));
                    }
                    fieldName = null;
                    break;
                case VALUE_NUMBER_FLOAT:
                    parent.addChild(DataNode.createDouble().setFieldName(fieldName)
                        .setValue(parser.getValueAsDouble()));
                    fieldName = null;
                    break;
                case FIELD_NAME:
                    fieldName = parser.getValueAsString();
                    break;
                default:
                    fieldName = null;
                    break;
            }
        }
    }

}