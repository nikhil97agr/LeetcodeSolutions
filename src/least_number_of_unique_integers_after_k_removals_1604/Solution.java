package least_number_of_unique_integers_after_k_removals_1604;

import java.util.*;
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int x : arr){
            map.put(x, map.getOrDefault(x,0)+1);
        }

        List<Map.Entry<Integer, Integer>> entry = new ArrayList<>(map.entrySet());
        Collections.sort(entry, (e1, e2)->{
            return e1.getValue() - e2.getValue();
        });

        for(Map.Entry<Integer, Integer> e : entry){
            if(e.getValue() <= k){
                map.remove(e.getKey());
                k-= e.getValue();
            }else{
                return map.size();
            }
        }
        return map.size();
    }
}