class Solution {
    public int subsequenceCount(int[] nums) {
        return solve(0, 0, nums, nums.length, new Integer[nums.length][2]);
    }

    private int solve(int i, int mod, int nums[], int n, Integer dp[][]){
        if(i==n){
            return mod;
        }

        if(dp[i][mod]!=null) return dp[i][mod];

        return dp[i][mod] = add(solve(i+1, mod, nums, n, dp), solve(i+1, (mod + nums[i])%2, nums, n, dp));
    }

    private int add(int a, int b){
        long sum = 1l*a + b;
        long mod = (long)1e9 + 7;
        return (int)(sum%mod);
    }
}