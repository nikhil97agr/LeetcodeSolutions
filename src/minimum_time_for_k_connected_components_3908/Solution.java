package minimum_time_for_k_connected_components_3908;

import java.util.*;
import java.util.LinkedList;

class Solution {
    public int minTime(int n, int[][] edges, int k) {
        LinkedList<Edge> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] =new LinkedList<>();
        }

        int min =0;
        int max= 1;

        for(int e[] : edges)
        {
            int u = e[0];
            int v = e[1];
            int time = e[2];
            adjList[u].add(new Edge(v, time));
            adjList[v].add(new Edge(u, time));
            max = Math.max(max, time);
        }

        int ans = 0;
        while(min <= max){
            int mid = min + (max - min)/2;
            if(possible(adjList, k, mid)){
                ans = mid;
                max = mid-1;
            }else{
                min = mid+1;
            }
        }




        return ans;

    }

    private boolean possible(LinkedList<Edge> adjList[] ,int k, int mid){
        int cnt = 0;
        boolean vis[] = new boolean[adjList.length];
        int n = adjList.length;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                cnt++;

                dfs(adjList, mid, i, vis);
            }
        }
        return cnt >= k;
    }

    private void dfs(LinkedList<Edge> adjList[], int mid, int u, boolean vis[]){
        vis[u] = true;

        for(Edge e : adjList[u]){
            if(e.time > mid && !vis[e.v]){
                dfs(adjList, mid, e.v, vis);
            }
        }
    }

    class Edge{
        int v;
        int time;
        public  Edge(int v, int time)

        {
            this.v = v;
            this.time = time;
        }
    }
}