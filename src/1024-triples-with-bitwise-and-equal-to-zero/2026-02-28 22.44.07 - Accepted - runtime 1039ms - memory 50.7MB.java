class Solution {
    public int countTriplets(int[] nums) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int x : nums){
            for(int y : nums){
                map.merge(x & y, 1, Integer::sum);
            }
        }
        int ans = 0;
        for(int x : nums){
            for(int y : map.keySet()){
                if( (x & y) ==0){
                    ans += map.get(y);
                }
            }
        }

        return ans;
    }
}