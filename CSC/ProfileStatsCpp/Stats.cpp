/**
 * Stats
 *
 * Form statistical measures of an array of numbers
 */
#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <algorithm>
#include <unistd.h>
#include <math.h>

#include <iostream>
using namespace std;

    void sortHalfValues(double *values, int length);

    double mean(double *values, int length) {
        double sum = 0;
        for (int i = 0; i< length; i++) sum += values[i];
        return sum/length;
    }

    double median(double *values, int length) {
        // Since we only need to have the first half of the
        // sorted results, we use a manual sort
        // instead of sorting the array with the std::sort, e.g.
        // The original version of the program said:
        //    std::sort(values,values+length);
        //    return values[length/2];
        // but that sorts the entire array, and we only need
        // to sort until we know the half-way point
        sortHalfValues(values, length);
        return values[length/2];
    }

    // Do a bubble sort of a vector until you've found the
    // first half of the result.  That's all that's needed
    // to find the median, so this should be faster.
    void sortHalfValues(double *values, int length) {
        for (int i=0; i<length/2+1; i++) { // stop sort early to save time!
            for (int j=length-2; j>=0; j--) {
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
    }

    double stddev(double *values, int length) {
        double sum = 0;
        for (int i = 0; i< length; i++) {
            sum += (values[i]-mean(values, length))*(values[i]-mean(values, length));
        }
        return sqrt(sum/(length-1));
    }


    // add a main() routine to this class to use as
    // a small test program.  It takes two arguments:
    //  ./Stats 1000 200
    // will create loop for 1000 times, each time
    // calculating the statistics of 201 randomly-chosen numbers.
    int
    main (int argc, char **argv)  {      // main program prints the stddev of the median of a set of randoms
        if (argc != 3) {
            cout << "Takes exactly two arguments:" << endl
                 << "   nRuns:  Number of times to repeat for performance measurement" << endl
                 << "   nSamples:  Size of data vector to process for median, mean, stddev" << endl;
            return -1;
        }

        int nRuns = atoi(argv[1]);
        int nSamples = atoi(argv[2]);

        double *vals = new double[nSamples];

        // save results of the statistics values for each run
        double *medians = new double[nRuns];
        double *means   = new double[nRuns];
        double *stddevs = new double[nRuns];

        // loop of runs to calculate statistics for a particular sample
        for (int i=0; i<nRuns; i++) {
            // first, load new sample array of nSamples random values
            for (int j=0; j<nSamples; j++) {
                vals[j] = (double)rand() / (double)RAND_MAX;
            }

            // store the results from this run into the arrays that hold all runs
            medians[i] = median(vals, nSamples);
            means[i] = mean(vals, nSamples);
            stddevs[i] = stddev(vals, nSamples);
        }

        cout << "Results: mean median = " << mean(medians, nRuns) << " stddev median = " << stddev(medians, nRuns) << endl;
        cout << "Results: mean stddev = " << mean(stddevs, nRuns) << " stddev stddev = " << stddev(stddevs, nRuns) << endl;
        cout << "Results: mean mean   = " << mean(means,   nRuns) << " stddev mean = " << stddev(means,   nRuns) << endl;

    }


