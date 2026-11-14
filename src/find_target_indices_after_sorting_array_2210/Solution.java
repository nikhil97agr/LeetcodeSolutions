package find_target_indices_after_sorting_array_2210;

import java.util.*;
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i] == target) list.add(i);
        }

        return list;
    }
}