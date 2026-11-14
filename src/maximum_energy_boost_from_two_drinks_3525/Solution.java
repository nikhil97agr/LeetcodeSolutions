package maximum_energy_boost_from_two_drinks_3525;

class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        Long dp[][] = new Long[energyDrinkA.length][2];
        return Math.max(solve(0, 0, energyDrinkA, energyDrinkB, energyDrinkA.length, dp),
        solve(0,1,energyDrinkA, energyDrinkB, energyDrinkA.length, dp));
    }

    private long solve(int i, int prev, int a[], int b[], int n, Long dp[][]){

        if(i==n) return 0l;

        if(dp[i][prev]!=null) return dp[i][prev];
        if(prev == 1){
            return dp[i][prev] = Math.max(solve(i+1, prev, a, b, n, dp) + b[i], solve(i+1, 0, a,b,n, dp));
        }
        return dp[i][prev] = Math.max(solve(i+1, prev, a, b,n, dp) + a[i], solve(i+1, 1, a, b,n, dp));
    }
}