class SmallestInfiniteSet {
    Set<Integer> set;
    PriorityQueue<Integer> smallest;
    int start = 1;
    public SmallestInfiniteSet() {
        set = new HashSet();
        smallest = new PriorityQueue<Integer>();        
    }
    
    public int popSmallest() {
        if(smallest.isEmpty() || smallest.peek()>start){
            return start++;
        }

        int x = smallest.poll();
        if(x==start){
            start++;
        }
        set.remove(x);
        return x;
    }
    
    public void addBack(int num) {
        if(!set.contains(num)){
            set.add(num);
            smallest.offer(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */