package count_all_possible_routes_1680;

class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        Integer dp[][] = new Integer[n][fuel+1];
        int mod = (int)1e9+7;

        return solve(locations, start, finish, fuel, dp, n, mod);
    }

    private int solve(int loc[], int curr, int end, int fuel, Integer dp[][], int n, int mod){
        if(fuel<0) return 0;
        
        if(dp[curr][fuel]!=null) return dp[curr][fuel];
        int total = 0;
        if(curr==end) total = 1;
        for(int i=0;i<n;i++){
            int f = Math.abs(loc[i] - loc[curr]);
            if(i!=curr){
                total = total%mod + solve(loc, i, end, fuel - f, dp, n, mod)%mod;
                total = total %mod;
            }
        }

        return dp[curr][fuel] = total;
    }
}