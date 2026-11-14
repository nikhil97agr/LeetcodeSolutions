package count_number_of_nice_subarrays_1370;

import java.util.*;
class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int cnt = 0;
        nums = Arrays.stream(nums).map(e -> e%2).toArray();

        int ans = 0;
        for(int x : nums){
            cnt += x;
            int diff = cnt - k;
            int temp = map.getOrDefault(diff, 0);
            ans += temp;
            map.put(cnt, map.getOrDefault(cnt, 0)+1);
            
        }
        return ans;
    }
}