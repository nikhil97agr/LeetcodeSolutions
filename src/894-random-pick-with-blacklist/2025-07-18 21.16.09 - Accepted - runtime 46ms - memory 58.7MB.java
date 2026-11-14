class Solution {
    int n;
    Set<Integer> set;
    int start;
    Queue<Integer> que;
    public Solution(int n, int[] blacklist) {
         set = new HashSet<>();
        for(int x : blacklist) set.add(x);
        que = new LinkedList();

        for(int i=0;i<n && que.size() < 20000;i++){
            if(!set.contains(i)) que.offer(i);
        }
    }
    
    public int pick() {
        int next = que.poll();

        que.offer(next);

        return next;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */