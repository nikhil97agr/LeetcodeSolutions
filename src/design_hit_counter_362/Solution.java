package design_hit_counter_362;

import java.util.*;
class HitCounter {
    Queue<Integer> que;
    public HitCounter() {
        que= new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        int start = timestamp - 300;
        while(!que.isEmpty() && que.peek() <= start) que.poll();
        que.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        int start= timestamp - 300;
        
        while(!que.isEmpty() && que.peek() <= start) que.poll();

        return que.size();
        
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */