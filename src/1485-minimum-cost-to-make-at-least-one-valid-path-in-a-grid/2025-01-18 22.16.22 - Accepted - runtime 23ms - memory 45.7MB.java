class Solution {
    public int minCost(int[][] grid) {
        int diff[][] = {{1, 0,1}, {2, 0,-1}, {3, 1,0}, {4, -1,0}};
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for(int x[] : dp){
            Arrays.fill(x, Integer.MAX_VALUE);
        }

        dp[0][0] = 0;

        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        que.offer(new int[]{0,0,0});
        while(!que.isEmpty()){
            int curr[] = que.poll();
            int r= curr[0];
            int c = curr[1];
            int cost = curr[2];

            if(r==n-1 && c==m-1) return cost;
            for(int d[] : diff){
                int sign = d[0];
                int nr = r + d[1];
                int nc = c + d[2];

                if(!isvalid(nr, nc, n, m)) continue;

                if(grid[r][c] == sign){
                    if(dp[r][c] < dp[nr][nc]){
                        dp[nr][nc]  = dp[r][c];
                        que.offer(new int[]{nr,nc, cost});
                    }
                }else{
                    if(dp[r][c] +1 < dp[nr][nc]){
                        dp[nr][nc] = dp[r][c] + 1;
                        que.offer(new int[]{nr,nc, cost+1});
                    }
                }
            }


        }

        return dp[n-1][m-1];
    }

    boolean isvalid(int r, int c, int n, int m){
        return r>=0 && r<n && c>=0 && c<m;
    }
}