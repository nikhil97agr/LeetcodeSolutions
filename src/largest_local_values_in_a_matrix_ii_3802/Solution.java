package largest_local_values_in_a_matrix_ii_3802;

import java.util.*;
import java.util.Arrays;

class Solution {

    public static void main(String[] args) {

        new Solution().countLocalMaximums(new int[][]{{0, 2, 1}, {1, 1, 0}});
    }

    public int countLocalMaximums(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;

        var tree = new SegmentTree[n];

        for (int i = 0; i < n; i++) {
            tree[i] = new SegmentTree(m);
            for (int j = 0; j < m; j++) {
                tree[i].add(1, j, matrix[i][j], 0, m - 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int x = matrix[i][j];
                if (x == 0) {
                    continue;
                }
                int val = check(tree, x, i, j, n, m);
                if (val <= x) {
                    ans++;
                }

            }
        }

        return ans;
    }

    private int check(SegmentTree[] tree, int x, int i, int j, int n, int m) {

        int max = -1;
        int s = i - x;
        int e = i + x;
        for (int start = Math.max(i - x, 0); start <= Math.min(i + x, n - 1); start++) {
            if (start != i && (start == s || start == e)) {
                int c1 = max(j - x, 0);
                int c2 = min(j + x, m - 1);

                if (abs(j - c1) == x) {
                    c1++;
                }
                if (abs(j - c2) == x) {
                    c2--;
                }
                max = max(max, get(tree[start], c1, c2, 0, m - 1));
                continue;

            }
            max = max(
                    max,
                    get(tree[start], max(j - x, 0), min(j + x, m - 1), 0, m - 1)
            );
        }

        return max;
    }

    private int abs(int a) {

        return Math.abs(a);
    }

    private int get(SegmentTree tree, int start, int end, int i, int j) {

        return tree.search(1, start, end, i, j);
    }

    private int min(int a, int b) {

        return Math.min(a, b);
    }

    private int max(int a, int b) {

        return Math.max(a, b);
    }

    class SegmentTree {

        int tree[];

        public SegmentTree(int n) {

            tree = new int[n * 4];
            Arrays.fill(tree, -1);
        }

        public void add(int ind, int i, int val, int l, int r) {

            if (i < l || r < i) {
                return;
            }

            if (l == r) {
                tree[ind] = val;
                return;
            }

            int mid = (l + r) / 2;

            add(2 * ind, i, val, l, mid);
            add(2 * ind + 1, i, val, mid + 1, r);

            tree[ind] = Math.max(tree[ind * 2], tree[2 * ind + 1]);
        }

        public int search(int ind, int ql, int qr, int l, int r) {

            if (ql > qr || qr < l || r < ql) {
                return -1;
            }
            if (ql <= l && r <= qr) {
                return tree[ind];
            }

            int mid = (l + r) / 2;

            return Math.max(search(2 * ind, ql, qr, l, mid), search(2 * ind + 1, ql, qr, mid + 1, r));
        }

    }
}

/*

[0 2 1]
[1 1 0]


*/