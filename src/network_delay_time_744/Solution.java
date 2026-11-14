package network_delay_time_744;

import java.util.*;
class Solution {
    class Pair{
        int v;
        int dist;
        public Pair(int v, int dist){
            this.v = v;
            this.dist = dist;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<Pair> que = new PriorityQueue<>((a,b) -> a.dist - b.dist);

        int dist[] = new int[n];
        LinkedList<Pair> adjList[] = new LinkedList[n];
        for(int time[] : times){
            int src = time[0]-1;
            int dest = time[1]-1;
            int d = time[2];

            if(adjList[src] == null) adjList[src] = new LinkedList<>();

            if(adjList[dest] == null) adjList[dest] = new LinkedList<>();

            adjList[src].add(new Pair(dest, d));
        }

        que.add(new Pair(k-1, 0));
            Arrays.fill(dist, Integer.MAX_VALUE);

            dist[k-1] = 0;
        while(!que.isEmpty()){
                Pair p = que.poll();

                Iterator<Pair> it = adjList[p.v].iterator();
                while(it.hasNext()){
                    Pair pair = it.next();

                    if(dist[pair.v] > p.dist + pair.dist){
                        dist[pair.v] = p.dist + pair.dist;

                        que.add(new Pair(pair.v, dist[pair.v]));
                    }
                }
        }

        int ans = 0;
        for(int x : dist){
            if(x==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, x);
        }

        return ans;
    }
}