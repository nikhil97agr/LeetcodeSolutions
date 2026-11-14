package check_if_array_pairs_are_divisible_by_k_1620;

import java.util.*;
class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr){
            int mod = ((x%k)+k)%k;
            map.put(mod, map.getOrDefault(mod, 0)+1);
        }
        for(int x : arr){
            int mod = ((x%k)+k)%k;

            if(mod == 0){
                if(map.get(mod)%2!=0) return false;
                continue;
            }

            int left = k - mod;

            if(!Objects.equals(map.get(mod), map.get(left))) return false;
        }

        return true;
    }
}