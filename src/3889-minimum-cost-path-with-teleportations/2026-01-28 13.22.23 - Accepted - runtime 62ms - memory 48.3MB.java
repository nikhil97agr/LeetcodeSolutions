class Solution {
    public int minCost(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        int max  = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max, grid[i][j]);
            }
        }
        int temp[]= new int[max+ 1];
        Arrays.fill(temp, Integer.MAX_VALUE);
        temp[grid[m-1][n-1]] = 0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i== m-1 && j == n-1) continue;

                int bottom = (i + 1 < m) ? dp[i+1][j] + grid[i+1][j] : Integer.MAX_VALUE;
                int right = (j+1 < n) ? dp[i][j+1] + grid[i][j+1] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(bottom, right);

                int val =grid[i][j];

                temp[val] = Math.min(temp[val], dp[i][j]);
            }
        }

        int best[] = new int[max + 1];
        for(int i=0;i<k;i++){
            best[0] = temp[0];

            for(int x=1;x<=max;x++){
                best[x] = Math.min(best[x-1], temp[x]);
            }

            for(int x=m-1;x>=0;x--){
                for(int y=n-1;y>=0;y--){
                    if(x==m-1 && y==n-1) continue;

                    int bottom = (x + 1 < m) ? dp[x+1][y] + grid[x+1][y] : Integer.MAX_VALUE;
                int right = (y+1 < n) ? dp[x][y+1] + grid[x][y+1] : Integer.MAX_VALUE;

                dp[x][y] = Math.min(bottom, right);
                int val = grid[x][y];
                dp[x][y] = Math.min(dp[x][y], best[val]);

                temp[val] = Math.min(temp[val], dp[x][y]);
                }
            }
        }

        return dp[0][0];
    }
}