package make_array_non_decreasing_or_non_increasing_1419;

import java.util.*;
class Solution {
    public int convertArray(int[] nums) {
        int a = 0;
        int b = 0;

        PriorityQueue<Integer> que= new PriorityQueue<>(Collections.reverseOrder());
        for(int x : nums){
            if(!que.isEmpty() && que.peek() > x){
                a += que.poll() - x;
                que.offer(x);
            }
            que.offer(x);
        }

        que = new PriorityQueue<>();
        for(int x : nums){
            if(!que.isEmpty() && que.peek() < x){
                b += x - que.poll();
                que.offer(x);
            }
            que.offer(x);
        }

        return Math.min(a,b);
    }
}