package maximum_product_of_three_elements_after_one_replacement_4101;

import java.util.*;
class Solution {
    
    public long maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n= nums.length;
        long max = (long)1e5;
        long min = -(long)1e5;
        long a = 1l*nums[0]*nums[1];
        long b= 1l*nums[0]*nums[n-1];
        long c = 1l*nums[n-1]*nums[n-2];

        if(a < 0) a *= min;
        else a*=max;
        if(b< 0) b *= min;
        else b*=max;
        if(c < 0) c*=min;
        else c*=max;

        return Math.max(a, Math.max(b,c));
    }
}