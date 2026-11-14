class Solution {
    public int numberOfBeautifulIntegers(int low, int high, int k) {
        char ch1[] = Integer.toString(low - 1).toCharArray();
        char ch2[] = Integer.toString(high).toCharArray();
        int n = ch1.length;
        int m = ch2.length;
        int a = 1;
        if (low != 1)
            a = solve(ch1, 0, 0, 0, k, 0, 1, 0, new Integer[n][n][k][n][2][2]);
        int b = solve(ch2, 0, 0, 0, k, 0, 1, 0, new Integer[m][m][k][m][2][2]);
        return b - a;
    }

    private int solve(char num[], int even, int odd, int sum, int k, int i, int flag1, int flag2,
            Integer dp[][][][][][]) {
        if (i == num.length) {
            if (even == odd && sum == 0)
                return 1;
            return 0;
        }

        if (dp[even][odd][sum][i][flag1][flag2] != null) {
            return dp[even][odd][sum][i][flag1][flag2];
        }
        if (flag1 == 0) {
            int ans = 0;
            for (int dig = 0; dig <= 9; dig++) {
                if (dig == 0) {
                    if (flag2 == 0) {
                        ans += solve(num, even, odd, sum, k, i + 1, flag1, flag2, dp);
                    } else {
                        int nSum = (sum * 10 + dig) % k;
                        ans += solve(num, even + 1, odd, nSum, k, i + 1, flag1, flag2, dp);
                    }
                } else {
                    boolean e = dig % 2 == 0;
                    int nSum = (sum * 10 + dig) % k;
                    ans += solve(num, e ? even + 1 : even, !e ? odd + 1 : odd, nSum, k, i + 1, flag1, 1, dp);
                }
            }

            return dp[even][odd][sum][i][flag1][flag2] = ans;
        } else {
            int d = num[i] - '0';
            int ans = 0;
            for (int dig = 0; dig < d; dig++) {
                if (dig == 0) {
                    if (flag2 == 0) {
                        ans += solve(num, even, odd, sum, k, i + 1, 0, flag2, dp);
                    } else {
                        int nSum = (sum * 10 + dig) % k;
                        ans += solve(num, even + 1, odd, nSum, k, i + 1, 0, flag2, dp);
                    }
                } else {
                    boolean e = dig % 2 == 0;
                    int nSum = (sum * 10 + dig) % k;
                    ans += solve(num, e ? even + 1 : even, !e ? odd + 1 : odd, nSum, k, i + 1, 0, 1, dp);
                }
            }

            boolean e = d % 2 == 0;
            int nSum = (sum * 10 + d) % k;
            ans += solve(num, e ? even + 1 : even, !e ? odd + 1 : odd, nSum, k, i + 1, 1, 1, dp);
            return dp[even][odd][sum][i][flag1][flag2] = ans;
        }
    }
}