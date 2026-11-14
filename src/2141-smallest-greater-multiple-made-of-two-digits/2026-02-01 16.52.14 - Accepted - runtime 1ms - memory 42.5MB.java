class Solution {
    long ans = -1;

    public int findInteger(int k, int digit1, int digit2) {
        solve(k, 0, Math.min(digit1, digit2), Math.max(digit1, digit2));

        return (int) ans;
    }

    private void solve(int k, long curr, int digit1, int digit2) {
        if (curr >= Integer.MAX_VALUE) {
            return;
        }
        if (curr % k == 0 && curr > k) {
            if (ans == -1) {
                ans = curr;
            } else {
                ans = Math.min(ans, curr);
            }
            return;
        }

        if (digit1 != 0 || curr != 0) {
            solve(k, curr * 10 + digit1, digit1, digit2);
        }

        if (digit2 != 0 || curr != 0) {
            solve(k, curr * 10 + digit2, digit1, digit2);
        }

    }
}