## Introduction to Java Testing with JUnit

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Get a feel for how tests can help you develop better code faster

First, do some setup:

```
cd TestIntroJava
source setup.sh
```

Then look at the TestExample.java file.  You'll see a series of tests that are structured like:

```
public void testEquals() {
    Assert.assertEquals( 1, 1 );
    Assert.assertEquals( 2, 2 );
    Assert.assertEquals( 1, 2 );
}
```

By inspection, some of those assertions are expected to pass, some to fail.

To run the tests:

```
    ./build
    java TestExample
```


This should provide a bunch of information on the passing and failing tests, then finish with something like:

```
FAILURES!!!
Tests run: 4,  Failures: 4,  Errors: 0
```

Note the basic structure in the file
 - There are multiple test methods
 - Each test method contains one or more Assert statements
 - The tests in the class are gathered up into a "Suite"
 - Which are run by a simple main routine

Fix the broken tests and get the tests to pass.  (Don't put a lot of time into it; you can just comment out the failing asserts) Notice the nice clean output when you do that.

Now add another test method.  What do you have to change to do that?  Have it fail at first, so you know it's being run, then make it pass.
