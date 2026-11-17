package array_of_doubled_pairs_991;

import java.util.*;
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        int n = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        for (int x : arr) {
            map.merge(x, 1, Integer::sum);
        }
        for(int i=0;i<n;i++){
            if(map.containsKey(arr[i]) && map.containsKey(2*arr[i])){
                if(arr[i]==0){
                    if(map.getOrDefault(0, 0) > 1){
                        remove(map, 0);
                        remove(map, 0);
                    }else{
                        return false;
                    }
                }else{
                    remove(map,arr[i]);
                    remove(map,2*arr[i]);
                }
            }
        }

        

        return map.isEmpty();

    }

    private void add(Map<Integer, Integer> map, int val){
        map.merge(val, 1, Integer::sum);
    }

    private void remove(Map<Integer, Integer> map, int val){
        map.merge(val, -1, Integer::sum);
        if(map.get(val) ==0) map.remove(val);
    }
}