package last_stone_weight_ii_1130;

class Solution {
    public int lastStoneWeightII(int[] stones) {
        Integer dp[][] = new Integer[stones.length][60002];
        return solve(0, 0, stones, stones.length, dp);
    }

    private int solve(int sum, int i, int nums[], int n, Integer dp[][] ){
        if(i == n){
            if(sum < 0) return Integer.MAX_VALUE;

            return sum;
        }

        int ind = sum + 3000;
        if(dp[i][ind]!=null) return dp[i][ind];

        return dp[i][ind] = Math.min(solve(sum - nums[i], i+1, nums, n, dp), solve(sum + nums[i], i+1, nums, n, dp));
    }
}