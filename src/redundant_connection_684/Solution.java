package redundant_connection_684;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        DSU dsu = new DSU(n+1);

        for(int e[] :edges){
            int src = e[0];
            int dest = e[1];

            if(dsu.isConnected(src, dest)) return e;

            dsu.union(src, dest);
        }

        return null;
    }
}

class DSU{
    int parent[];
    public DSU(int n){
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }

    public int find(int i){
        return (parent[i]==i) ? i :(parent[i] = find(parent[i]));
    }

    public void union(int i, int j){
        int p1 = find(i);
        int p2 = find(j);

        if(p1!=p2) parent[p1] = p2;
    }

    public boolean isConnected(int i, int j){
        return find(i) ==find(j);
    }
}