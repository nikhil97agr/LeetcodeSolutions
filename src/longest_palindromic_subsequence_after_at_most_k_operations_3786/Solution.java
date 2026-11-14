package longest_palindromic_subsequence_after_at_most_k_operations_3786;

class Solution {
    public int longestPalindromicSubsequence(String s, int k) {
        int n = s.length();
        Integer dp[][][] = new Integer[n][n][k + 1];
        return solve(s.toCharArray(), k, 0, s.length() - 1, dp);
    }

    private int solve(char ch[], int k, int i, int j, Integer dp[][][]) {
        if (i == j)
            return 1;
        if (i > j)
            return 0;
        if (dp[i][j][k] != null) {
            return dp[i][j][k];
        }
        int ans = 0;
        int dist = getDist(ch[i], ch[j]);
        if(dist <= k){
            ans = 2 + solve(ch, k-dist, i+1, j-1, dp);
        }
        
        ans = Math.max(ans, Math.max(solve(ch, k, i+1, j, dp), solve(ch, k, i, j-1, dp)));
        
        return dp[i][j][k] = ans;

    }
    
    private int getDist(char a, char b){
        int start = 'a';
        int end = 'z';
        int x = a;
        int y = b;
        
        if(x > y){
            return getDist(b, a);
        }
        
        int dist1 = (y-x);
        int dist2 = x-start  + (end-y)+1;
        return Math.min(dist1, dist2);
    }
}