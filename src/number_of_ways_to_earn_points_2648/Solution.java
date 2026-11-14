package number_of_ways_to_earn_points_2648;

class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        Long dp[][] = new Long[n][target+1];
        return (int)solve(target, types, 0, n, dp);
    }


    private long solve(int target, int types[][], int i, int n, Long dp[][]){
        if(target < 0) return 0;

        if(target == 0) return 1;
        if(i>=n) return 0;

        if(dp[i][target]!=null) return dp[i][target];

        int max = Math.min(target/types[i][1], types[i][0]);
        long total = 0;

        while(max >= 0){
            total = addMod(total, solve(target - types[i][1]*max, types, i+1, n, dp));
            max--;
        }
        return dp[i][target] = total;

    }

    private long addMod(long a, long b){
        long mod = (long)1e9+7;

        return (a%mod+b%mod)%mod;
    }
}