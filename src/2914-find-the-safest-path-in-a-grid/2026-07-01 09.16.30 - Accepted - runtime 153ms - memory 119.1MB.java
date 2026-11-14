class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int dist[][] = new int[n][n];

        Queue<int[]> que = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid.get(i).get(j) == 1){
                    dist[i][j] = 0;
                    que.offer(new int[]{i,j});
                }else{
                    dist[i][j] = -1;
                }
            }
        }
        int diff[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!que.isEmpty()){
            int cell[] = que.poll();
            for(int x[] : diff){
                int ni = cell[0] + x[0];
                int nj = cell[1] + x[1];

                if(isValid(n, ni, nj) && dist[ni][nj] == -1){
                    dist[ni][nj] = dist[cell[0]][cell[1]]+1;
                    que.offer(new int[]{ni,nj});
                }
            }
        }

        int min =0 ;
        int ans = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                max = Math.max(max, dist[i][j]);
            }
        }
        while(min <= max){
            int mid = (min+max)/2;
            if(isValid(dist, mid)){
                ans = mid;
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        return ans;
    }

    private boolean isValid(int mat[][], int value){
        int n = mat.length;

        if(mat[0][0] < value || mat[n-1][n-1] < value) return false;

        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0,0});
        boolean vis[][] = new boolean[n][n];
        vis[0][0] = true;
        int diff[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        while(!que.isEmpty()){
            int cell[] = que.poll();
            if(cell[0] == n-1 && cell[1] == n-1) return true;
            for(int d[] : diff){
                int ni = cell[0] + d[0];
                int nj = cell[1] + d[1];

                if(isValid(n, ni, nj) && mat[ni][nj] >= value && !vis[ni][nj]){
                    vis[ni][nj] = true;
                    que.offer(new int[]{ni, nj});
                }
            }
        }
        return false;
    }

    private boolean isValid(int n, int i, int j){
        return i >= 0 && j>=0 && i<n && j<n;
    }
}