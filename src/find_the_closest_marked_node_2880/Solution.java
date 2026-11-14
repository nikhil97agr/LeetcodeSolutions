package find_the_closest_marked_node_2880;

import java.util.*;
import java.util.stream.*;
class Solution {
    public int minimumDistance(int n, List<List<Integer>> edges, int s, int[] marked) {
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        LinkedList<int[]> adjList[]= IntStream.range(0, n).boxed().map(x-> new LinkedList<>()).toArray(LinkedList[]::new);

        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int d = edge.get(2);

            adjList[u].add(new int[]{v, d});
        }

        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        dist[s] = 0;
        que.offer(new int[]{s, 0});

        while(!que.isEmpty()){
            int next[] = que.poll();

            int u =next[0];
            int curr = next[1];

            for(int child[] : adjList[u]){
                int v = child[0];
                int d = child[1];

                if(dist[v] > curr + d){
                    dist[v] = curr + d;
                    que.offer(new int[]{v, curr + d});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int ind : marked){
            ans = Math.min(ans, dist[ind]);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}