package minimum_increment_operations_to_make_array_beautiful_3178;

class Solution {
    public long minIncrementOperations(int[] nums, int k) {
        int n = nums.length;
        long dp[] = new long[n];

        for(int i=0;i<n;i++){
            if(i <= 2){
                dp[i] = Math.max(0, k - nums[i]);
                continue;
            }

            dp[i] = Math.min(dp[i-1], Math.min(dp[i-2], dp[i-3])) + Math.max(0, k -nums[i]);
        }

        return Math.min(dp[n-1], Math.min(dp[n-2], dp[n-3]));
    }
}