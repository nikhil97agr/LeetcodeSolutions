package maximum_score_of_non_overlapping_intervals_3562;

import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

class Solution {

    Result dp[][];
    Node node[];

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();
        dp = new Result[n][5];
        node = new Node[n];
        for (int i = 0; i < n; i++) {
            var curr = intervals.get(i);
            node[i] = new Node(curr.get(0), curr.get(1), curr.get(2), i);
        }

        Arrays.sort(node, (a, b) -> {
            if (a.l == b.l) {
                return a.r - b.r;
            }

            return a.l - b.l;
        });

        Result result = solve(0, 4);

        int ans[] = new int[result.indices.size()];
        int ind = 0;
        for (int x : result.indices) {
            ans[ind++] = x;
        }

        return ans;
    }

    private Result solve(int i, int cnt) {

        if (cnt == 0) {
            return new Result(0, new TreeSet<>());
        }

        if (i == node.length) {
            return new Result(0, new TreeSet<>());
        }

        if (dp[i][cnt] != null) {
            return new Result(dp[i][cnt]);
        }

        Result skip = solve(i + 1, cnt);

        int ind = search(i + 1, node[i].r + 1);

        if (ind == -1) {
            Result res = new Result(node[i].w, new TreeSet<>());
            res.indices.add(node[i].ind);
            return dp[i][cnt] = response(res, skip);
        }
        Result ans = solve(ind, cnt - 1);
        Result res = new Result(ans);
        if (res.sum != Integer.MIN_VALUE) {
            res.sum += node[i].w;

        }
        res.indices.add(node[i].ind);

        return dp[i][cnt] = response(res, skip);
    }

    private Result response(Result res, Result skip) {

        if (res.sum > skip.sum) {
            return res;
        }
        if (skip.sum > res.sum) {
            return new Result(skip);
        }

         Integer a = skip.indices.first();
        Integer b = res.indices.first();
        while (a != null && a.equals(b)) {
            a = skip.indices.higher(a);
            b = res.indices.higher(b);
        }

        if (a == null && b == null) {
            return res;
        }
        if (a == null) {
            return res;
        }

        if (b == null) {
            return new Result(skip);
        }

        if (a < b) {
            return new Result(skip);
        }

        return res;
    }

    private int search(int i, int val) {

        int start = i;
        int ind = -1;
        int end = node.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (node[mid].l < val) {
                start = mid + 1;
            } else {
                ind = mid;
                end = mid - 1;
            }
        }

        return ind;
    }

    class Node {

        int l;
        int r;
        int w;
        int ind;

        public Node(int l, int r, int w, int ind) {

            this.l = l;
            this.r = r;
            this.w = w;
            this.ind = ind;
        }
    }

    class Result {

        long sum;
        TreeSet<Integer> indices;

        public Result(int sum, TreeSet<Integer> indices) {

            this.sum = sum;
            this.indices = indices;
        }

        public Result(Result result) {

            this.sum = result.sum;
            this.indices = new TreeSet<>(result.indices);
        }
    }
}