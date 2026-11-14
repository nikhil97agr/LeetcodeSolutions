class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        Integer dp[][] = new Integer[n][n];
        return solve(0, costs, 0, costs.length, dp);
    }

    private int solve(int i, int costs[][], int cnt, int n, Integer dp[][]){
        if(i==n){
            if(cnt == n/2){ 
                return 0;
            }else{
                return 1000000;
            }
        }

        if(dp[i][cnt]!=null) return dp[i][cnt];




        return dp[i][cnt] =Math.min(costs[i][0] + solve(i+1, costs, cnt+1,n, dp), costs[i][1] + solve(i+1, costs, cnt, n, dp));
    }
}