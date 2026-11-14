package choose_edges_to_maximize_score_in_a_tree_2517;

import java.util.*;
import java.util.stream.*;
class Solution {
    public long maxScore(int[][] edges) {
         int n = edges.length;
         List<int[]> list[] =IntStream.range(0, n).boxed().map(x-> new ArrayList<>()).toArray(List[]::new);

         for(int i=1;i<n;i++){
            int e[] = edges[i];
            int par = e[0];
            int val = e[1];
            list[par].add(new int[]{i, val});
         }
        
        long dp[][] = new long[n][2];
        dfs(0, 0, list, dp);
        return dp[0][0];
    }

    private long dfs(int curr, int parSize, List<int[]>[] list, long dp[][]){
        long sum = 0;
        for(int child[] : list[curr]){
           sum+= dfs(child[0], child[1], list, dp);
            
        }


         dp[curr][1] = sum + Math.max(parSize, 0);
        
        long max = sum;

        for(int child[] : list[curr]){
            int u = child[0];
            max = Math.max(dp[u][1] + sum - dp[u][0], max);
        }

        dp[curr][0] = max;

        return dp[curr][0];

    }
}