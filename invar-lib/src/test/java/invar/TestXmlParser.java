/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar;

import invar.lib.data.DataNode;
import invar.lib.data.DataParser;
import invar.lib.data.DataParserXml;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * Created by wangkang on 12/8/16
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestXmlParser {

    private static DataParser parser = new DataParserXml();

    @BeforeClass
    static public void testInit() throws Exception {
        DataNode node = parser.parse("<a/>");
        Assert.assertEquals(0, node.numChildren());
        Assert.assertEquals("a", node.getFieldName());
    }

    @Test
    public void test001() throws Exception {
        DataNode node = parser.parse("<a/>");
        Assert.assertEquals(0, node.numChildren());
        Assert.assertEquals("a", node.getFieldName());
    }

    @Test
    public void test002() throws Exception {
        DataNode node = parser.parse("<root>" +
            "<net ip=\"127.0.0.1\" port=\"3000\">" +
            "<desc>hello世界</desc>" +
            "</net></root>");
        Assert.assertEquals(1, node.numChildren());

        DataNode n1 = node.getChild(0);
        Assert.assertEquals(3, n1.numChildren());
        Assert.assertEquals("net", n1.getFieldName());

        DataNode n20 = n1.getChild(0);
        Assert.assertEquals(0, n20.numChildren());
        Assert.assertEquals("ip", n20.getFieldName());
        Assert.assertEquals("127.0.0.1", n20.getValue());

        DataNode n21 = n1.getChild(1);
        Assert.assertEquals(0, n21.numChildren());
        Assert.assertEquals("port", n21.getFieldName());
        Assert.assertEquals("3000", n21.getValue());

        DataNode n22 = n1.getChild(2);
        Assert.assertEquals(0, n22.numChildren());
        Assert.assertEquals("desc", n22.getFieldName());
        Assert.assertEquals("hello世界", n22.getValue());
    }

}
