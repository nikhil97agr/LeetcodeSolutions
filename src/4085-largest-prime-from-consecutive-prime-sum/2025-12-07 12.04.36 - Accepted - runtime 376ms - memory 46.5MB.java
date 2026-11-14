class Solution {
    public int largestPrime(int n) {
        boolean primes[] = new boolean[n+1];
        Arrays.fill(primes, true);

        primes[0] = primes[1] = false;
        for(int i=2;i<=n;i++){
            if(primes[i]){
                int next = i + i;
                while(next <= n){
                    primes[next] = false;
                    next+=i;
                }
            }
        }

        if(n==1) return 0;
        int num = 0;
        int ans = 0;
        for(int i=2;i<=n;i++){
            if(primes[i]){
                if(num + i > n) return ans;

                num += i;
                if(primes[num]){
                    ans = num;
                }
            }
        }

        return ans;
    }
}