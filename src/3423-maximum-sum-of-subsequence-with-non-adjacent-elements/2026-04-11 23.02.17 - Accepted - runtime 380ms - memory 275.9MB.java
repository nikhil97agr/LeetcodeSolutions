import java.util.*;

class Solution {

    long mod = 1_000_000_007;

    public int maximumSumSubsequence(int[] nums, int[][] queries) {

        int n = nums.length;
        SegmentTree tree = new SegmentTree(n);

        for (int i = 0; i < n; i++) {
            tree.update(1, 0, n - 1, i, nums[i]);
        }

        long ans = 0;

        for (int[] q : queries) {
            tree.update(1, 0, n - 1, q[0], q[1]);

            Data data= tree.tree[1];

            long best = max(data.firstLast, data.notFirstLast, data.notFirstNotLast, data.firstNotLast);

            ans = (ans + best) % mod;
        }

        return (int) ans;
    }

    private long max(long...arr){
        long ans= Long.MIN_VALUE;
        for(long x : arr){
            ans = Math.max(ans, x);
        }

        return ans;
    }



    class SegmentTree {
        Data[] tree;
        long NEG = (long) -1e18;

        SegmentTree(int n) {
            tree = new Data[4 * n];
            for (int i = 0; i < tree.length; i++) {
                tree[i] = new Data();
            }
        }

        void update(int idx, int l, int r, int pos, int val) {
            if (l == r) {
                tree[idx] = new Data(NEG, 0, NEG, val);
                return;
            }

            int mid = (l + r) / 2;

            if (pos <= mid) update(2 * idx, l, mid, pos, val);
            else update(2 * idx + 1, mid + 1, r, pos, val);
            tree[idx] = new Data();
            tree[idx].merge(tree[2 * idx], tree[2 * idx + 1]);
        }

        
    }

    class Data {
        long firstNotLast;
        long notFirstNotLast;
        long notFirstLast;
        long firstLast;

        Data() {}

        Data(long a, long b, long c, long d) {
            firstNotLast = a;
            notFirstNotLast = b;
            notFirstLast = c;
            firstLast = d;
        }

                public void merge(Data left, Data right) {

            firstNotLast = max(
                    left.firstLast + right.notFirstNotLast,
                    left.firstNotLast + right.firstNotLast,
                    left.firstNotLast + right.notFirstNotLast
            );
            notFirstNotLast = max(
                    left.notFirstLast + right.notFirstNotLast,
                    left.notFirstNotLast + right.firstNotLast,
                    left.notFirstNotLast + right.notFirstNotLast
            );

            notFirstLast = max(
                    left.notFirstLast + right.notFirstLast,
                    left.notFirstNotLast + right.firstLast,
                    left.notFirstNotLast + right.notFirstLast
            );

            firstLast = max(
                    left.firstNotLast + right.notFirstLast,
                    left.firstNotLast + right.firstLast,
                    left.firstLast + right.notFirstLast
            );
        }
    }
}