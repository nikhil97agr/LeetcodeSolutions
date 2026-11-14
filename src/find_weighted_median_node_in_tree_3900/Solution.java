package find_weighted_median_node_in_tree_3900;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {

    List<int[]> adjList[];
    int depth[];
    long dist[];
    int par[][];
    int log = 20;

    public int[] findMedian(int n, int[][] edges, int[][] queries) {

        adjList = new ArrayList[n];
        dist = new long[n];
        depth = new int[n];
        par = new int[n][log];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, w});
        }

        dfs(0, 0, 1, 0);

        int ans[] = new int[queries.length];

        for (var i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            if (u == v) {
                ans[i] = u;
                continue;
            }

            int lca = lca(u, v);
            long total = dist[u] + dist[v] - 2 * dist[lca];
            int start = 0;
            int end = depth[u] + depth[v] - 2 * depth[lca];
            int res = v;

            while (start <= end) {
                int mid = (start + end) / 2;
                int midNode = getMedian(u, v, lca, mid);
                int lcaMid = lca(u, midNode);
                long midWeight = dist[u] + dist[midNode] - 2 * dist[lcaMid];
                if (midWeight * 2 >= total) {
                    res = midNode;
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }

            ans[i] = res;
        }

        return ans;
    }

    private int getMedian(int u, int v, int lca, int midIndex) {
        if(depth[u] > depth[v] && lca == v){
            return getMedian(v, u, lca, depth[u] - depth[v] - midIndex);
        }
        int lenUl = depth[u] - depth[lca] + 1;

        if (midIndex < lenUl) {
            return liftUp(u, midIndex);

        }

        int remain = midIndex - (lenUl - 1);
        int lenVl = depth[v] - depth[lca];
        int diff = lenVl - remain;
        return liftUp(v, diff);


    }

    private int liftUp(int u, int dist) {

        for (int i = log - 1; i >= 0; i--) {
            int bit = (dist >> i) & 1;
            if (bit == 1) {
                u = par[u][i];
            }
        }

        return u;
    }

    private int lca(int u, int v) {

        if (depth[u] < depth[v]) {
            return lca(v, u);
        }

        u = liftUp(u, depth[u] - depth[v]);
        if(u== v) return u;
        for (int i = log - 1; i >= 0; i--) {
            if (par[u][i] != par[v][i]) {
                u = par[u][i];
                v = par[v][i];
            }
        }

        return par[u][0];
    }

    private void dfs(int curr, int p, int d, long distance) {

        dist[curr] = distance;
        depth[curr] = d;
        par[curr][0] = p;
        for (int i = 1; i < log; i++) {
            int pp = par[curr][i - 1];
            par[curr][i] = par[pp][i - 1];
        }

        for (var child : adjList[curr]) {
            int v = child[0];
            int w = child[1];

            if (v == p) {
                continue;
            }
            dfs(v, curr, d + 1, distance + w);
        }
    }
}