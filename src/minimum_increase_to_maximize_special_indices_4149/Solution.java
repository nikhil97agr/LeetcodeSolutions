package minimum_increase_to_maximize_special_indices_4149;

class Solution {

    Result dp[];
    long cost[];

    public long minIncrease(int[] nums) {

        int n = nums.length;
        dp = new Result[n];
        cost = new long[n];

        for (int i = 1; i < n - 1; i++) {
            cost[i] = Math.max(0, Math.max(nums[i - 1], nums[i + 1]) + 1 - nums[i]);
        }

        return solve(1, n, nums).cost;
    }

    private Result solve(int i, int n, int nums[]) {

        if (i >= n - 1) {
            return new Result(0, 0l);
        }
        
        if(dp[i] != null) return dp[i];

        Result skip = new Result(solve(i + 1, n, nums));
        Result take = new Result(solve(i + 2, n, nums));

        take.total++;
        take.cost += cost[i];

        if (take.total > skip.total) {
            return dp[i] = take;
        } else if (take.total < skip.total) {
            return dp[i] = skip;
        } else {
            if (take.cost < skip.cost) {
                return dp[i] = take;
            } else {
                return dp[i] = skip;
            }
        }

    }

    class Result {

        int total;
        long cost;

        public Result(int total, long cost) {

            this.total = total;
            this.cost = cost;
        }

        public Result(Result result) {

            this.total = result.total;
            this.cost = result.cost;
        }
    }
}