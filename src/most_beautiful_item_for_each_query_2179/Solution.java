package most_beautiful_item_for_each_query_2179;

import java.util.*;
class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Arrays.sort(items, (i1, i2)-> i1[0] - i2[0]);
        int max = 0;

        for(int x[] : items){
            max = Math.max(max, x[1]);
            map.put(x[0], max);
        }

        int ans[] = new int[queries.length];

        for(int i=0;i<queries.length;i++){
            Map.Entry<Integer, Integer> entry = map.floorEntry(queries[i]);
            if(entry == null) ans[i] = 0;
            else ans[i] = entry.getValue();
        }
        return ans;
    }
}