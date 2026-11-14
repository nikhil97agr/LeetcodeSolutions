class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        
        Integer dp[][] = new Integer[x+12][2];
        return Math.min(solve(x, y, dp, 0), solve(x, y, dp, 1));
        
    }
    
    private int solve(int x, int y, Integer dp[][], int op){
        if(x<=y) return y-x;
        if(dp[x][op]!=null) return dp[x][op];
        
        if(op==1){
            int rem = x%11;
            int ans1 = rem+1;
            int next = (x-rem)/11;
                ans1 += Math.min(solve(next, y, dp, 0), solve(next, y, dp ,1));
            
            
            rem = 11-rem;
            next++;
            int ans2 = rem+1;
            
                ans2 += Math.min(solve(next, y, dp, 0), solve(next, y , dp, 1));
            
            return dp[x][op] = Math.min(ans1, Math.min(ans2, x-y));            
        }else{
            int rem = x%5;
            int ans1 = rem+1;
            int next = (x-rem)/5;
           
                ans1 += Math.min(solve(next, y, dp, 0), solve(next, y, dp ,1));
           
            
            rem = 5-rem;
            next++;
            int ans2 = rem+1;
           
           
                ans2 += Math.min(solve(next, y, dp, 0), solve(next, y , dp, 1));
            
            return dp[x][op] = Math.min(ans1, Math.min(ans2, x-y));
        }
    }
}