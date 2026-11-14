class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int dp[][] = new int[m][n];
        for(int x[] : dp){
            Arrays.fill(x, 1);
        }
        
        int ans = 1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dp[i][j]==1){
                    boolean visited[][] = new boolean[m][n];
                    ans = Math.max(ans, solve(-1,matrix, visited, dp, i, j, m, n));
                }
            }
        }
        return ans;
    }

    private int solve(int prev,int matrix[][], boolean visited[][], int dp[][], int i, int j, int m, int n){
        if(i<0 || j<0 || i>=m || j>=n){
            return 0;
        }
        if(matrix[i][j]<=prev){
            return 0;
        }
        if(visited[i][j]){
            return 0;
        }
        if(dp[i][j] !=1){
            return dp[i][j];
        }

        visited[i][j] = true;
        
        int ans = solve(matrix[i][j],matrix, visited, dp, i+1, j, m, n);
        ans = Math.max(ans, solve(matrix[i][j],matrix, visited, dp, i-1, j, m ,n));
        ans = Math.max(ans, solve(matrix[i][j],matrix, visited, dp, i, j+1, m, n));
        ans = Math.max(ans, solve(matrix[i][j],matrix, visited, dp, i ,j-1, m, n));
        dp[i][j] = ans+1;
        visited[i][j] = false;
        return dp[i][j];
    }
}