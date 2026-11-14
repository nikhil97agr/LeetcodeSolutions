package sorting_three_groups_2904;

import java.util.*;
class Solution {
    public int minimumOperations(List<Integer> nums) {
        int n = nums.size();
        Integer dp[][] = new Integer[n+1][n+1];
        return solve(0, n, n, nums, dp);
    }

    private int solve(int i, int prev, int n, List<Integer> nums, Integer dp[][]){
        if(i==n) return 0;

        if(dp[i][prev]!=null) return dp[i][prev];
        if(prev == n){
            return dp[i][prev] = Math.min(1 + solve(i+1, prev, n, nums, dp), solve(i+1, i, n, nums, dp));
        }

        if(nums.get(i) >= nums.get(prev)){
            return dp[i][prev] =Math.min(1 + solve(i+1, prev, n, nums, dp), solve(i+1, i, n, nums, dp));
        }

        return dp[i][prev] = 1 + solve(i+1, prev, n, nums, dp);
    }
}