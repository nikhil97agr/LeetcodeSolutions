package maximum_product_of_the_length_of_two_palindromic_subsequences_2130;

class Solution {
    public int maxProduct(String s) {
        return solve(0, 0, s, s.length());
    }

    private int solve(int i, int bit, String s, int n) {
        if (i == n) {
            if (bit == 0 || Integer.bitCount(bit) == n)
                return 0;
            int a = s1(s.toCharArray(), bit, 0, n - 1, new Integer[n][n]);
            int b = s2(s.toCharArray(), bit, 0, n - 1, new Integer[n][n]);

            return a * b;
        }

        return Math.max(solve(i + 1, bit, s, n), solve(i + 1, bit | (1 << i), s, n));
    }

    private int s1(char ch[], int bit, int start, int end, Integer dp[][]) {
        if (start == end) {
            if ((bit & (1 << start)) != 0) {
                return 1;
            }
            return 0;
        }

        if(start > end) return 0;
        if(dp[start][end] !=null) return dp[start][end];
        int ans = 0;
        if ((bit & (1 << start)) == 0) {
            ans = s1(ch, bit, start + 1, end, dp);
        } else if ((bit & (1 << end)) == 0) {
            ans = Math.max(ans, s1(ch, bit, start, end - 1, dp));
        } else {
            if (ch[start] == ch[end]) {
                ans = Math.max(ans, 2 + s1(ch, bit, start + 1, end - 1, dp));
            }

            ans = Math.max(ans, Math.max(s1(ch, bit, start + 1, end, dp), s1(ch, bit, start, end - 1, dp)));
        }

        return dp[start][end] = ans;
    }

    private int s2(char ch[], int bit, int start, int end, Integer dp[][]) {
        if (start == end) {
            if ((bit & (1 << start)) == 0) {
                return 1;
            }
            return 0;
        }
        if(start > end) return 0;

        if(dp[start][end] !=null) return dp[start][end];
        int ans = 0;
        if ((bit & (1 << start)) != 0) {
            ans = s2(ch, bit, start + 1, end, dp);
        } else if ((bit & (1 << end)) != 0) {
            ans = Math.max(ans, s2(ch, bit, start, end - 1, dp));
        } else {
            if (ch[start] == ch[end]) {
                ans = Math.max(ans, 2 + s2(ch, bit, start + 1, end - 1, dp));
            }

            ans = Math.max(ans, Math.max(s2(ch, bit, start + 1, end, dp), s2(ch, bit, start, end - 1, dp)));
        }

        return dp[start][end] = ans;
    }
}