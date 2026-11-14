package cheapest_flights_within_k_stops_803;

import java.util.*;
class Solution {
    class Pair{
        int dest;
        int price;
        public Pair(int dest, int price){
            this.dest = dest;
            this.price = price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        LinkedList<Pair> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<Pair>();
        }
        for(int flight[] : flights){
            adjList[flight[0]].add(new Pair(flight[1], flight[2]));
        }
        int pathPrice[] = new int[n];
        Arrays.fill(pathPrice, Integer.MAX_VALUE);
        pathPrice[src] = 0;
        int result = Integer.MAX_VALUE;
        Queue<int[]> que = new LinkedList<int[]>();
        que.add(new int[]{src, 0, 0});
        while(!que.isEmpty()){
            int path[] = que.poll();
            if(path[0]==dst){
                result = Math.min(result, path[1]);
                continue;
            }
            if(path[2]>k){
                continue;
            }

            if(pathPrice[path[0]]<path[1]){
                continue;
            }
            pathPrice[path[0]] = path[1];

            Iterator<Pair> it = adjList[path[0]].iterator();
            while(it.hasNext()){
                Pair p = it.next();
                que.add(new int[]{p.dest, path[1]+p.price, path[2]+1});
            }
        }

        return result==Integer.MAX_VALUE?-1 : result;
    }
}