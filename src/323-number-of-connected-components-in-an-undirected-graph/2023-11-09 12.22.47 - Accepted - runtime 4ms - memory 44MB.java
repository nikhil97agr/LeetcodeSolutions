class Solution {
    public int countComponents(int n, int[][] edges) {
        LinkedList<Integer> list[] = new LinkedList[n];
        for(int i=0;i<n;i++) list[i] = new LinkedList<>();

        for(int e[] : edges){
            list[e[0]].add(e[1]);
            list[e[1]].add(e[0]);
        }

        int ans = 0;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans++;
                dfs(i, visited, list);
            }
        }

        return ans;
    }

    private void dfs(int i, boolean visited[], LinkedList<Integer> adjList[]){
        visited[i] = true;

        Iterator<Integer> it = adjList[i].iterator();
        while(it.hasNext()){
            int x = it.next();

            if(!visited[x]){
                dfs(x, visited, adjList);
            }
        }
    }
}