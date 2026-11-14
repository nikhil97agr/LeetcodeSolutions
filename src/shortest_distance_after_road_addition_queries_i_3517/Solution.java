package shortest_distance_after_road_addition_queries_i_3517;

import java.util.*;
class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int q = queries.length;
        
        int ans[] = new int[q];
        LinkedList<Integer> adjList[] = new LinkedList[n];
        
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }
        
        for(int i=0;i<n-1;i++){
            adjList[i].add(i+1);
        }
        


        for(int i=0;i<q;i++){
            int u = queries[i][0];
            int v = queries[i][1];
            adjList[u].add(v);
            
            PriorityQueue<int[]> que =new PriorityQueue<>((a,b)-> a[1] - b[1]);
            que.offer(new int[]{0, 0});
            
            boolean vis[] = new boolean[n];
            while(!que.isEmpty()){
                int node[] = que.poll();
                int x = node[0];
                int d = node[1];
                vis[x] = true;
                if(x == n-1){
                    ans[i] = d;
                    break;
                }
                
                
                for(int y : adjList[x]){
                    if(!vis[y]){
                        vis[y] = true;
                        que.offer(new int[]{y,d+1});
                    }
                }
            }
        }
        
        
        return ans;
    }
}