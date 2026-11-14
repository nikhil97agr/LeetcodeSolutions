import java.util.Arrays;

class Solution {

    public int[] beautifulPair(int[] nums1, int[] nums2) {

        int i1 = Integer.MAX_VALUE;
        int i2 = Integer.MAX_VALUE;
        int diff = Integer.MAX_VALUE;
        int n = nums1.length;
        int len = n + 1;
        var nodes = new Node[n ];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nums1[i], nums2[i], i);
        }

        SegmentTree smaller = new SegmentTree(n);
        SegmentTree larger = new SegmentTree(n);

        Arrays.sort(nodes, (a, b) -> {
            if (a.second == b.second) {
                return a.first - b.first;
            }

            return a.second - b.second;
        });

        for (var node : nodes) {

            int s1 = node.first + node.second;

            Node query = smaller.query(1, 0, n, 0, node.first);

            if (query.ind != len + 1) {
                int s2 = query.first;
                int d = s1 - s2;
                int min = Math.min(node.ind, query.ind);
                int max = Math.max(query.ind, node.ind);
                if (d < diff) {
                    diff = d;
                    i1 = Math.min(node.ind, query.ind);
                    i2 = Math.max(node.ind, query.ind);
                } else if (d == diff) {
                    if (min < i1) {
                        i1 = min;
                        i2 = max;
                    } else if (min == i1 && max < i2) {
                        i2 = max;
                    }
                }
            }

            smaller.update(1, node.ind, s1, node.first, 0, n);

            s1 = node.second - node.first;
            query = larger.query(1, 0, n, node.first, n);
            if (query.ind != len + 1) {
                int s2 = query.first;
                int d = s1 - s2;
                int min = Math.min(node.ind, query.ind);
                int max = Math.max(query.ind, node.ind);
                if (d < diff) {
                    diff = d;
                    i1 = Math.min(node.ind, query.ind);
                    i2 = Math.max(node.ind, query.ind);
                } else if (d == diff) {
                    if (min < i1) {
                        i1 = min;
                        i2 = max;
                    } else if (min == i1 && max < i2) {
                        i2 = max;
                    }
                }
            }
            larger.update(1, node.ind, s1, node.first, 0, n);
        }

        return new int[]{i1, i2};

    }

    class Node {

        int first;
        int second;
        int ind;

        public Node(int first, int second, int ind) {

            this.first = first;
            this.second = second;
            this.ind = ind;
        }
    }

    class SegmentTree {

        Node tree[];
        int n;

        public SegmentTree(int n) {

            this.n = n;
            tree = new Node[4 * n];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Node(-3 * n, -3 * n, n + 1);
            }

        }

        public Node query(int treeInd, int start, int end, int qs, int qe) {

            if (qs <= start && end <= qe) {
                return tree[treeInd];
            }

            if (qe < start || qs > end) {
                return new Node(-3 * n, -3 * n, n + 1);
            }

            int mid = (start + end) / 2;

            Node left = query(2 * treeInd, start, mid, qs, qe);
            Node right = query(2 * treeInd + 1, mid + 1, end, qs, qe);

            if (left.first > right.first) {
                return left;
            } else if (left.first < right.first) {
                return right;
            } else {
                if (left.ind < right.ind) {
                    return left;
                } else {
                    return right;
                }
            }
        }

        public void update(int treeInd, int index, int val, int ind, int start, int end) {

            if (end < ind || start > ind) {
                return;
            }

            if (start == end) {
                Node node = tree[treeInd];

                if (node.first < val) {
                    node.first = val;
                    node.ind = index;
                } else if (node.first == val && node.ind > index) {
                    node.ind = index;
                }
                return;
            }

            int mid = (start + end) / 2;

            if (ind <= mid) {
                update(2 * treeInd, index, val, ind, start, mid);
            } else {
                update(2 * treeInd + 1, index, val, ind, mid + 1, end);
            }

            Node left = tree[2 * treeInd];
            Node right = tree[2 * treeInd + 1];

            if (left.first > right.first) {
                tree[treeInd] = left;
            } else if (left.first < right.first) {
                tree[treeInd] = right;
            } else {
                if (left.ind < right.ind) {
                    tree[treeInd] = left;
                } else {
                    tree[treeInd] = right;
                }
            }
        }

    }
}