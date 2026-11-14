package maximum_number_of_consecutive_values_you_can_make_1930;

import java.util.*;
class Solution {
    public int getMaximumConsecutive(int[] nums) {
        int next = 1;
        Arrays.sort(nums);
        int i=0;
        int n = nums.length;
        while(i < n){
            if( nums[i] <= next){
                next += nums[i];
                i++;
            }else{
                return next;
            }
        }

        return next;
    }
}