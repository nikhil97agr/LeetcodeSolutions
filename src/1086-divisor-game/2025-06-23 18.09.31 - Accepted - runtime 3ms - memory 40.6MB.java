class Solution {
    public boolean divisorGame(int n) {
        Boolean dp[][] = new Boolean[n+1][2];

        return solve(dp, n, 0);

        
    }

    private boolean solve(Boolean dp[][], int n, int curr){

        if(dp[n][curr] !=null) return dp[n][curr];

        for(int i=1;i<n;i++){
            if(n%i ==0){
                if(curr ==0){
                    if(solve(dp, n-i, 1)){
                        return dp[n][curr] =true;
                    }
                }else{
                    if(!solve(dp, n-i, 0)){
                        return dp[n][curr] = false;
                    }
                }
            }
        }

        if(curr == 0){
            return dp[n][curr] = false;
        }

        return dp[n][curr] = true;
    
    }
}