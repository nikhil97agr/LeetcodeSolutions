package minimum_index_sum_of_common_elements_4050;

import java.util.*;
class Solution {
    public int minimumSum(int[] nums1, int[] nums2) {
        int ans = Integer.MAX_VALUE;
        int n = nums1.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(int i=0;i<n;i++){
            if(!map1.containsKey(nums1[i])){
                map1.put(nums1[i], i);
            }

            if(!map2.containsKey(nums2[i])){
                map2.put(nums2[i], i);
            }
        }

        for(int i=0;i<n;i++){
            ans = Math.min(ans, check(nums1[i], i, map2));
            ans = Math.min(ans, check(nums2[i], i, map1));
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int check(int x, int ind, Map<Integer, Integer> map){
        if(!map.containsKey(x)){
            return Integer.MAX_VALUE;
        }

        return ind + map.get(x);
    }
}