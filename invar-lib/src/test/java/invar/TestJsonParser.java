/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar;

import invar.lib.data.DataNode;
import invar.lib.data.DataParser;
import invar.lib.data.DataParserJson;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJsonParser {

    private static DataParser decoder = new DataParserJson();

    @BeforeClass
    static public void testInit() throws Exception {
        DataNode node = decoder.parse("0");
        Assert.assertEquals(0L, node.getValue());
    }

    @Test
    public void test001() throws Exception {
        DataNode node = decoder.parse("123");
        Assert.assertEquals(123L, node.getValue());
    }

    @Test
    public void test002() throws Exception {
        DataNode node = decoder.parse("3.14");
        Assert.assertEquals(3.14, node.getValue());
    }

    @Test
    public void test003() throws Exception {
        DataNode node = decoder.parse("\"hello\"");
        Assert.assertEquals("hello", node.getValue());
    }

    @Test
    public void test004() throws Exception {
        DataNode node = decoder.parse("[1,2,3]");
        Assert.assertEquals(3, node.numChildren());
        Assert.assertEquals("[1,2,3]", node.toString());
    }

    @Test
    public void test005() throws Exception {
        DataNode node = decoder.parse("{\"x\":66,\"y\":88}");
        Assert.assertEquals(2, node.numChildren());
        Assert.assertEquals("x", node.getChild(0).getFieldName());
        Assert.assertEquals(66L, node.getChild(0).getValue());
        Assert.assertEquals("y", node.getChild(1).getFieldName());
        Assert.assertEquals(88L, node.getChild(1).getValue());
    }

    @Test
    public void test006() throws Exception {
        DataNode node = decoder
            .parse("{\"a\":1,\"b\":{},\"c\":[{},[[{},{}]]]}");
        Assert.assertEquals(3, node.numChildren());
    }
}