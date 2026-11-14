package count_the_number_of_houses_at_a_certain_distance_i_3271;

import java.util.*;
class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int result[] = new int[n];
        x--;
        y--;
        for(int i=0;i<n;i++){
            int dist[] = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            PriorityQueue<int[]>que = new PriorityQueue<>((a,b) -> a[0] - b[0]);

            que.offer(new int[]{0, i});

            while(!que.isEmpty()){
                int curr[] = que.poll();
                int d = curr[0];
                int node = curr[1];
                if(d!=0){
                    result[d-1]++;
                }
                if(node == x){
                    if(d + 1 < dist[y] ){
                        dist[y] = d + 1;
                        que.offer(new int[]{d + 1, y});
                    }
                }else if(node == y){
                    if(d + 1 < dist[x]){
                        dist[x] = d + 1;
                        que.offer(new int[]{d + 1, x});
                    }
                }

                int back = node - 1;
                if(back >=0 && d + 1 < dist[back]){
                    dist[back] = d + 1;
                    que.offer(new int[]{d + 1, back});
                }

                int forw = node + 1;
                if(forw < n && d + 1 < dist[forw]){
                    dist[forw] = d + 1;
                    que.offer(new int[]{d + 1, forw});
                }
            }
        }

        return result;
    }
}