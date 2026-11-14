package minimum_number_of_days_to_disconnect_island_1691;

class Solution {
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;


        int total = 0;

        for (int g[] : grid) {
            for (int x : g)
                if (x == 1)
                    total++;
        }
        if(total == 1) return 1;
        if(total == 0) return 0;
        if(isDisconnected(grid, n, m)) return 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(isDisconnected(grid, n, m)){
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }

    private boolean isDisconnected(int grid[][], int n, int m){
        boolean traverse = false;
        boolean vis[][]=  new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    if(!vis[i][j]){
                        if(traverse) return true;

                        bfs(grid, i, j, vis, n, m);
                        traverse = true;
                    }
                }
            }
        }
        return false;
    }

    private void bfs(int grid[][], int i, int j, boolean vis[][], int n, int m) {
        vis[i][j] = true;

        int dir[][] = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int d[] : dir) {
            int ni = i + d[0];
            int nj = j + d[1];

            if (ni >= 0 && nj >= 0 && ni < n && nj < m && !vis[ni][nj] && grid[ni][nj] == 1) {
                bfs(grid, ni, nj, vis, n, m);
            }
        }
    }
}