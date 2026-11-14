package minimum_number_of_work_sessions_to_finish_the_tasks_2114;

class Solution {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;

        int finalState = (1<<n)-1;
        Integer dp[][] = new Integer[finalState+1][sessionTime+1];
        Integer ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(solve(1<<i, finalState, tasks, sessionTime, tasks[i], dp)+1, ans);
        }
        return ans;
    }

    private int solve(int currState, int finalState, int tasks[], int sessionTime, int currTime, Integer dp[][]){
        if(currState == finalState) return 0;

        if(dp[currState][currTime]!=null) return dp[currState][currTime];
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<tasks.length;i++){
            if((currState & (1<<i))==0){
                if(tasks[i] + currTime > sessionTime){
                    ans = Math.min(ans, 1 + solve(currState | (1<<i),finalState, tasks, sessionTime, tasks[i],dp));
                }else{
                    ans = Math.min(ans, solve(currState | (1<<i), finalState, tasks, sessionTime, currTime + tasks[i],dp));
                }
            }
        }
        return dp[currState][currTime] = ans;

    }
}