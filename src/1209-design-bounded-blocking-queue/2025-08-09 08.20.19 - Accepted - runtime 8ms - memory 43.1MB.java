class BoundedBlockingQueue {
    Deque<Integer> que;
    int cap;

    public BoundedBlockingQueue(int capacity) {
        que = new LinkedList<>();
        cap = capacity;
    }
    
    public synchronized void enqueue(int element) throws InterruptedException {
        while(que.size() == cap){
            wait();
        }

        que.offerLast(element);
        notifyAll();
    }
    
    public synchronized int dequeue() throws InterruptedException {
        while(que.isEmpty()){
            wait();
        }
        int val = que.pollFirst();
        notifyAll();
        return val;
    }
    
    public int size() {
        return que.size();
    }
}