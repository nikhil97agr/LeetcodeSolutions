package longest_common_subsequence_1250;

import java.util.*;
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][]= new int[n][m];
        for(int x[] : dp){
            Arrays.fill(x,-1);
        }
        int answer = solve(text1, text2, n, m, dp,0,0);
        return answer == -1 ? 0:answer;
    }

    private int solve(String s1, String s2, int n, int m, int dp[][], int i, int j){
        if(i>=n || j>=m){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int res = 0;
        if(s1.charAt(i)==s2.charAt(j)){
            res = 1 + solve(s1, s2, n, m, dp, i+1, j+1);
        }

        res = Math.max(res, Math.max(solve(s1,s2,n,m,dp, i+1,j), solve(s1, s2, n, m, dp, i ,j+1)));

        return dp[i][j] = res;
    }

}