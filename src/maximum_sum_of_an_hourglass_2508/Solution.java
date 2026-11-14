package maximum_sum_of_an_hourglass_2508;

class Solution {
    public int maxSum(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j-1>=0 &&  i+2<m && j+1<n){
                    ans = Math.max(ans, grid[i][j-1] + grid[i][j] + grid[i][j+1] + grid[i+1][j] + grid[i+2][j-1] + grid[i+2][j]+ grid[i+2][j+1] );
                }
            }
        }
        return ans;
    }
}