package minimum_time_to_complete_all_tasks_2657;

import java.util.*;
class Solution {
    public int findMinimumTime(int[][] tasks) {
        int n = tasks.length;
        Arrays.sort(tasks, (a,b) -> a[1] - b[1]);

        boolean slots[] = new boolean[2001];

        for(int t[] :tasks){
            int s= t[0];
            int e = t[1];
            int d = t[2];
            int i = s;
            for(;i<=e && d > 0;i++){
                if(slots[i]){
                    d--;
                }
            }

            i = e;
            while(d > 0 && i >= s){
                if(!slots[i]){
                    slots[i] = true;
                    d--;
                }
                i--;
            }
        }
        int ans = 0;
        for(boolean x : slots){
            if(x) ans++;
        }

        return ans;
    }
}