package maximum_size_subarray_sum_equals_k_325;

import java.util.*;
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];

            int req = sum - k;
            if(map.containsKey(req)){
                ans = Math.max(ans, i - map.get(req));
            }

            if(!map.containsKey(sum)){
                map.put(sum, i);
            }


        }

        return ans;
    }
}