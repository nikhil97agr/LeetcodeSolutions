package flip_square_submatrix_vertically_3973;

class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int startX = x;
        int endX = x + k;
        int startY = y;
        int endY = y + k;
        int res[][] =new int[n][m];

        for(int i=0;i<n;i++){
            res[i] = grid[i].clone();
        }
        int i1=startX;
        int i2 = endX - 1;
        for(;i1 < endX;i1++,i2--){
            for(int j=startY;j<endY;j++){
                res[i1][j] = grid[i2][j];
            }
        }
        return res;
    }
}