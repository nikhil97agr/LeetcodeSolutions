package stone_game_vii_1808;

class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;

        int pre[] = new int[n+1];


        for(int i=1;i<=n;i++){
            pre[i] = pre[i-1] + stones[i-1];
        }

        Integer dp[][][] = new Integer[n][n][2];

        return solve(stones, 0, n-1, 0, pre, n, dp);
    }

    private int solve(int arr[], int start, int end, int turn, int pre[], int n, Integer dp[][][]) {
        if (start > end)
            return 0;
        if (dp[start][end][turn] != null)
            return dp[start][end][turn];
        int ans = 0;
        if (turn == 0) {
            ans = Math.max(solve(arr, start + 1, end, 1, pre, n, dp) + pre[end + 1] - pre[start + 1],
                    solve(arr, start, end - 1, 1, pre, n, dp) + pre[end] - pre[start]);
        } else {
            ans = Math.min(solve(arr, start + 1, end, 0, pre, n, dp) - (pre[end + 1] - pre[start + 1]),
                    solve(arr, start, end - 1, 0, pre, n, dp) - (pre[end] - pre[start]));
        }

        return dp[start][end][turn] = ans;
    }
}