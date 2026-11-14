class MyCircularDeque {
    Node head;
    Node tail;
    int maxSize;
    int size;
    public MyCircularDeque(int k) {
        maxSize = k;
        size = 0;
        head = new Node(-1);
        tail = new Node(-1);
        tail.prev = head;
        head.next = tail;
    }
    
    public boolean insertFront(int value) {
        if(isFull()) return false;
        Node node = new Node(value);
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull()) return false;
        Node node = new Node(value);
        Node prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        prev.next = node;
        node.prev = prev;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty()) return false;
        Node node = head.next;
        node.next.prev = head;
        head.next = node.next;

        size--;
        return true;

    }
    
    public boolean deleteLast() {
        if(isEmpty()) return false;
        Node node = tail.prev;
        node.prev.next =tail;
        tail.prev = node.prev;
        size--;
        return true;
    }
    
    public int getFront() {
        if(isEmpty()) return -1;
        return head.next.val;
    }
    
    public int getRear() {
        if(isEmpty()) return -1;
        return tail.prev.val;
        
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return maxSize == size;
    }
}

class Node{
    int val;
    Node prev;
    Node next;
    public Node(int val){
        this.val =val;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */