class Solution {
    long mod = (long) 1e9 + 7;
    int dp[][];

    public int waysToDistribute(int n, int k) {

        dp = new int[n+1][k+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j] = add(dp[i-1][j-1], prod(j , dp[i-1][j]));
            }
        }
        return dp[n][k];
    }


    private int add(long a, long b) {

        return (int) ((a + b) % mod);
    }

    private int prod(long a, long b) {
        return (int) ((a * b) % mod);
    }

}