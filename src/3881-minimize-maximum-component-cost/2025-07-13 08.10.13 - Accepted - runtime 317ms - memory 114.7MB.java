import java.util.LinkedList;

class Solution {
    public int minCost(int n, int[][] edges, int k) {
        int ans= -1;
        LinkedList<Edge>[] adjList = new LinkedList[n];

        for(int i=0;i<n;i++) adjList[i] = new LinkedList<>();
        int start =0;
        int end = 0;
        for(int e[] : edges)
        {
            int u = e[0];
            int v = e[1];
            int w = e[2];
            end = Math.max(end, w);
            adjList[u].add(new Edge(v, w));
            adjList[v].add(new Edge(u, w));
        }

        while(start <= end){
            int mid = start + (end -start)/2;

            boolean vis[] = new boolean[n];
            int cnt = 0;
            for(int i=0;i<n;i++){
                if(!vis[i]){
                    dfs(i, vis, adjList, mid);
                    cnt++;
                }
            }

            if(cnt <= k){
                ans = mid;
                end  = mid-1;
            }else{
                start = mid+1;
            }
        }

        return ans;
    }

    private void dfs(int i, boolean[] vis, LinkedList<Edge>[] adjList, int w)
    {
        
        vis[i] = true;
        
        for(Edge e : adjList[i]){
            if(!vis[e.v] && e.w <= w){
                dfs(e.v, vis, adjList, w);
            }
        }
        
    }


    class Edge{
        int v;
        int w;

        public Edge(int v ,int w){
            this.v = v;
            this.w = w;
        }
    }
}