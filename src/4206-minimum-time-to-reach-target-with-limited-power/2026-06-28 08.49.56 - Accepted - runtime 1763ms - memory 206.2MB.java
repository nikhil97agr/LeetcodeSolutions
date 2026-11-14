import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    List<Edge> list[];

    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {

        list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (var edge : edges) {
            var u = edge[0];
            var v = edge[1];
            var t = edge[2];

            list[u].add(new Edge(v, t));

        }

        PriorityQueue<Path> que = new PriorityQueue<>((p1, p2) -> {
            if (p1.time == p2.time) {
                return p2.power - p1.power;
            }

            return Long.compare(p1.time, p2.time);
        });

        que.offer(new Path(source, power, 0));
        long time = Long.MAX_VALUE / 4;
        long p = Long.MIN_VALUE / 4;
        long dp[][] = new long[n][power + 1];
        for(var d : dp){
            Arrays.fill(d, Long.MAX_VALUE/ 4);
        }
        dp[source][power] = 0;
        while (!que.isEmpty()) {
            var next = que.poll();
            var src = next.dest;
            var pow = next.power;
            var t = next.time;
            if (t > dp[src][pow]) {
                continue;
            }
            if (src == target) {
                if (t < time) {
                    time = t;
                    p = pow;
                } else if (t == time && pow > p) {
                    p = pow;
                }

                continue;
            }
            if (pow < cost[src]) {
                continue;
            }

            for (var child : list[src]) {
                var dest = child.dest;
                var tt = child.time;

                var nextime = t + tt;
                var nextpow = pow - cost[src];

                if (nextime < dp[dest][nextpow]) {
                    dp[dest][nextpow] = nextime;
                    que.offer(new Path(dest, nextpow, nextime));
                }
            }
        }

        if (time == Long.MAX_VALUE / 4) {
            return new long[]{-1, -1};
        }

        return new long[]{time, p};


    }

    class Path {

        int dest;
        int power;
        long time;

        public Path(int dest, int power, long time) {

            this.dest = dest;
            this.power = power;
            this.time = time;
        }
    }

    class Edge {

        int dest;
        long time;

        public Edge(int dest, long time) {

            this.dest = dest;
            this.time = time;
        }
    }
}