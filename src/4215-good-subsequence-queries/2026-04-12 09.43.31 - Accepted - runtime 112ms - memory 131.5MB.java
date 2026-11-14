class Solution {

    public int countGoodSubseq(int[] nums, int p, int[][] queries) {

        int ans = 0;
        var n = nums.length;
        var tree = new SegmentTree(n);
        var cnt = 0;
        for (int i = 0; i < n; i++) {
            tree.insert(1, i, nums[i], 0, n - 1, p);
            if (nums[i] % p == 0) {
                cnt++;
            }
        }

        for (var q : queries) {
            var ind = q[0];
            var val = q[1];
            tree.insert(1, ind, val, 0, n - 1, p);
            if (val % p == 0) {
                cnt++;
            }
            if (nums[ind] % p == 0) {
                cnt--;
            }
            nums[ind] = val;
            if (tree.tree[1] == p) {
                if (cnt < n) {
                    ans++;
                    continue;
                }
                if (n > 10) {
                    ans++;
                    continue;
                }

                boolean res = false;
                for (int i = 0; i < n; i++) {
                    if (nums[i] % p == 0) {
                        tree.insert(1, i, 0, 0, n - 1, p);
                        if (tree.tree[1] == p) {
                            res = true;
                            tree.insert(1, i, nums[i], 0, n - 1, p);
                            break;
                        }

                        tree.insert(1, i, nums[i], 0, n - 1, p);


                    }

                }
                if (res) {
                    ans++;
                }
            }


        }

        return ans;
    }

    class SegmentTree {

        int tree[];

        public SegmentTree(int n) {

            tree = new int[n * 4];
        }

        public void insert(int ind, int i, int val, int l, int r, int p) {

            if (i < l || r < i) {
                return;
            }

            if (l == r) {
                if (val % p == 0) {
                    tree[ind] = val;
                } else {
                    tree[ind] = 0;
                }

                return;
            }

            int mid = (l + r) >> 1;
            insert(2 * ind, i, val, l, mid, p);
            insert(2 * ind + 1, i, val, mid + 1, r, p);

            tree[ind] = gcd(tree[2 * ind], tree[2 * ind + 1]);
        }

        private int gcd(int a, int b) {

            if (a == 0) {
                return b;
            }

            return gcd(b % a, a);
        }

    }

}