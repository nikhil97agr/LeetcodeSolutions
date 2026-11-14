import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    private int mod = 1_000_000_007;

    public int totalBeauty(int[] nums) {

        var ans = 0;
        var n = nums.length;
        var max = Arrays.stream(nums).max().getAsInt();

        List<Integer> gcds[] = new ArrayList[max + 1];
        for (int i = 0; i <= max; i++) {
            gcds[i] = new ArrayList<>();
        }

        for (int x : nums) {
            for (int d = 1; d * d <= x; d++) {
                if (x % d == 0) {
                    gcds[d].add(x);
                    if (x / d != d) {
                        gcds[x / d].add(x);
                    }
                }
            }
        }
        var dp = new int[max + 1];
        for (var gcd = max; gcd >= 1; gcd--) {
            var list = gcds[gcd];
            var sorted = new ArrayList<>(list);
            Collections.sort(sorted);
            var size = list.size();
            var tree = new SegmentTree(list.size());
            for (int i = 0; i < list.size(); i++) {
                int val = list.get(i);
                int ind = search(sorted, val);

                int total = add(1, tree.query(1, 0, ind - 1, 0, size - 1));
                dp[gcd] = add(dp[gcd], total);
                tree.insert(1, ind, total, 0, size - 1);
            }

            for (var g = gcd * 2; g <= max; g += gcd) {
                dp[gcd] = add(dp[gcd], -dp[g]);
            }

            ans = add(ans, prod(gcd, dp[gcd]));
        }

        return ans;
    }

    private int search(List<Integer> list, int val) {

        int start = 0;
        int end = list.size() - 1;
        while (start < end) {
            int mid = (start + end) >> 1;

            if (list.get(mid) < val) {
                start = mid + 1;
            } else {
                
                end = mid;
            }
        }

        return end;
    }

    private int add(long a, long b) {

        return (int) ((a + b + mod) % mod);
    }

    private int prod(long a, long b) {

        return (int) ((a * b) % mod);
    }

    class SegmentTree {

        int tree[];

        public SegmentTree(int n) {

            tree = new int[4 * n];
        }

        public void insert(int ind, int i, int val, int l, int r) {

            if (i < l || r < i) {
                return;
            }

            if (l == r) {
                tree[ind] = add(tree[ind], val);
                return;
            }

            int mid = (l + r) >> 1;

            insert(2 * ind, i, val, l, mid);
            insert(2 * ind + 1, i, val, mid + 1, r);

            tree[ind] = add(tree[2 * ind + 1], tree[2 * ind]);
        }

        public int query(int ind, int ql, int qr, int l, int r) {

            if (ql > qr || qr < l || r < ql) {
                return 0;
            }

            if (ql <= l && r <= qr) {
                return tree[ind];
            }

            int mid = (l + r) >> 1;
            return add(query(2 * ind, ql, qr, l, mid), query(2 * ind + 1, ql, qr, mid + 1, r));
        }
    }
}