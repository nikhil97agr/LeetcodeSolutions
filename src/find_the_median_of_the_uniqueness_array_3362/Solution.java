package find_the_median_of_the_uniqueness_array_3362;

import java.util.*;
class Solution {
    public int medianOfUniquenessArray(int[] nums) {
        var n = nums.length;
        var total = (1l * n*(n+1))/2;
        var required = (total +1)/2;
        int start = 1;
        int end = n;
        int ans= -1;
        while(start <= end){
             int mid = (start+end)>>1;

             if(check(nums, mid, required)){
                ans = mid;
                end = mid - 1;
             } else{
                start = mid + 1;
             }


        }


        return ans;
    }

    private boolean check(int nums[], int median, long required){
        var map =new HashMap<Integer, Integer>();

        int start =0;
        int end = 0;
        long total =0 ;
        int n = nums.length;
        for(;end < n;end++){
            if(map.size() < median || map.containsKey(nums[end])){
                map.merge(nums[end], 1, Integer::sum);
                continue;
            }

            while(map.size() == median){
                int len = end-start;
                total += len;
                map.merge(nums[start], -1, Integer::sum);
                if(map.get(nums[start]) == 0) map.remove(nums[start]);
                start++;
            }
            map.merge(nums[end], 1, Integer::sum);
        }

        while(start < n){
            total +=(end - start);
            start++;
        }

        return total >= required;
    }
}