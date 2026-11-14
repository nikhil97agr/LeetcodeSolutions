class Solution {
    Integer dp[][];

    public int minOperations(int[] nums, int sum) {
        int n = nums.length;

        dp = new Integer[sum + 1][n];
        int ans = solve(sum, nums, 0, n);

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }

    private int solve(int sum, int nums[], int i, int n) {
        if (sum == 0)
            return 0;

        if (sum < 0 || i == n) {
            return Integer.MAX_VALUE;
        }

        if (dp[sum][i] != null)
            return dp[sum][i];

        int ans = solve(sum, nums, i + 1, n);

        int num = nums[i];
        int op = 0;
        while (num <= sum) {
            int x = solve(sum - num, nums, i + 1, n);
            if (x != Integer.MAX_VALUE) {
                ans = Math.min(op + x, ans);
            }
            num *= 2;
            op++;
        }

        num = nums[i];
        op = 0;
        while (num >= 1) {
            if (num > sum) {
                num /= 2;
                op++;
                continue;
            }

            int a = num;
            int b = op;
            while (a <= sum) {
                int x = solve(sum - a, nums, i + 1, n);
                if (x != Integer.MAX_VALUE) {
                    ans = Math.min(b + x, ans);
                }

                a *= 2;
                b++;
            }

            num /= 2;
            op++;
        }

        return dp[sum][i] = ans;
    }
}