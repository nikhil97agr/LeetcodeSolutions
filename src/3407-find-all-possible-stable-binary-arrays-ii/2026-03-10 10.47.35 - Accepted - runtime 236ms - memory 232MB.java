class Solution {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int dp[][][] = new int[one+1][zero+1][2];

        for(int i=1;i<=Math.min(zero, limit);i++){
            dp[0][i][0] = 1;
        }

        for(int i=1;i<=Math.min(one, limit);i++){
            dp[i][0][1] = 1;
        }

        for(int o = 1;o <= one;o++){
            for(int z=1;z<=zero;z++){
                dp[o][z][1]= add(dp[o-1][z][1], dp[o-1][z][0]);
                dp[o][z][0] = add(dp[o][z-1][0], dp[o][z-1][1]);

                if(z - limit -1 >=0){
                    dp[o][z][0] = add(dp[o][z][0], -dp[o][z-limit-1][1]);
                }

                if(o -limit -1 >=0){
                    dp[o][z][1] = add(dp[o][z][1], -dp[o-limit-1][z][0]);
                }
            }
        }

        return add(dp[one][zero][0], dp[one][zero][1]);
    }

    private int add(long a, long b){
        long mod = (long)1e9 + 7;

        return (int)((a+b+mod)%mod);
    }
}