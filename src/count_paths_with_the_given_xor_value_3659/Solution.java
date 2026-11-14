package count_paths_with_the_given_xor_value_3659;

class Solution {
    public int countPathsWithXorValue(int[][] grid, int k) {
        int n = grid.length;
        int m =grid[0].length;
        Long dp[][][] = new Long[n][m][100];
        long mod = (long)1e9+7;
        long ans = solve(dp, 0, 0, n, m, grid, k, 0, mod)%mod;
        
        return (int)ans;
        
        
    }
    
    private long solve(Long dp[][][], int i, int j, int n, int m, int grid[][], int k, int curr, long mod){
        
        
        if(i>=n || j>=m || i<0 || j<0) return 0;
        
        if(i==n-1 && j==m-1){
            if((curr^grid[i][j]) == k) return 1;
            return 0;
        }
        
        if(dp[i][j][curr] !=null) return dp[i][j][curr];
        
        return dp[i][j][curr] = (solve(dp, i+1, j, n, m, grid, k, curr^grid[i][j], mod)%mod + solve(dp, i, j+1, n, m, grid, k, curr^grid[i][j], mod)%mod)%mod;
        
    }
}