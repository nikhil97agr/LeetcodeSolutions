package sum_of_remoteness_of_all_cells_3148;

import java.util.*;
class Solution {
    public long sumRemoteness(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == -1) vis[i][j] = true;
            }
        }
        Map<Integer, Long> map = new HashMap<>();
        int par[][] = new int[n][m];
        int next = 1;
        long ans= 0;
        long sum = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] !=-1) sum += grid[i][j];
                if(!vis[i][j]){
                    dfs(grid, i, j, n, m, par, map, vis, next);
                    next++;
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] != -1){
                    long remain = sum - map.get(par[i][j]);
                    ans += remain;
                }
            }
        }

        return ans;
    }

    private void dfs(int grid[][], int i, int j, int n, int m, int par[][], Map<Integer, Long> map, boolean vis[][], int parent){
        if(i <0 || j < 0 || i >=n || j >=m || vis[i][j]) return;

        vis[i][j] =true;
        map.merge(parent, 1l*grid[i][j], Long::sum);
        par[i][j] = parent;

        int dir[] = new int[]{0,1,0,-1,0};

        for(int d =0;d<4;d++){
            int ni = i+ dir[d];
            int nj = j + dir[d+1];

            dfs(grid, ni, nj, n, m, par, map, vis, parent);
        }
    }
}