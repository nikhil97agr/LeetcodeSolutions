package minimum_operations_to_remove_adjacent_ones_in_matrix_2259;

import java.util.*;
class Solution {
    Map<Integer, Integer> map;
    int n;
    int m;
    Set<Integer> vis;
    int grid[][];
    int diff[][] = new int[][]{{0,1}, {0,-1}, {-1,0},{1,0}};
    public int minimumOperations(int[][] grid) {
        int ans = 0;
        vis = new HashSet<>();
        m = grid.length;
        map = new HashMap<>();
        n = grid[0].length;
        this.grid = grid;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    continue;
                }

                int val = val(i, j);
                if(map.containsKey(val)) continue;
                vis = new HashSet<>();
                if(dfs(val)){
                    ans++;
                }
            }
        }

        return ans;
    }

    private boolean dfs(int val){
        for(int d[] : diff){
            int i = val / n;
            int j = val%n;

            int ni = i + d[0];
            int nj = j + d[1];
            if( ni < 0 || nj < 0 || ni >= m || nj >=n || grid[ni][nj] ==0) continue;

            int newVal = val(ni, nj);

            if(!vis.contains(newVal)){
                vis.add(newVal);
                if(!map.containsKey(newVal) || dfs(map.get(newVal))){
                    map.put(newVal, val);
                    map.put(val, newVal);
                    return true;
                }
            }
        }
        return false;
    }

    private int val(int i, int j){
        return n * i + j;
    }
}