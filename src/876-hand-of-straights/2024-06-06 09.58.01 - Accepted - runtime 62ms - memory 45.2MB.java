class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int x : hand){
            map.put(x, map.getOrDefault(x, 0)+1);
        }

        while(!map.isEmpty()){
            int next = map.firstKey();
            int size = 0;
            while(size < groupSize){
                if(!map.containsKey(next)) return false;
                map.put(next, map.get(next) -1);
                if(map.get(next) == 0) map.remove(next);
                next++;
                size++;
            }
        }
        return true;
    }
}