package reduction_operations_to_make_the_array_elements_equal_2016;

import java.util.*;
class Solution {
    public int reductionOperations(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>((a,b)->b-a);
        int ans = 0;
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int min = map.lastKey();
        int size = map.size()-1;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getKey()==min) break;

            ans += size*entry.getValue();
            size--;
        }

        return ans;
    }
}