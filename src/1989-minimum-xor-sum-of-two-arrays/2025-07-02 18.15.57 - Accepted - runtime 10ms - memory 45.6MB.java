class Solution {
    public int minimumXORSum(int[] a, int[] b) {
        int n =a.length;
        int max = (1<<n);

        Integer dp[][] = new Integer[n][max];

        return solve(a, b, dp, 0, 0, n,max-1);
    }

    private int solve(int a[], int b[], Integer dp[][], int i, int currState, int n,int finalState){
        
        if(currState == finalState) return 0;


        if(dp[i][currState]!=null) return dp[i][currState];
        int ans = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            if((currState & (1<<j)) == 0){
                ans = Math.min(ans, (a[j] ^ b[i]) + solve(a, b, dp, i+1, currState | (1<<j), n, finalState));
            }
        }

        return dp[i][currState] = ans;


    }


}