package maximize_meeting_earnings_with_idle_gaps_4314;

import java.util.*;
class Solution {
    Long dp[][];
    public long maxEarnings(int[][] meetings) {
        Arrays.sort(meetings, (a,b) ->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });

    dp = new Long[meetings.length][2];

        return solve(0, 0, meetings.length, meetings);
    }

    private long solve(int start, int i, int n, int meetings[][]){
        if( i == n){
            return 0;

        }

        if(dp[i][start] != null) return dp[i][start];

        int nextInd = search(meetings, i + 1, n-1 , meetings[i][1]);

        long ans = Math.max(solve(start, i + 1, n, meetings), 0);


        long profit = meetings[i][0] + meetings[i][2];

        if(nextInd == -1){
            if(start == 0){
                return dp[i][start] = Math.max(ans, meetings[i][2]);
            }else{
                return dp[i][start] =Math.max(ans, profit);
            }
        }
        long a2 = solve(1, nextInd, n, meetings);

        if(a2 == 0){
            if(start == 0){
                return dp[i][start] =Math.max(ans, meetings[i][2]);
            }else{
                return dp[i][start] =Math.max(ans, meetings[i][2] + meetings[i][0]);
            }
        }

        if(start ==0){
            return  dp[i][start] =Math.max(ans, a2 + meetings[i][2] - meetings[i][1]);
        }

        return  dp[i][start] =Math.max(ans, a2 + meetings[i][2] + meetings[i][0] - meetings[i][1]);





    }

    private int search(int meetings[][], int start, int end, int val){
        int ind = -1;
        while( start <= end){
            int mid = (start + end)/2;

            if(meetings[mid][0] < val){
                start = mid + 1;
            }else{
                ind = mid;
                end = mid - 1;
            }
        }

        return ind;
    }

}