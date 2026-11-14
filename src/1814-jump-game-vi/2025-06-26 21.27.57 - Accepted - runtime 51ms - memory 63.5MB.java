class Solution {
    public int maxResult(int[] nums, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> b[0] - a[0]);

        int n = nums.length;
        que.offer(new int[]{nums[n-1], n-1});
        for(int i=n-2;i>=0;i--){
            while(!que.isEmpty() && que.peek()[1] > i+k){
                que.poll();
            }

            int max[] = que.peek();
            que.offer(new int[]{max[0] + nums[i], i});
        }
        while(!que.isEmpty()){
            int max[] = que.poll();
            if(max[1] ==0) return max[0];
        }

        return -1;
    }
}