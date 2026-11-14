class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        Integer dp[][] = new Integer[n][k+1];
        int ans = solve(arr, 0, n, 0, 0, k, dp);
        return ans;
    }

    private int solve(int arr[], int ind, int n, int currLen, int currMax, int k, Integer dp[][]){
        if(ind==n) return currMax*currLen;
        if(dp[ind][currLen]!=null) return dp[ind][currLen];
        int ans = 0;
        if(currLen ==k){
            ans = k*currMax + solve(arr, ind+1, n, 1, arr[ind], k, dp);
        }else{
            int ans1 = solve(arr, ind+1, n, currLen+1, Math.max(currMax, arr[ind]), k, dp);
            int ans2 = solve(arr, ind+1, n, 1, arr[ind], k, dp) + currMax*currLen;
            ans = Math.max(ans1, ans2);
        }
        return dp[ind][currLen] = ans;
    }
}