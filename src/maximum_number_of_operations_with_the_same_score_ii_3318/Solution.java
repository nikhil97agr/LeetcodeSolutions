package maximum_number_of_operations_with_the_same_score_ii_3318;

class Solution {
    public int maxOperations(int[] nums) {
        int n = nums.length;

        int a1 = solve(nums, 0, n-1, nums[0] + nums[1], new Integer[n][n]);
        int a2 = solve(nums, 0, n-1, nums[0] + nums[n-1], new Integer[n][n]);
        int a3 = solve(nums, 0, n-1, nums[n-1]+nums[n-2], new Integer[n][n]);

        return Math.max(a1, Math.max(a2, a3));
    }

    private int solve(int nums[], int start, int end, int score, Integer dp[][]){
        if(start >= end) return 0;

        if(dp[start][end]!=null) return dp[start][end];

        int ans = 0;
        if(nums[start] + nums[end] == score){
            ans = Math.max(ans, 1 + solve(nums, start+1, end-1, score, dp));
        }

        if(nums[start] + nums[start+1] == score){
            ans = Math.max(ans, 1 + solve(nums, start+2, end, score, dp));
        }

        if(nums[end] + nums[end-1] == score){
            ans = Math.max(ans, 1 + solve(nums, start, end-2, score ,dp));

            
        }

        return dp[start][end] = ans;
    }
}