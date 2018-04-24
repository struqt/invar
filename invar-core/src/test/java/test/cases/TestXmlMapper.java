/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package test.cases;

import invar.lib.InvarRuntime;
import invar.lib.data.DataMapper;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.dict.SimpleDict;
import test.enums.Color;
import test.list.NestedList3D;
import test.list.SimpleList;
import test.list.SimpleListDict;
import test.misc.TestPointer;
import test.simple.Numbers;
import test.sql.SimpleRecord;

import java.util.LinkedList;
import java.util.Map;

/**
 * Created by wangkang on 12/9/16
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestXmlMapper {

    private static DataMapper mapper;

    @BeforeClass
    public static void init() {
        InvarRuntime.init();
        mapper = DataMapper.forXml();
        try {
            mapper.map(Numbers.Create(), Numbers.Create().toStringXML());
            mapper.map(SimpleRecord.Create(), SimpleRecord.Create().toStringXML());
            mapper.map(SimpleList.Create(), SimpleList.Create().toStringXML());
            mapper.map(NestedList3D.Create(), NestedList3D.Create().toStringXML());
            mapper.map(SimpleListDict.Create(), SimpleListDict.Create().toStringXML());
            mapper.map(SimpleDict.Create(), SimpleDict.Create().toStringXML());
            mapper.setVerbose(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_001_numbers_min_value() throws Exception {
        Numbers info = TestModels.numbersWithMinValues();
        String xml = info.toStringXML();
        printLine(xml);
        Numbers o = mapper.map(Numbers.Create(), xml);
        Assert.assertEquals(xml, o.toStringXML());
    }

    @Test
    public void test_002_numbers_max_value() throws Exception {
        Numbers info = TestModels.numbersWithMaxValues();
        String xml = info.toStringXML();
        printLine(xml);
        Numbers o = mapper.map(Numbers.Create(), xml);
        Assert.assertEquals(xml, o.toStringXML());
    }

    @Test
    public void test_003_numbers_random_value() throws Exception {
        Numbers info = TestModels.numbersWithRandomValues();
        String xml = info.toStringXML();
        printLine(xml);
        Numbers o = mapper.map(Numbers.Create(), xml);
        Assert.assertEquals(xml, o.toStringXML());
    }

    @Test
    public void test_004_nested_value() throws Exception {
        String xml = "<x number0=\"10\"><number1>\n11<![CDATA[200]]>\n </number1><number0>127</number0></x>";
        printLine(xml);
        Numbers o = mapper.map(Numbers.Create(), xml);
        Assert.assertEquals(127, o.getNumber0().intValue());
        Assert.assertEquals(200, o.getNumber1().intValue());
    }

    @Test
    public void test_005_uncharted_value() throws Exception {
        String xml = "<x number=\"10\"></x>";
        printLine(xml);
        mapper.map(Numbers.Create(), xml);
    }

    @Test
    public void test_010_boolean() throws Exception {
        String xml = "<x><bool10 value=\"false\"><![CDATA[ TRUE ]]></bool10></x>";
        printLine(xml);
        SimpleRecord o = mapper.map(SimpleRecord.Create(), xml);
        Assert.assertEquals(true, o.getBool10());
    }

    @Test
    public void test_011_string() throws Exception {
        String xml = "<x><string11><![CDATA[ hello ]]></string11></x>";
        printLine(xml);
        SimpleRecord o = mapper.map(SimpleRecord.Create(), xml);
        Assert.assertEquals(" hello ", o.getString11());
    }

    @Test
    public void test_012_enum_integer() throws Exception {
        String xml = "<x enum12=\"101\"/>";
        printLine(xml);
        SimpleRecord o = mapper.map(SimpleRecord.Create(), xml);
        Assert.assertEquals(Color.Green, o.getEnum12());
    }

    @Test
    public void test_012_enum_string() throws Exception {
        String xml = "<x><enum12><![CDATA[ Red ]]></enum12></x>";
        printLine(xml);
        SimpleRecord o = mapper.map(SimpleRecord.Create(), xml);
        Assert.assertEquals(Color.Red, o.getEnum12());
    }

    @Test
    public void test_013_struct() throws Exception {
        String xml = "<x><struct13><number0>127</number0><number1><![CDATA[200]]></number1></struct13></x>";
        printLine(xml);
        SimpleRecord o = mapper.map(SimpleRecord.Create(), xml);
        Assert.assertNotNull(o.getStruct13());
        Assert.assertEquals(127, o.getStruct13().getNumber0().intValue());
        Assert.assertEquals(200, o.getStruct13().getNumber1().intValue());
    }

    @Test
    public void test_021_nested_list3d() throws Exception {
        String xml
            = "<x><number2><n1><n2>"
            + "<n3>50</n3>"
            + "<n3>51</n3>"
            + "<n3 key=\"abc\" value=\"52\"/>"
            + "</n2></n1></number2></x>";
        printLine(xml);
        NestedList3D o = mapper.map(NestedList3D.Create(), xml);

        Assert.assertNotNull(o.getNumber2());
        Assert.assertNotNull(o.getNumber2().getFirst());
        Assert.assertNotNull(o.getNumber2().getFirst().getFirst());

        LinkedList<Integer> list = o.getNumber2().getFirst().getFirst();
        Assert.assertEquals(3, list.size());

        Assert.assertEquals(50, list.get(0).intValue());
        Assert.assertEquals(51, list.get(1).intValue());
        Assert.assertEquals(52, list.get(2).intValue());
    }

    @Test
    public void test_022_list_struct() throws Exception {
        String xml
            = "<x><records><n>"
            + "<number0>50</number0>"
            + "<number1>51</number1>"
            + "<number2 key=\"abc\" value=\"52\"/>"
            + "</n></records></x>";
        printLine(xml);
        SimpleList o = mapper.map(SimpleList.Create(), xml);
        Assert.assertNotNull(o.getRecords());
        Assert.assertEquals(1, o.getRecords().size());
        SimpleRecord record = o.getRecords().get(0);

        Assert.assertEquals(50, record.getNumber0().intValue());
        Assert.assertEquals(51, record.getNumber1().intValue());
        Assert.assertEquals(52, record.getNumber2().intValue());
    }

    @Test
    public void test_023_list_dict() throws Exception {
        String xml
            = "<x><number2><n>"
            + "<int32 key=\"0\" value=\"50\"/>"
            + "<int32 key=\"1\" value=\"51\"/>"
            + "<int32 key=\"2\" value=\"52\"/>"
            + "</n></number2></x>";
        printLine(xml);
        SimpleListDict o = mapper.map(SimpleListDict.Create(), xml);
        Assert.assertNotNull(o.getNumber2());
        Assert.assertEquals(1, o.getNumber2().size());
        Map<Integer, Integer> map = o.getNumber2().get(0);

        Assert.assertEquals(3, map.size());
        Assert.assertEquals(Integer.valueOf(50), map.get(0));
        Assert.assertEquals(Integer.valueOf(51), map.get(1));
        Assert.assertEquals(Integer.valueOf(52), map.get(2));
    }

    @Test
    public void test_024_list_dict() throws Exception {
        String xml
            = "<x><enums><n>"
            + "<n value=\"Red\"><key>100</key></n>"
            + "<n key=\"101\" value=\"Green\"/>"
            + "<n key=\"102\" value=\"Blue\"/>"
            + "</n></enums></x>";
        printLine(xml);
        SimpleListDict o = mapper.map(SimpleListDict.Create(), xml);
        Assert.assertNotNull(o.getEnums());
        Assert.assertEquals(1, o.getEnums().size());

        Map<Color, Color> map = o.getEnums().get(0);
        Assert.assertEquals(3, map.size());

        Assert.assertEquals(Color.Red, map.get(Color.Red));
        Assert.assertEquals(Color.Green, map.get(Color.Green));
        Assert.assertEquals(Color.Blue, map.get(Color.Blue));
    }

    @Test
    public void test_031_dict_struct() throws Exception {
        String xml
            = "<x><numbers>"
            + "<entry number0=\"50\"><key>0</key></entry>"
            + "<entry key=\"1\" number0=\"51\"/>"
            + "<entry key=\"2\" number0=\"52\"/>"
            + "</numbers></x>";
        printLine(xml);
        SimpleDict o = mapper.map(SimpleDict.Create(), xml);
    }

    @Test
    public void test_032_dict_struct() throws Exception {
        mapper.setShortenMapEntry(false);
        String xml
            = "<x><numbers>"
            + "<k1 v=\"0\"/>"
            + "<v1 number0=\"50\"/>"
            + "<k1 v=\"1\"/>"
            + "<v1 number0=\"51\"/>"
            + "<k1 v=\"2\"/>"
            + "<v1 number0=\"52\"/>"
            + "</numbers></x>";
        printLine(xml);
        SimpleDict o = mapper.map(SimpleDict.Create(), xml);
        mapper.setShortenMapEntry(true);
    }

    @Test
    public void test_033_dict_pointer() throws Exception {
        String xml
            = "<x><dict14>"
            + "<a>50</a>"
            + "<b>51</b>"
            + "<c>52</c>"
            + "</dict14></x>";
        printLine(xml);
        TestPointer o = mapper.map(TestPointer.Create(), xml);
    }


    static private void printLine(String s) {
        System.out.println("+ " + s);
    }
}
