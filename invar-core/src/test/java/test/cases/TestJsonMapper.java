/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package test.cases;

import invar.lib.InvarRuntime;
import invar.lib.data.DataMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import test.simple.Numbers;

/**
 * Created by wangkang on 12/9/16
 */
public class TestJsonMapper {

    private static DataMapper mapper;

    @BeforeClass
    public static void init() {
        InvarRuntime.init();
        mapper = DataMapper.forJson();
        try {
            Numbers info = Numbers.Create();
            String json = info.toStringJSON();
            mapper.map(Numbers.Create(), json);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void test_001_numbers_min_value() throws Exception {
        Numbers info = TestModels.numbersWithMinValues();
        String json = info.toStringJSON();
        printLine(json);
        Numbers o = mapper.map(Numbers.Create(), json);
        Assert.assertEquals(json, o.toStringJSON());
    }

    @Test
    public void test_002_numbers_max_value() throws Exception {
        Numbers info = TestModels.numbersWithMaxValues();
        String json = info.toStringJSON();
        printLine(json);
        Numbers o = mapper.map(Numbers.Create(), json);
        Assert.assertEquals(json, o.toStringJSON());
    }

    @Test
    public void test_003_numbers_random_value() throws Exception {
        Numbers info = TestModels.numbersWithRandomValues();
        String json = info.toStringJSON();
        printLine(json);
        Numbers o = mapper.map(Numbers.Create(), json);
        Assert.assertEquals(json, o.toStringJSON());
    }

    static private void printLine(String s) {
        System.out.println("| " + s);
    }
}
