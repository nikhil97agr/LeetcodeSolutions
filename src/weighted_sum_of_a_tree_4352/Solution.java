package weighted_sum_of_a_tree_4352;

import java.util.*;
class Solution {
    List<Integer> adjList[];
    int nums[];
    public long weightedSum(int[] parent, int[] nums) {
        this.nums = nums;
        int n = nums.length;

        adjList = new ArrayList[n];
        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();
        for(int i=1;i<n;i++){
            int p = parent[i];
            adjList[p].add(i);
        }

        int h = height(0);

        return dfs(h, 0, 1);
    }

    private long dfs(int h, int curr, int d){
        long val = 1l * nums[curr] * (h - d + 1);
        for(var child : adjList[curr]){
            val += dfs(h , child, d + 1);
        }

        return val;
    }

    private int height(int curr){

        int h = 0;
        for(int child : adjList[curr]){
            h = Math.max(h, height(child));
        }

        return h + 1;
    }
}