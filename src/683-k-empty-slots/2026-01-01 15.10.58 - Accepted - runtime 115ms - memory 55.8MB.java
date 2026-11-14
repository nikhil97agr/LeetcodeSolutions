class Solution {
    public int kEmptySlots(int[] bulbs, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = bulbs.length;
        for(int i=1;i<=n;i++){
            int pos = bulbs[i-1];

            Integer lower = set.lower(pos);
            Integer higher = set.higher(pos);

            if(higher !=null && lower != null){
                int between = higher - lower - 1;
                map.merge(between, -1, Integer::sum);
                
                if(map.get(between) ==0) map.remove(between);
            }

            if(lower != null){
                int cnt = pos - lower - 1;
                map.merge(cnt, 1, Integer::sum);
            }

            if(higher != null){
                int cnt = higher - pos - 1;
                map.merge(cnt, 1, Integer::sum);
            }
            set.add(pos);
            if(map.containsKey(k)){
                return i;
            }


        }

        return -1;
    }
}