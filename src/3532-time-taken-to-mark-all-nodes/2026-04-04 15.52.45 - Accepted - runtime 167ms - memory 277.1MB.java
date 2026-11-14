class Solution {
    List<Integer> adjList[];
    int dp[][];
    public int[] timeTaken(int[][] edges) {
        int n = edges.length + 1;
        dp = new int[n][2];
        adjList = new ArrayList[n];
        for(int i=0;i<n;i++) adjList[i] = new ArrayList<>();
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        dfs1(0, -1);
        dfs2(0, -1);


    int ans[] = new int[n];
    for(int i=0;i<n;i++) ans[i] = dp[i][0];

    return ans;

    }

    private int dfs1(int curr, int par){
        for(int child : adjList[curr]){
            if(child == par) continue;

            int next = child%2==0 ? 2 : 1;
            int time = dfs1(child, curr);

            int newTime = time + next;
            if(newTime > dp[curr][0]){
                dp[curr][1] = dp[curr][0];
                dp[curr][0] = newTime;
            }else if(newTime > dp[curr][1]){
                dp[curr][1] = newTime;
            }
        }

        return dp[curr][0];
    }

    private void dfs2(int curr, int par){
        if(par != -1){
            int parentToNode = curr%2==0 ? 2 : 1;
            int nodeToParent = par%2==0 ? 2 : 1;

            int parentMax = -1;
            if(dp[par][0] == dp[curr][0] + parentToNode){
                parentMax = dp[par][1] + nodeToParent;
            }else{
                parentMax = dp[par][0] + nodeToParent;

            }

            if(parentMax >= dp[curr][0]){
                dp[curr][1] = dp[curr][0];
                dp[curr][0] = parentMax;
            }else if(dp[curr][1] < parentMax){
                dp[curr][1] = parentMax;
            }
        }

        for(int child : adjList[curr]){
            if(child == par) continue;
            dfs2(child, curr);
        }
    }

}