package minimum_degree_of_a_connected_trio_in_a_graph_1887;

import java.util.*;
class Solution {
    public int minTrioDegree(int n, int[][] edges) {
        int ans = Integer.MAX_VALUE;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i, new HashSet<>());
        }
        for(int e[] : edges){
            int u = e[0]-1;
            int v = e[1]-1;
            map.get(u).add(v);
            map.get(v).add(u);
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(map.get(i).contains(j) && map.get(j).contains(k) && map.get(k).contains(i)){
                        ans = Math.min(ans, map.get(i).size() + map.get(j).size() + map.get(k).size() - 6);
                    }
                }
            }
        }


        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}