package multi_source_flood_fill_4283;

import java.util.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

class Solution {

    public int[][] colorGrid(int n, int m, int[][] sources) {
        var grid = new int[n][m];
        var que = new LinkedList<int[]>();
        boolean vis[][] = new boolean[n][m];

        for(int s[] : sources){
            grid[s[0]][s[1]] = s[2];
            vis[s[0]][s[1]] = true;
            que.offer(new int[]{s[0], s[1]});
        }
        int diff[] = new int[]{0, 1, 0, -1, 0};
        
        while(!que.isEmpty()){
            Map<Integer, Set<Integer>> map = new HashMap<>();
            while(!que.isEmpty()){
                int next[] = que.poll();
                for(int i=0;i<4;i++){
                    int x = next[0] + diff[i];
                    int y = next[1] + diff[i+1];
                    if( x < 0 || y < 0 || x >=n || y >=m|| vis[x][y]){
                        continue;
                    }
                    
                    grid[x][y] = Math.max(grid[x][y], grid[next[0]][next[1]]);
                    map.computeIfAbsent(x, xx-> new HashSet<>()).add(y);
                }
            }
            
            for(var entry : map.entrySet()){
                int x = entry.getKey();
                for(int y : entry.getValue()){
                    vis[x][y] = true;
                    que.offer(new int[]{x, y});
                }
            }
        }
        
        return grid;
        
        
    }
}