package minimum_inversion_count_in_subarrays_of_fixed_length_4145;

import java.util.*;
import java.util.Arrays;
import java.util.HashMap;

class Solution {

    public long minInversionCount(int[] nums, int k) {

        int n = nums.length;
        var tree = new SegmentTree(n);

        var compressed = new HashMap<Integer, Integer>();
        int ind = 0;
        int clone[] = nums.clone();
        Arrays.sort(clone);
        for (int x : clone) {
            if (!compressed.containsKey(x)) {
                compressed.put(x, ind++);
            }

        }

        long ans = Long.MAX_VALUE;
        long cnt = 0;
        for (int start = 0, end = 0; end < n; end++) {
            int val = compressed.get(nums[end]);
            cnt += tree.search(1, val + 1, n - 1, 0, n - 1);

            tree.add(1, val, 1, 0, n - 1);

            if (end >= k - 1) {
                ans = Math.min(ans, cnt);

                val = compressed.get(nums[start]);
                tree.add(1, val, -1, 0, n - 1);
                cnt -= tree.search(1, 0, val - 1, 0, n - 1);
                start++;
            }
        }
        
        return ans;
    }

    class SegmentTree {

        int tree[];

        public SegmentTree(int n) {

            tree = new int[n * 4];

        }

        public void add(int treeInd, int ind, int val, int start, int end) {

            if (ind < start || ind > end) {
                return;
            }
            if (start == end) {
                tree[treeInd] += val;
                return;
            }

            int mid = (start + end) / 2;

            add(2 * treeInd, ind, val, start, mid);
            add(2 * treeInd + 1, ind, val, mid + 1, end);

            tree[treeInd] = tree[2 * treeInd] + tree[2 * treeInd + 1];
        }

        public int search(int treeInd, int qs, int qe, int s, int e) {

            if (qe < s || qs > e) {
                return 0;
            }

            if (qs <= s && e <= qe) {
                return tree[treeInd];
            }

            int mid = (s + e) / 2;

            return search(2 * treeInd, qs, qe, s, mid) + search(2 * treeInd + 1, qs, qe, mid + 1, e);
        }
    }
}