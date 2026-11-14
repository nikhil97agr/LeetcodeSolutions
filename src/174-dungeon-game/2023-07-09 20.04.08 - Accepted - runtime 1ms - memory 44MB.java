class Solution {
    public int calculateMinimumHP(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Integer dp[][] = new Integer[m][n];
        return solve(0, 0, m, n, grid, dp);
    }

    private int solve(int i, int j, int m, int n, int grid[][], Integer dp[][]){
        if(i>=m || j>=n) return Integer.MAX_VALUE;
        if(i==m-1 && j==n-1){
            if(grid[i][j]>=0) return 1;
            return -grid[i][j] + 1;
        }
        if(dp[i][j] !=null) return dp[i][j];

        int ans = Math.min(solve(i+1, j, m, n,grid, dp), solve(i, j+1, m, n, grid, dp));
        if(grid[i][j]<0){
            return dp[i][j] = ans - grid[i][j];
        }
        if(grid[i][j]>=ans) return dp[i][j] = 1;
        return dp[i][j] = ans - grid[i][j];
    }
}