package minimum_subarrays_in_a_valid_split_2607;

class Solution {
    public int validSubarraySplit(int[] nums) {
        int n = nums.length;
        Integer dp[][] = new Integer[n][n];

        int ans = solve(0, 0, nums, nums.length, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int solve(int start, int end, int nums[], int n, Integer dp[][]){
        if(end ==n){
            if(start == end){
                return 0;
            }
            return Integer.MAX_VALUE;
        }

        if(dp[start][end] != null) return dp[start][end];
        int ans = Integer.MAX_VALUE;

        if(gcd(nums[start], nums[end]) > 1){
            int temp = solve(end+1, end+1, nums, n, dp);

            if(temp != Integer.MAX_VALUE) temp++;
            ans = Math.min(ans, temp);
        }

        ans = Math.min(ans, solve(start, end + 1, nums,n , dp));

        return dp[start][end] = ans;

    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }
}