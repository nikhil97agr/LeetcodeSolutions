class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        int ans = -1;
        for(int x : map.keySet()){
            if(map.get(x) == x){
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
}