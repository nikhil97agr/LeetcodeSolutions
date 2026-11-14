package count_different_palindromic_subsequences_730;

class Solution {

    public int countPalindromicSubsequences(String s) {

        int n = s.length();
        char ch[] = s.toCharArray();
        int dp[][] = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (ch[i] != ch[j]) {
                    dp[i][j] = add(dp[i + 1][j], add(dp[i][j - 1], -dp[i + 1][j - 1]));
                } else {
                    dp[i][j] = prod(dp[i + 1][j - 1], 2);
                    int left = i + 1;
                    int right = j - 1;
                    while (left <= right && ch[left] != ch[i]) {
                        left++;
                    }

                    while(left <= right && ch[right] !=ch[i]){
                        right--;
                    }

                    if(left > right){
                        dp[i][j] = add(dp[i][j], 2);
                    }else if(left == right){
                        dp[i][j]  = add(dp[i][j], 1);
                    }else{
                        dp[i][j] = add(dp[i][j], -dp[left+1][right-1]);
                    }
                }
            }
        }
        
        return dp[0][n-1];
    }

    private int add(long a, long b) {

        long mod = 1_000_000_007;
        return (int) ((a + b + mod) % mod);
    }

    private int prod(long a, long b) {

        long mod = 1_000_000_007;
        return (int) ((a * b) % mod);
    }
}