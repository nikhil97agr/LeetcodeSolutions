package find_the_power_of_k_size_subarrays_ii_3523;

import java.util.*;
class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int cnt[] = new int[n];
        Arrays.fill(cnt, 1);
        for(int i=1;i<n;i++){
            if(nums[i] - nums[i-1] == 1){
                cnt[i] = cnt[i-1] + 1;
            }
        }
        int ans[] =new int[n - k + 1];
        int ind = 0;
        Arrays.fill(ans, -1);
        for(int i=k-1;i<n;i++){
            if(cnt[i] >= k){
                ans[ind] = nums[i];

            }
            ind++;
        }
        return ans;
    }
}