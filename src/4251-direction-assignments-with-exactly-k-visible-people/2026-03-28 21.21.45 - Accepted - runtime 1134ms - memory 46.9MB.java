class Solution {

    int mod = 1_000_000_007;
    int fact[];
    int inv[];

    public static void main(String[] args) {

        new Solution().countVisiblePeople(3, 1, 0);
    }

    public int countVisiblePeople(int n, int pos, int k) {

        int ans = 0;
        fact = new int[n + 1];
        inv = new int[n + 1];
        int leftCnt = pos;
        int rightCnt = n - (pos + 1);
        fact[0] = 1;
        fact[1] = 1;
        inv[0] = 1;
        inv[1] = 1;

        for (int i = 2; i <= n; i++) {
            fact[i] = prod(fact[i - 1], i);
            inv[i] = pow(fact[i], mod - 2);
        }
        int total = comb(n-1, k);
        

        return prod(total, 2);
    }

    private int pow(int a, int b) {

        if (a == 0 || b == 1) {
            return a;
        }

        if (b == 0 || a == 1) {
            return 1;
        }

        int p = pow(a, b / 2);
        p = prod(p, p);

        if (b % 2 == 1) {
            p = prod(p, a);
        }

        return p;
    }

    private int comb(int l, int r) {

        return prod(fact[l], prod(inv[r], inv[l - r]));
    }


    private int prod(int a, int b) {

        long p = 1l * a * b;
        return (int) (p % mod);
    }
}