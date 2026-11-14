class Solution {
    List<Integer> adjList[];
    int time[][];
    int node[][];
    public int[] lastMarkedNodes(int[][] edges) {
        int n = edges.length + 1;
        adjList = new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }
        time = new int[n][2];
        node = new int[n][2];

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        dfs(0, -1);


        dfs2(0, -1);

        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = node[i][0];
        }

        return ans;
    }

    private void dfs2(int curr, int par){


        if(par != -1){
            int nextParentTime = 0;
            int nextParentNode = -1;
            if(node[par][0]  == node[curr][0]){
                nextParentTime = time[par][1] + 1;
                nextParentNode = node[par][1];
            }else{
                nextParentTime = time[par][0] + 1;
                nextParentNode = node[par][0];
            }

            if(nextParentTime > time[curr][0]){
                time[curr][1] = time[curr][0];
                node[curr][1] = node[curr][0];

                time[curr][0] = nextParentTime;
                node[curr][0] = nextParentNode;
            }else if(nextParentTime > time[curr][1]){
                time[curr][1] = nextParentTime;
                node[curr][1] = nextParentNode;
            }
        }


        for(int child : adjList[curr]){
            if(child == par) continue;
            dfs2(child, curr);
        }
    }

    private void dfs(int curr, int par){
        time[curr][0] = time[curr][1] = 0;
        node[curr][0] = node[curr][1] = curr;
        for(int child : adjList[curr]){
            if(child == par) continue;
            dfs(child, curr);
            int newTime = time[child][0] + 1;
            if(time[curr][0] < newTime){
                time[curr][1] = time[curr][0];
                node[curr][1] = node[curr][0];

                time[curr][0] = newTime;
                node[curr][0] = node[child][0];
            }else if(time[curr][1] < newTime){
                time[curr][1] = newTime;
                node[curr][1] = node[child][0];
            }
        }
    }
}