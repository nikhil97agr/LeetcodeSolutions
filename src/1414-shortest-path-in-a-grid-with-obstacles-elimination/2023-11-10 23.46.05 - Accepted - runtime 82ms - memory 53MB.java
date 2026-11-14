class Solution {
    class Cell{
        int r;
        int c;
        int steps;
        int obs;

        public Cell(int r, int c, int steps, int obs){
            this.r = r;
            this.c = c;
            this.steps=  steps;
            this.obs = obs;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][][] = new int[m][n][k+1];
        for(int x[][] : dp){
            for(int y[] : x){
                Arrays.fill(y, Integer.MAX_VALUE);
            }
        }


        dp[0][0][0] = 0;

        PriorityQueue<Cell> que = new PriorityQueue<>((a,b)->a.steps - b.steps);
        que.offer(new Cell(0, 0, 0, 0));

        while(!que.isEmpty()){
            Cell cell = que.poll();

            int r = cell.r;
            int c = cell.c;
            int steps = cell.steps;
            int obs =cell.obs;

            if(r==m-1 && c==n-1) return steps;

            if(obs>k) continue;


            int dir[][] = {{0,1},{0,-1}, {1,0}, {-1,0}};

            for(int d[] : dir){
                int nr = r + d[0];
                int nc = c + d[1];

                if(isValid(nr, nc, m, n)){
                    if(steps +1 < dp[nr][nc][obs]){
                        if(grid[nr][nc]==1){
                            dp[nr][nc][obs] = steps+1;
                            que.offer(new Cell(nr, nc, steps+1, obs+1));
                        }else{
                            dp[nr][nc][obs] = steps+1;
                            que.offer(new Cell(nr, nc, steps+1, obs));
                        }
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValid(int r, int c, int n, int m){
        return r>=0 && r<n && c>=0 && c<m;
    }
}