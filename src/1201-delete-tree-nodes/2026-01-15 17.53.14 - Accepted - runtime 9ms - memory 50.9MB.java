class Solution {
    
    public int deleteTreeNodes(int n, int[] parent, int[] value) {
       LinkedList<Integer> adjList[] = new LinkedList[n];
       for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
       } 

       for(int i=1;i<n;i++){
        adjList[parent[i]].add(i);
       }
        int res[] = dfs(adjList, value, 0, -1);
        return n - res[1];
    }

    private int[] dfs(LinkedList<Integer> adjList[], int value[], int curr, int par){
        int sum = value[curr];
        int cnt = 0;
        int total = 1;
        for(int p : adjList[curr]){
            if(p==par) continue;

            int s[] = dfs(adjList, value, p, curr);
            total += s[2];
            cnt+= s[1];
            sum += s[0];
        }

        return new int[]{sum, sum ==0 ? total : cnt, total};
    }
}