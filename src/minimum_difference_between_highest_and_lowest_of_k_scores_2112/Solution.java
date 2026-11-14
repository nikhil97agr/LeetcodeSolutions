package minimum_difference_between_highest_and_lowest_of_k_scores_2112;

import java.util.*;
class Solution {
    public int minimumDifference(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);

        int i=0;
        int j = k-1;

        while( j < nums.length){
            ans = Math.min(ans, nums[j] - nums[i]);
            j++;
            i++;
        }

        return ans;
    }
}