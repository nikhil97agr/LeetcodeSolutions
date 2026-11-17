package best_time_to_buy_and_sell_stock_iii_123;

class Solution {
    public int maxProfit(int[] prices) {
        Integer dp[][][] = new Integer[prices.length][2][2];
        return solve(prices, 0, prices.length, 1, 0, dp);
    }

    private int solve(int prices[], int i, int n, int buyFlag, int trxn, Integer dp[][][]){
        if(i==n) return 0;
        if(trxn==2) return 0;

        if(dp[i][buyFlag][trxn]!=null) return dp[i][buyFlag][trxn];

        int ans = solve(prices, i+1, n, buyFlag, trxn, dp);

        if(buyFlag==0){
            ans = Math.max(ans, solve(prices, i+1, n, 1, trxn+1,dp) + prices[i]);
        }else{
            ans = Math.max(ans, solve(prices, i+1, n, 0, trxn, dp) - prices[i]);
        }

        return dp[i][buyFlag][trxn] = ans;
    }
}