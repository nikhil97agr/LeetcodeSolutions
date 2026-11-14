package minimum_time_to_finish_the_race_2295;

import java.util.*;
class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        int n = tires.length;
        long max = 1_000_000_0000l;
        long continuousTime[][] = new long[n][20];
        for(long x[] : continuousTime){
            Arrays.fill(x, max);
        }
        for(var i=0;i<n;i++){
            continuousTime[i][1] = tires[i][0];
                for(int j=2;j<20;j++){
                    if(continuousTime[i][j-1] * tires[i][1] >= max){
                        break;
                    }

                    continuousTime[i][j] = continuousTime[i][j-1] * tires[i][1];
                }

                for(int j=2;j<20;j++){
                    if(continuousTime[i][j] + continuousTime[i][j-1] >= max) break;
                    continuousTime[i][j] += continuousTime[i][j-1];
                }
        }

        long dp[] = new long[numLaps + 1];

        Arrays.fill(dp, max);

        for(int lap = 1;lap <= numLaps;lap++){
            if( lap < 20){
                for(int i=0;i<n;i++){
                    dp[lap] = Math.min(dp[lap], continuousTime[i][lap]);
                }
            }
            // Because according to constraint and formula, more than 18 laps will surely not give optimal answer and change tire would be better
            for(int j=lap - 1;j>0 && j >= lap -18;j--){
                dp[lap] = Math.min(dp[lap], dp[j] + changeTime + dp[lap - j]);
            }
        }

        return (int)dp[numLaps];
    }
}