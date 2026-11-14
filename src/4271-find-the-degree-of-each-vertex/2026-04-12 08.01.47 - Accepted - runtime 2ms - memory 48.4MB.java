class Solution {
    public int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int degree[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(matrix[i][j] == 1){
                    degree[i]++;
                    degree[j]++;
                }
            }
        }

        return degree;
    }
}