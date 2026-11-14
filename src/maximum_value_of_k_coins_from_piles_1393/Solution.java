package maximum_value_of_k_coins_from_piles_1393;

import java.util.*;
class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int n = piles.size();
        Integer dp[][] = new Integer[n][k];

        return solve(dp, piles, k, n, 0);
    }

    private int solve(Integer dp[][], List<List<Integer>> piles, int k, int n, int ind){
        if(ind==n){
            return 0;
        }

        if(k<=0){
            return  0;
        }

        if(dp[ind][k-1]!=null){
            return dp[ind][k-1];
        }

        int max = solve(dp, piles, k, n, ind+1);
        int sum = 0;
        int m = piles.get(ind).size();
        for(int i=0;i<Math.min(m,k);i++){
            sum += piles.get(ind).get(i);
            max = Math.max(max, sum + solve(dp, piles, k-1-i,n,ind+1));
        }

        return dp[ind][k-1] = max;


    }
}