package nearest_exit_from_entrance_in_maze_2038;

import java.util.*;
class Solution {
    class Cell{
        int i;
        int j;
        int count;
        public Cell(int i, int j, int count){
            this.i = i;
            this.j = j;
            this.count = count;
        }
        public String toString(){
            return i+":"+j+":"+count;
        }
    }
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        Queue<Cell> que = new LinkedList();
        que.add(new Cell(entrance[0], entrance[1], 0));
        boolean visited[][] = new boolean[m][n];
        int istart = entrance[0], jstart=entrance[1];
        visited[entrance[0]][entrance[1]] = true;
        while(!que.isEmpty()){
            Cell cell = que.poll();
            int i=cell.i;
            int j = cell.j;
  
            if(isEdge(i,j, m, n) && (i!=istart || j!=jstart)){
                return cell.count;
            }
            int di[] = {1,-1,0,0};
            int dj[] = {0,0,-1,1};
            for(int k=0;k<4;k++){
                int nextI = i+di[k];
                int nextJ = j + dj[k];
                if(nextI>=m||nextI<0||nextJ>=n||nextJ<0||visited[nextI][nextJ] || maze[nextI][nextJ]=='+'){
                    continue;
                }
                que.add(new Cell(nextI, nextJ, cell.count+1));
                visited[nextI][nextJ] = true;
            }


        }
        return -1;

    }

    private boolean isEdge(int i, int j, int m, int n){
        if(i==m-1||j==n-1||i==0||j==0){
            return true;
        }
        return false;
    }
}