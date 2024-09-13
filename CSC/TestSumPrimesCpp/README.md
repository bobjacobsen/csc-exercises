## Testing SumPrimes in C++

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Gain familiarity with a typical test framework

First, set up the local environment:
```
   cd TestSumPrimesCpp
   source setup.sh
```

You'll find our sum-of-primes example in the file SumPrimes.cpp.  It's been recast as a C++ class. To compile and run it, hopefully printing the sum of primes in the 1st 7 integers, do:

```
   ./build
   ./SumPrimes 7
```
(As we discussed in class, the original code doesn't work correctly.)

If you want to see the actual compilation commands used, look inside the "build" file. Note that this is just recompiling specific files and leaving the resulting executable in the current directory. This is a fine approach in a simple project like this exercise; larger projects will use some form of "make" tool to do this smarter and more efficiently.

The file TestSumPrimes.cpp contains the code to setup CppUnit, plus a single test. Take a look at it, and see if you understand what it contains. You can run it with

```
  ./build
  ./TestSumPrimes
```

In its initial form, the test just makes sure that you can create a SumPrimes object, and passes. That gives the "OK" response.

There are commented-out tests that will check specific test cases, and therefore fail in the manner we discussed in lecture. Remove the leading // that comments out those lines, and watch the test fail when you run it:

```
  (edit the TestSumPrimes.cpp file)
  (edit the TestSumPrimes.h file)
  ./build
  ./TestSumPrimes
```

Isn't that "FAILURES!!!" message ugly? Now fix the bug(s) (See below for hints), and see the lovely "OK" again. Finally, add a couple more tests to check other ranges. (The sum of primes from 1 to 20 inclusive is 77, for example)

Hints:

 - It might be simpler to separate development and test of the "is N prime?" code from the "check the sum over a range" code. That way you can test the two parts separately. In the "refactored" subdirectory we've provided a version of the SumPrimes and TestSumPrimes files where that's been started. Copy those to the exercise directory if you'd like to see if that's an easier way to work. You might want to add additional tests to TestSumPrimes.

 - It's OK for a prime number to be divisible by 1.

 - If you try to divide a prime number by itself, you'll find that the remainder is zero.

 - For more information on C++ math routines like floor(...), round(...), sqrt(...), etc please see the <a href="https://cplusplus.com/reference/cmath/sqrt/">cmath doc page</a>.
