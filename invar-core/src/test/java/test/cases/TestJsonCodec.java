/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package test.cases;

import invar.lib.InvarRuntime;
import invar.lib.data.DataMapper;
import invar.lib.data.DataNode;
import invar.lib.data.DataParserJson;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.simple.Numbers;
import test.simple.SingleInt64;
import test.simple.SingleUInt64;

import java.math.BigInteger;

/**
 * Created by wangkang on 11/16/16
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestJsonCodec {

    private static DataParserJson parser;
    private static DataMapper mapper;

    @BeforeClass
    public static void init() {
        InvarRuntime.init();
        parser = new DataParserJson();
        mapper = new DataMapper(parser);
        try {
            parser.parse("[{\"a\":[123]}]");
            mapper.map(Numbers.Create(), "{}");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_001_int64_parse() throws Exception {
        String json = "9223372036854775807";
        DataNode node = parser.parse(json);
        Assert.assertEquals(node.getTypeId(), DataNode.TypeId.INT64);
    }

    @Test
    public void test_002_int64_mapping() throws Exception {
        SingleInt64 int64 = new SingleInt64();
        int64.setNumber(0x7FFFFFFFFFFFFFFFL);
        String json = int64.toStringJSON();
        SingleInt64 o = mapper.map(SingleInt64.Create(), json);
        Assert.assertEquals(json, o.toStringJSON());
    }

    @Test
    public void test_003_uint64_parse() throws Exception {
        String json = "18446744073709551615";
        DataNode node = parser.parse(json);
        Assert.assertEquals(node.getTypeId(), DataNode.TypeId.BIGINT);
    }

    @Test
    public void test_004_uint64_mapping() throws Exception {
        SingleUInt64 int64 = new SingleUInt64();
        int64.setNumber(new BigInteger("18446744073709551615"));
        String json = int64.toStringJSON();
        SingleUInt64 o = mapper.map(SingleUInt64.Create(), json);
        Assert.assertEquals(json, o.toStringJSON());
    }

    @Test
    public void test_005_numbers() throws Exception {
        Numbers o = new Numbers();
        o.setNumber0(0);
        o.setNumber1(1);
        o.setNumber2(2);
        o.setNumber3(3L);
        o.setNumber4(4);
        o.setNumber5(5);
        o.setNumber5(5);
        o.setNumber7(BigInteger.valueOf(7));
        o.setNumber8(8F);
        o.setNumber9(9.);
        String json = o.toStringJSON();
        Numbers o2 = mapper.map(new Numbers(), json);
        Assert.assertEquals(json, o2.toStringJSON());
    }

}
