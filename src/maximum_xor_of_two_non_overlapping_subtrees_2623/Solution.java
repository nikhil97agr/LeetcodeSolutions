package maximum_xor_of_two_non_overlapping_subtrees_2623;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {

    int maxBit = 45;
    Trie trie;
    List<Integer> adjList[];
    int n;
    long ans = 0;
    long sum[];
    int values[];

    public long maxXor(int n, int[][] edges, int[] values) {

        this.n = n;
        trie = new Trie();
        adjList = new ArrayList[n];
        this.values = values;
        sum = new long[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    private void dfs2(int u, int par) {

        long res = trie.xor(sum[u], maxBit);
        ans = Math.max(ans, res);
        for (int child : adjList[u]) {
            if (child == par) {
                continue;
            }
            dfs2(child,u);
        }
        trie.add(sum[u], maxBit);
        
    }

    private long dfs(int u, int par) {

        long total = 0;
        for (int child : adjList[u]) {
            if (child == par) {
                continue;
            }
            total += dfs(child, u);

        }
        total += values[u];
        sum[u] = total;
        return total;
    }

    class Trie {

        Trie trie[];

        public Trie() {

            trie = new Trie[2];
        }

        public void add(long num, int bit) {

            if (bit == -1) {
                return;
            }

            int ind = (int) ((num >> bit) & 1);

            if (trie[ind] == null) {
                trie[ind] = new Trie();
            }
            trie[ind].add(num, bit - 1);
        }

        public long xor(long num, int bit) {

            if (bit == -1) {
                return 0;
            }

            int ind = (int) ((num >> bit) & 1);
            if (trie[1 - ind] != null) {
                return (1l << bit) | (trie[1 - ind].xor(num, bit - 1));
            } else if (trie[ind] != null) {
                return trie[ind].xor(num, bit - 1);
            }

            return 0;
        }
    }
}