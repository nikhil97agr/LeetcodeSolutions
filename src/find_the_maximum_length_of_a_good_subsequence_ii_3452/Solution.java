package find_the_maximum_length_of_a_good_subsequence_ii_3452;

import java.util.*;
class Solution {
    public int maximumLength(int[] nums, int k) {
        var n = nums.length;
        var map = new HashMap<Integer, Integer>();
        var dp = new int[n][k+1];
        for(var i=0;i<n;i++){
            for(int j=0;j<=k;j++){
                dp[i][j] = 1;
            }
        }
        var kMax = new int[k+1];
        int ans = 0;
        for(var i=n-1;i>=0;i--){
            int prev = map.getOrDefault(nums[i], -1);
            var prevMax = kMax.clone();
            for(int j=0;j<=k;j++){
                if(prev != -1){
                    dp[i][j] = Math.max(dp[i][j],1+ dp[prev][j]);
                }

                if(j-1 >=0){
                    dp[i][j] = Math.max(dp[i][j],1 + kMax[j-1]);
                }
                prevMax[j] = Math.max(prevMax[j], dp[i][j]);
            }
            kMax= prevMax;
            ans = Math.max(ans, dp[i][k]);
            map.put(nums[i], i);
        }

        return ans;

    }
}