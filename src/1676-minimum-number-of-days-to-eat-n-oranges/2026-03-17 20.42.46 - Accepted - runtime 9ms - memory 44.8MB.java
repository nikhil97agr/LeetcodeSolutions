class Solution {
    public int minDays(int n) {
        
        var que= new PriorityQueue<int[]>((a,b) -> a[1] - b[1]);
        var vis = new HashSet<Integer>();
        que.offer(new int[]{n, 0});

        while(!que.isEmpty()){
            int next[] = que.poll();
            if(next[0]==1) return next[1] + 1;
            int m = next[0];
            if(vis.contains(m)) continue;
            vis.add(m);

            que.offer(new int[]{m/2, 1 + m%2 + next[1]});
            que.offer(new int[]{m/3, 1 + m%3 + next[1]});

        }

        return -1;


    }
}