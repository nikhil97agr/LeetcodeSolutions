package minimum_weighted_subgraph_with_the_required_paths_ii_3853;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
    int sum[];
    int log = 20;
    int parent[][];
    int depth[];
    List<int[]> adjList[] ;
    public int[] minimumWeight(int[][] edges, int[][] queries) {
        int n = edges.length + 1;
        sum = new int[n];
        parent = new int[n][log];
        depth = new int[n];
        adjList = new ArrayList[n];
        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, w});
        }

        dfs(0, 0, 0);
        int q = queries.length;
        int ans[] =new int[q];
        for(int i=0;i<q;i++){
            
            int s1 = queries[i][0], s2 = queries[i][1], dest = queries[i][2];
            int total = dist(s1, s2) + dist(s2,dest) + dist(s1, dest);
            ans[i] = total / 2;
        }
        
        return ans;

    }

    private int dist(int a, int b){
        int lca = lca(a,b);

        return sum[a] + sum[b] - 2 * sum[lca];
    }
    
    private int lca(int a, int b){
        if(depth[a] < depth[b]) return lca(b, a);
        
        int diff = depth[a] - depth[b];
        
        for(int j=log - 1;j>=0;j--){
            if( (diff & (1<<j))!=0){
                a = parent[a][j];
            }
        }
        if(a==b) return a;
        for(int j=log - 1;j>=0;j--){
            if(parent[a][j] != parent[b][j]){
                a = parent[a][j];
                b = parent[b][j];
            }
        }
        return parent[a][0];
    }

    private void dfs(int curr, int par, int d){
        depth[curr] = d;
        parent[curr][0] = par;
        for(int i=1;i<log;i++){
            parent[curr][i] = parent[parent[curr][i-1]][i-1];
        }

        for(int child[] : adjList[curr]){
            if(child[0] == par) continue;
            sum[child[0]] = child[1] + sum[curr];
            dfs(child[0], curr, d + 1);
        }
    }
}