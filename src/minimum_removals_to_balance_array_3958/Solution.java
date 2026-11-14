package minimum_removals_to_balance_array_3958;

import java.util.*;
class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;

        int ans = Integer.MAX_VALUE;;

        Arrays.sort(nums);
        int start = 0;
        int end = 0;
        long prod = 0;
        while(end < n){
             prod = 1l*nums[start]*k;

            while(prod < 1l*nums[end]){
                start++;
                prod = 1l*nums[start]*k;
            }
            ans = Math.min(ans, n - (end- start+1));
            
            end++;
            
        }
        while(prod < 1l*nums[end-1]){
            start++;
            prod = 1l*nums[start]*k;
        }

        return Math.min(ans, n-1);
        
    }
}