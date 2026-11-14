package flood_fill_733;

import java.util.*;
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int start = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{sr, sc});
        boolean vis[][] = new boolean[m][n];
        vis[sr][sc] = true;
        image[sr][sc] = color;
        while(!que.isEmpty()){
            int next[] = que.poll();
            int dir[] = new int[]{0, 1, 0, -1, 0};

            for(int i=0;i<=3;i++){
                int nr = next[0] + dir[i];
                int nc = next[1] + dir[i+1];

                if(nr <0 || nc < 0 || nr >=m || nc >=n || vis[nr][nc] || image[nr][nc] != start)  continue;
                image[nr][nc] = color;
                vis[nr][nc] = true;
                que.offer(new int[]{nr,nc});
            }
        }
        return image;
    }
}