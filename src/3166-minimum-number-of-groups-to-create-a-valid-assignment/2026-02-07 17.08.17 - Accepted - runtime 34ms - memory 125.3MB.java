class Solution {
    public int minGroupsForValidAssignment(int[] balls) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = balls.length;
        int minCnt = n;
        for(int b : balls){
            map.merge(b, 1, Integer::sum);

        }
        if(map.size() == 1) return 1;
        for(int val : map.values()){
            minCnt = Math.min(minCnt, val);
        }
        int ans = Integer.MAX_VALUE;
        for(int i=1;i<=minCnt;i++){
            int cnt = getCnt(map, i);
            ans = Math.min(ans, cnt);
        }
        
        return ans;
    }

    private int getCnt(Map<Integer, Integer> map, int k){
        int total = 0;
        for(int val : map.values()){
            int grps = val / k;
            int left = val % k;
            if(grps < left){
                return Integer.MAX_VALUE;
            }
            total += Math.ceil((1d * val)/(k+1));
        }

        return total;
    }
}