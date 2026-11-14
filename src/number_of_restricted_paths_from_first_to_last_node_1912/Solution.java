package number_of_restricted_paths_from_first_to_last_node_1912;

import java.util.*;
class Solution {
    public int countRestrictedPaths(int n, int[][] edges) {
      int dist[] = new int[n+1];
      Arrays.fill(dist, Integer.MAX_VALUE);
      LinkedList<int[]> adjList[] = new LinkedList[n+1];
      for(int i=0;i<=n;i++){
          adjList[i] = new LinkedList<>();
      }

      for(int e[] : edges){
          int src = e[0];
          int dest = e[1];
          int weight = e[2];
          adjList[src].add(new int[]{dest, weight});
          adjList[dest].add(new int[]{src, weight});
      }
      dist[n] =  0;
      PriorityQueue<int[]> que = new PriorityQueue<>((a,b)-> a[1] - b[1]);
      que.add(new int[]{n, 0});
      while(!que.isEmpty()){
        int node[] = que.poll();

        int d = node[1];
        int num = node[0];

        for(int x[] : adjList[num]){
            if( d+x[1] < dist[x[0]]){
                dist[x[0]] = d+x[1];
                que.add(new int[]{x[0], d+x[1]});
            }
        }

      }
       long mod = (long)1e9+7;
       long dp[] = new long[n+1];
       Arrays.fill(dp, -1);
       dp[1] =1;
        dfs(dist, dp, adjList, n, mod);
        return (int)(dp[n]%mod);
    }

    private long dfs(int dist[], long dp[], LinkedList<int[]> adjList[], int curr, long mod){
        if(curr ==1)return 1;
        if(dp[curr]!=-1) return dp[curr];

        long ans = 0;
        for(int []x : adjList[curr]){
            if(dist[curr] < dist[x[0]]){
                ans += dfs(dist, dp, adjList, x[0], mod)%mod;
                ans%=mod;
            }
        }

        dp[curr] = ans;

        return dp[curr];
    }
}