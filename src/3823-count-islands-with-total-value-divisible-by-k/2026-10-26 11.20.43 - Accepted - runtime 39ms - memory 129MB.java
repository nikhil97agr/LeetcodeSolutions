class Solution {
    public int countIslands(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==0) vis[i][j]= true;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j]){
                    long sum = getSum(vis, grid, i, j, n, m);

                    if(sum%k==0) ans++;
                }
            }
        }

        return ans;
    }

    private long getSum(boolean[][] vis, int[][] grid, int i, int j, int n, int m) {

        if(i <0 || i>=n || j < 0 || j >=m || vis[i][j]){
            return 0;
        }

        long sum = grid[i][j];

        int dir[][] = new int[][]{
                {1,0}, {-1,0}, {0,1}, {0, -1}
        };

        vis[i][j] = true;

        for(int d[] : dir){
            sum += getSum(vis, grid, i + d[0], j+ d[1], n, m);
        }


        return sum;

    }


}