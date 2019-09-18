/**
 * Stats.java
 * 
 * Form statistical measures of an array of numbers
 */

import java.util.Vector;
import java.util.Arrays;
import java.lang.Math;

public class Stats {
    
    public Stats( double val[] ) {
        values = val;
    }
    
    public double mean() {
        double sum = 0;
        for (int i = 0; i< values.length; i++) sum += values[i];
        return sum/values.length;
    }
    
    public double median() {
        // Since we only need to have the first half of the 
        // sorted results, we use a manual sort
        // instead of sorting the array with the Java sort, e.g.
        // The original version of the program said:
        //       Arrays.sort(values);
        //       return values[values.length/2];
        // but that sorts the entire array, and we only need
        // to sort until we know the half-way point
        
        return values[sortHalfValues().length/2];
    }
    
    public double[] sortHalfValues() {
        for (int i=0; i<values.length/2+1; i++) { // stop sort early to save time!
            for (int j=values.length-2; j>=0; j--) {
                // check that the jth value is smaller than j+1th,
                // else swap
                if (values[j]>values[j+1]) {
                    // swap
                    double temp = values[j];
                    values[j] = values[j+1];
                    values[j+1] = temp;
                }
            }
        }
        return values;
    }
    
    public double stddev() {
        double sum = 0;
        for (int i = 0; i< values.length; i++) {
            sum += Math.pow(values[i]-mean(),2);
        }
        return Math.sqrt(sum/(values.length-1));
    }
    
    // data members
    double values[];
    
    
    // add a main() routine to this class to use as 
    // a small test program.  It takes two arguments:
    //  java Stats 1000 200
    // will create loop for 1000 times, each time
    // calculating the statistics of 201 randomly-chosen numbers.
    static public void main(String[] args) {
        // main program prints the stddev of the median of a set of randoms
        int nRuns = Integer.parseInt(args[0]);
        int nSamples = Integer.parseInt(args[1]);
        
        // save results of the statistics values for each run
        double[] medians = new double[nRuns];
        double[] means   = new double[nRuns];
        double[] stddevs = new double[nRuns];
        
        // loop of runs to calculate statistics for a particular sample
        for (int i=0; i<nRuns; i++) { 
            // first, create new sample array of nSamples random values
            double[] vals = new double[nSamples];
            for (int j=0; j<vals.length; j++) {
                vals[j] = Math.random();
            }
            
            // calculate statistics from that array
            Stats s = new Stats(vals);
            // store the results from this run into the arrays that hold all runs
            medians[i] = s.median();
            means[i] = s.mean();
            stddevs[i] = s.stddev();
        }
	
        // have array of individual run statistics, calculate statistics over those
        Stats m = new Stats(medians);
        
        System.out.println("Results: mean median = "+m.mean()+
			   " stddev median = "+m.stddev());
        
        Stats n = new Stats(stddevs);
        System.out.println("         mean stddev = "+n.mean()+
			   " stddev stddev = "+n.stddev());
        
        Stats t = new Stats(means);
        System.out.println("         mean mean = "+t.mean()+
			   " stddev mean = "+t.stddev());
    }
}

