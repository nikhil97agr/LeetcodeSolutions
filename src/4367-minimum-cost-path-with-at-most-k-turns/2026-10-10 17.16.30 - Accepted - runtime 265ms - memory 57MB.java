class Solution {
    public int minCost(int[][] grid, int k) {
        int ans = 0;

        int n = grid.length;
        int m = grid[0].length;
        int dp[][][][] = new int[n][m][4][k+1];
        for(var d1 : dp){
            for(var d2 : d1){
                for(var d3 : d2){
                    Arrays.fill(d3, Integer.MAX_VALUE);
                }
            }
        }
        var que = new PriorityQueue<Path>((a,b) -> a.cost - b.cost);
        for(int i=0;i<4;i++){
            dp[0][0][i][0] = grid[0][0];
            que.offer(new Path(0, 0, grid[0][0], i, 0));
        }

        int dir[] = new int[]{0, 1, 0, -1, 0};

        while(!que.isEmpty()){
            var next = que.poll();
            int r = next.r;
            int c = next.c;
            int cost = next.cost;
            if(cost != dp[r][c][next.dir][next.k]){
                continue;
            }

            if(r == n-1 && c == m-1)return cost;

            for(int i=0;i<4;i++){
                int nr = r + dir[i];
                int nc = c + dir[i + 1];

                if(nr < 0 || nc < 0 || nr >=n || nc >= m){
                    continue;
                }
                int turn = next.k;
                if(next.dir != i){
                    turn++;
                }
                if(turn > k){
                    continue;
                }
                int nextCost = cost + grid[nr][nc];
                if(nextCost < dp[nr][nc][i][turn]){
                    dp[nr][nc][i][turn] = nextCost;
                    que.offer(new Path(nr, nc, nextCost, i, turn));
                }
            }
        }



        return -1;

    }

    class Path{
        int r;
        int c;
        int cost;
        int dir;
        int k;

        public Path(int r, int c, int cost, int dir, int k){
            this.r = r;
            this.c= c;
            this.cost = cost;
            this.dir =dir;
            this.k = k;
        }
    }

}