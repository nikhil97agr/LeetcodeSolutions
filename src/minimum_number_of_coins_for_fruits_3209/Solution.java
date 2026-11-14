package minimum_number_of_coins_for_fruits_3209;

class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        Integer dp[][] = new Integer[n+1][n+1];
        return solve(prices, 0, 0, prices.length, dp);
    }
    
    private int solve(int prices[], int i, int skipLeft, int n, Integer dp[][]){
        if(i==n) return 0;
        if(dp[i][skipLeft]!=null){
            return dp[i][skipLeft];
        }
        int ans = 0;
        if(skipLeft > 0){
            ans = Math.min(solve(prices, i+1, skipLeft-1, n, dp), solve(prices, i+1, i+1, n, dp)+prices[i]);
        }else{
            ans = solve(prices, i+1, i+1, n, dp) + prices[i];
        }
        return dp[i][skipLeft] = ans;
    }
}