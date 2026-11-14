package maximum_sum_of_3_non_overlapping_subarrays_689;

import java.util.*;
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        long prefix[] = new long[n+1];
        for(int i=1;i<=n;i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        Long dp[][] = new Long[n][4];

        // long max = solve(nums, 0, 1, dp, prefix, n, k);
        List<Integer> list = new ArrayList<>();
        dfs(nums, 0, 1, dp, prefix, n, k, list);
        return new int[]{list.get(0), list.get(1), list.get(2)};
    }

    private void dfs(int nums[], int i, int j, Long dp[][], long prefix[], int n, int k, List<Integer> list){
        if(j==4 || i+k > n) return;

        long with = solve(nums,i+k, j+1, dp, prefix, n, k) + prefix[i+k] - prefix[i];
        long without = solve(nums, i+1, j, dp, prefix, n, k);

        if(with >= without){
            list.add(i);
            dfs(nums, i+k, j+1, dp, prefix, n, k, list);
        }else{
            dfs(nums, i+1, j, dp, prefix, n, k, list);
        }
    }

    private long solve(int nums[], int i, int j, Long dp[][], long prefix[], int n, int k){
        
        if(j==4) return 0;
        if(i+k > n) return Long.MIN_VALUE;

        if(dp[i][j]!=null) {
            return dp[i][j];
        }


        return dp[i][j] = Math.max(solve(nums, i+1, j, dp, prefix, n, k),
        solve(nums, i+k, j+1, dp, prefix, n, k) + prefix[i+k] - prefix[i]);
        
    }
}