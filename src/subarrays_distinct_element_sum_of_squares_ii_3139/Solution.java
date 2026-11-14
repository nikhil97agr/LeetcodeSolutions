package subarrays_distinct_element_sum_of_squares_ii_3139;

import java.util.*;
import java.util.HashMap;

class Solution {

    private int mod = 1_000_000_007;

    public int sumCounts(int[] nums) {

        int ans = 0;
        var map = new HashMap<Integer, Integer>();
        var n = nums.length;
        var tree = new SegmentTree(n);
        for (var i = 0; i < n; i++) {
            var prevIndex = -1;
            if (map.containsKey(nums[i])) {
                prevIndex = map.get(nums[i]);
            }

            tree.update(1, 0, n - 1, prevIndex + 1, i, 1);

            Node res = tree.query(1, 0, n - 1, 0, n - 1);

            ans = add(ans, res.squareSum);

            map.put(nums[i], i);
        }

        return ans;
    }

    private int add(long... a) {

        long ans = 0;
        for (long x : a) {
            ans += x;
            ans += mod;
            ans %= mod;
        }

        return (int) ans;
    }

    private int prod(long... a) {

        long prod = 1;
        for (long p : a) {
            prod *= p;
            prod %= mod;
        }

        return (int) prod;
    }

    class SegmentTree {

        Node tree[];

        public SegmentTree(int n) {

            tree = new Node[4 * n];
            build(1, 0, n - 1);
        }

        public void build(int ind, int l, int r) {

            if (r < l) {
                return;
            }
            if (l == r) {
                tree[ind] = new Node(0, 0, 0);
                return;
            }

            int mid = (l + r) >> 1;
            build(ind << 1, l, mid);
            build((ind << 1) | 1, mid + 1, r);

            tree[ind] = merge(tree[ind << 1], tree[(ind << 1) | 1]);
        }

        public void update(int ind, int l, int r, int ql, int qr, int val) {

            pushToChild(ind, l, r);

            if (qr < l || r < ql) {
                return;
            }

            if (ql <= l && r <= qr) {
                tree[ind].lazy = add(tree[ind].lazy, val);
                pushToChild(ind, l, r);
                return;
            }

            int mid = (l + r) >> 1;
            update(ind << 1, l, mid, ql, qr, val);
            update((ind << 1) | 1, mid + 1, r, ql, qr, val);

            tree[ind] = merge(tree[ind << 1], tree[(ind << 1) | 1]);
        }

        private Node query(int ind, int l, int r, int ql, int qr) {

            pushToChild(ind, l, r);

            if (qr < l || r < ql) {
                return null;
            }

            if (ql <= l && r <= qr) {
                return tree[ind];
            }

            int mid = (l + r) >> 1;
            Node left = query(ind << 1, l, mid, ql, qr);
            Node right = query((ind << 1) | 1, mid + 1, r, ql, qr);

            if (left == null && right == null) {
                return null;
            }
            if (left == null) {
                return right;
            }
            if (right == null) {
                return left;
            }
            return merge(left, right);
        }

        private void pushToChild(int ind, int l, int r) {

            Node curr = tree[ind];
            if (curr != null && curr.lazy != 0) {
                curr.squareSum = add(curr.squareSum, prod(2, curr.sum, curr.lazy),
                        prod(curr.lazy, curr.lazy, r - l + 1));
                curr.sum = add(curr.sum, prod(curr.lazy, r - l + 1));

                if (l != r) {
                    tree[ind << 1].lazy = add(tree[ind << 1].lazy, curr.lazy);
                    tree[(ind << 1) | 1].lazy = add(tree[(ind << 1) | 1].lazy, curr.lazy);
                }

                curr.lazy = 0;
            }
        }

        private Node merge(Node a, Node b) {

            return new Node(0, add(a.squareSum, b.squareSum), add(a.sum, b.sum));
        }
    }


    class Node {

        int lazy;
        int squareSum;
        int sum;

        public Node(int lazy, int squareSum, int sum) {

            this.lazy = lazy;
            this.squareSum = squareSum;
            this.sum = sum;
        }
    }
}

