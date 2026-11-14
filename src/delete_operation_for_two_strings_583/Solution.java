package delete_operation_for_two_strings_583;

import java.util.*;
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n][m];
        for(int x[] : dp){
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        solve(word1, word2, n-1, m-1, dp);
        return dp[n-1][m-1];
    }
    
    public int solve(String s1 ,String s2, int i, int j, int dp[][]){
        if(i==-1){
            return j+1;
        }
        if(j==-1){
            return i+1;
        }
        
        if(dp[i][j]!=Integer.MAX_VALUE){
            return dp[i][j];
        }
        
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = solve(s1, s2, i-1, j-1, dp);
            return dp[i][j];
        }
        
        dp[i][j] =1+ Math.min(solve(s1, s2, i-1, j, dp), solve(s1, s2, i, j-1,dp));
        
        return dp[i][j];
    }
}