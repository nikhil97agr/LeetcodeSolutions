package count_distinct_subarrays_divisible_by_k_in_sorted_array_4063;

import java.util.*;
class Solution {
    public long numGoodSubarrays(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        Map<Long, Long> map = new HashMap<>();
        Map<Long, Map<Integer, Long>> map2 = new HashMap<>();
        map.put(0l, 1l);
        for(int x : nums){
            sum +=x;
            sum%=k;
            ans = ans + map.getOrDefault(sum, 0l) - map2.getOrDefault(sum, new HashMap<>()).getOrDefault(x, 0l);
            map.merge(sum, 1l, Long::sum);
            map2.computeIfAbsent(sum, y-> new HashMap<>()).merge(x, 1l, Long::sum);
        }

        return ans;
    }
}