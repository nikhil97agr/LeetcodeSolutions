package minimum_insertion_steps_to_make_a_string_palindrome_1437;

import java.util.*;
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];
        for(int d[] : dp){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            dp[i][i] = 0;
        }

        return solve(s, 0, n-1, dp);

    }

    private int solve(String s, int start, int end, int dp[][]){
        if(start>=end){
            return 0;
        }

        if(dp[start][end]!=Integer.MAX_VALUE){
            return dp[start][end];
        }

        if(s.charAt(start)==s.charAt(end)){
            dp[start][end] = solve(s, start+1, end-1, dp);
        }else{
            dp[start][end] = 1+Math.min(solve(s, start+1,end, dp), solve(s, start, end-1, dp));
        }
        return dp[start][end];
    }   
}