package rotting_oranges_1036;

import java.util.*;
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int result[][] = new int[m][n];
        for(int x[] : result){
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    result[i][j] = 0;
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==2){
                    solve(m,n,result,grid, i, j,0);
                }
            }
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1 || grid[i][j]==2 ){
                    if(result[i][j]==Integer.MAX_VALUE){
                        return -1;
                    }

                    ans = Math.max(ans, result[i][j]);
                }
            }
        }
        return ans;
    }

    public void solve(int m, int n, int result[][], int grid[][], int i, int j, int time){
        if(i>=m || i<0 || j>=n||j<0){
            return;
        }

        if(result[i][j]<time){
            return;
        }

        if(grid[i][j]==0){
            return;
        }

        result[i][j] = time;
        solve(m, n, result, grid, i+1, j, time+1);
        solve(m, n, result, grid, i-1, j, time+1);
        solve(m, n, result, grid, i, j+1, time+1);
        solve(m, n, result, grid, i, j-1, time+1);


    }
}