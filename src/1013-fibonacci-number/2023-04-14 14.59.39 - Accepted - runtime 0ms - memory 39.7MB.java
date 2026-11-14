class Solution {
    public int fib(int n) {
        int dp[] = new int[n+1];
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        dp[0] = 0;dp[1] = 1;
        return fib(n, dp);
    }

    private int fib(int n, int dp[]){
        if(n==0){
            return 0;
        }

        if(dp[n]!=0){
            return dp[n];
        }

        return dp[n] = fib(n-1, dp)+ fib(n-2, dp);
    }
}