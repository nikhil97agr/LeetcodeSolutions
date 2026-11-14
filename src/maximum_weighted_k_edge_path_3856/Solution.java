package maximum_weighted_k_edge_path_3856;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public int maxWeight(int n, int[][] edges, int k, int t) {

        Set<Integer>[][] dp = new HashSet[n][k + 1];
        for (var i = 0; i < n; i++) {
            for (var j = 0; j <= k; j++) {
                dp[i][j] = new HashSet<>();
            }
            dp[i][0].add(0);
        }

        for (var len = 1; len <= k; len++) {
            for (var e : edges) {
                var u = e[0];
                var v = e[1];
                var w = e[2];
                for (int weight : dp[u][len - 1]) {
                    if (weight + w < t) {
                        dp[v][len].add(weight + w);
                    }
                }
            }
        }
        
        int ans =-1;
        for(int i=0;i<n;i++){
            if(dp[i][k].isEmpty()) continue;
           ans = Math.max(ans, dp[i][k].stream().max(Integer::compareTo).get());
        }
        return ans;
    }
}