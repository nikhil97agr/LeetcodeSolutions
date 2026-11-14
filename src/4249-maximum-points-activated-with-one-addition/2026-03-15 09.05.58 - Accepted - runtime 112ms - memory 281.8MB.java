
class Solution {

    public int maxActivated(int[][] points) {
        int n = points.length;
        DSU  dsu =new DSU(n);
        var mx = new HashMap<Integer, List<Integer>>() ;
        var my= new HashMap<Integer, List<Integer>>();
        for(int i=0;i<n;i++){
            int x= points[i][0];
            int y = points[i][1];
            mx.computeIfAbsent(x, a -> new ArrayList<>()).add(i);
            my.computeIfAbsent(y, a -> new ArrayList<>()).add(i);

        }

        for(var list : mx.values()){
            for(int i=1;i<list.size();i++){
                dsu.merge(list.getFirst(), list.get(i));
            }
        }
        
        for(var list : my.values()){
            for(int i=1;i<list.size();i++){
                dsu.merge(list.getFirst(), list.get(i));
            }
        }
        int max = 0;
        int second =0;
        var par = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            int p = dsu.find(i);
            par.merge(p, 1, Integer::sum);
        }
        
        for(var val : par.values()){
            if(val > max){
                second = max;
                max =val;
            }else if(val > second){
                second = val;
            }
        }
        
        return max + second + 1;
    }

    class DSU {

        int parent[];
        int[] size;

        public DSU(int n) {

            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void merge(int x, int y){
            int p1 = find(x);
            int p2 = find(y);
            if(p1 == p2) return;

            if(size[p1] < size[p2]){
                parent[p1] = p2;
                size[p2] += size[p1];
            }else{
                parent[p2] = p1;
                size[p1] += size[p2];
            }
        }

        public int find(int par) {

            if (parent[par] == par) {
                return par;
            }
            return parent[par] = find(parent[par]);
        }


    }
}