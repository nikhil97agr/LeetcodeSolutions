class Solution {
    Integer dp[][][];
    public int maximumRows(int[][] matrix, int numSelect) {
        int m = matrix[0].length;
        dp = new Integer[m][numSelect+1][1<<m];
        return solve(matrix, matrix.length, matrix[0].length, numSelect, 0, 0);
    }

    private int solve(int matrix[][], int m, int n, int cnt, int mask, int i){
        if(cnt ==0){
            int ans = 0;

            for(int j=0;j<(1<<m);j++){
                boolean temp = true;
                for(int k=0;k<m;k++){
                    boolean res = true;
                    
                    if((j & (1<<k))!=0){
                        for(int l =0;l<n;l++){
                            if((mask & (1<<l))==0 && matrix[k][l] ==1){
                                res= false;
                                break;
                            }
                        }
                    }

                    if(!res){
                        temp = false;
                        break;
                    }
                }

                if(temp){
                    ans = Math.max(ans, Integer.bitCount(j));
                }
            }

            return ans;

        }
        if(i==n) return 0;

        if(dp[i][cnt][mask] !=null) return dp[i][cnt][mask];

        return dp[i][cnt][mask] = Math.max(solve(matrix, m, n, cnt - 1, mask | (1<<i), i+1), solve(matrix, m, n, cnt , mask, i+1));
    }
}