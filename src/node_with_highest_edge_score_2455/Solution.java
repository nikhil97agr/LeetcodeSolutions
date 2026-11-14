package node_with_highest_edge_score_2455;

import java.util.*;
class Solution {
    public int edgeScore(int[] edges) {
        int n = edges.length;
        long result[] = new long[n];
        for(int i=0;i<n;i++){
            result[edges[i]] += i;
        }
        System.out.println(Arrays.toString(result));

        long ans = Integer.MIN_VALUE;
        int ind = -1;
        for(int i=0;i<n;i++){
            if(ans<result[i]){
                ans = result[i];
                ind = i;
            }
        }
        return ind;
    }
}