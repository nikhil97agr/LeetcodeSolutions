class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for(int x : nums) map.put(x, map.getOrDefault(x, 0)+1);

        while(!map.isEmpty()){
            int next = map.firstKey();
            int size = 0;
            while(size < k && map.containsKey(next)){
                map.put(next, map.get(next)-1);
                if(map.get(next) == 0) map.remove(next);
                size++;
                next++;
            }

            if(size !=k )return false;
        }

        return true;
    }
}