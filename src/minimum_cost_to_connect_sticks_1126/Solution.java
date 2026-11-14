package minimum_cost_to_connect_sticks_1126;

import java.util.*;
class Solution {
    public int connectSticks(int[] sticks) {
        
        if(sticks.length ==1) return 0;
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int x : sticks) que.offer(x);
        int ans= 0;

        while(que.size() > 1){
            int first = que.poll();
            int second = que.poll();
            ans += first + second;
            que.offer(first + second);
        }


        


        return ans;



    }
}