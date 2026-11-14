class Solution {
    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        int n = nums.length;
        int prefix[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }

        int ans = 0;

        for (int i = firstLen; i <= n; i++) {
            for (int j = i + secondLen; j <= n; j++) {
                ans = Math.max(ans, prefix[i] - prefix[i - firstLen] + prefix[j] - prefix[j - secondLen]);
            }
        }

        for (int i = secondLen; i <= n; i++) {
            for (int j = i + firstLen; j <= n; j++) {
                ans = Math.max(ans, prefix[j] - prefix[j - firstLen] + prefix[i] - prefix[i - secondLen]);
            }
        }

        return ans;
    }
}