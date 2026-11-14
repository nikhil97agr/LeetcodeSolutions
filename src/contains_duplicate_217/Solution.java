package contains_duplicate_217;

import java.util.*;
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if(set.contains(x)){
                return true;
            }
            set.add(x);
        }

        return false;
    }
}