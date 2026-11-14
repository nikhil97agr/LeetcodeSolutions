class Solution {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        Integer dp[][] = new Integer[n][n];
        int len = solve(s.toCharArray(), 0, n - 1, dp);

        int left = n - len;

        return left <= k;
    }

    private int solve(char ch[], int start, int end, Integer dp[][]){
    if(start ==end) return 1;
    if(start > end) return 0;

    if(dp[start][end]!=null) return dp[start][end];

    int ans = 0;
    if(ch[start] == ch[end]){
        ans = 2 + solve(ch, start+1, end - 1, dp);
    }

    return dp[start][end] = Math.max(ans, Math.max(solve(ch, start+1, end, dp), solve(ch, start, end-1, dp)));
    }
}
