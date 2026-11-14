class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for(List<Integer> list: wall){
            int prev = 0;
            for(int i=0;i<list.size()-1;i++){
                prev += list.get(i);
                map.merge(prev, 1, Integer::sum);

            }
        }

        int ans = wall.size();
        System.out.println(map);
        for(int val : map.values()){
            ans = Math.min(ans, wall.size() - val);
        }
        return ans;
    }
}