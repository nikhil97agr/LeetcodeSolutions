package partition_array_into_k_distinct_groups_3979;

import java.util.*;
class Solution {
    public boolean partitionArray(int[] nums, int k) {
        Map<Integer, Integer> map =new HashMap<>();

        for(int x : nums) map.merge(x, 1, Integer::sum);
        int max = 0;
        for(int x : map.values()) max = Math.max(max, x);

        return nums.length%k ==0 && max <= nums.length/k;
        
    }
}