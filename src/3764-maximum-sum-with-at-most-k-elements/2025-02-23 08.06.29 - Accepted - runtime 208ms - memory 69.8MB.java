class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        long ans = 0;
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for(int i=0;i<grid.length;i++){
            for(int x : grid[i]){
                que.offer(new int[]{x, i});
            }
        }
        int cnt = 0;
        while(!que.isEmpty() && cnt < k){
            int n[] = que.poll();
            if(limits[n[1]]> 0){
                 ans += n[0];
                limits[n[1]]--;
                cnt++;
            } 
        }
        return ans;
        
    }
}