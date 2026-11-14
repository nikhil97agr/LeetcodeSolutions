import java.util.PriorityQueue;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<Path> que= new PriorityQueue<>((p1,p2)-> p1.time - p2.time);
        int n = moveTime.length;
        int m = moveTime[0].length;
        boolean vis[][] = new boolean[n][m];
        que.offer(new Path(0, 0, 0));

        vis[0][0] = true;

        while(!que.isEmpty()){
            Path path = que.poll();

            if(path.i == n-1 && path.j == m-1) return path.time;
            int dir[][] = new int[][]{{0,1}, {0,-1}, {-1, 0}, {1,0}};

            for(int d[] : dir){
                int ni = path.i + d[0];
                int nj = path.j + d[1];
                int time = path.time;
                
                if(isValid(n, m, ni, nj, vis)){
                   int nextTime = moveTime[ni][nj];
                   vis[ni][nj] = true;
                   que.offer(new Path(ni, nj, Math.max(nextTime, time)+1));
                }
            }
        }
        return 0;
    }

    private boolean isValid(int n, int m, int i, int j, boolean vis[][]){
        return i >=0 && j>=0 && i<n && j<m && !vis[i][j];
    }

    class Path{
        int i;
        int j;
        int time;

        public Path(int i, int j, int time){
            this.i = i;
            this.j = j;
            this.time = time;
        }
    }
    
}