class Solution {
    public int shortestPathWithHops(int n, int[][] edges, int s, int d, int k) {
        List<int[]>[] list = new ArrayList[n];
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
        }
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w= e[2];
            list[u].add(new int[]{v, w});
            list[v].add(new int[]{u, w});
        }

        PriorityQueue<Path> que = new PriorityQueue<>((a,b) ->{
            return a.dist - b.dist;
        });

        que.offer(new Path(s, 0, 0));

        int vis[][] =new int[n][k+1];
        for(int x[] : vis){
            Arrays.fill(x, Integer.MAX_VALUE);
        }
        Arrays.fill(vis[s], 0);
        int res = Integer.MAX_VALUE;
        while(!que.isEmpty()){
            Path path = que.poll();

            int u = path.u;
            int cnt = path.cnt;
            int dist = path.dist;

            if( u== d){
                res= Math.min(res, dist);
                continue;
            }

            for(int[] child : list[u]){
                int v =child[0];
                int w = child[1];
                if(vis[v][cnt] > dist + w){
                    que.offer(new Path(v, cnt, dist + w));
                    vis[v][cnt] = dist + w;
                }

                if(cnt !=k && vis[v][cnt +1] > dist){
                    que.offer(new Path(v, cnt+1, dist));
                    vis[v][cnt+1] = dist;
                }
            }

        }

        return res;



    }

    class Path{
        int u;
        int cnt;
        int dist;
        public Path(int u, int cnt, int dist){
            this.u = u;
            this.cnt = cnt;
            this.dist = dist;
        }
    }
}