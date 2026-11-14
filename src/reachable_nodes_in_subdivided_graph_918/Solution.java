package reachable_nodes_in_subdivided_graph_918;

import java.util.*;
class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        int m = edges.length;
        List<int[]>[] list = new ArrayList[n];
        for(int i=0;i<n;i++) list[i] = new ArrayList<>();
        for(int i=0;i<m;i++){
            int e[] = edges[i];
            int u = e[0];
            int v =e[1];
            list[u].add(new int[]{v, i});
            list[v].add(new int[]{u, i});
        }
        int moved[] = new int[m];
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int vis[] = new int[n];
        Arrays.fill(vis, Integer.MAX_VALUE);
        que.offer(new int[]{0, 0});
        vis[0] = 0;
        while(!que.isEmpty()){
            int next[] = que.poll();
            int u = next[0];
            int moves = next[1];
            if(moves > vis[u]) continue;
            for(int child[] : list[u]){
                int v = child[0];
                int cnt = edges[child[1]][2];
                int ind = child[1];
                if(moves+cnt+1 < vis[v]){
                    vis[v] = moves + cnt + 1;
                    que.offer(new int[]{v, moves + cnt + 1});
                }
            }
        }

        int ans = 0;
        for(int x : vis){
            if(x <= maxMoves) ans++;
        }

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int cnt = e[2];

            int a = Math.max(0, maxMoves - vis[u]);
            int b = Math.max(0, maxMoves - vis[v]);

            ans += Math.min(cnt, a+ b);
        }

        return ans;
    }
}