class Solution {
    public boolean checkPartitioning(String s) {
        int n =s.length();
        boolean dp[][] =new boolean[n][n];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                if(i <= 2){
                    if(s.charAt(j) == s.charAt(j+i-1)){
                        dp[j][j+i-1] = true;
                    }
                }else if(s.charAt(j) == s.charAt(j+i-1)){
                    dp[j][j+i-1] = dp[j+1][j+i-2];
                }
            }
        }

        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                if(dp[0][i] && dp[i+1][j] && dp[j+1][n-1]){
                    return true;
                }
            }
        }

        return false;
    }
}