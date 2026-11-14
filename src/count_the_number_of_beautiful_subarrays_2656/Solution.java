package count_the_number_of_beautiful_subarrays_2656;

import java.util.*;
class Solution {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int n = nums.length;
        int xor = 0;
        long ans = 0;
        for(int i=0;i<n;i++){
            xor ^= nums[i];

            ans += map.getOrDefault(xor, 0);
            map.merge(xor, 1, Integer::sum);
        }

        return ans;
    }
}