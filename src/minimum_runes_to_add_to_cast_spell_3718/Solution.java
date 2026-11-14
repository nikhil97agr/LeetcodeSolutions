package minimum_runes_to_add_to_cast_spell_3718;

import java.util.*;
class Solution {
    List<Integer> adjList[];
    List<Integer> par[];
    boolean vis[];

    public int minRunesToAdd(int n, int[] crystals, int[] flowFrom, int[] flowTo) {
        adjList= new ArrayList[n];
        par = new ArrayList[n];
        vis =new boolean[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
            par[i] = new ArrayList<>();
        }

        for(int i=0;i<flowFrom.length;i++){
            adjList[flowFrom[i]].add(flowTo[i]);
            par[flowTo[i]].add(flowFrom[i]);
        }

        for(int c : crystals){
            dfs(c, vis);
        }

        int ans = 0;
        for(int i=0;i<n;i++){
            if(!vis[i] && par[i].isEmpty()){
                ans++;
                dfs(i, vis);
            }
        }

        for(int i=0;i<n;i++){
            if(!vis[i]){
                ans++;
                boolean vis2[] = new boolean[n];
                dfs(getParent(i, vis2), vis);
            }
        }

        return ans;
    }

    private void dfs(int curr, boolean vis[]){
        if(!vis[curr]){
            vis[curr] = true;
            for(int child : adjList[curr]){
                dfs(child, vis);
            }
        }
    }

    private int getParent(int curr, boolean vis[]){
        if(!vis[curr]){
            vis[curr] = true;
            for(int child : par[curr]){
                return getParent(child,vis);
            }
        }
        return curr;
    }
}