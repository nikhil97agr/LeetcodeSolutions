package difference_between_maximum_and_minimum_price_sum_2627;

import java.util.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {

    long ans = 0;
    int n;
    LinkedList<Integer> adjList[];
    Map<Integer, Long> pathSum[];
    int prices[];

    public long maxOutput(int n, int[][] edges, int[] price) {

        this.prices = price;
        this.n = n;
        adjList = new LinkedList[n];
        pathSum = new HashMap[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new LinkedList<>();
            pathSum[i] = new HashMap<>();
        }

        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        dfs(0, -1);
        dfs(0, -1, 0l);

        return ans;
    }

    private void dfs(int u, int par, long sum) {
        if(pathSum[u].isEmpty()){
            ans = Math.max(ans, sum);
            return;
        }
        

        long max1 = -1;
        long max2 = -1;
        long u1 = -1;
        long u2 = -1;

        for (var entry : pathSum[u].entrySet()) {
            int child = entry.getKey();
            long s = entry.getValue();

            if (s > max1) {
                max2 = max1;
                u2 = u1;
                max1 = s;
                u1 = child;
            } else if (s > max2) {
                max2 = s;
                u2 = child;
            }
        }

        ans = Math.max(ans, Math.max(sum, max1));
        for (int child : adjList[u]) {
            if (child == par) {
                continue;
            }

            if (child != u1 && child != u2) {
                dfs(child, u, Math.max(sum, max1) + prices[u]);
            } else if (child != u1) {
                dfs(child, u, Math.max(sum, max1) + prices[u]);
            } else if (child != u2) {
                dfs(child, u, Math.max(sum, max2) + prices[u]);
            }
        }
    }

    private long dfs(int u, int par) {

        long max = 0;
        for (int child : adjList[u]) {
            if (child == par) {
                continue;
            }

            long next = dfs(child, u);
            pathSum[u].put(child, next);
            max = Math.max(max, next);
        }

        return max + prices[u];
    }


}