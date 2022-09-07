Java Development with Testing: Square/Cube

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Get a feel for how tests can help you develop better code faster

First, do some setup:

<CODE><PRE>
   cd exercise2
   source setup.sh
</PRE></CODE>

The program is meant to count the numbers that are both exact squares (the square of an integer, such as 9 and 16) and exact cubes (the cube of an integer, such as 27 and 64) within a given range. I've started development for you by sketching out the class <code>FindVals</code>, along with a test suite in the <code>TestFindVals</code> class.

<code>numInRange</code> is the primary method this class will provide to users; that's the one that people will invoke. There are two internal service methods for calculating whether a number is an exact square (<code>isSquare</code>) and an exact cube (<code>isCube</code>). Those were created in company with some tests.

You're picking up these classes in the midst of development.
The <code>isSquare</code>
routine has been improved to the point where it passes its tests.
Unfortunately, a bug fix we made in <code>isSquare</code>
was accidentally not made in <code>isCube</code>, so <code>isCube</code> is not passing its tests.

To compile and run the test suite:

<CODE><PRE>
  ./build
  java TestFindVals
</PRE></CODE>

To get some experience with debugging using a test suite, please

 - Run the tests, and fix the failures in <code>isCube</code>.
Add some more tests if there are cases you think should be checked.

 - There are some tests of the important <code>numInRange</code> function further on in the test class,
but some of their logic hasn't been written yet.
(Hint: There are still one or more bugs in the main routines that haven't yet been found.)
Add the appropriate test logic, based on the description in each test.
Then get the <code>FindVals</code> class to pass them.

 - Add some more tests of the search range, convincing yourself that you've really got a functioning <code>FindVals</code> class.


### Hints:

 - Just before I turned this development project over to you, I added a "floor" to the isSquare calculation.  Take a look at the failing <code>isCube</code>, and note that it's different.

 - For more information on Java math routines like floor(...), round(...), sqrt(...), etc
please see the
<a href="http://download.oracle.com/javase/8/docs/api/java/lang/Math.html">Math class doc page</a>.


 - Sometimes the CPU will compute the square-root of a number like 9 and get 2.999999.  "floor" and "round" treat that result differently. Which one gives the answer you want here? (These types of problems are really, really hard to see in somebody else's code!)
