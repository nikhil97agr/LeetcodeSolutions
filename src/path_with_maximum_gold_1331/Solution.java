package path_with_maximum_gold_1331;

class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = Integer.MIN_VALUE;

        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans, solve(i, j, m, n, grid));
            }
        }
        return ans;
    }

    private int solve(int i, int j, int m, int n, int grid[][]){
        if(i==m || j==n) return 0;


        int temp = grid[i][j];
        grid[i][j] = 0;
        int ans = temp;

        if(i+1 < m && grid[i+1][j] !=0){
            ans = Math.max(ans, temp + solve(i+1, j, m, n, grid));
        }

        if(i-1 >=0 && grid[i-1][j]!=0){
            ans = Math.max(ans, temp + solve(i-1, j, m,n, grid));
        }

        if(j+1 < n && grid[i][j+1] !=0){
            ans = Math.max(ans, temp + solve(i, j+1, m, n, grid));
        }

        if(j-1 >=0 && grid[i][j-1] !=0){
            ans = Math.max(ans, temp + solve(i, j-1, m, n, grid));
        }

        grid[i][j] = temp;
        return ans;
    }
}