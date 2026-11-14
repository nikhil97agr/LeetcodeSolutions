class Solution {
    Long dp[][][][];
    public long goodIntegers(long l, long r, int k) {
        char rr[] = Long.toString(r).toCharArray();
        char ll[] = Long.toString(l-1).toCharArray();
        dp = new Long[rr.length][10][2][2];
        long a = solve(rr, 0, 0, k, 1,0, rr.length);
        dp = new Long[ll.length][10][2][2];
        long b = solve(ll, 0, 0, k, 1,0, ll.length);

        return a - b;
    }

    private long solve(char dig[], int i, int prev, int k, int flag, int started, int n){
        if(i == n){
            return 1;
        }

        if(dp[i][prev][flag][started] !=null) return dp[i][prev][flag][started];

        long ans = 0;

        int limit = dig[i] - '0';
        int newLimit = (flag == 1) ? limit : 9;
        for(int d = 0;d<=newLimit;d++){
            if(Math.abs(d - prev) > k && started == 1){
                continue;
            }
            int newFlag = (flag == 1 && d== newLimit) ? 1 : 0;
            int newStarted = (started ==0 && d == 0) ? 0 : 1;

            ans += solve(dig, i + 1, d, k, newFlag,newStarted, n);
        }

        return dp[i][prev][flag][started] = ans;

    }
}