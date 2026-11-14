package toss_strange_coins_1166;

class Solution {
    public double probabilityOfHeads(double[] prob, int target) {
        Double dp[][] = new Double[prob.length][target + 1];
        return solve(prob, target, 0, dp);
    }

    private double solve(double prob[], int k, int ind, Double dp[][]){
        if(ind == prob.length){
            if( k ==0) return 1d;
            return 0d;
        }

        if( k < 0) return 0d;
        if(dp[ind][k] !=null) return dp[ind][k];
        double p1 = prob[ind] * solve(prob, k-1, ind+1, dp);
        double p2 = (1d - prob[ind]) * solve(prob, k, ind + 1, dp);

        return dp[ind][k] = p1 + p2;


    }
}