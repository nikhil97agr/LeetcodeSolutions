package best_time_to_buy_and_sell_stock_with_cooldown_309;

class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        Integer dp[][] = new Integer[n][2];

        return solve(dp, n, 0, prices, 0);
    }

    private int solve(Integer dp[][], int n, int i, int prices[], int state){
        if(i>=n) return 0;

        if(dp[i][state]!=null) return dp[i][state];

        if(state ==0){
            return  dp[i][state] = Math.max(-prices[i] + solve(dp, n, i+1, prices, 1), solve(dp, n, i+1, prices, 0));
        }else{
             return dp[i][state] = Math.max(prices[i] + solve(dp, n, i+2, prices, 0), solve(dp, n, i+1, prices, 1));
        }
    }
}