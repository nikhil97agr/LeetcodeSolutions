package the_two_sneaky_numbers_of_digitville_3581;

import java.util.*;
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int res[] = new int[2];
        int ind = 0;
        Set<Integer> set = new HashSet<>();
        for(int x : nums){
            if(set.contains(x)){
                res[ind++] = x;
            }
            set.add(x);
        }
        return res;
    }
}