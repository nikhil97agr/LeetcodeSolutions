package wildcard_matching_44;

class Solution {
    public boolean isMatch(String s, String p) {
        int n =s.length();
        int m = p.length();
        Boolean dp[][] = new Boolean[n][m];

        return solve(0,0,s,p,dp, n, m);
    }

    private boolean solve(int i, int j, String s, String p, Boolean dp[][], int n, int m){
        if(i==n&&j==m){
            return true;
        }

        if(j==m){
            return false;
        }
        if(i==n){
            while(j<m){
                if(p.charAt(j)!='*'){
                    return false;
                }
                j++;
            }

            return true;
        }

        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean ans = false;
        if(p.charAt(j)=='*'){
            ans = solve(i+1, j+1, s,p,dp,n,m) || solve(i+1,j, s, p, dp, n, m) || solve(i, j+1, s, p, dp, n, m);
        }else if(p.charAt(j)=='?' || p.charAt(j)==s.charAt(i)){
            ans = solve(i+1, j+1, s, p, dp, n, m);
        }

        return dp[i][j] = ans;
    }
}