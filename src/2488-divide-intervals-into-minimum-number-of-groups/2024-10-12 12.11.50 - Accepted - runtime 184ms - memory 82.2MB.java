class Solution {
    public int minGroups(int[][] intervals) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        for(int i[] : intervals){
            que.offer(new int[]{i[0], 1});
            que.offer(new int[]{i[1], -1});
        }

        int ans = 0;
        int cnt = 0;
        while(!que.isEmpty()){
            int p[] = que.poll();
            if(p[1] == 1) cnt++;
            else cnt--;
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}