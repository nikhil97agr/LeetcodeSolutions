package maximum_profit_in_job_scheduling_1352;

import java.util.*;
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;

        Job jobs[] = new Job[n];
        for(int i=0;i<n;i++){
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (j1, j2) -> j1.start - j2.start);
        Integer dp[] = new Integer[n];
        return solve(0, jobs, n, dp);
    }

    private int solve(int ind, Job jobs[], int n, Integer dp[]){
        if(ind==n) return 0;

        if(dp[ind]!=null) return dp[ind];

        int nextJob = findNextJob(ind+1, n-1, jobs, jobs[ind].end);
        if(nextJob == -1) nextJob = n;
        return dp[ind] = Math.max(solve(nextJob, jobs, n, dp)+ jobs[ind].profit, solve(ind+1, jobs, n, dp));
    }

    private int findNextJob(int start, int end, Job jobs[], int val){
        int ind = -1;
        while(start <= end){
            int mid = (start + end)/2;

            if(jobs[mid].start >= val){
                ind = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ind;
    }

    class Job{
        int start;
        int end;
        int profit;
        public Job(int start, int end, int profit){
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
}