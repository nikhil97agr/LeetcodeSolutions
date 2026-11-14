class Solution {
    public long elevatorRequests(int n, int start, int[][] requests) {
        int m = requests.length;

        int finalState = 1 << m;

        long dp[][] = new long[finalState][m];
        long max = Long.MAX_VALUE / 2;
        for(long d[] : dp){
            Arrays.fill(d, max);
        }

        for(int i=0;i < m;i++){
            long d = Math.abs(requests[i][1] - start);
            dp[1 << i][i] = Math.max(d, requests[i][0]);
        }

        for(int mask = 1; mask < finalState;mask++){
            for(int i = 0;i<m;i++){
                if((mask & (1 << i)) ==0 || dp[mask][i] >= max){
                    continue;
                }

                long curr = dp[mask][i];
                int floor = requests[i][1];


                for(int next = 0;next < m;next++){
                    if((mask & (1 << next)) !=0){
                        continue;
                    }

                    int nextFloor = requests[next][1];
                    int nextTime = requests[next][0];
                    long travel = Math.abs(floor - nextFloor);
                    long time = Math.max(nextTime, curr + travel);

                    int newMask = mask | (1 << next);
                    if(time < dp[newMask][next]){
                        dp[newMask][next] = time;
                    }
                }
            }
        }

        long ans = max;

        for(int i=0;i < m;i++){
            ans= Math.min(ans, dp[finalState - 1][i]);
        }

        return ans;
    }
}