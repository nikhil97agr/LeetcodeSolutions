package maximum_number_of_jumps_to_reach_the_last_index_2855;

import java.util.*;
class Solution {
    public int maximumJumps(int[] nums, int target) {
        var n = nums.length;
        var dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int i=0;i<n;i++){
            if(dp[i] == -1) continue;
            for(int j=i+1;j<n;j++){
                if(nums[j] - nums[i] <= target && nums[j] -nums[i] >= -target){

                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        if(dp[n-1] == -1) return -1;

        return dp[n-1];
    }
}