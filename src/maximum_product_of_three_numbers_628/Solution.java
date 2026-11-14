package maximum_product_of_three_numbers_628;

import java.util.*;
class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return Math.max(
            nums[0]*nums[1]*nums[n-1],
            nums[n-1]*nums[n-2]*nums[n-3]
        );
    }
}