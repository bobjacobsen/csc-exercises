
import junit.framework.Test;
import junit.framework.Assert;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestStats extends TestCase  {
    public TestStats(String s) {
        super(s);
    }

    // Main entry point
    static public void main(String[] args) {
        String[] testCaseName = {TestStats.class.getName()};
        // initialize junit
        junit.textui.TestRunner.main(testCaseName);
    }

    // tests
    public void testCreate() {
        double data[] = {1., 2., 3. };
        Stats s = new Stats(data);
    }

    // This test is not required if your final Stats class
    // doesnt use sortHalfValues
    public void testSortHalfValues() {
        double data[] = {1., 2., 6. };
        Stats s = new Stats(data);
        double[] sorted = s.sortHalfValues();
        Assert.assertEquals(1.0, sorted[0], 0. );
    }

    // This test is not required if your final Stats class
    // doesnt use sortHalfValues
    public void testSortHalfValues2() {
        double data[] = {7., 6., 5., 3., 4., 2., 1. };
        Stats s = new Stats(data);
        double[] sorted = s.sortHalfValues();
        Assert.assertEquals(1.0, sorted[0], 0. );
        Assert.assertEquals(2.0, sorted[1], 0. );
        Assert.assertEquals(3.0, sorted[2], 0. );
        Assert.assertEquals(4.0, sorted[3], 0. );
    }

    public void testMean() {
        double data[] = {1., 2., 6. };
        Stats s = new Stats(data);
        Assert.assertEquals(3.0, s.mean(), 0. );
    }

    public void testMedian() {
        double data[] = {1., 2., 6., 6., 2., 1. };
        Stats s = new Stats(data);
        Assert.assertEquals(2.0, s.median(), 0. );
    }

    public void testMedian0() {
    	double data[] = {2.};
        Stats s = new Stats(data);
        Assert.assertEquals(2.0, s.median(), 0. );
    }

    public void testMedian1() {
        double data[] = {1., 1., 1., 2., 3., 3., 3. };
        Stats s = new Stats(data);
        Assert.assertEquals(2.0, s.median(), 0. );
    }

    public void testMedian2() {
        double data[] = {10., 9., 8., 7., 6., 5., 4., 3., 2., 1., 0.};
        Stats s = new Stats(data);
        Assert.assertEquals(5.0, s.median(), 0. );
    }

    public void testMedian3() {
        double data[] = {1.,1.,1.,1.,1.,1.,1.,1.,1.,1.,1.,1.,1.,1.,1.,1.,100.};
        Stats s = new Stats(data);
        Assert.assertEquals(1.0, s.median(), 0. );
    }

    public void testMedian4() {
        double data[] = {10., 9., 8., 7., 5., 5., 5., 3., 2., 1., 0.};
        Stats s = new Stats(data);
        Assert.assertEquals(5.0, s.median(), 0. );
    }

    public void testMedian5() {
        double data[] = {1.,2.,3.,4.,5.,91.,92.,93.};
        Stats s = new Stats(data);
        Assert.assertEquals(5.0, s.median(), 0. );
    }

    public void testMedian6() {
        double data[] = {0.,0.,0.,5.,5.,5.,5.};
        Stats s = new Stats(data);
        Assert.assertEquals(5.0, s.median(), 0. );
    }

    public void testMedian7() {
        double data[] = {5.,5.,5.,5.,5.};
        Stats s = new Stats(data);
        Assert.assertEquals(5.0, s.median(), 0. );
    }

    public void testMedian8() {
        double data[] = {10., 9., 8., 7., 6., 5., 4., 3., 2., 1., 0.};
        Stats s = new Stats(data);
        Assert.assertEquals(5.0, s.median(), 0. );
    }

    public void testMedianOfArray() {
        // first, create sample array of nSamples random values
        double[] vals = new double[501];
        for (int j=0; j<vals.length; j++) {
            vals[j] = Math.random();
        }

        // calculate and store statistics
        Stats s = new Stats(vals);

        double med = s.median();
        Assert.assertEquals(median(vals), s.median(), 0. );
    }

    public void testMedianArrayFast() {
	// first, create sample array of nSamples random values
	double[] vals = new double[501];
	for (int j=0; j<vals.length; j++) {
	    vals[j] = Math.random();
	}
	// calculate and check result
	fastCheck(vals);
    }

    public void testMedianLargeArrayFast() {
	// first, create sample array of nSamples random values
	double[] vals = new double[20001];
	for (int j=0; j<vals.length; j++) {
	    vals[j] = Math.random();
	}
	// calculate and check result
	fastCheck(vals);
    }

    void fastCheck(double[] vals) {
	// calculate and store statistics
	Stats s = new Stats(vals);
	double med = s.median();

	// do a quick check the result is correct
	int lower = 0;
	int higher = 0;
	for (int i=0; i<vals.length; i++) {
	    if (med>= vals[i]) higher++;
	    if (med<= vals[i]) lower++;
	}
	Assert.assertTrue("right number below", lower>(vals.length-1)/2);
	Assert.assertTrue("right number above", higher>(vals.length-1)/2);
    }

    public void testStddev() {
	double data[] = {1., 2., 3. };
	Stats s = new Stats(data);
	Assert.assertEquals(1.0, s.stddev(), 0. );
    }

    public void testStddev2() {
	double data[] = {1., 2., 3. };
	Stats s = new Stats(data);
	Assert.assertEquals(1.0, s.stddev(), 0. );
    }

    public void testBig() {
	double data[] = new double[2000];
	Stats s = new Stats(data);
	Assert.assertEquals(0.0, s.median(), 0.0 );
    }

    public void testChange() {
	double data[] = {1., 2., 6. };
	Stats s = new Stats(data);
	data[0] = 4.;
	Assert.assertEquals(4.0, s.mean(), 0.0 );
    }

    // local calculation of median used in some tests
    static public double median(double[] values) {
        java.util.Arrays.sort(values);
        return values[values.length/2];
    }

    // test suite
    public static Test suite() {

        // all tests from here down in heirarchy
        TestSuite suite = new TestSuite(TestStats.class);

        // all tests from other classes
        return suite;
    }

}
