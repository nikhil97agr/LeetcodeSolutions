package check_if_n_and_its_double_exist_1468;

import java.util.*;
class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr) map.put(x, map.getOrDefault(x,0)+1);

        for(int x : map.keySet()){
            if((x<<1) == x){
                if(map.get(x<<1) > 1) return true;

            }else{
                if(map.getOrDefault(x<<1, 0)>0) return true;
            }

        }
        return false;
    }
}