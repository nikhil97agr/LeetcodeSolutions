package append_k_integers_with_minimal_sum_2305;

import java.util.*;
class Solution {
    public long minimalKSum(int[] nums, int k) {
        long ans = 0;
        Arrays.sort(nums);
        
        int start = 1;
        for(int i=0;i<nums.length && k > 0;i++){
            int end = Math.min(nums[i]-1, start+k-1);
            ans += getSum(start, end);
            k -= (end >= start ? ( end - start + 1) : 0);
            start = nums[i] + 1;

        }


        int end = start + k -1;

        return ans + getSum(start, end);



    }

    private long getSum(long start, long end){
        if(start > end) return 0l;
        long n = end - start+1;

        return (n*(2*start + n - 1))/2;
    }
}