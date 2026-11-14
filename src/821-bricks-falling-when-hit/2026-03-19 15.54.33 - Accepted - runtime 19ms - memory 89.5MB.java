class Solution {

    boolean stable[][];
    int grid[][];
    int m;
    int n;
    int dir[]  = new int[]{0,1,0,-1,0};
    public int[] hitBricks(int[][] grid, int[][] hits) {

         m = grid.length;
         n = grid[0].length;
        stable = new boolean[m][n];
        boolean replaced[] = new boolean[hits.length];
        this.grid = grid;

        for (int i=0;i<hits.length;i++) {
            int h[] = hits[i];
            int x = h[0];
            int y = h[1];

            if(grid[x][y] == 1){
                replaced[i] = true;
            }
            grid[x][y] = 0;
        }
        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 1 && !stable[0][i]) {
                dfs(0, i);
            }
        }
        int ans[] =new int[hits.length];
        
        for(int i=hits.length - 1;i>=0;i--){
            int x = hits[i][0];
            int y = hits[i][1];
            if(!replaced[i]) continue;
            grid[x][y] = 1;
            if(x==0){
                stable[x][y] = true;
            }
            for(int j=0;!stable[x][y] && j<dir.length-1;j++){
                int ni = x + dir[j];
                int nj = y + dir[j+1];
                if(ni < 0 || nj < 0 || ni >=m || nj >=n || grid[ni][nj] ==0 || !stable[ni][nj]) continue;
                stable[x][y]= true;
                break;
            }

            if(!stable[x][y]) continue;
            int cnt = dfs2(x, y);
            ans[i] = cnt - 1;
        }
        
        return ans;
    }
    
    private int dfs2(int i, int j){
        int cnt =1;
        stable[i][j]= true;
        for(int k=0;k<dir.length - 1;k++){
            int ni = i + dir[k];
            int nj = j + dir[k+1];
            if(ni < 0 || nj < 0 || ni >= m || nj >=n || grid[ni][nj] ==0 || stable[ni][nj]){
                continue;
            }
            cnt += dfs2(ni, nj);
            
        }
        
        return cnt;
    }

    private void dfs(int i, int j){
        stable[i][j] = true;
        
        for(int k=0;k<dir.length - 1;k++){
            int ni = i + dir[k];
            int nj = j + dir[k+1];
            if(ni  < 0 || nj < 0 || ni >= m || nj >= n || grid[ni][nj] ==0 || stable[ni][nj]){
                continue;
            }
            dfs(ni,nj);
        }
    }
}