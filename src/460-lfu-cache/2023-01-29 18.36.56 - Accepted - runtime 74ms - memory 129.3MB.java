class LFUCache {
    class Node{
        int key;
        int val;
        int freq;
        Node next;
        Node prev;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            freq = 1;
        }
    }

    class DLL{
        Node head;
        Node tail;
        public DLL(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
        }

        public void addNode(Node node){
            Node temp = head.next;
            head.next = node;
            node.next = temp;
            node.prev = head;
            temp.prev = node;
        }

        public Node removeNode(){
            Node temp = tail.prev;
            tail.prev = temp.prev;
            tail.prev.next = tail;
            return temp;
        }

        public void removeNode(Node node){
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
        }

        public boolean isEmpty(){
            return head.next==tail;
        }
    }

    Map<Integer, DLL> freq;
    Map<Integer, Node> cache;
    int capacity;
    public LFUCache(int capacity) {
       this.capacity = capacity;
       freq = new TreeMap<Integer, DLL>();
        cache = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)){
            return -1;
        }

        Node node = cache.get(key);
        freq.get(node.freq).removeNode(node);
        if(freq.get(node.freq).isEmpty()){
            freq.remove(node.freq);
        }
        node.freq++;
        if(!freq.containsKey(node.freq)){
            freq.put(node.freq, new DLL());
        }

        freq.get(node.freq).addNode(node);

        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity==0){
            return;
        }
        Node node = cache.get(key);
        if(node==null){
            node = new Node(key, value);

            if(cache.size()==capacity){
                int minFreq = getMinFrequency();
                Node temp = freq.get(minFreq).removeNode();
                
                if(freq.get(minFreq).isEmpty()){
                    freq.remove(minFreq);
                }
                cache.remove(temp.key);
            }
            cache.put(key ,node);
            if(freq.get(1)==null){
                freq.put(1, new DLL());
            }

            freq.get(1).addNode(node);

            return;
        }


        freq.get(node.freq).removeNode(node);
        if(freq.get(node.freq).isEmpty()){
            freq.remove(node.freq);
        }
        node.freq++;

        if(freq.get(node.freq)==null){
            freq.put(node.freq, new DLL());
        }

        freq.get(node.freq).addNode(node);

        node.val = value;
    }

    private int getMinFrequency(){
        return (new ArrayList<Integer>(freq.keySet())).get(0);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */