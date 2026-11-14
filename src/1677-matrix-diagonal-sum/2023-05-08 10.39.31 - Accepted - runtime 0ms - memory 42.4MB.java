class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int sum = 0;
        for(int i=0;i<n;i++){
            if(n%2==1 && i==n/2){
                sum += mat[i][i];
                continue;
            }

            sum += mat[i][i] + mat[i][n-1-i];
        }
        return sum;
    }
}