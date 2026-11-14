class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        que.offer(new int[]{0, 0, grid[0][0]});
        int m = grid.length;
        int n = grid[0].length;
        int time[][] = new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        time[0][0] = grid[0][0];

        while(!que.isEmpty()){
            int next[] = que.poll();
            int i = next[0];
            int j = next[1];
            int t = next[2];

            if(i==m-1 && j ==n-1) return t;

            int dir[] = new int[]{0,1,0,-1,0};

            for(int k=0;k<dir.length - 1;k++){
                int ni = i + dir[k];
                int nj = j + dir[k+1];
                if(ni < 0 || nj < 0 || ni >=m || nj >= n) continue;

                int nt = Math.max(t, grid[ni][nj]);

                if(time[ni][nj] > nt){
                    time[ni][nj] = nt;

                    que.offer(new int[]{ni, nj, nt});
                }
            }
        }

        return -1;
    }
}