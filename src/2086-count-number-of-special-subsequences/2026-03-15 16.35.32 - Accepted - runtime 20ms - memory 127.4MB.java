class Solution {

    public int countSpecialSubsequences(int[] nums) {
        int dp[] = new int[3];
        for(int x : nums){
            if(x==0){
                dp[0] = add(prod(dp[0], 2), 1);
            }else if(x==1){
                dp[1] = add(prod(dp[1], 2), dp[0]);
            }else{
                dp[2] = add(prod(dp[2], 2), dp[1]);
            }
        }

        return dp[2];
    }
    private int prod(long a, long b){
        long mod = (long)1e9 + 7;

        return (int)((a*b)%mod);
    }

    private int add(long a, long b){
        long mod = (long)1e9 + 7;
        long sum = a + b;
        return (int)(sum%mod);
    }
}