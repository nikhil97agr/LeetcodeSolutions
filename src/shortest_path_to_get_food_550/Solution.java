package shortest_path_to_get_food_550;

import java.util.*;
class Solution {
    public int getFood(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int r= 0;
        int c = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '*'){
                    r = i;
                    c = j;
                }
            }
        }

        PriorityQueue<Cell> que= new PriorityQueue<>((c1, c2) -> c1.cnt - c2.cnt);
        boolean vis[][] = new boolean[m][n];
        vis[r][c] = true;

        que.offer(new Cell(r, c, 1));

        while(!que.isEmpty()){
            Cell cell = que.poll();


            int diff[] = new int[]{0, 1, 0, -1, 0};

            for(int i=0;i<4;i++){
                int nr = cell.r + diff[i];
                int nc = cell.c + diff[i+1];

                if(nr < 0 || nc < 0 || nr >= m || nc >= n|| vis[nr][nc] || grid[nr][nc] == 'X'){
                    continue;
                }

                if(grid[nr][nc] == '#'){
                    return cell.cnt;
                }
                vis[nr][nc] =true;
                que.offer(new Cell(nr, nc, cell.cnt + 1));
            }
        }

        return -1;

        
    }

    class Cell{
        int r;
        int c;
        int cnt;

        public Cell(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}