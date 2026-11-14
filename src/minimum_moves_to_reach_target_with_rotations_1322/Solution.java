package minimum_moves_to_reach_target_with_rotations_1322;

import java.util.*;
class Solution {
    public int minimumMoves(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        Queue<int[]> que = new LinkedList<>();
        boolean vis[][][] = new boolean[n][n][2];

        vis[0][1][0] = true;

        que.offer(new int[]{0, 1, 0});
        while(!que.isEmpty()){
            int size= que.size();
            while(size-- > 0){
                int next[] = que.poll();
                if(next[0] == n-1 && next[1] == n-1 && next[2] == 0){
                    return ans;
                }

                int i = next[0];
                int j = next[1];
                int dir = next[2];
                if(dir == 1){
                    if(i+1 < n && grid[i+1][j] ==0 && !vis[i+1][j][1]){
                        vis[i+1][j][1] = true;
                        que.offer(new int[]{i+1, j, 1});
                    }

                    if(j+1 < n && grid[i][j+1]==0 && grid[i-1][j+1] ==0){
                        if(!vis[i][j+1][1]){
                            vis[i][j+1][1] = true;
                            que.offer(new int[]{i, j+1, 1});
                        }

                        if(!vis[i-1][j+1][0]){
                            que.offer(new int[]{i-1, j+1, 0});
                            vis[i-1][j+1][0] = true;
                        }
                    }
                }else{
                    if(j+1 < n && grid[i][j+1] ==0 && !vis[i][j+1][0]){
                        que.offer(new int[]{i , j+1, 0});
                        vis[i][j+1][0] = true;
                    }

                    if(i + 1 < n && grid[i+1][j] ==0  && grid[i+1][j-1] ==0){
                        if(!vis[i+1][j][0]){
                            vis[i+1][j][0] = true;
                            que.offer(new int[]{i+1, j, 0});
                        }

                        if(!vis[i+1][j-1][1]){
                            que.offer(new int[]{i+1, j-1, 1});
                        }
                    }
                }
            }
            ans++;
        }

        return -1;
    }
    
}