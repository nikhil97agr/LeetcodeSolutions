class Solution {
    public int maxPartitionFactor(int[][] points) {
        int n = points.length;

        if(n==2) return 0;
        int ans = 0;
        int min = 0;
        int max = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                max = Math.max(max, dist(points[i], points[j]));
            }
        }

        while(min <=max){
            int mid = min + (max - min)/2;

            if(check(points, mid)){
                ans = mid;
                min = mid + 1;
            }else{
                max = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int points[][], int mid){
        int n = points.length;
        
        int color[] = new int[n];

        LinkedList<Integer> adjList[] = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(dist(points[i], points[j]) < mid){
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }

        for(int i=0;i<n;i++){
            if(color[i] ==0 ){
                if(!bfs(adjList, color, i)) return false;
            }
        }
        return true;
        
    }

    private boolean bfs(LinkedList<Integer> adjList[], int color[], int src){
        Queue<Integer> que = new LinkedList<>();

        que.offer(src);
        color[src] = 1;

        while(!que.isEmpty()){
            int u = que.poll();

            for(int child : adjList[u]){
                if(color[child] ==0){
                    color[child] = -color[u];
                    que.offer(child);
                }else if(color[child] == color[u]) return false;
            }
        }
        return true;
    }

    private int dist(int p1[], int p2[]){
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }
}