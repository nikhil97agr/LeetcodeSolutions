package sum_of_distances_in_tree_863;

import java.util.*;
class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        int dp[] = new int[n];
        if(n==1){
            return new int[]{0};
        }
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<Integer>();
        }
        for(int edge[] : edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        boolean visited[] = new boolean[n];
        int result[] = new int[n];
        int child[] = new int[n];
        dfs(0,visited, adjList, n, child, 1, result);
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(0);
        visited = new boolean[n];
        while(!que.isEmpty()){
            int x = que.poll();
            visited[x] = true;
            Iterator<Integer> it = adjList[x].iterator();
            while(it.hasNext()){
                int m = it.next();
                if(!visited[m]){
                    que.add(m);
                    result[m] = result[x] - child[m] - 1 + (n - child[m] - 1);
                }
            }
        }
        return result;
    }

    private int dfs(int i, boolean[] visited,LinkedList adjList[], int n, int child[], int step, int result[]){
            if(i>=n){
                return 0;
            }
            visited[i] = true;
            Iterator<Integer> it = adjList[i].iterator();
            int count = 0;
            while(it.hasNext()){
                int x = it.next();
                if(!visited[x]){
                    result[0] += step;
                child[i]+= dfs(x, visited,adjList, n, child, step+1, result);
                }
            }

            return child[i]+1;
    }
}