class Solution {
    public long[] minCost(int n, int[][] roads, int[] appleCost, int k) {
        LinkedList<int[]> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }
        for(int r[] : roads){
            int u = r[0]-1;
            int v = r[1]-1;
            int c = r[2];
            adjList[u].add(new int[]{v,c});
            adjList[v].add(new int[]{u, c});
        }
        long ans[] = new long[n];

        for(int i=0;i<n;i++){
            boolean vis[] = new boolean[n];
            long res = appleCost[i];
            PriorityQueue<Path> que= new PriorityQueue<>((a,b) -> Long.compare(a.cost, b.cost));
            que.offer(new Path(i, 0));
            vis[i] = true;
            long cost[] = new long[n];
            Arrays.fill(cost, Long.MAX_VALUE);
            cost[i] = 0;
            while(!que.isEmpty()){
                Path path = que.poll();
                int u = path.u;
                long c = path.cost;
                for(int child[] : adjList[u]){
                    long nc = c + child[1];
                    if(nc < cost[child[0]]){
                        res = Math.min(res, nc*(k+1) + appleCost[child[0]]);
                        cost[child[0]] = nc;
                        que.offer(new Path(child[0], nc));
                    }
                }
            }


            ans[i] = res;
        }

        return ans;
    }

    class Path{
        long cost;
        int u;

        public Path(int u, long cost){
            this.u = u;
            this.cost = cost;
        }
    }
}