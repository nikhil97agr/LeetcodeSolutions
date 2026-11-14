class Solution {
    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        
        Long dp[][][] = new Long[n][m][3];
        
        return (int)solve(0, 0, 0,coins, n, m, dp);
    }
    
    private long solve(int i, int j, int neut, int coins[][], int n, int m, Long dp[][][]){
        
        if(i>=n || j >= m){
            return Integer.MIN_VALUE;
        }
        
        
        if(i == n-1 && j == m-1)
        {
            if(neut< 2 && coins[i][j] < 0){
                return 0;
            }else{
                return coins[i][j];
            }
        }
        if(dp[i][j][neut]!=null) return dp[i][j][neut];
        long ans = Integer.MIN_VALUE;
        if(neut < 2 && coins[i][j] < 0){
            ans = Math.max(solve(i+1, j, neut+1, coins, n, m, dp), solve(i, j+1, neut+1, coins, n, m, dp));
        }
        
        ans = Math.max(ans,
                      coins[i][j] + Math.max(solve(i+1, j, neut, coins, n, m, dp), solve(i, j+1, neut, coins, n, m, dp)));
        
        return dp[i][j][neut] = ans;
    }
}