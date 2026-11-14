package count_fertile_pyramids_in_a_land_2193;

class Solution {
    public int countPyramids(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        int ones[][] = new int[n][m];
        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                cnt++;
                ones[i][j] = cnt;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    ans += solve(grid, i+1, j-1, j+1, n, m, 1, ones);
                }
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(grid[i][j]==1){
                    ans += solve(grid, i-1, j-1, j+1, n, m, -1, ones);
                }
            }
        }
        return ans;
    }

    private int solve(int grid[][], int i, int j1, int j2, int n, int m, int diff, int ones[][]){
        if(i>=n || i<0 || j1>=m || j2>=m || j1<0 || j2<0) return 0;

        boolean found = true;
        int count = ones[i][j2] - ones[i][j1] + (grid[i][j1]==0 ? 0 : 1);
        if(count!=(j2-j1)+1) return 0;


        return 1 + solve(grid, i+diff, j1-1, j2+1, n, m, diff, ones);
    }
}