package count_stepping_numbers_in_range_2921;

class Solution {

    long mod = (long) 1e9 + 7;
    Integer dp[][][];
    public int countSteppingNumbers(String low, String high) {

        int a = check(low.toCharArray());
        int b = check(high.toCharArray());
        int ans = add(b, -a);
        boolean flag = true;
        for (int i = 1; i < low.length(); i++) {
            if (Math.abs(low.charAt(i) - low.charAt(i - 1)) != 1) {
                flag = false;
                break;
            }
        }
        if (flag) {
            ans = add(ans, 1);
        }

        return ans;
    }

    private int check(char ch[]){
        int n = ch.length;
        int ans = 0;
        dp = new Integer[n][10][2];
        for(int dig = 1;dig < ch[0]-'0';dig++){
            ans = add(ans, solve(1, dig, ch, 0, n));
        }
        ans =add(ans, solve(1, ch[0] - '0', ch, 1, n));
        for(int i=1;i<n;i++){
            for(int dig =1;dig <= 9;dig++){
                ans = add(ans, solve(i+1, dig, ch, 0, n));
            }
        }

        return ans;
    }

    private int solve(int i, int prev, char ch[], int flag, int n) {

        if (i == n) {
            return 1;
        }
        if(dp[i][prev][flag]!=null) return dp[i][prev][flag];

        if (flag == 0) {
            int ans = 0;
            if (prev < 9) {
                ans = add(ans, solve(i + 1, prev + 1, ch, 0, n));
            }

            if (prev > 0) {
                ans = add(ans, solve(i + 1, prev - 1, ch, 0, n));
            }

            return dp[i][prev][flag] = ans;
        } else {
            int ans = 0;
            if (prev < 9) {
                if (prev + 1 == ch[i] - '0') {
                    ans = add(ans, solve(i + 1, prev + 1, ch, 1, n));
                }

                if (prev + 1 < ch[i] - '0') {
                    ans = add(ans, solve(i + 1, prev + 1, ch, 0, n));
                }
            }

            if (prev > 0) {
                if(prev -1 == ch[i] - '0'){
                    ans = add(ans, solve(i+1, prev - 1, ch, 1, n));
                }

                if(prev - 1 < ch[i] - '0'){
                    ans = add(ans, solve(i+1, prev -1, ch, 0, n));
                }
            }

            return dp[i][prev][flag] = ans;
        }

    }

    private int add(long a, long b) {

        long sum = a + b + mod;
        return (int) (sum % mod);
    }

}