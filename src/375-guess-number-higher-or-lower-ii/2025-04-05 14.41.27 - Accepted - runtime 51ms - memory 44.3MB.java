class Solution {
    public int getMoneyAmount(int n) {
        int ans = Integer.MAX_VALUE;
        Integer dp[][] = new Integer[n+1][n+1];
        return solve(1, n, dp);
    }

    private int solve(int start, int end, Integer dp[][]){
        if(start >= end) return 0;

        if(dp[start][end] !=null) return dp[start][end];
        int ans = Integer.MAX_VALUE;

        for(int i=start;i<=end;i++){
            ans = Math.min(ans, 
            i+Math.max(
                solve(start, i-1, dp), solve(i+1, end, dp)
            ));
        }
        return dp[start][end] = ans;
    }
}