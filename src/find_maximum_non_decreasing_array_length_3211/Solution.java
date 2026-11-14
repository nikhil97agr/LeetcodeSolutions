package find_maximum_non_decreasing_array_length_3211;

import java.util.*;
class Solution {
    public int findMaximumLength(int[] nums) {
        int ans = 0;
        int n = nums.length;
        long pref[] = new long[n+1];

        for(int i=1;i<=n;i++) pref[i] = pref[i-1] + nums[i-1];
        int dp[] = new int[n + 1];
        int last[] = new int[n+2];

        for(int i=0,j=1;j<=n;j++){
            i = Math.max(i, last[j]);
            int ind = Arrays.binarySearch(pref, 2 * pref[j] - pref[i]);
            dp[j] = dp[i] + 1;
            if(ind < 0){
                ind = -ind - 1;
            }

            last[ind] = j;
        }

        return dp[n];
        
    }
}