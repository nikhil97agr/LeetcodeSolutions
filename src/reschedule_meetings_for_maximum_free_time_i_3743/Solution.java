package reschedule_meetings_for_maximum_free_time_i_3743;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> list = new ArrayList<>();
        int n = endTime.length;
        list.add(startTime[0]);
        for(int i=0;i<n-1;i++){
            list.add(startTime[i+1] - endTime[i]);
        }
        list.add(eventTime - endTime[n-1]);
        int ans = 0;
        int sum = 0;
        k++;
        for(int i=0;i<k;i++){
            sum+=list.get(i);
        }
        ans = sum;
        int start = 0;
        for(int i=k;i<list.size();i++){
            sum  = sum - list.get(start) + list.get(i);
            start++;
            ans = Math.max(ans, sum);
        }
        
        return ans;
    }
}