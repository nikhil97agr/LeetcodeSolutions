class Solution {
    public int minScore(int n, int[][] roads) {
        LinkedList<int[]> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<int[]>();
        }
        for(int road[]: roads){
            adjList[road[0]-1].add(new int[]{road[1]-1, road[2]});
            adjList[road[1]-1].add(new int[]{road[0]-1, road[2]});
        }
        boolean visited[] = new boolean[n];
        int ans = Integer.MAX_VALUE;
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(0);
        while(!que.isEmpty()){
            int i = que.poll();
            visited[i] = true;
            Iterator<int[]> it = adjList[i].iterator();
            while(it.hasNext()){
                int x[] = it.next();
                if(!visited[x[0]]){
                    ans = Math.min(ans, x[1]);
                    que.add(x[0]);
                }
                
            }
        }
        return ans;
        
    }
    

}