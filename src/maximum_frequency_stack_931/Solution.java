package maximum_frequency_stack_931;

import java.util.*;
class FreqStack {
    PriorityQueue<int[]> pq;
    HashMap<Integer, Integer> map;
    int index;
    public FreqStack() {
        pq = new PriorityQueue<int[]>((a,b)->{
            if(a[0]!=b[0])
            {
                return b[0] - a[0];
            }
            return b[1] - a[1];
        });
            map = new HashMap();
        index = 0;
    }
    
    public void push(int x) {
        if(map.containsKey(x)){
            map.put(x, map.get(x)+1);
        }else{
            map.put(x,1);
        }
        
        pq.offer(new int[]{map.get(x), index, x});
        index++;
        
    }
    
    public int pop() {
        int value = pq.poll()[2];
        map.put(value, map.get(value)-1);
        return value;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */