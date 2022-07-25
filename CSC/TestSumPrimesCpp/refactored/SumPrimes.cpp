
bool isPrime(int n) {
        bool prime = true;
        for (int j=1; j < 10; j++) { // loop over possible factors
            if (n % j == 0) prime = false;
        }
        return prime;
}

int sumPrimes(int n) {
    int sum = 0;
    for ( int i=1; i < n; i++ ) {  // loop over possible primes
        if (isPrime(i)) sum += i;
    }
    return sum;
}


