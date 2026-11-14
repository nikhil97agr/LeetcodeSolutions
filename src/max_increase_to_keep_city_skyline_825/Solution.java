package max_increase_to_keep_city_skyline_825;

import java.util.*;
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int row[] = new int[n];
        int col[] = new int[n];
        Arrays.fill(row, -1);
        Arrays.fill(col, -1);
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> b[2] - a[2]);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                que.offer(new int[]{i, j, grid[i][j]});
            }
        }
        int ans = 0;
        while(!que.isEmpty()){
            int x[] = que.poll();
            int i =x[0];
            int j= x[1];
            int val = x[2];
            int r = row[i] == -1 ? val : row[i];
            int c = col[j] == -1 ? val : col[j];

            if(col[j] == -1) col[j] = val;
            if(row[i] == -1) row[i] = val;

            ans += (Math.min(r,c) - val);

        
        }
        return ans;
    }
}