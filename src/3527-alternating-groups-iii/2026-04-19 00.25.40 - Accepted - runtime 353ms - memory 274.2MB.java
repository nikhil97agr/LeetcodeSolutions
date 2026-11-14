import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

class Solution {

    public List<Integer> numberOfAlternatingGroups(int[] colors, int[][] queries) {

        var n = colors.length;
        var result = new ArrayList<Integer>();

        var map = new TreeMap<Integer, Integer>();
        var tree = new SegmentTree(n + 1);
        for (int i = 0; i < n; i++) {
            int r = i + 1;
            while (r < n && colors[r] != colors[r - 1]) {
                r++;
            }
            map.put(i, r - 1);
            var len = r - i;
            i = r - 1;
            update(tree, len, n);
        }

        for (var q : queries) {
            if (q[0] == 1) {
                result.add(compute(tree, q[1], n, map, colors));
            } else {
                update(tree, q[1], q[2], colors, map, n);
            }
        }

        return result;
    }

    private void update(SegmentTree tree, int ind, int val, int[] colors, TreeMap<Integer, Integer> map, int n) {

        if (colors[ind] == val) {
            return;
        }

        colors[ind] = val;

        if (ind < n - 1) {
            if (val == colors[ind + 1]) {
                var start = map.floorKey(ind);
                var end = map.get(start);
                update(tree, -(end - start + 1), n);

                map.put(start, ind);
                update(tree, ind - start + 1, n);

                map.put(ind + 1, end);
                update(tree, end - ind, n);
            } else {
                var start1 = ind + 1;
                var end1 = map.get(start1);
                update(tree, -(end1 - start1 + 1), n);

                map.remove(start1);
                var start2 = map.floorKey(ind);
                var end2 = map.get(start2);
                map.remove(start2);
                update(tree, -(end2 - start2 + 1), n);
                map.put(start2, end1);
                update(tree, end1 - start2 + 1, n);

            }
        }

        if (ind > 0) {
            if (val == colors[ind - 1]) {
                var start = map.floorKey(ind);
                var end = map.get(start);
                update(tree, -(end - start + 1), n);
                map.put(start, ind - 1);
                update(tree, ind - start, n);

                map.put(ind, end);
                update(tree, end - ind + 1, n);
            } else {
                var start = map.floorKey(ind - 1);
                update(tree, -(ind - start), n);
                var end2 = map.get(ind);
                update(tree, -(end2 - ind + 1), n);
                map.remove(ind);
                map.put(start, end2);
                update(tree, end2 - start + 1, n);

            }
        }


    }

    private int compute(SegmentTree tree, int size, int n, TreeMap<Integer, Integer> map, int colors[]) {

        var node = tree.query(1, size, n, 0, n);
        int ans = node.sum - (node.cnt * (size - 1));

        if (colors[0] != colors[n - 1]) {
            var first = map.firstEntry();
            var last = map.lastEntry();

            var l1 = last.getValue() - last.getKey() + 1;
            var l2 = first.getValue() - first.getKey() + 1;
            ans = ans + Math.max(0, l1 + l2 - size + 1) - Math.max(0, l1 - size + 1) - Math.max(0, l2 - size + 1);
        }

        return ans;
    }

    public void update(SegmentTree tree, int len, int n) {

        tree.add(1, Math.abs(len), len, 0, n);
    }

    class SegmentTree {

        Node tree[];

        public SegmentTree(int n) {

            tree = new Node[n * 4];
        }

        public void add(int ind, int i, int val, int l, int r) {

            if (i < l || r < i) {
                if (tree[ind] == null) {
                    tree[ind] = new Node(0, 0);
                }

                return;
            }

            if (l == r) {
                if (tree[ind] == null) {
                    tree[ind] = new Node(0, 0);
                }

                tree[ind].sum += val;
                tree[ind].cnt += val / i;
                return;
            }

            var mid = (l + r) >> 1;
            add(2 * ind, i, val, l, mid);
            add(2 * ind + 1, i, val, mid + 1, r);
            tree[ind] = tree[ind * 2].merge(tree[ind * 2 + 1]);
        }

        public Node query(int ind, int ql, int qr, int l, int r) {

            if (qr < l || r < ql) {
                return new Node(0, 0);
            }

            if (ql <= l && r <= qr) {
                return tree[ind];
            }

            var mid = (l + r) >> 1;
            var left = query(2 * ind, ql, qr, l, mid);
            var right = query(2 * ind + 1, ql, qr, mid + 1, r);

            if (left == null) {
                left = new Node(0, 0);
            }
            if (right == null) {
                right = new Node(0, 0);
            }

            return left.merge(right);
        }
    }

    class Node {

        int sum;
        int cnt;

        public Node(int sum, int cnt) {

            this.sum = sum;
            this.cnt = cnt;
        }

        public Node merge(Node node) {

            return new Node(sum + node.sum, cnt + node.cnt);
        }
    }

}