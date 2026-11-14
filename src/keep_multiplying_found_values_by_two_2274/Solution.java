package keep_multiplying_found_values_by_two_2274;

import java.util.*;
class Solution {
    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            set.add(x);
        }

        while(set.contains(original)){
            original<<=1;
        }
        return original;
    }
}