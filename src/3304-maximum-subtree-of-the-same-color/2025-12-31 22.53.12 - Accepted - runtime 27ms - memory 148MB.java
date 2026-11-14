class Solution {
    int ans = 1;
    public int maximumSubtreeSize(int[][] edges, int[] colors) {
        int n = colors.length;
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }

        for(int e[] : edges){
            int u = e[0], v= e[1];
            adjList[u].add(v);
            adjList[v].add(u);
        }

        dfs(0,-1,  adjList, colors);
        return ans;
    }

    private int dfs(int curr, int par, LinkedList<Integer> adjList[], int []colors){

        if(adjList[curr].size() == 1 && curr !=0) return 1;

        int size = 0;
        boolean flag = true;
        for(int c : adjList[curr]){
            if(c == par) continue;
            if(colors[c] == colors[curr]){
                int a = dfs(c, curr, adjList, colors);
                if(a == -1) return -1;
                size += a;

            }else{
                flag = false;
                 dfs(c, curr, adjList, colors);
            }
        }
        if(!flag) return -1 ;
        size++;
        ans = Math.max(ans, size);
        return size ;
    }
}