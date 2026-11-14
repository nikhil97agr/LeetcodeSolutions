package convert_an_array_into_a_2d_array_with_conditions_2724;

import java.util.*;
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        while(!map.isEmpty()){
            Set<Integer> keys = new HashSet<>(map.keySet());
            List<Integer> temp = new ArrayList<>();
            for(int x : keys){
                temp.add(x);
                int cnt = map.get(x);
                if(cnt ==1 ) map.remove(x);
                else map.put(x, cnt-1);
            }
            result.add(temp);
        }
        return result;
    }
}