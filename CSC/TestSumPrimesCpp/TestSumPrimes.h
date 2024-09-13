
#ifndef CPP_UNIT_EXAMPLETESTCASE_H
#define CPP_UNIT_EXAMPLETESTCASE_H

#include <cppunit/extensions/HelperMacros.h>

/*
 * A test case that to
 * test the SumPrimes class
 *
 */

class TestSumPrimes : public CPPUNIT_NS::TestFixture
{
  CPPUNIT_TEST_SUITE( TestSumPrimes );
  CPPUNIT_TEST( testOneIsNotPrime );
  // CPPUNIT_TEST( testTwoIsPrime );
  // CPPUNIT_TEST( testThreeIsPrime );
  // CPPUNIT_TEST( testFourIsNotPrime );
  // CPPUNIT_TEST( testTenIsNotPrime );
  // CPPUNIT_TEST( testElevenIsPrime );
  // CPPUNIT_TEST( testTwelve );
  CPPUNIT_TEST_SUITE_END();

protected:
  void testOneIsNotPrime();
  void testTwoIsPrime();
  void testThreeIsPrime();
  void testFourIsNotPrime();
  void testTenIsNotPrime();
  void testElevenIsPrime();
  void testTwelve();
};


#endif
