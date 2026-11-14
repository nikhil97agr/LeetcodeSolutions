class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(manager[i] != -1){
                adjList[manager[i]].add(i);
            }
        }
        
        Queue<int[]> que = new LinkedList<>();
        
        que.offer(new int[]{headID, informTime[headID]});
        while(!que.isEmpty()){
            int node[] = que.poll();
            if(informTime[node[0]] == 0){
                ans = Math.max(ans, node[1]);
                continue;
            }
            for(int child : adjList[node[0]]){
                que.offer(new int[]{child, node[1] + informTime[child]});
            }
        }
        
        return ans;
    }
}