class Solution {
    public int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int ans = 0;
        que.offer(a);
        que.offer(b);
        que.offer(c);
        while(que.size() >1){
            a = que.poll();
            b = que.poll();
            a--;
            b--;
            ans++;
            if(a!=0) que.offer(a);
            if(b !=0 ) que.offer(b);
        }

        return ans;






    }
}