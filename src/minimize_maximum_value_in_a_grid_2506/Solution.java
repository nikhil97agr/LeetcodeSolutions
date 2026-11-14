package minimize_maximum_value_in_a_grid_2506;

import java.util.*;
class Solution {
    class Cell{
        int r;
        int c;
        int val;
        public Cell(int r, int c, int val){
            this.r = r;
            this.c = c;
            this.val = val;
        }
    }
    public int[][] minScore(int[][] grid) {
        PriorityQueue<Cell> que = new PriorityQueue<>((a,b) -> a.val - b.val);
        int n = grid.length;
        int m = grid[0].length;

        int row[] = new int[n];
        int col[] = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                que.offer(new Cell(i, j, grid[i][j]));
            }
        }
        while(!que.isEmpty()){
            Cell cell = que.poll();
            int r= cell.r;
            int c = cell.c;

            grid[r][c] = Math.max(row[r], col[c])+1;
            row[r] =grid[r][c];
            col[c] = grid[r][c];
        }
        return grid;
    }
}