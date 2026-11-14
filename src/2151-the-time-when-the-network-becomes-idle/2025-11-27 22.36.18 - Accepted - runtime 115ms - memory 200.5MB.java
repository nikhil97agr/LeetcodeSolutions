import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

class Solution {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        int time[] = new int[n];
        LinkedList<Integer>[] adjList = IntStream.range(0, n).boxed().map(x-> new LinkedList<Integer>()).toArray(LinkedList[]::new);

        for(int e[] : edges){
            adjList[e[0]].add(e[1]);
            adjList[e[1]].add(e[0]);
        }
        Arrays.fill(time, Integer.MAX_VALUE);
        time[0] = 0;
        PriorityQueue<int[]> que= new PriorityQueue<>((a,b) -> a[1] - b[1]);

        que.offer(new int[]{0,0});
        while(!que.isEmpty()){
            int next[] = que.poll();

            int u = next[0];
            int dist = next[1];

            for(int v : adjList[u]){
                if(time[v] > dist + 1){
                    time[v] = dist + 1;
                    que.offer(new int[]{v, dist + 1});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(patience[i] >= 2 * time[i]){
                ans = Math.max(ans, 2 * time[i]);
                continue;
            }
            int t = 2*time[i];
            int p = patience[i];

            int trips = t/p;

            if(t%p ==0){
                trips--;
            }

            ans = Math.max(ans, t + trips*p);


        }
        return ans+1;
    }
}