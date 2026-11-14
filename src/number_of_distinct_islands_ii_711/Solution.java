package number_of_distinct_islands_ii_711;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int numDistinctIslands2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<Map<Integer, Integer>> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    List<int[]> pos = new ArrayList<>();
                    bfs(i, j, grid, pos, m, n);
                    Map<Integer, Integer> map = new HashMap<>();
                    for(int i1 =0;i1< pos.size();i1++){
                        for(int i2 = i1 + 1;i2 < pos.size();i2++){
                            int dist = getDist(pos.get(i1), pos.get(i2));
                            map.merge(dist, 1, Integer::sum);
                        }
                    }
                    
                    set.add(map);
                }
            }
        }
        
        return set.size();
    }
    
    private int getDist(int a[], int b[]){
        return (int)Math.pow(a[0] - b[0], 2) + (int)Math.pow(a[1] - b[1], 2);
    }

    private void bfs(int i, int j, int grid[][], List<int[]> pos, int m, int n){
        grid[i][j] = 0;
        pos.add(new int[]{i, j});

        int dir[] = {0, -1, 0, 1, 0};
        for(int k=0;k<dir.length - 1;k++){
            int ni  = i + dir[k];
            int nj = j + dir[k+1];

            if( ni < 0 || ni >= m || nj < 0 || nj >= n || grid[ni][nj] ==0) continue;

            bfs(ni, nj, grid, pos, m, n);
        }
    }
}