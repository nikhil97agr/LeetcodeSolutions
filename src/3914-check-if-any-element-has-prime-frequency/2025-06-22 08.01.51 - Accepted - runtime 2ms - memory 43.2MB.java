class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        boolean primes[] = new boolean[101];
        Arrays.fill(primes, true);
        primes[0] = primes[1] =false;
        for(int i=2;i<=100;i++){
            int j= i+i;
            if(primes[i]){
                while(j<= 100){
                    primes[j] = false;
                    j+=i;
                }
            }
        }

        int cnt[] = new int[101];
        for(int x : nums){
            cnt[x]++;
        }

        for(int c : cnt){
            if(primes[c]) return true;
        }

        return false;
    }
}