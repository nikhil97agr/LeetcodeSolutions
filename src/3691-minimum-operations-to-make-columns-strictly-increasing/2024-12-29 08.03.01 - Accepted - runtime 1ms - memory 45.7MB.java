class Solution {
    public int minimumOperations(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int ans =0;
        for(int j=0;j<m;j++){
            for(int i=1;i<n;i++){
                if(grid[i][j] <= grid[i-1][j]){
                    ans += (grid[i-1][j] - grid[i][j] + 1);
                    grid[i][j] = grid[i-1][j]+1;
                }
            }
        }
        
        return ans;
    }
}