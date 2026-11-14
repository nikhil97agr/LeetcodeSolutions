package minimum_edge_weight_equilibrium_queries_in_a_tree_3079;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
    int log = 16;
    int depth[];
    int n;
    int cnt[][];
    List<int[]> adjList[];
    int parent[][];
    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        this.n = n;
        cnt = new int[n][27];
        depth = new int[n];
        parent = new int[n][log];
       adjList  = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();

        }
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adjList[u].add(new int[]{v, w});
            adjList[v].add(new int[]{u, w});
        }

        dfs(0, 0, 0);
        int q = queries.length;
        int ans[] = new int[q];

        for(int i=0;i<q;i++){
            int a = queries[i][0];
            int b = queries[i][1];
            int lca = lca(a,b);
            int cntA[] = diff(cnt[a], cnt[lca]);
            int cntB[] = diff(cnt[b], cnt[lca]);
            int finalDiff[] = new int[27];
            int total = 0;
            for(int j=0;j<27;j++){
                finalDiff[j] = cntA[j] + cntB[j];
                total += finalDiff[j];
            }
            
            ans[i] = total;
            for(int j=0;j<27;j++){
                ans[i] = Math.min(ans[i], total - finalDiff[j]);
            }



        }
        return ans;
    }

    private int []diff(int a[], int b[]){
        int diff[] = new int[27];
        for(int i=0;i<27;i++){
            diff[i]=a[i] - b[i];
        }
        return diff;
    }

    private int lca(int a, int b){
        if(depth[a] < depth[b]) return lca(b,a);

        int diff = depth[a] - depth[b];
        for(int j = log - 1;j>=0;j--){
            if((diff & (1<<j)) !=0){
                a = parent[a][j];
            }
        }

        if(a==b) return a;

        for(int j=log-1;j>=0;j--){
            if(parent[a][j] != parent[b][j]){
                a = parent[a][j];
                b = parent[b][j];
            }
        }

        return parent[a][0];
    }

    private void dfs(int curr, int par, int d){
        parent[curr][0] = par;
        depth[curr] = d;

        for(int i=1;i<log;i++){
            parent[curr][i] = parent[parent[curr][i-1]][i-1];
        }

        for(int child[] : adjList[curr]){
            if(child[0] == par) continue;
            cnt[child[0]] = cnt[curr].clone();
            cnt[child[0]][child[1]]++;
            dfs(child[0], curr,d + 1);

        }
    }
}