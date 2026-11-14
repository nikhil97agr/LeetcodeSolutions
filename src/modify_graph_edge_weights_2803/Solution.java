package modify_graph_edge_weights_2803;

import java.util.*;

class Solution {
    int max = (int)2e9;
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        Map<Integer, Map<Integer, Integer>> map  = new HashMap<>();
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w= e[2];

            if(w == -1) continue;

            map.computeIfAbsent(u, u1 -> new HashMap<>()).put(v, w);
            map.computeIfAbsent(v, v1 -> new HashMap<>()).put(u, w);
        }
        int currDist = getMinDist(map, source, destination, n);
        if(currDist < target) return new int[0][];

        for(int e[] : edges){
            if(e[2] != -1) continue;

            if(currDist == target){
                e[2] = max;
                continue;
            }

            int u = e[0];
            int v = e[1];
            int w = e[2];
            e[2] = 1;
            map.computeIfAbsent(u, u1 -> new HashMap<>()).put(v, e[2]);
            map.computeIfAbsent(v, v1 -> new HashMap<>()).put(u, e[2]);

            currDist = getMinDist(map, source, destination, n);


            if(currDist <= target){
                e[2] += (target - currDist);
                currDist = target;
            }
        }

        return currDist == target ? edges : new int[0][];

    }

    private int getMinDist(Map<Integer, Map<Integer, Integer>> map, int src, int dest, int n){
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> a[1] - b[1]);

        que.offer(new int[]{src, 0});
        boolean vis[] = new boolean[n];
        while(!que.isEmpty()){
            int next[] = que.poll();
            if(next[0] == dest) return next[1];
            vis[next[0]] = true;
            Map<Integer, Integer> child = map.getOrDefault(next[0], new HashMap<>());

            for(int x : child.keySet()){
                if(!vis[x]){
                    que.offer(new int[]{x, next[1] + child.get(x)});
                }
            }
        }
        return max;
    }

}