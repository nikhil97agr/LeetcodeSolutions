package minimize_maximum_pair_sum_in_array_1988;

import java.util.*;
class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int n = nums.length;
        int i=0;
        int j= n-1;
        while(i<j){
            ans = Math.max(ans, nums[i]+nums[j]);

            i++;j--;
        }
        return ans;
    }
}