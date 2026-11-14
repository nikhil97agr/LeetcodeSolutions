class Solution {
    public int specialPerm(int[] nums) {
        int n = nums.length;
        int mask = (1<<n);
        Integer dp[][] = new Integer[mask][n+1];
        return solve(nums, n, n, 0, mask, dp);
    }

    private int solve(int nums[], int n, int prev, int state, int mask, Integer dp[][]){
        if(state == (mask - 1)) return 1;

        if(dp[state][prev] != null) return dp[state][prev];
        int ans = 0;
        for(int i=0;i<n;i++){
            if((state & (1<<i)) ==0 && (prev ==n  || nums[prev]%nums[i]==0 || nums[i]%nums[prev] ==0)){
                ans = add(ans, solve(nums, n, i, state | (1<<i), mask, dp));
            }
        }

        return dp[state][prev] = ans;
    }

    private int add(int a, int b){
        long mod = (long)1e9+ 7;
        long sum = 1l*a + b;

        return (int)(sum%mod);
    }
}