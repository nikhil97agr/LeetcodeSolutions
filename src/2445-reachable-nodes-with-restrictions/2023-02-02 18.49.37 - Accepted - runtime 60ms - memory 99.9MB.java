class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<Integer>();
        }
        for(int edge[] : edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        

        int count = 0;
        boolean visited[] = new boolean[n];
        for(int i : restricted){
            visited[i] = true;
        }
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(0);
        while(!que.isEmpty()){
            int x = que.poll();
            if(visited[x]){
                continue;
            }
            visited[x] = true;
            count++;
            Iterator<Integer> it = adjList[x].iterator();
            while(it.hasNext()){
                int y = it.next();
                if(!visited[y]){
                    que.add(y);
                }
            }

        }

        return count;
    }
}