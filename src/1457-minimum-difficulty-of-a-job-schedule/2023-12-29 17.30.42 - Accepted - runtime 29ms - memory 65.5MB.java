class Solution {
    public int minDifficulty(int[] arr, int d) {
        int n = arr.length;
        if(n < d) return -1;
        if(n==d) return Arrays.stream(arr).reduce(0, Integer::sum);
        int max = Arrays.stream(arr).max().getAsInt();
        Integer dp[][][] = new Integer[n][d+1][max+1];

        return solve(0, d,n, arr, dp, 0);
    }

    private int solve(int i, int d, int n, int arr[],Integer dp[][][], int currMax){
        if(i == n){
            if(d==0) return 0;
            return 10000000;
        }
        if(d==0) return 10000000;
        
        currMax = Math.max(currMax, arr[i]);
        if(dp[i][d][currMax]!= null) return dp[i][d][currMax];
        int ans = Math.min(solve(i+1, d-1, n, arr, dp, 0) + currMax,
                            solve(i+1, d, n, arr, dp, currMax));

        dp[i][d][currMax] = ans;
        return ans;
    }


}