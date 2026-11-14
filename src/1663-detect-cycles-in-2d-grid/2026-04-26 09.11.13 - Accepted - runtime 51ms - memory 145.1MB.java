class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for(char c = 'a';c<='z';c++){
            boolean vis[][] =new boolean[m][n];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(!vis[i][j] && grid[i][j] == c){
                        if(dfs(grid, vis, c, i, j, -1, -1 , m, n)){
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char grid[][], boolean vis[][], char c, int i, int j, int pi, int pj, int m, int n){
        if( i < 0 || j < 0 || i >=m || j >= n || grid[i][j] != c){
            return false;
        }

        if(vis[i][j]) return true;
        vis[i][j] = true;
        int d[] = new int[]{0, 1, 0, -1, 0};

        for(int k=0;k<4;k++){
            int nx = i + d[k];
            int ny = j + d[k+1];

            if((nx != pi || ny != pj )&& dfs(grid, vis, c, nx, ny,i, j, m, n)){
                return true;
            }


        }

        return false;
    }
}