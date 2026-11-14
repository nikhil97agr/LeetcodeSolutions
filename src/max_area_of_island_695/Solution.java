package max_area_of_island_695;

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n =grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                ans = Math.max(ans, solve(i,j,m,n, grid));
            }
        }
        return ans;
    }

    private int solve(int i, int j, int m, int n, int grid[][]){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==0){
            return 0;
        }

        grid[i][j] = 0;
        return 1 + solve(i+1, j, m, n, grid) + solve(i-1, j, m,n , grid) + solve(i , j+1, m, n, grid) + solve(i, j-1, m, n, grid);
    }
}