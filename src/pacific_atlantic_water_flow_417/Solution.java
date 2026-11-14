package pacific_atlantic_water_flow_417;

import java.util.*;
class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Queue<int[]> que = new LinkedList<>();  // 0 -> Val, 1 -> i, 2 -> j, 3 -> flag( 0 for P, 1 for A)

        int n= heights.length;
        int m = heights[0].length;
        boolean vis[][][] = new boolean[n][m][2];
        for(int i=0;i<n;i++){
            que.offer(new int[]{heights[i][0], i, 0, 0});
            que.offer(new int[]{heights[i][m-1], i, m-1, 1});
            vis[i][0][0] = vis[i][m-1][1] = true;
        }

        for(int i=0;i<m;i++){
            que.offer(new int[]{heights[0][i], 0, i, 0});
            que.offer(new int[]{heights[n-1][i], n-1, i, 1});

            vis[0][i][0] = vis[n-1][i][1] = true;
        }

        while(!que.isEmpty()){
            int node[] = que.poll();

            int dir[] = new int[]{0, 1, 0, -1, 0};
            for(int i=0;i<dir.length - 1;i++){
                int ni = node[1] + dir[i];
                int nj = node[2] + dir[i+1];

                if(ni >=0 && nj >=0 && ni< n && nj < m && !vis[ni][nj][node[3]] && node[0] <= heights[ni][nj]){
                    vis[ni][nj][node[3]] = true;
                    que.offer(new int[]{heights[ni][nj], ni, nj, node[3]});
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j][0] && vis[i][j][1]){
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }
}