package number_of_ways_to_rearrange_sticks_with_k_sticks_visible_1996;

class Solution {
    public int rearrangeSticks(int n, int k) {
        int dp[][] = new int[n+1][k+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                dp[i][j] = add(
                        dp[i-1][j-1],
                        prod(i-1, dp[i-1][j])
                    );
            }
        }
        return dp[n][k];
    }

    private int add(int a, int b){
        long mod = (long)1e9 +7;
        long sum = 1l*a + b;

        return (int)(sum%mod);
    }

    private int prod(int a, int b){
        long mod = (long)1e9 + 7;

        long p = 1l*a*b;

        return (int)(p%mod);
    }
}