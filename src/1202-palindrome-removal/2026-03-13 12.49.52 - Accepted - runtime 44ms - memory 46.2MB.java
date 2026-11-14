class Solution {
    Integer dp[][];
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        dp = new Integer[n][n];
        return solve(0, arr.length -1,arr);
    }
    private int solve(int start, int end, int arr[]){
        if(start > end) return 0;
        if(dp[start][end] !=null) return dp[start][end];
        int ans = Math.min(solve(start, end-1, arr), solve(start+1, end, arr)) + 1;
        if( end > 0 && arr[end-1] == arr[end]){
            ans = Math.min(ans, solve(start, end-2, arr) +1);
        }
        if(start < arr.length-1 && arr[start] == arr[start+1]){
            ans = Math.min(ans, solve(start+2, end, arr)+1);
        }

        for(int i=start;i<end-1;i++){
            if(arr[i]==arr[end]){
                ans = Math.min(ans, solve(start, i-1, arr) + solve( i+1, end- 1, arr));
            }
        }

        return dp[start][end] = ans;
        
    }
}