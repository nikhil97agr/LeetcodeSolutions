class Solution {
    Integer dp[][];
    public int numberOfPermutations(int n, int[][] requirements) {
        var map =new HashMap<Integer ,Integer>();
        var maxCnt = 0;
        for(var r : requirements){
            map.put(r[0], r[1]);
            maxCnt = Math.max(maxCnt, r[1]);
        }

        if(map.containsKey(0) && map.get(0) !=0) return 0;
        dp = new Integer[n][maxCnt + 1];

        return solve(1, n, 0, maxCnt, map);


    }
    private int solve(int i, int n, int cnt, int maxCnt, Map<Integer, Integer> map){
        if(i ==n ) return 1;
        if(dp[i][cnt] !=null) return dp[i][cnt];
        int ans = 0;
        int req = map.getOrDefault(i, -1);
        for(int newCnt = cnt; newCnt <= Math.min(cnt + i, maxCnt);newCnt++){  
            if(req == -1 || req == newCnt){
                ans = add(ans, solve(i+1, n, newCnt, maxCnt, map));
            }
        }
        return dp[i][cnt] = ans;
    }

    private int add(int a, int b){
        int mod = 1_000_000_007;
        return (int)((1l* a + b)%mod);
    }
}