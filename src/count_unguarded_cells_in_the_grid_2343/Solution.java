package count_unguarded_cells_in_the_grid_2343;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][]= new int[m][n];

        for(int g[] : guards){
            grid[g[0]][g[1]] = 1;
        }

        for(int w[] : walls){
            grid[w[0]][w[1]] = 2;
        }
        int mat[][] = new int[m][n];

        for(int i=0;i<m;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    cnt++;
                }else if(grid[i][j] == 2){
                    cnt = 0;
                }else{
                    mat[i][j]+=cnt;
                }
            }

            cnt = 0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j] == 1){
                    cnt++;
                }else if(grid[i][j]==2){
                    cnt = 0;
                }else{
                    mat[i][j]+=cnt;
                }
            }
        }

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<m;j++){
                if(grid[j][i] == 1){
                    cnt++;
                }else if(grid[j][i] == 2){
                    cnt = 0;
                }else{
                    mat[j][i]+=cnt;
                }
            }

            cnt = 0;
            for(int j=m-1;j>=0;j--){
                if(grid[j][i] == 1){
                    cnt++;
                }else if(grid[j][i] == 2){
                    cnt = 0;
                }else{
                    mat[j][i]+=cnt;
                }
            }
        }

        int ans = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] ==0 && mat[i][j]==0){
                    ans++;
                }
            }
        }
        return ans;
    }
}