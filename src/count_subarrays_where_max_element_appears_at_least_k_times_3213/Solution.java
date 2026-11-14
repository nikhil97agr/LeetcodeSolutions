package count_subarrays_where_max_element_appears_at_least_k_times_3213;

import java.util.*;
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int l = 0;
        int r = 0;
        long ans = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        while(r < n){
            if(nums[r] == max) k--;

            r++;
            while( k == 0){
                if(nums[l] == max) k++;
                l++;
            }
            ans += 1L*l;
        }
        return ans;
    }
}