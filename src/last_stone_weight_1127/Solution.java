package last_stone_weight_1127;

import java.util.*;
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : stones){
            que.add(x);
        }

        while(que.size()>1){
            int x = que.poll();
            int y = que.poll();
            if(x!=y){
                que.add(x-y);
            }
        }

        return que.isEmpty() ? 0 : que.poll();
    }
}