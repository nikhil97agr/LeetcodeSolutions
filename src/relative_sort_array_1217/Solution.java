package relative_sort_array_1217;

import java.util.*;
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int x : arr1) map.put(x, map.getOrDefault(x, 0)+1);

        int ans[] = new int[arr1.length];

        int i=0;
        for(int x : arr2){
            int cnt = map.get(x);
            while(cnt-- > 0){
                ans[i++] = x;
            }

            map.remove(x);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int cnt = entry.getValue();
            while(cnt-->0){
                ans[i++] = entry.getKey();
            }
        }
        return ans;
    }
}