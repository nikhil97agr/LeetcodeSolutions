package shortest_distance_after_road_addition_queries_ii_3514;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int g[][] = new int[][]{{2,4},{0,2},{0,4}};

        int ans[] = new Solution().shortestDistanceAfterQueries(5, g);
        System.out.println(Arrays.toString(ans));
    }
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int q = queries.length;
        int ans[] = new int[q];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n-1;i++){
            map.put(i, i+1);

        }
        for(int i=0;i<q;i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int next = map.getOrDefault(u, -1);
            
            if(next ==-1 || next > v){
                ans[i] = map.size();
                continue;
            }
            
            map.put(u, v);
            
            while(next < v){
                map.remove(next);
                next++;
            }
            ans[i] = map.size();
        }
        return ans;
    }

}
