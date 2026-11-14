package largest_positive_integer_that_exists_with_its_negative_2524;

import java.util.*;
class Solution {
    public int findMaxK(int[] nums) {
        int ans = Integer.MIN_VALUE;;
        Set<Integer> set = new HashSet<>();
        for(int x : nums) set.add(x);
        for(int x : nums){
            if(set.contains(-x)){
                ans = Math.max(ans, x);
            }
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}