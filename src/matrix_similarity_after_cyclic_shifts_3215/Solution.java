package matrix_similarity_after_cyclic_shifts_3215;

class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        int back = n-k;
        int temp[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i%2==0){
                    int x = j;
                    for(int l=1;l<=k;l++){
                        x--;
                        if(x<0){
                            x = m-1;
                        }
                    }
                    temp[i][x] = mat[i][j];
                }else{
                    int x = j;
                    for(int l=1;l<=k;l++){
                        x++;
                        if(x>=m) x=0;
                    }
                    temp[i][x] = mat[i][j];
                    
                }
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]!=temp[i][j]) return false;
            }
        }
        return true;
    }
}