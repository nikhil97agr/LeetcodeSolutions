package minimum_threshold_path_with_limited_heavy_edges_4102;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public int minimumThreshold(int n, int[][] edges, int source, int target, int k) {

        int max = 0;
        for (int e[] : edges) {
            max = Math.max(max, e[2]);
        }

        int ans = -1;
        int start = 0;
        int end = max;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (check(n, edges, source, target, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    private boolean check(int n, int[][] edges, int src, int target, int k, int mid) {

        int max = Integer.MAX_VALUE;
        int dist[] = new int[n];

        Arrays.fill(dist, max);

        dist[src] = 0;

        List<int[]> adjList[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int w = (e[2] > mid) ? 1 : 0;
            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, w});
        }

        var que = new PriorityQueue<int[]>(Comparator.comparingInt(a -> a[0]));

        que.offer(new int[]{0, src});

        while (!que.isEmpty()) {
            var next = que.poll();
            int d = next[0];
            int node = next[1];

            if (dist[node] != d) {
                continue;
            }

            for (var child : adjList[node]) {
                int v = child[0];
                int w = child[1];

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    que.offer(new int[]{d + w, v});
                }
            }
        }

        if (dist[target] <= k) {
            return true;
        }

        return false;
    }
}