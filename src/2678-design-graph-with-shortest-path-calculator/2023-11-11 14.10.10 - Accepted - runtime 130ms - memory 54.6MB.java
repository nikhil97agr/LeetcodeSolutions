class Graph {
    LinkedList<int[]> adjList[];
    int n;
    public Graph(int n, int[][] edges) {
        adjList = new LinkedList[n];
        this.n = n;
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }
        for(int x[] : edges){
            adjList[x[0]].add(new int[]{x[1], x[2]});
        }
    }
    
    public void addEdge(int[] edge) {
        adjList[edge[0]].add(new int[]{edge[1], edge[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> a[1] - b[1]);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        que.add(new int[]{node1, 0});
        while(!que.isEmpty()){
            int curr[] = que.poll();
            int node = curr[0];
            int d = curr[1];

            if(node == node2) return d;
            if(dist[curr[0]]!=Integer.MAX_VALUE) continue;

            dist[node] = d;

            for(int x[] : adjList[node]){
                if(d + x[1] < dist[x[0]]){
                    que.offer(new int[]{x[0], d+x[1]});
                }
            }
        }
        return -1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */