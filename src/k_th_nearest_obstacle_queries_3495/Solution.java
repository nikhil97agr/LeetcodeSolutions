package k_th_nearest_obstacle_queries_3495;

import java.util.*;
class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        int n = queries.length;
        int ans[] = new int[n];
        
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<n;i++){
            int q[] = queries[i];
            int x =   q[0];
            int y = q[1];
            
            int total = Math.abs(x) + Math.abs(y);
            que.offer(total);
            
            if(que.size() > k) que.poll();
            
            if(que.size() == k){
                ans[i] = que.peek();
            }else{
                ans[i]= -1;
            }
            
            }
        return ans;
    }
}