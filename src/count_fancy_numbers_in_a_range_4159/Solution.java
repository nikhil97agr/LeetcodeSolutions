package count_fancy_numbers_in_a_range_4159;

import java.util.*;
import java.util.HashSet;
import java.util.Set;

class Solution {

    Set<Integer> set;

    public long countFancy(long l, long r) {

        set = new HashSet<>();
        for (int i = 0; i <= 150; i++) {
            if (good(i)) {
                set.add(i);
            }
        }

        char c1[] = Long.toString(l - 1).toCharArray();
        char c2[] = Long.toString(r).toCharArray();

        long a = solve(c1, 0, c1.length, 1, 0, 0, 0, 0, 0, new Long[c1.length][2][11][2][2][150][2]);
        long b = solve(c2, 0, c2.length, 1, 0, 0, 0, 0, 0, new Long[c2.length][2][11][2][2][150][2]);

        return b - a;
    }

    private long solve(char ch[], int i, int n, int flag, int started, int prev,
                       int inc, int dec, int sum,
                       Long dp[][][][][][][]) {

        if (i == n) {

            if (started == 0) return 0;

            boolean goodNumber = (inc == 0 || dec == 0);
            boolean goodSum = set.contains(sum);

            return (goodNumber || goodSum) ? 1 : 0;
        }

        if (dp[i][flag][prev][inc][dec][sum][started] != null)
            return dp[i][flag][prev][inc][dec][sum][started];

        int limit = (flag == 1) ? ch[i] - '0' : 9;

        long ans = 0;

        for (int d = 0; d <= limit; d++) {

            int nextFlag = (flag == 1 && d == limit) ? 1 : 0;

            if (started == 0 && d == 0) {

                ans += solve(ch, i + 1, n, nextFlag, 0, 0, inc, dec, sum, dp);

            } else {

                if (started == 0) {

                    ans += solve(ch, i + 1, n, nextFlag, 1, d, inc, dec, sum + d, dp);

                } else {

                    int ninc = inc;
                    int ndec = dec;
                    
                    if (d >= prev) ninc = 1;
                    if (d <= prev) ndec = 1;

                    ans += solve(ch, i + 1, n, nextFlag, 1, d, ninc, ndec, sum + d, dp);
                }
            }
        }

        return dp[i][flag][prev][inc][dec][sum][started] = ans;
    }

    private boolean good(int sum) {

        char ch[] = Integer.toString(sum).toCharArray();

        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < ch.length - 1; i++) {

            if (ch[i] >= ch[i + 1]) inc = false;
            if (ch[i] <= ch[i + 1]) dec = false;
        }

        return inc || dec;
    }
}