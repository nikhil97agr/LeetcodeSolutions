package maximum_vacation_days_568;

import java.util.*;
class Solution {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k =days[0].length;
        int dp[][] = new int[n][k];
        for(int d [] : dp){
            Arrays.fill(d, -1);
        }
        dp[0][0] = days[0][0];

        for(int i=1;i<n;i++){
            if(flights[0][i] == 1) dp[i][0] = days[i][0];
        }

        for(int week = 1;week < k;week++){
            for(int destination = 0;destination < n; destination ++){
                for(int src =0;src <n; src++){
                    if(dp[src][week-1] != -1 && (flights[src][destination] == 1 || src == destination)){
                        dp[destination][week] = Math.max(dp[destination][week], dp[src][week-1] + days[destination][week]);
                    }
                }
            }
        }


        return Arrays.stream(dp).mapToInt(x -> x[k-1]).max().getAsInt();
    }
}