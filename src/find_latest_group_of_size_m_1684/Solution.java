package find_latest_group_of_size_m_1684;

import java.util.*;
class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if(m==n) return n;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, n);
        for(int i=n-1;i>=0;i--){
            int val = arr[i];
            Integer lower = map.floorKey(val);
            if(lower !=null){

                int value = map.get(lower);
                if(val - lower ==m || value - val== m) return i;

                map.remove(lower);
                if(lower <= val-1){
                    map.put(lower, val - 1);
                }

                if(val+1 <= value){
                    map.put(val+1, value);
                }
            }
            
        }
        return -1;
    }

 
}