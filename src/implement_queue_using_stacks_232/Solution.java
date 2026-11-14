package implement_queue_using_stacks_232;

import java.util.*;
class MyQueue {
    Stack<Integer> que;
    public MyQueue() {
        que = new Stack<Integer>();
    }
    
    public void push(int x) {
        Stack<Integer> temp = new Stack<>();
        while(!que.isEmpty()){
            temp.push(que.pop());
        }
        que.push(x);
        while(!temp.isEmpty()){
            que.push(temp.pop());
        }
    }
    
    public int pop() {
        return que.pop();
    }
    
    public int peek() {
        return que.peek();
    }
    
    public boolean empty() {
        return que.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */