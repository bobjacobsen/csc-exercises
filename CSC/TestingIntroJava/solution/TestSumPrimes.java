
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;

public class TestSumPrimes extends TestCase  {

    // define a series of tests

    public void testCreate() {
    	// a first test, to check machinery is working
	    SumPrimes s = new SumPrimes();
    }

    public void testOneIsNotPrime() {
      SumPrimes s = new SumPrimes();
      Assert.assertEquals("check sumPrimes(1)", 0, s.sumPrimes(1));
    }

    public void testTwoIsPrime() { // 2 is prime
      SumPrimes s = new SumPrimes();
      Assert.assertEquals("check sumPrimes(2)", 2, s.sumPrimes(2));
    }

    public void testThreeIsPrime() { // 3 is prime
     SumPrimes s = new SumPrimes();
     Assert.assertEquals("check sumPrimes(3)", 5, s.sumPrimes(3));
    }

    public void testFourIsNotPrime() {
      SumPrimes s = new SumPrimes();
      Assert.assertEquals("check sumPrimes(4)", 5, s.sumPrimes(4));
    }

    public void testTenIsNotPrime() {
      SumPrimes s = new SumPrimes();
      Assert.assertEquals("check sumPrimes(10)", 17, s.sumPrimes(10));
    }

    public void testElevenIsPrime() {
      SumPrimes s = new SumPrimes();
      Assert.assertEquals("check sumPrimes(11)", 28, s.sumPrimes(11));
    }

    public void testTwelve() {
      SumPrimes s = new SumPrimes();
      Assert.assertEquals("check sumPrimes(12)", 28, s.sumPrimes(12));
    }

    // from here on is testing infrastructure, no modifications needed

    public TestSumPrimes(String s) {
	    super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {TestSumPrimes.class.getName()};

        // launch JUnit
        junit.textui.TestRunner.main(testCaseName);
    }

    // define test suite
    public static Test suite() {
        // all tests from here down in heirarchy
        TestSuite suite = new TestSuite(TestSumPrimes.class);
        return suite;
    }

}
