package maximal_rectangle_85;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int hist[][] = new int[n][m];
        for(int i=0;i<m;i++){
            if(matrix[0][i] == '1') hist[0][i] = 1;
        }

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    hist[i][j] = hist[i-1][j]+1;
                }
            }
        }
        int ans = 0;
        for(int h[] : hist){

            for(int i=0;i<m;i++){
                int last = i;
                int first = i;

                while(first >= 0 && h[first]>=h[i]){
                    first--;
                }
                while(last< m && h[last] >= h[i]){
                    last++;
                }

                ans = Math.max(ans, h[i] * (last - first - 1));
            }
        }
        return ans;
    }
}