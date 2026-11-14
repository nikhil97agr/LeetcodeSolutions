package check_if_it_is_possible_to_split_array_2916;

import java.util.*;
class Solution {
    public boolean canSplitArray(List<Integer> nums, int m) {
        if(nums.size() <= 2) return true;
        for(int i=0;i<nums.size() - 1;i++){
            if(nums.get(i) + nums.get(i+1) >= m) return true;
        }

        return false;
    }
}