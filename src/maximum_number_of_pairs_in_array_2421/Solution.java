package maximum_number_of_pairs_in_array_2421;

import java.util.*;
class Solution {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            int cnt = map.getOrDefault(x, 0);
            map.put(x, cnt + 1);
        
        }
        int pair = 0;
        int left = 0;

        for(int x : nums){
            if(map.containsKey(x)){
                int cnt = map.get(x);
                if(cnt%2==0){
                    pair += cnt/2;
                }else{
                    pair += cnt/2;
                    left++;
                }
                map.remove(x);
            }
        }

        return new int[]{pair, left};
    }
}