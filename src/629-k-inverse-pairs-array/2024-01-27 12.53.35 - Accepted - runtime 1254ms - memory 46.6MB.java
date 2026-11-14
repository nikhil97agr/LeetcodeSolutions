class Solution {
    public int kInversePairs(int n, int k) {
        int dp[][] = new int[n+1][k+1];
        int mod = (int)1e9+7;
        dp[0][0] = 1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                for(int l=0;l<=Math.min(i-1,j);l++){
                    dp[i][j] = (dp[i][j] + dp[i-1][j-l]%mod)%mod;
                }
            }
        }

        return dp[n][k];
    }
}