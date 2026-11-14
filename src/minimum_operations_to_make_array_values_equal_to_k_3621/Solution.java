package minimum_operations_to_make_array_values_equal_to_k_3621;

import java.util.*;
class Solution {
    public int minOperations(int[] nums, int k) {
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        for(int x : nums) set.add(x);
        
        Integer lower = set.higher(k);
        if(lower!=null) return -1;
        
        if(set.getLast() == k){
            return set.size()-1;
        }
        
        return set.size();
        
    }
}