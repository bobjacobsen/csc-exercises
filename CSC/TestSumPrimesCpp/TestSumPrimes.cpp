#include <cppunit/config/SourcePrefix.h>
#include "TestSumPrimes.h"

#include "SumPrimes.cpp"

CPPUNIT_TEST_SUITE_REGISTRATION( TestSumPrimes );

void TestSumPrimes::testOneIsNotPrime() {
  CPPUNIT_ASSERT_EQUAL(0, sumPrimes(1));
}

// void TestSumPrimes::testTwoIsPrime() { // 2 is prime
//   CPPUNIT_ASSERT_EQUAL(2, sumPrimes(2));
// }

// void TestSumPrimes::testThreeIsPrime() { // 3 is prime
//  CPPUNIT_ASSERT_EQUAL(5, sumPrimes(3));
// }

// void TestSumPrimes::testFourIsNotPrime() {
//   CPPUNIT_ASSERT_EQUAL(5, sumPrimes(4));
// }

// void TestSumPrimes::testTenIsNotPrime() {
//   CPPUNIT_ASSERT_EQUAL(17, sumPrimes(10));
// }

// void TestSumPrimes::testElevenIsPrime() {
//   CPPUNIT_ASSERT_EQUAL(28, sumPrimes(11));
// }

// void TestSumPrimes::testTwelve() {
//   CPPUNIT_ASSERT_EQUAL(28, sumPrimes(12));
// }

