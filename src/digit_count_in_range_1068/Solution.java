package digit_count_in_range_1068;

class Solution {
    public int digitsCount(int d, int low, int high) {

        int a = solve(Integer.toString(high).toCharArray(), 0, 0, 1, 0, d, new Integer[10][2][10][2]);
        int b = solve(Integer.toString(low - 1).toCharArray(), 0, 0, 1, 0, d, new Integer[10][2][10][2]);
        return a - b;
    }

    private int solve(char ch[], int found, int i, int tight, int cnt, int d, Integer dp[][][][]) {
        if (i == ch.length) {
            return cnt;
        }
        if (dp[i][tight][cnt][found] != null)
            return dp[i][tight][cnt][found];
        int ans = 0;
        if (tight == 0) {
            for (int dig = 0; dig <= 9; dig++) {
                if (d == 0) {
                    if (dig == 0) {
                        if (found == 1) {
                            ans += solve(ch, found, i + 1, tight, cnt + 1, d, dp);
                        } else {
                            ans += solve(ch, found, i + 1, tight, cnt, d, dp);
                        }
                        continue;
                    }
                }
                ans += solve(ch, 1, i + 1, tight, cnt + (dig == d ? 1 : 0), d, dp);
            }
        } else {
            int lim = ch[i] - '0';
            for (int dig = 0; dig < lim; dig++) {
                if (d == 0) {
                    if (dig == 0) {
                        if (found == 1) {
                            ans += solve(ch, found, i + 1, 0, cnt + 1, d, dp);
                        } else {
                            ans += solve(ch, found, i + 1, 0, cnt, d, dp);
                        }
                        continue;
                    }
                }
                ans += solve(ch, 1, i + 1, 0, cnt + (dig == d ? 1 : 0), d, dp);
            }

            if (d == 0) {
                if (lim == 0) {
                    if (found == 1) {
                        ans += solve(ch, found, i + 1, 1, cnt + 1, d, dp);
                    } else {
                        ans += solve(ch, found, i + 1, 1, cnt, d, dp);
                    }

                } else {
                    ans += solve(ch, 1, i + 1, tight, cnt + (lim == d ? 1 : 0), d, dp);

                }
            } else {
                ans += solve(ch, 1, i + 1, tight, cnt + (lim == d ? 1 : 0), d, dp);

            }

        }

        return dp[i][tight][cnt][found] = ans;
    }
}