class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int row[] = new int[m];
        int col[] = new int[n];
        for(int i=0;i<m;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(mat[i][j]==0){
                    cnt++;
                }
            }
            row[i] = cnt;
        }

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<m;j++){
                if(mat[j][i]==0){
                    cnt++;
                }
            }
            col[i] = cnt;
        }
        int ans = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1 && row[i] == n-1 && col[j]==m-1){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}