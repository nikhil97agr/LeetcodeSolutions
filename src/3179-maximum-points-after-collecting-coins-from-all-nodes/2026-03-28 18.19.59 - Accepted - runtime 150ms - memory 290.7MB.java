class Solution {
    List<Integer> adjList[];
    int maxBit;
    int n;
    int coins[];
    int k;
    Result dp[][];
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        this.coins = coins;
        this.k = k;
        n = coins.length;
        
        adjList = new ArrayList[n];
        int max= Arrays.stream(coins).max().getAsInt();
        if(max == 0){
            maxBit = 1;
        }else{
        maxBit = (int)(Math.log(Arrays.stream(coins).max().getAsInt())/ Math.log(2));

        }
        dp = new Result[n][maxBit + 1];
        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();
        for(var e : edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        Result result = solve(0, -1, 0);

        return Math.max(0, Math.max(result.first, result.second));
    }

    private Result solve(int curr, int par, int t){
        if(dp[curr][t] != null) return dp[curr][t];
        Result result = new Result((coins[curr]>>t) - k, coins[curr]>>(t + 1));

        for(int child : adjList[curr]){
            if(child == par) continue;
            Result r1 = solve(child, curr, t);
            Result r2 = solve(child, curr, Math.min(t + 1, maxBit));
            result.first += Math.max(r1.first, r1.second);
            result.second += Math.max(r2.first, r2.second);
        }

        return dp[curr][t] = result;
    }

    class Result{
        int first;
        int second;
        public Result(int first, int second){
            this.first= first;
            this.second = second;
        }
    }
}
