class Solution {
    public int minOperations(String s1, String s2) {
        int n = s1.length();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        int[][] dp = new int[n + 1][2];
        int max = 1_000_000_000;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = dp[i][1] = max;
        }

        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            int curr = c1[i] - '0';
            int target = c2[i] - '0';

            for (int j = 0; j <= 1; j++) {
                if (dp[i][j] == max) continue;

                for (int nextJ = 0; nextJ <= 1; nextJ++) {
                    if (i == n - 1 && nextJ > 0) continue;

                    int requiredOnes = target + j + nextJ;
                    
                    if (requiredOnes >= curr) {
                        int k = requiredOnes - curr;
                        int cost = k + nextJ;

                        dp[i + 1][nextJ] = Math.min(dp[i + 1][nextJ], dp[i][j] + cost);
                    }
                }
            }
        }

        if (dp[n][0] == max) return -1;
        return dp[n][0];
    }
}