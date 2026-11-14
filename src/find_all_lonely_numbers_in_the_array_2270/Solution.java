package find_all_lonely_numbers_in_the_array_2270;

import java.util.*;
class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x,0)+1);

        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int key = entry.getKey();
            int value = entry.getValue();
            if(value>1){
                map.put(key, -1);
            }
            if(map.containsKey(key-1)){
                map.put(key, -1);
                map.put(key-1, -1);
            }
            if(map.containsKey(key+1)){
                map.put(key, -1);
                map.put(key+1,-1);
            }
        }

        List<Integer> result = new ArrayList<Integer>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue()!=-1){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}