package maximize_expression_of_three_elements_4112;

import java.util.*;
class Solution {
    public int maximizeExpressionOfThree(int[] nums) {
        Arrays.sort(nums);


        int n = nums.length;

        return nums[n-1] + nums[n-2] - nums[0];
    }
}