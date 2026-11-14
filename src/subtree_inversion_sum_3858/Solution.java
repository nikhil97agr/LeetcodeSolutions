package subtree_inversion_sum_3858;

import java.util.*;

class Solution {

    int nums[];
    int k;
    List<Integer> adjList[];
    long ans = 0;

    Long with[][][];

    long invalid = Long.MIN_VALUE;

    public long subtreeInversionSum(int[][] edges, int[] nums, int k) {

        int n = edges.length + 1;
        this.nums = nums;
        this.k = k;
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (var e : edges) {
            var u = e[0];
            var v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        with = new Long[n][k+2][2];


        return dfs(0, -1, -1, 1, k);

    }

    private long dfs(int curr, int par, int dist, int multiplier, int k) {
        List<Integer> adjList[] = this.adjList;
        int m = Math.min(multiplier+1, 1);
        if(with[curr][dist + 1][m] != null){
            return with[curr][dist + 1][m];
        }

        long withInversion = invalid;
        long withOutInversion = invalid;

        for (int child : adjList[curr]) {
            if (child == par) {
                continue;
            }
            long without = dfs(child, curr, dist == -1 ? -1 : Math.min(dist + 1, k), multiplier, k);

            if (dist == k || dist == -1) {
                long with = dfs(child, curr, 1, multiplier * -1, k);
                long res = with;
                if (res != invalid) {
                    if (withInversion == invalid) {
                        withInversion = res;

                    } else {
                        withInversion += res;

                    }
                }
            }
            long res = without;;
            if (res != invalid) {
                if (withOutInversion == invalid) {
                    withOutInversion = res;
                } else {
                    withOutInversion += res;
                }
            }

        }
        if (withOutInversion == invalid) {
            withOutInversion = multiplier * nums[curr];
        } else {
            withOutInversion += multiplier * nums[curr];
        }
        if (dist == k || dist == -1) {
            if (withInversion == invalid) {
                withInversion = -1l * multiplier * nums[curr];
            } else {
                withInversion += -1l * multiplier * nums[curr];

            }
        }

        return with[curr][dist + 1][m] = Math.max(withInversion, withOutInversion);

    }

}