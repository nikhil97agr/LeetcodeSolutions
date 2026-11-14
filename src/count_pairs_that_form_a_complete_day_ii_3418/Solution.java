package count_pairs_that_form_a_complete_day_ii_3418;

import java.util.*;
class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long ans = 0;
        Map<Integer, Long> map = new HashMap<>();
        int n = hours.length;
        for(int i=0;i<n;i++){
            int mod= hours[i]%24;
            if(mod ==0){
                ans += map.getOrDefault(mod, 0L);
                map.put(0, map.getOrDefault(0, 0L)+1);
            }else{
                int remain = 24 - mod;
                ans += map.getOrDefault(remain, 0L);
                map.put(mod, map.getOrDefault(mod, 0L)+1);
            }
        }
        return ans;
    }
}