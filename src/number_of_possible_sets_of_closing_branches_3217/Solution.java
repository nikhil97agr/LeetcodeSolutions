package number_of_possible_sets_of_closing_branches_3217;

import java.util.*;
class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int ans = 0;
        int dist[][] = new int[n][n];
        
        for(int d[] : dist) Arrays.fill(d, Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            dist[i][i] =0;
        }
        for(int r[] : roads){
            int u = r[0];
            int v = r[1];
            int d = r[2];

            dist[u][v] = dist[v][u] = Math.min(dist[u][v], d);
        }

        for(int i=0;i<(1<<n);i++){
            int d = getDist(dist, n, i);


            if(d <= maxDistance) ans++;
        }

        return ans;

    }

    private int getDist(int adjList[][], int n, int mask){
        int dist[][] =new int[n][n];
        for(int d[] : dist){
            Arrays.fill(d, 1000000000);
        }
        for(int i=0;i<n;i++){
            dist[i][i] = 0;
            for(int j=0;j<n;j++){
                if(adjList[i][j] != Integer.MAX_VALUE){
                    dist[i][j] = dist[j][i] = adjList[i][j];
                }
            }
        }
        for(int i=0;i<n;i++){
            if((mask & (1<<i)) ==0) continue;
            for(int j=0;j<n;j++){
                if(i==j || (mask & (1<<j))==0) continue;
                for(int k=0;k<n;k++){
                    if(k==i || k==j || (mask & (1<<k))==0) continue;

                    dist[j][k] = Math.min(dist[j][k], dist[j][i] + dist[i][k]);
                }
            }
        }

        int max = 0;

        for(int i=0;i<n;i++){
            if((mask & (1<<i)) ==0){
                continue;
            }

            for(int j=0;j<n;j++){
                if((mask & (1 << j))==0){
                    continue;
                }

                max = Math.max(max, dist[i][j]);
            }
        }

        return max;
    }
}