package equal_sum_grid_partition_i_3849;

class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        long top = 0;
        long temp = 0;
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<n;i++){
             for(int j=0;j<m;j++){
                 top += grid[i][j];
             }   
        }
        temp = top;
        long bottom = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                bottom += grid[i][j];
                top -= grid[i][j];
            }

            if(top == bottom) return true;
        }

        top = bottom = 0;
        top = temp;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                top -= grid[j][i];
                bottom += grid[j][i];
            }

            if(top == bottom) return true;
        }

        return false;
    }
}