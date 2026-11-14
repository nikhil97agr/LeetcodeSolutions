package search_a_2d_matrix_ii_240;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int x[] : matrix){
            for(int y : x) {
                if(y==target) return true;
            }
        }
        return false;
    }
}