class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int cost[] = new int[]{0,1,1};
        int ans = solve(0, 0, n, m, k - cost[grid[0][0]], grid, new Integer[n][m][k+1], cost);

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    private int solve(int i, int j, int n, int m, int k, int grid[][], Integer dp[][][], int cost[]){
        if( k < 0) return Integer.MIN_VALUE;

        if(i==n-1 && j== m-1){


            return grid[i][j];
        }

        if(dp[i][j][k]!=null) return dp[i][j][k];

        int ans = Integer.MIN_VALUE;
        int dir[] = new int[]{0,1,0};

        for(int l=0;l<2;l++){
            int ni = i + dir[l];
            int nj = j + dir[l+1];
            if(ni <0 || nj < 0 || ni >=n || nj >= m){
                continue;
            }
            int val = grid[i][j];
            int temp =  solve(ni, nj, n, m, k - cost[grid[ni][nj]], grid, dp, cost);

            if(temp != Integer.MIN_VALUE){
                ans = Math.max(ans, val + temp);
            }
        }


        return dp[i][j][k] = ans;
    }
}