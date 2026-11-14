class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer dp[][][] = new Integer[m][n][maxMove+1];
        

        int mod = (int)1e9+7;

        return solve(m, n, startRow, startColumn, maxMove, dp, mod);
    }

    private int solve(int m, int n, int r, int c, int move, Integer dp[][][], int mod){
        if(move < 0) return 0;

        if(r >=m || c >= n || r <0 || c <0) return 1;

        if(dp[r][c][move]!=null) return dp[r][c][move];

        int diff[] = new int[]{1,0,-1,0,1};
        int ans = 0;
        for(int i=0;i<4;i++){
            int nr = r + diff[i];
            int nc = c + diff[i+1];
            ans += solve(m, n, nr, nc, move-1, dp, mod)%mod;
            ans%=mod;
        }


        return dp[r][c][move] = ans%mod;

    }
}