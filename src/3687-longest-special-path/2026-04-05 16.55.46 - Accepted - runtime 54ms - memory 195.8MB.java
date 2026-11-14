import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    int longest = 0;
    int size = 1;
    List<int[]> adjList[];
    int nums[];
    int depth[] = new int[50001];

    public int[] longestSpecialPath(int[][] edges, int[] nums) {

        int n = edges.length + 1;

        this.nums = nums;
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int l = edges[i][2];
            adjList[u].add(new int[]{v,l});
            adjList[v].add(new int[]{u,l});
        }
        List<Integer> list = new ArrayList<>();
        list.add(0);

        dfs(0, -1, 1, 0, list);

        return new int[]{-longest, size};
    }

    private void dfs(int curr, int par, int currDepth, int left, List<Integer> pre){
        
        int prevDepth = depth[nums[curr]];
        depth[nums[curr]] = currDepth;

        left = Math.max(left, prevDepth);

        int first = -(pre.get(pre.size()-1) - pre.get(left));
        int second = currDepth - left;

        if(first < longest || (first == longest && second < size)){
            size = second;
            longest = first;
        }

        for(var child : adjList[curr]){
            int v = child[0];
            int l = child[1];

            if(v == par) continue;
            pre.add(pre.get(pre.size()-1) + l);

            dfs(v, curr, currDepth + 1, left, pre);

            pre.remove(pre.size()-1);

        }

        depth[nums[curr]] = prevDepth;

    }
}