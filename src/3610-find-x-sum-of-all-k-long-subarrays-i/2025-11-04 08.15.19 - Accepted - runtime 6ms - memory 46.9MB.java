class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int ans [] = new int[n-k + 1];

        for(int i=0;i<n-k+1;i++){
            int cnt[] = new int[51];

            for(int j=i;(j-i+1)<=k;j++){
                cnt[nums[j]]++;
            }

            PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
                if(a[0] == b[0]) return b[1] - a[1];

                return b[0] - a[0];
            });

            for(int j=0;j<=50;j++){
                if(cnt[j] != 0){
                    que.offer(new int[]{cnt[j], j});
                }
            }
            int c = 0;
            int sum = 0;
            while(c <x && !que.isEmpty()){
                int y[] = que.poll();
                sum += y[1]*y[0];
                c++;
            }

            ans[i] = sum;
        }

        return ans;
    }
}