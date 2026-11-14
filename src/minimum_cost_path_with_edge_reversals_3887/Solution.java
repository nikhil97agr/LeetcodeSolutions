package minimum_cost_path_with_edge_reversals_3887;

import java.util.*;

import java.text.Normalizer.Form;class Solution {
    public int minCost(int n, int[][] edges) {
        List<int[]> []list = new ArrayList[n];
        List<int[]> reverse[] =new ArrayList[n];

        for(int i=0;i<n;i++){
            list[i]= new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];

            list[u].add(new int[]{v, w});
            reverse[v].add(new int[]{u, 2*w});
        }

        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        que.offer(new int[]{0, 0, 0});
        int dist[][] = new int[n][2];
        for(int x[] : dist){
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        dist[0][0] =0;
        int ans = Integer.MAX_VALUE;
        while(!que.isEmpty()){
            int next[] = que.poll();
            int u = next[0];
            int d = next[1];
            int flag = next[2];

            if(u == n-1) {
                ans = Math.min(ans, d);
                continue;
            }
            if(d > dist[u][flag]) continue;
            for(int child[] : list[u]){
                int v=  child[0];
                int w = child[1];
                if(d + w < dist[v][flag]){
                    que.offer(new int[]{v, d + w, flag});
                    dist[v][flag] = d + w;
                }
            }

                for(int child[] : reverse[u]){
                    int v = child[0];
                    int w = child[1];
                    if(d + w < dist[v][1]){
                        dist[v][1] = d + w;
                        que.offer(new int[]{v, d+w, 1});
                    }
                }
            
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}