package maximum_profitable_triplets_with_increasing_prices_ii_3204;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

class Solution {

    public int maxProfit(int[] prices, int[] profits) {
        int max= Arrays.stream(prices).max().getAsInt();
        SegmentTree pre = new SegmentTree(max);
        SegmentTree suf = new SegmentTree(max);
        var map = new HashMap<Integer, TreeMap<Integer, Integer>>();

        for (int i = 0; i <=max; i++) {
            push(map, i, 0);
        }
        int n = prices.length;
        for (int i = n - 1; i > 0; i--) {
            int p = prices[i];
            int pr = profits[i];
            suf.insert(1, 0, max, p, pr, true);
            push(map, p, pr);
        }
        int ans = -1;
        pre.insert(1, 0, max, prices[0], profits[0], true);
        for (int i = 1; i < n - 1; i++) {
            int p = prices[i];
            int pr = profits[i];
            pop(map, p, pr);
            suf.insert(1, 0, max, p, map.get(p).lastKey(), false);
            int l = pre.query(1, 0, max, 0, p - 1);
            int r = suf.query(1, 0, max, p + 1, max);
            if (l != 0 && r != 0) {
                ans = Math.max(ans, l + r + pr);
            }
            pre.insert(1, 0, max, p, pr, true);
        }

        return ans;

    }

    private void push(Map<Integer, TreeMap<Integer, Integer>> map, int price, int profit){
        map.computeIfAbsent(price, x-> new TreeMap<>()).merge(profit, 1, Integer::sum);
    }
    
    private void pop(Map<Integer, TreeMap<Integer, Integer>> map, int price, int profit){
        map.get(price).merge(profit, -1, Integer::sum);
        if(map.get(price).get(profit) ==0){
            map.get(price).remove(profit);
        }
    }

    class SegmentTree {

        int tree[];
        int max = 0;

        public SegmentTree(int max) {
            this.max = max;
            tree = new int[max * 4];
        }

        public void insert(int treeInd, int l, int r, int pos, int val, boolean isMax) {

            if (l == r) {
                if (isMax) {
                    tree[treeInd] = Math.max(tree[treeInd], val);
                } else {
                    tree[treeInd] = val;
                }
                return;
            }

            int mid = (l + r) / 2;

            if (pos <= mid) {
                insert(2 * treeInd, l, mid, pos, val, isMax);
            } else {
                insert(2 * treeInd + 1, mid + 1, r, pos, val, isMax);
            }

            tree[treeInd] = Math.max(tree[2 * treeInd], tree[2 * treeInd + 1]);
        }

        public int query(int treeInd, int l, int r, int ql, int qr) {

            if (l > r) {
                return 0;
            }

            if (ql > r || qr < l) {
                return 0;
            }

            if (ql <= l && r <= qr) {
                return tree[treeInd];
            }

            int mid = (l + r) / 2;

            return Math.max(
                    query(2 * treeInd, l, mid, ql, qr),
                    query(2 * treeInd + 1, mid + 1, r, ql, qr)
            );
        }
    }
}