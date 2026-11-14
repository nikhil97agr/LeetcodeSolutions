package count_the_number_of_complete_components_2793;

import java.util.*;
class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        int ans = 0;
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        boolean b[][] = new boolean[n][n];
        for(int e[]: edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);

            b[e[0]][e[1]] = true;
            b[e[1]][e[0]] = true;
        }
        boolean vis[] =new boolean[n];
        for(int i=0;i<n;i++){
            Set<Integer> set = new HashSet<>();
            if(!vis[i]){
               bfs(vis, i, set, adjList);
                int cnt = 0;
                for(int x : set){
                    for(int y : set){
                        if(b[x][y]) cnt++;
                    }
                }

                int m = set.size();
                if(cnt == (m*(m-1))){
                    ans++;
                }
            }
        }
        return ans;
    }

    private void bfs(boolean vis[], int curr, Set<Integer> set, LinkedList<Integer> adjList[]){

        set.add(curr);
        vis[curr] = true;
        int cnt = 0;
        for(int x : adjList[curr]){
            if(!vis[x]){
                bfs(vis, x, set, adjList);
            }
        }
    }


}