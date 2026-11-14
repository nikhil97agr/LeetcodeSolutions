class Solution {
    public boolean isMatch(String s, String p) {
      int n = s.length();
      int m = p.length();
      Boolean dp[][] = new Boolean[n][m];

      return solve(0,0, s, p, n, m, dp);  
    }

    private boolean solve(int i, int j, String s, String p, int n, int m, Boolean dp[][]){
        if(i==n){
            while(j<m){
                if(j==m-1){
                    return false;
                }
                if(p.charAt(j+1)!='*'){
                    return false;
                }
                j+=2;
            }
            return true;

        }
        if(j==m){
            return false;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }

        if(p.charAt(j)=='.'){
            if(j<m-1 && p.charAt(j+1)=='*'){
                dp[i][j] = solve(i+1,j, s, p, n, m, dp) || solve(i, j+2, s, p, n, m, dp);
            }else{

            dp[i][j] = solve(i+1, j+1, s, p, n, m, dp);
            }
        }else if(p.charAt(j)==s.charAt(i)){
            if(j<m-1 && p.charAt(j+1)=='*'){
                dp[i][j] = solve(i+1, j, s, p, n, m, dp) || solve(i, j+2, s, p, n, m, dp);
            }else{
                dp[i][j] = solve(i+1, j+1, s, p, n, m, dp);
            }


        }else{
            if(j<m-1 && p.charAt(j+1)=='*'){
                dp[i][j] = solve(i, j+2, s, p, n, m, dp);
            }else{
                dp[i][j] = false;
            }
        }
        return dp[i][j];
    }
}