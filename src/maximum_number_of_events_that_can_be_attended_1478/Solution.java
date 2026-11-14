package maximum_number_of_events_that_can_be_attended_1478;

import java.util.*;
class Solution {
    public int maxEvents(int[][] events) {
        int maxTime = 0;
        for(int e[] : events){
            maxTime= Math.max(e[1], maxTime);
        }

        int ans =0;

        PriorityQueue<Integer> que = new PriorityQueue<>();
        Arrays.sort(events, (a,b) -> a[0] - b[0]);

        for(int i=1, j=0;i<=maxTime;i++){

            while(j < events.length && events[j][0] <= i){
                que.offer(events[j][1]);
                j++;
            }

            while(!que.isEmpty() && que.peek() < i){
                que.poll();
            }

            if(!que.isEmpty()){
                que.poll();
                ans++;
            }
        }

        return ans;
    }
}