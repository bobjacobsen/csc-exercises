## Introduction to CppUnit

This is a brief introduction to the use of CppUnit to test C++ code.

(It also makes sure your system is set up for later exercises)

To start, look at the ExampleTestCase.cpp file.  You'll see a series of tests that are structured like:

```
void ExampleTestCase::example()
{
  CPPUNIT_ASSERT_DOUBLES_EQUAL( 1.0, 1.1, 0.05 );
  CPPUNIT_ASSERT( 1 == 0 );
  CPPUNIT_ASSERT( 1 == 1 );
}
```

By inspection, some of those assertions are expected to pass, some to fail.

To run the tests:

```
./build
./a.out
```

This should provide a bunch of information on the passing and failing tests, then finish with something like:

```
Failures !!!
Run: 5   Failure total: 4   Failures: 4   Errors: 0
```

Note the basic structure:
 - There are multiple test methods, each testing one kind of thing
 - Each test method contains one or more ASSERT macros
 - The tests in the class are gathered up into a "Suite" by a CPPUNIT_TEST_SUITE_REGISTRATION macros

Now look at the ExampleTestCase.h file, which defines the structure of the class. CppUnit macros also occur there.  These are necessary because standard C++ doesn't have a reflection capability that would let CppUnit find tests at runtime; that knowledge has to be compiled in.

Fix the broken tests and get the tests to pass.  (Don't put a lot of time into it; you can just comment out the failing asserts) Notice the nice clean output when you do that.

Now add another test method.  What do you have to change to do that?  Have it fail at first, so you know it's being run, then make it pass.

Finally, take a look at Main.cpp.  This configures CppUnit with two nice forms of output, then invokes the test suite(s) you've defined. Make your tests fail again, then comment out on or the other 'addListener' lines to see how the output changes. There are multiple other formatters available too.

