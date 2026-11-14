package maximum_total_subarray_value_ii_4007;

import java.util.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

class Solution {

    public long maxTotalValue(int[] nums, int k) {

        long ans = 0;
        var que = new PriorityQueue<Node>((a, b) -> Long.compare(b.diff, a.diff));
        var n = nums.length;
        var tree = new SegmentTree(nums);
        que.offer(new Node(0, n - 1, 0));
        var vis = new HashSet<String>();

        vis.add(key(0, n - 1));
        while (!que.isEmpty() && k-- > 0) {
            var next = que.poll();

            var start = next.start;
            var end = next.end;

            long min = tree.min(1, start, end, 0, n - 1);
            long max = tree.max(1, start, end, 0, n - 1);

            ans += Math.abs(min - max);

            if (start + 1 <= end) {
                var key = key(start + 1, end);
                if (!vis.contains(key)) {
                    min = tree.min(1, start + 1, end, 0, n - 1);
                    max = tree.max(1, start + 1, end, 0, n - 1);
                    que.offer(new Node(start + 1, end, Math.abs(min - max)));
                    vis.add(key);
                }
            }

            if (start <= end - 1) {
                var key = key(start, end - 1);
                if (!vis.contains(key)) {
                    min = tree.min(1, start, end - 1, 0, n - 1);
                    max = tree.max(1, start, end - 1, 0, n - 1);
                    que.offer(new Node(start, end - 1, Math.abs(min - max)));
                    vis.add(key);
                }
            }


        }
        return ans;


    }

    private String key(int start, int end) {

        return String.format("%d:%d", start, end);
    }

    class SegmentTree {

        int min[];
        int max[];

        public SegmentTree(int nums[]) {

            int n = nums.length;
            min = new int[n * 4];
            max = new int[n * 4];

            Arrays.fill(min, Integer.MAX_VALUE);
            Arrays.fill(max, -1);

            for (int i = 0; i < n; i++) {
                insert(1,i, nums[i], 0, n - 1);
            }
        }

        public int min(int treeInd, int ql, int qr, int l, int r) {

            if (ql > qr || qr < l || r < ql) {
                return Integer.MAX_VALUE;
            }

            if (ql <= l && r <= qr) {
                return min[treeInd];
            }

            int mid = (l + r) / 2;

            return Math.min(min(2 * treeInd, ql, qr, l, mid), min(2 * treeInd + 1, ql, qr, mid + 1, r));
        }

        public int max(int treeInd, int ql, int qr, int l, int r) {

            if (ql > qr || qr < l || r < ql) {
                return -1;
            }

            if (ql <= l && r <= qr) {
                return max[treeInd];
            }

            int mid = (l + r) / 2;

            return Math.max(max(2 * treeInd, ql, qr, l, mid), max(2 * treeInd + 1, ql, qr, mid + 1, r));
        }

        private void insert(int treeInd,int i, int val, int start, int end) {

            if (i < start || i > end) {
                return;
            }

            if (start == end) {
                min[treeInd] = max[treeInd] = val;
                return;
            }

            int mid = (start + end) / 2;

            insert(2 * treeInd,i, val, start, mid);
            insert(2 * treeInd + 1,i, val, mid + 1, end);

            min[treeInd] = Math.min(min[2 * treeInd], min[2 * treeInd + 1]);
            max[treeInd] = Math.max(max[2 * treeInd], max[2 * treeInd + 1]);
        }
    }

    class Node {

        int start;
        int end;
        long diff;

        public Node(int start, int end, long diff) {

            this.start = start;
            this.end = end;
            this.diff = diff;
        }
    }
}