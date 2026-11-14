import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

class Solution {

    int n;

    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        this.n = n;
            LinkedList<int[]> adjList[];
    LinkedList<int[]> revAdjList[];
        adjList = new LinkedList[n];
        revAdjList = new LinkedList[n];
        for(int i=0;i<n;i++){
            adjList[i] = new LinkedList<>();
            revAdjList[i] = new LinkedList<>();
        }
        for(int e[] : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            adjList[u].add(new int[]{v, w});
            revAdjList[v].add(new int[]{u, w});
        }

        long dist1[] = shortestPath(adjList, src1);
        long dist2[] = shortestPath(adjList, src2);
        long dist3[] = shortestPath(revAdjList, dest);

        long ans = Long.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(dist1[i] !=-1 && dist2[i] != -1 && dist3[i] !=-1){
                ans = Math.min(ans, dist1[i] + dist2[i] + dist3[i]);
            }
        }

        return ans == Long.MAX_VALUE ? -1 : ans;
    }

    private long[] shortestPath(LinkedList<int[]> adjList[], int src){
        long dist[] = new long[n];
        Arrays.fill(dist, -1);

        PriorityQueue<long[]> que= new PriorityQueue<>((a,b) -> Long.compare(a[1], b[1]));
        que.offer(new long[]{src, 0});
        dist[src] = 0;
        boolean vis[] = new boolean[n];
        while(!que.isEmpty()){
            long next[] = que.poll();
            int u = (int)next[0];
            long d = next[1];

            if(dist[u] != -1 && dist[u] < d){
                continue;
            }

            if(dist[u] == d && vis[u]) continue;

            vis[u] = true;

            for(int child[] : adjList[u]){
                int v = child[0];
                int d1 = child[1];

                long nextDist = d + d1;
                if(dist[v] == nextDist && vis[v]) continue;
                if(dist[v] == -1 || dist[v] > nextDist){
                    que.offer(new long[]{v, nextDist});
                    dist[v] = nextDist;
                }
            }
        }

        return dist;
    }


}