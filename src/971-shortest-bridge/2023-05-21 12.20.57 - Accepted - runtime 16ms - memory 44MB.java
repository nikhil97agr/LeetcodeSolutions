class Solution {
    public int shortestBridge(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        Set<int[]> cells = new HashSet<>();
        boolean island = false;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    dfs(m, n, i, j, grid, cells, visited);
                    island = true;
                    break;
                }
            }
            if(island) break;
        }
        Queue<int[]> que = new LinkedList<>();
        for(int x[] : cells){
            que.add(new int[]{x[0], x[1], 0});
        }

        while(!que.isEmpty()){
            int cell[] = que.poll();
            int i = cell[0];
            int j = cell[1];
            int level = cell[2];
            int diff[] = new int[]{1,0,-1,0,1};
            for(int x =0;x<4;x++){
                int ni = i + diff[x];
                int nj = j + diff[x+1];

                if(ni>=0 && ni<m && nj>=0 && nj<n && !visited[ni][nj]){
                    if(grid[ni][nj]==1){
                        return level;
                    }
                    que.add(new int[]{ni,nj, level+1});
                    visited[ni][nj] = true;
                }
            }
        }

        return -1;
    }

    private void dfs(int m, int n, int i, int j, int grid[][], Set<int[]> cells, boolean visited[][]){
        if(i>=m || i<0 || j>=n || j<0 || visited[i][j] || grid[i][j]==0){
            return;
        }

        cells.add(new int[]{i,j});
        visited[i][j] = true;

        int diff[] = new int[]{1,0,-1,0,1};
        for(int x=0;x<4;x++){
            int ni = i+diff[x];
            int nj = j + diff[x+1];
            dfs(m, n, ni, nj, grid, cells, visited);
        }

    }
}