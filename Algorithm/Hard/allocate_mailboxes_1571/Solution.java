package allocate_mailboxes_1571;

import java.util.*;
class Solution {
    Integer dp[][];
    public int minDistance(int[] houses, int k) {
        int n = houses.length;
        Arrays.sort(houses);
        dp = new Integer[n][k+1];

        return solve(houses, k, n, 0, 0);
    }

    private int solve(int arr[], int k, int n, int i, int houses){
        if(i==n){
            if(houses == k) return 0;
            return Integer.MAX_VALUE;
        }

        if(houses == k) return Integer.MAX_VALUE;
        if(dp[i][houses] !=null) return dp[i][houses];
        int ans = Integer.MAX_VALUE;
        for(int j=i;j<n;j++){
            int mid = arr[(j+i)/2];

            int total = 0;
            for(int l=i;l<=j;l++){
                total += Math.abs(mid - arr[l]);
            }

            int res = solve(arr, k, n, j+1, houses + 1);

            if(res != Integer.MAX_VALUE){
                ans = Math.min(ans, res + total);
            }
        }

        return dp[i][houses] = ans;
    }
}