package minimum_positive_sum_subarray_3644;

import java.util.*;
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        int n= nums.size();
        for(int i=l;i<=r;i++){
            int start = 0;
            int sum = 0;
            int end = 0;
            while(end < i){
                sum+= nums.get(end);
                end++;
            }
            
            if(sum > 0){
                ans = Math.min(ans, sum);
            }
            
            while(end < n){
                sum = sum + nums.get(end) - nums.get(start);
                end++;
                start++;
                if(sum > 0)
                ans = Math.min(ans, sum);
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}