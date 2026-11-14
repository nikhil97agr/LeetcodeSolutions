package maximum_alternating_sum_of_squares_4078;

import java.util.*;
class Solution {
    public long maxAlternatingSum(int[] nums) {

        
        int n = nums.length;
        long[] square = new long[n];
        for(int i=0;i<n;i++){
            square[i] = 1l*nums[i]*nums[i];
        }

        Arrays.sort(square);
        int start = 0;
        int end = nums.length - 1;
        long ans = 0;
        while(start < end){
            ans = ans + square[end] - square[start];
            start++;
            end--;
        }

        if(start == end){
            ans += square[end];
        }

        return ans;
    }
}