package minimum_time_to_visit_disappearing_nodes_3389;

import java.util.*;
class Solution {
    public int[] minimumTime(int n, int[][] edges, int[] d) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        LinkedList<Pair> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }
        for(int e[] : edges){
            adjList[e[0]].add(new Pair(e[1], e[2]));
            adjList[e[1]].add(new Pair(e[0], e[2]));
        }
        que.offer(new int[]{0, 0});
        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        boolean vis[] = new boolean[n];
        while(!que.isEmpty()){
            int []node = que.poll();
            if(vis[node[0]]) continue;
            vis[node[0]] = true;
            if(d[node[0]] <= node[1]){
                continue;
            }
            
            ans[node[0]] = node[1];
            
            for(Pair p : adjList[node[0]]){
                if(!vis[p.node]){
                    que.offer(new int[]{p.node, node[1] + p.dist});
                }
            }
            
            
            
        }
        return ans;
    }
    
    class Pair{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }
    
}