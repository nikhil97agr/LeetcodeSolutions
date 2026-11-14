class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        Boolean dp[] = new Boolean[n];
        boolean vis[] = new boolean[n];
        return solve(start, arr, dp, n, vis);
    }

    private boolean solve(int i, int arr[], Boolean dp[], int n, boolean vis[]){
        if(i <0 || i >=n ) return false;
        if(arr[i] ==0) return true;
        if(dp[i]!=null) return dp[i];
        if(vis[i]) return false;
        vis[i] = true;
        return dp[i] = solve(i + arr[i], arr, dp, n, vis) || solve(i-arr[i], arr, dp, n, vis);
    }
}