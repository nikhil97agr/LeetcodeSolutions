class NumMatrix {
    int pre[][];
    public NumMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        pre = new int[m][n];

        pre[0][0] = matrix[0][0];
        for(int i=1;i<n;i++){
            pre[0][i]  = pre[0][i-1] + matrix[0][i];
        }

        for(int i=1;i<m;i++){
            pre[i][0] = pre[i-1][0] + matrix[i][0];
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                pre[i][j] = matrix[i][j] + pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int total = pre[row2][col2];

        if(row1 !=0){
            total -= pre[row1-1][col2];
        }

        if(col1 !=0){
            total -= pre[row2][col1-1];
        }

        if(col1 !=0 && row1!=0){
            total += pre[row1-1][col1-1];
        }

        return total;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */