package smallest_missing_genetic_value_in_each_subtree_2131;

import java.util.*;
class Solution {
    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = parents.length;
        int ans[] = new int[n];
        Arrays.fill(ans, 1);
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        for(int i=1;i<n;i++){
            adjList[parents[i]].add(i);
        }

        boolean vis[] = new boolean[Arrays.stream(nums).max().getAsInt()+2];
        int pos = -1;
        for(int i=0;i<n;i++){
            if(nums[i] == 1){
                pos = i;
                break;
            }
        }
        int min = 1;
        for(;pos < nums.length && pos != -1; pos = parents[pos]){
            dfs(vis, adjList, pos, nums);

            while(vis[min]){
                min++;
            }
            ans[pos]= min;
        }

        return ans;
    }

    private void dfs(boolean vis[], LinkedList<Integer> adjList[], int i, int nums[]){
        if(!vis[nums[i]]){
            vis[nums[i]] = true;
            for(int child : adjList[i]){
                dfs(vis, adjList, child, nums);
            }
        }
    }
}