package maximum_score_of_a_node_sequence_2353;

import java.util.*;
class Solution {
    public int maximumScore(int[] scores, int[][] edges) {
        int res = -1;
        int n = scores.length;
        PriorityQueue<Integer> que[] = new PriorityQueue[n];

        for(int i=0;i<n;i++){
            que[i] = new PriorityQueue<>((a,b) -> scores[a] - scores[b]);
        }

        for(int edge[] : edges){
           int src = edge[0];
           int dest = edge[1];
           que[src].add(dest);
           que[dest].add(src);

           if(que[src].size()>3) que[src].poll();
           if(que[dest].size()>3) que[dest].poll();
        }

        for(int edge[] : edges){
            int src = edge[0];
            int dest =edge[1];
            for(int i : que[src]){
                for(int j : que[dest]){
                    if(src!=j && i!=dest && i!=j){
                        res = Math.max(res, scores[i] + scores[j] + scores[src] + scores[dest]);
                    }
                }
            }

            
        }
        return res;
    }
}