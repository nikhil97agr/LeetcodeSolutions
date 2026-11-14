class Solution {
    Integer dp[][][];
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n][2];
        return solve(0, 0, 0, m, n, grid);
    }

    private int solve(int i, int j, int dir, int m, int n, int grid[][]){
        if(i==m-1 && j== n-1) return 1;
        if(i < 0 || j < 0 || i >= m || j >= n) return 0;
        if(dp[i][j][dir] != null) return dp[i][j][dir];
        int ans = 0;
        if(grid[i][j] == 1){
            if(dir == 0){
                ans = add(ans, solve(i+1, j, 1, m, n, grid));
            }else{
                ans = add(ans, solve(i, j+1, 0, m, n, grid));
            }
        }else{
            int d[][] = new int[][]{{0,1}, {1,0}};

            for(int di[] : d){
                int ni = di[0] + i;
                int nj = di[1] + j;

                ans = add(ans, solve(ni, nj, di[0], m, n, grid));
            }
        }    
        
        return dp[i][j][dir] = ans;
    }
    private boolean valid(int i, int j, int m, int n){
        return i >=0 && j >=0 && i < m && j < n;
    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;
        long sum = a+b;

        return (int)(sum%mod);
    }
}