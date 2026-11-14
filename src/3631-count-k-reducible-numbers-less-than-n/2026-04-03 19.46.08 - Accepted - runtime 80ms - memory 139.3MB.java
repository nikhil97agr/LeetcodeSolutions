class Solution {

    char ch[];
    int n;
    int k;
    int steps[];
    int mod = 1_000_000_007;
    Integer dp[][][];
    public int countKReducibleNumbers(String s, int k) {

        ch = s.toCharArray();
        n = s.length();
        if(n==1){
            return 0;
        }
        this.k = k;
        steps = new int[n + 1];
        steps[0] = Integer.MAX_VALUE;
        steps[1] = 0;
        dp = new Integer[n+1][2][n + 1];

        for (int digits = 2; digits <= n; digits++) {
            int bits = Integer.bitCount(digits);
            steps[digits] = steps[bits] + 1;
        }

        return solve(0, 1, 0);
    }

    private int solve(int i, int flag, int bits) {

        if (i ==n) {
            if (flag == 0  &&  steps[bits] <= k-1) {
                return 1;
            }

            
            return 0;
        }
        if(dp[i][flag][bits]!=null) return dp[i][flag][bits];
        int ans = 0;

        int limit = flag ==0 ? 1 : (ch[i] - '0');

        for(int bit =0; bit <= limit; bit++){
            int newFlag = (flag == 1 && bit == limit) ? 1 : 0;
            ans = add(ans, solve(i+1, newFlag, bits + bit));
        }

        return dp[i][flag][bits] = ans;
    }

    private int add(int a, int b) {

        long s = 1l * a + b + mod;
        return (int) (s % mod);
    }
}