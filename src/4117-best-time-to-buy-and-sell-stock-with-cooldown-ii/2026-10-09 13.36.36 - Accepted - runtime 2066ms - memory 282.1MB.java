class Solution {
    public int maxProfit(int[] prices, int cooldown, int[] costs) {
        int n = costs.length;
        int dp[][][] = new int[n][n][2];
        for(int i=n-1;i>=0;i--){
            for(int prev=0;prev < n;prev++){
                int a1 = (i + 1 < n) ? dp[prev][i + 1][1] : 0;
                int p1 = -prices[i] +  (( i + 1 < n) ? dp[i][i+1][0] : 0);
                dp[prev][i][1] = Math.max(a1, p1);

                if(prev <= i){
                    int a2 = (i + 1 < n) ? dp[prev][i+1][0] : 0;
                    int cdIndex = i + cooldown + 1;
                    int p2 = prices[i] - costs[i - prev] + (cdIndex < n ? dp[0][cdIndex][1] : 0);
                    dp[prev][i][0] = Math.max(a2, p2);
                }
            }
        }

        return dp[0][0][1];
    }
}