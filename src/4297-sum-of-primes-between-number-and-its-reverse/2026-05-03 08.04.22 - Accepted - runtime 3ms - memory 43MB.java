class Solution {
    public int sumOfPrimesInRange(int n) {
        int rev = reverse(n);

        boolean primes[] = new boolean[Math.max(n, rev) + 1];

        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        int max= Math.max(n, rev);
        for(int i=2;i<=max;i++){
            if(primes[i]){
                for(int j= i + i;j<=max;j+=i){
                    primes[j] = false;
                }
            }   
        }

        int ans=0;
        for(int i=Math.min(n, rev);i<=max;i++){
            if(primes[i]){
                ans+=i;
            }
        }

        return ans;
    }

    private int reverse(int n){
        int rev = 0;
        while(n > 0){
            int dig = n%10;
            rev = rev * 10 + dig;
            n/=10;
        }

        return rev;
    }
}