class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        int parent[] = new int[n+1];
        for(int i=0;i<=n;i++) parent[i] = i;

        for(int i=threshold+1;i<=n;i++){
            int j = i + i;
            
            while( j <= n){
                int p1 = find(i, parent);
                int p2 = find(j, parent);
                if(p1 != p2){
                    parent[p1] = p2;
                }
                j+=i;
            }


        }
        List<Boolean> list = new ArrayList<>();

        for(int q[] : queries){
            int a = q[0];
            int b = q[1];
            int p1= find(a, parent);
            int p2 = find(b, parent);
            if(p1 == p2){
                list.add(true);
            }else{
                list.add(false);
            }
        }


        return list;

    }

    private int find(int i, int parent[]){
        if(parent[i] == i) return i;

        return parent[i] = find(parent[i], parent);
    }
}