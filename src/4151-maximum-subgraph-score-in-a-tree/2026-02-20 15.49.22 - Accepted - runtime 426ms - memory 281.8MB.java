class Solution {
    int good[];
    LinkedList<Integer> adjList[];
    int n;
    int ans[];
    Map<Integer, Integer> scores[];
    public int[] maxSubgraphScore(int n, int[][] edges, int[] good) {
        for(int i=0;i<n;i++){
            if(good[i] ==0) good[i] = -1;
        }
        ans = new int[n];
        scores = new HashMap[n];
        this.n = n;
        this.good = good;
        adjList = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
            scores[i] = new HashMap<>();
        }

        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }
        dfs(0, -1);
        dfs(0, -1, 0);
        return ans;
    }

    private void dfs(int curr, int par, int score){
        int total = scores[curr].values().stream().reduce(0, Integer::sum);
        ans[curr] = total + good[curr] + score;

        for(int child : adjList[curr]){
            if(child == par){
                continue;
            }

            dfs(child, curr, Math.max(total - scores[curr].get(child) + score + good[curr], 0));
        }
    }

    private int dfs(int curr, int par){
        int total =0;
        for(int child : adjList[curr]){
            if(child == par) continue;
            int score = dfs(child, curr);
            total+=score;
            scores[curr].put(child, score);
        }

        return Math.max(total + good[curr], 0);
    }
}