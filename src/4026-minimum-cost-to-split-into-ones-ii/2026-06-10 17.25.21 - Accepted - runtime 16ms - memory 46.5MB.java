class Solution {
    Map<Integer, Long> map;
    public long minCost(int n) {
        map = new HashMap<>();
        return solve(n);
    }

    private long solve(int x){
        if(x == 1) return 0;
        if(x==2) return 1;

        if(map.containsKey(x)) return map.get(x);

        int mid = x / 2;

        int second = x - mid;

        long ans = 1l * mid * second + solve(mid) + solve(second);
        map.put(x, ans);
        return ans;
    }
}