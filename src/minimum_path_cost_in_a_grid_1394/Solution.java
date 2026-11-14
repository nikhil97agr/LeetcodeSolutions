package minimum_path_cost_in_a_grid_1394;

class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;

        int ans = Integer.MAX_VALUE;
        Integer dp[][] = new Integer[m][n];
        for(int i=0;i<n;i++){
            ans = Math.min(ans, solve(0, i, m, n, grid, moveCost, dp));
        }

        return ans;
    }

    private int solve(int i, int j, int m, int n, int grid[][], int cost[][], Integer dp[][]){
        if(i==m-1){
            return grid[i][j];
        }
        if(dp[i][j] !=null) return dp[i][j];
        int ans = Integer.MAX_VALUE;

        for(int k=0;k<n;k++){
            ans = Math.min(ans, solve(i+1, k, m, n, grid, cost, dp) + grid[i][j] + cost[grid[i][j]][k]);
        }

        return dp[i][j] =ans;
    }
}