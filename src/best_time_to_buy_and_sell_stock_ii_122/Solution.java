package best_time_to_buy_and_sell_stock_ii_122;

class Solution {
    Integer dp[][];
    public int maxProfit(int[] prices) {
        int n =prices.length;
        dp = new Integer[n][2];
        return solve(0, prices, n, 0);
    }

    private int solve(int i, int prices[], int n, int prev){
        if(i==n){
            if(prev != 0){
                return Integer.MIN_VALUE;
            }

            return 0;
        }

        if(dp[i][prev] != null) return dp[i][prev];

        int a= solve(i + 1, prices, n, prev);
        int b = Integer.MIN_VALUE;

        if(prev ==0){
            b = solve(i+1, prices, n,1);
            if(b != Integer.MIN_VALUE){
                b -= prices[i];
            }
        }else {
            b = solve( i + 1, prices, n, 0);
            if(b != Integer.MIN_VALUE){
                b += prices[i];
            }
        }


        return dp[i][prev] = Math.max(a, b);

    }
}