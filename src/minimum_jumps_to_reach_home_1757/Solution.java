package minimum_jumps_to_reach_home_1757;

import java.util.*;
class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> set = new HashSet<>();
        for(int y : forbidden) set.add(y);

        Queue<int[]> que = new LinkedList<>();
        boolean vis[][] =new boolean[40000][2];
        int ans = 0;
        vis[0][0] = true;
        que.offer(new int[]{0, 0});
        while(!que.isEmpty()){
            int size= que.size();
            while(size -- > 0){
                int next[] = que.poll();

                if(next[0] == x) return ans;

                int f = next[0] + a;

                if(f <40000 && !set.contains(f) && !vis[f][0]){
                    vis[f][0] = true;
                    que.offer(new int[]{f, 0});
                }

                int back= next[0] - b;
                if(next[1] != 1 && back >=0 && back < 40000 && !set.contains(back) && !vis[back][1]){
                    vis[back][1] = true;
                    que.offer(new int[]{back, 1});
                }
            }
            ans++;
        }

        return -1;
    }
}