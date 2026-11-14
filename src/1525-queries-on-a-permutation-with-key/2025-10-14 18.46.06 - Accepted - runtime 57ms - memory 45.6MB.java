class Solution {
    public int[] processQueries(int[] queries, int m) {
        int ans[] = new int[queries.length];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0;i<m;i++){
            map.put(i+1, i);
        }

        for(int i=0;i<queries.length;i++){
            int val = queries[i];
            int ind = map.get(val);
            ans[i] = ind;


            for(int j=1;j<=m;j++){
                int k = map.get(j);
                if(k < ind){
                    map.put(j, k+1);
                }
            }
            map.put(val, 0);
            
        }

        return ans;
    }
}