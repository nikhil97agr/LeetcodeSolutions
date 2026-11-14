package find_time_required_to_eliminate_bacterial_strains_3814;

import java.util.*;
class Solution {
    public long minEliminationTime(int[] timeReq, int splitTime) {
        PriorityQueue<Long> que = new PriorityQueue<>();
        for(int x : timeReq) que.offer(1l*x);
        while(que.size() > 1){
            long first =que.poll();
            long second = que.poll();

            que.offer(second + splitTime);
        }


        return que.poll();

    }
}