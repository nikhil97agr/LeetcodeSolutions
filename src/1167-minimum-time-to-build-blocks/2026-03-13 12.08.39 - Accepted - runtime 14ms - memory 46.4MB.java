class Solution {
    public int minBuildTime(int[] blocks, int split) {
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for(int b : blocks) que.offer(b);
        while(que.size() > 1){
            int first = que.poll();
            int second = que.poll();
            que.offer(second + split);
        }

        return que.poll();
    }
}