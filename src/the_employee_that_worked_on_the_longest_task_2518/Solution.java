package the_employee_that_worked_on_the_longest_task_2518;

import java.util.*;
class Solution {
    public int hardestWorker(int n, int[][] logs) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int prev = 0;
        int counters[] = new int[n];
        counters[logs[0][0]] = logs[0][1];
        
        for(int i=1;i<logs.length;i++){
            int log[] = logs[i];
            counters[log[0]] = Math.max(log[1] - logs[i-1][1], counters[log[0]]);
        }
        int max = Integer.MIN_VALUE;
        int id = -1;
        for(int i=0;i<n;i++){
            if(counters[i]>max){
                id = i;
                max = counters[i];
            }
        }
        return id;
    }
}