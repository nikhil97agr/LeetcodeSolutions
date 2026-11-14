class Solution {
    public int absDifference(int[] nums, int k) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for(int x : nums){
            min.offer(x);
            max.offer(x);

            if(min.size() > k){
                min.poll();
                max.poll();
            }
        }

        int res = 0;
        while(!min.isEmpty()) res += min.poll();
        while(!max.isEmpty()) res -= max.poll();

        return Math.abs(res);
    }
}