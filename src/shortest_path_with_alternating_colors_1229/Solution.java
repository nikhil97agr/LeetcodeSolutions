package shortest_path_with_alternating_colors_1229;

import java.util.*;
class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        LinkedList<Edge> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();

        for(int red[] : redEdges){
            adjList[red[0]].add(new Edge(red[1], 0));
        }

        for(int blue[] : blueEdges){
            adjList[blue[0]].add(new Edge(blue[1], 1));


        }

        boolean visited[][] = new boolean[n][2];

        visited[0][0] = true;
        visited[0][1] = true;
        int ans[] = new int[n];
        Arrays.fill(ans , -1);
        ans[0] = 0;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, -1});
        while(!que.isEmpty()){
            int edge[] = que.poll();
            int node = edge[0];
            int step = edge[1];
            int color = edge[2];

            Iterator<Edge> it = adjList[node].iterator();
            while(it.hasNext()){
                Edge e = it.next();

                if(!visited[e.dest][e.color] && e.color != color){
                    if(ans[e.dest]==-1) ans[e.dest] =step+1;

                    visited[e.dest][e.color] = true;
                    que.offer(new int[]{e.dest, step+1, e.color});
                }
            } 
        }
        return ans;
    }
    class Edge{
        int dest;
        int color;

        public Edge(int dest, int color){
            this.dest = dest;
            this.color = color;
        }
    }
}