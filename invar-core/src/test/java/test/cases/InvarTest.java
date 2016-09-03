package test.cases;
///*

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import test.simple.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class InvarTest {

    private void print(String s) {
        System.out.print("| ");
        System.out.println(s.trim());
    }

    @Test
    public void test_001_SingleInt08() throws IOException {
        SingleInt8 o = SingleInt8.Create();
        o.setNumber(-128);
        Assert.assertEquals(o.getNumber().intValue(), -128);
        o.setNumber(127);
        Assert.assertEquals(o.getNumber().intValue(), 127);

        ByteArrayOutputStream out = new ByteArrayOutputStream(4);
        o.write(out);
        Assert.assertEquals(1, out.size());
        Assert.assertEquals(127, out.toByteArray()[0]);

        byte[] bytes = out.toByteArray();
        SingleInt8 inp = o.reuse();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals("{\"number\":127}", inp.toStringJSON().trim());
        Assert.assertEquals("<SingleInt8 number=\"127\"/>", inp.toStringXML());

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }

    @Test
    public void test_002_SingleInt16() throws IOException {
        SingleInt16 o = SingleInt16.Create();
        o.setNumber(-32768);
        Assert.assertEquals(o.getNumber().intValue(), -32768);
        o.setNumber(32767);
        Assert.assertEquals(o.getNumber().intValue(), 32767);

        ByteArrayOutputStream out = new ByteArrayOutputStream(4);
        o.write(out);
        Assert.assertEquals(2, out.size());
        byte[] bytes = out.toByteArray();
        Assert.assertEquals(127, bytes[0]);
        Assert.assertEquals(-1, bytes[1]);

        SingleInt16 inp = SingleInt16.Create();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals("{\"number\":32767}", inp.toStringJSON().trim());
        Assert.assertEquals("<SingleInt16 number=\"32767\"/>", inp.toStringXML());

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }

    @Test
    public void test_003_SingleInt32() throws IOException {
        SingleInt32 o = SingleInt32.Create();
        o.setNumber(Integer.MIN_VALUE);
        Assert.assertEquals(o.getNumber().intValue(), -2147483648);
        o.setNumber(Integer.MAX_VALUE);
        Assert.assertEquals(o.getNumber().intValue(), 2147483647);

        ByteArrayOutputStream out = new ByteArrayOutputStream(4);
        o.write(out);
        Assert.assertEquals(4, out.size());
        byte[] bytes = out.toByteArray();
        Assert.assertEquals(127, bytes[0]);
        Assert.assertEquals(-1, bytes[1]);
        Assert.assertEquals(-1, bytes[2]);
        Assert.assertEquals(-1, bytes[3]);

        SingleInt32 inp = SingleInt32.Create();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals("{\"number\":2147483647}", inp.toStringJSON().trim());
        Assert.assertEquals("<SingleInt32 number=\"2147483647\"/>", inp.toStringXML());

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }

    @Test
    public void test_004_SingleInt64() throws IOException {
        SingleInt64 o = SingleInt64.Create();
        o.setNumber(Long.MIN_VALUE);
        Assert.assertEquals(o.getNumber().longValue(), 0x8000000000000000L);
        o.setNumber(Long.MAX_VALUE);
        Assert.assertEquals(o.getNumber().longValue(), 0x7FFFFFFFFFFFFFFFL);

        ByteArrayOutputStream out = new ByteArrayOutputStream(8);
        o.write(out);
        Assert.assertEquals(8, out.size());
        byte[] bytes = out.toByteArray();
        Assert.assertEquals(127, bytes[0]);
        Assert.assertEquals(-1, bytes[1]);
        Assert.assertEquals(-1, bytes[2]);
        Assert.assertEquals(-1, bytes[3]);
        Assert.assertEquals(-1, bytes[4]);
        Assert.assertEquals(-1, bytes[5]);
        Assert.assertEquals(-1, bytes[6]);
        Assert.assertEquals(-1, bytes[7]);

        SingleInt64 inp = SingleInt64.Create();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals("{\"number\":9223372036854775807}", inp.toStringJSON().trim());
        Assert.assertEquals("<SingleInt64 number=\"9223372036854775807\"/>", inp.toStringXML());

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }

    @Test
    public void test_005_SingleUInt08() throws IOException {
        SingleUInt8 o = SingleUInt8.Create();
        o.setNumber(0);
        Assert.assertEquals(o.getNumber().intValue(), 0);
        o.setNumber(255);
        Assert.assertEquals(o.getNumber().intValue(), 255);

        ByteArrayOutputStream out = new ByteArrayOutputStream(4);
        o.write(out);
        Assert.assertEquals(1, out.size());
        Assert.assertEquals(-1, out.toByteArray()[0]);

        byte[] bytes = out.toByteArray();
        SingleUInt8 inp = o.reuse();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals("{\"number\":255}", inp.toStringJSON().trim());
        Assert.assertEquals("<SingleUInt8 number=\"255\"/>", inp.toStringXML());

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }

    @Test
    public void test_006_SingleUInt16() throws IOException {
        SingleUInt16 o = SingleUInt16.Create();
        o.setNumber(0);
        Assert.assertEquals(o.getNumber().intValue(), 0);
        o.setNumber(65535);
        Assert.assertEquals(o.getNumber().intValue(), 65535);

        ByteArrayOutputStream out = new ByteArrayOutputStream(4);
        o.write(out);
        Assert.assertEquals(2, out.size());
        Assert.assertEquals(-1, out.toByteArray()[0]);
        Assert.assertEquals(-1, out.toByteArray()[0]);

        byte[] bytes = out.toByteArray();
        SingleUInt16 inp = o.reuse();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals("{\"number\":65535}", inp.toStringJSON().trim());
        Assert.assertEquals("<SingleUInt16 number=\"65535\"/>", inp.toStringXML());

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }

    @Test
    public void test_007_SingleUInt32() throws IOException {
        SingleUInt32 o = SingleUInt32.Create();
        o.setNumber(0L);
        Assert.assertEquals(o.getNumber().intValue(), 0);
        o.setNumber(0xFFFFFFFFL);
        Assert.assertEquals(o.getNumber().intValue(), 0xFFFFFFFF);
        Assert.assertEquals(o.getNumber().longValue(), 0xFFFFFFFFL);
        ByteArrayOutputStream out = new ByteArrayOutputStream(4);
        o.write(out);
        Assert.assertEquals(4, out.size());
        byte[] bytes = out.toByteArray();
        Assert.assertEquals(-1, bytes[0]);
        Assert.assertEquals(-1, bytes[1]);
        Assert.assertEquals(-1, bytes[2]);
        Assert.assertEquals(-1, bytes[3]);
        SingleUInt32 inp = SingleUInt32.Create();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals("{\"number\":4294967295}", inp.toStringJSON().trim());
        Assert.assertEquals("<SingleUInt32 number=\"4294967295\"/>", inp.toStringXML());

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }

    @Test
    public void test_008_SingleUInt64() throws IOException {
        SingleUInt64 o = SingleUInt64.Create();
        o.setNumber(BigInteger.valueOf(0L));
        Assert.assertEquals(o.getNumber().longValue(), 0);
        o.setNumber(new BigInteger("18446744073709551615", 10));
        Assert.assertEquals(o.getNumber().toString(), "18446744073709551615");
        ByteArrayOutputStream out = new ByteArrayOutputStream(8);
        o.write(out);
        Assert.assertEquals(8, out.size());
        byte[] bytes = out.toByteArray();
        Assert.assertEquals(-1, bytes[0]);
        Assert.assertEquals(-1, bytes[1]);
        Assert.assertEquals(-1, bytes[2]);
        Assert.assertEquals(-1, bytes[3]);
        Assert.assertEquals(-1, bytes[4]);
        Assert.assertEquals(-1, bytes[5]);
        Assert.assertEquals(-1, bytes[6]);
        Assert.assertEquals(-1, bytes[7]);
        SingleUInt64 inp = SingleUInt64.Create();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals("{\"number\":18446744073709551615}", inp.toStringJSON().trim());
        Assert.assertEquals("<SingleUInt64 number=\"18446744073709551615\"/>", inp.toStringXML());

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }


    @Test
    public void test_009_SingleFloat32() throws IOException {
        SingleFloat32 o = SingleFloat32.Create();
        o.setNumber(3.14f);
        Assert.assertEquals(o.getNumber().doubleValue(), 3.14, 0.0001);

        ByteArrayOutputStream out = new ByteArrayOutputStream(4);
        o.write(out);
        Assert.assertEquals(4, out.size());
        byte[] bytes = out.toByteArray();
        Assert.assertEquals(64, bytes[0]);
        Assert.assertEquals(72, bytes[1]);
        Assert.assertEquals(-11, bytes[2]);
        Assert.assertEquals(-61, bytes[3]);

        SingleFloat32 inp = SingleFloat32.Create();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals("{\"number\":3.14}", inp.toStringJSON().trim());
        Assert.assertEquals("<SingleFloat32 number=\"3.14\"/>", inp.toStringXML());

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }

    @Test
    public void test_010_SingleFloat64() throws IOException {
        SingleFloat64 o = SingleFloat64.Create();
        o.setNumber(3.141592654);
        Assert.assertEquals(o.getNumber(), 3.141592654, 0.0000000001);
        ByteArrayOutputStream out = new ByteArrayOutputStream(8);
        o.write(out);
        Assert.assertEquals(8, out.size());
        byte[] bytes = out.toByteArray();
        Assert.assertEquals(64, bytes[0]);
        Assert.assertEquals(9, bytes[1]);
        Assert.assertEquals(33, bytes[2]);
        Assert.assertEquals(-5, bytes[3]);
        Assert.assertEquals(84, bytes[4]);
        Assert.assertEquals(82, bytes[5]);
        Assert.assertEquals(69, bytes[6]);
        Assert.assertEquals(80, bytes[7]);

        SingleFloat64 inp = SingleFloat64.Create();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals("{\"number\":3.141592654}", inp.toStringJSON().trim());
        Assert.assertEquals("<SingleFloat64 number=\"3.141592654\"/>", inp.toStringXML());

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }

    @Test
    public void test_011_Numbers() throws IOException {
        Numbers o = Numbers.Create();
        o.setNumber0(Byte.valueOf((byte) 10));
        o.setNumber1(Short.valueOf((short) 11));
        o.setNumber0(10);
        o.setNumber1(11);
        o.setNumber2(12);
        o.setNumber3(13L);
        o.setNumber4(14);
        o.setNumber5(15);
        o.setNumber6(16L);
        o.setNumber7(BigInteger.valueOf(17L));
        o.setNumber8(18.0f);
        o.setNumber9(19.0);
        ByteArrayOutputStream out = new ByteArrayOutputStream(4);
        o.write(out);
        Assert.assertEquals(42, out.size());
        byte[] bytes = out.toByteArray();
        Numbers inp = o.reuse();
        inp.read(new ByteArrayInputStream(bytes));
        Assert.assertEquals(10, inp.getNumber0().byteValue());
        Assert.assertEquals(11, inp.getNumber1().shortValue());
        Assert.assertEquals(12, inp.getNumber2().intValue());
        Assert.assertEquals(13, inp.getNumber3().longValue());
        Assert.assertEquals(14, inp.getNumber4().shortValue());
        Assert.assertEquals(15, inp.getNumber5().intValue());
        Assert.assertEquals(16, inp.getNumber6().longValue());
        Assert.assertEquals(17, inp.getNumber7().longValue());
        Assert.assertEquals(18.0, inp.getNumber8().doubleValue(), 0.00001);
        Assert.assertEquals(19.0, inp.getNumber9(), 0.00001);

        print(inp.toStringJSON());
        print(inp.toStringXML());
    }

}
//*/