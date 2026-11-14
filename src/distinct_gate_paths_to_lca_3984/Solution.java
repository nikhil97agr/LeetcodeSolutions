package distinct_gate_paths_to_lca_3984;

import java.util.*;
class Solution {
    int mod= 1_000_000_007;
    List<Integer> adjList[];
    int n;
    int gates[][];
    int parent[][];
    int depth[];
    int log = 16;
    public int distinctPaths(int n, int[] par, int[][] gates, int[][] queries) {
        this.n = n;
        adjList = new ArrayList[n];
        this.gates =gates;
        this.parent = new int[n][log];
        depth = new int [n];
        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(par[i] != -1){
                adjList[par[i]].add(i);
            }
        }

        dfs(0, 0, 0);

        int mat[][][] = new int[n][log][4];

        for(int i=0;i<n;i++){
            mat[i][0][0] = gates[i][0];
            mat[i][0][1] = gates[i][2];
            mat[i][0][2] = gates[i][2];
            mat[i][0][3] = gates[i][1];
        }

        for(int i = 1;i<log;i++){
            for(int j=0;j<n;j++){
                int p = parent[j][i-1];
                int anc = parent[p][i-1];

                if(anc == p && anc == 0){
                    mat[j][i][0] = 1;
                    mat[j][i][3] = 1;
                }else{
                    mat[j][i] = prod(mat[p][i-1], mat[j][i-1]);
                }
            }
        }

        int ans = 0;
        for(var q : queries){
            int anode = q[0];
            int acard = q[1];
            int bnode = q[2];
            int bcard = q[3];

            int lca = lca(anode, bnode);

            int a = ways(anode, depth[lca], acard, mat);
            int b = ways(bnode, depth[lca], bcard, mat);

            int prod = prod(a,b);

            ans ^= prod;
        }

        return ans;

    }

    private int ways(int node, int d, int start, int mat[][][]){
        int red = (start == 1 ? 1 : 0);
        int blue = (start == 0 ? 1 : 0);

        int curr = node;
        int steps = depth[curr] - d;
        int k=0;
        while(steps > 0){
            if((steps & 1)!= 0){
                int res[] = prod(mat[curr][k], red, blue);
                red = res[0];
                blue= res[1];
                curr = parent[curr][k];
            }
            steps >>= 1;
            k++;
        }

        return add(red, blue);
    }

    private int[] prod(int mat[], int red, int blue){
        return new int []{
            add(prod(mat[0], red), prod(mat[1], blue)),
            add(prod(mat[2], red), prod(mat[3], blue))
        };
    }

    private int lca(int u, int v){
        if(depth[v] > depth[u]){
            return lca(v, u);
        }
        int diff = depth[u] - depth[v];

        for(int i= log - 1;i>=0;i--){
            int bit =   ((diff>> i) &1);
            if(bit == 1){
                u = parent[u][i];
            }


        }

        if(u == v) return u;

        for(int i = log - 1;i>=0;i--){
            if(parent[u][i] != parent[v][i]){
                u = parent[u][i];
                v = parent[v][i];
            }
        }

        return parent[u][0];
    }

    private int[] prod(int a[], int b[]){
        return new int[]{
            add(prod(a[0], b[0]), prod(a[1], b[2])),
            add(prod(a[0], b[1]), prod(a[1], b[3])),
            add(prod(a[2], b[0]), prod(a[3], b[2])),
            add(prod(a[2], b[1]), prod(a[3], b[3]))
        };
    }

    private void dfs(int curr, int par, int d){
        depth[curr] = d;
        parent[curr][0] = par;
        for(int i=1;i<log;i++){
            int prev = parent[curr][i-1];
            parent[curr][i] = parent[prev][i-1];
        }

        for(int child : adjList[curr]){
            if(child == par) continue;

            dfs(child, curr, d + 1);
        }
    }

    private int prod(int a, int b){
        long p = 1l * a * b;

        return(int)(p%mod);
    }

    private int add(int a, int b){
        long sum = 1l * a  + b  + mod;

        return (int)(sum%mod);
    }
}