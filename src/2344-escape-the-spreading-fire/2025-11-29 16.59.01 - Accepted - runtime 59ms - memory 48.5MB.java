class Solution {
    public int maximumMinutes(int[][] grid) {
        int start = 0;
        int end = (int)1e9;
        int n = grid.length;
        int m = grid[0].length;
        int time[][] = calcTime(grid, n, m);
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(time[0][0] !=0 && mid >= time[0][0]){
                end = mid - 1;
                continue;
            }
            if(check(mid, grid, n, m, time)){
                ans= mid;
                start = mid + 1;
            }else{
                 end = mid - 1;
            }
        }


        return ans;
    }

    private int[][] calcTime(int grid[][], int n, int m){
        int time[][] = new int[n][m];
        boolean vis[][] = new boolean[n][m];
        PriorityQueue<int[]> que= new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    vis[i][j] = true;
                    que.offer(new int[]{i,j , 0});
                }else if(grid[i][j] == 2){
                    time[i][j] = -1;
                    vis[i][j] = true;
                }
            }
        }
        int diff[] = new int[]{0,1,0,-1,0};
        while(!que.isEmpty()){
            int next[] = que.poll();
            int i= next[0];
            int j = next[1];
            int d = next[2];

            for(int k=0;k<4;k++){
                int ni =i + diff[k];
                int nj = j + diff[k+1];

                if(ni < 0 || nj < 0 || ni >=n || nj >= m|| vis[ni][nj]) continue;

                time[ni][nj] = d + 1;
                vis[ni][nj] = true;
                que.offer(new int[]{ni, nj, d + 1});
            }
        }


        return time;
    }

    private boolean check(int mid, int grid[][], int n, int m, int time[][]){

        PriorityQueue<int[]> que= new PriorityQueue<>((a,b) -> a[2] - b[2]);

        boolean vis[][] = new boolean[n][m];

        vis[0][0] = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 || grid[i][j] == 2){
                    vis[i][j] = true;
                }
            }
        }
        que.offer(new int[]{0, 0, mid});
        int diff[] = new int[]{0, 1, 0, -1, 0};
        while(!que.isEmpty()){
            int next[] = que.poll();
            int i = next[0];
            int j= next[1];
            int d = next[2];

            for(int k=0;k<4;k++){
                int ni =  i + diff[k];
                int nj = j + diff[k+1];

                if(ni < 0 || nj < 0 || ni >= n || nj >=m || vis[ni][nj] ) continue;

                if(ni == n-1 && nj == m-1){
                    if(time[ni][nj] ==0 || time[ni][nj] >= d + 1) return true;
                    return false;
                }

                if(time[ni][nj] !=0 && time[ni][nj] <= d + 1){
                    continue;
                }


                vis[ni][nj] = true;

                que.offer(new int[]{ni, nj, d + 1});
                
            }

        }


        return false;
    }
}