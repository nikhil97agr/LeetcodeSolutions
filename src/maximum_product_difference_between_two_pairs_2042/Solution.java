package maximum_product_difference_between_two_pairs_2042;

import java.util.*;
class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n-1]*nums[n-2]) - (nums[0]*nums[1]);
    }
}