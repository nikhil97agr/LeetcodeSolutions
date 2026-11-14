package shortest_cycle_in_a_graph_2671;

import java.util.*;
class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] =new LinkedList<>();
        }
        
        for(int edge[] : edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        
        boolean visited[] = new boolean[n];
        int cycle = Integer.MAX_VALUE;
        int depth[] = new int[n];
        Arrays.fill(depth, 0);
        return shortest_cycle(n, adjList);
    }


    static int shortest_cycle(int n, LinkedList<Integer> adjList[])
    {
 
        int ans = Integer.MAX_VALUE;
 
        for (int i = 0; i < n; i++)
        {
 
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
 
            int[] parent = new int[n];
            Arrays.fill(parent, -1);
 
            dist[i] = 0;
            Queue<Integer> q = new LinkedList<>();
 
            q.add(i);
 
            while (!q.isEmpty())
            {
 
                int x = q.poll();
                Iterator<Integer> it = adjList[x].iterator();
                while(it.hasNext())
                {
                    int child = it.next();
                    if (dist[child] == Integer.MAX_VALUE)
                    {
 
                        dist[child] = 1 + dist[x];
 
                        parent[child] = x;
 
                        q.add(child);
                    } else if (parent[x] != child && parent[child] != x)
                        ans = Math.min(ans, dist[x] + dist[child] + 1);
                }
            }
        }
 
        if (ans == Integer.MAX_VALUE)
            return -1;
 
        else
            return ans;
    }
}