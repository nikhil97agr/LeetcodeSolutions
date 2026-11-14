package n_repeated_element_in_size_2n_array_1001;

import java.util.*;
class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if(set.contains(x)) return x;
            set.add(x);
        }
        return -1;
    }
}