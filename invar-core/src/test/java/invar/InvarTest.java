/*
 * Copyright (c) 2016. Kang Wang. The following code is distributed under
 * the terms of the MIT license found at http://opensource.org/licenses/MIT
 */

package invar;

import org.junit.Assert;
import org.junit.Test;

public class InvarTest {

    @Test
    public void testMain() throws Exception {

        final String dirIn = "../invar-example/example/rule/";
        final String dirOut = "target/test-code-gen/";

        String[] args = new String[]{"-rule", dirIn,
            "-xsd    ", dirOut + "xsd/",
            "-cpp    ", dirOut + "cpp/",
            "-java   ", dirOut + "java/",
            "-csharp ", dirOut + "csharp/",
            "-python ", dirOut + "snippet/python/",
            "-php    ", dirOut + "php/",
            "-flash  ", dirOut + "flash/",
        };
        Invar.main(args);
        Assert.assertTrue(true);
    }

}