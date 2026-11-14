package number_of_subarrays_with_and_value_of_k_3466;

import java.util.*;
class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        
        Map<Integer, Long> prev = new HashMap<>();
        
        for (int num : nums) {
            Map<Integer, Long> curr = new HashMap<>();
            
            curr.put(num, 1L);
            
            for (int val : prev.keySet()) {
                int newVal = val & num;
                curr.put(newVal, curr.getOrDefault(newVal, 0L) + prev.get(val));
            }
            
            ans += curr.getOrDefault(k, 0L);
            prev = curr;
        }
        
        return ans;
    }
}
