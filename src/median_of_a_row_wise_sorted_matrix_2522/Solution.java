package median_of_a_row_wise_sorted_matrix_2522;

import java.util.*;
class Solution {
    public int matrixMedian(int[][] grid) {
        int n = grid.length;
        int m =grid[0].length;
        int total = ((n*m)+1)/2;
        PriorityQueue<Integer> que= new PriorityQueue<>(Collections.reverseOrder());
        for(int x[] : grid){
            for(int y : x){
                que.offer(y);
                if(que.size() > total) que.poll();
            }
        }

        return que.peek();

    }
}