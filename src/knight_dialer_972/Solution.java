package knight_dialer_972;

class Solution {
    public int knightDialer(int n) {
        Long dp[][][] = new Long[4][3][n+1];
        long mod = (long)1e9+7;
        long ans = 0;
        int grid[][] = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-1}
        };
        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                ans += solve(i, j, grid, n-1, dp, mod);
                ans%=mod;
            }
        }

        return (int)ans;

    }

    private long solve(int i, int j, int grid[][], int n, Long dp[][][], long mod){
        if(i>=4 || j>=3 || i<0 || j<0 || grid[i][j]==-1) return 0;
        if(n==0) return 1;


        if(dp[i][j][n]!=null) return dp[i][j][n];

        int x[] = new int[]{1,-1,-2,-2,-1,1,2,2};
        int y[] = new int[]{-2,-2,-1,1,2,2,1,-1};
        long ans = 0;
        for(int k=0;k<x.length;k++){
            ans = ans + solve(i+x[k], j+y[k], grid, n-1, dp, mod)%mod;
            ans%=mod;
        }    

        return dp[i][j][n] = ans;
    }
}