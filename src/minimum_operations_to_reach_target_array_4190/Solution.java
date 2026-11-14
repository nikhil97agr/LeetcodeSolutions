package minimum_operations_to_reach_target_array_4190;

import java.util.*;
class Solution {
    public int minOperations(int[] nums, int[] target) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(target[i] != nums[i]){
                map.merge(nums[i], 1, Integer::sum);
            }    
        }

        return map.size();
        
    }
}