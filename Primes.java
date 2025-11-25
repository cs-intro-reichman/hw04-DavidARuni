public class Primes {
    
    static boolean [] isPrime;

    public static void main(String[] args) {

        final int n = Integer.parseInt(args[0]);
        
        //Set a new array with [f,f,t,t,...,t](n+1)
        isPrime = new boolean[n+1];
        for(int i = 2; i <= n ; i++){
            isPrime[i] = true;
        }

        int start = 2;
        
        while (start * start <= n){
            
            if ( isPrime[start] ){
                crossNonPrimes(start);
            }
            start++;
        } 

        print(n);
    }
    /***
     * Take an int num and cross-out all multiplications
     * 
     * @param num : Base number to cross primes 
     */
    private static void crossNonPrimes(int num){
        // num*num -> the next number for a prime
        // i += num -> eliminates the need for if % == 0 
        for (int i = num*num; i < isPrime.length; i += num){
            isPrime[i] = false;
        }
    }

    private static void print(int n) {
        int numOfPrimes = 0; 

        System.out.println("Prime numbers up to " + n + ":");
        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                numOfPrimes++;
                System.out.println(i);
            }
        }

        int per = (int)(100 * numOfPrimes / n);
        System.out.println("There are " + numOfPrimes + 
                        " primes between 2 and " + n + 
                        " (" + per + "% are primes)");

    }
}