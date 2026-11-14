class Solution {
    static class State {
        int node;
        int used;
        long dist;

        State(int node, int used, long dist) {
            this.node = node;
            this.used = used;
            this.dist = dist;
        }
    }

    public long minCostExcludingMax(int n, int[][] edges) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            adj[e[1]].add(new int[]{e[0], e[2]});
        }

        long INF = Long.MAX_VALUE / 4;
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) {
            dist[i][0] = dist[i][1] = INF;
        }

        PriorityQueue<State> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[0][0] = 0;
        pq.offer(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();
            int u = cur.node;
            int used = cur.used;
            long d = cur.dist;

            if (d >= dist[n-1][1] || d > dist[u][used]) continue;

            for (int[] edge : adj[u]) {
                int v = edge[0];
                int w = edge[1];

                if (d + w < dist[v][used]) {
                    dist[v][used] = d + w;
                    pq.offer(new State(v, used, dist[v][used]));
                }

                if (used == 0 && d < dist[v][1]) {
                    dist[v][1] = d;
                    pq.offer(new State(v, 1, d));
                }
            }
        }

        return dist[n - 1][1];
    }
}
