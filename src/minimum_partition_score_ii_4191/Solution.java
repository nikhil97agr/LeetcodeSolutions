package minimum_partition_score_ii_4191;

import java.util.*;

public class Solution {

    static class Line {
        long m;
        long b;
        int c;

        Line(long m, long b, int c) {
            this.m = m;
            this.b = b;
            this.c = c;
        }
    }

    static class Result {
        long dp;
        int cnt;

        Result(long dp, int cnt) {
            this.dp = dp;
            this.cnt = cnt;
        }
    }

    public long minPartitionScore(int[] nums, int k) {
        int n = nums.length;

        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i] + nums[i];
        }

        long total = pref[n];

        long lo = -total * total;
        long hi = total * total;

        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;

            if (run(pref, n, mid).cnt >= k) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }

        Result res = run(pref, n, lo);

        long ans = res.dp - lo * k;

        return Math.round((ans + total) / 2.0);
    }

    private Result run(long[] pref, int n, long penalty) {

        long[] dp = new long[n + 1];
        int[] cnt = new int[n + 1];

        Deque<Line> hull = new ArrayDeque<>();

        addLine(hull, new Line(0, 0, 1));

        for (int i = 1; i <= n; i++) {

            long x = pref[i];

            while (hull.size() >= 2) {
                Line first = hull.pollFirst();
                Line second = hull.peekFirst();

                if (better(first, second, x)) {
                    hull.addFirst(first);
                    break;
                }
            }

            Line best = hull.peekFirst();

            dp[i] = value(best, x) + x * x + penalty;
            cnt[i] = best.c;

            addLine(hull,
                    new Line(
                            -2L * x,
                            dp[i] + x * x,
                            cnt[i] + 1
                    ));
        }

        return new Result(dp[n], cnt[n]);
    }

    private long value(Line line, long x) {
        return line.m * x + line.b;
    }

    private boolean better(Line a, Line b, long x) {
        long va = value(a, x);
        long vb = value(b, x);

        return va < vb || (va == vb && a.c > b.c);
    }

    private boolean bad(Line a, Line b, Line c) {

        return (double) (b.b - a.b) / (a.m - b.m)
                >= (double) (c.b - b.b) / (b.m - c.m);
    }

    private void addLine(Deque<Line> hull, Line line) {

        while (hull.size() >= 2) {
            Line last = hull.pollLast();
            Line secondLast = hull.peekLast();

            if (bad(secondLast, last, line)) {
                continue;
            }

            hull.addLast(last);
            break;
        }

        hull.addLast(line);
    }
}