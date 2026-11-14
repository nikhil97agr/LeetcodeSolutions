package incremental_even_weighted_cycle_queries_4114;

class Solution {
    int parent[];
    int xor[];
    public int numberOfEdgesAdded(int n, int[][] edges) {
        int ans = 0;
        parent= new int[n];
        xor = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int e[] : edges){
            if(union(e[0], e[1], e[2])){
                ans++;
            }
        }

        return ans;
    }

    private boolean union(int u, int v, int w){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv){
            return (xor[u] ^ xor[v] ^ w )== 0;
        }

        parent[pu] =pv;
        xor[pu] = xor[u] ^ xor[v] ^ w;
        return true;
    }

    private int find(int p){
        if(parent[p] != p){
            int pp = parent[p];
            parent[p] = find(pp);
            xor[p] ^= xor[pp];
        }

        return parent[p];
    }
}