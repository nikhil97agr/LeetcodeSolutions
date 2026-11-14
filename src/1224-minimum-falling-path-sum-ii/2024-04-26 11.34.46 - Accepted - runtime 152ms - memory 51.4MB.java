class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        if(n==1)
        {
            return arr[0][0];
        }
        int dp[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dp[i][j] = -1;
            }
        }
        for(int i=0;i<n;i++)
        {
            dp[n-1][i] = arr[n-1][i];
        }
        
        for(int i=0;i<n;i++)
        {
            int ans = Integer.MAX_VALUE;
            for(int j=i+1;j<n;j++)
            {
                ans = Math.min(ans, solve(arr, n, dp, 1, j));
            }
            for(int j=i-1;j>-1;j--)
            {
                ans = Math.min(ans, solve(arr, n, dp, 1, j));
            }
            dp[0][i] = arr[0][i] + ans;
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            ans = Math.min(ans, dp[0][i]);
        }
        return ans;
    }
    
    public int solve(int[][] arr, int n, int[][] dp, int i, int j)
    {
        if(i>=n)
        {
            return 0;
        }
        if(dp[i][j]!=-1)
        {
            return dp[i][j];
        }
        
        int ans = Integer.MAX_VALUE;
        
        for(int x = j+1;x<n;x++)
        {
            ans = Math.min(ans, solve(arr, n, dp, i+1, x));
        }
        for(int x=j-1;x>-1;x--)
        {
            ans = Math.min(ans, solve(arr, n, dp, i+1, x));
        }
        
        dp[i][j] = arr[i][j] +ans;
        return dp[i][j];
    }
}