class Solution {
    public long maxSpending(int[][] values) {
        long ans = 0;
        PriorityQueue<int[]> que= new PriorityQueue<>((a,b) ->{
            return a[0] - b[0];
        });
        long day = 1;

        int n = values.length;
        int m = values[0].length;

        for(int i=0;i<n;i++){
            que.offer(new int[]{values[i][m-1], i, m-1});
        }

        while(!que.isEmpty()){
            int next[] = que.poll();

            ans += day * next[0];
            day++;
            if(next[2] ==0) continue;
            que.offer(new int[]{values[next[1]][next[2]-1], next[1], next[2] - 1});
        }

        return ans;
    }
}