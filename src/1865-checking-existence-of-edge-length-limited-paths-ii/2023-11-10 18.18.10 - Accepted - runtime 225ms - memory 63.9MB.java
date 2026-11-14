class DistanceLimitedPathsExist {
    TreeMap<Integer, int[]> map;
    public DistanceLimitedPathsExist(int n, int[][] edgeList) {
        map = new TreeMap<>();
        Arrays.sort(edgeList, (a,b)->a[2]-b[2]);
        int parent[] = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
        for(int e[] : edgeList){
            union(e[0], e[1], parent);
            map.put(e[2], parent.clone());
        }


    }
    
    public boolean query(int p, int q, int limit) {
        Map.Entry<Integer, int[]> entry = map.lowerEntry(limit);
        if(entry==null) return false;

        int parent[] = entry.getValue();

        return find(parent, p) == find(parent, q);
    }

    private int find(int parent[], int i){
        if(parent[i] ==i ) return parent[i];

        return parent[i] = find(parent, parent[i]);
    }

    private void union(int i, int j, int parent[]){
        int p1 = find(parent, i);
        int p2 = find(parent, j);

        if(p1!=p2){
            parent[p1] = p2;
        }
    }
}

/**
 * Your DistanceLimitedPathsExist object will be instantiated and called as such:
 * DistanceLimitedPathsExist obj = new DistanceLimitedPathsExist(n, edgeList);
 * boolean param_1 = obj.query(p,q,limit);
 */