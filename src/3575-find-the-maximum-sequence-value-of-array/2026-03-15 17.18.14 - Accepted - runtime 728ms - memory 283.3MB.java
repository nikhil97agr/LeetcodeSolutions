import java.util.Arrays;

class Solution {

    public int maxValue(int[] nums, int k) {

        int n = nums.length;
        int indLeft[] = new int[128];
        Arrays.fill(indLeft, Integer.MAX_VALUE);
        int indRight[] = new int[128];
        Arrays.fill(indRight, -1);

        dfs1(nums, indLeft, 0, 0, k, n, new Boolean[n][128][k + 1]);
        dfs2(nums, indRight, n - 1, 0, k, n, new Boolean[n][128][k + 1]);
        int ans = 0;
        for (int i = 0; i < 128; i++) {
            for (int j = 0; j < 128; j++) {
                if (indLeft[i] < indRight[j]) {
                    ans = Math.max(ans, i ^ j);
                }
            }
        }
        return ans;
    }

    private void dfs1(int nums[], int indices[], int i, int or, int cnt, int n, Boolean dp[][][]) {

        if (cnt == 0) {
            indices[or] = i - 1;
            return;
        }
        if (i == n) {
            return;
        }

        if (dp[i][or][cnt] != null) {
            return;

        }

        dp[i][or][cnt] = true;
        dfs1(nums, indices, i + 1, or, cnt, n, dp);
        dfs1(nums, indices, i + 1, or | nums[i], cnt - 1, n, dp);
    }

    private void dfs2(int nums[], int indices[], int i, int or, int cnt, int n, Boolean dp[][][]) {

        if (cnt == 0) {
            indices[or] = i + 1;
            return;
        }
        if (i == -1) {
            return;
        }

        if (dp[i][or][cnt] != null) {
            return;

        }

        dp[i][or][cnt] = true;
        dfs2(nums, indices, i - 1, or, cnt, n, dp);
        dfs2(nums, indices, i - 1, or | nums[i], cnt - 1, n, dp);
    }
}