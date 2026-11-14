package sequential_grid_path_cover_3899;

import java.util.*;
class Solution {
    public List<List<Integer>> findPath(int[][] grid, int k) {
        List<List<Integer>> result = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((grid[i][j] ==0 || grid[i][j] == 1) && solve(grid, new boolean[m][n], i, j, result, 0, 1 + (grid[i][j] ==0 ? 0 : 1), k, m, n)) return result;
            }
        }
        return result;
    }

    private boolean solve(int grid[][], boolean vis[][], int i, int j, List<List<Integer>> result, int cnt, int next, int k, int m, int n){
        

        int dir[] = new int[]{1,0,-1,0,1};
        result.add(List.of(i, j));
        vis[i][j] = true;
        cnt++;

        if(cnt == m*n){
            return true;
        }

        for(int d=0;d<4;d++){
            int ni = i + dir[d];
            int nj = j + dir[d+1];
            if(ni < 0 || nj < 0 || ni >= m || nj >= n || vis[ni][nj]){
                continue;
            }

            if(grid[ni][nj] ==0 || grid[ni][nj] == next){
                if(solve(grid, vis, ni, nj, result, cnt, next + (grid[ni][nj] ==0 ? 0 : 1), k, m, n)){
                    return true;
                }
            }
            

            

        }

        result.remove(result.size()-1);
        vis[i][j] = false;
        return false;
    }
}