package best_time_to_buy_and_sell_stock_v_3892;

class Solution {
    public long maximumProfit(int[] prices, int k) {
        Long dp[][][] = new Long[prices.length][k+1][3];
        return solve(prices, 0, k, prices.length, dp, 0);
    }

    private long solve(int prices[], int i, int k, int n,Long[][][] dp, int prev){
        if(i==n){
            if(prev == 1 || prev == 2) return Integer.MIN_VALUE;
            return 0;
        }
        if(k==0) return 0;

        if(dp[i][k][prev]!=null) return dp[i][k][prev];
        
        long ans = 0;
        if(prev == 0){
             ans = Math.max(-prices[i] + solve(prices, i+1, k, n, dp, 1), prices[i] + solve(prices, i+1, k, n, dp, 2));
        }else if(prev == 1){
            ans = prices[i] + solve(prices, i+1, k-1, n, dp, 0);
        }else{
            ans = -prices[i] + solve(prices, i+1, k-1, n, dp, 0);
        }

        ans = Math.max(ans, solve(prices, i+1, k, n, dp, prev));

        return dp[i][k][prev] = ans;
    }
}