class Solution {
    public int maxWidthRamp(int[] nums) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]) return b[1] - a[1];
            return b[0] - a[0];
        });
        for(int i=0;i<nums.length;i++){
            que.offer(new int[]{nums[i], i});
        }
        int ind = que.poll()[1];
        int ans = 0;

        while(!que.isEmpty()){
            int p[] = que.poll();
            if(p[1] < ind){
                ans = Math.max(ans, ind - p[1]);
            }else{
                ind = p[1];
            }
        }
        return ans;
    }
}