package minimum_cost_to_equalize_arrays_using_swaps_4253;

import java.util.*;
import java.util.Arrays;

class Solution {

    public int minCost(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int max = Math.max(Arrays.stream(nums1).max().getAsInt(), Arrays.stream(nums2).max().getAsInt());
        int c1[] = new int[max + 1];
        int c2[] = new int[max + 1];
        for (int i = 0; i < n; i++) {
            if (nums1[i] == nums2[i]) {
                continue;
            }
            c1[nums1[i]]++;
            c2[nums2[i]]++;
        }
        int ans = 0;
        for (int i = 0; i <= max; i++) {
            if ((c1[i] + c2[i]) % 2 != 0) {
                return -1;
            }else{
                ans += Math.abs(c1[i] - c2[i]);
            }
        }
        
        if(ans%2!=0 || (ans/2)%2!=0) return -1;
        
        return ans/4;

        
    }
}