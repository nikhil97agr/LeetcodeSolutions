package count_square_submatrices_with_all_ones_1402;

class Solution {
    public int countSquares(int[][] matrix) {
        int ans = 0 ;
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1 && i>0 && j>0){
                    matrix[i][j] =Math.min(matrix[i-1][j], Math.min(matrix[i][j-1], matrix[i-1][j-1]))+1;
                }

                ans += matrix[i][j];
            }   
        }

        return ans;
    }
}