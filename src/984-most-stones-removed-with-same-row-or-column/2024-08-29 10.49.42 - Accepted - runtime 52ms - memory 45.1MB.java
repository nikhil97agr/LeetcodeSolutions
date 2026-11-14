class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        if(n<=1){
            return 0;
        }
        LinkedList<Integer> adjList[] = new LinkedList[n];

        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<Integer>();
        }
        for(int i=0;i<n;i++){
            int u[] = stones[i];
            for(int j=0;j<n;j++){
                int v[] = stones[j];
                if(i==j){
                    continue;
                }
                if(u[0]==v[0] || u[1] == v[1]){
                    adjList[i].add(j);
                }
            }
        }
        int count = 0;
        boolean visited[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]){
                continue;
            }
            count++;
            removeStones(visited, n, adjList, i);
        }
        return n - count;
    }

    public void removeStones(boolean visited[], int n, LinkedList adjList[], int i){
         
         visited[i] = true;

         Iterator<Integer> it = adjList[i].iterator();
         while(it.hasNext()){
             int x= it.next();
             if(!visited[x]){
                 removeStones(visited,n , adjList, x);
             }
         }
    }
}