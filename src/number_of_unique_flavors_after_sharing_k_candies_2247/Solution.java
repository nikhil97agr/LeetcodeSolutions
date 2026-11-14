package number_of_unique_flavors_after_sharing_k_candies_2247;

import java.util.*;
class Solution {
    public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : candies){
            map.merge(x, 1, Integer::sum);
        }
        if(k == candies.length) return 0;
        if(k==0) return map.size();
        int start = 0;
        int ans =0;
        int end = 0;
        while(end < k-1){
            remove(map, candies[end]);
            end++;
        }

        while(end < candies.length){
            remove(map, candies[end]);
            ans = Math.max(ans, map.size());
            map.merge(candies[start], 1, Integer::sum);
            end++;
            start++;
        }

        return ans;
    }
    private void remove(Map<Integer, Integer> map, int val){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);
    }
}