package find_valid_matrix_given_row_and_column_sums_1711;

import java.util.*;
class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        PriorityQueue<int[]> col = new PriorityQueue<>((a,b)->a[0] - b[0]);
        PriorityQueue<int[]> row = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int n = rowSum.length;
        int m = colSum.length;

        int mat[][] = new int[n][m];
        for(int i=0;i<n;i++){
            row.offer(new int[]{rowSum[i], i});
        }

        for(int i=0;i<m;i++){
            col.offer(new int[]{colSum[i], i});
        }
        while(!col.isEmpty() && !row.isEmpty()){
            int c[] = col.poll();
            int r[] = row.poll();

            if(r[0] <= c[0]){
                mat[r[1]][c[1]] = r[0];
                c[0] -= r[0];
                if(c[0] != 0){
                    col.add(c);
                }
            }else{
                mat[r[1]][c[1]] = c[0];
                r[0] -= c[0];
                row.offer(r);
            }
        }


        return mat;
    }
}