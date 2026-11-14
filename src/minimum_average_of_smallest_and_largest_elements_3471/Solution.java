package minimum_average_of_smallest_and_largest_elements_3471;

import java.util.*;
class Solution {
    public double minimumAverage(int[] nums) {
        double res = Double.MAX_VALUE;
        Arrays.sort(nums);

        int start = 0;
        int end = nums.length-1;
        while(start <end){
            double avg = (1d*nums[start] + 1d*nums[end])/2d;
            res = Math.min(res, avg);
            start++;
            end--;
        }
        return res;
    }
}