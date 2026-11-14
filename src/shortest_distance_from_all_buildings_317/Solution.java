package shortest_distance_from_all_buildings_317;

import java.util.*;
class Solution {
    public int shortestDistance(int[][] grid) {
        int ans = Integer.MAX_VALUE;
        int req = 0;
        for(int g[] : grid){
            for(int x :g){
                if(x == 1){
                    req++;
                }
            }
        }

        int n = grid.length;
        int m = grid[0].length;
        int dir[] = new int[]{
            0, 1, 0, -1, 0
        };
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] !=0){
                    continue;
                }

                Queue<int[]> que = new LinkedList<>();

                que.offer(new int[]{i,j, 0});
                boolean vis[][] = new boolean[n][m];
                vis[i][j] = true;
                int sum = 0;
                int cnt = 0;
                while(!que.isEmpty() && cnt < req){
                    int next[] = que.poll();
                    int i1 = next[0];
                    int j1 = next[1];
                    int dist = next[2];

                    for(int k=0;k<dir.length-1;k++){
                        int ni = i1 + dir[k];
                        int nj = j1 + dir[k+1];

                        if(ni >=0 && nj >=0 && ni < n && nj < m && !vis[ni][nj] && grid[ni][nj] !=2){
                            if(grid[ni][nj] == 1){
                                cnt++;
                                vis[ni][nj] = true;
                                sum += (dist+1);
                                continue;
                            }

                            vis[ni][nj] = true;
                            que.offer(new int[]{ni, nj, dist + 1});
                        }
                    }
                }
                if(cnt == req)
                ans = Math.min(ans, sum);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}