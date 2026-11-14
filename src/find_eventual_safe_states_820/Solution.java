package find_eventual_safe_states_820;

import java.util.*;
import java.util.stream.*;
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> result = new HashSet<>();
        int n = graph.length;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, visited, new boolean[n],graph, result);
            }
        }
        for(int i=0;i<n;i++){
            if(graph[i].length==0) result.add(i);
        }
        return result.stream().sorted().collect(Collectors.toList());
    }

    public boolean dfs(int i, boolean vis[],boolean rec[], int graph[][], Set<Integer> result){
        if(graph[i].length==0){
            return true;
        }

        vis[i] = true;
        rec[i] = true;

        for(int x : graph[i]){
            if(!vis[x]){
                if(!dfs(x, vis, rec, graph, result)) return false;
            }
            if(vis[x]){
                if(result.contains(x)) continue;
                else return false;
            }
            if(rec[x]) return false;
        }


        rec[i] = false;
        result.add(i);
        return true;
    }

}