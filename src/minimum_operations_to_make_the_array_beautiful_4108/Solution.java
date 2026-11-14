package minimum_operations_to_make_the_array_beautiful_4108;

import java.util.*;
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;

        int dp[][] = new int[n][101];
        for(int x [] : dp) Arrays.fill(x, Integer.MAX_VALUE);
        for(int val = nums[0];val <= 100;val += nums[0]){
            if(val < nums[1]) continue;
            dp[1][val] = val - nums[1];
        }

        for(int i=2;i<n;i++){
            for(int j=1;j<=100;j++){
                if(dp[i-1][j] == Integer.MAX_VALUE) continue;

                for(int k=j;k<=100;k+=j){
                    if(k < nums[i]) continue;

                    dp[i][k] = Math.min(dp[i][k], k - nums[i] + dp[i-1][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int x : dp[n-1]){
            ans = Math.min(ans, x);
        }

        return ans;
    }

}