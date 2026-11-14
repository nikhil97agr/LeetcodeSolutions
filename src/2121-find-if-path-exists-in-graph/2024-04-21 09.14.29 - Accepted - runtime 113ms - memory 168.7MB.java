class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean visited[] = new boolean[n];
        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] =new LinkedList<Integer>();

        }

        for(int edge[] : edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        return check(source, destination, adjList, n, visited);
    }

    private boolean check(int start, int end, LinkedList<Integer> adjList[], int n, boolean[] visited){
        if(start==end){
            return true;
        }
        visited[start] = true;

        Iterator<Integer> it = adjList[start].iterator();
        while(it.hasNext()){
            int x = it.next();
            if(!visited[x]){
                if(check(x, end, adjList, n, visited)){
                    return true;
                }
            }
        }

        return false;

    }
}