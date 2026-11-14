package minimum_processing_time_3151;

import java.util.*;
class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks, Collections.reverseOrder());
        int ans = 0;
        int i =0 ;
        int cnt = 0;
        for(int t : tasks){
            ans = Math.max(processorTime.get(i) + t, ans);
            cnt++;
            if(cnt == 4){
                i++;
                cnt = 0;
            }
        }

        return ans;
    }
}