class Solution {

    int[][] C5 = new int[5][5];

    public boolean hasSameDigits(String s) {

        for (int i = 0; i < 5; i++) {
            C5[i][0] = C5[i][i] = 1;
            for (int j = 1; j < i; j++) {
                C5[i][j] = (C5[i - 1][j - 1] + C5[i - 1][j]) % 5;
            }
        }

        return check(s, 2) && check(s, 5);
    }

    private boolean check(String s, int mod) {
        int n = s.length();

        int a = 0, b = 0;

        for (int i = 0; i <= n - 2; i++) {
            int coeff = (mod == 2) ? comb2(n - 2, i) : comb5(n - 2, i);

            a = (a + coeff * (s.charAt(i) - '0')) % mod;
            b = (b + coeff * (s.charAt(i + 1) - '0')) % mod;
        }

        return a == b;
    }

    private int comb2(int n, int r) {
        return ((r & (n - r)) == 0) ? 1 : 0;
    }

    private int comb5(int n, int r) {
        int res = 1;

        while (n > 0 || r > 0) {
            int ni = n % 5;
            int ri = r % 5;

            if (ri > ni) return 0;

            res = (res * C5[ni][ri]) % 5;

            n /= 5;
            r /= 5;
        }

        return res;
    }
}