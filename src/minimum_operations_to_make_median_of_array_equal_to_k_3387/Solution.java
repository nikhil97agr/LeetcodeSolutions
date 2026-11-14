package minimum_operations_to_make_median_of_array_equal_to_k_3387;

import java.util.*;
class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        int mid = n/2;

       int i = mid;
       int j = mid;
        long ans =0 ;
       for(;i>=0 && nums[i] > k;i--){
        ans += (nums[i] - k);
       }

       for(;j<n && nums[j] < k;j++){
        ans += (k - nums[j]);
       }

       return ans;
    }
}