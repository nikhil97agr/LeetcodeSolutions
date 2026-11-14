package rank_transform_of_an_array_1256;

import java.util.*;
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int rank = 1;
        int clone[] = arr.clone();
        Arrays.sort(clone);
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : clone){
            if(!map.containsKey(x)){
                map.put(x, rank);
                rank++;
            }
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}