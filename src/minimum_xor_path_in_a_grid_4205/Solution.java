package minimum_xor_path_in_a_grid_4205;

class Solution {
    Integer dp[][][];
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n][1<<11];

        return solve(0, 0, m, n, 0, grid);
    }

    private int solve(int i, int j, int m, int n, int xor, int grid[][]){
        if(i ==m-1 && j== n-1){
            return xor ^ grid[i][j];
        }

        if( i >=m || j >=n) return Integer.MAX_VALUE;

        if(dp[i][j][xor] !=null) return dp[i][j][xor];

        int x = xor ^ grid[i][j];
        return dp[i][j][xor] = Math.min(solve(i+1, j, m, n, x, grid), solve(i, j+1, m, n, x, grid));
        
    }

    
}