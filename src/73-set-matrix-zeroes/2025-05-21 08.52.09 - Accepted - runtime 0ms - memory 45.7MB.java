class Solution {
    public void setZeroes(int[][] matrix) {
      int r = matrix.length;
        int c = matrix[0].length;
        boolean col[] = new boolean[c];
        boolean row[] = new boolean[r];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(matrix[i][j]==0){
                    col[j] = true;
                    row[i] = true;
                }
            }
        }

        for(int i=0;i<r;i++){
            if(row[i]){
                for(int j=0;j<c;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        for(int i=0;i<c;i++){
            if(col[i]){
                for(int j=0;j<r;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}