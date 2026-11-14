class Solution {
    public int interleaveCharacters(String word1, String word2, String target) {
        int l1 = word1.length();
        int l2 = word2.length();
        int l3 = target.length();

        int[][][][] dp = new int[l3 + 1][l1 + 1][l2 + 1][4];
        int[][][][] sum1 = new int[l3 + 1][l1 + 1][l2 + 1][4];
        int[][][][] sum2 = new int[l3 + 1][l1 + 1][l2 + 1][4];

        for (int j = 0; j <= l1; j++) {
            for (int k = 0; k <= l2; k++) {
                dp[l3][j][k][3] = 1;
            }
        }

        for (int i = l3 - 1; i >= 0; i--) {
            char t = target.charAt(i);

            for (int j = l1; j >= 0; j--) {
                for (int k = l2; k >= 0; k--) {
                    for (int mask = 0; mask < 4; mask++) {
                        
                        if (j < l1) {
                            sum1[i][j][k][mask] = sum1[i][j + 1][k][mask];
                            if (word1.charAt(j) == t) {
                                sum1[i][j][k][mask] = add(sum1[i][j][k][mask], dp[i + 1][j + 1][k][mask | 1]);
                            }
                        }

                        if (k < l2) {
                            sum2[i][j][k][mask] = sum2[i][j][k + 1][mask];
                            if (word2.charAt(k) == t) {
                                sum2[i][j][k][mask] = add(sum2[i][j][k][mask], dp[i + 1][j][k + 1][mask | 2]);
                            }
                        }

                        dp[i][j][k][mask] = add(sum1[i][j][k][mask], sum2[i][j][k][mask]);
                    }
                }
            }
        }

        return dp[0][0][0][0];
    }

    private int add(int a, int b) {
        long mod = 1_000_000_007L;
        long sum = a + b + mod;
        return (int) (sum % mod);
    }
}