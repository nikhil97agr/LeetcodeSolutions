class Solution {
    long dp[];
    public long rob(int[] nums, int[] colors) {
        dp = new long[nums.length];
        Arrays.fill(dp, -1);
        return solve(nums, colors, 0, nums.length);
    }

    private long solve(int nums[], int colors[], int ind, int n){
        if(ind==n) return 0;
        if(dp[ind] != -1) return dp[ind];
        long ans = solve(nums, colors, ind + 1, n);

        if(ind +1 >= n){
            ans = Math.max(ans, solve(nums, colors, ind +1, n) + nums[ind]);
        }else{
            if(colors[ind] == colors[ind+1]){
                ans = Math.max(ans, solve(nums, colors, ind +2, n) + nums[ind]);
            }else{
                ans = Math.max(ans, solve(nums, colors, ind + 1, n) + nums[ind]);
            }
        }

        return dp[ind] = ans;
    }
}