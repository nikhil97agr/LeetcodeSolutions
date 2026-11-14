package knight_probability_in_chessboard_688;

class Solution {

    public double knightProbability(int n, int k, int row, int column) {
        Double dp[][][] = new Double[n][n][k+1];
        return solve(n, k, row, column, dp);
    }

    private double solve(int n, int k, int r, int c, Double dp[][][]){
        if(!valid(r, c, n)) return 0d;

        if(k==0) return 1d;
        if(dp[r][c][k]!=null) return dp[r][c][k];
        int dr[] = new int[]{2, 2, 1, -1, -2, -2, 1 ,-1};
        int dc[] = new int[]{-1, 1, 2, 2, 1, -1, -2, -2};
        double ans = 0;
        for(int i=0;i<8;i++){
            ans = ans + solve(n, k-1, r+dr[i], c+dc[i], dp)/8d;
        }

        return dp[r][c][k] = ans;
    }

    private boolean valid(int r, int c, int n){
        return r>=0 && r<n && c>=0 && c<n;
    }
}