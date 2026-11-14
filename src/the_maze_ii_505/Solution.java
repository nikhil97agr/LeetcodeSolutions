package the_maze_ii_505;

import java.util.*;
class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] dest) {
        int n = maze.length;
        int m = maze[0].length;

        int dist[][] = new int[n][m];
        for(int r[] : dist){
            Arrays.fill(r, Integer.MAX_VALUE);
        }

        dist[start[0]][start[1]] = 0;

        solve(start, maze, n, m, dist);

        int r = dest[0];
        int c = dest[1];

        return dist[r][c]==Integer.MAX_VALUE ? -1 : dist[r][c];
    }

    private void solve(int start[], int maze[][], int n, int m, int dist[][]){
        int diff[][] = {{0,1}, {0,-1}, {1,0}, {-1,0}};

        for(int d[] : diff){
            int r = start[0] + d[0];
            int c = start[1] + d[1];

            int cnt = 0;
            while(r <n && r >=0 && c<m && c>=0 && maze[r][c]==0){
                r+=d[0];
                c+=d[1];
                cnt++;
            }
            r -= d[0];
            c -= d[1];
            if(dist[start[0]][start[1]] + cnt < dist[r][c]){
                dist[r][c] = dist[start[0]][start[1]] + cnt;
                solve(new int[]{r,c}, maze, n, m, dist);
            }
        }
    }
}