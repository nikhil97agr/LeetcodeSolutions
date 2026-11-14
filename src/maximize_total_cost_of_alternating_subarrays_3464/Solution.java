package maximize_total_cost_of_alternating_subarrays_3464;

class Solution {
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        Long dp[][] = new Long[n][2];

        return solve(0, nums, dp, 0, n);
    }

    private long solve(int i, int nums[], Long dp[][], int parity, int n){
        if(i==n) return 0l;

        if(dp[i][parity]!=null) return dp[i][parity];

        return dp[i][parity] = Math.max(
            (parity==0 ? 1L:-1L)*nums[i] + solve(i+1, nums, dp, parity ==0 ? 1 : 0, n),
            nums[i] + solve(i+1, nums, dp, 1,n)
        );
    }
}