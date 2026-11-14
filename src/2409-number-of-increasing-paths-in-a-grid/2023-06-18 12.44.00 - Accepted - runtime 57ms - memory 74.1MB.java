class Solution {
    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int mod = (int)1e9+7;
        int dp[][] = new int[m][n];
        for(int x[] : dp){
            Arrays.fill(x, -1);
        }
        int total = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                total = (total + solve(i, j, -1, dp, m, n, grid, mod)%mod)%mod;
            }
        }

        return total;
    }

    private int solve(int i, int j, int prev, int dp[][], int m, int n, int grid[][], int mod){
        if(i<0 || j<0 || i>=m  || j>=n || prev>=grid[i][j]){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int curr = grid[i][j];

        return dp[i][j] = (1+solve(i, j+1, curr, dp, m, n, grid, mod)%mod + solve(i, j-1, curr, dp, m, n, grid, mod)%mod + solve(i+1, j, curr, dp, m, n, grid, mod)%mod + solve(i-1, j, curr, dp, m, n, grid, mod)%mod)%mod;
    }
}