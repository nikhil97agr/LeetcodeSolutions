package minimum_swaps_to_avoid_forbidden_values_4061;

import java.util.*;
class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
        var n = nums.length;
        var m1 = new HashMap<Integer, Integer>();
        var same = 0;
        var m2 = new HashMap<Integer, Integer>();
        var m3 = new HashMap<Integer, Integer>();
        var maxCnt = 0;
        for(var i=0;i<n;i++){
            m1.merge(nums[i], 1, Integer::sum);
            m2.merge(forbidden[i], 1, Integer::sum);
            if(nums[i] == forbidden[i]){
                same++;
                m3.merge(nums[i], 1, Integer::sum);
                maxCnt = Math.max(maxCnt, m3.get(nums[i]));
            }
        }

        for(var entry : m2.entrySet()){
            int emptyPos = n- entry.getValue();
            if(emptyPos < m1.getOrDefault(entry.getKey(), 0)) return -1;
        }



        return Math.max(maxCnt, (same + 1)/2);
    }
}