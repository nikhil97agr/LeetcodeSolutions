class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        if(n==1){
            return matrix[0][0];
        }
        int dp[][] = new int[n][m];
        for(int x[] : dp){
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            dp[n-1][i] = matrix[n-1][i];
        }
        int result = Integer.MAX_VALUE;
        for(int i=0;i<m;i++){
            result = Math.min(result, solve(matrix, dp, 0, i, n,m));
        }
        return result;
    }
    
    public int solve(int mat[][], int dp[][], int i, int j, int n, int m){
        if(j<0 || j>=m){
            return Integer.MAX_VALUE;
        }

        
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        
        int sum = Math.min(solve(mat, dp, i+1, j-1, n, m), Math.min(
        solve(mat, dp, i+1, j, n, m), solve(mat, dp, i+1, j+1, n, m)));
        
        dp[i][j] = mat[i][j] + sum;
        return dp[i][j];
    }
}