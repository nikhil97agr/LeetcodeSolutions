package minimize_the_maximum_edge_weight_of_graph_3720;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        
        int ans = -1;
        
        int l = 0;
        int r = 0;
        
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            r = Math.max(r, w);
            int val = map.getOrDefault(v, new HashMap<>()).getOrDefault(u, Integer.MAX_VALUE);
            map.computeIfAbsent(v, x -> new HashMap<>()).put(u, Math.min(val, w));
        }
        
        while(l <= r){
            int mid = (l+r)/2;
            
            boolean vis[] = new boolean[n];
            dfs(vis, 0,-1, map, mid);
            boolean res = true;
            for(boolean x : vis){
                if(!x){
                    res = false;
                    break;
                }
            }
            
            if(res){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        return ans;
        
    }

    private void dfs(boolean[] vis, int u, int par, Map<Integer, Map<Integer, Integer>> map, int mid) {
        
        vis[u] = true;
        
        for(Map.Entry<Integer, Integer> entry : map.getOrDefault(u, new HashMap<>()).entrySet()){
            int key = entry.getKey();
            int val = entry.getValue();
            if(!vis[key] && val <= mid && key != par){
                dfs(vis, key, u, map, mid);
            }
        }
    }
}