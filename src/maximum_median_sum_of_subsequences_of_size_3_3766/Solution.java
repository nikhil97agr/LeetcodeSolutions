package maximum_median_sum_of_subsequences_of_size_3_3766;

import java.util.*;
class Solution {
    public long maximumMedianSum(int[] nums) {
        Arrays.sort(nums);
        long ans= 0;
        int n = nums.length;
        int start =0;
        int end = n-1;
        int next= n-2;

        while(start < next){
            ans += nums[next];
            next-=2;
            end -=2;
            start++;
        }
        

        return ans;
    }
}