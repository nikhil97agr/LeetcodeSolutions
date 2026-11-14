class Solution {
    public int maximumLength(int[] nums, int k) {
        int ans = 0;
        int dp[][] = new int[k][k];
        int n = nums.length;

        for (int num : nums) {
            int curr = num % k;
            for (int j = 0; j < k; j++) {
                int prev = (j-curr + k) % k;

                dp[curr][j] = Math.max(dp[curr][j], 1 + dp[prev][j]);
                ans = Math.max(ans, dp[curr][j]);
            }
        }
        
        return ans;
    }
}