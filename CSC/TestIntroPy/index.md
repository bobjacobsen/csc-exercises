## Unit Testing in Python with PyUnit

Reminder: If there's been a correction to this exercise posted, update your local copy via [these instructions](https://docs.google.com/document/d/1g3b2e7wf3mWaIZ4U6MkNR5B4fQuO71y6Q341LGs45HQ/edit?usp=sharing) before proceeding.

Goal: Gain familiarity with PyUnit

PyUnit is a unit test framework for Python code. PyUnit is the familiar name for the Python unittest built-in module. As such, it cleanly integrates with the Python module system. In this exercise, we're going to focus on writing and running simple PyUnit tests.

Start by doing some set up:

```
    cd TestIntroPy
    source setup.sh
```

Let's run a very simple set of tests for the existing
Python string routines:

```
    python3 -m unittest TestStringMethods
```

This should print three dots while it runs, then tell you something like "Ran 3 tests in 0.000s"

Take a look at the file.  You'll see individual methods that run those three tests. They're contained in a class that inherits from <code>unittest.TestCase</code>, which tells Python that these are tests.  And the lines at the end cause the
test to be run when the file is loaded and run.

There's a line at the bottom of the 2nd test that's been commented out.
Un-comment that and run the tests again to see what a failed test looks like.
You should see an "F" instead of a period, plus information about what failed and where.

You can also use module, class and method syntax to run just one specific test method:

```
    python3 -m unittest TestStringMethods.TestStringMethods.test_split
```

This can be really useful if you've just fixed a problem and want to return the specific
test that had caught it.

### Testing a module

For large projects, you might want to have your tests separate from your operational code.
Take a look at the SampleClass.py, which is a single-file module that has four methods, all very simple.
See if that all looks OK.

Even though it's very simple, it would be good to test it,
so the TestSampleClass.py test class was prepared.
To run it,
```
    python3 TestSampleClass.py
```

It will fail.  Find out what's going wrong and fix it so the tests run cleanly.

### For more information

For more information on PyUnit, please see:
 - The <a href="http://pyunit.sourceforge.net/pyunit.html">PyUnit home page</a>.
 - The
"<a href="http://pyunit.sourceforge.net/pyunit.html#USING">Using PyUnit</a>" section of the manual

- <a href="https://docs.python.org/3.6/library/unittest.html">Section 26.4 of the Python manual</a> covers the integration with Python.
