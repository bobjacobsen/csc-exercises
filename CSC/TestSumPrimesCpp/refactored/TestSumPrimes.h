
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
  CPPUNIT_TEST( testTwoIsPrime );
  CPPUNIT_TEST( testThreeIsPrime );
  CPPUNIT_TEST( testFourIsNotPrime );
  CPPUNIT_TEST( testTenIsNotPrime );
  CPPUNIT_TEST( testElevenIsPrime );
  CPPUNIT_TEST( testTwelveIsNotPrime );

  CPPUNIT_TEST( testSumOfOne );
  CPPUNIT_TEST( testSumOfTwo );
  CPPUNIT_TEST( testSumOfThree );
  CPPUNIT_TEST( testSumOfFour );
  CPPUNIT_TEST( testSumOfTen );
  CPPUNIT_TEST( testSumOfEleven );
  CPPUNIT_TEST( testSumOfTwelve );

  CPPUNIT_TEST_SUITE_END();

protected:
  void testOneIsNotPrime();
  void testTwoIsPrime();
  void testThreeIsPrime();
  void testFourIsNotPrime();
  void testTenIsNotPrime();
  void testElevenIsPrime();
  void testTwelveIsNotPrime();

  void testSumOfOne();
  void testSumOfTwo();
  void testSumOfThree();
  void testSumOfFour();
  void testSumOfTen();
  void testSumOfEleven();
  void testSumOfTwelve();

};


#endif
