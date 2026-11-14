class Solution {
    public int minSteps(int n) {
        if(n==1) return 0;
        Integer dp[][] = new Integer[n+1][n+1];

        return 1+ solve(n, dp, 1, 1);
    }

    private int solve(int n, Integer dp[][], int pasteLength, int currLength){
        if(currLength == n) return 0;

        if(currLength > n) return 1001;

        if(dp[pasteLength][currLength]!=null) return dp[pasteLength][currLength];

        return dp[pasteLength][currLength] = Math.min(
            1 + solve(n, dp, pasteLength, currLength+pasteLength),
            2 + solve(n, dp, currLength, 2*currLength)
        );
    }
}