package find_minimum_time_to_finish_all_jobs_1825;

import java.util.*;
class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        int start = 0;
        int end = (int)1e9;
        Arrays.sort(jobs);
        int ans = -1;
        while(start <= end){
            int mid = (start +end)/2;
            int arr[] = new int[k];
            Arrays.fill(arr, mid);
            if(check(jobs,jobs.length-1, k, mid, arr)){
                ans = mid;
                end = mid -1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }

    private boolean check(int jobs[], int i, int k, int val, int workerTime[]){
        if(i==-1) return true;

        for(int j=0;j<k;j++){
            if(workerTime[j] < jobs[i]) continue;
            workerTime[j] -= jobs[i];

            if(check(jobs, i-1, k, val, workerTime)){
                return true;
            }

            workerTime[j] += jobs[i];

            if(workerTime[j] == val) return false;
        }

        return false;
    }
}