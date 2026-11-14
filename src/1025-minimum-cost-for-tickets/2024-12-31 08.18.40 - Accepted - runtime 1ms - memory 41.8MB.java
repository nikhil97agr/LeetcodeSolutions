class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int maxDay = days[n-1];
        int dp[] = new int[maxDay+1];
        boolean isTravel[] = new boolean[maxDay+1];
        for(int x : days){
            isTravel[x] = true;
        }
        for(int i=1;i<=maxDay;i++){
            if(!isTravel[i]){
                dp[i] = dp[i-1];
                continue;
            }
            
            dp[i] = costs[0] + dp[i-1];
            dp[i] = Math.min(costs[1] + dp[Math.max(i-7,0)], dp[i]);
            dp[i] = Math.min(costs[2] + dp[Math.max(i-30,0)], dp[i]);
        }
        
        return dp[maxDay];
    }
    
 
}