class Solution {
    public boolean predictTheWinner(int nums[]) {
        int n = nums.length;
        Integer dp[][][] = new Integer[n][n][2];

        return solve(nums, 0, n - 1, dp, 0) >= 0;

    }

    private int solve(int nums[], int start, int end, Integer dp[][][], int player){ 
        if (start > end) {
            return 0;
        }

        if (dp[start][end][player] != null)
            return dp[start][end][player];

        if (player == 0) {
            dp[start][end][player] = Math.max(nums[start] + solve(nums, start + 1, end, dp, 1),
                    nums[end] + solve(nums, start, end - 1, dp, 1));
        } else {
            dp[start][end][player] = Math.min(-nums[start] + solve(nums, start + 1, end, dp, 0),
                    -nums[end] + solve(nums, start, end - 1, dp, 0));
        }

        return dp[start][end][player];
    }
}