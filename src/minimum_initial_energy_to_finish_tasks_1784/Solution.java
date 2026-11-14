package minimum_initial_energy_to_finish_tasks_1784;

import java.util.*;
import java.util.Arrays;

class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (t1, t2)->{
            int l1 = t1[1] - t1[0];
            int l2 = t2[1] - t2[0];

            int e1 = t1[1] + (Math.max(0, t2[1] - l1));
            int e2 = t2[1] + (Math.max(0, t1[1] - l2));

            return e1 - e2;
        });
        
        int current = 0;
        int energy = 0;
        for(int t[]: tasks){
            if(current >= t[1]){
                current -= t[0];
            }else{
                int extra = t[1] -current;
                energy += extra;
                current += extra;
                current -= t[0];
            }
        }
        
        return energy;
    }
}