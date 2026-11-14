package maximum_star_sum_of_a_graph_2590;

import java.util.*;
class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        int n =vals.length;

        PriorityQueue<Integer> que[]= new PriorityQueue[n];
        for(int i=0;i<n;i++) que[i] = new PriorityQueue<>();
        int sum[] = new int[n];
        for(int i=0;i<n;i++) sum[i]= vals[i];

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];

            if(vals[u] >=0){
                sum[v] += vals[u];
                que[v].offer(vals[u]);
                if(que[v].size() > k){
                    sum[v] -= que[v].poll();
                }
            }

            if(vals[v] >=0){
                sum[u] += vals[v];
                que[u].offer(vals[v]);
                if(que[u].size() >k){
                    sum[u] -= que[u].poll();
                }
            }
        }

        return Arrays.stream(sum).max().getAsInt();
    }
}