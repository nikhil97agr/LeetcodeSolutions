package maximum_element_after_decreasing_and_rearranging_1956;

import java.util.*;
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int x : arr){ map.put(x, map.getOrDefault(x, 0)+1); }

        int prevMax = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){

            for(int i=0;i<entry.getValue();i++){
                if(prevMax ==entry.getKey()){
                    continue;
                }else if(entry.getKey()-prevMax==1){
                    prevMax = entry.getKey();
                }else{
                    prevMax++;
                }
            }
        }

        return prevMax;
    }
}