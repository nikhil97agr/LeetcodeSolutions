package edit_distance_72;

import java.util.*;
class Solution {
    public int minDistance(String word1, String word2) {
        int n =word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m];
        for(int x[] : dp){
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        return solve(word1, word2, n, m, dp, n-1 ,m-1);
       
    }

    private int solve(String word1, String word2, int n, int m, int dp[][], int i, int j){
        if(i<0){
            return j+1;
        }

        if(j<0){
            return i+1;
        }

        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }

        if(word1.charAt(i)==word2.charAt(j)){
            dp[i][j] = solve(word1, word2, n, m, dp, i-1, j-1);
        }

        dp[i][j] = Math.min(dp[i][j], 1+solve(word1, word2, n, m, dp, i-1,j));

        dp[i][j] = Math.min(dp[i][j], 1 + solve(word1, word2, n, m, dp, i-1, j-1));
        System.out.println(i+":"+j);
        dp[i][j] = Math.min(dp[i][j], 1+solve(word1, word2, n, m, dp, i, j-1));
        return dp[i][j];
    }
}




