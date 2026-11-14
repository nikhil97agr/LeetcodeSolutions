package find_x_value_of_array_ii_3840;

class Solution {

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        var n = nums.length;
        var q = queries.length;
        var res = new int[q];
        var tree = new SegmentTree(n, k);

        for (var i = 0; i < n; i++) {
            tree.add(1, i, nums[i], 0, n - 1);
        }

        for (var i = 0; i < q; i++) {
            var ind = queries[i][0];
            var val = queries[i][1];
            var start = queries[i][2];
            var x = queries[i][3];
            
            
            tree.add(1, ind, val, 0, n-1);
            
            var node = tree.query(1, start, n-1, 0, n-1);
            res[i] = node.rem[x];
        }

        return res;
    }


    class SegmentTree {

        Node tree[];
        int k;

        public SegmentTree(int n, int k) {

            this.k = k;
            tree = new Node[4 * n];
            for (int i = 0; i < 4 * n; i++) {
                tree[i] = new Node(1, k);
            }
        }

        public Node query(int ind, int ql, int qr, int l, int r) {

            if (qr < l || r < ql) {
                return new Node(1, k);
            }

            if (ql <= l && r <= qr) {
                return tree[ind];
            }

            int mid = (l + r) / 2;

            Node left = query(2 * ind, ql, qr, l, mid);
            Node right = query(2 * ind + 1, ql, qr, mid + 1, r);

            return merge(left, right);
        }

        public void add(int ind, int i, int val, int l, int r) {

            if (i < l || r < i) {
                return;
            }

            if (l == r) {
                tree[ind] = new Node(val, k);
                tree[ind].rem[val % k] = 1;
                return;
            }

            int mid = (l + r) / 2;

            add(2 * ind, i, val, l, mid);
            add(2 * ind + 1, i, val, mid + 1, r);

            tree[ind] = merge(tree[2 * ind], tree[2 * ind + 1]);

        }

        private Node merge(Node left, Node right) {

            Node node = new Node(left.prod * right.prod, k);

            for (int i = 0; i < k; i++) {
                node.rem[i] = left.rem[i];
            }

            for (int i = 0; i < k; i++) {
                int newRem = (i * left.prod) % k;
                node.rem[newRem] += right.rem[i];
            }

            return node;
        }
    }

    class Node {

        int prod;
        int rem[];

        public Node(int val, int k) {

            rem = new int[k];
            prod = val % k;

        }
    }
}
