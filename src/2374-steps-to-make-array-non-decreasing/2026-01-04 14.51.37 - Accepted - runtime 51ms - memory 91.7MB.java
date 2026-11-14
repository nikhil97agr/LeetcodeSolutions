class Solution {
    public int totalSteps(int[] nums) {
        int ans = 0;
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int dp[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                dp[i] = Math.max(++dp[i], dp[stack.pop()]);
            }
            ans = Math.max(ans, dp[i]);
            stack.push(i);
        }

        return ans;
    }
}