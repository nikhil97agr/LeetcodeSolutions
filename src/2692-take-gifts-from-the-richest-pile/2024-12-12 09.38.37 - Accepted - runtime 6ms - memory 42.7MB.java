class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Long> que = new PriorityQueue<>(Collections.reverseOrder());
        for(int x : gifts){
            que.add((long)x);
        }
        for(int i=0;i<k;i++){
            long x = que.poll();
            x = (long)Math.sqrt(x);
            que.add(x);
        }
        
        long count = 0;
        while(!que.isEmpty()){
            count += que.poll();
        }
        return count;
    }
}