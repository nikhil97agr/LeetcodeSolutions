class Solution {
    List<Edge> adjList[];
    public long minMoves(int[] balance) {
        var n = balance.length;
        long sum = 0;
        for(int x : balance) sum += x;
        if(sum < 0) return -1;

        adjList = new ArrayList[n + 2];
        for(int i=0;i< n + 2;i++){
            adjList[i] = new ArrayList<>();
        }

        int s = n;
        int t = n + 1;
        long max = Long.MAX_VALUE/3;
        for(int i=0;i<n;i++){
            if(balance[i] > 0){
                add(s, i, balance[i], 0);
            }else if(balance[i]  < 0){
                add(i, t, -balance[i], 0);
            }

            add(i, (i+1)%n, max, 1);
            add(i, (i - 1 + n)%n, max, 1);
        }

        long ans = 0;

        while(true){
            long dist[] = new long[n + 2];
            Arrays.fill(dist, max);
            int[] pNode = new int[n + 2];
            int pEdge[] = new int[n + 2];
            boolean[] inQueue = new boolean[n + 2];

            var que = new LinkedList<Integer>();
            dist[s] = 0;
            que.add(s);
            inQueue[s] = true;

            while(!que.isEmpty()){
                int u = que.poll();
                inQueue[u] = false;

                for(int i=0;i< adjList[u].size();i++){
                    var edge = adjList[u].get(i);

                    if(edge.cap > 0 && dist[edge.to] > dist[u] + edge.cost){
                        dist[edge.to] = dist[u] +edge.cost;
                        pNode[edge.to] = u;
                        pEdge[edge.to] = i;
                        if(!inQueue[edge.to]){
                            que.add(edge.to);
                            inQueue[edge.to] = true;
                        }
                    }
                }
            }

            if(dist[t] == max) break;
            
            long mm = max;
            int curr = t;

            while(curr != s){
                int p = pNode[curr];
                int ind = pEdge[curr];
                mm = Math.min(mm, adjList[p].get(ind).cap);
                curr = p;
            }

            curr = t;
            while(curr != s){
                int p = pNode[curr];
                int ind = pEdge[curr];
                Edge e = adjList[p].get(ind);
                e.cap -= mm;
                adjList[curr].get(e.rev).cap += mm;
                ans += mm * e.cost;
                curr = p;
            }

        }

        return ans;
    }

    public void add(int u, int v, long cap, long cost){
        adjList[u].add(new Edge(v, adjList[v].size(), cap, cost));
        adjList[v].add(new Edge(u, adjList[u].size()-1, 0, -cost));
    }

    class Edge{
        int to;
        int rev;
        long cap;
        long cost;

        public Edge(int to, int rev, long cap, long cost){
            this.to = to;
            this.rev = rev;
            this.cap = cap;
            this.cost = cost;
        }
    }
}