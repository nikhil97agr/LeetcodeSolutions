class Solution {
    public int minimumCost(int n, int[][] connections) {
        int par[] = new int[n];
        for(int i=0;i<n;i++) par[i] = i;

        LinkedList<int[]> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        PriorityQueue<int[]> que= new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int c[] : connections)
        {
            int u = c[0] - 1;
            int v = c[1] - 1;
            int ct =c[2] ;

            adjList[u].add(new int[]{v, ct});
            adjList[v].add(new int[]{u, ct});

            que.offer(new int[]{u, v, ct});
        }  
        int ans = 0;
        while(!que.isEmpty()){
            int next[] = que.poll();
            int p1 = findPar(next[0], par);
            int p2 = findPar(next[1], par);
            if(p1 == p2) continue;

            par[p1] = p2;
            ans += next[2];
        }


        int p = findPar(0, par);
        for(int i=1;i<n;i++){
            int p1 = findPar(i, par);
            if(p1 !=p) return -1;
        }

        return ans;


    }

    private int findPar(int p, int par[]){
        if(par[p] == p) return p;

        return par[p] = findPar(par[p], par);
    }
}