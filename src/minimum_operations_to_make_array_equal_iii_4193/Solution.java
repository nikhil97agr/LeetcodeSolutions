package minimum_operations_to_make_array_equal_iii_4193;

import java.util.*;
class Solution {
    public long minOperations(int[] nums) {
        var cnt = new HashMap<Integer, Integer>();
        var map = new HashMap<Integer, Integer>();
        var max = 0;

        for (int x : nums) {
            map.merge(x, 1, Integer::sum);
            max = Math.max(max, x);
            cnt.put(x, 0);
        }
        var n = nums.length;

        long ans = n;


        if (map.size() == 1)
            return 0;




        for (var entry : map.entrySet()) {
            var key = entry.getKey();
            var val = entry.getValue();
            for (var num = key * 2; num <= max; num += key) {
                if (map.containsKey(num)) {
                    cnt.merge(num, val, Integer::sum);
                    cnt.merge(key, map.get(num), Integer::sum);
                }
            }
        }
        for (var entry : cnt.entrySet()) {
            var key = entry.getKey();
            if (key == 1) {
                continue;
            }
            var val = entry.getValue();
            ans = Math.min(ans, 1l * val + 2l * (n - val - map.get(key)));
        }

        return ans;
    }


}