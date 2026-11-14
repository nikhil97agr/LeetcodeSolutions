package maximum_sum_of_alternating_subsequence_with_distance_at_least_k_4260;

import java.util.*;
import java.util.Arrays;

class Solution {

    public long maxAlternatingSum(int[] nums, int k) {

        int n = nums.length;
        int clone[] = nums.clone();
        Arrays.sort(clone);
        int len = 0;
        for (int i = 0; i < n; i++) {
            if (len == 0 || clone[len - 1] != clone[i]) {
                clone[len++] = clone[i];
            }
        }
        long d[] = new long[n];
        long u[] = new long[n];

        SegmentTree down = new SegmentTree(len);
        SegmentTree up = new SegmentTree(len);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int j = i - k;

            if (j >= 0) {
                int ind = Arrays.binarySearch(clone, 0, len, nums[j]);
                down.add(1, ind, max(d[j], nums[j]), 0, len - 1);
                up.add(1, ind, max(u[j], nums[j]), 0, len - 1);
            }

            int ind = Arrays.binarySearch(clone, 0, len, nums[i]);
            long a = down.query(1, 0, ind - 1, 0, len - 1);
            if (a != -1) {
                u[i] = max(u[i], a + nums[i]);

            }
            long b = up.query(1, ind + 1, len - 1, 0, len - 1);
            if (b != -1) {
                d[i] = max(d[i], b + nums[i]);
            }

            ans = max(ans, d[i], u[i], nums[i]);
        }

        return ans;

    }


    private long max(long... arr) {

        long ans = -1;
        for (long x : arr) {
            ans = Math.max(ans, x);
        }

        return ans;
    }


    class SegmentTree {

        long tree[];

        public SegmentTree(int n) {

            tree = new long[n * 4];
            Arrays.fill(tree, -1);
        }

        public void add(int ind, int i, long val, int l, int r) {

            if (i < l || r < i) {
                return;
            }

            if (l == r) {
                tree[ind] = Math.max(tree[ind], val);
                return;
            }

            int mid = (l + r) / 2;

            add(2 * ind, i, val, l, mid);
            add(2 * ind + 1, i, val, mid + 1, r);

            tree[ind] = Math.max(tree[2 * ind], tree[2 * ind + 1]);
        }

        public long query(int ind, int ql, int qr, int l, int r) {

            if (qr < l || r < ql) {
                return -1;
            }

            if (ql <= l && r <= qr) {
                return tree[ind];
            }

            int mid = (l + r) / 2;

            return Math.max(query(2 * ind, ql, qr, l, mid), query(2 * ind + 1, ql, qr, mid + 1, r));
        }
    }

}