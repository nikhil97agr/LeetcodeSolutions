class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];

        for(int i=0;i<n;i++){
            if(color[i]==0 && !dfs(graph, color, i, 1)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int graph[][], int colors[], int i, int clr){
        if(colors[i]!=0){
            return colors[i] == clr;
        }

        colors[i] = clr;

        for(int x : graph[i]){
            if(!dfs(graph, colors, x, -clr)){
                return false;
            }
        }
        return true;
    }
}