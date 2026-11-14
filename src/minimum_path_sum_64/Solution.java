package minimum_path_sum_64;

import java.util.*;
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];

        for(int d[] : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        return solve(0,0,m,n,grid,dp);
    }

    private int solve(int i, int j, int m, int n, int grid[][], int dp[][]){
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(i<0 || i>=m || j<0 || j>=n){
            return Integer.MAX_VALUE;
        }

        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }

        int ans = solve(i+1, j, m, n, grid, dp);
        ans = Math.min(ans, solve(i, j+1, m, n, grid, dp));

        return dp[i][j] = ans + grid[i][j];
    }
}