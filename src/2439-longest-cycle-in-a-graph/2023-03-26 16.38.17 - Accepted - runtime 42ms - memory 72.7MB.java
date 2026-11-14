class Solution {
    int ans = -1;
    public int longestCycle(int[] edges) {
        int dist[] = new int[edges.length];
        boolean visited[] = new boolean[edges.length];
        boolean extra[] = new boolean[edges.length];
        for(int i=0;i<edges.length;i++){
            if(!visited[i]){
                dfs(i, visited, extra, dist,  edges,0);
            }
        }

        return ans;
    }

    public void dfs(int node, boolean[] visited, boolean[] extra, int dist[], int[] edges, int distance){
        if(node!=-1){
            if(!visited[node]){
                visited[node] = true;
                extra[node] = true;
                dist[node] = distance;
                dfs(edges[node], visited, extra, dist, edges, distance+1);
            }
            else if(extra[node]){
                ans = Math.max(ans, distance- dist[node]);
            }

            extra[node] = false;
        }
    }
}