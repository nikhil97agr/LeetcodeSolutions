package maximum_number_of_events_that_can_be_attended_ii_1851;

import java.util.*;
class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b)->{
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] -b[0];
        });

        int n = events.length;

        Integer dp[][] = new Integer[n][k+1];

        return solve(events, 0,k, dp, n);
    }

    private int solve(int events[][], int i, int k, Integer dp[][], int n){
        if(i >= n || k <=0) return 0;

        if(dp[i][k]!=null) return dp[i][k];

        int nextEvent = search(events, events[i][1]);

        return dp[i][k] = Math.max(
            events[i][2] + solve(events, nextEvent, k-1, dp,n),
            solve(events, i+1, k, dp,n)
        );
    }

    private int search(int events[][],int value){
        int start = 0;
        int end = events.length-1;
        int ans = events.length;

        while(start <= end){
            int mid = (start + end)/2;

            if(events[mid][0] > value){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }
}