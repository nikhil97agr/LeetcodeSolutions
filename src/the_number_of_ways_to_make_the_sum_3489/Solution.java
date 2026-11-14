package the_number_of_ways_to_make_the_sum_3489;

class Solution {
    Integer dp[][];
    public int numberOfWays(int n) {
        dp =new Integer[n+1][3];
        int denom[] = {1,2,6};
        int ans = 0;
        for(int i=0;i<=2;i++){
            ans = add(ans, solve( n - i * 4, 0, denom));
        }

         return ans;
    }

    private int solve(int n,  int ind, int []denom){
        if(n < 0) return 0;
        if(n==0) return 1;
        if(ind == denom.length) return 0;
        if(dp[n][ind] !=null) return dp[n][ind];
        return dp[n][ind] = add(solve(n - denom[ind], ind, denom), solve(n, ind+1, denom));
    }

    private int add(int a, int b){
        long sum = 1l * a + b;
        long mod = ( long)1e9 + 7;
        return (int)(sum%mod);
    }
}