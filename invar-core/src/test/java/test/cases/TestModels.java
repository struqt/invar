/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package test.cases;

import test.simple.Numbers;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by wangkang on 12/9/16
 */
class TestModels {

    static Numbers numbersWithMinValues() {
        Numbers info = Numbers.Create();
        info.setNumber0(Byte.MIN_VALUE);
        info.setNumber1(Short.MIN_VALUE);
        info.setNumber2(Integer.MIN_VALUE);
        info.setNumber3(Long.MIN_VALUE);
        info.setNumber4(0);
        info.setNumber5(0);
        info.setNumber6(0);
        info.setNumber7(BigInteger.ZERO);
        info.setNumber8(Float.MIN_VALUE);
        info.setNumber9(Double.MIN_VALUE);
        return info;
    }

    static Numbers numbersWithMaxValues() {
        Numbers info = Numbers.Create();
        info.setNumber0(Byte.MAX_VALUE);
        info.setNumber1(Short.MAX_VALUE);
        info.setNumber2(Integer.MAX_VALUE);
        info.setNumber3(Long.MAX_VALUE);
        info.setNumber4(0xFF);
        info.setNumber5(0xFFFF);
        info.setNumber6(0xFFFFFFFFL);
        info.setNumber7(new BigInteger("FFFFFFFFFFFFFFFF", 16));
        info.setNumber8(Float.MAX_VALUE);
        info.setNumber9(Double.MAX_VALUE);
        return info;
    }

    static Numbers numbersWithRandomValues() {
        Numbers info = Numbers.Create();
        info.setNumber0(new Random().nextInt() & 0x7F);
        info.setNumber1(new Random().nextInt() & 0x7FFF);
        info.setNumber2(new Random().nextInt());
        info.setNumber3(new Random().nextLong());
        info.setNumber4(new Random().nextInt() & 0xFF);
        info.setNumber5(new Random().nextInt() & 0xFFFF);
        info.setNumber6(new Random().nextInt() & 0x0FFFFFFF);
        info.setNumber7(BigInteger.valueOf(new Random().nextLong()));
        info.setNumber8(Float.MAX_VALUE);
        info.setNumber9(Double.MAX_VALUE);
        return info;
    }

}
