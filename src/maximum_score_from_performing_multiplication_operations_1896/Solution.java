package maximum_score_from_performing_multiplication_operations_1896;

import java.util.*;
class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        int dp[][] = new int[m][n];
        for(int x[] : dp){
            Arrays.fill(x, Integer.MIN_VALUE);
        }
        return solve(nums, multipliers, 0, n-1, 0,m, dp);
        
    }
    
    public int solve(int nums[], int multi[], int left, int right, int i, int m, int[][] dp){
        if(i==m){
            return 0;
        }
        if(dp[left][right]!=Integer.MIN_VALUE){
            return dp[left][right];
        }
        
        int leftMax = nums[left]*multi[i] + solve(nums, multi, left+1, right, i+1, m, dp);
        int rightMax = nums[right]*multi[i] + solve(nums, multi, left, right-1, i+1, m, dp);
        
        return dp[left][right] = Math.max(leftMax, rightMax);
        
    }
}