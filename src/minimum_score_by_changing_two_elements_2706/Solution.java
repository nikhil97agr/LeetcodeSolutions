package minimum_score_by_changing_two_elements_2706;

import java.util.*;
class Solution {
    public int minimizeSum(int[] nums) {
        
        int n = nums.length;
        if(n==3){
            return 0;
        }
        
       Arrays.sort(nums);
        return Math.min(nums[n-1]-nums[2], Math.min(nums[n-3]-nums[0], nums[n-2]-nums[1]));
    }
}