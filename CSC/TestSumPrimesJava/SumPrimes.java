
public class SumPrimes {

    int sumPrimes(int largest) {
        // return the sum of prime numbers less than or equal to argument
        // (Hint: sometimes comments are wrong, and the test is really the definition)
        int sum = 0;
        for ( int i=0; i < largest; i++ ) {  // loop over possible primes
            boolean prime = true;
                for (int j=1; j < 10; j++) { // loop over possible factors; would <= Math.sqrt(value) be better?
            if (i % j == 0) prime = false;
            }
            if (prime) sum += i;
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



