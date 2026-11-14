import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public String minInteger(String num, int k) {

        int n = num.length();
        StringBuilder ans = new StringBuilder();
        var que = new ArrayList<Queue<Integer>>();
        for (int i = 0; i <= 9; i++) {
            que.add(new LinkedList<>());
        }

        for (int i = 0; i < n; i++) {
            int dig = num.charAt(i) - '0';
            que.get(dig).add(i);
        }
        SegmentTree tree = new SegmentTree(n);

        for (int i = 0; i < n; i++) {
            for (int dig = 0; dig <= 9; dig++) {
                if (que.get(dig).isEmpty()) {
                    continue;
                }

                int index = que.get(dig).peek();
                int cnt = tree.query(0, index, 0, n - 1, 1);

                int left = index - cnt;
                if (left <= k) {
                    k -= left;
                    tree.add(index, 0, n - 1, 1);
                    ans.append(dig);
                    que.get(dig).poll();
                    break;
                }
            }
        }

        return ans.toString();
    }

    private class SegmentTree {

        int tree[];

        public SegmentTree(int n) {

            tree = new int[n * 4];

        }

        public void add(int val, int start, int end, int treeIndex) {

            if (val < start || val > end) {
                return;
            }

            if (start == end) {
                tree[treeIndex] = 1;
                return;
            }
            int mid = (start + end) >> 1;
            add(val, start, mid, 2 * treeIndex);
            add(val, mid + 1, end, 2 * treeIndex + 1);
            tree[treeIndex] = tree[2 * treeIndex] + tree[2 * treeIndex + 1];
        }

        public int query(int ql, int qr, int l, int r, int treeInd) {

            if (qr < l || r < ql) {
                return 0;
            }

            if (ql <= l && r <= qr) {
                return tree[treeInd];
            }

            int mid = (l + r) >> 1;

            return query(ql, qr, l, mid, 2 * treeInd) + query(ql, qr, mid + 1, r, 2 * treeInd + 1);
        }
    }
}