## ProfileStatsJava: Practice tuning a small application

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.


Goal: Get some practice improving the performance of an application

First, create a local copy of the exercise files.

```
    cd ProfileStatsJava
    source setup.sh
```

The directory contains a Stats class, which computes various statistical quantities from an array of integers.
For examples of how it's used, see the tests in the TestStats class.

Our goal is to calculate the standard deviation of the median of N numbers chosen at random from a uniform distribution.
(You probably already know how to just calculate the standard deviation of the mean, so instead we're asking about the properties of the median, which you probably don't know how to directly calculate)

For example, if we take the median of 11 random numbers that are each between 0 and 1, the median will fluctuate a little because the random numbers vary from run to run.
Our goal is to write a program to measure the standard deviation of that fluctuation.

To run the test suite,

```
  ./build
  ./test
```

Note that the tests pass!  The Stats class is correct, but it is much too slow.

The Stats program takes two arguments:

```
  time ./run 500 1001
```
Write down how long this took, we'll use that number later. For example, your machine might take 23 user (CPU) seconds.

The program throws a set of random numbers, calculates the median, and remembers that result.
It then repeats that a bunch of times with different random numbers so that it can measure the statistical variation in the median.

The first argument is the number of times to repeat the median calculation (e.g. number of sets of set of random data to generate and find the median from) for use in calculating the standard deviation.
In this example, we repeat the calculation 500 times.
(As you make the program faster, you may want to increase this so that you can still get good sampling of the performance)

The second argument is the number of random numbers in a sample, e.g. we're calculating the median of 1001 numbers each time.

You can see how this works in the main() routine in Stats.java.

(Note that the 'run' script has disabled Java's run-time compilation. We've done this because the Java compiler is smart enough to compile away some of the inefficiencies in this sample program that we want you to track down yourself)

To get a profile after running the program:

```
  ./analysis
```

The goal is to reduce the total time needed to find the mean of the variance observed in each of 500 iterations of finding the median of 100,001 numbers, e.g. to print the correct stddev-median value while using the smallest possible CPU time as measured by:

```
  time ./run 500 100001
```

The program doesn't need to do anything else.

Note that this is a test of how the Stats class does over 100,001 entries, a factor of 100 more numbers than you initially ran.
This is a particularly difficult test when you consider that the time taken goes as (some) power of the problem size!
You need to make some big improvements.  But you'll also have to make sure that the output of the program is correct.
There are some hints at the bottom.

I suggest you start by looking for evidence of where the program is spending unnecessary time.
See if you can improve those places first.
There are some obvious hot spots that will help you make progress.

Don't forget to recompile with ./build after changing the program!

Once you've fixed the examples of poor coding, try increasing the sample size by a factor of 4, e.g.

```
  time ./run 500 4001
```

How much longer should that take?  How should finding the median scale with number of samples?  Is that what you observe? If not, can you find and fix the problem?


On Bob's laptop, the original program scales like:
<table border="1">
<tr><th>Run</th><th>CPU sec</th</tr>
<tr><td>time ./run 500 501</td><td>6.6</td></tr>
<tr><td>time ./run 500 1001</td><td>26</td></tr>
<tr><td>time ./run 500 2001</td><td>96</td></tr>
<tr><td>time ./run 500 4001</td><td>332</td></tr>
</table>

Is this scaling like the N ln(N) you'd expect?

Students at previous CSCs have managed to push the performance:

 - If "time ./run 500 1001" with the original code takes about 10 seconds or so
 - then "time ./run 500 100001", our goal, takes way too long to wait for with the original code.
 - Basic profiling work should get you to about 50-60 seconds for the "time ./run 500 100001" goal
 - Under 45 seconds requires care, but is possible
 - Under 30 seconds has been done but requires extraordinary effort. Is that worth it?

Note that these are with one specific machine: Since you're using a different one,
take the timing from the "time ./run 500 1001" and use ratios from that time:  "It got a factor of two faster!"

But for this improved performance to matter, remember that the program must still be correct!

 - The Stats class has to still pass all the tests
 - The program still has to find the correct value (within statistical fluctuations) of the variance of the median for any input values, especially including other test cases like 200 and 50001.

And because this is a test of the algorithm's speed, improvements in e.g. the random number generators that feed the test really don't count as speeding up the algorithm.

If you get a version that you think is pretty good, please
email your Java file(s) to <a href="mailto:jacobsen@berkeley.edu?subject=CSC-ex4">jacobsen@berkeley.edu</a>
so we can take a look at it
(and it helps if you put both team members names in the email!)

## Hints

 - It's really hard to write your own sort algorithm and have it be faster than one done by experts. See [XKCD's set of custom sorts](https://xkcd.com/1185/).
 - One thing to look for is unnecessary work.  In that case, you don't need to make it faster, you should just remove it.
 - Note: we deliberately disable optimization and the Java Just In Time (JIT) compiler to make this a tougher test of algorithm optimization.  If you turn those back on by running with defaults, your program will be a factor of 5-10 faster, but that doesn't count as improving the algorithm.
 -  Note: Java checks every array reference, which means they can be slow since we're not using the just-in-time compiler here. It also checks the stack when leaving a block, which can also be slow.
