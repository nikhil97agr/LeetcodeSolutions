package visit_array_positions_to_maximize_score_2893;

class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        Long dp[][] = new Long[n][2];

        return solve(nums, x, dp, 0, n, nums[0]%2);
    }

    private long solve(int nums[], int x, Long dp[][], int i, int n, int parity){
        if(i==n) return 0;

        if(dp[i][parity]!=null) return dp[i][parity];
        if(parity == nums[i]%2){
            return dp[i][parity] = Math.max(solve(nums, x, dp, i+1, n, parity) + nums[i], solve(nums, x, dp,i+1, n, parity));
        }else{
            return dp[i][parity] =Math.max(
                solve(nums, x, dp, i+1, n, parity^1) + nums[i] - x,
                solve(nums, x, dp, i+1, n, parity)
            );
        }
    }
}