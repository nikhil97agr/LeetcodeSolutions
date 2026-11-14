class Solution {
    public boolean hasValidPath(char[][] grid) {
        int open = 0;
        int n  = grid.length;
        int m = grid[0].length;

        if(grid[0][0] == ')' || grid[n-1][m-1] == '(') return false;
        Boolean dp[][][] = new Boolean[n][m][n+m+1];

        return solve(grid, n, m, 0, 0, open, dp);
    }


    private boolean solve(char grid[][], int n, int m , int i, int j, int open, Boolean dp[][][]){
        if(i < 0 || j < 0|| i >= n || j >=m ) return false;

        if(i==n-1 && j==m-1){
            return open == 1 && grid[i][j] == ')';
        }
        if(dp[i][j][open]!=null) return dp[i][j][open];
        if(grid[i][j] == '('){
            return dp[i][j][open] = solve(grid, n, m, i+1, j, open+1, dp) || solve(grid, n, m, i, j+1, open+1, dp);
        }else{
            if(open==0) return false;

            return dp[i][j][open] = solve(grid, n, m, i+1, j, open-1, dp) || solve(grid, n, m, i, j+1, open - 1, dp);
        }
    }
}