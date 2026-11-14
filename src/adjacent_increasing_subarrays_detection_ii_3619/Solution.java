package adjacent_increasing_subarrays_detection_ii_3619;

import java.util.*;
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int size = 0;
        int prev = Integer.MIN_VALUE;
        int n = nums.size();
        int pre = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            if( nums.get(i) > prev){
                size++;
                prev = nums.get(i);
            }else{
                prev = nums.get(i);
                pre = size;
                size =1;
            }

            ans = Math.max(ans, 
                Math.max(Math.min(size, pre), size/2)
            );
        }

        return ans;
    }
}