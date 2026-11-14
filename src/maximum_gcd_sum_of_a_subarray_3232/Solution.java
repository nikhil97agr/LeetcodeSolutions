package maximum_gcd_sum_of_a_subarray_3232;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public long maxGcdSum(int[] nums, int k) {

        long ans = 0;
        int n = nums.length;

        long pre[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }

        List<int[]> prev = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<int[]> next = new ArrayList<>();
            int len = 1;
            next.add(new int[]{nums[i], i});
            for (int p[] : prev) {
                int g = gcd(p[0], nums[i]);
                if (g == next.get(len - 1)[0]) {
                    next.get(len - 1)[1] = Math.min(next.get(len - 1)[1], p[1]);
                } else {
                    next.add(new int[]{g, p[1]});
                    len++;
                }
            }

            for (int p[] : next) {
                int gcd = p[0];
                int start = p[1];
                int l = i - start + 1;
                if (l < k) {
                    continue;
                }
                long sum = pre[i + 1] - pre[start];
                ans = Math.max(ans, sum * gcd);

            }
            prev = next;
        }

        return ans;
    }

    private int gcd(int a, int b) {

        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
}