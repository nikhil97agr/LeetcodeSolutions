class Solution {
    public int maxBoxesInWarehouse(int[] boxes, int[] warehouse) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        for(int b : boxes){
            map.merge(b, 1, Integer::sum);
        }
        TreeMap<Integer, Integer> m2 = new TreeMap<>();
        for(int w : warehouse){
            m2.merge(w, 1, Integer::sum);
        }

        for(int i=warehouse.length-1;i>=0;i--){
            int min = m2.firstKey();
            Integer lower = map.floorKey(min);
            if(lower !=null){
                ans++;
                map.merge(lower, -1, Integer::sum);
                if(map.get(lower) ==0) map.remove(lower);
                
            }
            m2.merge(warehouse[i], -1, Integer::sum);
                if(m2.get(warehouse[i]) ==0) m2.remove(warehouse[i]);
        }

        return ans;

    }
}