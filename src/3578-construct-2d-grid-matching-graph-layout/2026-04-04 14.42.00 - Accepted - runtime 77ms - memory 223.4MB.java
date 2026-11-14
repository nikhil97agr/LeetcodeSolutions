class Solution {
     List<Integer> adjList[];
    public int[][] constructGridLayout(int n, int[][] edges) {
        adjList= new ArrayList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new ArrayList<>();
        }
        int degree[] = new int[n];
        int degrees[]= new int[5];
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
            degree[u]++;
            degree[v]++;
        }

        int num = -1;

        for(int i=0;i<n;i++){
            degrees[degree[i]]++;
            if(degree[i] == 1){

                int ans[][] = new int[1][n];
                ans[0][0]=i;
                var que = new LinkedList<Integer>();
                que.offer(i);
                int ind = 0;
                boolean vis[] = new boolean[n];

                vis[i] = true;
                while(!que.isEmpty()){
                    int next = que.poll();
                    ans[0][ind++] = next;
                    for(int child : adjList[next]){
                        if(!vis[child]){
                            que.offer(child);
                            vis[child] = true;
                        }
                    }
                }

                return ans;

            }

            if(degree[i] == 2){
                num = i;
            }
        }
        List<Integer> first = new ArrayList<>();
        first.add(num);
        boolean vis[] = new boolean[n];
        vis[num] = true;
        int prev = 0;

        while(true){
            int curr = first.get(prev);
            int next = findNext(curr, degree, vis);
            first.add(next);
            degree[curr]--;
            degree[next]--;
            vis[next] = true;
            if(degree[next] == 1){
                break;
            }

            prev++;


        }

        int col = first.size();
        int row = n / col;
        int ans[][] = new int[row][col];
        for(int i=0;i<col;i++){
            ans[0][i] = first.get(i);
        }

        for(int i=1;i<row;i++){
            for(int j=0;j<col;j++){
                int curr = ans[i-1][j];
                int next = findNext(curr, degree, vis);

                ans[i][j] = next;
                degree[next]--;
                degree[curr]--;
                vis[next] = true;
            }
        }


return ans;
        

    }

    private int findNext(int curr, int degree[], boolean []vis){
        int node = Integer.MAX_VALUE;
        int minDegree = Integer.MAX_VALUE;
        for(int child : adjList[curr]){
            if(!vis[child] && degree[child] < minDegree){
                minDegree = degree[child];
                node = child;
            }
        }

        return node;
    }
}