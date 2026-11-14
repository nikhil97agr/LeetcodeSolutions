package minimum_number_of_flips_to_make_binary_grid_palindromic_i_3526;

class Solution {
    public int minFlips(int[][] grid) {
        int row = 0;
        int col = 0;
        int n = grid.length;
        int m= grid[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m/2;j++){
                if(grid[i][j] != grid[i][m-1-j]) row++;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n/2;j++){
                if(grid[j][i] != grid[n-1-j][i]) col++;
            }
        }

        return Math.min(row, col);
    }
}