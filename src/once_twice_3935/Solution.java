package once_twice_3935;

import java.util.*;
class Solution {
    public int[] onceTwice(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums) map.merge(x, 1, Integer::sum);
        int ans[] = new int[]{0,0};

        for(int key : map.keySet()){
            int val = map.get(key);
            if(val == 1) ans[0] = key;
            if(val ==2 ) ans[1] = key;
        }

        return ans;
    }
}