package minimum_edge_reversals_so_every_node_is_reachable_3105;

import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    int cnt[];
    int n;
    List<Integer> adjList[];
    Map<Integer, Integer> pathSize[];
    Map<Integer, Integer> reversal[];
    Map<Integer, Set<Integer>> direction;
    public int[] minEdgeReversals(int n, int[][] edges) {
        this.n = n;
        cnt = new int[n];
        adjList = new ArrayList[n];
        pathSize = new HashMap[n];
        reversal = new HashMap[n];
        direction = new HashMap<>();

        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
            pathSize[i] = new HashMap<>();
            reversal[i] = new HashMap<>();
        }

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
            direction.computeIfAbsent(u,x -> new HashSet<>()).add(v);
        }

        dfs1(0, -1);
        dfs2(0, -1, 0, 0);


        return cnt;

    }
    
    private void dfs2(int curr, int par, int path, int rev){
        cnt[curr] += (path - rev);
        for(int child : adjList[curr]){
            if(child == par) continue;
            path += pathSize[curr].get(child);
            rev += reversal[curr].get(child);
        }
        
        for(int child : adjList[curr]){
            if(child == par) continue;
            
            int leftPath = path - pathSize[curr].get(child);
            int leftRev = rev - reversal[curr].get(child);
            leftPath++;
            if (direction.containsKey(child) && direction.get(child).contains(curr)) {
                leftRev++;
            }
            
            dfs2(child, curr, leftPath, leftRev);
        }
    }

    private int[] dfs1(int curr, int par){
        int rev = 0;
        int path = 0;
        for(int child : adjList[curr]){
            if(child == par) continue;

            int res[] = dfs1(child, curr);
            pathSize[curr].put(child, res[0]);
            reversal[curr].put(child, res[1]);
            rev+= res[1];
            path += res[0];
        }
        cnt[curr] += (path - rev);
        if(par != -1){
            path++;
            if(direction.containsKey(par) && direction.get(par).contains(curr)){
                rev++;
            }
        }
        return new int[]{path, rev};
    }
}