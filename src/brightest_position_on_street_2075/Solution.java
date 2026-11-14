package brightest_position_on_street_2075;

import java.util.*;
class Solution {
    public int brightestPosition(int[][] lights) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->{
            if(a[0] == b[0]){
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        for(int l [] : lights){
            que.offer(new int[]{l[0] - l[1], 1});
            que.offer(new int[]{l[0] + l[1], -1});
        }

        int ans = Integer.MAX_VALUE;
        int cnt = 0;
        int max = 0;
        while(!que.isEmpty()){
            int next[] = que.poll();
            if(next[1] == 1){
                cnt++;
            }

            if(cnt > max){
                ans = next[0];
                max = cnt;
            }
            if(next[1] == -1){
                cnt--;
            }
        }

        return ans;
    }
}