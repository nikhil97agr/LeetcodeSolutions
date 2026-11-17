package beautiful_arrangement_526;

class Solution {
    public int countArrangement(int n) {
        int max = (1<<n) -1 ;
        Integer dp[][] = new Integer[max+1][n+1];
        return solve(0, dp, max, 1,n);
    }

    private int solve(int curr, Integer dp[][], int max, int i, int n){
        if(curr == max) return 1;

        if(dp[curr][i] !=null) return dp[curr][i];
        int ans = 0;
        for(int j=1;j<=n;j++){
            int dig = (1<<(j-1))&curr;
            if(dig == 0 && (j%i==0 || i%j==0)){
                ans += solve(curr|(1<<(j-1)), dp, max, i+1, n);
            }
        }

        return dp[curr][i] = ans;
    }
}

