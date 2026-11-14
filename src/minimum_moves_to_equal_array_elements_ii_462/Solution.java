package minimum_moves_to_equal_array_elements_ii_462;

import java.util.*;
class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        long prefix[] = new long[n];

        for(int i=n-2;i>=0;i--){
            prefix[i] = prefix[i+1] + (1L*nums[i+1] - 1L*nums[i])*(n-i-1);
        }
        long suff = 0;
        long ans = prefix[0];
        for(int i=1;i<n;i++){
            ans = Math.min(ans, prefix[i] + suff + (1l*i) * (1l*nums[i] - 1l*nums[i-1]));
            suff += (1l*i) * (1l*nums[i] - 1l*nums[i-1]);
        }
        return (int)ans;
    }
}