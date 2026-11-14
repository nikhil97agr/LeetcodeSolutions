class Solution {

    long mod = (long)1e9 + 7;
    public int numberOfWays(int n) {
        int m = n / 2;
        int dp[] = new int[m+1];
        dp[0] = 1;

        for(int i=1;i<=m;i++){
            int total = 0;
            for(int j=0;j<i;j++){
                total = add(total, prod(dp[j], dp[i - j - 1]));
            }

            dp[i] = total;
        }

        return dp[m];
    }

    private int add(int a, int b){
        long sum = mod + a + b;

        return (int)(sum%mod);
    }

    private int prod(int a, int b){
        long prod = 1l*a*b;

        return (int)(prod%mod);
    }
}