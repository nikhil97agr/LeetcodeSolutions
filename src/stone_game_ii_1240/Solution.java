package stone_game_ii_1240;

class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;
        Integer dp[][] = new Integer[n+1][2*n+1];
        int total = 0;
        for(int x : piles) total+=x;

        return (total+solve(0,1, piles,n,dp))/2;
    }

    private int solve(int i, int m, int []piles, int n, Integer dp[][]){
        if(i>=n){
            return 0;
        }

        if(dp[i][m]!=null) return dp[i][m];

        int total = 0;
        int ans = Integer.MIN_VALUE; 
        for(int j=0;j<2*m;j++){
            if(i+j<n) total += piles[i+j];
           ans = Math.max(ans,total - solve(i+j+1, Math.max(m, j+1), piles, n, dp));
        }
        return dp[i][m] = ans;
    }
}