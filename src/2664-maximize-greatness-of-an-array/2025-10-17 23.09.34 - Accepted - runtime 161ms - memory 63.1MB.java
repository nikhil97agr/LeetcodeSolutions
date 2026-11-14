class Solution {
    public int maximizeGreatness(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for(int x : nums){
            map.merge(x, 1, Integer::sum);
        }

        for(int x : nums){
            Integer higher = map.higherKey(x);
            if(higher != null){
                cnt++;
                map.merge(higher, -1, Integer::sum);
                if(map.get(higher) == 0) map.remove(higher);
            }
        }

        return cnt;
    }
}