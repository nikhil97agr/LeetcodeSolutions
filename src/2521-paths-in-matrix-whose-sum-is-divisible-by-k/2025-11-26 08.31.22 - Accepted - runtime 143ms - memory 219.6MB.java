class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        long mod = (long)1e9+7;

        Long dp[][][] = new Long[m][n][k];

        return (int)(solve(0,0,0,m,n,k,grid,mod, dp)%mod);
    }

    private long solve(int i, int j, int sum, int m, int n,int k, int grid[][],long mod, Long dp[][][]){
        if(i>=m || j>=n) return 0;

        if(i==m-1 && j==n-1) return ((sum+grid[i][j])%k)==0 ? 1 : 0;
        if(dp[i][j][sum]!=null) return dp[i][j][sum];

        return dp[i][j][sum] = (solve(i+1, j, (sum+grid[i][j])%k, m, n, k, grid, mod, dp)%mod + solve(i, j+1, (sum+grid[i][j])%k, m, n, k, grid, mod, dp)%mod)%mod;
    }
}