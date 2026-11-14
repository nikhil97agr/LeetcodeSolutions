class MyCircularQueue {
    int arr[];
    int size;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        this.size = k;
        rear = front = -1;
        arr = new int[size];
    }
    
    public boolean enQueue(int value) {
        if(front==-1){
            front = rear = 0;
            arr[front] = value;
            return true;
        }
        
        if((front==0&&rear==size-1)||(rear == front-1)){
            return false;
        }
        
        if(rear==size-1){
            rear = 0;
            arr[rear] = value;
            
        }else{
            arr[++rear] = value;
        }
        return true;        
        
    }
    
    public boolean deQueue() {
        if(rear==-1){
            return false;
        }
        
        if(rear==front){
            rear= -1;
            front = -1;
            return true;
        }
        if(front==size-1){
        front = 0;
        }else{
            front++;
        }
        return true;
    }
    
    public int Front() {
        if(front==-1){
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if(rear==-1){
            return -1;
        }
        return arr[rear];
        
    }
    
    public boolean isEmpty() {
        if(rear==-1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if((front==0&&rear==size-1)||(front-1==rear)){
            return true;
        }
        return false;
        
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */