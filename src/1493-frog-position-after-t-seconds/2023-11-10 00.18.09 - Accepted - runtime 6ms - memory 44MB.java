class Solution {
    class Jump{
        int node;
        double prob;
        int time;

        public Jump(int node, double prob, int time){
            this.node = node;
            this.prob = prob;
            this.time = time;
        }

        public String toString(){
            return (""+node+":"+prob+":"+time);
        }
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        Set<Integer> adjList[] = new HashSet[n+1];
        for(int i=0;i<=n;i++){
            adjList[i] = new HashSet<>();

        }
        boolean visited[] = new boolean[n+1];
        for(int e[] : edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        Queue<Jump> que = new LinkedList<>();
        que.add(new Jump(1, 1d,0));
        visited[1]  = true;
        while(!que.isEmpty()){
            Jump jump = que.poll();
            int childCount = adjList[jump.node].size();
            double probChild = 1d/childCount;
            if(jump.node==target ){
                if(jump.time>t) return 0d;
                if(jump.time ==t || adjList[jump.node].size()==0) return jump.prob;
                
            }

            for(int child : adjList[jump.node]){
                if(visited[child]) continue;
                visited[child] = true;
                adjList[child].remove(jump.node);
                que.add(new Jump(child, jump.prob*probChild, jump.time+1));
            }
        }

        return 0;
    }
}