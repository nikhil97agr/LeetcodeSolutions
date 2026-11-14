class Solution {
    public int numWays(String[] words, String target) {
        int m =words[0].length();
        int n = target.length();
        Integer dp[][] = new Integer[m][n];
        int cnt[][] = new int[m][130];
        for(int i=0;i<m;i++){
            for(String word : words){
                cnt[i][word.charAt(i)]++;
            }
        }
        long mod = (long)1e9 + 7;
        return solve(0,0,m,n,dp,cnt, mod, target);
    }

    private int solve(int i, int j, int m, int n, Integer dp[][], int  cnt[][], long mod, String target){
        if(j==n){
            return 1;
        }

        if(i==m){
            return 0;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        long count = solve(i+1, j, m, n, dp, cnt, mod, target)%mod;

        if(cnt[i][target.charAt(j)]>0){


            count += 1l*solve(i+1, j+1, m, n, dp, cnt, mod, target)*cnt[i][target.charAt(j)];
            count %=mod;
        }

        return dp[i][j] = (int)count;
    }
}




