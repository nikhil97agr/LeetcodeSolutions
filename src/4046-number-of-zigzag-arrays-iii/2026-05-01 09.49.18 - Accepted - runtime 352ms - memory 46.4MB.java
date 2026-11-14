class Solution {

    int mod = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {

        int len = r - l + 1;
        int dp[] = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = calc(n, i);
        }

        if (len <= n) {
            return dp[len];
        }

        int fact[] = new int[n + 1];
        int inv[] = new int[n + 1];

        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = prod(fact[i - 1], i);
        }

        inv[n] = pow(fact[n], mod - 2);
        for (int i = n - 1; i >= 0; i--) {
            inv[i] = prod(inv[i + 1], i + 1);
        }

        int total = 1;
        for (int i = 0; i <= n; i++) {
            int nums = len - i;
            total = prod(total, nums);
        }

        int ans = 0;

        for (int i = 0; i <= n; i++) {
            int denom = prod(inv[i], inv[n-i]);
            if((n-i)%2==1){
                denom = add(mod, -denom);
            }
            int values = len - i;

            int arrays = dp[i];
            arrays = prod(arrays, total);
            arrays = prod(arrays, pow(values, mod - 2));

            ans = add(ans, prod(arrays, denom));
        }

        return ans;
    }

    private int pow(int a, int b) {

        int ans = 1;
        while (b > 0) {
            if (b % 2 == 1) {
                ans = prod(ans, a);
            }

            a = prod(a, a);
            b >>= 1;
        }

        return ans;
    }

    private int calc(int n, int m) {

        if (m <= 1) {
            return 0;
        }
        int up[] = new int[m];
        int down[] = new int[m];

        for (int i = 0; i < m; i++) {
            up[i] = i;
            down[i] = m - i - 1;
        }

        for (int i = 3; i <= n; i++) {
            int newUp[] = new int[m];
            int newDown[] = new int[m];
            int pre = 0;
            for (int j = 0; j < m; j++) {
                newUp[j] = pre;
                pre = add(pre, down[j]);
            }

            int suff = 0;
            for (int j = m-1;j>=0;j--) {
                newDown[j] = suff;
                suff = add(suff, up[j]);
            }

            up = newUp;
            down = newDown;
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            ans = add(ans, up[i]);
            ans = add(ans, down[i]);
        }

        return ans;
    }


    private int add(long a, long b) {

        return (int) ((a + b + mod) % mod);
    }

    private int prod(long a, long b) {

        return (int) ((a * b) % mod);
    }
}