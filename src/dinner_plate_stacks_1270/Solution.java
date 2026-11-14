package dinner_plate_stacks_1270;

import java.util.*;
class DinnerPlates {
    List<Stack> list;
    PriorityQueue<Integer> que;
    int cap;
    PriorityQueue<Integer> pop;
    public DinnerPlates(int capacity) {
        list = new ArrayList<>();
        this.cap = capacity;
        que = new PriorityQueue<>();
        for(int i=0;i<=200000;i++){
            que.offer(i);
        }
        pop = new PriorityQueue<>(Collections.reverseOrder());

    }
    
    public void push(int val) {
        while(!pop.isEmpty() && list.get(pop.peek()).isEmpty()){
            pop.poll();
        }
        int next = que.peek();
        if(list.size() == next){
            list.add(new Stack<>());
        }
        if(list.get(next).isEmpty()){
            pop.offer(next);
        }
        list.get(next).push(val);
        if(list.get(next).size() == cap){
            que.poll();
        }

    }
    
    public int pop() {
        while(!pop.isEmpty() && list.get(pop.peek()).isEmpty()){
            pop.poll();
        }
        if(pop.isEmpty()){
            return -1;
        }
        int peek = pop.peek();
        Stack<Integer> stack = list.get(peek);
        if(stack.size() == cap){
            que.offer(peek);
        }
        return stack.pop();
    }
    
    public int popAtStack(int index) {
        if(index >= list.size()) return -1;
        if(list.get(index).isEmpty()) return -1;
        Stack<Integer> stack = list.get(index);

        if(stack.size() == cap){
            que.offer(index);
        }

        return stack.pop();
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */