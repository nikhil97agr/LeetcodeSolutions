package minimum_cost_to_cut_a_stick_1669;

import java.util.*;
class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Integer dp[][] = new Integer[m][m];
        Arrays.sort(cuts);
        return solve(0, n, 0, m-1, cuts, dp);
    }

    private int solve(int stickStart, int stickEnd, int i, int j, int cuts[], Integer dp[][]){
        if(i>j){
            return 0;
        }
        if(dp[i][j]!=null) return dp[i][j];

        int cost = Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int leftCutCost = solve(stickStart, cuts[k], i, k-1, cuts, dp);
            int rightCutCost = solve(cuts[k], stickEnd, k+1, j, cuts, dp);

            int c = (stickEnd - stickStart) + leftCutCost + rightCutCost;
            cost = Math.min(c, cost);
        }

        return dp[i][j] = cost;
    }
}