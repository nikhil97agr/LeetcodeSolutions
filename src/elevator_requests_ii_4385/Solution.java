package elevator_requests_ii_4385;

import java.util.*;
class Solution {
    public long elevatorRequests(int n, int start, int[] requests) {
        int l = requests.length;

        int transform[] = new int[ l + 1];
        for(int i=0;i<l;i++){
            transform[i]= requests[i];
        }

        transform[l] = start;

        Arrays.sort(transform);
        int ind = 0;
        for(int i=0;i<= l;i++){
            if(transform[i] == start){
                ind = i;
                break;
            }
        }

        long dp[][][] = new long[l + 1][l+ 1][2];
        long max= Long.MAX_VALUE/2;

        for(long a[][] : dp){
            for(long b[] : a){
                b[0] = b[1] = max;
            }
        }

        dp[ind][ind][0] = dp[ind][ind][1] = 0;


        for(int i=1;i<=l;i++){
            for(int j=0;j + i - 1<=l;j++){
                int k = j + i - 1;
                int rem = l - (i - 1);

                if(dp[j][k][0] < max){
                    if( j > 0){
                        long dist = 1l * transform[j] - transform[j-1];
                        dp[j-1][k][0] = Math.min(dp[j-1][k][0], dp[j][k][0] + dist * rem);
                    }

                    if( k < l){
                        long dist = 1l * transform[k + 1] - transform[j];
                        dp[j][k+1][1] = Math.min(dp[j][k+1][1], dp[j][k][0] + dist * rem);
                    }
                }

                if(dp[j][k][1] < max){
                    if( j > 0){
                        long dist = 1l * transform[k] - transform[j - 1];
                        dp[j-1][k][0] = Math.min(dp[j-1][k][0], dp[j][k][1] + dist * rem);
                    }

                    if( k < l){
                        long dist = 1l * transform[k + 1] - transform[k];
                        dp[j][k+1][1] = Math.min(dp[j][k+1][1], dp[j][k][1] + dist * rem);
                    }
                }
            }
        }

        return Math.min(dp[0][l][0], dp[0][l][1]);
    }
}