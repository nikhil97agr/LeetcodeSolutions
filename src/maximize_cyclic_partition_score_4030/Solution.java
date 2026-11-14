package maximize_cyclic_partition_score_4030;

class Solution {
    Long dp[][][];
    public long maximumScore(int[] nums, int k) {

        int n = nums.length;
        int maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        dp = new Long[n][k + 1][3];
        long a = solve(maxIndex, k, 0, maxIndex + n, n, nums);
        dp = new Long[n][k+1][3];
        long b = solve(maxIndex + 1, k, 0, maxIndex + 1 + n, n, nums);

        return Math.max(a, b);
    }

    private long solve(int i, int k, int prev, int end, int n, int nums[]) {

        if (i == end) {
            if (prev == 1 || prev == 2) {
                return Integer.MIN_VALUE;
            }
            return 0;
        }

        if (k == 0) {
            return 0;
        }

        
        if(dp[i%n][k][prev] !=null) return dp[i%n][k][prev];
        long ans = solve(i + 1, k, prev, end, n, nums);

        if (prev == 0) {
            ans = Math.max(ans,
                    Math.max(
                            -nums[i % n] + solve(i + 1, k, 1, end, n, nums),
                            nums[i % n] + solve(i + 1, k, 2, end, n, nums)
                    ));
        } else if (prev == 1) {
            ans = Math.max(ans, nums[i % n] + solve(i + 1, k - 1, 0, end, n, nums));
        } else {
            ans = Math.max(ans, -nums[i % n] + solve(i + 1, k - 1, 0, end, n, nums));
        }

        return dp[i%n][k][prev] = ans;
    }
}