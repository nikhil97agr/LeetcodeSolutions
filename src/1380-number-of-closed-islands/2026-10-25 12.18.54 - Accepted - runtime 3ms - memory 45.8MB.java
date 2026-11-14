class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            if(grid[i][0]==0 && !visited[i][0]){
                dfs(grid, visited, i, 0, n, m);
            }
            if(grid[i][m-1]==0 && !visited[i][m-1]){
                dfs(grid, visited, i, m-1, n, m);
            }
        }

        for(int i=0;i<m;i++){
            if(grid[0][i]==0 && !visited[0][i]){
                dfs(grid, visited, 0, i, n, m);
            }

            if(grid[n-1][i]==0 && !visited[n-1][i]){
                dfs(grid, visited, n-1, i, n, m);
            }
        }
        int ans = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 && !visited[i][j]){
                    dfs(grid, visited, i, j, n, m);
                    ans++;
                }
            }
        }

        return ans;

        
    }

    private void dfs(int grid[][], boolean vis[][], int i, int j, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j] || grid[i][j]==1){
            return ;
        }

        vis[i][j] = true;
        dfs(grid, vis, i+1, j, n, m);
        dfs(grid, vis, i-1, j, n, m);
        dfs(grid, vis, i, j+1, n, m);
        dfs(grid, vis, i, j-1, n, m);

    }
}