class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        Integer dp[][][] = new Integer[n][k][2];

        return solve(prices, 0, n, k, 1, 0, dp);
    }

    private int solve(int prices[], int i, int n, int k, int buyFlag, int trxnNumber, Integer dp[][][]){
        if(i==n) return 0;

        if(trxnNumber ==k) return 0;

        if(dp[i][trxnNumber][buyFlag]!=null) return dp[i][trxnNumber][buyFlag] ;
        int ans = solve(prices, i+1, n, k, buyFlag, trxnNumber, dp);
        if(buyFlag==1){
            ans = Math.max(ans, solve(prices, i+1, n, k, 0, trxnNumber, dp) - prices[i]);
        }else{
            ans = Math.max(ans, solve(prices, i+1, n, k, 1, trxnNumber+1, dp) + prices[i]);
        }

        return dp[i][trxnNumber][buyFlag] = ans;
    }
}