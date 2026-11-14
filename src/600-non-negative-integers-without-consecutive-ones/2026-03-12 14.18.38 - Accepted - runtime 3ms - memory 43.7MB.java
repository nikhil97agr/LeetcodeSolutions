class Solution {
    Integer dp[][][];
    public int findIntegers(int n) {
        char ch [] = Integer.toBinaryString(n).toCharArray();
        dp = new Integer[ch.length][2][2];
        return solve(ch, 1, 0, ch.length, 0);
    }
    
    private int solve(char ch[], int flag, int i, int n, int prev){
        if(i == n) return 1;

        if(dp[i][flag][prev] !=null) return dp[i][flag][prev];
        int ans = 0;
        if(flag == 1){
            if(ch[i] == '0'){
                ans = solve(ch, 1, i+1, n, 0);
            }else{
                ans = solve(ch, 0, i+1, n, 0);
                if(prev != 1){
                    ans =ans + solve(ch, 1, i+1, n, 1);
                }
            }
        }else{
            if(prev == 1){
                ans = solve(ch, flag, i+1, n, 0);
            }else{
                ans = solve(ch, flag, i+1, n, 1 ) + solve(ch, flag, i+1, n, 0);
            }
        }
        
        return dp[i][flag][prev ] =ans;
    }
}