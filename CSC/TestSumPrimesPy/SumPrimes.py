import math
import sys

def sumPrimes(n) :
    sum = 0;
    for i in range(1, n):   # loop over possible primes
        prime = True;
        for j in range(1, 10):  # loop over possible factors
            if (i % j == 0) : prime = False;
        if (prime) : sum += i;
    return sum;
