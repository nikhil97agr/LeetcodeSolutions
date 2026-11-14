class Solution {
    long upper = Long.MAX_VALUE;
    long lower = Long.MIN_VALUE;
    public int maxProductPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long mod = (long)1e9 + 7;
        Long dp[][][] = new Long[m][n][2];

        return Math.max(-1, (int)(solve(grid, 0, 0, m, n, dp)[1]%mod));
    }


    private Long[] solve(int grid[][], int i, int j, int m, int n, Long dp[][][]){
        if(i==m-1 && j== n-1) return new Long[]{1l*grid[i][j], 1l*grid[i][j]};

        if(i < 0 || i>=m || j< 0 || j>=n) return new Long[]{upper, lower};

        if(dp[i][j][0] !=null) {
            return dp[i][j];
        }
        Long a[] = solve(grid, i+1, j, m, n, dp);
        Long b[] = solve(grid, i, j+1, m, n, dp);

        Long ans[] = new Long[]{upper, lower};
        solve(a[0], upper, ans, grid[i][j]);
        solve(a[1], lower, ans, grid[i][j]);
        solve(b[0], upper, ans, grid[i][j]);
        solve(b[1], lower, ans, grid[i][j]);


        return dp[i][j] = ans;
    }

    private void solve(long x, long match, Long ans[], int val){
        if(x==match){
            return;
        }

        ans[0] = Math.min(ans[0], x*val );
        ans[1] = Math.max(ans[1], x * val);
    }
}