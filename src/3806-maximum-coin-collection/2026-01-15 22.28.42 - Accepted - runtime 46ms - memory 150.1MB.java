class Solution {
    public long maxCoins(int[] lane1, int[] lane2) {
        int n= lane1.length;
        long dp[][][] = new long[n][2][3];  
        dp[0][0][2] = dp[0][0][0] = lane1[0];
        dp[0][1][1] = lane2[0];
        long result = Math.max(dp[0][0][2], dp[0][1][1]);
        for(int i=1;i<n;i++){
            dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][1]) + lane1[i];

            dp[i][0][2] = Math.max(dp[i-1][0][2], 0) + lane1[i];

            dp[i][1][1] = Math.max(dp[i-1][0][2], Math.max(dp[i-1][1][1], 0)) + lane2[i];
            result = Math.max(result,
            Math.max(dp[i][0][0], 
            Math.max(dp[i][0][2], dp[i][1][1])));
        }


        return result;
    }
}