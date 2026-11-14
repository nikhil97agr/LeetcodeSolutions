package maximize_the_number_of_target_nodes_after_connecting_trees_i_3633;

import java.util.*;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        LinkedList<Integer> tree1[] = buildGraph(edges1, n);
        LinkedList<Integer> tree2[] = buildGraph(edges2, m);

        int cnt1[] = cntEdges(tree1, k, n);
        int cnt2[] = cntEdges(tree2, k-1, m);
        int res[] = new int[n];
        int max = Arrays.stream(cnt2).max().getAsInt();
        
        for(int i=0;i<n;i++){
            res[i] = max + cnt1[i];
        }
        return res;
    }

    private int[] cntEdges(LinkedList<Integer> adjList[], int k, int n){
        int cnt[] = new int[n];

        for(int i=0;i<n;i++){
            cnt[i] = dfs( adjList, k, 0,i, i);
        }


        return cnt;
    }

    private int dfs(LinkedList<Integer> adjList[], int k,  int count, int src, int dest){
        if(count > k) return 0;

        int ans = 1;

        for(int child : adjList[dest]){
            if(child == src) continue;

            ans += dfs(adjList, k, count+1, dest, child);
        }
        return ans;
    }

    private LinkedList<Integer>[] buildGraph(int edges[][], int n){
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        for(int e[] : edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        return adjList;
    }
}