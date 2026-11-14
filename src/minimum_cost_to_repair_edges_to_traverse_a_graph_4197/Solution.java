package minimum_cost_to_repair_edges_to_traverse_a_graph_4197;

import java.util.*;
class Solution {
    public int minCost(int n, int[][] edges, int k) {
        LinkedList<int[]> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        int ans = -1;

        int min = 0;
        int max =0;
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            max = Math.max(max, w);
            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, w});
        }

        while(min <= max){
            int mid = min + (max - min)/2;

            if(possible(adjList, mid, k, n)){
                ans = mid;
                max = mid -1 ;
            }else{
                min =mid + 1;
            }
        }

        return ans;
    }

    private boolean possible(LinkedList<int[]> adjList[], int money, int k, int n){
        PriorityQueue<int[]> que= new PriorityQueue<>((a,b) -> a[1] - b[1]);

        que.offer(new int[]{0,0});
        boolean vis[] = new boolean[n];
        vis[0] = true;
        while(!que.isEmpty()){
            int next[] = que.poll();
            if(next[0] == n-1) return true;

            if(next[1] == k) continue;

            for(int []child : adjList[next[0]]){
                int v = child[0];
                int w = child[1];
                if(w > money || vis[v]) continue;
                vis[v] = true;
                que.offer(new int[]{v, next[1] + 1});
            }
        }

        return false;
    }
}