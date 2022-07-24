#include <math.h>
#include <iostream>

int sumPrimes(int n) {
    int sum = 0;
    for ( int i=2; i <= n; i++ ) {  // loop over possible primes
        bool prime = true;
        for (int j=2; j <= sqrt(i); j++) { // loop over possible factors
            if (i % j == 0) prime = false;
        }
        if (prime) sum += i;
    }
    return sum;
}
