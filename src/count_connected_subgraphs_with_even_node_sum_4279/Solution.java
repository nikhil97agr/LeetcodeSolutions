package count_connected_subgraphs_with_even_node_sum_4279;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public int evenSumSubgraphs(int[] nums, int[][] edges) {

        int n = nums.length;
        List<Integer> adjList[] = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjList[u].add(v);
            adjList[v].add(u);
        }

        int ans = 0;

        for (int i = 1; i < (1 << n); i++) {
            int clone[] = nums.clone();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int bit = i >> j;
                if ((bit & 1) == 0) {
                    clone[j] = -1;
                } else {
                    sum += nums[j];
                }
            }

            if (sum % 2 == 1) {
                continue;
            }

            if (check(clone, adjList, n)) {
                ans++;
            }
        }

        return ans;

    }

    private boolean check(int clone[], List<Integer> adjList[], int n) {

        boolean vis[] = new boolean[n];
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (clone[i] == -1) {
                continue;
            }

            if (!vis[i] && found) {
                return false;
            }
            found = true;
            dfs(i, -1, adjList, clone, vis);
        }

        return true;


    }

    private void dfs(int curr, int par, List<Integer> adjList[], int nums[], boolean[] vis){
        if(nums[curr] == -1 || vis[curr]) return;
        
        vis[curr] = true;
        for(int child : adjList[curr]){
            if(child == par) continue;
            dfs(child, curr, adjList, nums, vis);
        }
    }
}