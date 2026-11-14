package minimum_cost_to_buy_apples_ii_3976;

import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    long max = 1_000_000_000_000_000L;

    public int[] minCost(int n, int[] prices, int[][] roads) {

        List<Edge> empty[] = new ArrayList[n];
        List<Edge> carry[] = new ArrayList[n];

        build(empty, roads, n, false);
        build(carry, roads, n, true);

        long emptyDist[][] = new long[n][n];
        long carryDist[][] = new long[n][n];

        for (int i = 0; i < n; i++) {
            emptyDist[i] = solve(i, empty, n);
            carryDist[i] = solve(i, carry, n);
        }

        var ans = new int[n];

        for (int i = 0; i < n; i++) {
            long res = Long.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                long dist = emptyDist[i][j] + prices[j] + carryDist[j][i];

                res = Math.min(res, dist);
            }

            ans[i] = (int) res;
        }

        return ans;

    }

    public long[] solve(int src, List<Edge> list[], int n) {

        long dist[] = new long[n];
        Arrays.fill(dist, max);

        dist[src] = 0;

        var que = new PriorityQueue<Node>(Comparator.comparingLong(a -> a.dist));

        que.offer(new Node(src, 0));

        while (!que.isEmpty()) {
            var node = que.poll();
            var d = node.dist;
            var u = node.dest;

            if (dist[u] != d) {
                continue;
            }

            for (var child : list[u]) {
                var v = child.dest;
                var w = child.cost;

                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    que.offer(new Node(v, dist[v]));
                }
            }
        }

        return dist;

    }

    private void build(List<Edge> list[], int[][] roads, int n, boolean tax) {

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int r[] : roads) {
            int u = r[0];
            int v = r[1];
            int c = r[2];
            int t = r[3];

            if (tax) {
                list[u].add(new Edge(v, 1l * c * t));
                list[v].add(new Edge(u, 1l * c * t));
            } else {
                list[u].add(new Edge(v, c));
                list[v].add(new Edge(u, c));
            }
        }
    }

    class Node {

        int dest;
        long dist;

        public Node(int dest, long dist) {

            this.dest = dest;
            this.dist = dist;
        }
    }

    class Edge {

        int dest;
        long cost;

        public Edge(int dest, long cost) {

            this.dest = dest;
            this.cost = cost;
        }
    }
}