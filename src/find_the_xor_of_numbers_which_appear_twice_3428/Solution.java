package find_the_xor_of_numbers_which_appear_twice_3428;

import java.util.*;
class Solution {
    public int duplicateNumbersXOR(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        int ans = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 2){
                ans = ans^entry.getKey();
            }
        }
        return ans;
    }
}