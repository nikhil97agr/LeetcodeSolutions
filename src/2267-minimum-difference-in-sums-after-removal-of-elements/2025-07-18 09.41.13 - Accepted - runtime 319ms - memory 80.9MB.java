class Solution {
    public long minimumDifference(int[] nums) {
        int n = nums.length;
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        long left[] = new long[n+1];
        int arrSize = n/3;
        for(int i=1;i<=n;i++){
            sum += nums[i-1];
            que.offer(nums[i-1]);
            if(que.size() > arrSize) sum -= que.poll();

            left[i] = sum;
        }

        que= new PriorityQueue<>();
        sum = 0;
        long right[] = new long[n+1];

        for(int i=n;i>0;i--){
            sum += nums[i-1];
            que.offer(nums[i-1]);
            if(que.size() > arrSize) sum -= que.poll();
            right[i] = sum;
        }

        long ans =Long.MAX_VALUE;

        for(int i=arrSize;i<=arrSize*2;i++){
            ans = Math.min(ans, left[i] - right[i+1]);
        }

        
        return ans;
        
    }
}