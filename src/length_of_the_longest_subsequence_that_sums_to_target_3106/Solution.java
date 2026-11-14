package length_of_the_longest_subsequence_that_sums_to_target_3106;

import java.util.*;
class Solution {
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        Integer dp[][] = new Integer[nums.size()][target+1];
        int ans = solve(nums, nums.size(), 0, target, dp);

        return ans <= 0 ? -1 : ans;
    }

    private int solve(List<Integer> list, int n, int i, int target, Integer dp[][]){
        if(i==n){
            if(target !=0) return Integer.MIN_VALUE;
        }

        if(target ==0) return 0;
        if(dp[i][target]!=null) return dp[i][target];
        int ans = Integer.MIN_VALUE;
        if(list.get(i) <= target)
        {
            ans= 1 + solve(list, n, i+1, target - list.get(i), dp);
        }

        ans = Math.max(ans, solve(list, n, i+1, target, dp));

        return dp[i][target] = ans;
    }   
}