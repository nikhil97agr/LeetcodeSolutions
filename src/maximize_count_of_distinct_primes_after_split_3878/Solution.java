package maximize_count_of_distinct_primes_after_split_3878;

import java.util.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {

    public int[] maximumCount(int[] nums, int[][] queries) {

        var n = nums.length;
        var q = queries.length;
        var ans = new int[q];
        var max = Math.max(Arrays.stream(nums).max().getAsInt(),
                Arrays.stream(queries).mapToInt(x -> x[1]).max().getAsInt());
        var primes = new boolean[max + 1];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;
        for (int i = 2; i <= max; i++) {
            if (primes[i]) {
                for (int j = i << 1; j <= max; j += i) {
                    primes[j] = false;
                }
            }
        }
        var tree = new SegmentTree(n);
        var map = new HashMap<Integer, TreeSet<Integer>>();

        for (int i = 0; i < n; i++) {
            if (!primes[nums[i]]) {
                continue;
            }
            map.computeIfAbsent(nums[i], x -> new TreeSet<>()).add(i);
        }

        for (var entry : map.entrySet()) {
            var set = entry.getValue();

            if (set.size() == 1) {
                tree.update(1, 0, n - 1, 0, n - 1, 1);
                continue;
            }

            var l = set.first();
            var r = set.last();

            update(1, tree, l, r, n);
        }

        for (int i = 0; i < q; i++) {
            var ind = queries[i][0];
            var val = queries[i][1];
            if (primes[nums[ind]]) {
                remove(nums[ind], map, tree, ind, n);
            }
            if (!primes[val]) {
                ans[i] = tree.query(1, 0, n - 1, 0, n - 1);
                nums[ind] = val;

                continue;
            }

            if (map.containsKey(val)) {
                var set = map.get(val);
                update(-1, tree, set.first(), set.last(), n);
            }
            map.computeIfAbsent(val, x -> new TreeSet<>()).add(ind);
            var set = map.get(val);
            update(1, tree, set.first(), set.last(), n);
            ans[i] = tree.query(1, 0, n - 1, 0, n - 1);
            nums[ind] = val;

        }

        return ans;

    }

    private void update(int val, SegmentTree tree, int l, int r, int n) {

        if (l == r) {
            tree.update(1, 0, n - 1, 0, n - 1, val);
            return;
        }

        tree.update(1, 0, n - 1, 0, l - 1, val);
        tree.update(1, 0, n - 1, l, r - 1, 2 * val);
        tree.update(1, 0, n - 1, r, n - 1, val);
    }

    private void remove(int val, Map<Integer, TreeSet<Integer>> map, SegmentTree tree, int ind, int n) {

        var set = map.get(val);
        if (set.size() == 1) {
            tree.update(1, 0, n - 1, 0, n - 1, -1);
            remove(val, map, ind);
            return;
        }

        update(-1, tree, set.first(), set.last(), n);
        set.remove(ind);
        update(1, tree, set.first(), set.last(), n);
    }

    private void remove(int val, Map<Integer, TreeSet<Integer>> map, int ind) {

        map.get(val).remove(ind);
        if (map.get(val).isEmpty()) {
            map.remove(val);
        }
    }

    static class SegmentTree {

        int lazy[];
        int tree[];

        public SegmentTree(int n) {

            lazy = new int[4 * n];
            tree = new int[4 * n];
        }

        public void push(int ind, int l, int r) {

            if (lazy[ind] != 0) {
                tree[ind] += lazy[ind];

                if (l != r) {
                    lazy[2 * ind] += lazy[ind];
                    lazy[2 * ind + 1] += lazy[ind];
                }

                lazy[ind] = 0;
            }
        }

        public void update(int ind, int l, int r, int ql, int qr, int val) {

            push(ind, l, r);

            if (ql > qr || qr < l || r < ql) {
                return;
            }

            if (ql <= l && r <= qr) {
                lazy[ind] += val;
                push(ind, l, r);
                return;
            }
            var mid = (l + r) >> 1;

            update(2 * ind, l, mid, ql, qr, val);
            update(2 * ind + 1, mid + 1, r, ql, qr, val);
            tree[ind] = Math.max(tree[2 * ind], tree[2 * ind + 1]);

        }

        public int query(int ind, int l, int r, int ql, int qr) {

            push(ind, l, r);
            if (ql > qr || qr < l || r < ql) {
                return 0;
            }

            if (ql <= l && r <= qr) {
                return tree[ind];
            }

            int mid = (l + r) >> 1;

            return Math.max(query(2 * ind, l, mid, ql, qr), query(2 * ind + 1, mid + 1, r, ql, qr));
        }
    }
}