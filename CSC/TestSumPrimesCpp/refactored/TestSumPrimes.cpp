
#include <cppunit/config/SourcePrefix.h>
#include "TestSumPrimes.h"

#include "SumPrimes.cpp"

CPPUNIT_TEST_SUITE_REGISTRATION( TestSumPrimes );




void TestSumPrimes::testOneIsNotPrime() {
  CPPUNIT_ASSERT(!isPrime(1));
}

void TestSumPrimes::testTwoIsPrime() { // 2 is prime
  CPPUNIT_ASSERT(isPrime(2));
}

void TestSumPrimes::testThreeIsPrime() { // 3 is prime
 CPPUNIT_ASSERT(isPrime(3));
}

void TestSumPrimes::testFourIsNotPrime() {
  CPPUNIT_ASSERT(!isPrime(4));
}

void TestSumPrimes::testTenIsNotPrime() {
  CPPUNIT_ASSERT(!isPrime(10));
}

void TestSumPrimes::testElevenIsPrime() {
  CPPUNIT_ASSERT(isPrime(11));
}

void TestSumPrimes::testTwelveIsNotPrime() {
  CPPUNIT_ASSERT(!isPrime(12));
}



void TestSumPrimes::testSumOfOne() {
  CPPUNIT_ASSERT_EQUAL(0, sumPrimes(1));
}

void TestSumPrimes::testSumOfTwo() { // 2 is prime
  CPPUNIT_ASSERT_EQUAL(2, sumPrimes(2));
}

void TestSumPrimes::testSumOfThree() { // 3 is prime
 CPPUNIT_ASSERT_EQUAL(5, sumPrimes(3));
}

void TestSumPrimes::testSumOfFour() {
  CPPUNIT_ASSERT_EQUAL(5, sumPrimes(4));
}

void TestSumPrimes::testSumOfTen() {
  CPPUNIT_ASSERT_EQUAL(17, sumPrimes(10));
}

void TestSumPrimes::testSumOfEleven() {
  CPPUNIT_ASSERT_EQUAL(28, sumPrimes(11));
}

void TestSumPrimes::testSumOfTwelve() {
  CPPUNIT_ASSERT_EQUAL(28, sumPrimes(12));
}

