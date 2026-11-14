package the_most_similar_path_in_a_graph_1687;

import java.util.*;
class Solution {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] target) {
        int m = target.length;
        int dp[][] = new int[m][n];

        for(int x[] : dp){
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        int parent[][] = new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i] = (names[i].equals(target[0]) ? 0 : 1);
        }

        for(int i=1;i<m;i++){
            for(int road[] : roads){
                int u = road[0];
                int v = road[1];
                int uv = dp[i-1][u] + (names[v].equals(target[i]) ? 0 : 1);
                int vu = dp[i-1][v] + (names[u].equals(target[i]) ? 0 : 1);
                if(uv < dp[i][v]){
                    dp[i][v] = uv;
                    parent[i][v] = u;
                }

                if(vu < dp[i][u]){
                    dp[i][u] = vu;
                    parent[i][u] = v;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int node = -1;
        int dist = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(dp[m-1][i] < dist){
                node = i;
                dist = dp[m-1][i];
            }
        }

        result.add(node);
        for(int i=m-1;i>0;i--){
            node = parent[i][node];
            result.add(node);
        }

        Collections.reverse(result);
        return result;

    }
}