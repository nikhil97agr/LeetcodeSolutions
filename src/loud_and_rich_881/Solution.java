package loud_and_rich_881;

import java.util.*;
class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        
        for(int e[] : richer){
            int u = e[0];
            int v = e[1];

            adjList[v].add(u);
        }

        int ans[] = new int[n];
        Arrays.fill(ans, -1);
        for(int i=0;i<n;i++){
            ans[i] =dfs(adjList, quiet, i, ans);
        }


        return ans;


    }

    private int dfs(LinkedList<Integer> adjList[], int q[], int i, int ans[]){

        if(ans[i] != -1) return ans[i];
        int res = i;

        for(int child : adjList[i]){
            int next = dfs(adjList, q, child, ans);

            if(q[next] < q[res]){
                res = next;
            }
        }

        return ans[i] = res;
    }
}