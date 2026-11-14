class Solution {
    public List<Integer> minimumFlips(int n, int[][] edges, String start, String target) {
        List<int[]> list[] = new ArrayList[n];
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++) list[i] =new ArrayList<>();
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            list[u].add(new int[]{v, i});
            list[v].add(new int[]{u, i});
        }
        int diff[] = new int[n];
        int sum =0;
        for(int i=0;i<n;i++){
            if(start.charAt(i) != target.charAt(i)){
                diff[i] = 1;
            }
            sum += diff[i];
        }

        if(sum%2 == 1){
            return List.of(-1);
        }

        boolean vis[] = new boolean[n];

        if(dfs(0, vis, list, result, diff) == 1){
            return List.of(-1);
        }

        Collections.sort(result);

        return result;
        
        
    }

    private int dfs(int curr, boolean vis[], List<int[]> list[], List<Integer> result, int diff[]){
        vis[curr] = true;


        int parity = diff[curr];


        for(int child[] : list[curr]){
            int v = child[0];
            int ind = child[1];
            if(!vis[v]){
                int recur = dfs(v, vis, list, result, diff);
                if(recur == 1){
                    result.add(ind);
                    parity ^= 1;
                }
            }
        }

        return parity;
    }
}