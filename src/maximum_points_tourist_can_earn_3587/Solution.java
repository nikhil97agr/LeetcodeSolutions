package maximum_points_tourist_can_earn_3587;

class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int ans = 0;
        Integer dp[][] = new Integer[n][k];
        for(int i=0;i<n;i++){
            ans = Math.max(ans, solve(n, k, stayScore, travelScore, 0, i, dp));
        }

        return ans;
    }

    private int solve(int n, int k, int [][] stayScore, int [][] travelScore, int currDay, int currDest, Integer dp[][]){

        if(currDay >=k ) return 0;
        if(dp[currDest][currDay]!= null) return dp[currDest][currDay];
        int max = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,
                    Math.max(
                        solve(n, k, stayScore, travelScore, currDay +1, currDest, dp) + stayScore[currDay][currDest],
                        solve(n, k, stayScore, travelScore, currDay + 1, i, dp) + travelScore[currDest][i]
                    )
                    );
        }

        return dp[currDest][currDay] = max;

    }
}