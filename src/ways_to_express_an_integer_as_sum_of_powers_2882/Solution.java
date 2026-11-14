package ways_to_express_an_integer_as_sum_of_powers_2882;

class Solution {
    public int numberOfWays(int n, int x) {
        Integer dp[][] = new Integer[n+1][n+1];

        return solve(1,n,n+1, x, dp);
    }

    private int solve(int i,int n,int max, int x, Integer dp[][]){
        if(n==0) return 1;
        if( n < 0 || i ==max) return 0;

        if(dp[i][n] !=null) return dp[i][n];

        long val = (long)Math.pow(1l*i, x);

        int ans = solve(i+1, n,max, x, dp);

        if(val <=1l*n){
            ans = add(ans, solve(i+1, n - (int)val,max, x, dp));
        }

       return  dp[i][n]=ans;
        
    }

    private int add(int a, int b){
        long sum = 1l*a + b;
        long mod = (long)1e9 + 7;

        return (int)(sum%mod);
    }
}