package maximum_consistent_columns_in_a_grid_4225;

class Solution {
    public int maxConsistentColumns(int[][] grid, int limit) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[] = new int[n];

        int max = 1;

        for(int j=0;j<n;j++){
            dp[j] = 1;
            for(int k=0;k<j;k++){
                boolean res = true;

                for(int i=0;i<m;i++){
                    if(Math.abs(grid[i][j] - grid[i][k]) > limit){
                        res = false;
                        break;
                    }
                }
                if(res){
                    dp[j] = Math.max(dp[j], dp[k] + 1);
                }
            }
            max = Math.max(max, dp[j]);
        }

        return max;
    }
}