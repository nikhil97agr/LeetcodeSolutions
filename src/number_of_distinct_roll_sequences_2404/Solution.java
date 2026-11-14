package number_of_distinct_roll_sequences_2404;

class Solution {
    Integer dp[][][];
    public int distinctSequences(int n) {
        dp = new Integer[n][8][8];
        return solve(0,7,7, n);
    }

    private int solve(int i, int p1, int p2,  int n){
        if(i==n) return 1;

        if(dp[i][p1][p2] !=null) return dp[i][p1][p2];
        int ans = 0;

        for(int j =1;j<=6;j++){
            if(j  == p1 || j== p2 ) continue;
            if(p2 == 7 || gcd(p2, j) == 1){
                ans = add(ans, solve(i+1, p2, j,n));
            }
        }

        return dp[i][p1][p2] = ans;
    }

    private int gcd(int a, int b){
        if(a==0) return b;

        return gcd(b%a, a);
    }

    private int add(long a, long b){
        long mod = (long)1e9 + 7;

        return (int)((a+b)%mod);
    }
}