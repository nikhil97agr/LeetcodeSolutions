package number_of_sets_of_k_non_overlapping_line_segments_1725;

class Solution {
    public int numberOfSets(int n, int k) {
        Integer dp[][][] = new Integer[n+1][k+1][2];
        return solve(0, k, 1, n, dp);
    }

    private int solve(int i, int k, int isStart, int n, Integer dp[][][]){
        if(k==0){
            return 1;
        }

        if(i==n){
            return 0;
        }

        if(dp[i][k][isStart]!=null)return dp[i][k][isStart];

        int ans = solve(i+1, k, isStart, n, dp);
        if(isStart==1){
            ans = add(ans, solve(i+1, k, 0, n, dp));
        }else{
            ans = add(ans, solve(i, k-1, 1, n, dp));
        }
        

        return dp[i][k][isStart] = ans;
    }

    private int add(int a, int b){
        long mod = (long)1e9 + 7;

        long sum = 1l*a + b;

        return (int)(sum%mod);
    }
}