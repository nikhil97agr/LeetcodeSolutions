class RecentCounter {
    PriorityQueue<Integer> list;
    public RecentCounter() {
        list = new PriorityQueue<>();
    }
    
    public int ping(int t) {
        list.add(t);
        while(list.peek()<(t-3000)){
            list.poll();
        }
        return list.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */