package check_if_a_number_is_majority_element_in_a_sorted_array_1102;

import java.util.*;
class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int x : nums) map.merge(x, 1, Integer::sum);
        int n = nums.length;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() > n /2){
                return entry.getKey() == target;
            }
        }

        return false;
    }
}