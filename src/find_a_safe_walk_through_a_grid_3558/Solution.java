package find_a_safe_walk_through_a_grid_3558;

import java.util.*;
class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        PriorityQueue<int[]> que = new PriorityQueue<int[]>((a,b) -> b[2] - a[2]);
        que.offer(new int[]{0,0,health - grid.get(0).get(0)});
        boolean vis[][] = new boolean[m][n];

        vis[0][0] = true;

        while(!que.isEmpty()){
            int next[] = que.poll();

            int i = next[0];
            int j = next[1];
            int h = next[2];
            if( h <=0) continue;

            if(i==m-1 && j==n-1){
                return true;
            }

            int dir[] = new int[]{0,1,0,-1,0};

            for(int d=0;d<4;d++){
                int ni = i + dir[d];
                int nj = j + dir[d+1];
                if(ni >=0 && nj >=0 && ni < m && nj < n && !vis[ni][nj]  ){
                int val = grid.get(ni).get(nj);
                    if(h-val > 0){
que.offer(new int[]{ni, nj, h - val});
                    vis[ni][nj] = true;
                    }
                    
                }
            }
        }

        return false;
    }
}