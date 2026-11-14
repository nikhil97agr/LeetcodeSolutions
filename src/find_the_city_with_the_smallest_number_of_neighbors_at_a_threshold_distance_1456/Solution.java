package find_the_city_with_the_smallest_number_of_neighbors_at_a_threshold_distance_1456;

import java.util.*;
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int dis[][] = new int[n][n];
        for(int r[] : dis ) Arrays.fill(r, 100000);
        for(int e[]  : edges){
            dis[e[0]][e[1]] = e[2];
            dis[e[1]][e[0]] = e[2];
        }
        for(int i=0;i<n;i++) dis[i][i] = 0;
    
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                }
            }
        }

        int ans = 0;
        int ind =n+1;

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(dis[i][j] <= distanceThreshold && dis[i][j]!=0){
                    cnt++;

                }
            }
            if(cnt <= ind){
                ind = cnt;
                ans = i;
            }
        }
        return ans;


    }
}