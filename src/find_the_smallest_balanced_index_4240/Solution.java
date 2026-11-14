package find_the_smallest_balanced_index_4240;

import java.util.*;
class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long sum = Arrays.stream(nums).mapToLong(x-> x).sum();
        long prod = 1;
        int ans = -1;
        int n = nums.length - 1;
        for(int i=n;i>=0;i--){
            sum -= nums[i];
            if(sum == prod) ans = i;

            if(prod > sum) break;
            prod *= nums[i];
        }

        return ans;
    }
}