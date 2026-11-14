package count_days_without_meetings_3430;

import java.util.*;
class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (m1, m2) -> {
            return m1[0] - m2[0];
        });
        int ans = 0;
        int nextStart = 1;
        for(int m[] : meetings){
            if(m[0] > nextStart){
                ans += (m[0] - nextStart);
                nextStart = m[1] + 1;
            }else{
                if(m[1] >= nextStart){
                    nextStart = m[1] + 1;
                }
            }
            
        }
        if(days >= nextStart){
            ans += (days - nextStart) +1;
        }
        return ans;
    }
}