package number_of_ways_to_stay_in_the_same_place_after_some_steps_1398;

class Solution {
    public int numWays(int steps, int arrLen) {
        Long dp[][] = new Long[steps+1][Math.min(arrLen, steps/2+1)+1];
        long mod = (long)1e9+7;
        return (int)solve(0, steps, arrLen, mod, dp);
    }

    private long solve(int ind, int steps, int n, long mod, Long dp[][]){
        if(ind < 0 || ind >= n){ return 0; }
        if(ind > steps) return 0;
        if(steps==0){
            if(ind ==0) return 1l;
            return 0;
        }
        if(dp[steps][ind]!=null) return dp[steps][ind];
        long ans = solve(ind+1, steps-1, n, mod, dp) + solve(ind-1, steps -1, n, mod, dp)
            +solve(ind, steps-1, n, mod, dp);
            ans = ans%mod;
        return dp[steps][ind] = ans;
    }
}