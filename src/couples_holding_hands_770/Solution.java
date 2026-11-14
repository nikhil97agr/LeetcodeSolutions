package couples_holding_hands_770;

class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length/2;
        DSU dsu  = new DSU(n);
        for(int i=0;i<n;i++){
            int x = row[2*i];
            int y = row[2*i+1];
            dsu.union(x/2, y/2);
        }

        return n - dsu.count;
    }
}

class DSU{

    int parent[];
    int count;
    public DSU(int n){
        parent = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        count = n;
    }

    public int find (int i){
        return (parent[i]==i) ? i : (parent[i] = find(parent[i]));
    }

    public void union(int i, int j){
        int p1 = find(i);
        int p2 = find(j);

        if(p1==p2) return;

        parent[p1] = p2;

        count--;
    }
}