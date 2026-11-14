class Solution {
    public int countPrimes(int n) {
        if(n<=2) return 0;

        boolean primes[] = new  boolean[n];

        primes[0] = primes[1] = true;
        for(int i=4;i<n;i+=2){
            primes[i] = true;
        }
        int cnt = 1;
        for(int i=3;i<n;i+=2){
            if(!primes[i]){
                cnt++;
                int j = i+i;
                while(j<n){
                    primes[j] = true;
                    j+=i;
                }
            }
        }

        
        return cnt;
    }
}