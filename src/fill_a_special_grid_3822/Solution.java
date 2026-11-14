package fill_a_special_grid_3822;

class Solution {
    int start = 0;
    public int[][] specialGrid(int N) {
        int n = 1<<N;

 

        int ans[][] = new int[n][n];

        if(n==0){
            ans[0][0] = 0;
            return ans;
        }


        solve(ans, n/2, 0, n-1);
        return ans;
    }

    private void solve(int grid[][], int n, int i, int j){
        if(n==0){
            grid[i][j] = start++;
            
            return;
        }

        solve(grid, n/2, i, j);
        solve(grid, n/2, i+n, j);
        solve(grid, n/2, i+n, j-n);
        solve(grid, n/2, i, j-n);

        
        

        
    }
}