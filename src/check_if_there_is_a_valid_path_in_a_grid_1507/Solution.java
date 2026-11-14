package check_if_there_is_a_valid_path_in_a_grid_1507;

import java.util.*;
class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int par[][][] = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                par[i][j] = new int[] { i, j };
            }
        }
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[] { 0, 0 });
        int dir[] = new int[] { 0, 1, 0, -1, 0 };

        while (!que.isEmpty()) {
            int next[] = que.poll();
            int i = next[0];
            int j = next[1];
            if(i==n-1 && j == m-1) return true;
            int p1[] = par(par, i, j);
            for (int k = 0; k < 4; k++) {
                int ni = i + dir[k];
                int nj = j + dir[k + 1];
                if (ni < 0 || nj < 0 || ni >= n || nj >= m)
                    continue;
                int p2[] = par(par, ni, nj);
                if (!equal(p1, p2) && possible(grid[i][j], grid[ni][nj], dir[k], dir[k+1])) {
                    int pi = p2[0];
                    int pj = p2[1];
                    que.offer(new int[]{ni, nj});
                    par[pi][pj] = p1;
                }

            }
        }


        return false;

    }

    private boolean possible(int curr, int next, int v, int h) {
        System.out.println(curr+":"+next+":"+h+":"+v);
        if((curr ==1 || curr ==2) && curr == next) return true;
        if((curr == 1 && next == 2) || (curr == 2 && next == 1)) return false;
        return switch(curr) {
            case 1 ->{
                if((next == 3 || next == 5) && h == 1){
                    yield true;
                } 

                if((next == 4 || next == 6) && h == -1) yield true;
                
                yield false;
            }

            case 2 ->{
                if((next == 5 || next == 6) && v == 1) yield true;
                if((next == 3 || next == 4) && v == -1) yield true;

                yield false;
            }

            case 3 ->{
                if((next == 2 || next == 5 || next == 6) && v == 1) yield true;
                if((next == 1 || next == 4 || next == 6) && h == -1) yield true;

                yield false;
            }

            case 4 ->{
                if((next == 2 || next == 5 || next == 6) && v == 1) yield true;
                if((next == 1 || next == 3 || next == 5) && h == 1) yield true;

                yield false;
            }

            case 5 ->{
                if((next == 2 || next == 3 || next == 4) && v == -1) yield true;
                if((next == 1 || next == 4 || next == 6) && h == -1) yield true;

                yield false;
            }

            case 6 ->{
                if((next == 2 || next == 3 || next == 4) && v == 1) yield true;
                if((next == 1 || next == 3 || next == 5) && h == 1) yield true;

                yield false;
            }


            default ->{
                yield true;
            }
        };
        
    }

    private boolean equal(int p1[], int p2[]) {
        return p1[0] == p2[0] && p1[1] == p2[1];
    }

    private int[] par(int par[][][], int i, int j) {
        int p[] = par[i][j];

        if (p[0] == i && p[1] == j)
            return p;

        return par[i][j] = par(par, p[0], p[1]);
    }
}