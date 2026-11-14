package sort_matrix_by_diagonals_3748;

import java.util.*;
class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        int r = n-1;
        int ans[][] = new int[n][n];
        int cnt = 1;
        while(r >= 0){
            PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
            int i=r;
            int j=0;
            int c = cnt;
            while(c-- > 0){
                que.offer(grid[i][j]);
                i++;
                j++;
            }
            i=r;
            j=0;
            while(!que.isEmpty()){
             ans [i][j] = que.poll();
                i++;
                j++;
            }
            cnt++;
            r--;
        }

        int c=1;
        cnt = n-1;
        while(c <= n-1){
            PriorityQueue<Integer> que = new PriorityQueue<>();
            int cn = cnt;
            int i=0;
            int j=c;
        
            while(cn--> 0){
                que.offer(grid[i][j]);
                i++;
                j++;
            }

            i=0;
            j=c;
            while(!que.isEmpty()){
                ans[i][j] = que.poll();
                i++;
                j++;
            }
            cnt--;

            c++;
        }
        return ans;
    }
}