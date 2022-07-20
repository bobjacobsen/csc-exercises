
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;

public class TestFindVals extends TestCase  {

    // define a series of tests

    public void testCreate() {
	    // a first test, to check machinery is working
	    FindVals s = new FindVals();
    }

    // basic tests of square, cube checks

    public void testNotSquare() {
        // numbers that aren't squares should return false
        FindVals s = new FindVals();
        Assert.assertTrue( ! s.isSquare(3) );
    }

    public void testIsSquare() {
        // numbers that are squares should return true
        FindVals s = new FindVals();
        Assert.assertTrue( "4 is a square", s.isSquare(4) );
    }

    public void testNotCube() {
        // numbers that aren't cubes should return false
        FindVals s = new FindVals();
        Assert.assertTrue( "3 is not a cube", ! s.isCube(3) );
    }

    public void testIsCube() {
        // numbers that are cubes should return true
        FindVals s = new FindVals();
        Assert.assertTrue("27 is a cube", s.isCube(27) );
    }

    public void testIsLargeCube() {
        // Vaguely worried about precision, so test larger number
        FindVals s = new FindVals();
        Assert.assertTrue("321 cubed is a cube",  s.isCube(321*321*321) );
    }

    // basic tests of the search function

    public void testUnsuccessfulSearch() {
        // test a range where no square&cube should be found
        FindVals s = new FindVals();
        Assert.assertEquals("check range 2,3 ", 0, s.numInRange(2,3) );
    }

    public void testSuccessfulSearch() {
        // test a range where a square&cube should actually exist
        FindVals s = new FindVals();
        Assert.assertEquals("check range 60,68 ", 1, s.numInRange(60,68) );
    }

    //  more advanced tests

    // test the end points of the search

    public void testLowerLimit() {
        // range is inclusive, make sure a square&cube at lower limit is seen
        FindVals s = new FindVals();
        // ... (code missing here)
    }

    public void testUpperLimit() {
        // range is inclusive, make sure a square&cube at upper limit is seen
        FindVals s = new FindVals();
        // ... (code missing here)
    }



    // from here on is testing infrastructure, no mods needed

    public TestFindVals(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {TestFindVals.class.getName()};

        // launch JUnit
        junit.textui.TestRunner.main(testCaseName);
    }

    // define test suite
    public static Test suite() {
        // all tests from here down in heirarchy
        TestSuite suite = new TestSuite(TestFindVals.class);
        return suite;
    }

}
