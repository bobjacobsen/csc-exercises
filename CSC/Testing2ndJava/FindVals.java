/**
 * FindVals.java
 *
 * Sample, simple class to show how tests work
 *
 * This class searches for numbers that are both squares
 * and cubes.  OK, not such a hard thing to do ...
 *
 */

import java.util.Vector;
import java.util.Arrays;
import java.lang.Math;

public class FindVals {

    public FindVals( ) {
    }

    // Determine how many numbers in an inclusive range
    // are both squares and cubes of integers
    public int numInRange(int low, int high) {
        int num = 0;
        for (int i=low; i<high; i++)
            if (isSquare(i) && isCube(i)) num++;
        return num;
    }

    // Test whether an number is a square
    boolean isSquare(int val) {
        double root = Math.floor(Math.pow(val, 0.5));
        if (Math.abs(root*root - val) < 1.E-6 ) return true;
        else return false;
    }

    boolean isCube(int val) {
        double root = Math.pow(val, 1./3.);
        if (Math.abs(root*root*root-val) < 1.E-6 ) return true;
        else return false;
    }
}
