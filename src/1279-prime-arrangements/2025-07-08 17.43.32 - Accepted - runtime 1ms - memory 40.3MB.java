class Solution {
    public int numPrimeArrangements(int n) {
        int total = n;
        boolean prime[]= new boolean[n+1];
        Arrays.fill(prime, true);
        prime[1] = false;
        for(int i=1;i<=n;i++){
            if(prime[i]){
                total--;
                int j=i+i;

                while(j<=n){
                    prime[j]   = false;
                    j+=i;
                }
            }
        }

        int primes = n - total;

        int ans = 1;

        for(int i=1;i<=total;i++){
            ans = prod(ans, i);
        }

        for(int i=1;i<=primes;i++){
            ans = prod(ans, i);
        }

        return ans;
    }

    private int prod(int a, int b){
        long mod = (long)1e9 + 7;

        long total = 1l*a*b;

        return (int)(total%mod);
    }
}