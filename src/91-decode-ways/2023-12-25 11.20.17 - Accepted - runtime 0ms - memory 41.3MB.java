class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int dp[] = new int[n];
        if(s.startsWith("0")){
            return 0;
        }
        Arrays.fill(dp, -1);
        
        return solve(s, n, 0, dp);
    }
    
    public int solve(String s, int n, int i, int[] dp){
        if(i==n){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        
        if(s.charAt(i)=='0'){
             dp[i]=0;
        }
        
        else if(i==n-1){
             dp[i] = solve(s, n, i+1, dp);
        }
        else if(s.charAt(i)=='1'||(s.charAt(i)=='2'&&s.charAt(i+1)<='6'))
        {
           
            dp[i] = solve(s,n, i+1, dp) + solve(s, n, i+2, dp);
            
        }else{
         dp[i] = solve(s,n,i+1,dp);
        }
                

        return dp[i];
    }
}