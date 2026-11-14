package possible_bipartition_922;

import java.util.*;
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int parent[] = new int[n+1];
        Arrays.fill(parent, -1);
        List<Integer> list[] = new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            list[i] = new ArrayList<>();
        }

        for(int d[] : dislikes){
            list[d[0]].add(d[1]);
            list[d[1]].add(d[0]);
        }
        for(int i=1;i<=n;i++){
            if(parent[i]==-1){
                parent[i] = 0;

                if(!dfs(i, parent, list))return false;
            }
        }
        return true;


    }

    private boolean dfs(int node, int parent[], List<Integer> list[]){
        for(int x : list[node]){
            if(parent[node]==parent[x]) return false;

            if(parent[x]==-1){
                parent[x] = parent[node]^1;
                if(!dfs(x, parent, list)) return false;
            }
        }

        return true;
    }
}