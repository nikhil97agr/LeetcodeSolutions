class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dp[][][] = new int[r][c][c];
        for(int x[][] : dp){
            for(int y[] : x){
                Arrays.fill(y, -1);
            }
        }
        solve(grid, r,c,dp, 0, 0, c-1);
        return dp[0][0][c-1];
    }
    
    public int solve(int grid[][], int r, int c, int dp[][][], int i, int j1, int j2){
        if(j1<0||j1>=c||j2<0||j2>=c){
            return 0;
        }
        
        if(i==r-1){
            if(j1==j2){
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        int dj1[] = {-1,0,1};
        int dj2[] = {-1,0,1};
        int max = Integer.MIN_VALUE;
        for(int x=0;x<3;x++){
            for(int j=0;j<3;j++){
                int d1 = j1 + dj1[x];
                int d2 = j2 + dj2[j];
                if(j1==j2){
                    max = Math.max(max,grid[i][j1] + solve(grid, r, c, dp, i+1, d1, d2));
                }else{
                    max = Math.max(max, grid[i][j1] + grid[i][j2] + solve(grid, r,c , dp, i+1, d1, d2));
                }
            }
        }
        
        dp[i][j1][j2] = max;
        return max;
    }
}