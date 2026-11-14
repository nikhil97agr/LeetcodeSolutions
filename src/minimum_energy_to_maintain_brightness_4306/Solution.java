package minimum_energy_to_maintain_brightness_4306;

import java.util.*;
class Solution {
    public long minEnergy(int n, int brightness, int[][] intervals) {
        int en = (brightness + 2)/3;

        long total = 0;

        Arrays.sort(intervals, (a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            }

            return a[0] - b[0];
        });

        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<intervals.length;i++){
            int s = intervals[i][0];
            int e = intervals[i][1];

            if(s > end){
                total += (end - start + 1);
                start = s;
                end = e;
            }else{
                end = Math.max(end, e);
            }
        }

        total += (end - start + 1);


        return total * en;
    }
}