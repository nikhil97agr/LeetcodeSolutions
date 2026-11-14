package minimum_cost_to_convert_string_ii_3238;

import java.util.*;
// Java Solution
class Solution {
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        int cnt = 0;
        Map<String, Integer> id = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            if (!id.containsKey(original[i])) id.put(original[i], cnt++);
            if (!id.containsKey(changed[i])) id.put(changed[i], cnt++);
        }

        long INF = (long) 1e18;
        long[][] dist = new long[cnt][cnt];
        for (int i = 0; i < cnt; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < original.length; i++) {
            int u = id.get(original[i]);
            int v = id.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < cnt; k++)
            for (int i = 0; i < cnt; i++)
                for (int j = 0; j < cnt; j++)
                    if (dist[i][k] < INF && dist[k][j] < INF)
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

        int n = source.length();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == INF) continue;

            if (source.charAt(i) == target.charAt(i))
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);

            for (Map.Entry<String, Integer> e1 : id.entrySet()) {
                String src = e1.getKey();
                int si = e1.getValue();
                int len = src.length();
                if (i + len > n) continue;
                if (source.substring(i, i + len).equals(src)) {
                    for (Map.Entry<String, Integer> e2 : id.entrySet()) {
                        String tar = e2.getKey();
                        int ti = e2.getValue();
                        if (tar.length() != len) continue;
                        if (target.substring(i, i + len).equals(tar) && dist[si][ti] < INF) {
                            dp[i + len] = Math.min(dp[i + len], dp[i] + dist[si][ti]);
                        }
                    }
                }
            }
        }

        return dp[n] >= INF ? -1 : dp[n];
    }
}