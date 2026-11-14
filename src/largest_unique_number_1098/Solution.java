package largest_unique_number_1098;

import java.util.*;
class Solution {
    public int largestUniqueNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.merge(x, 1, Integer::sum);
        }

        int ans = -1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1){
                ans = Math.max(ans, entry.getKey());
            }
        }

        return ans;
    }
}