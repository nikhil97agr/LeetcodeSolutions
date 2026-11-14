class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        Integer dp[][] = new Integer[n][2];
        solve(prices, fee, dp, n, 0, 0);
        return dp[0][0];
    }

    private int solve(int p[], int fee, Integer dp[][], int n, int i, int j){
        if(i>=n) return 0;
        if(dp[i][j]!=null) return dp[i][j];

        if(j==0){
            dp[i][j] = solve(p, fee, dp, n, i+1, 1)-p[i];
        }else{
            dp[i][j] = solve(p, fee, dp, n, i+1, 0)+p[i]-fee;
        }

        dp[i][j] = Math.max(dp[i][j], solve(p, fee, dp, n, i+1, j));

        return dp[i][j];
    }
}