package k_diff_pairs_in_an_array_532;

import java.util.*;
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int val = entry.getValue();
            int prev = key - k;
            int next = key + k;

            if (next == prev) {
                if (val > 1) {
                    ans++;
                }
            } else {
                if (map.getOrDefault(next, -1) != -1) {
                    ans++;

                }
                if (map.getOrDefault(prev, -1) != -1) {
                    ans++;
                }
            }
            map.put(key, -1);
        }
        return ans;

    }
}