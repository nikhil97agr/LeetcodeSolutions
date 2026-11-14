class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : nums) que.offer(x);

        while(k-- > 0){
            int x = que.poll();

            ans += x;

            que.offer((x + 2 )/3);
        }
        return ans;
    }
}