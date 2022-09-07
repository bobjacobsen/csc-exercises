## ProfileStatsCpp: Practice tuning a small C++ application

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Get some practice improving the performance of a C++ application

First, do some setup:

```
    cd ProfileStatsCpp
    source setup.sh
```

This is the equivalent of
<a href="ProfileStatsJava.md">ProfileStatsJava</a>,
except using a basic C++ program and gprof for profiling.

The directory contains a Stats class, which computes various statistical quantities from an array of integers.

Our goal is to calculate the standard deviation of the median of N numbers chosen at random from a uniform distribution.
(You probably already know how to just calculate the standard deviation of the mean, so instead we're asking about the properties of the median, which you probably don't know how to directly calculate)

For example, if we take the median of 11 random numbers that are each between 0 and 1, the median will fluctuate a little because the random numbers vary from run to run.
We've written a program to measure the standard deviation of that fluctuation.

The program throws a array of random numbers, calculates the median,
and remembers that result.
It then repeats that a bunch of times with different random numbers so that it can
measure the statistical variation in the median.

To compile the program

```
  g++ -std=c++11 -pg -g Stats.cpp
```

The Stats program takes two arguments:

```
  time ./a.out 500 1001
```
The first argument is the number of times to repeat the median calculation
(e.g. number of sets of set of random data to generate and find the median from) for use in calculating the standard deviation.
In this example, we repeat the calculation 500 times.
(As you make the program faster, you may want
to increase this so that you can still get good sampling of the performance)

The second argument is the number of random numbers in a sample,
e.g. we're calculating the median of 1001 numbers each time.

Write down how long this took, we'll use that number later. For example,
your machine might take 3.4 user (CPU) seconds when the arguments are 500 and 1001.

The Stats class is correct, but it is much too slow.

You can see how this works in the main() routine in Stats.cpp.

To get a profile after running the program:

```
  gprof -l -b a.out
```

(The -l asks for a line-by-line listing.  Try it without -b to see what that does!)

The goal is to reduce the total time needed to find the mean variance from 500 iterations of finding the median of 100,001 numbers,
e.g. to print the correct stddev-median value while using the smallest possible CPU time as measured by:

```
  time ./a.out 500 100001
```

The program doesn't need to do anything else.

Note that this is a test of how the Stats class does over 100,001 entries, a factor of 100 more numbers than you initially ran.
This is a particularly difficult test when you consider that the time taken goes as (some) power of the problem size!
You need to make some big improvements.  But you'll also have to make sure that the output of the program is correct.
There are some hints at the bottom.

I suggest you start by looking at where the program is spending its time. See if you can
improve that.  There are some obvious hot spots that will help you make progress.

Don't forget to recompil after changing the program!

Once you've fixed the examples of poor coding, try increasing the sample size by a factor of 4, e.g.

```
  time ./run 500 4001
```

How much longer should that take?  How should finding the median scale with number of samples?  Is that what you observe? If not, can you find and fix the problem?

To add some interest, we provide some historical idea of how far students at previous CSCs have
managed to push the performance:

 - If "time ./run 500 1001" with the original code takes about 3.5 seconds or so
 - then "time ./run 500 100001", our goal, takes way too long to wait for with the original code.
 - Basic profiling work should get you to about 25-28 seconds for the "time ./run 500 100001" goal
 - Under 20 seconds requires significant work. It's possible, but is it worth it?

Note that these are with one specific machine: For your tests, take the timing from the "time ./run 500 1001" and use ratios from that time:  "It got a factor of two faster!"

But for this improved performance to matter, remember that the program must still be correct!

 - The Stats class has to still to produce correct results (should you add some tests?)
 - The program still has to find the correct value (within statistical fluctuations)
of the variance of the median for any input values, especially including other test cases like 200 and 50001.

And because this is a test of the algorithm's speed, improvements in e.g. the random number generators that feed the test really don't count as speeding up the algorithm.

If you get a version that you think is really good, please
email your .cpp file(s) to <a href="mailto:jacobsen@berkeley.edu?subject=CSC-ex4">jacobsen@berkeley.edu</a>
so we can take a look at it
(and it helps if you put both team members names in the email!)

### Hints

 - It's really hard to write your own sort algorithm and have it be faster than
one done by experts.
See (<a href="https://xkcd.com/1185/">XKCD's set of custom sorts</a>)
 - One thing to look for is unnecessary work.  In that case, you don't need to make that work faster, you should just remove it.
 - For more info on gprof, see the man page and [the manual](https://sourceware.org/binutils/docs/gprof/).

