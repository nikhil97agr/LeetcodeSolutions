class Solution {
    Long dp[];
    public long minimumCost(int[] nums, int[] cost, int k) {

        var n = nums.length;
        dp = new Long[n];
        var preNum = new long[n];
        var preCost = new long[n + 1];
        for (var i = 0; i < n; i++) {
            if (i > 0) {
                preNum[i] = preNum[i - 1];
            }
            preNum[i] += nums[i];
            preCost[i + 1] = preCost[i] + cost[i];
        }

        return solve(0, n, preNum, preCost, k);
    }

    private long solve(int start, int n, long preNum[], long preCost[], int k) {

        if (start == n) {
            return 0;
        }

        if(dp[start]!=null) return dp[start];

        long ans = Long.MAX_VALUE;
        for (int end = start; end < n; end++) {
            long a = preNum[end] * (preCost[end + 1] - preCost[start]);
            long b = k * (preCost[n] - preCost[start]);
            ans = Math.min(ans, a + b + solve(end + 1, n, preNum, preCost, k));
        }

        return dp[start] = ans;
    }
}