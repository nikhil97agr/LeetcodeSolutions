class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        char num[] = Long.toString(n).toCharArray();

        int len = num.length;
        int ans = 0;
        for(int i=1;i<len;i++){
            ans += Math.pow(digits.length, i);
        }
        return ans + solve(0, 1, digits, num, new Integer[len][2], len);
    }

    private int solve(int i, int flag, String digits[], char num[], Integer dp[][], int n){
        if(i==n){
            return 1;
        }

        if(dp[i][flag]!=null) return dp[i][flag];
        int ans = 0;
        if(flag == 0){
            for(int j=0;j<digits.length;j++){
                ans += solve(i+1, flag, digits, num, dp, n);
            }
        }else{
            String dig = Character.toString(num[i]);
            for(int j=0;j<digits.length && digits[j].compareTo(dig)<=0;j++){
                if(digits[j].equals(dig)){
                    ans += solve(i+1, 1, digits, num, dp, n);
                }else{
                    ans += solve(i+1, 0, digits, num, dp, n);
                }
            }
        }

        return dp[i][flag] = ans;
    }
}