package keys_and_rooms_871;

import java.util.*;
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean visited[] = new boolean[n];

        Queue<Integer> que = new LinkedList<>();
        int cnt = 0;
        que.offer(0);
        cnt = 1;
        visited[0] = true;
        while(!que.isEmpty()){
            int x = que.poll();

            for(int node : rooms.get(x)){
                if(!visited[node]){
                    que.offer(node);
                    visited[node] = true;
                    cnt++;
                }
            }   
        }

        return cnt == n;
    }
}