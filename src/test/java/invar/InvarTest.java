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
        final String prefix = "target/example-code-gen/";
        Invar.main(new String[]{"-rule", "res/example/rule/",
                "-xsd", prefix + "xsd/",
                "-csharp", prefix + "csharp/",
                "-java", prefix + "java/",
                "-objc", prefix + "objc/",
                "-cpp", prefix + "cpp/",
                "-php", prefix + "php/",
                //"-flash", prefix + "flash/",
        });
    }
}
