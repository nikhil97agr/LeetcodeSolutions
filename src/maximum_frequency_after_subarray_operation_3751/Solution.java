package maximum_frequency_after_subarray_operation_3751;

import java.util.*;
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int cnt = 0;
        for(int x : nums){
            set.add(x);
            if(x==k) cnt++;
        }

        int max= 0;
        for(int x : set){
            if(x == k){
                continue;
            }

            int freq =0 ;
            int currMax = 0;
            for(int i=0;i<n;i++){
                freq = freq - (nums[i] == k ? 1 : 0) + (nums[i] == x ? 1 : 0);
                currMax = Math.max(currMax, freq);
                if(freq < 0) freq = 0;
            }

            max = Math.max(max, currMax);
        }

        return cnt + max;
    }
}