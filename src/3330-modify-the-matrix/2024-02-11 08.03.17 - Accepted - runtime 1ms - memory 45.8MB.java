class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int maxCol[] = new int[m];
        for(int j=0;j<m;j++){
            int max = 0;
            for(int i=0;i<n;i++){
                max = Math.max(max, matrix[i][j]);
            }
            maxCol[j] = max;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==-1){
                    matrix[i][j] = maxCol[j];
                }
            }
        }
        return matrix;
    }
}