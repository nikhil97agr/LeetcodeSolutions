class Solution {
    public int maxJumps(int[] arr, int d) {
        Integer dp[] = new Integer[arr.length];
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> a[0] - b[0]);
        int ans = 1;
        for(int i=0;i<arr.length;i++){
            que.offer( new int[]{arr[i], i});
        }
        for(int next[] : que){
            int i = next[1];
            ans = Math.max(ans, solve(i, arr, arr.length, d, dp));
        }

        return ans;
    }
    private int solve(int i, int arr[], int n, int d, Integer dp[]){
        if(dp[i] != null) return dp[i];
        int ans = 1;
        for(int x = 1;x <= d && i + x < n && arr[i+x] < arr[i];x++){
            ans = Math.max(ans, 1 + solve(i+x, arr, n, d, dp));
        }

        for(int x = 1;x<=d && i-x >=0 && arr[i-x] < arr[i];x++){
            ans = Math.max(ans, 1 + solve(i-x, arr, n, d, dp));
        }


        return dp[i] = ans;

    }
}