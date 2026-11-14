class Solution {
    public int numPermsDISequence(String s) {
        int n = s.length();
        int dp[][] = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i] = 1;
        }
        int mod = 1_000_000_007;
        for(int j=0;j<n;j++){
            int current = 0;
            if(s.charAt(j) == 'D'){
                for(int i=n-1-j;i>=0;i--){
                    current = (current + dp[j][i+1])%mod;
                    dp[j+1][i] = current;
                }
            }else{
                for(int i=0;i<n-j;i++){
                    current = (current + dp[j][i])%mod;
                    dp[j+1][i] = current;
                }
            }
            
        }

        return dp[n][0];
    }
}