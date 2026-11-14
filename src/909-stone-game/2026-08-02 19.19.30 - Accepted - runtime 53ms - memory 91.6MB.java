class Solution {
    public boolean stoneGame(int[] piles) {
        Integer dp[][][] = new Integer[piles.length][piles.length][2];
        int ans = solve(piles, 0, piles.length-1, 0, dp);


        return ans > 0;
    }

    private int solve(int piles[], int start, int end, int turn, Integer dp[][][]){
        if(end < start) return 0;

        if(dp[start][end][turn]!=null) return dp[start][end][turn];
        if(turn ==0 ){
            return dp[start][end][turn] = Math.max(solve(piles, start, end-1,1, dp) + piles[end], solve(piles, start+1, end, 1, dp) + piles[start]);
        }

        return dp[start][end][turn] =  Math.min(
            solve(piles, start, end-1, 0, dp) - piles[end],
            solve(piles, start+1, end, 0, dp) - piles[start]
        );

    }
}