package longest_palindromic_subsequence_ii_1822;

class Solution {
    public int longestPalindromeSubseq(String s) {
        Integer dp[][][] = new Integer[s.length()][s.length()][27];
        return solve(s, 0, s.length()-1, 26, dp);
    }

    private int solve(String s, int i, int j, int prev, Integer dp[][][]){
        if(i>=j) return 0;

        if(dp[i][j][prev]!=null) return dp[i][j][prev];
        if(s.charAt(i)-'a' == prev) return dp[i][j][prev]=solve(s, i+1, j, prev, dp);

        if(s.charAt(j)-'a' == prev) return dp[i][j][prev]=solve(s, i, j-1, prev, dp);

        if(s.charAt(i)==s.charAt(j)) return dp[i][j][prev]=solve(s, i+1, j-1, s.charAt(i)-'a', dp) + 2;

        return dp[i][j][prev]=Math.max(solve(s, i+1, j, prev, dp), solve(s, i, j-1, prev, dp));
    }
}