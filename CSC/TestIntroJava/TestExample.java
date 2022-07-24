
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;

public class TestExample extends TestCase  {

    // define a series of basic tests

    public void testLogic() {
        Assert.assertTrue( true );
        Assert.assertTrue( 1 != 2 );
        Assert.assertTrue( 1 == 2 );
    }

    public void testEquals() {
        Assert.assertEquals( 1, 1 );
        Assert.assertEquals( 2, 2 );
        Assert.assertEquals( 1, 2 );
    }

    public void testLogicLabels() {
        Assert.assertTrue( "testing true", true );
        Assert.assertTrue( "testing 1 != 2", 1 != 2 );
        Assert.assertTrue( "testing 1 == 2", 1 == 2 );
    }

    public void testEqualsLabels() {
        Assert.assertEquals( "equals 1,1", 1, 1 );
        Assert.assertEquals( "equals 2,2", 2, 2 );
        Assert.assertEquals( "equals 1,2", 1, 2 );
    }


    // from here on is testing infrastructure, no mods needed

    public TestExample(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {TestExample.class.getName()};

        // launch JUnit
        junit.textui.TestRunner.main(testCaseName);
    }

    // define test suite
    public static Test suite() {
        // all tests from here down in heirarchy
        TestSuite suite = new TestSuite(TestExample.class);
        return suite;
    }

}
