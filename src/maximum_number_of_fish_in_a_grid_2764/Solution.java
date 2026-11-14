package maximum_number_of_fish_in_a_grid_2764;

import java.util.*;
class Solution {
    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;
        boolean vis[][] = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    vis[i][j] = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j]) {
                    Queue<int[]> que = new LinkedList<>();

                    que.offer(new int[] { i, j });
                    vis[i][j] = true;
                    int sum = 0;
                    while (!que.isEmpty()) {
                        int curr[] = que.poll();
                        sum += grid[curr[0]][curr[1]];

                        int diff[] = new int[]{1,0,-1,0,1};
                        for(int  k=0;k<diff.length-1;k++){
                            int ni = curr[0] + diff[k];
                            int nj = curr[1] + diff[k+1];

                            if(ni >=0 && nj >= 0 && ni<n && nj<m && !vis[ni][nj]){
                                vis[ni][nj] = true;
                                que.offer(new int[]{ni, nj });
                            }
                        }
                    }
                    ans = Math.max(ans, sum);
                }
            }
        }

        return ans;

    }
}