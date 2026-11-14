class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans= 0;

        int m = matrix.length;
        int n = matrix[0].length;

        int row[][] = new int[m][n];


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] =='0'){
                    row[i][j] = 0 ;
                    continue;
                }
                if(i==0){
                    row[i][j] = 1;
                    continue;
                }
                row[i][j] = row[i-1][j] + 1;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int cnt = row[i][j];

                int total = 0;
                for(int k=j-1;k>=0 && row[i][k] >= cnt;k--){
                    total++;
                }
                for(int k=j+1;k<n && row[i][k] >= cnt; k++){
                    total++;
                }

                if(total +1 >= cnt){
                    ans = Math.max(ans, cnt*cnt);
                }
            }
        }

        return ans;
    }
}