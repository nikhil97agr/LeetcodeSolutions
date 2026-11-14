package check_if_grid_satisfies_conditions_3415;

class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                boolean x = true;
                boolean y = true;
                if(i+1 <n && grid[i][j] != grid[i+1][j]){
                    x= false;
                }
                if(j+1 < m && grid[i][j] == grid[i][j+1]){
                    y = false;
                }
                
                
                if(!x || !y){
                    return false;
                }
            }
        }
        return true;
    }
}