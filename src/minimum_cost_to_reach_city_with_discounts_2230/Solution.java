package minimum_cost_to_reach_city_with_discounts_2230;

import java.util.*;
import java.util.stream.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Solution {
    public int minimumCost(int n, int[][] highways, int discounts) {

        LinkedList<int[]> adjList[] = IntStream.range(0, n).boxed().map(x -> new LinkedList<int[]>()).toArray(LinkedList[]::new);

        for(int h[] : highways){
            int u = h[0];
            int v = h[1];

            adjList[u].add(new int[]{v, h[2]});
            adjList[v].add(new int[]{u, h[2]});
        }

        PriorityQueue<Path> que = new PriorityQueue<>(Comparator.comparingInt(Path::getDist));
        int dist[][] = new int[n][discounts + 1];

        for(int d[] : dist) Arrays.fill(d, Integer.MAX_VALUE);
        Arrays.fill(dist[0], 0);

        que.offer(new Path(0, 0, 0));
        boolean vis[][] =new boolean[n][discounts+1];
        
        while(!que.isEmpty()){
            Path next = que.poll();
            int u = next.u;
            int d = next.dist;
            int disc = next.discount;
            
            if(u == n-1){
                return d;
            }

            if(vis[u][disc]) continue;

            vis[u][disc] = true;

            for(int v[] : adjList[u]){
                int dest = v[0];
                int toll = v[1];

                if(toll + d < dist[dest][disc]){
                    dist[dest][discounts] = toll + d;
                    que.offer(new Path(dest, toll + d , disc));
                }

                if(disc < discounts && d + toll/2 < dist[dest][disc + 1]){
                    dist[dest][disc+1] = d + toll/2;
                    que.offer(new Path(dest, toll /2 + d, disc + 1));
                }
            }
        }

        return -1;
    }

    class Path{
        int u;
        int dist;
        int discount;

        public Path(int u, int dist, int discount){
            this.u = u;
            this.dist = dist;
            this.discount = discount;
        }

        public int getDist(){
            return dist;
        }
    }
}