class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n+1][amount+1];
        for(int d[] : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;
        for(int i=1;i<=n;i++){
            dp[i][0] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i-1] && dp[i][j-coins[i-1]]!=Integer.MAX_VALUE){
                    dp[i][j] = 1+dp[i][j-coins[i-1]];
                }
                if(dp[i-1][j]!=Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][j]);
                }
            }
        }

        return dp[n][amount]==Integer.MAX_VALUE ? -1 : dp[n][amount];
    }
}