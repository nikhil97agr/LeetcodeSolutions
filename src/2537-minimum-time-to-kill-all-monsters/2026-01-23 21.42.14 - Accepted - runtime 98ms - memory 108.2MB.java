class Solution {
    public long minimumTime(int[] power) {
        int n =power.length;
        int last = (1<<n) - 1;
        Long dp[][] = new Long[n+1][1<<n];
        return solve(1, 0, power, n, last, dp);
    }

    private long solve(int gain, int mask, int power[], int n, int last, Long dp[][]){
        if(mask == last){
            return 0;
        }
        if(dp[gain][mask]!=null) return dp[gain][mask];
        long ans = Long.MAX_VALUE;
        for(int i=0;i<n;i++){
            if((mask & (1<<i)) ==0){

                long p = power[i];
                long day = (p + gain -1)/gain;

                ans = Math.min(
                    ans,
                    day + solve(gain+1, mask | (1<<i),power, n, last, dp)
                );


            }
        }

        return dp[gain][mask] = ans;
    }
}