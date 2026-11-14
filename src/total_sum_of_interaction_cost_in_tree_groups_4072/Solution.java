package total_sum_of_interaction_cost_in_tree_groups_4072;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        new Solution().interactionCosts(4, new int[][]{{0,1}, {1,2}, {0,3}}, new int[]{2,5,3,3});
    }
    List<Integer> adjList[];
    int n;
    long ans;
    int grp[];
    long cnt[][];
    public long interactionCosts(int n, int[][] edges, int[] group) {
        grp = group;
        this.n = n;
        adjList = new ArrayList[n];

        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        Set<Integer> groups = new HashSet<>();
        for(int g: group){
            groups.add(g);
        }
        for(int g : groups){
            cnt = new long[n][2];
            dfs(0, -1, g);

            bfs(0, -1, g, 0, 0);

        }

        return ans;
    }
    private void bfs(int curr, int par, int g, long dist, long nodes){
        if(grp[curr] == g){
            ans += dist;
        }
        long newDist = cnt[curr][0];
        long newNodes = cnt[curr][1];

        for(int child : adjList[curr]){
            if(child == par) continue;
            int sub = grp[child] == g ? 1 : 0;
            newDist = newDist - cnt[child][0] - cnt[child][1] - sub;
            newNodes = newNodes - cnt[child][1] - sub;

            bfs(child, curr, g, dist + newDist + nodes + newNodes, newNodes + nodes);
        }


    }

    private long[] dfs(int curr, int par, int g){
        long dist = 0;
        long nodes = 0;
        for(int child : adjList[curr]){
            if(child == par) continue;
            long next[] = dfs(child, curr, g);

            nodes += next[1];
            dist += next[0];

        }
        if(grp[curr] == g){
            ans += dist;

        }
        cnt[curr] = new long[]{dist, nodes};
        if(grp[curr] == g){
            nodes++;
        }
        return new long[]{dist + nodes, nodes};
    }
}