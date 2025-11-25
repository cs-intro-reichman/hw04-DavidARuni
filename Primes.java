public class Primes {
    
    static boolean [] isPrime;

    public static void main(String[] args) {

        final int n = Integer.parseInt(args[0]);
        
        //Set a new array with [f,f,t,t,...,t](n+1)
        isPrime = new boolean[n+1];
        for(int i = 2; i < n+1 ; i++){
            isPrime[i] = true;
        }

        int start = 2;
        do {
            
            if ( isPrime[start] ){
                crossNonPrimes(start);
            }
            start++;
            
        } while (start<=isPrime.length);

        print(n);
    }
    /***
     * Take an int num and cross-out all multiplications
     * 
     * @param num : Base number to cross primes 
     */
    private static void crossNonPrimes(int num){
        for (int i = num; i < isPrime.length; i++){
            if(isPrime[i] && i % num == 0){
                isPrime[i] = false;
            }
        }
    }

    private static void print(int n){
        int numOfPrimes = 0; 
        for(int i = 0; i < isPrime.length; i++){
            if (isPrime[i]){
                numOfPrimes++;
                System.out.println(i);
            }
        }
        int per = (int)(100 * numOfPrimes / n );
        System.err.println("There are " + numOfPrimes + " primes between 2 and " + n + ". (" + per + "% are primes)");
    }
}