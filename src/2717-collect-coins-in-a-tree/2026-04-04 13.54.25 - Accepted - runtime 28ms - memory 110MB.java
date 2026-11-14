import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {

    public int collectTheCoins(int[] coins, int[][] edges) {

        int n = coins.length;
        List<Integer> adjList[] = new ArrayList[n];
        int degree[] = new int[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];
            adjList[u].add(v);
            adjList[v].add(u);
            degree[u]++;
            degree[v]++;
        }

        var que = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1 && coins[i] == 0) {
                que.offer(i);
            }
        }

        while (!que.isEmpty()) {
            int next = que.poll();
            if (degree[next] == 0) {
                continue;
            }

            degree[next] = 0;
            for (int child : adjList[next]) {
                degree[child]--;
                if (degree[child] == 1 && coins[child] == 0) {
                    que.offer(child);
                }
            }
        }

        for (int dist = 0; dist < 2; dist++) {
            que = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (degree[i] == 1) {
                    que.offer(i);
                }
            }

            while (!que.isEmpty()) {
                int next = que.poll();

                if (degree[next] == 0) continue;
                degree[next] = 0;
                for(int child : adjList[next]){
                    if(degree[child] > 0){
                        degree[child]--;
                    }
                }
            }
        }
        int total = 0;
        for(int e[] : edges){
            int u = e[0], v = e[1];
            if(degree[u] > 0 && degree[v] > 0){
                total++;
            }
        }
        
        return total << 1;
    }
}