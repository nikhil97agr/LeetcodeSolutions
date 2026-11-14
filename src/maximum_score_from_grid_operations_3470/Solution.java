package maximum_score_from_grid_operations_3470;

class Solution {
    Long dp[][][];
    public long maximumScore(int[][] grid) {
        int n = grid.length;
        dp = new Long[n+1][n+1][n+1];



        return solve(n, 0 , 0, 0, grid);
    }

    private long solve(int n, int c, int prev1, int prev2, int grid[][]){
        if( c >= n) return 0;

        if(dp[c][prev1][prev2] !=null) return dp[c][prev1][prev2];

        long s2 = 0;
        for(int i=0;i<prev2;i++){
            s2 += grid[i][c];

        }


        long ans =s2 + solve(n, c+1, 0, prev1, grid);

        long s1 = 0;

        if(c + 1 < n){
            for(int i=prev1;i < n ;i++){
                s1 += grid[i][c];

                ans = Math.max(ans, s1 + solve(n, c+ 1, i + 1, 0, grid));
            }
        }

        for(int i=0;i<n;i++){
            if( i < prev2){
                s2 -= grid[i][c];
            }

            ans = Math.max(ans, s2 + solve(n, c + 1, 0, i + 1, grid));
        }

        return dp[c][prev1][prev2] = ans;


    }
}