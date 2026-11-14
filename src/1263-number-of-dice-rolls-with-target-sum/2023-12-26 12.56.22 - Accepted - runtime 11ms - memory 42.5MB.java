class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        Long dp[][] = new Long[n+1][target+1];

        long mod = (long)1e9 +7;
        long ans = solve(dp, n, k, target, 0, mod);
        ans %=mod;
        return (int)ans;
    }

    private long solve(Long dp[][], int n, int k, int target, int sum, long mod){
        
        if(n==0){
            if(sum==target) return 1l;
            return 0;
        }
        if(sum >= target) return 0l;

        if(dp[n][sum] != null) return dp[n][sum];
        long ans = 0;
        for(int i=1;i<=k;i++){
            ans += solve(dp, n-1, k,  target, sum + i, mod);
            ans %=mod;
        }

        return dp[n][sum] = ans%mod;
    }
}