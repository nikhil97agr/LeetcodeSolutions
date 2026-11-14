class Solution {
    public int maxDistance(int[][] grid) {
        Queue<int[]>que = new LinkedList<>();
        int n = grid.length;
        int dp[][] =new int[n][n];
        for(int d[] : dp) Arrays.fill(d, -1);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1) que.offer(new int[]{i,j});
            }
        }
        int dir[][] = new int[][]{
            {0,1},{0,-1},
            {-1,0}, {-1,1},{-1,-1},
            {1,0}, {1,-1},{1,1}
        };
        while(!que.isEmpty()){
            int next[] = que.poll();
            int i = next[0];
            int j = next[1];
            for(int d[] : dir){
                int ni = i + d[0];
                int nj = j + d[1];

                if(ni < 0 || nj < 0 || ni >=n || nj >=n || grid[ni][nj] == 1) continue;
                int dist = dist(i, j, ni, nj);
                if(grid[i][j] ==0){
                    dist = dp[i][j] + (d[0]*d[1] ==0 ? 1 : 2);
                }

                if(dp[ni][nj] == -1 || dp[ni][nj] > dist){
                    dp[ni][nj] = dist;
                    que.offer(new int[]{ni, nj});
                }
            }
        }

        int ans = -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    private int dist(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}