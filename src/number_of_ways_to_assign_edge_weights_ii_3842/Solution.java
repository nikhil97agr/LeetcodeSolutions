package number_of_ways_to_assign_edge_weights_ii_3842;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {

    int depth[];
    int parent[][];
    int max = 16;
    List<Integer> adjList[];

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        depth = new int[n];
        parent = new int[n][max];

        adjList = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (var edge : edges) {
            var u = edge[0] - 1;
            var v = edge[1] - 1;
            adjList[u].add(v);
            adjList[v].add(u);
        }

        dfs(0, 0, 0);
        Integer dp[][] = new Integer[n + 1][2];
        var ans = new int[queries.length];
        for (var i = 0; i < queries.length; i++) {
            var q = queries[i];
            var u = q[0] - 1;
            var v = q[1] - 1;

            int lca = lca(u, v);

            int depthDiff = depth[u] + depth[v] - 2 * depth[lca];

            ans[i] = dfs(depthDiff, 0, dp);

        }

        return ans;
    }

    private int dfs(int n, int sum, Integer dp[][]) {

        if ( n == 0) {
            return sum;
        }

        if (dp[n][sum] != null) {
            return dp[n][sum];
        }

        return dp[n][sum] = add(dfs( n- 1, (sum + 1) % 2, dp), dfs(n - 1, (sum + 2) % 2, dp));
    }

    private int add(int a, int b) {

        int mod = 1_000_000_007;

        long sum = 1l * a + b;

        return (int) (sum % mod);
    }

    private int lca(int u, int v) {

        if (depth[u] < depth[v]) {
            return lca(v, u);
        }

        int diff = depth[u] - depth[v];

        for (int i = max - 1; i >= 0; i--) {
            int bit = (diff >> i) & 1;

            if (bit == 1) {
                u = parent[u][i];
            }
        }

        if (u == v) {
            return u;
        }

        for (int i = max - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }


    private void dfs(int curr, int par, int d) {

        depth[curr] = d;

        parent[curr][0] = par;

        for (int i = 1; i < max; i++) {
            int prev = parent[curr][i - 1];
            parent[curr][i] = parent[prev][i - 1];
        }

        for (var child : adjList[curr]) {
            if (child == par) {
                continue;
            }

            dfs(child, curr, d + 1);
        }
    }
}