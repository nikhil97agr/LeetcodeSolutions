package decode_ways_ii_639;

class Solution {
    Integer dp[][];
    public int numDecodings(String s) {
        dp =new Integer[s.length()][27];
        return solve(s.toCharArray(), 0, s.length(), 0);
    }

    private int solve(char ch[], int i, int n, int prev) {

        if (i == n) {
            if(prev <=26)
            return 1;

            return 0;
        }
        if((prev ==0 && ch[i]-'0' == 0) || (prev  > 26)) return 0;
        if(dp[i][prev] !=null) return dp[i][prev];

        int ans = prev ==0 ? 0 : solve(ch, i, n, 0);
        
        if(ch[i] == '*'){
            for(int dig = 1;dig <= 9;dig++){
                ans =add(ans, solve(ch, i+1, n, prev * 10 + dig));
            }
        }else{
            ans = add(ans, solve(ch, i+1, n, prev * 10 + (ch[i] - '0')));
        }
        
        return dp[i][prev] = ans;
    }
    
    private int add(long a, long b)
    {
        long mod = (long )1e9 + 7;
        return (int)((a+b)%mod);
    }
}