package invar;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by wangkang on 5/20/16
 */
public class InvarTest extends TestCase {


    public InvarTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(InvarTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testInvarMain() {
        final String prefix = "example/code/";
        Invar.main(new String[]{"-rule", "example/rule/",
                "-xsd", prefix + "xsd/",
                "-csharp", prefix + "csharp/",
                //"-java", prefix + "java/",
                "-objc", prefix + "objc/",
                //"-cpp", prefix + "cpp/",
                "-python", prefix + "python/",
                "-php", prefix + "php/",
                //"-flash", prefix + "flash/",
        });
    }
}
