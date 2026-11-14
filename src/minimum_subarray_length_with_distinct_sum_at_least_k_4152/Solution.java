package minimum_subarray_length_with_distinct_sum_at_least_k_4152;

import java.util.*;
class Solution {
    public int minLength(int[] nums, int k) {
        int ans = -1;
        int start = 1;
        int n = nums.length;
        int end = nums.length;
        while(start <= end){
            int mid = (start + end)/2;

            Map<Integer, Integer> map = new HashMap<>();
            int s = 0;
            int e = 0;
            long sum = 0;
            while(e < mid-1){
                map.merge(nums[e], 1, Integer::sum);
                if(map.get(nums[e]) ==1){
                    sum += nums[e];
                }
                e++;
            }
            boolean res = false;
            while(e < n){
                map.merge(nums[e], 1, Integer::sum);
                if(map.get(nums[e]) ==1){
                    sum += nums[e];
                }

                if(sum >=k ){
                    res= true;
                    break;
                }

                map.merge(nums[s], -1, Integer::sum);

                if(map.get(nums[s]) ==0){
                    map.remove(nums[s]);
                    sum -= nums[s];
                }
                s++;
                e++;
            }

            if(res){
                ans = mid;
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }
}