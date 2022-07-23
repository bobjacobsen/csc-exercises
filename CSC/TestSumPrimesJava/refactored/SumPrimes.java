
public class SumPrimes {

    boolean isPrime(int value) {
        // handle special case
        if (value == 1) return false;

        // loop over possible factors & check for division
        for (int factor = 1; factor < 10; factor++) {  // would <= Math.sqrt(value) be better?
            if (value % factor == 0) return false;
        }
        return true;
    }

    int sumPrimes(int largest) {
        // return the sum of prime numbers less than or equal to argument
        int sum = 0;
        for ( int i=2; i <= largest; i++ ) {  // loop over possible primes from 2 to largest
            if (isPrime(i)) sum += i;
        }
        return sum;
    }

    // main routine
    static public void main(String[] args) {
        if ( args.length == 0 || args[0]==null) {
            System.out.println("first argument must be the max number to check");
        }
        else {
            SumPrimes s = new SumPrimes();
            int result = s.sumPrimes(Integer.parseInt(args[0]));
            System.out.println("sumPrimes() returns "+result);
        }
    }

}



