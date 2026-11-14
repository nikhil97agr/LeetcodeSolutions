class Solution {
    public boolean validTree(int n, int[][] edges) {
        int parent[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int edge[] : edges){
            int p1 = find(parent, edge[0]);
            int p2 = find(parent, edge[1]);
            if(p1==p2) return false;

            parent[p1] = p2;
        }

        int p = find(parent, 0);
        for(int i=0;i<n;i++){
            int p1 = find(parent, i);
            if(p1 !=p) return false;
        }
        return true;
    }

    private int find(int parent[] , int node){
        if(parent[node] == node) return node;

        return parent[node] = find(parent, parent[node]);
    }
}