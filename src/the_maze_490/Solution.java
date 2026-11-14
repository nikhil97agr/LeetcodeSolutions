package the_maze_490;

import java.util.*;
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        int n  = maze.length;
        int m = maze[0].length;

        boolean visited[][] = new boolean[n][m];

        return solve(start, dest, visited, n, m, maze);
    }

    private boolean solve(int curr[], int dest[], boolean visited[][], int n, int m, int maze[][]){
        if(Arrays.equals(curr, dest)) return true;

        if(visited[curr[0]][curr[1]]) return false;

        int x = curr[0];
        int y = curr[1];

        visited[x][y]= true;

        int diff[][] = {{0,1} , {0, -1}, {1,0}, {-1,0}};

        for(int d[] : diff){
            int r = x + d[0];
            int c = y + d[1];

            while(r <n && c < m && r >=0 && c>=0 && maze[r][c]==0){
                r += d[0];
                c += d[1];
            }

            if(solve(new int[]{r-d[0], c-d[1]}, dest, visited, n, m, maze)) return true;
        }

        return false;

    }
}