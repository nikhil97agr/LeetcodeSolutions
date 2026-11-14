package minimum_time_to_visit_a_cell_in_a_grid_2711;

import java.util.*;
import java.util.PriorityQueue;

class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTime(new int [][]{{0,1,3,2},{5,1,2,5},{4,3,8,6}}));

    }
    public int minimumTime(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean visited[][] = new boolean[m][n];
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        que.offer(new int[]{0, 0, 0});
        if(grid[0][1] > 1 && grid[1][0] > 1) return -1;
        visited[0][0] = true;

        while(!que.isEmpty()){
            int next[] = que.poll();
            int ci = next[0];
            int cj = next[1];
            int time = next[2];
            int dir[] = {0,1,0,-1,0};
            if(ci == m-1 && cj == n-1) return time;
            for(int i=0;i<4;i++){
                int ni = next[0] + dir[i];
                int nj = next[1] + dir[i+1];

                if(ni < 0 || nj < 0 || ni >= m || nj >= n || visited[ni][nj]) continue;

                visited[ni][nj] = true;

                if(time >= grid[ni][nj]){
                    que.offer(new int[]{ni, nj, time+1});
                }else{
                    int diff = grid[ni][nj] - time;
                    if(diff%2==0){
                        que.offer(new int[]{ni, nj, grid[ni][nj]+1});
                    }else{
                        que.offer(new int[]{ni,nj, grid[ni][nj]});
                    }
                }

            }
        }
        return -1;
    }
}