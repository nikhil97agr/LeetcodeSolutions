package maximum_sum_of_m_non_overlapping_subarrays_i_4123;

import java.util.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {

    public long maximumSum(int[] nums, int m, int l, int r) {

        long neg = Long.MIN_VALUE / 4;
        long ans = -1_000_000_000_000_000L;
        var n = nums.length;
        long pre[] = new long[n + 1];
        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1] + nums[i-1];
        }

        long prev[] = new long[n + 1];

        for (int k = 1; k <= m; k++) {
            long next[] = new long[n + 1];
            Arrays.fill(next, neg);

            Deque<Integer> que = new ArrayDeque<>();

            for (int i = 1; i <= n; i++) {
                next[i] = next[i - 1];

                int ind = i - l;
                if (ind >= 0) {
                    long value = prev[ind] - pre[ind];

                    while (!que.isEmpty()) {
                        int last = que.peekLast();
                        long val = prev[last] - pre[last];

                        if (val <= value) {
                            que.pollLast();
                        } else {
                            break;
                        }
                    }
                    que.offerLast(ind);
                }

                int range = i - r;
                while (!que.isEmpty() && que.peekFirst() < range) {
                    que.pollFirst();
                }

                if (!que.isEmpty()) {
                    int t = que.peekFirst();

                    next[i] = Math.max(
                            next[i],
                            pre[i] + (prev[t] - pre[t])
                    );
                }
            }

            ans = Math.max(ans, next[n]);

            prev = next;
        }

        return ans;
    }
}