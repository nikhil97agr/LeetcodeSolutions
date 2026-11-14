package maximum_profit_from_trading_stocks_2426;

class Solution {
    Integer dp[][];
    public int maximumProfit(int[] present, int[] future, int budget) {
        int n =present.length;
        dp = new Integer[n][budget + 1];
        return solve(0, present, future, budget, present.length);
    }

    private int solve(int i, int present[], int future[], int budget, int n){
        if(budget < 0){
            return Integer.MIN_VALUE;
        }
        if(i==n) return 0;
        if(dp[i][budget] != null) return dp[i][budget];
        int a= solve(i+1, present, future, budget, n);
        int b = solve(i+1, present, future, budget - present[i], n);
        if(b != Integer.MIN_VALUE){
            b += (future[i] - present[i]);
        }

        return dp[i][budget] =Math.max(Math.max(a,b), 0);
    }
}