class KthLargest {
    PriorityQueue<Integer> que;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        que = new PriorityQueue<>();
        for(int x : nums){
            que.offer(x);
            if(que.size() > k) que.poll();
        }
    }
    
    public int add(int val) {
        que.offer(val);
        if(que.size() > k){
            que.poll();
        }
        return que.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */