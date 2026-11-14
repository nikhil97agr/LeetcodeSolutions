package longest_subarray_divisible_by_k_with_at_most_one_negation_i_4374;

import java.util.*;
class Solution {
    public int longestSubarray(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        Map<Integer, Integer> map =new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
            int rem = (sum%k + k)%k;
            if(rem == 0){
                ans = Math.max(ans, i + 1);
                continue;
            }
            if(map.containsKey(rem)){
                ans = Math.max(ans, i - map.get(rem));
            }

            for(int j=i;j>=0;j--){
                int newSum = sum - 2 * nums[j];
                int rr = (newSum%k + k)%k;
                if(map.containsKey(rr) && map.get(rr) < j){
                    ans = Math.max(ans, i - map.get(rr));
                }
            }

            map.putIfAbsent(rem,i);
        }

        return ans;
    }
}