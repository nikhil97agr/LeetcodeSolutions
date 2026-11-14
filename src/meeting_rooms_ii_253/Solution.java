package meeting_rooms_ii_253;

import java.util.*;
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0] - b[0]);

        PriorityQueue<Integer> que = new PriorityQueue<>();
        int ans = 0;
        for(int i[] : intervals){
            if(que.isEmpty()){
                que.add(i[1]);
                ans = Math.max(ans , 1);
                continue;
            }

            while(!que.isEmpty() && que.peek() <= i[0]){
                que.poll();
            }

            que.add(i[1]);
            ans = Math.max(ans, que.size());
        }
        return ans;
    }
}