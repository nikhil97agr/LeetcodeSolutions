package maximum_path_quality_of_a_graph_2189;

import java.util.*;
import java.util.concurrent.atomic.*;
class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        int n = values.length;
        List<int[]> list[] = new ArrayList[n];
        for(int i=0;i<n;i++) list[i] =new ArrayList<>();
        for(int e[] :edges){
            int u = e[0];
            int v = e[1];
            int t = e[2];
            list[u].add(new int[]{v, t});
            list[v].add(new int[]{u, t});
        }
        AtomicInteger ans = new AtomicInteger(0);
        
        Set<Integer> vis = new HashSet<>();
        vis.add(0);
        dfs(0, list, vis, 0, maxTime, values, values[0], ans);

        return ans.get();
    }

    private void dfs(int curr, List<int[]> []list, Set<Integer> vis, int currTime, int maxTime, int values[], int currValue, AtomicInteger ans){
        if(curr ==0){
            ans.set(Math.max(ans.get(), currValue));
        }

        for(int child[] : list[curr]){
            int v = child[0];
            int t = child[1];

            if(currTime + t > maxTime) continue;

            if(!vis.contains(v)){
                vis.add(v);
                dfs(v, list, vis, currTime + t, maxTime, values, currValue + values[v], ans);
                vis.remove(v);
            }else{
                dfs(v, list, vis, currTime + t, maxTime, values, currValue, ans);
            }
        }
    }




}