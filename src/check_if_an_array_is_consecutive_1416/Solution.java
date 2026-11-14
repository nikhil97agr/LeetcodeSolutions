package check_if_an_array_is_consecutive_1416;

import java.util.*;
class Solution {
    public boolean isConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int x = Arrays.stream(nums).min().getAsInt();
        int n = nums.length;
        for(int y : nums){
            if(y >= x && y <= (x + n -1)){
                set.add(y);
            }
        }

        return set.size() == n;
    }
}