class Solution {
    public int maxSubarrayLength(int[] nums) {
        PriorityQueue<Integer> que= new PriorityQueue<>((a,b)->{
            return nums[b] - nums[a];
        });
        int ans = 0;
        for(int i=0;i<nums.length;i++) que.offer(i);
        int n= nums.length;
        for(int i=n-1;i>=0;i--){
            while(!que.isEmpty() && nums[que.peek()] > nums[i]){
                if(que.peek() >= i){
                    que.poll();
                    continue;
                }
                ans = Math.max(ans, i - que.poll()+1);
            }
        }

        return ans;
    }


}