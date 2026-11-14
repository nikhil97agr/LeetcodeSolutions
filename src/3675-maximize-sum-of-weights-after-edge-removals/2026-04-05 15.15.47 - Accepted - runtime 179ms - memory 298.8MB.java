import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    List<int[]> adjList[];
    int k;

    public long maximizeSumOfWeights(int[][] edges, int k) {

        int n = edges.length + 1;
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        this.k = k;
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, w});

        }

        return dfs(0, -1)[1];
    }

    private long[] dfs(int curr, int par) {

        long withouK = 0;
        PriorityQueue<Long> diff = new PriorityQueue<>(Collections.reverseOrder());
        for (int[] child : adjList[curr]) {
            int v = child[0];
            int w = child[1];
            if (v == par) {
                continue;
            }
            long result[] = dfs(v, curr);
            withouK += result[1];

            diff.add(Math.max(0l, result[0] + w - result[1]));
        }

        var que = new PriorityQueue<Long>(diff);
        long withK = withouK;
        for (int i = 0; i < k - 1 && !que.isEmpty(); i++) {
            withouK += que.poll();
        }
        que = new PriorityQueue<>(diff);
        for (int i = 0; i < k && !que.isEmpty(); i++) {
            withK += que.poll();
        }

        return new long[]{withouK, withK};
    }

}