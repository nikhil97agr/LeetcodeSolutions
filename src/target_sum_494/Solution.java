package target_sum_494;

import java.util.*;
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<Integer, Map<Integer, Integer>> dp = new HashMap<>();

        return solve(nums,0, 0, nums.length ,target, dp);
    }

    private int solve(int nums[], int i, int sum, int n, int target, Map<Integer, Map<Integer, Integer>> dp){
        if(i == n){
            if(sum == target) return 1;
            return 0;
        }

        if(dp.containsKey(i) && dp.get(i).containsKey(sum)) return dp.get(i).get(sum);

        int total = solve(nums, i+1, sum + nums[i], n, target, dp) + solve(nums, i+1, sum - nums[i], n, target, dp);

        dp.computeIfAbsent(i, x -> new HashMap<>()).put(sum, total);
        return total;

    }
}