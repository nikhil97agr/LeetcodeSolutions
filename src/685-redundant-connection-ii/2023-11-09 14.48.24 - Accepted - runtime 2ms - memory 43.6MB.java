class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length+1;
        DSU dsu = new DSU(n);
        int degree[] = new int[n+1];
        int degree2 = -1;
        int res[] = null;
        for(int i=0;i<edges.length;i++){
            int e[] = edges[i];
            int src = e[0];
            int dest = e[1];
            degree[dest]++;

            if(degree[dest]==2){
                degree2 = i;
            }

            if(dsu.isConnected(src, dest)) res = e;

            dsu.union(src, dest);
        }

        if(degree2 == -1) return res;

        int e1 = -1;;
        int e2=-1;

        for(int i=0;i<edges.length;i++){
            if(degree[edges[i][1]]==2){
                if(e1!=-1){
                    e2 =i;
                    break;
                }else{
                    e1 = i;
                }
            }
        }

        dsu = new DSU(n);

        for(int e[] : edges){
            int src = e[0];
            int end = e[1];

            if(e==edges[e2]) continue;

            if(dsu.isConnected(src, end)){
                return edges[e1];
            }

            dsu.union(src, end);
        }

        return edges[e2];

        
    }
}

class DSU{
    int parent[];
    public DSU(int n){
        parent = new int[n+1];

        for(int i=0;i<=n;i++){
            parent[i] = i;
        }

    }

    public int find(int i){
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    public void union(int i, int j){
        int p1 = find(i);
        int p2 = find(j);

        if(p1!=p2){
            parent[p1] = p2;
        }
    }

    public boolean isConnected(int i, int j){
        int p1 = find(i);
        int p2 = find(j);
        return p1==p2;
    }
}