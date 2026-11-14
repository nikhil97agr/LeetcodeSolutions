class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int dist1[] = new int[n];
        int dist2[] = new int[n];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        boolean vis[] = new boolean[n];

        dfs(edges, node1, vis,  dist1, 0);
        Arrays.fill(vis, false);
        dfs(edges, node2, vis, dist2, 0);

        int ans = n;
        int ind = -1;

        for(int i=0;i<n;i++){
            int max = Math.max(dist1[i], dist2[i]);

            if(dist1[i] != -1 && dist2[i] != -1 && max < ans){
                ans = max;
                ind = i;
            }
        }

        return ind;
    }

    private void dfs(int edges[], int u, boolean vis[], int dist[], int curr){
        if(u== -1) return;
        if(vis[u]) return;
        vis[u] = true;

        dist[u] =curr;

        dfs(edges, edges[u], vis, dist, curr+1);
    }
}