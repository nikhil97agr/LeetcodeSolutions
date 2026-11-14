package merge_similar_items_2447;

import java.util.*;
class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        sum(items1, map);
        sum(items2, map);
        List<List<Integer>> res = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            res.add(Arrays.asList(entry.getKey(), entry.getValue()));
        }
        
        return res;
    }

    private void sum(int arr[][], Map<Integer, Integer> map){
        for(int a[] : arr){
            map.merge(a[0], a[1], Integer::sum);
        }
    }
}