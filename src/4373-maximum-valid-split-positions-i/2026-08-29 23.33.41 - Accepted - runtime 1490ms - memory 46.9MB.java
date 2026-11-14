class Solution {
    public int maxValidSplits(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            int gcd = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (i == j)
                    continue;
                gcd = gcd(gcd, nums[j]);
                stack.push(gcd);
            }

            ans = Math.max(ans, cnt(stack, nums, i, n));
        }

        Stack<Integer> stack =new Stack<>();
        int gcd = 0;
        for(int i=n-1;i>=0;i--){
            gcd = gcd(gcd, nums[i]);
            stack.push(gcd);
        }

        ans = Math.max(ans, cnt(stack, nums, -1, n));

        return ans;
    }

    private int cnt(Stack<Integer> stack, int nums[], int skip, int n) {
        int gcd = 0;
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            if (skip == j) {
                continue;
            }

            stack.pop();
            gcd = gcd(gcd, nums[j]);
            if (!stack.isEmpty()) {
                if (gcd == stack.peek()) {
                    cnt++;
                }
            }

        }

        return cnt;
    }

    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}